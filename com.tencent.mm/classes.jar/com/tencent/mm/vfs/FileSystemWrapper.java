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
  protected final FileSystem APv;
  
  protected FileSystemWrapper(FileSystem paramFileSystem)
  {
    this.APv = paramFileSystem;
  }
  
  public final boolean A(String paramString, long paramLong)
  {
    return this.APv.A(paramString, paramLong);
  }
  
  public OutputStream M(String paramString, boolean paramBoolean)
  {
    return this.APv.M(paramString, paramBoolean);
  }
  
  public final List<FileSystem.a> N(String paramString, boolean paramBoolean)
  {
    return this.APv.N(paramString, paramBoolean);
  }
  
  public final boolean O(String paramString, boolean paramBoolean)
  {
    return this.APv.O(paramString, paramBoolean);
  }
  
  public final String P(String paramString, boolean paramBoolean)
  {
    return this.APv.P(paramString, paramBoolean);
  }
  
  public void a(CancellationSignal paramCancellationSignal)
  {
    this.APv.a(paramCancellationSignal);
  }
  
  public final boolean aV(String paramString1, String paramString2)
  {
    return this.APv.aV(paramString1, paramString2);
  }
  
  public final int ajj()
  {
    return this.APv.ajj();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean exists(String paramString)
  {
    return this.APv.exists(paramString);
  }
  
  public InputStream openRead(String paramString)
  {
    return this.APv.openRead(paramString);
  }
  
  public final void q(Map<String, String> paramMap)
  {
    this.APv.q(paramMap);
  }
  
  public final boolean qD(String paramString)
  {
    return this.APv.qD(paramString);
  }
  
  public final FileSystem.b uk(String paramString)
  {
    return this.APv.uk(paramString);
  }
  
  public final FileSystem.a ul(String paramString)
  {
    return this.APv.ul(paramString);
  }
  
  public final boolean um(String paramString)
  {
    return this.APv.um(paramString);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.APv, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemWrapper
 * JD-Core Version:    0.7.0.1
 */