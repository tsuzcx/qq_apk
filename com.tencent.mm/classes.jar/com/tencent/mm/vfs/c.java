package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a.a;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class c
  extends a
{
  public void a(CancellationSignal paramCancellationSignal)
  {
    Iterator localIterator = hdS().iterator();
    while (localIterator.hasNext())
    {
      FileSystem.b localb = (FileSystem.b)localIterator.next();
      paramCancellationSignal.throwIfCanceled();
      localb.a(paramCancellationSignal);
    }
  }
  
  protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
  {
    throw new AssertionError();
  }
  
  public ReadableByteChannel boI(String paramString)
  {
    FileSystem.b localb = ho(paramString, 1);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.boI(paramString);
  }
  
  public ByteChannel boJ(String paramString)
  {
    FileSystem.b localb = ho(paramString, 3);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.boJ(paramString);
  }
  
  public FileSystem.a boK(String paramString)
  {
    FileSystem.b localb = ho(paramString, 0);
    if (localb == null) {
      throw new RuntimeException("Cannot delegate path to filesystem: ".concat(String.valueOf(paramString)));
    }
    return localb.boK(paramString);
  }
  
  public boolean boL(String paramString)
  {
    FileSystem.b localb = ho(paramString, 1);
    return (localb != null) && (localb.boL(paramString));
  }
  
  public e boM(String paramString)
  {
    FileSystem.b localb = ho(paramString, 1);
    if (localb == null) {
      return null;
    }
    return localb.boM(paramString);
  }
  
  public boolean boN(String paramString)
  {
    FileSystem.b localb = ho(paramString, 2);
    return (localb != null) && (localb.boN(paramString));
  }
  
  public final boolean ck(String paramString, long paramLong)
  {
    FileSystem.b localb = ho(paramString, 3);
    return (localb != null) && (localb.ck(paramString, paramLong));
  }
  
  protected final long d(String paramString1, FileSystem.b paramb, String paramString2)
  {
    throw new AssertionError();
  }
  
  public WritableByteChannel dv(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 3;; i = 2)
    {
      localb = ho(paramString, i);
      if (localb != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.dv(paramString, paramBoolean);
  }
  
  public OutputStream dw(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 3;; i = 2)
    {
      localb = ho(paramString, i);
      if (localb != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.dw(paramString, paramBoolean);
  }
  
  public Iterable<e> dx(String paramString, boolean paramBoolean)
  {
    Object localObject = hdS();
    int i = ((List)localObject).size();
    if (i == 1) {
      paramString = ((FileSystem.b)((List)localObject).get(0)).dx(paramString, paramBoolean);
    }
    do
    {
      return paramString;
      if (i == 0) {
        return null;
      }
      localObject = new com.tencent.mm.vfs.a.c(new com.tencent.mm.vfs.a.a(hdS(), new b(paramString)), new c((byte)0));
      paramString = (String)localObject;
    } while (!paramBoolean);
    return new com.tencent.mm.vfs.a.a((Iterable)localObject, new a(hdS()));
  }
  
  public final boolean dy(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = hdS().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem.b)localIterator.next()).dy(paramString, paramBoolean) | bool) {}
    return bool;
  }
  
  public final String dz(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 2;; i = 1)
    {
      localb = ho(paramString, i);
      if (localb != null) {
        break;
      }
      return null;
    }
    return localb.dz(paramString, paramBoolean);
  }
  
  public final boolean gC(String paramString)
  {
    Iterator localIterator = hdS().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem.b)localIterator.next()).gC(paramString) | bool) {}
    return bool;
  }
  
  public int hdR()
  {
    return ho("", 0).hdR();
  }
  
  public abstract List<FileSystem.b> hdS();
  
  public abstract FileSystem.b ho(String paramString, int paramInt);
  
  public ParcelFileDescriptor nr(String paramString1, String paramString2)
  {
    int i;
    if (paramString2.contains("rw")) {
      i = 3;
    }
    FileSystem.b localb;
    for (;;)
    {
      localb = ho(paramString1, i);
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
    return localb.nr(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    FileSystem.b localb = ho(paramString, 1);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.openRead(paramString);
  }
  
  static final class a
    implements a.a<e, e>
  {
    private final Iterable<FileSystem.b> Rbm;
    
    a(Iterable<FileSystem.b> paramIterable)
    {
      this.Rbm = paramIterable;
    }
  }
  
  static final class b
    implements a.a<FileSystem.b, e>
  {
    private final String mPrefix;
    
    b(String paramString)
    {
      this.mPrefix = paramString;
    }
  }
  
  static final class c
    implements com.tencent.mm.vfs.a.c.a<e>
  {
    private final HashSet<String> Rbn;
    
    private c()
    {
      AppMethodBeat.i(187636);
      this.Rbn = new HashSet();
      AppMethodBeat.o(187636);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.c
 * JD-Core Version:    0.7.0.1
 */