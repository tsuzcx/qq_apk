package com.tencent.mm.plugin.setting.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserAuthItemParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<UserAuthItemParcelable> CREATOR = new UserAuthItemParcelable.1();
  public String nRj;
  public int nRk;
  public String scope;
  public int state;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.scope);
    paramParcel.writeString(this.nRj);
    paramParcel.writeInt(this.state);
    paramParcel.writeInt(this.nRk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.UserAuthItemParcelable
 * JD-Core Version:    0.7.0.1
 */