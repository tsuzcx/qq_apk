package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwitchAccountModel
  implements Parcelable
{
  public static final Parcelable.Creator<SwitchAccountModel> CREATOR;
  public final String mBI;
  public final String qEJ;
  public final String qEK;
  public final int qEL;
  public final String username;
  
  static
  {
    AppMethodBeat.i(126864);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(126864);
  }
  
  public SwitchAccountModel(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.qEJ = paramString1;
    this.username = paramString2;
    this.mBI = paramString3;
    this.qEK = paramString4;
    this.qEL = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(126863);
    paramParcel.writeString(this.qEJ);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.mBI);
    paramParcel.writeString(this.qEK);
    paramParcel.writeInt(this.qEL);
    AppMethodBeat.o(126863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.SwitchAccountModel
 * JD-Core Version:    0.7.0.1
 */