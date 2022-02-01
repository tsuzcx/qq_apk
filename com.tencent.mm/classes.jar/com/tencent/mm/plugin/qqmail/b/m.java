package com.tencent.mm.plugin.qqmail.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
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

public final class m
  extends n
{
  private boolean isCancelled = false;
  private int result = 0;
  private HttpClient uLp = null;
  private HttpRequestBase uLq = null;
  private HttpResponse uLr = null;
  
  private static void a(n.b paramb, HttpRequestBase paramHttpRequestBase)
  {
    AppMethodBeat.i(122691);
    if (paramb.uLu == null)
    {
      AppMethodBeat.o(122691);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramb.uLu.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new BasicNameValuePair(str, (String)paramb.uLu.get(str)));
    }
    ((HttpPost)paramHttpRequestBase).setEntity(new UrlEncodedFormEntity(localArrayList, "utf-8"));
    AppMethodBeat.o(122691);
  }
  
  public final n.c a(String paramString1, String paramString2, n.b paramb, n.a parama)
  {
    AppMethodBeat.i(122689);
    ad.d("MicroMsg.URLConnectionUtil", "uri=" + paramString2 + ", " + paramb);
    for (;;)
    {
      Object localObject2;
      try
      {
        this.isCancelled = false;
        this.uLp = new DefaultHttpClient();
        if (paramb.uLt != 0) {
          continue;
        }
        if (paramb.uLt != 0) {
          continue;
        }
        localObject1 = paramb.uLu;
        this.uLq = new HttpGet(d(paramString1, paramString2, (Map)localObject1));
        this.uLq.addHeader("User-Agent", userAgent);
        this.uLq.addHeader("Host", host);
        System.setProperty("http.keepAlive", "false");
        this.uLq.addHeader("Accept-Charset", "utf-8");
        this.uLq.addHeader("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
        this.uLq.addHeader("Content-Type", "text/html");
        this.uLq.addHeader("Cookie", as(paramb.uLv));
        if (paramb.uLt == 1) {
          a(paramb, this.uLq);
        }
        this.uLr = this.uLp.execute(this.uLq);
        this.result = this.uLr.getStatusLine().getStatusCode();
        localObject1 = null;
        localObject2 = null;
        localHttpEntity = null;
        if (this.uLr.getFirstHeader("set-cookie") == null) {
          break label1294;
        }
        paramString1 = this.uLr.getFirstHeader("set-cookie").getValue();
        if (this.uLr.getFirstHeader("Content-Encoding") != null) {
          localObject1 = this.uLr.getFirstHeader("Content-Encoding").getValue();
        }
        if (this.uLr.getFirstHeader("Content-Disposition") != null) {
          localObject2 = this.uLr.getFirstHeader("Content-Disposition").getValue();
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
        localHttpEntity = this.uLr.getEntity();
        localHttpEntity.getContentLength();
        localObject2 = localHttpEntity.getContent();
        if ((localObject1 == null) || (!((String)localObject1).contains("gzip"))) {
          break label1287;
        }
        localObject1 = new GZIPInputStream((InputStream)localObject2);
        if (i == 0) {
          continue;
        }
        localObject2 = uLs;
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramb.uLu.get("default_attach_name") != null) {
          continue;
        }
        paramb = Long.valueOf(System.currentTimeMillis());
        paramb = i.d(new e((String)localObject2, paramb), true);
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
        parama.ddV();
        continue;
      }
      catch (UnknownHostException paramString1)
      {
        paramString1 = new n.c(-10005, null, "unknow host");
        return paramString1;
        paramb = (Serializable)paramb.uLu.get("default_attach_name");
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
        parama = akU(paramString1);
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
        ad.d("MicroMsg.URLConnectionUtil", "uri=" + paramString2 + ", " + paramString1);
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
        ad.printErrStackTrace("MicroMsg.URLConnectionUtil", paramString1, "http unavailable", new Object[0]);
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
        ad.printErrStackTrace("MicroMsg.URLConnectionUtil", paramString1, "http unavailable", new Object[0]);
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
        if (this.uLp == null) {
          continue;
        }
        this.uLp.getConnectionManager().shutdown();
        AppMethodBeat.o(122689);
      }
      if (i == 0)
      {
        localObject2 = localHttpEntity;
        if (this.uLr.getFirstHeader("Content-Length") != null) {
          localObject2 = this.uLr.getFirstHeader("Content-Length").getValue();
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (bt.getInt((String)localObject2, 0) > 5242880L))
        {
          paramString1 = new n.c(-10000, null, "mail content to large");
          if (this.uLp != null) {
            this.uLp.getConnectionManager().shutdown();
          }
          AppMethodBeat.o(122689);
          return paramString1;
          localObject1 = null;
          continue;
          if (paramb.uLt == 0)
          {
            localObject1 = paramb.uLu;
            this.uLq = new HttpPost(d(paramString1, paramString2, (Map)localObject1));
            continue;
          }
        }
      }
      label1287:
      Object localObject1 = localObject2;
      continue;
      label1294:
      paramString1 = null;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(122690);
    ad.d("MicroMsg.URLConnectionUtil", "cancel conection.");
    this.isCancelled = true;
    if ((this.uLq != null) && (!this.uLq.isAborted())) {
      this.uLq.abort();
    }
    if (this.uLp != null) {
      this.uLp.getConnectionManager().shutdown();
    }
    AppMethodBeat.o(122690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.m
 * JD-Core Version:    0.7.0.1
 */