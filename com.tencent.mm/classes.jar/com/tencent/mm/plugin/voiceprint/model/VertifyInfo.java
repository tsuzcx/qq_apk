package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class VertifyInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VertifyInfo> CREATOR;
  public String gEl = "";
  public String mFileName = "";
  public String mText = "";
  public boolean mqT = false;
  public String trb = "";
  public int tri = 0;
  public int trp;
  public int trq;
  public int trr = 0;
  public boolean trs = false;
  
  static
  {
    AppMethodBeat.i(26110);
    CREATOR = new VertifyInfo.1();
    AppMethodBeat.o(26110);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(26109);
    paramParcel.writeInt(this.trp);
    paramParcel.writeInt(this.trq);
    paramParcel.writeInt(this.trr);
    paramParcel.writeInt(this.tri);
    paramParcel.writeString(bo.bf(this.mText, ""));
    paramParcel.writeString(bo.bf(this.trb, ""));
    paramParcel.writeString(bo.bf(this.mFileName, ""));
    if (this.trs)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.mqT) {
        break label119;
      }
    }
    label119:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(26109);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.VertifyInfo
 * JD-Core Version:    0.7.0.1
 */