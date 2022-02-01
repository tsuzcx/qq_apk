package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public final class a
  extends c
{
  private static final String BOUNDARY;
  private HttpPost xaF;
  
  static
  {
    AppMethodBeat.i(215160);
    BOUNDARY = "WEIXIN" + System.currentTimeMillis();
    AppMethodBeat.o(215160);
  }
  
  private static String a(c.e parame)
  {
    AppMethodBeat.i(215159);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = parame.xaW.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append("------" + BOUNDARY + "\r\n");
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
      localStringBuilder.append("\r\n");
      localStringBuilder.append((String)parame.xaW.get(str));
      localStringBuilder.append("\r\n");
    }
    localObject = new e(parame.xaY.filePath);
    if (!((e)localObject).isFile())
    {
      parame = new InvalidParameterException("The path to upload isnot a file.");
      AppMethodBeat.o(215159);
      throw parame;
    }
    localObject = ((e)localObject).getName();
    localStringBuilder.append("------" + BOUNDARY + "\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=\"" + parame.xaY.param + "\"; filename=\"" + (String)localObject + "\"\r\n");
    localStringBuilder.append("\r\n");
    parame = localStringBuilder.toString();
    AppMethodBeat.o(215159);
    return parame;
  }
  
  public final c.f a(String paramString1, String paramString2, c.e parame, c.d paramd)
  {
    int j = 0;
    AppMethodBeat.i(215157);
    ad.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + parame);
    paramd = new DefaultHttpClient();
    int i = j;
    try
    {
      Object localObject = a(parame);
      i = j;
      String str = parame.xaY.filePath;
      i = j;
      StringBuilder localStringBuilder = new StringBuilder();
      i = j;
      localStringBuilder.append("\r\n");
      i = j;
      localStringBuilder.append("------" + BOUNDARY + "--\r\n");
      i = j;
      localObject = new a((String)localObject, str, localStringBuilder.toString());
      i = j;
      this.xaF = new HttpPost(f(paramString1, paramString2, parame.xaW));
      i = j;
      this.xaF.setHeader("User-Agent", USER_AGENT);
      i = j;
      this.xaF.setHeader("Host", host);
      i = j;
      this.xaF.setHeader("Connection", "Keep-Alive");
      i = j;
      this.xaF.setHeader("Accept-Charset", "utf-8");
      i = j;
      this.xaF.setHeader("Cookie", aA(parame.xaX));
      i = j;
      this.xaF.setEntity((HttpEntity)localObject);
      i = j;
      parame = paramd.execute(this.xaF);
      i = j;
      j = parame.getStatusLine().getStatusCode();
      i = j;
      paramString1 = parame.getEntity();
      i = j;
      parame = parame.getFirstHeader("set-cookie").getValue();
      i = j;
      paramString1 = EntityUtils.toString(paramString1);
      i = j;
      paramString1 = new c.f(j, auU(parame), paramString1);
      i = j;
      ad.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.HttpClientUtil", paramString1, "", new Object[0]);
      j = i;
      if (i == 0) {
        j = 503;
      }
      paramString1 = new c.f(j, null, null);
      return paramString1;
    }
    finally
    {
      paramd.getConnectionManager().shutdown();
      AppMethodBeat.o(215157);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(215158);
    ad.d("MicroMsg.HttpClientUtil", "cancel conection.");
    if ((this.xaF != null) && (!this.xaF.isAborted())) {
      this.xaF.abort();
    }
    AppMethodBeat.o(215158);
  }
  
  final class a
    implements HttpEntity
  {
    private e aXd;
    private int length;
    private String xaG;
    private String xaH;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(215150);
      this.xaG = paramString1;
      this.aXd = new e(paramString2);
      this.xaH = paramString3;
      this.length = (paramString1.length() + (int)this.aXd.length() + paramString3.length());
      AppMethodBeat.o(215150);
    }
    
    public final void consumeContent()
    {
      AppMethodBeat.i(215156);
      if (isStreaming())
      {
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        AppMethodBeat.o(215156);
        throw localUnsupportedOperationException;
      }
      AppMethodBeat.o(215156);
    }
    
    public final InputStream getContent()
    {
      AppMethodBeat.i(215154);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
      AppMethodBeat.o(215154);
      throw localUnsupportedOperationException;
    }
    
    public final Header getContentEncoding()
    {
      return null;
    }
    
    public final long getContentLength()
    {
      return this.length;
    }
    
    public final Header getContentType()
    {
      AppMethodBeat.i(215153);
      BasicHeader localBasicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + a.BOUNDARY);
      AppMethodBeat.o(215153);
      return localBasicHeader;
    }
    
    public final boolean isChunked()
    {
      AppMethodBeat.i(215151);
      if (!isRepeatable())
      {
        AppMethodBeat.o(215151);
        return true;
      }
      AppMethodBeat.o(215151);
      return false;
    }
    
    public final boolean isRepeatable()
    {
      return true;
    }
    
    public final boolean isStreaming()
    {
      AppMethodBeat.i(215152);
      if (!isRepeatable())
      {
        AppMethodBeat.o(215152);
        return true;
      }
      AppMethodBeat.o(215152);
      return false;
    }
    
    public final void writeTo(OutputStream paramOutputStream)
    {
      AppMethodBeat.i(215155);
      DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
      localDataOutputStream.writeBytes(this.xaG);
      InputStream localInputStream = null;
      paramOutputStream = localInputStream;
      try
      {
        byte[] arrayOfByte = new byte[1024];
        paramOutputStream = localInputStream;
        localInputStream = i.ai(this.aXd);
        for (;;)
        {
          paramOutputStream = localInputStream;
          int i = localInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          paramOutputStream = localInputStream;
          localDataOutputStream.write(arrayOfByte, 0, i);
        }
        paramOutputStream = localObject;
      }
      finally
      {
        if (paramOutputStream != null) {
          paramOutputStream.close();
        }
        AppMethodBeat.o(215155);
      }
      localDataOutputStream.flush();
      if (localObject != null) {
        localObject.close();
      }
      localDataOutputStream.writeBytes(this.xaH);
      AppMethodBeat.o(215155);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.a
 * JD-Core Version:    0.7.0.1
 */