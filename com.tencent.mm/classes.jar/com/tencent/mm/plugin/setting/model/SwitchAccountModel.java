package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwitchAccountModel
  implements Parcelable
{
  public static final Parcelable.Creator<SwitchAccountModel> CREATOR;
  public final String qRN;
  public final String username;
  public final String xoq;
  public final String xor;
  public final int xos;
  
  static
  {
    AppMethodBeat.i(73786);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(73786);
  }
  
  public SwitchAccountModel(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.xoq = paramString1;
    this.username = paramString2;
    this.qRN = paramString3;
    this.xor = paramString4;
    this.xos = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73785);
    paramParcel.writeString(this.xoq);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.qRN);
    paramParcel.writeString(this.xor);
    paramParcel.writeInt(this.xos);
    AppMethodBeat.o(73785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.SwitchAccountModel
 * JD-Core Version:    0.7.0.1
 */