package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMemberData> CREATOR = new Parcelable.Creator() {};
  MultiTalkGroupMember mto;
  
  public MultiTalkGroupMemberData(MultiTalkGroupMember paramMultiTalkGroupMember)
  {
    this.mto = paramMultiTalkGroupMember;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(bk.aM(this.mto.wJQ, ""));
    paramParcel.writeString(bk.aM(this.mto.wJR, ""));
    paramParcel.writeInt(this.mto.status);
    paramParcel.writeInt(this.mto.aQw);
    paramParcel.writeInt(this.mto.wIR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.MultiTalkGroupMemberData
 * JD-Core Version:    0.7.0.1
 */