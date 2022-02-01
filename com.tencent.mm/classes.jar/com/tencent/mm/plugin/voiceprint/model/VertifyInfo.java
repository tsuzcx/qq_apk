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
  public int DsN = 0;
  public String GQO = "";
  public int GRa;
  public int GRb;
  public int GRc = 0;
  public boolean GRd = false;
  public String kly = "";
  public String mFileName = "";
  public String mText = "";
  public boolean sXX = false;
  
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
    paramParcel.writeInt(this.GRa);
    paramParcel.writeInt(this.GRb);
    paramParcel.writeInt(this.GRc);
    paramParcel.writeInt(this.DsN);
    paramParcel.writeString(Util.nullAs(this.mText, ""));
    paramParcel.writeString(Util.nullAs(this.GQO, ""));
    paramParcel.writeString(Util.nullAs(this.mFileName, ""));
    if (this.GRd)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.sXX) {
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