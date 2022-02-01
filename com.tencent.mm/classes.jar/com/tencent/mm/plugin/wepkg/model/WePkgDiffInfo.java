package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WePkgDiffInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WePkgDiffInfo> CREATOR;
  public String XFP;
  public int XFQ;
  public String downloadUrl;
  public int fileSize;
  public String md5;
  public String mtT;
  public String oldVersion;
  public String version;
  
  static
  {
    AppMethodBeat.i(110682);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110682);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110681);
    paramParcel.writeString(this.mtT);
    paramParcel.writeString(this.oldVersion);
    paramParcel.writeString(this.XFP);
    paramParcel.writeString(this.version);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeString(this.md5);
    paramParcel.writeInt(this.fileSize);
    paramParcel.writeInt(this.XFQ);
    AppMethodBeat.o(110681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WePkgDiffInfo
 * JD-Core Version:    0.7.0.1
 */