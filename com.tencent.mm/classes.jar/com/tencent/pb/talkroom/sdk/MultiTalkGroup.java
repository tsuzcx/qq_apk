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
  public int RCJ;
  public String RGY = "";
  public String RGZ = "";
  public List<MultiTalkGroupMember> RHa = new ArrayList();
  public String zHD = "";
  public String zHE = "";
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String hjv()
  {
    return this.zHD;
  }
  
  public String toString()
  {
    return "MultiTalkGroup [mMultiTalkGroupId=" + this.zHD + ", mMultiTalkClientGroupId=" + this.RGY + ", mWxGroupId=" + this.zHE + ", mRouteId=" + this.RCJ + ", mCreatorUsrName=" + this.RGZ + ", mMultiTalkGroupMemberList=" + this.RHa + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    String str;
    if (this.zHD == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.RGY != null) {
        break label136;
      }
      str = "";
      label31:
      paramParcel.writeString(str);
      if (this.zHE != null) {
        break label145;
      }
      str = "";
      label48:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.RCJ);
      if (this.RGZ != null) {
        break label154;
      }
      str = "";
      label73:
      paramParcel.writeString(str);
      if (this.RHa != null) {
        break label163;
      }
    }
    label136:
    label145:
    label154:
    label163:
    for (int i = 0;; i = this.RHa.size())
    {
      paramParcel.writeInt(i);
      while (j < i)
      {
        paramParcel.writeParcelable((MultiTalkGroupMember)this.RHa.get(j), paramInt);
        j += 1;
      }
      str = this.zHD;
      break;
      str = this.RGY;
      break label31;
      str = this.zHE;
      break label48;
      str = this.RGZ;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroup
 * JD-Core Version:    0.7.0.1
 */