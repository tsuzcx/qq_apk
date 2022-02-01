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
    Iterator localIterator = fxD().iterator();
    while (localIterator.hasNext())
    {
      FileSystem localFileSystem = (FileSystem)localIterator.next();
      paramCancellationSignal.throwIfCanceled();
      localFileSystem.a(paramCancellationSignal);
    }
  }
  
  public ReadableByteChannel aSc(String paramString)
  {
    FileSystem localFileSystem = gn(paramString, 1);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.aSc(paramString);
  }
  
  public ByteChannel aSd(String paramString)
  {
    FileSystem localFileSystem = gn(paramString, 3);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.aSd(paramString);
  }
  
  public FileSystem.b aSe(String paramString)
  {
    FileSystem localFileSystem = gn(paramString, 0);
    if (localFileSystem == null) {
      throw new RuntimeException("Cannot delegate path to filesystem: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.aSe(paramString);
  }
  
  public boolean aSf(String paramString)
  {
    FileSystem localFileSystem = gn(paramString, 1);
    return (localFileSystem != null) && (localFileSystem.aSf(paramString));
  }
  
  public FileSystem.a aSg(String paramString)
  {
    FileSystem localFileSystem = gn(paramString, 1);
    if (localFileSystem == null) {
      return null;
    }
    return localFileSystem.aSg(paramString);
  }
  
  public boolean aSh(String paramString)
  {
    FileSystem localFileSystem = gn(paramString, 2);
    return (localFileSystem != null) && (localFileSystem.aSh(paramString));
  }
  
  protected final boolean b(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    throw new AssertionError();
  }
  
  public void bS(Map<String, String> paramMap)
  {
    Iterator localIterator = fxD().iterator();
    while (localIterator.hasNext()) {
      ((FileSystem)localIterator.next()).bS(paramMap);
    }
  }
  
  public WritableByteChannel cR(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 3;; i = 2)
    {
      localFileSystem = gn(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.cR(paramString, paramBoolean);
  }
  
  public OutputStream cS(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 3;; i = 2)
    {
      localFileSystem = gn(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.cS(paramString, paramBoolean);
  }
  
  public final Iterable<FileSystem.a> cT(final String paramString, final boolean paramBoolean)
  {
    new Iterable()
    {
      public final Iterator<FileSystem.a> iterator()
      {
        AppMethodBeat.i(13092);
        q.a local1 = new q.a(DelegateFileSystem.this.fxD().iterator()) {};
        AppMethodBeat.o(13092);
        return local1;
      }
    };
  }
  
  public boolean cU(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = fxD().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).cU(paramString, paramBoolean) | bool) {}
    return bool;
  }
  
  public final String cV(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 2;; i = 1)
    {
      localFileSystem = gn(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      return null;
    }
    return localFileSystem.cV(paramString, paramBoolean);
  }
  
  public final boolean ch(String paramString, long paramLong)
  {
    FileSystem localFileSystem = gn(paramString, 3);
    return (localFileSystem != null) && (localFileSystem.ch(paramString, paramLong));
  }
  
  protected final long d(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    throw new AssertionError();
  }
  
  public int fxC()
  {
    return gn("", 0).fxC();
  }
  
  protected abstract Iterable<FileSystem> fxD();
  
  protected abstract FileSystem gn(String paramString, int paramInt);
  
  public ParcelFileDescriptor lT(String paramString1, String paramString2)
  {
    int i;
    if (paramString2.contains("rw")) {
      i = 3;
    }
    FileSystem localFileSystem;
    for (;;)
    {
      localFileSystem = gn(paramString1, i);
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
    return localFileSystem.lT(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    FileSystem localFileSystem = gn(paramString, 1);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.openRead(paramString);
  }
  
  public boolean zB(String paramString)
  {
    Iterator localIterator = fxD().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).zB(paramString) | bool) {}
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.DelegateFileSystem
 * JD-Core Version:    0.7.0.1
 */