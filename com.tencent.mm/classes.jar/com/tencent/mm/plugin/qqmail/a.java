package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
  private HttpPost xqw;
  
  static
  {
    AppMethodBeat.i(217906);
    BOUNDARY = "WEIXIN" + System.currentTimeMillis();
    AppMethodBeat.o(217906);
  }
  
  private static String a(c.e parame)
  {
    AppMethodBeat.i(217905);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = parame.xqN.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append("------" + BOUNDARY + "\r\n");
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
      localStringBuilder.append("\r\n");
      localStringBuilder.append((String)parame.xqN.get(str));
      localStringBuilder.append("\r\n");
    }
    localObject = new k(parame.xqP.filePath);
    if (!((k)localObject).isFile())
    {
      parame = new InvalidParameterException("The path to upload isnot a file.");
      AppMethodBeat.o(217905);
      throw parame;
    }
    localObject = ((k)localObject).getName();
    localStringBuilder.append("------" + BOUNDARY + "\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=\"" + parame.xqP.param + "\"; filename=\"" + (String)localObject + "\"\r\n");
    localStringBuilder.append("\r\n");
    parame = localStringBuilder.toString();
    AppMethodBeat.o(217905);
    return parame;
  }
  
  public final c.f a(String paramString1, String paramString2, c.e parame, c.d paramd)
  {
    int j = 0;
    AppMethodBeat.i(217903);
    ae.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + parame);
    paramd = new DefaultHttpClient();
    int i = j;
    try
    {
      Object localObject = a(parame);
      i = j;
      String str = parame.xqP.filePath;
      i = j;
      StringBuilder localStringBuilder = new StringBuilder();
      i = j;
      localStringBuilder.append("\r\n");
      i = j;
      localStringBuilder.append("------" + BOUNDARY + "--\r\n");
      i = j;
      localObject = new a((String)localObject, str, localStringBuilder.toString());
      i = j;
      this.xqw = new HttpPost(f(paramString1, paramString2, parame.xqN));
      i = j;
      this.xqw.setHeader("User-Agent", USER_AGENT);
      i = j;
      this.xqw.setHeader("Host", host);
      i = j;
      this.xqw.setHeader("Connection", "Keep-Alive");
      i = j;
      this.xqw.setHeader("Accept-Charset", "utf-8");
      i = j;
      this.xqw.setHeader("Cookie", aG(parame.xqO));
      i = j;
      this.xqw.setEntity((HttpEntity)localObject);
      i = j;
      parame = paramd.execute(this.xqw);
      i = j;
      j = parame.getStatusLine().getStatusCode();
      i = j;
      paramString1 = parame.getEntity();
      i = j;
      parame = parame.getFirstHeader("set-cookie").getValue();
      i = j;
      paramString1 = EntityUtils.toString(paramString1);
      i = j;
      paramString1 = new c.f(j, awj(parame), paramString1);
      i = j;
      ae.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.HttpClientUtil", paramString1, "", new Object[0]);
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
      AppMethodBeat.o(217903);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(217904);
    ae.d("MicroMsg.HttpClientUtil", "cancel conection.");
    if ((this.xqw != null) && (!this.xqw.isAborted())) {
      this.xqw.abort();
    }
    AppMethodBeat.o(217904);
  }
  
  final class a
    implements HttpEntity
  {
    private k aXd;
    private int length;
    private String xqx;
    private String xqy;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(217896);
      this.xqx = paramString1;
      this.aXd = new k(paramString2);
      this.xqy = paramString3;
      this.length = (paramString1.length() + (int)this.aXd.length() + paramString3.length());
      AppMethodBeat.o(217896);
    }
    
    public final void consumeContent()
    {
      AppMethodBeat.i(217902);
      if (isStreaming())
      {
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        AppMethodBeat.o(217902);
        throw localUnsupportedOperationException;
      }
      AppMethodBeat.o(217902);
    }
    
    public final InputStream getContent()
    {
      AppMethodBeat.i(217900);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
      AppMethodBeat.o(217900);
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
      AppMethodBeat.i(217899);
      BasicHeader localBasicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + a.BOUNDARY);
      AppMethodBeat.o(217899);
      return localBasicHeader;
    }
    
    public final boolean isChunked()
    {
      AppMethodBeat.i(217897);
      if (!isRepeatable())
      {
        AppMethodBeat.o(217897);
        return true;
      }
      AppMethodBeat.o(217897);
      return false;
    }
    
    public final boolean isRepeatable()
    {
      return true;
    }
    
    public final boolean isStreaming()
    {
      AppMethodBeat.i(217898);
      if (!isRepeatable())
      {
        AppMethodBeat.o(217898);
        return true;
      }
      AppMethodBeat.o(217898);
      return false;
    }
    
    public final void writeTo(OutputStream paramOutputStream)
    {
      AppMethodBeat.i(217901);
      DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
      localDataOutputStream.writeBytes(this.xqx);
      InputStream localInputStream = null;
      paramOutputStream = localInputStream;
      try
      {
        byte[] arrayOfByte = new byte[1024];
        paramOutputStream = localInputStream;
        localInputStream = o.ai(this.aXd);
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
        AppMethodBeat.o(217901);
      }
      localDataOutputStream.flush();
      if (localObject != null) {
        localObject.close();
      }
      localDataOutputStream.writeBytes(this.xqy);
      AppMethodBeat.o(217901);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.a
 * JD-Core Version:    0.7.0.1
 */