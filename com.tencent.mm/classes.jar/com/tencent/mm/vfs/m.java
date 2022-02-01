package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class m
  implements FileSystem.b
{
  public final InputStream Lh(String paramString)
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
  
  public final ReadableByteChannel bDS(String paramString)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final ByteChannel bDT(String paramString)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final boolean bDU(String paramString)
  {
    return false;
  }
  
  public final j bDV(String paramString)
  {
    return null;
  }
  
  public final Iterable<j> bDW(String paramString)
  {
    return null;
  }
  
  public final boolean bDX(String paramString)
  {
    return false;
  }
  
  public final FileSystem.a bDY(String paramString)
  {
    return null;
  }
  
  public final boolean cF(String paramString, long paramLong)
  {
    return false;
  }
  
  public final WritableByteChannel et(String paramString, boolean paramBoolean)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final OutputStream ev(String paramString, boolean paramBoolean)
  {
    throw new FileNotFoundException("Path '" + paramString + "' not found on NullFileSystem");
  }
  
  public final boolean ew(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public final String ex(String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public final boolean iP(String paramString)
  {
    return false;
  }
  
  public final int jKc()
  {
    return 28;
  }
  
  public final ParcelFileDescriptor qf(String paramString1, String paramString2)
  {
    throw new FileNotFoundException("Path '" + paramString1 + "' not found on NullFileSystem");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.m
 * JD-Core Version:    0.7.0.1
 */