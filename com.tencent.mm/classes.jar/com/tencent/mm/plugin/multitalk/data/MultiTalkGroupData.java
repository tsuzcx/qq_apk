package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

public class MultiTalkGroupData
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupData> CREATOR = new MultiTalkGroupData.1();
  private MultiTalkGroup mtn;
  
  public MultiTalkGroupData() {}
  
  public MultiTalkGroupData(MultiTalkGroup paramMultiTalkGroup)
  {
    this.mtn = paramMultiTalkGroup;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(bk.aM(this.mtn.wJL, ""));
    paramParcel.writeString(bk.aM(this.mtn.wJM, ""));
    paramParcel.writeString(bk.aM(this.mtn.wJN, ""));
    paramParcel.writeInt(this.mtn.wFA);
    paramParcel.writeString(bk.aM(this.mtn.wJO, ""));
    paramParcel.writeInt(this.mtn.wJP.size());
    int i = 0;
    while (i < this.mtn.wJP.size())
    {
      paramParcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember)this.mtn.wJP.get(i)), paramInt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.MultiTalkGroupData
 * JD-Core Version:    0.7.0.1
 */