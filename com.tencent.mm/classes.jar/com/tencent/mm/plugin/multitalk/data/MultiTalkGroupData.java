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
  private MultiTalkGroup Fmq;
  
  static
  {
    AppMethodBeat.i(114410);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(114410);
  }
  
  public MultiTalkGroupData() {}
  
  public MultiTalkGroupData(MultiTalkGroup paramMultiTalkGroup)
  {
    this.Fmq = paramMultiTalkGroup;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114409);
    paramParcel.writeString(Util.nullAs(this.Fmq.FmO, ""));
    paramParcel.writeString(Util.nullAs(this.Fmq.ZiE, ""));
    paramParcel.writeString(Util.nullAs(this.Fmq.FmP, ""));
    paramParcel.writeInt(this.Fmq.Zel);
    paramParcel.writeString(Util.nullAs(this.Fmq.ZiF, ""));
    paramParcel.writeInt(this.Fmq.ZiG.size());
    int i = 0;
    while (i < this.Fmq.ZiG.size())
    {
      paramParcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember)this.Fmq.ZiG.get(i)), paramInt);
      i += 1;
    }
    AppMethodBeat.o(114409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.MultiTalkGroupData
 * JD-Core Version:    0.7.0.1
 */