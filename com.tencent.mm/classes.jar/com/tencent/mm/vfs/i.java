package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class i
  implements FileSystem.b
{
  public void a(CancellationSignal paramCancellationSignal) {}
  
  public final boolean a(String paramString1, FileSystem.b paramb, String paramString2)
  {
    return false;
  }
  
  public final ReadableByteChannel boI(String paramString)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final ByteChannel boJ(String paramString)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final FileSystem.a boK(String paramString)
  {
    return null;
  }
  
  public final boolean boL(String paramString)
  {
    return false;
  }
  
  public final e boM(String paramString)
  {
    return null;
  }
  
  public final boolean boN(String paramString)
  {
    return false;
  }
  
  public final long c(String paramString1, FileSystem.b paramb, String paramString2)
  {
    throw new FileNotFoundException("Path '" + paramString1 + "' not found on NullFileSystem");
  }
  
  public final boolean ck(String paramString, long paramLong)
  {
    return false;
  }
  
  public final WritableByteChannel dv(String paramString, boolean paramBoolean)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final OutputStream dw(String paramString, boolean paramBoolean)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final Iterable<e> dx(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public final boolean dy(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public final String dz(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public final boolean gC(String paramString)
  {
    return false;
  }
  
  public final int hdR()
  {
    return 28;
  }
  
  public final ParcelFileDescriptor nr(String paramString1, String paramString2)
  {
    throw new FileNotFoundException("Path '" + paramString1 + "' not found on NullFileSystem");
  }
  
  public final InputStream openRead(String paramString)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.i
 * JD-Core Version:    0.7.0.1
 */