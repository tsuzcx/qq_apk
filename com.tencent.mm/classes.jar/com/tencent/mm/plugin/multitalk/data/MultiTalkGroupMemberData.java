package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupMemberData> CREATOR;
  MultiTalkGroupMember zHg;
  
  static
  {
    AppMethodBeat.i(114413);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(114413);
  }
  
  public MultiTalkGroupMemberData(MultiTalkGroupMember paramMultiTalkGroupMember)
  {
    this.zHg = paramMultiTalkGroupMember;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114412);
    paramParcel.writeString(Util.nullAs(this.zHg.RHb, ""));
    paramParcel.writeString(Util.nullAs(this.zHg.RHc, ""));
    paramParcel.writeInt(this.zHg.status);
    paramParcel.writeInt(this.zHg.bDZ);
    paramParcel.writeInt(this.zHg.RGf);
    AppMethodBeat.o(114412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.MultiTalkGroupMemberData
 * JD-Core Version:    0.7.0.1
 */