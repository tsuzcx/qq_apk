package com.tencent.mm.plugin.qqmail.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

public final class m
  extends n
{
  private boolean isCancelled = false;
  private HttpClient pIW = null;
  private HttpRequestBase pIX = null;
  private HttpResponse pIY = null;
  private int result = 0;
  
  private static void a(n.b paramb, HttpRequestBase paramHttpRequestBase)
  {
    AppMethodBeat.i(67957);
    if (paramb.pJb == null)
    {
      AppMethodBeat.o(67957);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramb.pJb.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new BasicNameValuePair(str, (String)paramb.pJb.get(str)));
    }
    ((HttpPost)paramHttpRequestBase).setEntity(new UrlEncodedFormEntity(localArrayList, "utf-8"));
    AppMethodBeat.o(67957);
  }
  
  public final n.c a(String paramString1, String paramString2, n.b paramb, n.a parama)
  {
    AppMethodBeat.i(67955);
    ab.d("MicroMsg.URLConnectionUtil", "uri=" + paramString2 + ", " + paramb);
    for (;;)
    {
      Object localObject2;
      try
      {
        this.isCancelled = false;
        this.pIW = new DefaultHttpClient();
        if (paramb.pJa != 0) {
          continue;
        }
        if (paramb.pJa != 0) {
          continue;
        }
        localObject1 = paramb.pJb;
        this.pIX = new HttpGet(f(paramString1, paramString2, (Map)localObject1));
        this.pIX.addHeader("User-Agent", userAgent);
        this.pIX.addHeader("Host", host);
        System.setProperty("http.keepAlive", "false");
        this.pIX.addHeader("Accept-Charset", "utf-8");
        this.pIX.addHeader("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
        this.pIX.addHeader("Content-Type", "text/html");
        this.pIX.addHeader("Cookie", W(paramb.pJc));
        if (paramb.pJa == 1) {
          a(paramb, this.pIX);
        }
        this.pIY = this.pIW.execute(this.pIX);
        this.result = this.pIY.getStatusLine().getStatusCode();
        localObject1 = null;
        localObject2 = null;
        localHttpEntity = null;
        if (this.pIY.getFirstHeader("set-cookie") == null) {
          break label1298;
        }
        paramString1 = this.pIY.getFirstHeader("set-cookie").getValue();
        if (this.pIY.getFirstHeader("Content-Encoding") != null) {
          localObject1 = this.pIY.getFirstHeader("Content-Encoding").getValue();
        }
        if (this.pIY.getFirstHeader("Content-Disposition") != null) {
          localObject2 = this.pIY.getFirstHeader("Content-Disposition").getValue();
        }
        if ((localObject2 == null) || (!((String)localObject2).contains("attachment;")) || (!paramString2.contains("download"))) {
          continue;
        }
        i = 1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1 = new n.c(-10001, null, "unsupported ecoding");
        return paramString1;
        localObject1 = null;
        continue;
        i = 0;
        continue;
        localHttpEntity = this.pIY.getEntity();
        localHttpEntity.getContentLength();
        localObject2 = localHttpEntity.getContent();
        if ((localObject1 == null) || (!((String)localObject1).contains("gzip"))) {
          break label1291;
        }
        localObject1 = new GZIPInputStream((InputStream)localObject2);
        if (i == 0) {
          continue;
        }
        localObject2 = pIZ;
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramb.pJb.get("default_attach_name") != null) {
          continue;
        }
        paramb = Long.valueOf(System.currentTimeMillis());
        paramb = new FileOutputStream(new File((String)localObject2, paramb), true);
        localObject2 = new byte[1024];
        if (this.isCancelled) {
          continue;
        }
        j = ((InputStream)localObject1).read((byte[])localObject2);
        if (j <= 0) {
          continue;
        }
        paramb.write((byte[])localObject2, 0, j);
        paramb.flush();
        parama.cdD();
        continue;
      }
      catch (UnknownHostException paramString1)
      {
        paramString1 = new n.c(-10005, null, "unknow host");
        return paramString1;
        paramb = (Serializable)paramb.pJb.get("default_attach_name");
        continue;
        paramb = new ByteArrayOutputStream();
        continue;
      }
      catch (ClientProtocolException paramString1)
      {
        HttpEntity localHttpEntity;
        paramString1 = new n.c(-10002, null, "client protocol error");
        return paramString1;
        if (!this.isCancelled) {
          continue;
        }
        paramb.flush();
        paramb.close();
        return null;
        int j = this.result;
        parama = Xr(paramString1);
        if (i == 0) {
          continue;
        }
        paramString1 = "";
        paramString1 = new n.c(j, parama, paramString1);
        paramb.flush();
        paramb.close();
        localHttpEntity.consumeContent();
        if (localObject1 == null) {
          continue;
        }
        ((InputStream)localObject1).close();
        ab.d("MicroMsg.URLConnectionUtil", "uri=" + paramString2 + ", " + paramString1);
        return paramString1;
        paramString1 = new String(((ByteArrayOutputStream)paramb).toByteArray());
        continue;
      }
      catch (IllegalStateException paramString1)
      {
        paramString1 = new n.c(-10003, null, "illegal state");
        return paramString1;
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1 = new n.c(-10004, null, "output file not found");
        return paramString1;
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("MicroMsg.URLConnectionUtil", paramString1, "http unavailable", new Object[0]);
        if (this.result != 0) {
          continue;
        }
        i = 503;
        paramString1 = new n.c(i, null, null);
        return paramString1;
        i = this.result;
        continue;
      }
      catch (OutOfMemoryError paramString1)
      {
        ab.printErrStackTrace("MicroMsg.URLConnectionUtil", paramString1, "http unavailable", new Object[0]);
        if (this.result != 0) {
          continue;
        }
        int i = 503;
        paramString1 = new n.c(i, null, null);
        return paramString1;
        i = this.result;
        continue;
      }
      finally
      {
        if (this.pIW == null) {
          continue;
        }
        this.pIW.getConnectionManager().shutdown();
        AppMethodBeat.o(67955);
      }
      if (i == 0)
      {
        localObject2 = localHttpEntity;
        if (this.pIY.getFirstHeader("Content-Length") != null) {
          localObject2 = this.pIY.getFirstHeader("Content-Length").getValue();
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (bo.getInt((String)localObject2, 0) > 5242880L))
        {
          paramString1 = new n.c(-10000, null, "mail content to large");
          if (this.pIW != null) {
            this.pIW.getConnectionManager().shutdown();
          }
          AppMethodBeat.o(67955);
          return paramString1;
          localObject1 = null;
          continue;
          if (paramb.pJa == 0)
          {
            localObject1 = paramb.pJb;
            this.pIX = new HttpPost(f(paramString1, paramString2, (Map)localObject1));
            continue;
          }
        }
      }
      label1291:
      Object localObject1 = localObject2;
      continue;
      label1298:
      paramString1 = null;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(67956);
    ab.d("MicroMsg.URLConnectionUtil", "cancel conection.");
    this.isCancelled = true;
    if ((this.pIX != null) && (!this.pIX.isAborted())) {
      this.pIX.abort();
    }
    if (this.pIW != null) {
      this.pIW.getConnectionManager().shutdown();
    }
    AppMethodBeat.o(67956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.m
 * JD-Core Version:    0.7.0.1
 */