package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
  private static final String BOUNDARY;
  private HttpPost pIS;
  
  static
  {
    AppMethodBeat.i(67954);
    BOUNDARY = "WEIXIN" + System.currentTimeMillis();
    AppMethodBeat.o(67954);
  }
  
  private static String a(n.b paramb)
  {
    AppMethodBeat.i(67953);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramb.pJb.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append("------" + BOUNDARY + "\r\n");
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
      localStringBuilder.append("\r\n");
      localStringBuilder.append((String)paramb.pJb.get(str));
      localStringBuilder.append("\r\n");
    }
    localObject = new File(paramb.pJd.filePath);
    if (!((File)localObject).isFile())
    {
      paramb = new InvalidParameterException("The path to upload isnot a file.");
      AppMethodBeat.o(67953);
      throw paramb;
    }
    localObject = ((File)localObject).getName();
    localStringBuilder.append("------" + BOUNDARY + "\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=\"" + paramb.pJd.cvO + "\"; filename=\"" + (String)localObject + "\"\r\n");
    localStringBuilder.append("\r\n");
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(67953);
    return paramb;
  }
  
  public final n.c a(String paramString1, String paramString2, n.b paramb, n.a parama)
  {
    int j = 0;
    AppMethodBeat.i(67951);
    ab.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + paramb);
    parama = new DefaultHttpClient();
    int i = j;
    try
    {
      Object localObject = a(paramb);
      i = j;
      String str = paramb.pJd.filePath;
      i = j;
      StringBuilder localStringBuilder = new StringBuilder();
      i = j;
      localStringBuilder.append("\r\n");
      i = j;
      localStringBuilder.append("------" + BOUNDARY + "--\r\n");
      i = j;
      localObject = new l.a(this, (String)localObject, str, localStringBuilder.toString());
      i = j;
      this.pIS = new HttpPost(f(paramString1, paramString2, paramb.pJb));
      i = j;
      this.pIS.setHeader("User-Agent", userAgent);
      i = j;
      this.pIS.setHeader("Host", host);
      i = j;
      this.pIS.setHeader("Connection", "Keep-Alive");
      i = j;
      this.pIS.setHeader("Accept-Charset", "utf-8");
      i = j;
      this.pIS.setHeader("Cookie", W(paramb.pJc));
      i = j;
      this.pIS.setEntity((HttpEntity)localObject);
      i = j;
      paramb = parama.execute(this.pIS);
      i = j;
      j = paramb.getStatusLine().getStatusCode();
      i = j;
      paramString1 = paramb.getEntity();
      i = j;
      paramb = paramb.getFirstHeader("set-cookie").getValue();
      i = j;
      paramString1 = EntityUtils.toString(paramString1);
      i = j;
      paramString1 = new n.c(j, Xr(paramb), paramString1);
      i = j;
      ab.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.HttpClientUtil", paramString1, "", new Object[0]);
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
      AppMethodBeat.o(67951);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(67952);
    ab.d("MicroMsg.HttpClientUtil", "cancel conection.");
    if ((this.pIS != null) && (!this.pIS.isAborted())) {
      this.pIS.abort();
    }
    AppMethodBeat.o(67952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.l
 * JD-Core Version:    0.7.0.1
 */