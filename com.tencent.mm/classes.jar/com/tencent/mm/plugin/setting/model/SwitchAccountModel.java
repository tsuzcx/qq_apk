package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwitchAccountModel
  implements Parcelable
{
  public static final Parcelable.Creator<SwitchAccountModel> CREATOR;
  public final String qjl;
  public final String username;
  public final String wdc;
  public final String wdd;
  public final int wde;
  
  static
  {
    AppMethodBeat.i(73786);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(73786);
  }
  
  public SwitchAccountModel(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.wdc = paramString1;
    this.username = paramString2;
    this.qjl = paramString3;
    this.wdd = paramString4;
    this.wde = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73785);
    paramParcel.writeString(this.wdc);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.qjl);
    paramParcel.writeString(this.wdd);
    paramParcel.writeInt(this.wde);
    AppMethodBeat.o(73785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.SwitchAccountModel
 * JD-Core Version:    0.7.0.1
 */