package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwitchAccountModel
  implements Parcelable
{
  public static final Parcelable.Creator<SwitchAccountModel> CREATOR;
  public final String AmC;
  public final String PnR;
  public final String PnS;
  public final int PnT;
  public final String nickName;
  public final String username;
  
  static
  {
    AppMethodBeat.i(73786);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(73786);
  }
  
  public SwitchAccountModel(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    this.PnR = paramString1;
    this.username = paramString2;
    this.AmC = paramString3;
    this.PnS = paramString4;
    this.PnT = paramInt;
    this.nickName = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73785);
    paramParcel.writeString(this.PnR);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.AmC);
    paramParcel.writeString(this.PnS);
    paramParcel.writeInt(this.PnT);
    paramParcel.writeString(this.nickName);
    AppMethodBeat.o(73785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.SwitchAccountModel
 * JD-Core Version:    0.7.0.1
 */