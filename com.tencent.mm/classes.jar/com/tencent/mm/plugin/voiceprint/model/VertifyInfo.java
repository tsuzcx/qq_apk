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
  public boolean Aah = false;
  public int POh = 0;
  public String UsZ = "";
  public int Utl;
  public int Utm;
  public int Utn = 0;
  public boolean Uto = false;
  public String mFileName = "";
  public String mText = "";
  public String pZt = "";
  
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
    paramParcel.writeInt(this.Utl);
    paramParcel.writeInt(this.Utm);
    paramParcel.writeInt(this.Utn);
    paramParcel.writeInt(this.POh);
    paramParcel.writeString(Util.nullAs(this.mText, ""));
    paramParcel.writeString(Util.nullAs(this.UsZ, ""));
    paramParcel.writeString(Util.nullAs(this.mFileName, ""));
    if (this.Uto)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.Aah) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.VertifyInfo
 * JD-Core Version:    0.7.0.1
 */