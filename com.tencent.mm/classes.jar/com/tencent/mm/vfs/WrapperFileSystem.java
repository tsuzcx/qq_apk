package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;

public abstract class WrapperFileSystem<T extends FileSystem>
  extends AbstractFileSystem
{
  protected final T HRw;
  
  protected WrapperFileSystem(Parcel paramParcel)
  {
    q.a(paramParcel, WrapperFileSystem.class, 1);
    this.HRw = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.HRw == null) {
      throw new IllegalArgumentException("Wrong wrapped filesystem.");
    }
  }
  
  protected WrapperFileSystem(T paramT)
  {
    this.HRw = paramT;
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    this.HRw.a(paramCancellationSignal);
  }
  
  public ReadableByteChannel aMA(String paramString)
  {
    return this.HRw.aMB(paramString);
  }
  
  public ByteChannel aMB(String paramString)
  {
    return this.HRw.aMB(paramString);
  }
  
  public FileSystem.b aMC(String paramString)
  {
    return this.HRw.aMC(paramString);
  }
  
  public boolean aMD(String paramString)
  {
    return this.HRw.aMD(paramString);
  }
  
  public FileSystem.a aME(String paramString)
  {
    return this.HRw.aME(paramString);
  }
  
  public final boolean aMF(String paramString)
  {
    return this.HRw.aMF(paramString);
  }
  
  protected boolean b(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    if ((this.HRw instanceof AbstractFileSystem)) {
      return ((AbstractFileSystem)this.HRw).b(paramString1, paramFileSystem, paramString2);
    }
    return false;
  }
  
  public void bN(Map<String, String> paramMap)
  {
    this.HRw.bN(paramMap);
  }
  
  public WritableByteChannel cL(String paramString, boolean paramBoolean)
  {
    return this.HRw.cL(paramString, paramBoolean);
  }
  
  public OutputStream cM(String paramString, boolean paramBoolean)
  {
    return this.HRw.cM(paramString, paramBoolean);
  }
  
  public Iterable<FileSystem.a> cN(String paramString, boolean paramBoolean)
  {
    return this.HRw.cN(paramString, paramBoolean);
  }
  
  public boolean cO(String paramString, boolean paramBoolean)
  {
    return this.HRw.cO(paramString, paramBoolean);
  }
  
  public String cP(String paramString, boolean paramBoolean)
  {
    return this.HRw.cP(paramString, paramBoolean);
  }
  
  public boolean cf(String paramString, long paramLong)
  {
    return this.HRw.cf(paramString, paramLong);
  }
  
  protected long d(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    if ((this.HRw instanceof AbstractFileSystem)) {
      return ((AbstractFileSystem)this.HRw).d(paramString1, paramFileSystem, paramString2);
    }
    return this.HRw.c(paramString1, paramFileSystem, paramString2);
  }
  
  public int fhA()
  {
    return this.HRw.fhA();
  }
  
  public final ParcelFileDescriptor lw(String paramString1, String paramString2)
  {
    return this.HRw.lw(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    return this.HRw.openRead(paramString);
  }
  
  public boolean vv(String paramString)
  {
    return this.HRw.vv(paramString);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.b(paramParcel, WrapperFileSystem.class, 1);
    paramParcel.writeParcelable(this.HRw, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.WrapperFileSystem
 * JD-Core Version:    0.7.0.1
 */