package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class ai
  extends a
{
  protected final FileSystem.b agwv;
  
  protected ai(FileSystem.b paramb)
  {
    this.agwv = paramb;
  }
  
  public InputStream Lh(String paramString)
  {
    return this.agwv.Lh(paramString);
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    this.agwv.a(paramCancellationSignal);
  }
  
  protected long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
  {
    return this.agwv.a(paramString1, paramb, paramString2, paramBoolean);
  }
  
  protected boolean b(String paramString1, FileSystem.b paramb, String paramString2)
  {
    return this.agwv.a(paramString1, paramb, paramString2);
  }
  
  public ReadableByteChannel bDS(String paramString)
  {
    return this.agwv.bDT(paramString);
  }
  
  public ByteChannel bDT(String paramString)
  {
    return this.agwv.bDT(paramString);
  }
  
  public boolean bDU(String paramString)
  {
    return this.agwv.bDU(paramString);
  }
  
  public j bDV(String paramString)
  {
    return this.agwv.bDV(paramString);
  }
  
  public Iterable<j> bDW(String paramString)
  {
    return this.agwv.bDW(paramString);
  }
  
  public boolean bDX(String paramString)
  {
    return this.agwv.bDX(paramString);
  }
  
  public final FileSystem.a bDY(String paramString)
  {
    return this.agwv.bDY(paramString);
  }
  
  public boolean cF(String paramString, long paramLong)
  {
    return this.agwv.cF(paramString, paramLong);
  }
  
  public WritableByteChannel et(String paramString, boolean paramBoolean)
  {
    return this.agwv.et(paramString, paramBoolean);
  }
  
  public OutputStream ev(String paramString, boolean paramBoolean)
  {
    return this.agwv.ev(paramString, paramBoolean);
  }
  
  public boolean ew(String paramString, boolean paramBoolean)
  {
    return this.agwv.ew(paramString, paramBoolean);
  }
  
  public String ex(String paramString, boolean paramBoolean)
  {
    return this.agwv.ex(paramString, paramBoolean);
  }
  
  public boolean iP(String paramString)
  {
    return this.agwv.iP(paramString);
  }
  
  public int jKc()
  {
    return this.agwv.jKc();
  }
  
  public ParcelFileDescriptor qf(String paramString1, String paramString2)
  {
    return this.agwv.qf(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.ai
 * JD-Core Version:    0.7.0.1
 */