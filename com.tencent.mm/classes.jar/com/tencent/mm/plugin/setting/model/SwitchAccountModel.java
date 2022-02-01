package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwitchAccountModel
  implements Parcelable
{
  public static final Parcelable.Creator<SwitchAccountModel> CREATOR;
  public final String rBN;
  public final String username;
  public final String yCV;
  public final String yCW;
  public final int yCX;
  
  static
  {
    AppMethodBeat.i(73786);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(73786);
  }
  
  public SwitchAccountModel(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.yCV = paramString1;
    this.username = paramString2;
    this.rBN = paramString3;
    this.yCW = paramString4;
    this.yCX = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73785);
    paramParcel.writeString(this.yCV);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.rBN);
    paramParcel.writeString(this.yCW);
    paramParcel.writeInt(this.yCX);
    AppMethodBeat.o(73785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.SwitchAccountModel
 * JD-Core Version:    0.7.0.1
 */