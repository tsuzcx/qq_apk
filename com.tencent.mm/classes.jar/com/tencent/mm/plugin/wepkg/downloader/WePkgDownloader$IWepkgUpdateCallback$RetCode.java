package com.tencent.mm.plugin.wepkg.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum WePkgDownloader$IWepkgUpdateCallback$RetCode
  implements Parcelable
{
  public static final Parcelable.Creator<RetCode> CREATOR = new Parcelable.Creator() {};
  
  static
  {
    rOA = new RetCode("CANCEL", 5);
    rOB = new RetCode[] { rOv, rOw, rOx, rOy, rOz, rOA };
  }
  
  private WePkgDownloader$IWepkgUpdateCallback$RetCode() {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode
 * JD-Core Version:    0.7.0.1
 */