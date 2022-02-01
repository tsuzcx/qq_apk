package com.tencent.mm.sdk.http;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public class HttpClientUploadWrapper
  extends HttpWrapperBase
{
  private static final String BOUNDARY;
  private static final int CHUNK_LEN = 1024;
  private static final String FIX = "--";
  private static final String MULTIPART_FORM_DATA = "multipart/form-data";
  private static final String NEW_LINE = "\r\n";
  private static final String TAG = "MicroMsg.HttpClientWrapper";
  private HttpClient client;
  private HttpPost post;
  
  static
  {
    AppMethodBeat.i(187828);
    BOUNDARY = "WEIXIN" + System.currentTimeMillis();
    AppMethodBeat.o(187828);
  }
  
  public HttpClientUploadWrapper(HttpClient paramHttpClient)
  {
    this.client = paramHttpClient;
  }
  
  private String genNextPart(HttpWrapperBase.Request paramRequest)
  {
    AppMethodBeat.i(187826);
    paramRequest = new StringBuilder();
    paramRequest.append("\r\n");
    paramRequest.append("------" + BOUNDARY + "--\r\n");
    paramRequest = paramRequest.toString();
    AppMethodBeat.o(187826);
    return paramRequest;
  }
  
  private String genPrePart(HttpWrapperBase.Request paramRequest)
  {
    AppMethodBeat.i(187825);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramRequest.params.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append("------" + BOUNDARY + "\r\n");
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n");
      localStringBuilder.append("\r\n");
      localStringBuilder.append((String)paramRequest.params.get(str));
      localStringBuilder.append("\r\n");
    }
    localObject = new q(paramRequest.attachment.filePath);
    if (!((q)localObject).ifH())
    {
      paramRequest = new InvalidParameterException("The path to upload isnot a file.");
      AppMethodBeat.o(187825);
      throw paramRequest;
    }
    localObject = ((q)localObject).getName();
    localStringBuilder.append("------" + BOUNDARY + "\r\n");
    localStringBuilder.append("Content-Disposition: form-data; name=\"" + paramRequest.attachment.param + "\"; filename=\"" + (String)localObject + "\"\r\n");
    localStringBuilder.append("\r\n");
    paramRequest = localStringBuilder.toString();
    AppMethodBeat.o(187825);
    return paramRequest;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(187824);
    Log.d("MicroMsg.HttpClientWrapper", "cancel conection.");
    if ((this.post != null) && (!this.post.isAborted())) {
      this.post.abort();
    }
    this.client.getConnectionManager().shutdown();
    AppMethodBeat.o(187824);
  }
  
  public void send(HttpWrapperBase.Request paramRequest, HttpWrapperBase.Response paramResponse)
  {
    int j = 0;
    AppMethodBeat.i(187823);
    Log.d("MicroMsg.HttpClientWrapper", "request: %s", new Object[] { paramRequest });
    int i = j;
    try
    {
      Object localObject = new FileUploadEntity(genPrePart(paramRequest), paramRequest.attachment.filePath, genNextPart(paramRequest));
      i = j;
      this.post = new HttpPost(paramRequest.getUrl());
      i = j;
      this.post.setHeader("User-Agent", "weixin/android");
      i = j;
      this.post.setHeader("Host", paramRequest.host);
      i = j;
      this.post.setHeader("Connection", "Keep-Alive");
      i = j;
      this.post.setHeader("Accept-Charset", "utf-8");
      i = j;
      this.post.setHeader("Cookie", getCookie(paramRequest.cookie));
      i = j;
      this.post.setEntity((HttpEntity)localObject);
      i = j;
      localObject = this.client.execute(this.post);
      i = j;
      j = ((HttpResponse)localObject).getStatusLine().getStatusCode();
      i = j;
      paramRequest = ((HttpResponse)localObject).getEntity();
      i = j;
      localObject = ((HttpResponse)localObject).getFirstHeader("set-cookie").getValue();
      i = j;
      paramRequest = EntityUtils.toString(paramRequest);
      i = j;
      paramResponse.status = j;
      i = j;
      paramResponse.cookie = parseCookie((String)localObject);
      i = j;
      paramResponse.content = paramRequest;
      i = j;
      Log.d("MicroMsg.HttpClientWrapper", "response: %s", new Object[] { paramResponse });
      return;
    }
    catch (Exception paramRequest)
    {
      Log.printErrStackTrace("MicroMsg.HttpClientWrapper", paramRequest, "", new Object[0]);
      Log.printErrStackTrace("MicroMsg.HttpClientWrapper", paramRequest, "", new Object[0]);
      j = i;
      if (i == 0) {
        j = 503;
      }
      paramResponse.status = j;
      return;
    }
    finally
    {
      this.client.getConnectionManager().shutdown();
      AppMethodBeat.o(187823);
    }
  }
  
  class FileUploadEntity
    implements HttpEntity
  {
    private q file;
    private int length;
    private String nextPart;
    private String prePart;
    
    public FileUploadEntity(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(186400);
      this.prePart = paramString1;
      this.file = new q(paramString2);
      this.nextPart = paramString3;
      this.length = (paramString1.length() + (int)this.file.length() + paramString3.length());
      AppMethodBeat.o(186400);
    }
    
    public void consumeContent()
    {
      AppMethodBeat.i(186419);
      if (isStreaming())
      {
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        AppMethodBeat.o(186419);
        throw localUnsupportedOperationException;
      }
      AppMethodBeat.o(186419);
    }
    
    public InputStream getContent()
    {
      AppMethodBeat.i(186413);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
      AppMethodBeat.o(186413);
      throw localUnsupportedOperationException;
    }
    
    public Header getContentEncoding()
    {
      return null;
    }
    
    public long getContentLength()
    {
      return this.length;
    }
    
    public Header getContentType()
    {
      AppMethodBeat.i(186408);
      BasicHeader localBasicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + HttpClientUploadWrapper.BOUNDARY);
      AppMethodBeat.o(186408);
      return localBasicHeader;
    }
    
    public boolean isChunked()
    {
      AppMethodBeat.i(186402);
      if (!isRepeatable())
      {
        AppMethodBeat.o(186402);
        return true;
      }
      AppMethodBeat.o(186402);
      return false;
    }
    
    public boolean isRepeatable()
    {
      return true;
    }
    
    public boolean isStreaming()
    {
      AppMethodBeat.i(186404);
      if (!isRepeatable())
      {
        AppMethodBeat.o(186404);
        return true;
      }
      AppMethodBeat.o(186404);
      return false;
    }
    
    public void writeTo(OutputStream paramOutputStream)
    {
      AppMethodBeat.i(186418);
      DataOutputStream localDataOutputStream = new DataOutputStream(paramOutputStream);
      localDataOutputStream.writeBytes(this.prePart);
      InputStream localInputStream = null;
      paramOutputStream = localInputStream;
      try
      {
        byte[] arrayOfByte = new byte[1024];
        paramOutputStream = localInputStream;
        localInputStream = u.al(this.file);
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
        AppMethodBeat.o(186418);
      }
      localDataOutputStream.flush();
      if (localObject != null) {
        localObject.close();
      }
      localDataOutputStream.writeBytes(this.nextPart);
      AppMethodBeat.o(186418);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.http.HttpClientUploadWrapper
 * JD-Core Version:    0.7.0.1
 */