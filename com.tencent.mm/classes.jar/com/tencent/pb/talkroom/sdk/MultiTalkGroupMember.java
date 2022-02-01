package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMember> CREATOR = new Parcelable.Creator() {};
  public int ahgm;
  public String ahhi = "";
  public String ahhj = "";
  public int reason;
  public int status;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroupMember [usrName=" + this.ahhi + ", inviteUsrName=" + this.ahhj + ", status=" + this.status + ", reason=" + this.reason + ", inviteTime=" + this.ahgm + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.ahhi == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.ahhj != null) {
        break label63;
      }
    }
    label63:
    for (String str = "";; str = this.ahhj)
    {
      paramParcel.writeString(str);
      paramParcel.writeInt(this.status);
      paramParcel.writeInt(this.reason);
      paramParcel.writeInt(this.ahgm);
      return;
      str = this.ahhi;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroupMember
 * JD-Core Version:    0.7.0.1
 */