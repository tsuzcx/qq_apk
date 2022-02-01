package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

public final class a
  extends c
{
  private static final String BOUNDARY;
  private HttpPost post;
  
  static
  {
    AppMethodBeat.i(249907);
    BOUNDARY = "WEIXIN" + System.currentTimeMillis();
    AppMethodBeat.o(249907);
  }
  
  private static String a(c.e parame)
  {
    AppMethodBeat.i(249905);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = parame.params.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append("------" + BOUNDARY + "\r\n");
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
      localStringBuilder.append("\r\n");
      localStringBuilder.append((String)parame.params.get(str));
      localStringBuilder.append("\r\n");
    }
    AppMethodBeat.o(249905);
    throw null;
  }
  
  public final c.f a(String paramString1, String paramString2, c.e parame, c.d paramd)
  {
    AppMethodBeat.i(249902);
    Log.d("MicroMsg.HttpClientUtil", "uri=" + paramString2 + ", " + parame);
    paramString1 = new DefaultHttpClient();
    try
    {
      a(parame);
      AppMethodBeat.o(249902);
      throw null;
    }
    catch (Exception paramString2)
    {
      Log.printErrStackTrace("MicroMsg.HttpClientUtil", paramString2, "", new Object[0]);
      paramString2 = new c.f(503, null, null);
      return paramString2;
    }
    finally
    {
      paramString1.getConnectionManager().shutdown();
      AppMethodBeat.o(249902);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(249903);
    Log.d("MicroMsg.HttpClientUtil", "cancel conection.");
    if ((this.post != null) && (!this.post.isAborted())) {
      this.post.abort();
    }
    AppMethodBeat.o(249903);
  }
  
  final class a
    implements HttpEntity
  {
    public final void consumeContent()
    {
      throw null;
    }
    
    public final InputStream getContent()
    {
      AppMethodBeat.i(249630);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
      AppMethodBeat.o(249630);
      throw localUnsupportedOperationException;
    }
    
    public final Header getContentEncoding()
    {
      return null;
    }
    
    public final long getContentLength()
    {
      throw null;
    }
    
    public final Header getContentType()
    {
      AppMethodBeat.i(249627);
      BasicHeader localBasicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + a.BOUNDARY);
      AppMethodBeat.o(249627);
      return localBasicHeader;
    }
    
    public final boolean isChunked()
    {
      throw null;
    }
    
    public final boolean isRepeatable()
    {
      return true;
    }
    
    public final boolean isStreaming()
    {
      throw null;
    }
    
    public final void writeTo(OutputStream paramOutputStream)
    {
      AppMethodBeat.i(249631);
      new DataOutputStream(paramOutputStream);
      AppMethodBeat.o(249631);
      throw null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.a
 * JD-Core Version:    0.7.0.1
 */