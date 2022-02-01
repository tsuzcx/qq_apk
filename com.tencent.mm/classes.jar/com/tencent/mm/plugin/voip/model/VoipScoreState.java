package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public class VoipScoreState
  implements Parcelable
{
  public static final Parcelable.Creator<VoipScoreState> CREATOR;
  public String AEC;
  public int AED;
  public long AEE;
  public int roomId;
  public long tIG;
  public long tKb;
  
  static
  {
    AppMethodBeat.i(115108);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(115108);
  }
  
  public VoipScoreState()
  {
    AppMethodBeat.i(115102);
    this.AEC = "";
    this.AED = -1;
    this.roomId = -1;
    this.tIG = -1L;
    this.tKb = -1L;
    this.AEE = 0L;
    ac.m("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
    AppMethodBeat.o(115102);
  }
  
  protected VoipScoreState(Parcel paramParcel)
  {
    AppMethodBeat.i(115103);
    this.AEC = "";
    this.AED = -1;
    this.roomId = -1;
    this.tIG = -1L;
    this.tKb = -1L;
    this.AEE = 0L;
    this.AEC = paramParcel.readString();
    this.AED = paramParcel.readInt();
    this.roomId = paramParcel.readInt();
    this.tIG = paramParcel.readLong();
    this.tKb = paramParcel.readLong();
    this.AEE = paramParcel.readLong();
    AppMethodBeat.o(115103);
  }
  
  public static void ejH()
  {
    AppMethodBeat.i(115105);
    long l = bi.ayX();
    g.agS();
    g.agR().agA().set(ah.a.GRD, Long.valueOf(l));
    ac.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(115105);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(115104);
    ac.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1) });
    this.roomId = paramInt2;
    this.tIG = paramLong;
    if (!bs.isNullOrNil(paramString)) {
      try
      {
        paramString = new String(Base64.decode(paramString.getBytes(), 0));
        ac.m("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
        this.AED = paramInt1;
        this.AEC = paramString;
        AppMethodBeat.o(115104);
        return;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.VoipScoreState", paramString, "setScoreState error: %s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(115104);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean ejG()
  {
    AppMethodBeat.i(208376);
    g.agS();
    long l2 = ((Long)g.agR().agA().get(ah.a.GRD, Long.valueOf(-1L))).longValue();
    if (l2 > 0L) {}
    for (long l1 = l2;; l1 = 0L)
    {
      this.AEE = l1;
      l1 = bi.ayX();
      ac.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.AED) });
      if ((bs.isNullOrNil(this.AEC)) || (this.AED <= 0) || ((l2 > 0L) && (l1 - l2 <= this.AED * 86400000L))) {
        break;
      }
      ac.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
      AppMethodBeat.o(208376);
      return true;
    }
    AppMethodBeat.o(208376);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(115107);
    String str = "VoipScoreState{scoreTitle='" + this.AEC + '\'' + ", scoreIntervalDay=" + this.AED + ", roomId=" + this.roomId + ", roomKey=" + this.tIG + ", startTalkTime=" + this.tKb + ", lastShowScoreTime=" + this.AEE + '}';
    AppMethodBeat.o(115107);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(115106);
    paramParcel.writeString(this.AEC);
    paramParcel.writeInt(this.AED);
    paramParcel.writeInt(this.roomId);
    paramParcel.writeLong(this.tIG);
    paramParcel.writeLong(this.tKb);
    paramParcel.writeLong(this.AEE);
    AppMethodBeat.o(115106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipScoreState
 * JD-Core Version:    0.7.0.1
 */