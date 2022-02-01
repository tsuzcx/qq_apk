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
  public int IjW;
  public String Iog = "";
  public String Ioh = "";
  public String Ioi = "";
  public String Ioj = "";
  public List<MultiTalkGroupMember> Iok = new ArrayList();
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String flJ()
  {
    return this.Iog;
  }
  
  public String toString()
  {
    return "MultiTalkGroup [mMultiTalkGroupId=" + this.Iog + ", mMultiTalkClientGroupId=" + this.Ioh + ", mWxGroupId=" + this.Ioi + ", mRouteId=" + this.IjW + ", mCreatorUsrName=" + this.Ioj + ", mMultiTalkGroupMemberList=" + this.Iok + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    String str;
    if (this.Iog == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.Ioh != null) {
        break label136;
      }
      str = "";
      label31:
      paramParcel.writeString(str);
      if (this.Ioi != null) {
        break label145;
      }
      str = "";
      label48:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.IjW);
      if (this.Ioj != null) {
        break label154;
      }
      str = "";
      label73:
      paramParcel.writeString(str);
      if (this.Iok != null) {
        break label163;
      }
    }
    label136:
    label145:
    label154:
    label163:
    for (int i = 0;; i = this.Iok.size())
    {
      paramParcel.writeInt(i);
      while (j < i)
      {
        paramParcel.writeParcelable((MultiTalkGroupMember)this.Iok.get(j), paramInt);
        j += 1;
      }
      str = this.Iog;
      break;
      str = this.Ioh;
      break label31;
      str = this.Ioi;
      break label48;
      str = this.Ioj;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroup
 * JD-Core Version:    0.7.0.1
 */