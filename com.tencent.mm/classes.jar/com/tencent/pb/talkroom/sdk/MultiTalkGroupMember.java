package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMember> CREATOR = new Parcelable.Creator() {};
  public int Inn;
  public String Iol = "";
  public String Iom = "";
  public int bvJ;
  public int status;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroupMember [usrName=" + this.Iol + ", inviteUsrName=" + this.Iom + ", status=" + this.status + ", reason=" + this.bvJ + ", inviteTime=" + this.Inn + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.Iol == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.Iom != null) {
        break label63;
      }
    }
    label63:
    for (String str = "";; str = this.Iom)
    {
      paramParcel.writeString(str);
      paramParcel.writeInt(this.status);
      paramParcel.writeInt(this.bvJ);
      paramParcel.writeInt(this.Inn);
      return;
      str = this.Iol;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroupMember
 * JD-Core Version:    0.7.0.1
 */