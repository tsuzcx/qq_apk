package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMember> CREATOR = new Parcelable.Creator() {};
  public int MfN;
  public String MgJ = "";
  public String MgK = "";
  public int reason;
  public int status;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroupMember [usrName=" + this.MgJ + ", inviteUsrName=" + this.MgK + ", status=" + this.status + ", reason=" + this.reason + ", inviteTime=" + this.MfN + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.MgJ == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.MgK != null) {
        break label63;
      }
    }
    label63:
    for (String str = "";; str = this.MgK)
    {
      paramParcel.writeString(str);
      paramParcel.writeInt(this.status);
      paramParcel.writeInt(this.reason);
      paramParcel.writeInt(this.MfN);
      return;
      str = this.MgJ;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroupMember
 * JD-Core Version:    0.7.0.1
 */