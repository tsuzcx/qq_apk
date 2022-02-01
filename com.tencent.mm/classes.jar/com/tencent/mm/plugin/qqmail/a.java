package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
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
  private HttpPost post;
  
  static
  {
    AppMethodBeat.i(198560);
    BOUNDARY = "WEIXIN" + System.currentTimeMillis();
    AppMethodBeat.o(198560);
  }
  
  private static String a(c.e parame)
  {
    AppMethodBeat.i(198559);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = parame.params.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append("------" + BOUNDARY + "\r\n");
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
      localStringBuilder.append("\r\n");
      localStringBuilder.append((String)parame.params.get(str));
      localStringBuilder.append("\r\n");
    }
    localObject = new o(parame.BqS.filePath);
    if (!((o)localObject).isFile())
    {
      parame = new InvalidParameterException("The path to upload isnot a file.");
      AppMethodBeat.o(198559);
      throw parame;
    }
    localObject = ((o)localObject).getName();
    localStringBuilder.append("------" + BOUNDARY + "\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=\"" + parame.BqS.param + "\"; filename=\"" + (String)localObject + "\"\r\n");
    localStringBuilder.append("\r\n");
    parame = localStringBuilder.toString();
    AppMethodBeat.o(198559);
    return parame;
  }
  
  public final c.f a(String paramString1, String paramString2, c.e parame, c.d paramd)
  {
    int j = 0;
    AppMethodBeat.i(198557);
    Log.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + parame);
    paramd = new DefaultHttpClient();
    int i = j;
    try
    {
      Object localObject = a(parame);
      i = j;
      String str = parame.BqS.filePath;
      i = j;
      StringBuilder localStringBuilder = new StringBuilder();
      i = j;
      localStringBuilder.append("\r\n");
      i = j;
      localStringBuilder.append("------" + BOUNDARY + "--\r\n");
      i = j;
      localObject = new a((String)localObject, str, localStringBuilder.toString());
      i = j;
      this.post = new HttpPost(d(paramString1, paramString2, parame.params));
      i = j;
      this.post.setHeader("User-Agent", USER_AGENT);
      i = j;
      this.post.setHeader("Host", host);
      i = j;
      this.post.setHeader("Connection", "Keep-Alive");
      i = j;
      this.post.setHeader("Accept-Charset", "utf-8");
      i = j;
      this.post.setHeader("Cookie", getCookie(parame.cookie));
      i = j;
      this.post.setEntity((HttpEntity)localObject);
      i = j;
      parame = paramd.execute(this.post);
      i = j;
      j = parame.getStatusLine().getStatusCode();
      i = j;
      paramString1 = parame.getEntity();
      i = j;
      parame = parame.getFirstHeader("set-cookie").getValue();
      i = j;
      paramString1 = EntityUtils.toString(paramString1);
      i = j;
      paramString1 = new c.f(j, parseCookie(parame), paramString1);
      i = j;
      Log.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.HttpClientUtil", paramString1, "", new Object[0]);
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
      AppMethodBeat.o(198557);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(198558);
    Log.d("MicroMsg.HttpClientUtil", "cancel conection.");
    if ((this.post != null) && (!this.post.isAborted())) {
      this.post.abort();
    }
    AppMethodBeat.o(198558);
  }
  
  final class a
    implements HttpEntity
  {
    private o file;
    private int length;
    private String nextPart;
    private String prePart;
    
    public a(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(198550);
      this.prePart = paramString1;
      this.file = new o(paramString2);
      this.nextPart = paramString3;
      this.length = (paramString1.length() + (int)this.file.length() + paramString3.length());
      AppMethodBeat.o(198550);
    }
    
    public final void consumeContent()
    {
      AppMethodBeat.i(198556);
      if (isStreaming())
      {
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        AppMethodBeat.o(198556);
        throw localUnsupportedOperationException;
      }
      AppMethodBeat.o(198556);
    }
    
    public final InputStream getContent()
    {
      AppMethodBeat.i(198554);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
      AppMethodBeat.o(198554);
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
      AppMethodBeat.i(198553);
      BasicHeader localBasicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + a.BOUNDARY);
      AppMethodBeat.o(198553);
      return localBasicHeader;
    }
    
    public final boolean isChunked()
    {
      AppMethodBeat.i(198551);
      if (!isRepeatable())
      {
        AppMethodBeat.o(198551);
        return true;
      }
      AppMethodBeat.o(198551);
      return false;
    }
    
    public final boolean isRepeatable()
    {
      return true;
    }
    
    public final boolean isStreaming()
    {
      AppMethodBeat.i(198552);
      if (!isRepeatable())
      {
        AppMethodBeat.o(198552);
        return true;
      }
      AppMethodBeat.o(198552);
      return false;
    }
    
    public final void writeTo(OutputStream paramOutputStream)
    {
      AppMethodBeat.i(198555);
      DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
      localDataOutputStream.writeBytes(this.prePart);
      InputStream localInputStream = null;
      paramOutputStream = localInputStream;
      try
      {
        byte[] arrayOfByte = new byte[1024];
        paramOutputStream = localInputStream;
        localInputStream = s.ao(this.file);
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
        AppMethodBeat.o(198555);
      }
      localDataOutputStream.flush();
      if (localObject != null) {
        localObject.close();
      }
      localDataOutputStream.writeBytes(this.nextPart);
      AppMethodBeat.o(198555);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.a
 * JD-Core Version:    0.7.0.1
 */