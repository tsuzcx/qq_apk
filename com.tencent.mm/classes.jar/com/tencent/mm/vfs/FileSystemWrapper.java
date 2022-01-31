package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public abstract class FileSystemWrapper
  extends AbstractFileSystem
{
  protected final FileSystem wuw;
  
  protected FileSystemWrapper(FileSystem paramFileSystem)
  {
    this.wuw = paramFileSystem;
  }
  
  public OutputStream I(String paramString, boolean paramBoolean)
  {
    return this.wuw.I(paramString, paramBoolean);
  }
  
  public final List<FileSystem.a> J(String paramString, boolean paramBoolean)
  {
    return this.wuw.J(paramString, paramBoolean);
  }
  
  public final boolean K(String paramString, boolean paramBoolean)
  {
    return this.wuw.K(paramString, paramBoolean);
  }
  
  public final String L(String paramString, boolean paramBoolean)
  {
    return this.wuw.L(paramString, paramBoolean);
  }
  
  public final int Qd()
  {
    return this.wuw.Qd();
  }
  
  public void a(CancellationSignal paramCancellationSignal)
  {
    this.wuw.a(paramCancellationSignal);
  }
  
  public final boolean aC(String paramString1, String paramString2)
  {
    return this.wuw.aC(paramString1, paramString2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    return this.wuw.exists(paramString);
  }
  
  public final boolean jJ(String paramString)
  {
    return this.wuw.jJ(paramString);
  }
  
  public final void m(Map<String, String> paramMap)
  {
    this.wuw.m(paramMap);
  }
  
  public final FileSystem.b mZ(String paramString)
  {
    return this.wuw.mZ(paramString);
  }
  
  public final FileSystem.a na(String paramString)
  {
    return this.wuw.na(paramString);
  }
  
  public final boolean nb(String paramString)
  {
    return this.wuw.nb(paramString);
  }
  
  public InputStream openRead(String paramString)
  {
    return this.wuw.openRead(paramString);
  }
  
  public final boolean r(String paramString, long paramLong)
  {
    return this.wuw.r(paramString, paramLong);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.wuw, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemWrapper
 * JD-Core Version:    0.7.0.1
 */