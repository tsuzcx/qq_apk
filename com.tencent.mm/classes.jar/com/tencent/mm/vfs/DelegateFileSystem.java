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
  public boolean CA(String paramString)
  {
    Iterator localIterator = fOq().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).CA(paramString) | bool) {}
    return bool;
  }
  
  public void a(CancellationSignal paramCancellationSignal)
  {
    Iterator localIterator = fOq().iterator();
    while (localIterator.hasNext())
    {
      FileSystem localFileSystem = (FileSystem)localIterator.next();
      paramCancellationSignal.throwIfCanceled();
      localFileSystem.a(paramCancellationSignal);
    }
  }
  
  public ReadableByteChannel aYb(String paramString)
  {
    FileSystem localFileSystem = gK(paramString, 1);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.aYb(paramString);
  }
  
  public ByteChannel aYc(String paramString)
  {
    FileSystem localFileSystem = gK(paramString, 3);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.aYc(paramString);
  }
  
  public FileSystem.b aYd(String paramString)
  {
    FileSystem localFileSystem = gK(paramString, 0);
    if (localFileSystem == null) {
      throw new RuntimeException("Cannot delegate path to filesystem: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.aYd(paramString);
  }
  
  public boolean aYe(String paramString)
  {
    FileSystem localFileSystem = gK(paramString, 1);
    return (localFileSystem != null) && (localFileSystem.aYe(paramString));
  }
  
  public FileSystem.a aYf(String paramString)
  {
    FileSystem localFileSystem = gK(paramString, 1);
    if (localFileSystem == null) {
      return null;
    }
    return localFileSystem.aYf(paramString);
  }
  
  public boolean aYg(String paramString)
  {
    FileSystem localFileSystem = gK(paramString, 2);
    return (localFileSystem != null) && (localFileSystem.aYg(paramString));
  }
  
  protected final boolean b(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    throw new AssertionError();
  }
  
  public void bY(Map<String, String> paramMap)
  {
    Iterator localIterator = fOq().iterator();
    while (localIterator.hasNext()) {
      ((FileSystem)localIterator.next()).bY(paramMap);
    }
  }
  
  public WritableByteChannel cW(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 3;; i = 2)
    {
      localFileSystem = gK(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.cW(paramString, paramBoolean);
  }
  
  public OutputStream cX(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 3;; i = 2)
    {
      localFileSystem = gK(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.cX(paramString, paramBoolean);
  }
  
  public final Iterable<FileSystem.a> cY(final String paramString, final boolean paramBoolean)
  {
    new Iterable()
    {
      public final Iterator<FileSystem.a> iterator()
      {
        AppMethodBeat.i(13092);
        q.a local1 = new q.a(DelegateFileSystem.this.fOq().iterator()) {};
        AppMethodBeat.o(13092);
        return local1;
      }
    };
  }
  
  public boolean cZ(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = fOq().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem)localIterator.next()).cZ(paramString, paramBoolean) | bool) {}
    return bool;
  }
  
  public final boolean cn(String paramString, long paramLong)
  {
    FileSystem localFileSystem = gK(paramString, 3);
    return (localFileSystem != null) && (localFileSystem.cn(paramString, paramLong));
  }
  
  protected final long d(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    throw new AssertionError();
  }
  
  public final String da(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem localFileSystem;
    for (int i = 2;; i = 1)
    {
      localFileSystem = gK(paramString, i);
      if (localFileSystem != null) {
        break;
      }
      return null;
    }
    return localFileSystem.da(paramString, paramBoolean);
  }
  
  public int fOp()
  {
    return gK("", 0).fOp();
  }
  
  protected abstract Iterable<FileSystem> fOq();
  
  protected abstract FileSystem gK(String paramString, int paramInt);
  
  public ParcelFileDescriptor mt(String paramString1, String paramString2)
  {
    int i;
    if (paramString2.contains("rw")) {
      i = 3;
    }
    FileSystem localFileSystem;
    for (;;)
    {
      localFileSystem = gK(paramString1, i);
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
    return localFileSystem.mt(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    FileSystem localFileSystem = gK(paramString, 1);
    if (localFileSystem == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localFileSystem.openRead(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.DelegateFileSystem
 * JD-Core Version:    0.7.0.1
 */