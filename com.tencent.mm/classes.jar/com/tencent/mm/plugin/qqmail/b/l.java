package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public final class l
  extends n
{
  private static final String BOUNDARY = "WEIXIN" + System.currentTimeMillis();
  private HttpPost ndB;
  
  private static String a(n.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramb.ndL.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append("------" + BOUNDARY + "\r\n");
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
      localStringBuilder.append("\r\n");
      localStringBuilder.append((String)paramb.ndL.get(str));
      localStringBuilder.append("\r\n");
    }
    localObject = new File(paramb.ndN.filePath);
    if (!((File)localObject).isFile()) {
      throw new InvalidParameterException("The path to upload isnot a file.");
    }
    localObject = ((File)localObject).getName();
    localStringBuilder.append("------" + BOUNDARY + "\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=\"" + paramb.ndN.bOx + "\"; filename=\"" + (String)localObject + "\"\r\n");
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString();
  }
  
  public final n.c a(String paramString1, String paramString2, n.b paramb, n.a parama)
  {
    int j = 0;
    y.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + paramb);
    parama = new DefaultHttpClient();
    int i = j;
    try
    {
      Object localObject = a(paramb);
      i = j;
      String str = paramb.ndN.filePath;
      i = j;
      StringBuilder localStringBuilder = new StringBuilder();
      i = j;
      localStringBuilder.append("\r\n");
      i = j;
      localStringBuilder.append("------" + BOUNDARY + "--\r\n");
      i = j;
      localObject = new l.a(this, (String)localObject, str, localStringBuilder.toString());
      i = j;
      this.ndB = new HttpPost(c(paramString1, paramString2, paramb.ndL));
      i = j;
      this.ndB.setHeader("User-Agent", aRC);
      i = j;
      this.ndB.setHeader("Host", host);
      i = j;
      this.ndB.setHeader("Connection", "Keep-Alive");
      i = j;
      this.ndB.setHeader("Accept-Charset", "utf-8");
      i = j;
      this.ndB.setHeader("Cookie", H(paramb.ndM));
      i = j;
      this.ndB.setEntity((HttpEntity)localObject);
      i = j;
      paramb = parama.execute(this.ndB);
      i = j;
      j = paramb.getStatusLine().getStatusCode();
      i = j;
      paramString1 = paramb.getEntity();
      i = j;
      paramb = paramb.getFirstHeader("set-cookie").getValue();
      i = j;
      paramString1 = EntityUtils.toString(paramString1);
      i = j;
      paramString1 = new n.c(j, Lh(paramb), paramString1);
      i = j;
      y.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.HttpClientUtil", paramString1, "", new Object[0]);
      j = i;
      if (i == 0) {
        j = 503;
      }
      paramString1 = new n.c(j, null, null);
      return paramString1;
    }
    finally
    {
      parama.getConnectionManager().shutdown();
    }
  }
  
  public final void cancel()
  {
    y.d("MicroMsg.HttpClientUtil", "cancel conection.");
    if ((this.ndB != null) && (!this.ndB.isAborted())) {
      this.ndB.abort();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.l
 * JD-Core Version:    0.7.0.1
 */