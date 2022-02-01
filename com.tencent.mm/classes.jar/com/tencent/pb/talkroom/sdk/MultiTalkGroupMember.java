package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMember> CREATOR = new Parcelable.Creator() {};
  public int ZhL;
  public String ZiH = "";
  public String ZiI = "";
  public int bnA;
  public int status;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroupMember [usrName=" + this.ZiH + ", inviteUsrName=" + this.ZiI + ", status=" + this.status + ", reason=" + this.bnA + ", inviteTime=" + this.ZhL + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.ZiH == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.ZiI != null) {
        break label63;
      }
    }
    label63:
    for (String str = "";; str = this.ZiI)
    {
      paramParcel.writeString(str);
      paramParcel.writeInt(this.status);
      paramParcel.writeInt(this.bnA);
      paramParcel.writeInt(this.ZhL);
      return;
      str = this.ZiH;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroupMember
 * JD-Core Version:    0.7.0.1
 */