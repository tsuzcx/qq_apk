package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

public class MultiTalkGroupData
  implements Parcelable
{
  public static final Parcelable.Creator<MultiTalkGroupData> CREATOR;
  private MultiTalkGroup vZY;
  
  static
  {
    AppMethodBeat.i(114410);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(114410);
  }
  
  public MultiTalkGroupData() {}
  
  public MultiTalkGroupData(MultiTalkGroup paramMultiTalkGroup)
  {
    this.vZY = paramMultiTalkGroup;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114409);
    paramParcel.writeString(bt.bI(this.vZY.LJC, ""));
    paramParcel.writeString(bt.bI(this.vZY.LJD, ""));
    paramParcel.writeString(bt.bI(this.vZY.LJE, ""));
    paramParcel.writeInt(this.vZY.LFq);
    paramParcel.writeString(bt.bI(this.vZY.LJF, ""));
    paramParcel.writeInt(this.vZY.LJG.size());
    int i = 0;
    while (i < this.vZY.LJG.size())
    {
      paramParcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember)this.vZY.LJG.get(i)), paramInt);
      i += 1;
    }
    AppMethodBeat.o(114409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.data.MultiTalkGroupData
 * JD-Core Version:    0.7.0.1
 */