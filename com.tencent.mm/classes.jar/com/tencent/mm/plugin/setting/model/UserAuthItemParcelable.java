package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class UserAuthItemParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<UserAuthItemParcelable> CREATOR;
  public String qFg;
  public int qFh;
  public String scope;
  public int state;
  
  static
  {
    AppMethodBeat.i(126882);
    CREATOR = new UserAuthItemParcelable.1();
    AppMethodBeat.o(126882);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(126881);
    paramParcel.writeString(this.scope);
    paramParcel.writeString(this.qFg);
    paramParcel.writeInt(this.state);
    paramParcel.writeInt(this.qFh);
    AppMethodBeat.o(126881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.UserAuthItemParcelable
 * JD-Core Version:    0.7.0.1
 */