package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DownloadBigPkgSuccessNotify
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadBigPkgSuccessNotify> CREATOR = new DownloadBigPkgSuccessNotify.1();
  public String dCD;
  
  private DownloadBigPkgSuccessNotify(Parcel paramParcel)
  {
    this.dCD = paramParcel.readString();
  }
  
  public DownloadBigPkgSuccessNotify(String paramString)
  {
    this.dCD = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.dCD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.DownloadBigPkgSuccessNotify
 * JD-Core Version:    0.7.0.1
 */