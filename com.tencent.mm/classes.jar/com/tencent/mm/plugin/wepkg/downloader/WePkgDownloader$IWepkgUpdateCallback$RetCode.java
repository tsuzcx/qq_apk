package com.tencent.mm.plugin.wepkg.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum WePkgDownloader$IWepkgUpdateCallback$RetCode
  implements Parcelable
{
  public static final Parcelable.Creator<RetCode> CREATOR;
  
  static
  {
    AppMethodBeat.i(63437);
    vFj = new RetCode("OK", 0);
    vFk = new RetCode("LOCAL_FILE_NOT_FOUND", 1);
    vFl = new RetCode("PKG_INTEGRITY_FAILED", 2);
    vFm = new RetCode("PKG_INVALID", 3);
    vFn = new RetCode("FAILED", 4);
    vFo = new RetCode("CANCEL", 5);
    vFp = new RetCode[] { vFj, vFk, vFl, vFm, vFn, vFo };
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(63437);
  }
  
  private WePkgDownloader$IWepkgUpdateCallback$RetCode() {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(63436);
    paramParcel.writeInt(ordinal());
    AppMethodBeat.o(63436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode
 * JD-Core Version:    0.7.0.1
 */