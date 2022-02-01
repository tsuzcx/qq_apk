package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public class VertifyInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VertifyInfo> CREATOR;
  public String AvR = "";
  public int AvY = 0;
  public int Awf;
  public int Awg;
  public int Awh = 0;
  public boolean Awi = false;
  public String iRo = "";
  public String mFileName = "";
  public String mText = "";
  public boolean qGc = false;
  
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
    paramParcel.writeInt(this.Awf);
    paramParcel.writeInt(this.Awg);
    paramParcel.writeInt(this.Awh);
    paramParcel.writeInt(this.AvY);
    paramParcel.writeString(bs.bG(this.mText, ""));
    paramParcel.writeString(bs.bG(this.AvR, ""));
    paramParcel.writeString(bs.bG(this.mFileName, ""));
    if (this.Awi)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.qGc) {
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