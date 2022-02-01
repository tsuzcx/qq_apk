package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.Map;

public abstract class DelegateFileSystem
  extends AbstractFileSystem
{
  public void a(CancellationSignal paramCancellationSignal)
  {
    Iterator localIterator = fhB().iterator();
    while (localIterator.hasNext())
    {
      FileSystem localFileSystem = (FileSystem)localIterator.next();
      paramCancellationSignal.throwIfCanceled();
      localFileSystem.a(paramCancellationSignal);
    }
  }
  
  public ReadableByteChannel aMA(String paramString)
  {
    FileSystem localFileSystem = gj(paramString, 1);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.aMA(paramString);
  }
  
  public ByteChannel aMB(String paramString)
  {
    FileSystem localFileSystem = gj(paramString, 3);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.aMB(paramString);
  }
  
  public FileSystem.b aMC(String paramString)
  {
    FileSystem localFileSystem = gj(paramString, 0);
    if (localFileSystem == null) {
      throw new RuntimeException("Cannot delegate path to filesystem: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.aMC(paramString);
  }
  
  public boolean aMD(String paramString)
  {
    FileSystem localFileSystem = gj(paramString, 1);
    return (localFileSystem != null) && (localFileSystem.aMD(paramString));
  }
  
  public FileSystem.a aME(String paramString)
  {
    FileSystem localFileSystem = gj(paramString, 1);
    if (localFileSystem == null) {
      return null;
    }
    return localFileSystem.aME(paramString);
  }
  
  public boolean aMF(String paramString)
  {
    FileSystem localFileSystem = gj(paramString, 2);
    return (localFileSystem != null) && (localFileSystem.aMF(paramString));
  }
  
  protected final boolean b(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    throw new AssertionError();
  }
  
  public void bN(Map<String, String> paramMap)
  {
    Iterator localIterator = fhB().iterator();
    while (localIterator.hasNext()) {
      ((FileSystem)localIterator.next()).bN(paramMap);
    }
  }
  
  public WritableByteChannel cL(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 3;; i = 2)
    {
      localFileSystem = gj(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.cL(paramString, paramBoolean);
  }
  
  public OutputStream cM(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 3;; i = 2)
    {
      localFileSystem = gj(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.cM(paramString, paramBoolean);
  }
  
  public final Iterable<FileSystem.a> cN(final String paramString, final boolean paramBoolean)
  {
    new Iterable()
    {
      public final Iterator<FileSystem.a> iterator()
      {
        AppMethodBeat.i(13092);
        q.a local1 = new q.a(DelegateFileSystem.this.fhB().iterator()) {};
        AppMethodBeat.o(13092);
        return local1;
      }
    };
  }
  
  public final boolean cO(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = fhB().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).cO(paramString, paramBoolean) | bool) {}
    return bool;
  }
  
  public final String cP(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 2;; i = 1)
    {
      localFileSystem = gj(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      return null;
    }
    return localFileSystem.cP(paramString, paramBoolean);
  }
  
  public final boolean cf(String paramString, long paramLong)
  {
    FileSystem localFileSystem = gj(paramString, 3);
    return (localFileSystem != null) && (localFileSystem.cf(paramString, paramLong));
  }
  
  protected final long d(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    throw new AssertionError();
  }
  
  public int fhA()
  {
    return gj("", 0).fhA();
  }
  
  protected abstract Iterable<FileSystem> fhB();
  
  protected abstract FileSystem gj(String paramString, int paramInt);
  
  public ParcelFileDescriptor lw(String paramString1, String paramString2)
  {
    int i;
    if (paramString2.contains("rw")) {
      i = 3;
    }
    FileSystem localFileSystem;
    for (;;)
    {
      localFileSystem = gj(paramString1, i);
      if (localFileSystem != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString1)));
      if (paramString2.contains("w")) {
        i = 2;
      } else {
        i = 1;
      }
    }
    return localFileSystem.lw(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    FileSystem localFileSystem = gj(paramString, 1);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.openRead(paramString);
  }
  
  public final boolean vv(String paramString)
  {
    Iterator localIterator = fhB().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).vv(paramString) | bool) {}
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.DelegateFileSystem
 * JD-Core Version:    0.7.0.1
 */