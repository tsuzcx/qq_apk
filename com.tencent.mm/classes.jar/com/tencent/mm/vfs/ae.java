package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class ae
  extends a
{
  protected final FileSystem.b YBJ;
  
  protected ae(FileSystem.b paramb)
  {
    this.YBJ = paramb;
  }
  
  public InputStream Tf(String paramString)
  {
    return this.YBJ.Tf(paramString);
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    this.YBJ.a(paramCancellationSignal);
  }
  
  protected long b(String paramString1, FileSystem.b paramb, String paramString2, boolean paramBoolean)
  {
    if ((this.YBJ instanceof a)) {
      return ((a)this.YBJ).b(paramString1, paramb, paramString2, paramBoolean);
    }
    return this.YBJ.a(paramString1, paramb, paramString2, paramBoolean);
  }
  
  protected boolean b(String paramString1, FileSystem.b paramb, String paramString2)
  {
    if ((this.YBJ instanceof a)) {
      return ((a)this.YBJ).b(paramString1, paramb, paramString2);
    }
    return false;
  }
  
  public final FileSystem.a bBA(String paramString)
  {
    return this.YBJ.bBA(paramString);
  }
  
  public final boolean bBB(String paramString)
  {
    return this.YBJ.bBB(paramString);
  }
  
  public final f bBC(String paramString)
  {
    return this.YBJ.bBC(paramString);
  }
  
  public final boolean bBD(String paramString)
  {
    return this.YBJ.bBD(paramString);
  }
  
  public final ReadableByteChannel bBy(String paramString)
  {
    return this.YBJ.bBz(paramString);
  }
  
  public final ByteChannel bBz(String paramString)
  {
    return this.YBJ.bBz(paramString);
  }
  
  public final boolean ct(String paramString, long paramLong)
  {
    return this.YBJ.ct(paramString, paramLong);
  }
  
  public final WritableByteChannel dH(String paramString, boolean paramBoolean)
  {
    return this.YBJ.dH(paramString, paramBoolean);
  }
  
  public OutputStream dI(String paramString, boolean paramBoolean)
  {
    return this.YBJ.dI(paramString, paramBoolean);
  }
  
  public final Iterable<f> dJ(String paramString, boolean paramBoolean)
  {
    return this.YBJ.dJ(paramString, paramBoolean);
  }
  
  public final boolean dK(String paramString, boolean paramBoolean)
  {
    return this.YBJ.dK(paramString, paramBoolean);
  }
  
  public final String dL(String paramString, boolean paramBoolean)
  {
    return this.YBJ.dL(paramString, paramBoolean);
  }
  
  public final boolean ho(String paramString)
  {
    return this.YBJ.ho(paramString);
  }
  
  public int ieY()
  {
    return this.YBJ.ieY();
  }
  
  public final ParcelFileDescriptor oh(String paramString1, String paramString2)
  {
    return this.YBJ.oh(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.ae
 * JD-Core Version:    0.7.0.1
 */