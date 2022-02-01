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
  public int JLH;
  public String JPR = "";
  public String JPS = "";
  public String JPT = "";
  public String JPU = "";
  public List<MultiTalkGroupMember> JPV = new ArrayList();
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String fCa()
  {
    return this.JPR;
  }
  
  public String toString()
  {
    return "MultiTalkGroup [mMultiTalkGroupId=" + this.JPR + ", mMultiTalkClientGroupId=" + this.JPS + ", mWxGroupId=" + this.JPT + ", mRouteId=" + this.JLH + ", mCreatorUsrName=" + this.JPU + ", mMultiTalkGroupMemberList=" + this.JPV + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    String str;
    if (this.JPR == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.JPS != null) {
        break label136;
      }
      str = "";
      label31:
      paramParcel.writeString(str);
      if (this.JPT != null) {
        break label145;
      }
      str = "";
      label48:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.JLH);
      if (this.JPU != null) {
        break label154;
      }
      str = "";
      label73:
      paramParcel.writeString(str);
      if (this.JPV != null) {
        break label163;
      }
    }
    label136:
    label145:
    label154:
    label163:
    for (int i = 0;; i = this.JPV.size())
    {
      paramParcel.writeInt(i);
      while (j < i)
      {
        paramParcel.writeParcelable((MultiTalkGroupMember)this.JPV.get(j), paramInt);
        j += 1;
      }
      str = this.JPR;
      break;
      str = this.JPS;
      break label31;
      str = this.JPT;
      break label48;
      str = this.JPU;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroup
 * JD-Core Version:    0.7.0.1
 */