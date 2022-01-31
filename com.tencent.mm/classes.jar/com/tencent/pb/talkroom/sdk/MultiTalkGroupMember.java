package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMember> CREATOR = new MultiTalkGroupMember.1();
  public int aQw;
  public int status;
  public int wIR;
  public String wJQ = "";
  public String wJR = "";
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroupMember [usrName=" + this.wJQ + ", inviteUsrName=" + this.wJR + ", status=" + this.status + ", reason=" + this.aQw + ", inviteTime=" + this.wIR + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.wJQ == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.wJR != null) {
        break label63;
      }
    }
    label63:
    for (String str = "";; str = this.wJR)
    {
      paramParcel.writeString(str);
      paramParcel.writeInt(this.status);
      paramParcel.writeInt(this.aQw);
      paramParcel.writeInt(this.wIR);
      return;
      str = this.wJQ;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroupMember
 * JD-Core Version:    0.7.0.1
 */