package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMember> CREATOR = new Parcelable.Creator() {};
  public int RGf;
  public String RHb = "";
  public String RHc = "";
  public int bDZ;
  public int status;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroupMember [usrName=" + this.RHb + ", inviteUsrName=" + this.RHc + ", status=" + this.status + ", reason=" + this.bDZ + ", inviteTime=" + this.RGf + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.RHb == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.RHc != null) {
        break label63;
      }
    }
    label63:
    for (String str = "";; str = this.RHc)
    {
      paramParcel.writeString(str);
      paramParcel.writeInt(this.status);
      paramParcel.writeInt(this.bDZ);
      paramParcel.writeInt(this.RGf);
      return;
      str = this.RHb;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroupMember
 * JD-Core Version:    0.7.0.1
 */