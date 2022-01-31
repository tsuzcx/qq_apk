package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private String pIT;
  private String pIU;
  
  public l$a(l paraml, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(67944);
    this.pIT = paramString1;
    this.file = new File(paramString2);
    this.pIU = paramString3;
    this.length = (paramString1.length() + (int)this.file.length() + paramString3.length());
    AppMethodBeat.o(67944);
  }
  
  public final void consumeContent()
  {
    AppMethodBeat.i(67950);
    if (isStreaming())
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
      AppMethodBeat.o(67950);
      throw localUnsupportedOperationException;
    }
    AppMethodBeat.o(67950);
  }
  
  public final InputStream getContent()
  {
    AppMethodBeat.i(67948);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    AppMethodBeat.o(67948);
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
    AppMethodBeat.i(67947);
    BasicHeader localBasicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + l.access$000());
    AppMethodBeat.o(67947);
    return localBasicHeader;
  }
  
  public final boolean isChunked()
  {
    AppMethodBeat.i(67945);
    if (!isRepeatable())
    {
      AppMethodBeat.o(67945);
      return true;
    }
    AppMethodBeat.o(67945);
    return false;
  }
  
  public final boolean isRepeatable()
  {
    return true;
  }
  
  public final boolean isStreaming()
  {
    AppMethodBeat.i(67946);
    if (!isRepeatable())
    {
      AppMethodBeat.o(67946);
      return true;
    }
    AppMethodBeat.o(67946);
    return false;
  }
  
  public final void writeTo(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(67949);
    paramOutputStream = new DataOutputStream(paramOutputStream);
    paramOutputStream.writeBytes(this.pIT);
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
          break label72;
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
    label72:
    AppMethodBeat.o(67949);
    throw paramOutputStream;
    paramOutputStream.flush();
    localFileInputStream.close();
    paramOutputStream.writeBytes(this.pIU);
    AppMethodBeat.o(67949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.l.a
 * JD-Core Version:    0.7.0.1
 */