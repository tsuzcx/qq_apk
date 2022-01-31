package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WePkgDiffInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WePkgDiffInfo> CREATOR;
  public String cqq;
  public String downloadUrl;
  public String ezY;
  public int fileSize;
  public String vFR;
  public String vFS;
  public int vFT;
  public String version;
  
  static
  {
    AppMethodBeat.i(63524);
    CREATOR = new WePkgDiffInfo.1();
    AppMethodBeat.o(63524);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(63523);
    paramParcel.writeString(this.ezY);
    paramParcel.writeString(this.vFR);
    paramParcel.writeString(this.vFS);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeString(this.cqq);
    paramParcel.writeInt(this.fileSize);
    paramParcel.writeInt(this.vFT);
    AppMethodBeat.o(63523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WePkgDiffInfo
 * JD-Core Version:    0.7.0.1
 */