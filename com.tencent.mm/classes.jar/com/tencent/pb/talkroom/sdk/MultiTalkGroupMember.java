package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMember> CREATOR = new MultiTalkGroupMember.1();
  public int Bgr;
  public String Bhq = "";
  public String Bhr = "";
  public int aXG;
  public int status;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroupMember [usrName=" + this.Bhq + ", inviteUsrName=" + this.Bhr + ", status=" + this.status + ", reason=" + this.aXG + ", inviteTime=" + this.Bgr + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.Bhq == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.Bhr != null) {
        break label63;
      }
    }
    label63:
    for (String str = "";; str = this.Bhr)
    {
      paramParcel.writeString(str);
      paramParcel.writeInt(this.status);
      paramParcel.writeInt(this.aXG);
      paramParcel.writeInt(this.Bgr);
      return;
      str = this.Bhq;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroupMember
 * JD-Core Version:    0.7.0.1
 */