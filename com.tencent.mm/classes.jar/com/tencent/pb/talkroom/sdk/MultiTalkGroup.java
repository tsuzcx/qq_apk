package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkGroup
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroup> CREATOR = new MultiTalkGroup.1();
  public int wFA;
  public String wJL = "";
  public String wJM = "";
  public String wJN = "";
  public String wJO = "";
  public List<MultiTalkGroupMember> wJP = new ArrayList();
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroup [mMultiTalkGroupId=" + this.wJL + ", mMultiTalkClientGroupId=" + this.wJM + ", mWxGroupId=" + this.wJN + ", mRouteId=" + this.wFA + ", mCreatorUsrName=" + this.wJO + ", mMultiTalkGroupMemberList=" + this.wJP + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    String str;
    if (this.wJL == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.wJM != null) {
        break label136;
      }
      str = "";
      label31:
      paramParcel.writeString(str);
      if (this.wJN != null) {
        break label145;
      }
      str = "";
      label48:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.wFA);
      if (this.wJO != null) {
        break label154;
      }
      str = "";
      label73:
      paramParcel.writeString(str);
      if (this.wJP != null) {
        break label163;
      }
    }
    label136:
    label145:
    label154:
    label163:
    for (int i = 0;; i = this.wJP.size())
    {
      paramParcel.writeInt(i);
      while (j < i)
      {
        paramParcel.writeParcelable((MultiTalkGroupMember)this.wJP.get(j), paramInt);
        j += 1;
      }
      str = this.wJL;
      break;
      str = this.wJM;
      break label31;
      str = this.wJN;
      break label48;
      str = this.wJO;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroup
 * JD-Core Version:    0.7.0.1
 */