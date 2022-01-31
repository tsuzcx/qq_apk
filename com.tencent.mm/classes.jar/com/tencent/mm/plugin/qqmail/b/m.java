package com.tencent.mm.plugin.qqmail.b;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private HttpClient ndF = null;
  private HttpRequestBase ndG = null;
  private HttpResponse ndH = null;
  private boolean ndI = false;
  private int result = 0;
  
  private static void a(n.b paramb, HttpRequestBase paramHttpRequestBase)
  {
    if (paramb.ndL == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramb.ndL.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new BasicNameValuePair(str, (String)paramb.ndL.get(str)));
    }
    ((HttpPost)paramHttpRequestBase).setEntity(new UrlEncodedFormEntity(localArrayList, "utf-8"));
  }
  
  public final n.c a(String paramString1, String paramString2, n.b paramb, n.a parama)
  {
    y.d("MicroMsg.URLConnectionUtil", "uri=" + paramString2 + ", " + paramb);
    for (;;)
    {
      Object localObject2;
      try
      {
        this.ndI = false;
        this.ndF = new DefaultHttpClient();
        if (paramb.ndK != 0) {
          continue;
        }
        if (paramb.ndK != 0) {
          continue;
        }
        localObject1 = paramb.ndL;
        this.ndG = new HttpGet(c(paramString1, paramString2, (Map)localObject1));
        this.ndG.addHeader("User-Agent", aRC);
        this.ndG.addHeader("Host", host);
        System.setProperty("http.keepAlive", "false");
        this.ndG.addHeader("Accept-Charset", "utf-8");
        this.ndG.addHeader("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
        this.ndG.addHeader("Content-Type", "text/html");
        this.ndG.addHeader("Cookie", H(paramb.ndM));
        if (paramb.ndK == 1) {
          a(paramb, this.ndG);
        }
        this.ndH = this.ndF.execute(this.ndG);
        this.result = this.ndH.getStatusLine().getStatusCode();
        localObject1 = null;
        localObject2 = null;
        localHttpEntity = null;
        if (this.ndH.getFirstHeader("set-cookie") == null) {
          break label1245;
        }
        paramString1 = this.ndH.getFirstHeader("set-cookie").getValue();
        if (this.ndH.getFirstHeader("Content-Encoding") != null) {
          localObject1 = this.ndH.getFirstHeader("Content-Encoding").getValue();
        }
        if (this.ndH.getFirstHeader("Content-Disposition") != null) {
          localObject2 = this.ndH.getFirstHeader("Content-Disposition").getValue();
        }
        if ((localObject2 == null) || (!((String)localObject2).contains("attachment;")) || (!paramString2.contains("download"))) {
          continue;
        }
        i = 1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString2 = new n.c(-10001, null, "unsupported ecoding");
        paramString1 = paramString2;
        return paramString2;
        localObject1 = null;
        continue;
        i = 0;
        continue;
        localHttpEntity = this.ndH.getEntity();
        localHttpEntity.getContentLength();
        localObject2 = localHttpEntity.getContent();
        if ((localObject1 == null) || (!((String)localObject1).contains("gzip"))) {
          break label1238;
        }
        localObject1 = new GZIPInputStream((InputStream)localObject2);
        if (i == 0) {
          continue;
        }
        localObject2 = ndJ;
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramb.ndL.get("default_attach_name") != null) {
          continue;
        }
        paramb = Long.valueOf(System.currentTimeMillis());
        paramb = new FileOutputStream(new File((String)localObject2, paramb), true);
        localObject2 = new byte[1024];
        if (this.ndI) {
          continue;
        }
        j = ((InputStream)localObject1).read((byte[])localObject2);
        if (j <= 0) {
          continue;
        }
        paramb.write((byte[])localObject2, 0, j);
        paramb.flush();
        parama.btt();
        continue;
      }
      catch (UnknownHostException paramString1)
      {
        paramString2 = new n.c(-10005, null, "unknow host");
        paramString1 = paramString2;
        return paramString2;
        paramb = (Serializable)paramb.ndL.get("default_attach_name");
        continue;
        paramb = new ByteArrayOutputStream();
        continue;
      }
      catch (ClientProtocolException paramString1)
      {
        HttpEntity localHttpEntity;
        paramString2 = new n.c(-10002, null, "client protocol error");
        paramString1 = paramString2;
        return paramString2;
        if (!this.ndI) {
          continue;
        }
        paramb.flush();
        paramb.close();
        return null;
        int j = this.result;
        parama = Lh(paramString1);
        if (i == 0) {
          continue;
        }
        paramString1 = "";
        paramString1 = new n.c(j, parama, paramString1);
        paramb.flush();
        paramb.close();
        localHttpEntity.consumeContent();
        y.d("MicroMsg.URLConnectionUtil", "uri=" + paramString2 + ", " + paramString1);
        return paramString1;
        paramString1 = new String(((ByteArrayOutputStream)paramb).toByteArray());
        continue;
      }
      catch (IllegalStateException paramString1)
      {
        paramString2 = new n.c(-10003, null, "illegal state");
        paramString1 = paramString2;
        return paramString2;
      }
      catch (FileNotFoundException paramString1)
      {
        paramString2 = new n.c(-10004, null, "output file not found");
        paramString1 = paramString2;
        return paramString2;
      }
      catch (Exception paramString1)
      {
        y.printErrStackTrace("MicroMsg.URLConnectionUtil", paramString1, "http unavailable", new Object[0]);
        if (this.result != 0) {
          continue;
        }
        i = 503;
        paramString2 = new n.c(i, null, null);
        paramString1 = paramString2;
        return paramString2;
        i = this.result;
        continue;
      }
      catch (OutOfMemoryError paramString1)
      {
        y.printErrStackTrace("MicroMsg.URLConnectionUtil", paramString1, "http unavailable", new Object[0]);
        if (this.result != 0) {
          continue;
        }
        int i = 503;
        paramString2 = new n.c(i, null, null);
        paramString1 = paramString2;
        return paramString2;
        i = this.result;
        continue;
      }
      finally
      {
        if (this.ndF == null) {
          continue;
        }
        this.ndF.getConnectionManager().shutdown();
      }
      if (i == 0)
      {
        localObject2 = localHttpEntity;
        if (this.ndH.getFirstHeader("Content-Length") != null) {
          localObject2 = this.ndH.getFirstHeader("Content-Length").getValue();
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (bk.getInt((String)localObject2, 0) > 5242880L))
        {
          paramString2 = new n.c(-10000, null, "mail content to large");
          paramString1 = paramString2;
          if (this.ndF != null)
          {
            this.ndF.getConnectionManager().shutdown();
            paramString1 = paramString2;
          }
          return paramString1;
          localObject1 = null;
          continue;
          if (paramb.ndK == 0)
          {
            localObject1 = paramb.ndL;
            this.ndG = new HttpPost(c(paramString1, paramString2, (Map)localObject1));
            continue;
          }
        }
      }
      label1238:
      Object localObject1 = localObject2;
      continue;
      label1245:
      paramString1 = null;
    }
  }
  
  public final void cancel()
  {
    y.d("MicroMsg.URLConnectionUtil", "cancel conection.");
    this.ndI = true;
    if ((this.ndG != null) && (!this.ndG.isAborted())) {
      this.ndG.abort();
    }
    if (this.ndF != null) {
      this.ndF.getConnectionManager().shutdown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.m
 * JD-Core Version:    0.7.0.1
 */