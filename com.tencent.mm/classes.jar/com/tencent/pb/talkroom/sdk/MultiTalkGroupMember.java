package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMember> CREATOR = new Parcelable.Creator() {};
  public int LIJ;
  public String LJH = "";
  public String LJI = "";
  public int reason;
  public int status;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroupMember [usrName=" + this.LJH + ", inviteUsrName=" + this.LJI + ", status=" + this.status + ", reason=" + this.reason + ", inviteTime=" + this.LIJ + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.LJH == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.LJI != null) {
        break label63;
      }
    }
    label63:
    for (String str = "";; str = this.LJI)
    {
      paramParcel.writeString(str);
      paramParcel.writeInt(this.status);
      paramParcel.writeInt(this.reason);
      paramParcel.writeInt(this.LIJ);
      return;
      str = this.LJH;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroupMember
 * JD-Core Version:    0.7.0.1
 */