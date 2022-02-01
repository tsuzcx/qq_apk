package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public class VertifyInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VertifyInfo> CREATOR;
  public int JzA = 0;
  public String NGZ = "";
  public int NHl;
  public int NHm;
  public int NHn = 0;
  public boolean NHo = false;
  public String mFileName = "";
  public String mText = "";
  public String ndo = "";
  public boolean wDW = false;
  
  static
  {
    AppMethodBeat.i(29791);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(29791);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(29790);
    paramParcel.writeInt(this.NHl);
    paramParcel.writeInt(this.NHm);
    paramParcel.writeInt(this.NHn);
    paramParcel.writeInt(this.JzA);
    paramParcel.writeString(Util.nullAs(this.mText, ""));
    paramParcel.writeString(Util.nullAs(this.NGZ, ""));
    paramParcel.writeString(Util.nullAs(this.mFileName, ""));
    if (this.NHo)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.wDW) {
        break label119;
      }
    }
    label119:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(29790);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.VertifyInfo
 * JD-Core Version:    0.7.0.1
 */