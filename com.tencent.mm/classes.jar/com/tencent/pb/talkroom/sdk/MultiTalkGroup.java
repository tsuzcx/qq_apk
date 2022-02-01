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
  public String FmO = "";
  public String FmP = "";
  public int Zel;
  public String ZiE = "";
  public String ZiF = "";
  public List<MultiTalkGroupMember> ZiG = new ArrayList();
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String ilf()
  {
    return this.FmO;
  }
  
  public String toString()
  {
    return "MultiTalkGroup [mMultiTalkGroupId=" + this.FmO + ", mMultiTalkClientGroupId=" + this.ZiE + ", mWxGroupId=" + this.FmP + ", mRouteId=" + this.Zel + ", mCreatorUsrName=" + this.ZiF + ", mMultiTalkGroupMemberList=" + this.ZiG + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    String str;
    if (this.FmO == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.ZiE != null) {
        break label136;
      }
      str = "";
      label31:
      paramParcel.writeString(str);
      if (this.FmP != null) {
        break label145;
      }
      str = "";
      label48:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.Zel);
      if (this.ZiF != null) {
        break label154;
      }
      str = "";
      label73:
      paramParcel.writeString(str);
      if (this.ZiG != null) {
        break label163;
      }
    }
    label136:
    label145:
    label154:
    label163:
    for (int i = 0;; i = this.ZiG.size())
    {
      paramParcel.writeInt(i);
      while (j < i)
      {
        paramParcel.writeParcelable((MultiTalkGroupMember)this.ZiG.get(j), paramInt);
        j += 1;
      }
      str = this.FmO;
      break;
      str = this.ZiE;
      break label31;
      str = this.FmP;
      break label48;
      str = this.ZiF;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroup
 * JD-Core Version:    0.7.0.1
 */