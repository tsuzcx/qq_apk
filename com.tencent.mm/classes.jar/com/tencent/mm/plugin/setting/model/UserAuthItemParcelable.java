package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UserAuthItemParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<UserAuthItemParcelable> CREATOR;
  public String Poo;
  public int Pop;
  public String scope;
  public int state;
  
  static
  {
    AppMethodBeat.i(73804);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(73804);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(73803);
    paramParcel.writeString(this.scope);
    paramParcel.writeString(this.Poo);
    paramParcel.writeInt(this.state);
    paramParcel.writeInt(this.Pop);
    AppMethodBeat.o(73803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.UserAuthItemParcelable
 * JD-Core Version:    0.7.0.1
 */