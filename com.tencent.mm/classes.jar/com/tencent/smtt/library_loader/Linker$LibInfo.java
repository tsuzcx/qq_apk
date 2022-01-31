package com.tencent.smtt.library_loader;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Locale;

public class Linker$LibInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LibInfo> CREATOR;
  public long mLoadAddress;
  public long mLoadSize;
  public int mRelroFd;
  public long mRelroSize;
  public long mRelroStart;
  
  static
  {
    AppMethodBeat.i(138982);
    CREATOR = new Linker.LibInfo.1();
    AppMethodBeat.o(138982);
  }
  
  public Linker$LibInfo()
  {
    this.mLoadAddress = 0L;
    this.mLoadSize = 0L;
    this.mRelroStart = 0L;
    this.mRelroSize = 0L;
    this.mRelroFd = -1;
  }
  
  public Linker$LibInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(138979);
    this.mLoadAddress = paramParcel.readLong();
    this.mLoadSize = paramParcel.readLong();
    this.mRelroStart = paramParcel.readLong();
    this.mRelroSize = paramParcel.readLong();
    paramParcel = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel);
    if (paramParcel == null) {}
    for (int i = -1;; i = paramParcel.detachFd())
    {
      this.mRelroFd = i;
      AppMethodBeat.o(138979);
      return;
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(138978);
    if (this.mRelroFd >= 0) {}
    try
    {
      ParcelFileDescriptor.adoptFd(this.mRelroFd).close();
      label22:
      this.mRelroFd = -1;
      AppMethodBeat.o(138978);
      return;
    }
    catch (IOException localIOException)
    {
      break label22;
    }
  }
  
  public int describeContents()
  {
    return 1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(138981);
    String str = String.format(Locale.US, "[load=0x%x-0x%x relro=0x%x-0x%x fd=%d]", new Object[] { Long.valueOf(this.mLoadAddress), Long.valueOf(this.mLoadAddress + this.mLoadSize), Long.valueOf(this.mRelroStart), Long.valueOf(this.mRelroStart + this.mRelroSize), Integer.valueOf(this.mRelroFd) });
    AppMethodBeat.o(138981);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(138980);
    if (this.mRelroFd >= 0)
    {
      paramParcel.writeLong(this.mLoadAddress);
      paramParcel.writeLong(this.mLoadSize);
      paramParcel.writeLong(this.mRelroStart);
      paramParcel.writeLong(this.mRelroSize);
      try
      {
        ParcelFileDescriptor localParcelFileDescriptor = ParcelFileDescriptor.fromFd(this.mRelroFd);
        localParcelFileDescriptor.writeToParcel(paramParcel, 0);
        localParcelFileDescriptor.close();
        AppMethodBeat.o(138980);
        return;
      }
      catch (IOException paramParcel) {}
    }
    AppMethodBeat.o(138980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.library_loader.Linker.LibInfo
 * JD-Core Version:    0.7.0.1
 */