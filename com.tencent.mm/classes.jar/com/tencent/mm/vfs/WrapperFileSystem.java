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
  protected final T Ljf;
  
  protected WrapperFileSystem(Parcel paramParcel)
  {
    q.a(paramParcel, WrapperFileSystem.class, 1);
    this.Ljf = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.Ljf == null) {
      throw new IllegalArgumentException("Wrong wrapped filesystem.");
    }
  }
  
  protected WrapperFileSystem(T paramT)
  {
    this.Ljf = paramT;
  }
  
  public boolean CA(String paramString)
  {
    return this.Ljf.CA(paramString);
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    this.Ljf.a(paramCancellationSignal);
  }
  
  public ReadableByteChannel aYb(String paramString)
  {
    return this.Ljf.aYc(paramString);
  }
  
  public ByteChannel aYc(String paramString)
  {
    return this.Ljf.aYc(paramString);
  }
  
  public FileSystem.b aYd(String paramString)
  {
    return this.Ljf.aYd(paramString);
  }
  
  public boolean aYe(String paramString)
  {
    return this.Ljf.aYe(paramString);
  }
  
  public FileSystem.a aYf(String paramString)
  {
    return this.Ljf.aYf(paramString);
  }
  
  public final boolean aYg(String paramString)
  {
    return this.Ljf.aYg(paramString);
  }
  
  protected boolean b(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    if ((this.Ljf instanceof AbstractFileSystem)) {
      return ((AbstractFileSystem)this.Ljf).b(paramString1, paramFileSystem, paramString2);
    }
    return false;
  }
  
  public void bY(Map<String, String> paramMap)
  {
    this.Ljf.bY(paramMap);
  }
  
  public WritableByteChannel cW(String paramString, boolean paramBoolean)
  {
    return this.Ljf.cW(paramString, paramBoolean);
  }
  
  public OutputStream cX(String paramString, boolean paramBoolean)
  {
    return this.Ljf.cX(paramString, paramBoolean);
  }
  
  public Iterable<FileSystem.a> cY(String paramString, boolean paramBoolean)
  {
    return this.Ljf.cY(paramString, paramBoolean);
  }
  
  public boolean cZ(String paramString, boolean paramBoolean)
  {
    return this.Ljf.cZ(paramString, paramBoolean);
  }
  
  public boolean cn(String paramString, long paramLong)
  {
    return this.Ljf.cn(paramString, paramLong);
  }
  
  protected long d(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    if ((this.Ljf instanceof AbstractFileSystem)) {
      return ((AbstractFileSystem)this.Ljf).d(paramString1, paramFileSystem, paramString2);
    }
    return this.Ljf.c(paramString1, paramFileSystem, paramString2);
  }
  
  public String da(String paramString, boolean paramBoolean)
  {
    return this.Ljf.da(paramString, paramBoolean);
  }
  
  public int fOp()
  {
    return this.Ljf.fOp();
  }
  
  public final ParcelFileDescriptor mt(String paramString1, String paramString2)
  {
    return this.Ljf.mt(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    return this.Ljf.openRead(paramString);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.b(paramParcel, WrapperFileSystem.class, 1);
    paramParcel.writeParcelable(this.Ljf, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.WrapperFileSystem
 * JD-Core Version:    0.7.0.1
 */