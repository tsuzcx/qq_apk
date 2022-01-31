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
  public int Bda;
  public String Bhl = "";
  public String Bhm = "";
  public String Bhn = "";
  public String Bho = "";
  public List<MultiTalkGroupMember> Bhp = new ArrayList();
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "MultiTalkGroup [mMultiTalkGroupId=" + this.Bhl + ", mMultiTalkClientGroupId=" + this.Bhm + ", mWxGroupId=" + this.Bhn + ", mRouteId=" + this.Bda + ", mCreatorUsrName=" + this.Bho + ", mMultiTalkGroupMemberList=" + this.Bhp + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    String str;
    if (this.Bhl == null)
    {
      str = "";
      paramParcel.writeString(str);
      if (this.Bhm != null) {
        break label136;
      }
      str = "";
      label31:
      paramParcel.writeString(str);
      if (this.Bhn != null) {
        break label145;
      }
      str = "";
      label48:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.Bda);
      if (this.Bho != null) {
        break label154;
      }
      str = "";
      label73:
      paramParcel.writeString(str);
      if (this.Bhp != null) {
        break label163;
      }
    }
    label136:
    label145:
    label154:
    label163:
    for (int i = 0;; i = this.Bhp.size())
    {
      paramParcel.writeInt(i);
      while (j < i)
      {
        paramParcel.writeParcelable((MultiTalkGroupMember)this.Bhp.get(j), paramInt);
        j += 1;
      }
      str = this.Bhl;
      break;
      str = this.Bhm;
      break label31;
      str = this.Bhn;
      break label48;
      str = this.Bho;
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.talkroom.sdk.MultiTalkGroup
 * JD-Core Version:    0.7.0.1
 */