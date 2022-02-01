package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class j
  implements FileSystem.b
{
  public final InputStream Tf(String paramString)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final long a(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
  {
    throw new FileNotFoundException("Path '" + paramString1 + "' not found on NullFileSystem");
  }
  
  public void a(CancellationSignal paramCancellationSignal) {}
  
  public final boolean a(String paramString1, FileSystem.b paramb, String paramString2)
  {
    return false;
  }
  
  public final FileSystem.a bBA(String paramString)
  {
    return null;
  }
  
  public final boolean bBB(String paramString)
  {
    return false;
  }
  
  public final f bBC(String paramString)
  {
    return null;
  }
  
  public final boolean bBD(String paramString)
  {
    return false;
  }
  
  public final ReadableByteChannel bBy(String paramString)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final ByteChannel bBz(String paramString)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final boolean ct(String paramString, long paramLong)
  {
    return false;
  }
  
  public final WritableByteChannel dH(String paramString, boolean paramBoolean)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final OutputStream dI(String paramString, boolean paramBoolean)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final Iterable<f> dJ(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public final boolean dK(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public final String dL(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public final boolean ho(String paramString)
  {
    return false;
  }
  
  public final int ieY()
  {
    return 28;
  }
  
  public final ParcelFileDescriptor oh(String paramString1, String paramString2)
  {
    throw new FileNotFoundException("Path '" + paramString1 + "' not found on NullFileSystem");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.j
 * JD-Core Version:    0.7.0.1
 */