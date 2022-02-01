package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

public class MultiTalkGroupData
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupData> CREATOR;
  private MultiTalkGroup Liu;
  
  static
  {
    AppMethodBeat.i(114410);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(114410);
  }
  
  public MultiTalkGroupData() {}
  
  public MultiTalkGroupData(MultiTalkGroup paramMultiTalkGroup)
  {
    this.Liu = paramMultiTalkGroup;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114409);
    paramParcel.writeString(Util.nullAs(this.Liu.LiU, ""));
    paramParcel.writeString(Util.nullAs(this.Liu.ahhf, ""));
    paramParcel.writeString(Util.nullAs(this.Liu.LiV, ""));
    paramParcel.writeInt(this.Liu.ahcO);
    paramParcel.writeString(Util.nullAs(this.Liu.ahhg, ""));
    paramParcel.writeInt(this.Liu.ahhh.size());
    int i = 0;
    while (i < this.Liu.ahhh.size())
    {
      paramParcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember)this.Liu.ahhh.get(i)), paramInt);
      i += 1;
    }
    AppMethodBeat.o(114409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.MultiTalkGroupData
 * JD-Core Version:    0.7.0.1
 */