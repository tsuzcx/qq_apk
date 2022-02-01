package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class x
  extends a
{
  protected final FileSystem.b LFY;
  
  protected x(FileSystem.b paramb)
  {
    this.LFY = paramb;
  }
  
  public final boolean Dc(String paramString)
  {
    return this.LFY.Dc(paramString);
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    this.LFY.a(paramCancellationSignal);
  }
  
  public final ReadableByteChannel aZD(String paramString)
  {
    return this.LFY.aZE(paramString);
  }
  
  public final ByteChannel aZE(String paramString)
  {
    return this.LFY.aZE(paramString);
  }
  
  public final FileSystem.a aZF(String paramString)
  {
    return this.LFY.aZF(paramString);
  }
  
  public final boolean aZG(String paramString)
  {
    return this.LFY.aZG(paramString);
  }
  
  public final c aZH(String paramString)
  {
    return this.LFY.aZH(paramString);
  }
  
  public final boolean aZI(String paramString)
  {
    return this.LFY.aZI(paramString);
  }
  
  protected boolean b(String paramString1, FileSystem.b paramb, String paramString2)
  {
    if ((this.LFY instanceof a)) {
      return ((a)this.LFY).b(paramString1, paramb, paramString2);
    }
    return false;
  }
  
  public final boolean cp(String paramString, long paramLong)
  {
    return this.LFY.cp(paramString, paramLong);
  }
  
  protected long d(String paramString1, FileSystem.b paramb, String paramString2)
  {
    if ((this.LFY instanceof a)) {
      return ((a)this.LFY).d(paramString1, paramb, paramString2);
    }
    return this.LFY.c(paramString1, paramb, paramString2);
  }
  
  public final WritableByteChannel da(String paramString, boolean paramBoolean)
  {
    return this.LFY.da(paramString, paramBoolean);
  }
  
  public OutputStream db(String paramString, boolean paramBoolean)
  {
    return this.LFY.db(paramString, paramBoolean);
  }
  
  public final Iterable<c> dc(String paramString, boolean paramBoolean)
  {
    return this.LFY.dc(paramString, paramBoolean);
  }
  
  public final boolean dd(String paramString, boolean paramBoolean)
  {
    return this.LFY.dd(paramString, paramBoolean);
  }
  
  public final String de(String paramString, boolean paramBoolean)
  {
    return this.LFY.de(paramString, paramBoolean);
  }
  
  public int fSL()
  {
    return this.LFY.fSL();
  }
  
  public final ParcelFileDescriptor mA(String paramString1, String paramString2)
  {
    return this.LFY.mA(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    return this.LFY.openRead(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.x
 * JD-Core Version:    0.7.0.1
 */