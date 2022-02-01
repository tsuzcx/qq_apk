package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class ab
  extends a
{
  protected final FileSystem.b Rbp;
  
  protected ab(FileSystem.b paramb)
  {
    this.Rbp = paramb;
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    this.Rbp.a(paramCancellationSignal);
  }
  
  protected boolean b(String paramString1, FileSystem.b paramb, String paramString2)
  {
    if ((this.Rbp instanceof a)) {
      return ((a)this.Rbp).b(paramString1, paramb, paramString2);
    }
    return false;
  }
  
  public final ReadableByteChannel boI(String paramString)
  {
    return this.Rbp.boJ(paramString);
  }
  
  public final ByteChannel boJ(String paramString)
  {
    return this.Rbp.boJ(paramString);
  }
  
  public final FileSystem.a boK(String paramString)
  {
    return this.Rbp.boK(paramString);
  }
  
  public final boolean boL(String paramString)
  {
    return this.Rbp.boL(paramString);
  }
  
  public final e boM(String paramString)
  {
    return this.Rbp.boM(paramString);
  }
  
  public final boolean boN(String paramString)
  {
    return this.Rbp.boN(paramString);
  }
  
  public final boolean ck(String paramString, long paramLong)
  {
    return this.Rbp.ck(paramString, paramLong);
  }
  
  protected long d(String paramString1, FileSystem.b paramb, String paramString2)
  {
    if ((this.Rbp instanceof a)) {
      return ((a)this.Rbp).d(paramString1, paramb, paramString2);
    }
    return this.Rbp.c(paramString1, paramb, paramString2);
  }
  
  public final WritableByteChannel dv(String paramString, boolean paramBoolean)
  {
    return this.Rbp.dv(paramString, paramBoolean);
  }
  
  public OutputStream dw(String paramString, boolean paramBoolean)
  {
    return this.Rbp.dw(paramString, paramBoolean);
  }
  
  public final Iterable<e> dx(String paramString, boolean paramBoolean)
  {
    return this.Rbp.dx(paramString, paramBoolean);
  }
  
  public final boolean dy(String paramString, boolean paramBoolean)
  {
    return this.Rbp.dy(paramString, paramBoolean);
  }
  
  public final String dz(String paramString, boolean paramBoolean)
  {
    return this.Rbp.dz(paramString, paramBoolean);
  }
  
  public final boolean gC(String paramString)
  {
    return this.Rbp.gC(paramString);
  }
  
  public int hdR()
  {
    return this.Rbp.hdR();
  }
  
  public final ParcelFileDescriptor nr(String paramString1, String paramString2)
  {
    return this.Rbp.nr(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    return this.Rbp.openRead(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.ab
 * JD-Core Version:    0.7.0.1
 */