package com.tencent.mm.plugin.qqmail.b;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

final class l$a
  implements HttpEntity
{
  private File file;
  private int length;
  private String ndC;
  private String ndD;
  
  public l$a(l paraml, String paramString1, String paramString2, String paramString3)
  {
    this.ndC = paramString1;
    this.file = new File(paramString2);
    this.ndD = paramString3;
    this.length = (paramString1.length() + (int)this.file.length() + paramString3.length());
  }
  
  public final void consumeContent()
  {
    if (isStreaming()) {
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }
  }
  
  public final InputStream getContent()
  {
    throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
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
    return new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + l.access$000());
  }
  
  public final boolean isChunked()
  {
    return !isRepeatable();
  }
  
  public final boolean isRepeatable()
  {
    return true;
  }
  
  public final boolean isStreaming()
  {
    return !isRepeatable();
  }
  
  public final void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream = new DataOutputStream(paramOutputStream);
    paramOutputStream.writeBytes(this.ndC);
    try
    {
      byte[] arrayOfByte = new byte[1024];
      localFileInputStream = new FileInputStream(this.file);
      try
      {
        for (;;)
        {
          int i = localFileInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        if (localFileInputStream == null) {
          break label67;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        FileInputStream localFileInputStream = null;
      }
    }
    localFileInputStream.close();
    label67:
    throw paramOutputStream;
    paramOutputStream.flush();
    localFileInputStream.close();
    paramOutputStream.writeBytes(this.ndD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.l.a
 * JD-Core Version:    0.7.0.1
 */