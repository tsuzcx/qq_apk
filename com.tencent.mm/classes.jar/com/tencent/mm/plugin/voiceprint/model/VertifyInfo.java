package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public class VertifyInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VertifyInfo> CREATOR;
  public String iri = "";
  public String mFileName = "";
  public String mText = "";
  public boolean pXx = false;
  public int zdA;
  public int zdB = 0;
  public boolean zdC = false;
  public String zdl = "";
  public int zds = 0;
  public int zdz;
  
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
    paramParcel.writeInt(this.zdz);
    paramParcel.writeInt(this.zdA);
    paramParcel.writeInt(this.zdB);
    paramParcel.writeInt(this.zds);
    paramParcel.writeString(bt.by(this.mText, ""));
    paramParcel.writeString(bt.by(this.zdl, ""));
    paramParcel.writeString(bt.by(this.mFileName, ""));
    if (this.zdC)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.pXx) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.VertifyInfo
 * JD-Core Version:    0.7.0.1
 */