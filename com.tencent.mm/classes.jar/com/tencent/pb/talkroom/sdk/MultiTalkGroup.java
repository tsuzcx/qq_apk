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
  public int LFq;
  public String LJC = "";
  public String LJD = "";
  public String LJE = "";
  public String LJF = "";
  public List<MultiTalkGroupMember> LJG = new ArrayList();
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String fTp()
  {
    return this.LJC;
  }
  
  public String toString()
  {
    return "MultiTalkGroup [mMultiTalkGroupId=" + this.LJC + ", mMultiTalkClientGroupId=" + this.LJD + ", mWxGroupId=" + this.LJE + ", mRouteId=" + this.LFq + ", mCreatorUsrName=" + this.LJF + ", mMultiTalkGroupMemberList=" + this.LJG + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    String str;
    if (this.LJC == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.LJD != null) {
        break label136;
      }
      str = "";
      label31:
      paramParcel.writeString(str);
      if (this.LJE != null) {
        break label145;
      }
      str = "";
      label48:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.LFq);
      if (this.LJF != null) {
        break label154;
      }
      str = "";
      label73:
      paramParcel.writeString(str);
      if (this.LJG != null) {
        break label163;
      }
    }
    label136:
    label145:
    label154:
    label163:
    for (int i = 0;; i = this.LJG.size())
    {
      paramParcel.writeInt(i);
      while (j < i)
      {
        paramParcel.writeParcelable((MultiTalkGroupMember)this.LJG.get(j), paramInt);
        j += 1;
      }
      str = this.LJC;
      break;
      str = this.LJD;
      break label31;
      str = this.LJE;
      break label48;
      str = this.LJF;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroup
 * JD-Core Version:    0.7.0.1
 */