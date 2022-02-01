package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a.a;
import com.tencent.mm.vfs.a.c;
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

public abstract class d
  extends a
{
  private boolean dN(String paramString, boolean paramBoolean)
  {
    String str = ad.bCc(paramString);
    if (str == null) {
      return false;
    }
    for (paramString = hX(str, 2); (paramBoolean) && ((paramString instanceof d)); paramString = ((d)paramString).hX(str, 2)) {}
    for (Object localObject = hX(str, 1); (paramBoolean) && ((localObject instanceof d)); localObject = ((d)localObject).hX(str, 1)) {}
    if ((paramString == localObject) || (paramString.bBB(str))) {
      return false;
    }
    localObject = ((FileSystem.b)localObject).bBC(str);
    if ((localObject == null) || (!((f)localObject).YCj)) {
      return false;
    }
    return paramString.bBD(str);
  }
  
  public InputStream Tf(String paramString)
  {
    FileSystem.b localb = hX(paramString, 1);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.Tf(paramString);
  }
  
  public final long a(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
  {
    try
    {
      long l = super.a(paramString1, paramb, paramString2, paramBoolean);
      return l;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if (dN(paramString1, true)) {
        return super.a(paramString1, paramb, paramString2, paramBoolean);
      }
      throw localFileNotFoundException;
    }
  }
  
  public void a(CancellationSignal paramCancellationSignal)
  {
    Iterator localIterator = ifa().iterator();
    while (localIterator.hasNext())
    {
      FileSystem.b localb = (FileSystem.b)localIterator.next();
      paramCancellationSignal.throwIfCanceled();
      localb.a(paramCancellationSignal);
    }
  }
  
  public final boolean a(String paramString1, FileSystem.b paramb, String paramString2)
  {
    boolean bool2 = super.a(paramString1, paramb, paramString2);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (dN(paramString1, true)) {
        bool1 = super.a(paramString1, paramb, paramString2);
      }
    }
    return bool1;
  }
  
  protected final long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
  {
    throw new AssertionError();
  }
  
  protected final boolean b(String paramString1, FileSystem.b paramb, String paramString2)
  {
    throw new AssertionError();
  }
  
  public FileSystem.a bBA(String paramString)
  {
    FileSystem.b localb = hX(paramString, 0);
    if (localb == null) {
      throw new RuntimeException("Cannot delegate path to filesystem: ".concat(String.valueOf(paramString)));
    }
    return localb.bBA(paramString);
  }
  
  public boolean bBB(String paramString)
  {
    FileSystem.b localb = hX(paramString, 1);
    return (localb != null) && (localb.bBB(paramString));
  }
  
  public f bBC(String paramString)
  {
    FileSystem.b localb = hX(paramString, 1);
    if (localb == null) {
      return null;
    }
    return localb.bBC(paramString);
  }
  
  public boolean bBD(String paramString)
  {
    FileSystem.b localb = hX(paramString, 2);
    return (localb != null) && (localb.bBD(paramString));
  }
  
  public ReadableByteChannel bBy(String paramString)
  {
    FileSystem.b localb = hX(paramString, 1);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.bBy(paramString);
  }
  
  public ByteChannel bBz(String paramString)
  {
    FileSystem.b localb = hX(paramString, 3);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.bBz(paramString);
  }
  
  public final boolean ct(String paramString, long paramLong)
  {
    FileSystem.b localb = hX(paramString, 3);
    return (localb != null) && (localb.ct(paramString, paramLong));
  }
  
  public WritableByteChannel dH(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 3;; i = 2)
    {
      localb = hX(paramString, i);
      if (localb != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    if ((paramBoolean) || (ifa().size() <= 1)) {
      return localb.dH(paramString, paramBoolean);
    }
    try
    {
      WritableByteChannel localWritableByteChannel = localb.dH(paramString, false);
      return localWritableByteChannel;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if (dN(paramString, false)) {
        return localb.dH(paramString, false);
      }
      throw localFileNotFoundException;
    }
  }
  
  public OutputStream dI(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 3;; i = 2)
    {
      localb = hX(paramString, i);
      if (localb != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    if ((paramBoolean) || (ifa().size() <= 1)) {
      return localb.dI(paramString, paramBoolean);
    }
    try
    {
      OutputStream localOutputStream = localb.dI(paramString, false);
      return localOutputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if (dN(paramString, false)) {
        return localb.dI(paramString, false);
      }
      throw localFileNotFoundException;
    }
  }
  
  public Iterable<f> dJ(String paramString, boolean paramBoolean)
  {
    Object localObject = ifa();
    int i = ((List)localObject).size();
    if (i == 1) {
      paramString = ((FileSystem.b)((List)localObject).get(0)).dJ(paramString, paramBoolean);
    }
    do
    {
      return paramString;
      if (i == 0) {
        return null;
      }
      localObject = new c(new com.tencent.mm.vfs.a.a(ifa(), new b(paramString)), new c((byte)0));
      paramString = (String)localObject;
    } while (!paramBoolean);
    return new com.tencent.mm.vfs.a.a((Iterable)localObject, new a(ifa()));
  }
  
  public final boolean dK(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = ifa().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem.b)localIterator.next()).dK(paramString, paramBoolean) | bool) {}
    return bool;
  }
  
  public final String dL(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 2;; i = 1)
    {
      localb = hX(paramString, i);
      if (localb != null) {
        break;
      }
      return null;
    }
    return localb.dL(paramString, paramBoolean);
  }
  
  public abstract FileSystem.b hX(String paramString, int paramInt);
  
  public final boolean ho(String paramString)
  {
    Iterator localIterator = ifa().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem.b)localIterator.next()).ho(paramString) | bool) {}
    return bool;
  }
  
  public int ieY()
  {
    return hX("", 0).ieY();
  }
  
  public abstract List<FileSystem.b> ifa();
  
  public ParcelFileDescriptor oh(String paramString1, String paramString2)
  {
    int i;
    if (paramString2.contains("rw")) {
      i = 3;
    }
    FileSystem.b localb;
    for (;;)
    {
      localb = hX(paramString1, i);
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
    return localb.oh(paramString1, paramString2);
  }
  
  static final class a
    implements a.a<f, f>
  {
    private final Iterable<FileSystem.b> YBG;
    
    a(Iterable<FileSystem.b> paramIterable)
    {
      this.YBG = paramIterable;
    }
  }
  
  static final class b
    implements a.a<FileSystem.b, f>
  {
    private final String mPrefix;
    
    b(String paramString)
    {
      this.mPrefix = paramString;
    }
  }
  
  static final class c
    implements c.a<f>
  {
    private final HashSet<String> YBH;
    
    private c()
    {
      AppMethodBeat.i(235987);
      this.YBH = new HashSet();
      AppMethodBeat.o(235987);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.d
 * JD-Core Version:    0.7.0.1
 */