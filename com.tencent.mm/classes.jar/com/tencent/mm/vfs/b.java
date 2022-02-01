package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a.a;
import com.tencent.mm.vfs.a.c.a;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class b
  extends a
{
  public final boolean Dc(String paramString)
  {
    Iterator localIterator = fSM().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem.b)localIterator.next()).Dc(paramString) | bool) {}
    return bool;
  }
  
  public void a(CancellationSignal paramCancellationSignal)
  {
    Iterator localIterator = fSM().iterator();
    while (localIterator.hasNext())
    {
      FileSystem.b localb = (FileSystem.b)localIterator.next();
      paramCancellationSignal.throwIfCanceled();
      localb.a(paramCancellationSignal);
    }
  }
  
  public ReadableByteChannel aZD(String paramString)
  {
    FileSystem.b localb = gU(paramString, 1);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.aZD(paramString);
  }
  
  public ByteChannel aZE(String paramString)
  {
    FileSystem.b localb = gU(paramString, 3);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.aZE(paramString);
  }
  
  public FileSystem.a aZF(String paramString)
  {
    FileSystem.b localb = gU(paramString, 0);
    if (localb == null) {
      throw new RuntimeException("Cannot delegate path to filesystem: ".concat(String.valueOf(paramString)));
    }
    return localb.aZF(paramString);
  }
  
  public boolean aZG(String paramString)
  {
    FileSystem.b localb = gU(paramString, 1);
    return (localb != null) && (localb.aZG(paramString));
  }
  
  public c aZH(String paramString)
  {
    FileSystem.b localb = gU(paramString, 1);
    if (localb == null) {
      return null;
    }
    return localb.aZH(paramString);
  }
  
  public boolean aZI(String paramString)
  {
    FileSystem.b localb = gU(paramString, 2);
    return (localb != null) && (localb.aZI(paramString));
  }
  
  protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
  {
    throw new AssertionError();
  }
  
  public final boolean cp(String paramString, long paramLong)
  {
    FileSystem.b localb = gU(paramString, 3);
    return (localb != null) && (localb.cp(paramString, paramLong));
  }
  
  protected final long d(String paramString1, FileSystem.b paramb, String paramString2)
  {
    throw new AssertionError();
  }
  
  public WritableByteChannel da(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 3;; i = 2)
    {
      localb = gU(paramString, i);
      if (localb != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.da(paramString, paramBoolean);
  }
  
  public OutputStream db(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 3;; i = 2)
    {
      localb = gU(paramString, i);
      if (localb != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.db(paramString, paramBoolean);
  }
  
  public final Iterable<c> dc(String paramString, boolean paramBoolean)
  {
    Object localObject = fSM();
    if (((List)localObject).size() == 1) {
      paramString = ((FileSystem.b)((List)localObject).get(0)).dc(paramString, paramBoolean);
    }
    do
    {
      return paramString;
      localObject = new com.tencent.mm.vfs.a.c(new com.tencent.mm.vfs.a.a(fSM(), new b(paramString)), new c((byte)0));
      paramString = (String)localObject;
    } while (!paramBoolean);
    return new com.tencent.mm.vfs.a.a((Iterable)localObject, new a(fSM()));
  }
  
  public final boolean dd(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = fSM().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem.b)localIterator.next()).dd(paramString, paramBoolean) | bool) {}
    return bool;
  }
  
  public final String de(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 2;; i = 1)
    {
      localb = gU(paramString, i);
      if (localb != null) {
        break;
      }
      return null;
    }
    return localb.de(paramString, paramBoolean);
  }
  
  public int fSL()
  {
    return gU("", 0).fSL();
  }
  
  public abstract List<FileSystem.b> fSM();
  
  public abstract FileSystem.b gU(String paramString, int paramInt);
  
  public ParcelFileDescriptor mA(String paramString1, String paramString2)
  {
    int i;
    if (paramString2.contains("rw")) {
      i = 3;
    }
    FileSystem.b localb;
    for (;;)
    {
      localb = gU(paramString1, i);
      if (localb != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString1)));
      if (paramString2.contains("w")) {
        i = 2;
      } else {
        i = 1;
      }
    }
    return localb.mA(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    FileSystem.b localb = gU(paramString, 1);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.openRead(paramString);
  }
  
  static final class a
    implements a.a<c, c>
  {
    private final Iterable<FileSystem.b> LFV;
    
    a(Iterable<FileSystem.b> paramIterable)
    {
      this.LFV = paramIterable;
    }
  }
  
  static final class b
    implements a.a<FileSystem.b, c>
  {
    private final String mPrefix;
    
    b(String paramString)
    {
      this.mPrefix = paramString;
    }
  }
  
  static final class c
    implements c.a<c>
  {
    private final HashSet<String> LFW;
    
    private c()
    {
      AppMethodBeat.i(193363);
      this.LFW = new HashSet();
      AppMethodBeat.o(193363);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.b
 * JD-Core Version:    0.7.0.1
 */