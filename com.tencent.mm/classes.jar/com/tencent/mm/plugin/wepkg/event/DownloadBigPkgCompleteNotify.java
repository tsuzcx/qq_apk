package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DownloadBigPkgCompleteNotify
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadBigPkgCompleteNotify> CREATOR;
  public String ezY;
  public boolean success;
  
  static
  {
    AppMethodBeat.i(63459);
    CREATOR = new DownloadBigPkgCompleteNotify.1();
    AppMethodBeat.o(63459);
  }
  
  private DownloadBigPkgCompleteNotify(Parcel paramParcel)
  {
    AppMethodBeat.i(63458);
    this.ezY = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.success = bool;
      AppMethodBeat.o(63458);
      return;
      bool = false;
    }
  }
  
  public DownloadBigPkgCompleteNotify(String paramString, boolean paramBoolean)
  {
    this.ezY = paramString;
    this.success = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(63457);
    paramParcel.writeString(this.ezY);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(63457);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify
 * JD-Core Version:    0.7.0.1
 */