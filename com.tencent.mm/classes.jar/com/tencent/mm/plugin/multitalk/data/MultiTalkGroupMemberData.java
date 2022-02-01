package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMemberData> CREATOR;
  MultiTalkGroupMember uWR;
  
  static
  {
    AppMethodBeat.i(114413);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(114413);
  }
  
  public MultiTalkGroupMemberData(MultiTalkGroupMember paramMultiTalkGroupMember)
  {
    this.uWR = paramMultiTalkGroupMember;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114412);
    paramParcel.writeString(bs.bG(this.uWR.JPW, ""));
    paramParcel.writeString(bs.bG(this.uWR.JPX, ""));
    paramParcel.writeInt(this.uWR.status);
    paramParcel.writeInt(this.uWR.reason);
    paramParcel.writeInt(this.uWR.JOX);
    AppMethodBeat.o(114412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.MultiTalkGroupMemberData
 * JD-Core Version:    0.7.0.1
 */