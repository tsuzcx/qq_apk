package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMemberData> CREATOR;
  MultiTalkGroupMember oSZ;
  
  static
  {
    AppMethodBeat.i(53884);
    CREATOR = new MultiTalkGroupMemberData.1();
    AppMethodBeat.o(53884);
  }
  
  public MultiTalkGroupMemberData(MultiTalkGroupMember paramMultiTalkGroupMember)
  {
    this.oSZ = paramMultiTalkGroupMember;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(53883);
    paramParcel.writeString(bo.bf(this.oSZ.Bhq, ""));
    paramParcel.writeString(bo.bf(this.oSZ.Bhr, ""));
    paramParcel.writeInt(this.oSZ.status);
    paramParcel.writeInt(this.oSZ.aXG);
    paramParcel.writeInt(this.oSZ.Bgr);
    AppMethodBeat.o(53883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.MultiTalkGroupMemberData
 * JD-Core Version:    0.7.0.1
 */