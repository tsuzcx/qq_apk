package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public class VertifyInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VertifyInfo> CREATOR;
  public String CmN = "";
  public int CmU = 0;
  public int Cnb;
  public int Cnc;
  public int Cnd = 0;
  public boolean Cne = false;
  public String jnq = "";
  public String mFileName = "";
  public String mText = "";
  public boolean rxZ = false;
  
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
    paramParcel.writeInt(this.Cnb);
    paramParcel.writeInt(this.Cnc);
    paramParcel.writeInt(this.Cnd);
    paramParcel.writeInt(this.CmU);
    paramParcel.writeString(bu.bI(this.mText, ""));
    paramParcel.writeString(bu.bI(this.CmN, ""));
    paramParcel.writeString(bu.bI(this.mFileName, ""));
    if (this.Cne)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.rxZ) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.VertifyInfo
 * JD-Core Version:    0.7.0.1
 */