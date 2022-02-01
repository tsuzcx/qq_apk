package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkGroup
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroup> CREATOR = new Parcelable.Creator() {};
  public String LiU = "";
  public String LiV = "";
  public int ahcO;
  public String ahhf = "";
  public String ahhg = "";
  public List<MultiTalkGroupMember> ahhh = new ArrayList();
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroup [mMultiTalkGroupId=" + this.LiU + ", mMultiTalkClientGroupId=" + this.ahhf + ", mWxGroupId=" + this.LiV + ", mRouteId=" + this.ahcO + ", mCreatorUsrName=" + this.ahhg + ", mMultiTalkGroupMemberList=" + this.ahhh + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    String str;
    if (this.LiU == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.ahhf != null) {
        break label136;
      }
      str = "";
      label31:
      paramParcel.writeString(str);
      if (this.LiV != null) {
        break label145;
      }
      str = "";
      label48:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.ahcO);
      if (this.ahhg != null) {
        break label154;
      }
      str = "";
      label73:
      paramParcel.writeString(str);
      if (this.ahhh != null) {
        break label163;
      }
    }
    label136:
    label145:
    label154:
    label163:
    for (int i = 0;; i = this.ahhh.size())
    {
      paramParcel.writeInt(i);
      while (j < i)
      {
        paramParcel.writeParcelable((MultiTalkGroupMember)this.ahhh.get(j), paramInt);
        j += 1;
      }
      str = this.LiU;
      break;
      str = this.ahhf;
      break label31;
      str = this.LiV;
      break label48;
      str = this.ahhg;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroup
 * JD-Core Version:    0.7.0.1
 */