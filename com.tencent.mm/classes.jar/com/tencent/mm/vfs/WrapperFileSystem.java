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
  protected final T JrA;
  
  protected WrapperFileSystem(Parcel paramParcel)
  {
    q.a(paramParcel, WrapperFileSystem.class, 1);
    this.JrA = ((FileSystem)paramParcel.readParcelable(getClass().getClassLoader()));
    if (this.JrA == null) {
      throw new IllegalArgumentException("Wrong wrapped filesystem.");
    }
  }
  
  protected WrapperFileSystem(T paramT)
  {
    this.JrA = paramT;
  }
  
  public final void a(CancellationSignal paramCancellationSignal)
  {
    this.JrA.a(paramCancellationSignal);
  }
  
  public ReadableByteChannel aSc(String paramString)
  {
    return this.JrA.aSd(paramString);
  }
  
  public ByteChannel aSd(String paramString)
  {
    return this.JrA.aSd(paramString);
  }
  
  public FileSystem.b aSe(String paramString)
  {
    return this.JrA.aSe(paramString);
  }
  
  public boolean aSf(String paramString)
  {
    return this.JrA.aSf(paramString);
  }
  
  public FileSystem.a aSg(String paramString)
  {
    return this.JrA.aSg(paramString);
  }
  
  public final boolean aSh(String paramString)
  {
    return this.JrA.aSh(paramString);
  }
  
  protected boolean b(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    if ((this.JrA instanceof AbstractFileSystem)) {
      return ((AbstractFileSystem)this.JrA).b(paramString1, paramFileSystem, paramString2);
    }
    return false;
  }
  
  public void bS(Map<String, String> paramMap)
  {
    this.JrA.bS(paramMap);
  }
  
  public WritableByteChannel cR(String paramString, boolean paramBoolean)
  {
    return this.JrA.cR(paramString, paramBoolean);
  }
  
  public OutputStream cS(String paramString, boolean paramBoolean)
  {
    return this.JrA.cS(paramString, paramBoolean);
  }
  
  public Iterable<FileSystem.a> cT(String paramString, boolean paramBoolean)
  {
    return this.JrA.cT(paramString, paramBoolean);
  }
  
  public boolean cU(String paramString, boolean paramBoolean)
  {
    return this.JrA.cU(paramString, paramBoolean);
  }
  
  public String cV(String paramString, boolean paramBoolean)
  {
    return this.JrA.cV(paramString, paramBoolean);
  }
  
  public boolean ch(String paramString, long paramLong)
  {
    return this.JrA.ch(paramString, paramLong);
  }
  
  protected long d(String paramString1, FileSystem paramFileSystem, String paramString2)
  {
    if ((this.JrA instanceof AbstractFileSystem)) {
      return ((AbstractFileSystem)this.JrA).d(paramString1, paramFileSystem, paramString2);
    }
    return this.JrA.c(paramString1, paramFileSystem, paramString2);
  }
  
  public int fxC()
  {
    return this.JrA.fxC();
  }
  
  public final ParcelFileDescriptor lT(String paramString1, String paramString2)
  {
    return this.JrA.lT(paramString1, paramString2);
  }
  
  public InputStream openRead(String paramString)
  {
    return this.JrA.openRead(paramString);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.b(paramParcel, WrapperFileSystem.class, 1);
    paramParcel.writeParcelable(this.JrA, paramInt);
  }
  
  public boolean zB(String paramString)
  {
    return this.JrA.zB(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.WrapperFileSystem
 * JD-Core Version:    0.7.0.1
 */