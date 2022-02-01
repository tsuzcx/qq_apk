package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
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

public final class l
  extends n
{
  private static final String BOUNDARY;
  private HttpPost vUc;
  
  static
  {
    AppMethodBeat.i(122688);
    BOUNDARY = "WEIXIN" + System.currentTimeMillis();
    AppMethodBeat.o(122688);
  }
  
  private static String a(n.b paramb)
  {
    AppMethodBeat.i(122687);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramb.vUl.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append("------" + BOUNDARY + "\r\n");
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
      localStringBuilder.append("\r\n");
      localStringBuilder.append((String)paramb.vUl.get(str));
      localStringBuilder.append("\r\n");
    }
    localObject = new e(paramb.vUn.filePath);
    if (!((e)localObject).isFile())
    {
      paramb = new InvalidParameterException("The path to upload isnot a file.");
      AppMethodBeat.o(122687);
      throw paramb;
    }
    localObject = ((e)localObject).getName();
    localStringBuilder.append("------" + BOUNDARY + "\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=\"" + paramb.vUn.param + "\"; filename=\"" + (String)localObject + "\"\r\n");
    localStringBuilder.append("\r\n");
    paramb = localStringBuilder.toString();
    AppMethodBeat.o(122687);
    return paramb;
  }
  
  public final n.c a(String paramString1, String paramString2, n.b paramb, n.a parama)
  {
    int j = 0;
    AppMethodBeat.i(122685);
    ac.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + paramb);
    parama = new DefaultHttpClient();
    int i = j;
    try
    {
      Object localObject = a(paramb);
      i = j;
      String str = paramb.vUn.filePath;
      i = j;
      StringBuilder localStringBuilder = new StringBuilder();
      i = j;
      localStringBuilder.append("\r\n");
      i = j;
      localStringBuilder.append("------" + BOUNDARY + "--\r\n");
      i = j;
      localObject = new a((String)localObject, str, localStringBuilder.toString());
      i = j;
      this.vUc = new HttpPost(f(paramString1, paramString2, paramb.vUl));
      i = j;
      this.vUc.setHeader("User-Agent", userAgent);
      i = j;
      this.vUc.setHeader("Host", host);
      i = j;
      this.vUc.setHeader("Connection", "Keep-Alive");
      i = j;
      this.vUc.setHeader("Accept-Charset", "utf-8");
      i = j;
      this.vUc.setHeader("Cookie", au(paramb.vUm));
      i = j;
      this.vUc.setEntity((HttpEntity)localObject);
      i = j;
      paramb = parama.execute(this.vUc);
      i = j;
      j = paramb.getStatusLine().getStatusCode();
      i = j;
      paramString1 = paramb.getEntity();
      i = j;
      paramb = paramb.getFirstHeader("set-cookie").getValue();
      i = j;
      paramString1 = EntityUtils.toString(paramString1);
      i = j;
      paramString1 = new n.c(j, apT(paramb), paramString1);
      i = j;
      ac.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ac.printErrStackTrace("MicroMsg.HttpClientUtil", paramString1, "", new Object[0]);
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
      AppMethodBeat.o(122685);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(122686);
    ac.d("MicroMsg.HttpClientUtil", "cancel conection.");
    if ((this.vUc != null) && (!this.vUc.isAborted())) {
      this.vUc.abort();
    }
    AppMethodBeat.o(122686);
  }
  
  final class a
    implements HttpEntity
  {
    private e kPM;
    private int length;
    private String vUd;
    private String vUe;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(122678);
      this.vUd = paramString1;
      this.kPM = new e(paramString2);
      this.vUe = paramString3;
      this.length = (paramString1.length() + (int)this.kPM.length() + paramString3.length());
      AppMethodBeat.o(122678);
    }
    
    public final void consumeContent()
    {
      AppMethodBeat.i(122684);
      if (isStreaming())
      {
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        AppMethodBeat.o(122684);
        throw localUnsupportedOperationException;
      }
      AppMethodBeat.o(122684);
    }
    
    public final InputStream getContent()
    {
      AppMethodBeat.i(122682);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
      AppMethodBeat.o(122682);
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
      AppMethodBeat.i(122681);
      BasicHeader localBasicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + l.BOUNDARY);
      AppMethodBeat.o(122681);
      return localBasicHeader;
    }
    
    public final boolean isChunked()
    {
      AppMethodBeat.i(122679);
      if (!isRepeatable())
      {
        AppMethodBeat.o(122679);
        return true;
      }
      AppMethodBeat.o(122679);
      return false;
    }
    
    public final boolean isRepeatable()
    {
      return true;
    }
    
    public final boolean isStreaming()
    {
      AppMethodBeat.i(122680);
      if (!isRepeatable())
      {
        AppMethodBeat.o(122680);
        return true;
      }
      AppMethodBeat.o(122680);
      return false;
    }
    
    public final void writeTo(OutputStream paramOutputStream)
    {
      AppMethodBeat.i(122683);
      DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
      localDataOutputStream.writeBytes(this.vUd);
      InputStream localInputStream = null;
      paramOutputStream = localInputStream;
      try
      {
        byte[] arrayOfByte = new byte[1024];
        paramOutputStream = localInputStream;
        localInputStream = i.ag(this.kPM);
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
        AppMethodBeat.o(122683);
      }
      localDataOutputStream.flush();
      if (localObject != null) {
        localObject.close();
      }
      localDataOutputStream.writeBytes(this.vUe);
      AppMethodBeat.o(122683);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.l
 * JD-Core Version:    0.7.0.1
 */