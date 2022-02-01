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
  public int Mcu;
  public String MgG = "";
  public String MgH = "";
  public List<MultiTalkGroupMember> MgI = new ArrayList();
  public String wmA = "";
  public String wmz = "";
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String fXP()
  {
    return this.wmz;
  }
  
  public String toString()
  {
    return "MultiTalkGroup [mMultiTalkGroupId=" + this.wmz + ", mMultiTalkClientGroupId=" + this.MgG + ", mWxGroupId=" + this.wmA + ", mRouteId=" + this.Mcu + ", mCreatorUsrName=" + this.MgH + ", mMultiTalkGroupMemberList=" + this.MgI + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    String str;
    if (this.wmz == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.MgG != null) {
        break label136;
      }
      str = "";
      label31:
      paramParcel.writeString(str);
      if (this.wmA != null) {
        break label145;
      }
      str = "";
      label48:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.Mcu);
      if (this.MgH != null) {
        break label154;
      }
      str = "";
      label73:
      paramParcel.writeString(str);
      if (this.MgI != null) {
        break label163;
      }
    }
    label136:
    label145:
    label154:
    label163:
    for (int i = 0;; i = this.MgI.size())
    {
      paramParcel.writeInt(i);
      while (j < i)
      {
        paramParcel.writeParcelable((MultiTalkGroupMember)this.MgI.get(j), paramInt);
        j += 1;
      }
      str = this.wmz;
      break;
      str = this.MgG;
      break label31;
      str = this.wmA;
      break label48;
      str = this.MgH;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroup
 * JD-Core Version:    0.7.0.1
 */