package com.tencent.mm.plugin.qqmail;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
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
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public final class b
  extends c
{
  public static final String NiO;
  private HttpClient client = null;
  private HttpRequestBase httpRequest = null;
  private HttpResponse httpResponse = null;
  private boolean isCancelled = false;
  private int result = 0;
  
  static
  {
    AppMethodBeat.i(266926);
    NiO = "weixin/" + d.nsC + "/0x" + Integer.toHexString(d.Yxh);
    AppMethodBeat.o(266926);
  }
  
  private static void a(c.e parame, HttpRequestBase paramHttpRequestBase)
  {
    AppMethodBeat.i(266922);
    if (parame.params == null)
    {
      AppMethodBeat.o(266922);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parame.params.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new BasicNameValuePair(str, (String)parame.params.get(str)));
    }
    ((HttpPost)paramHttpRequestBase).setEntity(new UrlEncodedFormEntity(localArrayList, "utf-8"));
    AppMethodBeat.o(266922);
  }
  
  public final c.f a(String paramString1, String paramString2, c.e parame, c.d paramd)
  {
    AppMethodBeat.i(266931);
    Log.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + parame);
    for (;;)
    {
      Object localObject2;
      try
      {
        this.isCancelled = false;
        this.client = new DefaultHttpClient();
        if (parame.method != 0) {
          continue;
        }
        this.httpRequest = new HttpGet(d(paramString1, paramString2, parame.params));
        this.httpRequest.addHeader("User-Agent", NiO);
        System.setProperty("http.keepAlive", "false");
        this.httpRequest.addHeader("Accept-Charset", "utf-8");
        this.httpRequest.addHeader("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
        this.httpRequest.addHeader("Content-Type", "text/html");
        this.httpRequest.addHeader("Cookie", getCookie(parame.cookie));
        if (parame.method == 1) {
          a(parame, this.httpRequest);
        }
        this.httpResponse = this.client.execute(this.httpRequest);
        this.result = this.httpResponse.getStatusLine().getStatusCode();
        localObject1 = null;
        localObject2 = null;
        localHttpEntity = null;
        if (this.httpResponse.getFirstHeader("set-cookie") == null) {
          break label1248;
        }
        paramString1 = this.httpResponse.getFirstHeader("set-cookie").getValue();
        if (this.httpResponse.getFirstHeader("Content-Encoding") != null) {
          localObject1 = this.httpResponse.getFirstHeader("Content-Encoding").getValue();
        }
        if (this.httpResponse.getFirstHeader("Content-Disposition") != null) {
          localObject2 = this.httpResponse.getFirstHeader("Content-Disposition").getValue();
        }
        if ((localObject2 == null) || (!((String)localObject2).contains("attachment;")) || (!paramString2.contains("download"))) {
          continue;
        }
        i = 1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1 = new c.f(-10001, null, "unsupported ecoding");
        return paramString1;
        i = 0;
        continue;
        localHttpEntity = this.httpResponse.getEntity();
        localHttpEntity.getContentLength();
        localObject2 = localHttpEntity.getContent();
        if ((localObject1 == null) || (!((String)localObject1).contains("gzip"))) {
          break label1241;
        }
        localObject1 = new GZIPInputStream((InputStream)localObject2);
        if (i == 0) {
          continue;
        }
        localObject2 = NiP;
        StringBuilder localStringBuilder = new StringBuilder();
        if (parame.params.get("default_attach_name") != null) {
          continue;
        }
        parame = Long.valueOf(System.currentTimeMillis());
        parame = y.e(new u((String)localObject2, parame), true);
        localObject2 = new byte[1024];
        if (this.isCancelled) {
          continue;
        }
        j = ((InputStream)localObject1).read((byte[])localObject2);
        if (j <= 0) {
          continue;
        }
        parame.write((byte[])localObject2, 0, j);
        parame.flush();
        paramd.gDS();
        continue;
      }
      catch (UnknownHostException paramString1)
      {
        paramString1 = new c.f(-10005, null, "unknow host");
        return paramString1;
        parame = (Serializable)parame.params.get("default_attach_name");
        continue;
        parame = new ByteArrayOutputStream();
        continue;
      }
      catch (ClientProtocolException paramString1)
      {
        HttpEntity localHttpEntity;
        paramString1 = new c.f(-10002, null, "client protocol error");
        return paramString1;
        if (!this.isCancelled) {
          continue;
        }
        parame.flush();
        parame.close();
        return null;
        int j = this.result;
        paramd = parseCookie(paramString1);
        if (i == 0) {
          continue;
        }
        paramString1 = "";
        paramString1 = new c.f(j, paramd, paramString1);
        parame.flush();
        parame.close();
        localHttpEntity.consumeContent();
        if (localObject1 == null) {
          continue;
        }
        ((InputStream)localObject1).close();
        Log.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + paramString1);
        return paramString1;
        paramString1 = new String(((ByteArrayOutputStream)parame).toByteArray());
        continue;
      }
      catch (IllegalStateException paramString1)
      {
        paramString1 = new c.f(-10003, null, "illegal state");
        return paramString1;
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1 = new c.f(-10004, null, "output file not found");
        return paramString1;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.HttpClientUtil", paramString1, "http unavailable", new Object[0]);
        if (this.result != 0) {
          continue;
        }
        i = 503;
        paramString1 = new c.f(i, null, null);
        return paramString1;
        i = this.result;
        continue;
      }
      catch (OutOfMemoryError paramString1)
      {
        Log.printErrStackTrace("MicroMsg.HttpClientUtil", paramString1, "http unavailable", new Object[0]);
        if (this.result != 0) {
          continue;
        }
        int i = 503;
        paramString1 = new c.f(i, null, null);
        return paramString1;
        i = this.result;
        continue;
      }
      finally
      {
        if (this.client == null) {
          continue;
        }
        this.client.getConnectionManager().shutdown();
        AppMethodBeat.o(266931);
      }
      if (i == 0)
      {
        localObject2 = localHttpEntity;
        if (this.httpResponse.getFirstHeader("Content-Length") != null) {
          localObject2 = this.httpResponse.getFirstHeader("Content-Length").getValue();
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (Util.getInt((String)localObject2, 0) > 5242880L))
        {
          paramString1 = new c.f(-10000, null, "mail content to large");
          if (this.client != null) {
            this.client.getConnectionManager().shutdown();
          }
          AppMethodBeat.o(266931);
          return paramString1;
          this.httpRequest = new HttpPost(d(paramString1, paramString2, null));
          continue;
        }
      }
      label1241:
      Object localObject1 = localObject2;
      continue;
      label1248:
      paramString1 = null;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(266934);
    Log.d("MicroMsg.HttpClientUtil", "cancel conection.");
    this.isCancelled = true;
    if ((this.httpRequest != null) && (!this.httpRequest.isAborted())) {
      this.httpRequest.abort();
    }
    if (this.client != null) {
      this.client.getConnectionManager().shutdown();
    }
    AppMethodBeat.o(266934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b
 * JD-Core Version:    0.7.0.1
 */