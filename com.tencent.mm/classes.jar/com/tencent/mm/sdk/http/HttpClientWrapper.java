package com.tencent.mm.sdk.http;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.t;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientWrapper
  extends HttpWrapperBase
{
  public static final String DEF_ATTACH_NAME = "default_attach_name";
  private static final int MAX_CONTENT_LENGTH = 5242880;
  public static final int RET_CODE_CONTENT_TOO_LARGE = -10000;
  public static final int RET_CODE_FILE_NOT_FOUND = -10004;
  public static final int RET_CODE_ILLEGAL_STATE = -10003;
  public static final int RET_CODE_PROTOCOL = -10002;
  public static final int RET_CODE_UNKOWN_HOST = -10005;
  public static final int RET_CODE_UNSUPPORT_ENCODE = -10001;
  public static final int RET_NETWORK_UNAVAILABLE = -10006;
  public static final int RET_SDCARD_UNAVAILABLE = -10007;
  private static final String TAG = "MicroMsg.HttpClientWrapper";
  private HttpClient client = null;
  private HttpRequestBase httpRequest = null;
  private HttpResponse httpResponse = null;
  private boolean isCancelled = false;
  private int result = 0;
  
  public HttpClientWrapper(HttpClient paramHttpClient)
  {
    this.client = paramHttpClient;
  }
  
  private void writePostStringContent(HttpWrapperBase.Request paramRequest, HttpRequestBase paramHttpRequestBase)
  {
    AppMethodBeat.i(230276);
    if (paramRequest.params == null)
    {
      AppMethodBeat.o(230276);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramRequest.params.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new BasicNameValuePair(str, (String)paramRequest.params.get(str)));
    }
    ((HttpPost)paramHttpRequestBase).setEntity(new UrlEncodedFormEntity(localArrayList, "utf-8"));
    AppMethodBeat.o(230276);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(230275);
    Log.d("MicroMsg.HttpClientWrapper", "cancel conection.");
    this.isCancelled = true;
    if ((this.httpRequest != null) && (!this.httpRequest.isAborted())) {
      this.httpRequest.abort();
    }
    if (this.client != null) {
      this.client.getConnectionManager().shutdown();
    }
    AppMethodBeat.o(230275);
  }
  
  public void send(HttpWrapperBase.Request paramRequest, HttpWrapperBase.Response paramResponse)
  {
    Object localObject1 = null;
    int i = 503;
    AppMethodBeat.i(230274);
    Log.d("MicroMsg.HttpClientWrapper", "request: %s", new Object[] { paramRequest });
    for (;;)
    {
      try
      {
        this.isCancelled = false;
        if (paramRequest.method == 0)
        {
          this.httpRequest = new HttpGet(paramRequest.getUrl());
          this.httpRequest.addHeader("User-Agent", "weixin/android");
          this.httpRequest.addHeader("Host", paramRequest.host);
          System.setProperty("http.keepAlive", "false");
          this.httpRequest.addHeader("Accept-Charset", "utf-8");
          this.httpRequest.addHeader("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
          this.httpRequest.addHeader("Content-Type", "text/html");
          this.httpRequest.addHeader("Cookie", getCookie(paramRequest.cookie));
          if (paramRequest.method == 1) {
            writePostStringContent(paramRequest, this.httpRequest);
          }
          this.httpResponse = this.client.execute(this.httpRequest);
          this.result = this.httpResponse.getStatusLine().getStatusCode();
          if (this.httpResponse.getFirstHeader("set-cookie") == null) {
            break label993;
          }
          paramRequest = this.httpResponse.getFirstHeader("set-cookie").getValue();
          if (this.httpResponse.getFirstHeader("Content-Encoding") != null) {
            localObject1 = this.httpResponse.getFirstHeader("Content-Encoding").getValue();
          }
          if (this.httpResponse.getFirstHeader("Content-Disposition") != null) {
            this.httpResponse.getFirstHeader("Content-Disposition").getValue();
          }
          localHttpEntity = this.httpResponse.getEntity();
          l = localHttpEntity.getContentLength();
          Object localObject2 = localHttpEntity.getContent();
          if ((localObject1 == null) || (!((String)localObject1).contains("gzip"))) {
            break label990;
          }
          localObject2 = new GZIPInputStream((InputStream)localObject2);
          if ((paramResponse.attachment == null) || (Util.isNullOrNil(paramResponse.attachment.filePath))) {
            continue;
          }
          localObject1 = s.d(new o(paramResponse.attachment.filePath), true);
          byte[] arrayOfByte = new byte[1024];
          if (this.isCancelled) {
            continue;
          }
          int j = ((InputStream)localObject2).read(arrayOfByte);
          if (j <= 0) {
            continue;
          }
          ((OutputStream)localObject1).write(arrayOfByte, 0, j);
          ((OutputStream)localObject1).flush();
          continue;
        }
      }
      catch (UnsupportedEncodingException paramRequest)
      {
        paramResponse.status = -10001;
        paramResponse.content = "unsupported ecoding";
        return;
        this.httpRequest = new HttpPost(paramRequest.getUrl());
        continue;
      }
      catch (UnknownHostException paramRequest)
      {
        paramResponse.status = -10005;
        paramResponse.content = "unknow host";
        return;
        localObject1 = new ByteArrayOutputStream();
        continue;
      }
      catch (ClientProtocolException paramRequest)
      {
        HttpEntity localHttpEntity;
        long l;
        paramResponse.status = -10002;
        paramResponse.content = "client protocol error";
        return;
        if (this.isCancelled)
        {
          ((OutputStream)localObject1).flush();
          ((OutputStream)localObject1).close();
          return;
        }
        paramResponse.status = this.result;
        paramResponse.cookie = parseCookie(paramRequest);
        if ((localObject1 instanceof t))
        {
          paramRequest = "";
          paramResponse.content = paramRequest;
          paramResponse.contentLength = l;
          ((OutputStream)localObject1).flush();
          ((OutputStream)localObject1).close();
          localHttpEntity.consumeContent();
          Log.d("MicroMsg.HttpClientWrapper", "response:%s", new Object[] { paramResponse });
          return;
        }
        paramRequest = new String(((ByteArrayOutputStream)localObject1).toByteArray());
        continue;
      }
      catch (IllegalStateException paramRequest)
      {
        paramResponse.status = -10003;
        paramResponse.content = "illegal state";
        return;
      }
      catch (FileNotFoundException paramRequest)
      {
        paramResponse.status = -10004;
        paramResponse.content = "output file not found";
        return;
      }
      catch (Exception paramRequest)
      {
        Log.printErrStackTrace("MicroMsg.HttpClientWrapper", paramRequest, "http unavailable", new Object[0]);
        if (this.result == 0)
        {
          paramResponse.status = i;
          return;
        }
        i = this.result;
        continue;
      }
      catch (OutOfMemoryError paramRequest)
      {
        Log.printErrStackTrace("MicroMsg.HttpClientWrapper", paramRequest, "http unavailable", new Object[0]);
        if (this.result == 0)
        {
          i = 503;
          paramResponse.status = i;
          return;
        }
        i = this.result;
        continue;
      }
      finally
      {
        if (this.client != null) {
          this.client.getConnectionManager().shutdown();
        }
        AppMethodBeat.o(230274);
      }
      AppMethodBeat.o(230274);
      return;
      label990:
      continue;
      label993:
      paramRequest = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.http.HttpClientWrapper
 * JD-Core Version:    0.7.0.1
 */