package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;

public class VertifyInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VertifyInfo> CREATOR = new VertifyInfo.1();
  public String fmR = "";
  public String hnV = "";
  public boolean jWC = false;
  public String mFileName = "";
  public String pLf = "";
  public int pLm = 0;
  public int pLt;
  public int pLu;
  public int pLv = 0;
  public boolean pLw = false;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.pLt);
    paramParcel.writeInt(this.pLu);
    paramParcel.writeInt(this.pLv);
    paramParcel.writeInt(this.pLm);
    paramParcel.writeString(bk.aM(this.hnV, ""));
    paramParcel.writeString(bk.aM(this.pLf, ""));
    paramParcel.writeString(bk.aM(this.mFileName, ""));
    if (this.pLw)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.jWC) {
        break label107;
      }
    }
    label107:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
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