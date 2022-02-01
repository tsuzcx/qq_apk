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

public abstract class f
  extends a
{
  private boolean ez(String paramString, boolean paramBoolean)
  {
    String str = ah.bEv(paramString);
    if (str == null) {
      return false;
    }
    for (paramString = jk(str, 2); (paramBoolean) && ((paramString instanceof f)); paramString = ((f)paramString).jk(str, 2)) {}
    for (Object localObject = jk(str, 1); (paramBoolean) && ((localObject instanceof f)); localObject = ((f)localObject).jk(str, 1)) {}
    if ((paramString == localObject) || (paramString.bDU(str))) {
      return false;
    }
    localObject = ((FileSystem.b)localObject).bDV(str);
    if ((localObject == null) || (!((j)localObject).agxh)) {
      return false;
    }
    return paramString.bDX(str);
  }
  
  public InputStream Lh(String paramString)
  {
    FileSystem.b localb = jk(paramString, 1);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.Lh(paramString);
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
      if (ez(paramString1, true)) {
        return super.a(paramString1, paramb, paramString2, paramBoolean);
      }
      throw localFileNotFoundException;
    }
  }
  
  public void a(CancellationSignal paramCancellationSignal)
  {
    Iterator localIterator = jKf().iterator();
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
      if (ez(paramString1, true)) {
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
  
  public ReadableByteChannel bDS(String paramString)
  {
    FileSystem.b localb = jk(paramString, 1);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.bDS(paramString);
  }
  
  public ByteChannel bDT(String paramString)
  {
    FileSystem.b localb = jk(paramString, 3);
    if (localb == null) {
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    return localb.bDT(paramString);
  }
  
  public boolean bDU(String paramString)
  {
    FileSystem.b localb = jk(paramString, 1);
    return (localb != null) && (localb.bDU(paramString));
  }
  
  public j bDV(String paramString)
  {
    FileSystem.b localb = jk(paramString, 1);
    if (localb == null) {
      return null;
    }
    return localb.bDV(paramString);
  }
  
  public Iterable<j> bDW(String paramString)
  {
    List localList = jKf();
    int i = localList.size();
    if (i == 1) {
      return ((FileSystem.b)localList.get(0)).bDW(paramString);
    }
    if (i == 0) {
      return null;
    }
    return new c(new com.tencent.mm.vfs.a.a(jKf(), new a(paramString)), new b((byte)0));
  }
  
  public boolean bDX(String paramString)
  {
    FileSystem.b localb = jk(paramString, 2);
    return (localb != null) && (localb.bDX(paramString));
  }
  
  public FileSystem.a bDY(String paramString)
  {
    FileSystem.b localb = jk(paramString, 0);
    if (localb == null) {
      throw new RuntimeException("Cannot delegate path to filesystem: ".concat(String.valueOf(paramString)));
    }
    return localb.bDY(paramString);
  }
  
  public final boolean cF(String paramString, long paramLong)
  {
    FileSystem.b localb = jk(paramString, 3);
    return (localb != null) && (localb.cF(paramString, paramLong));
  }
  
  public WritableByteChannel et(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 3;; i = 2)
    {
      localb = jk(paramString, i);
      if (localb != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    if ((paramBoolean) || (jKf().size() <= 1)) {
      return localb.et(paramString, paramBoolean);
    }
    try
    {
      WritableByteChannel localWritableByteChannel = localb.et(paramString, false);
      return localWritableByteChannel;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if (ez(paramString, false)) {
        return localb.et(paramString, false);
      }
      throw localFileNotFoundException;
    }
  }
  
  public OutputStream ev(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 3;; i = 2)
    {
      localb = jk(paramString, i);
      if (localb != null) {
        break;
      }
      throw new FileNotFoundException("Path not found on any filesystems: ".concat(String.valueOf(paramString)));
    }
    if ((paramBoolean) || (jKf().size() <= 1)) {
      return localb.ev(paramString, paramBoolean);
    }
    try
    {
      OutputStream localOutputStream = localb.ev(paramString, false);
      return localOutputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if (ez(paramString, false)) {
        return localb.ev(paramString, false);
      }
      throw localFileNotFoundException;
    }
  }
  
  public final boolean ew(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = jKf().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem.b)localIterator.next()).ew(paramString, paramBoolean) | bool) {}
    return bool;
  }
  
  public final String ex(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    FileSystem.b localb;
    for (int i = 2;; i = 1)
    {
      localb = jk(paramString, i);
      if (localb != null) {
        break;
      }
      return null;
    }
    return localb.ex(paramString, paramBoolean);
  }
  
  public final boolean iP(String paramString)
  {
    Iterator localIterator = jKf().iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((FileSystem.b)localIterator.next()).iP(paramString) | bool) {}
    return bool;
  }
  
  public int jKc()
  {
    return jk("", 0).jKc();
  }
  
  public abstract List<FileSystem.b> jKf();
  
  public abstract FileSystem.b jk(String paramString, int paramInt);
  
  public ParcelFileDescriptor qf(String paramString1, String paramString2)
  {
    int i;
    if (paramString2.contains("rw")) {
      i = 3;
    }
    FileSystem.b localb;
    for (;;)
    {
      localb = jk(paramString1, i);
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
    return localb.qf(paramString1, paramString2);
  }
  
  static final class a
    implements a.a<FileSystem.b, j>
  {
    private final String mPrefix;
    
    a(String paramString)
    {
      this.mPrefix = paramString;
    }
  }
  
  static final class b
    implements c.a<j>
  {
    private final HashSet<String> agwu;
    
    private b()
    {
      AppMethodBeat.i(238184);
      this.agwu = new HashSet();
      AppMethodBeat.o(238184);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.f
 * JD-Core Version:    0.7.0.1
 */