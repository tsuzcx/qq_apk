package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

public class MultiTalkGroupData
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupData> CREATOR;
  private MultiTalkGroup oSY;
  
  static
  {
    AppMethodBeat.i(53881);
    CREATOR = new MultiTalkGroupData.1();
    AppMethodBeat.o(53881);
  }
  
  public MultiTalkGroupData() {}
  
  public MultiTalkGroupData(MultiTalkGroup paramMultiTalkGroup)
  {
    this.oSY = paramMultiTalkGroup;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(53880);
    paramParcel.writeString(bo.bf(this.oSY.Bhl, ""));
    paramParcel.writeString(bo.bf(this.oSY.Bhm, ""));
    paramParcel.writeString(bo.bf(this.oSY.Bhn, ""));
    paramParcel.writeInt(this.oSY.Bda);
    paramParcel.writeString(bo.bf(this.oSY.Bho, ""));
    paramParcel.writeInt(this.oSY.Bhp.size());
    int i = 0;
    while (i < this.oSY.Bhp.size())
    {
      paramParcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember)this.oSY.Bhp.get(i)), paramInt);
      i += 1;
    }
    AppMethodBeat.o(53880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.MultiTalkGroupData
 * JD-Core Version:    0.7.0.1
 */