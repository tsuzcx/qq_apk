package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public class VoipScoreState
  implements Parcelable
{
  public static final Parcelable.Creator<VoipScoreState> CREATOR;
  public int roomId;
  public long sAY;
  public long sCt;
  public String zlO;
  public int zlP;
  public long zlQ;
  
  static
  {
    AppMethodBeat.i(115108);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(115108);
  }
  
  public VoipScoreState()
  {
    AppMethodBeat.i(115102);
    this.zlO = "";
    this.zlP = -1;
    this.roomId = -1;
    this.sAY = -1L;
    this.sCt = -1L;
    this.zlQ = 0L;
    ad.m("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
    AppMethodBeat.o(115102);
  }
  
  protected VoipScoreState(Parcel paramParcel)
  {
    AppMethodBeat.i(115103);
    this.zlO = "";
    this.zlP = -1;
    this.roomId = -1;
    this.sAY = -1L;
    this.sCt = -1L;
    this.zlQ = 0L;
    this.zlO = paramParcel.readString();
    this.zlP = paramParcel.readInt();
    this.roomId = paramParcel.readInt();
    this.sAY = paramParcel.readLong();
    this.sCt = paramParcel.readLong();
    this.zlQ = paramParcel.readLong();
    AppMethodBeat.o(115103);
  }
  
  public static void dUv()
  {
    AppMethodBeat.i(115105);
    long l = bi.asg();
    g.afC();
    g.afB().afk().set(ae.a.FtJ, Long.valueOf(l));
    ad.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(115105);
  }
  
  public final void b(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(115104);
    ad.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1) });
    this.roomId = paramInt2;
    this.sAY = paramLong;
    if (!bt.isNullOrNil(paramString)) {
      try
      {
        paramString = new String(Base64.decode(paramString.getBytes(), 0));
        ad.m("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
        this.zlP = paramInt1;
        this.zlO = paramString;
        AppMethodBeat.o(115104);
        return;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.VoipScoreState", paramString, "setScoreState error: %s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(115104);
  }
  
  public final boolean dUu()
  {
    AppMethodBeat.i(192051);
    g.afC();
    long l2 = ((Long)g.afB().afk().get(ae.a.FtJ, Long.valueOf(-1L))).longValue();
    if (l2 > 0L) {}
    for (long l1 = l2;; l1 = 0L)
    {
      this.zlQ = l1;
      l1 = bi.asg();
      ad.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.zlP) });
      if ((bt.isNullOrNil(this.zlO)) || (this.zlP <= 0) || ((l2 > 0L) && (l1 - l2 <= this.zlP * 86400000L))) {
        break;
      }
      ad.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
      AppMethodBeat.o(192051);
      return true;
    }
    AppMethodBeat.o(192051);
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(115107);
    String str = "VoipScoreState{scoreTitle='" + this.zlO + '\'' + ", scoreIntervalDay=" + this.zlP + ", roomId=" + this.roomId + ", roomKey=" + this.sAY + ", startTalkTime=" + this.sCt + ", lastShowScoreTime=" + this.zlQ + '}';
    AppMethodBeat.o(115107);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(115106);
    paramParcel.writeString(this.zlO);
    paramParcel.writeInt(this.zlP);
    paramParcel.writeInt(this.roomId);
    paramParcel.writeLong(this.sAY);
    paramParcel.writeLong(this.sCt);
    paramParcel.writeLong(this.zlQ);
    AppMethodBeat.o(115106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipScoreState
 * JD-Core Version:    0.7.0.1
 */