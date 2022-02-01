package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public class VoipScoreState
  implements Parcelable
{
  public static final Parcelable.Creator<VoipScoreState> CREATOR;
  public String CdC;
  public int CdD;
  public long CdE;
  public int roomId;
  public long uLt;
  public long uMO;
  
  static
  {
    AppMethodBeat.i(115108);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(115108);
  }
  
  public VoipScoreState()
  {
    AppMethodBeat.i(115102);
    this.CdC = "";
    this.CdD = -1;
    this.roomId = -1;
    this.uLt = -1L;
    this.uMO = -1L;
    this.CdE = 0L;
    ad.m("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
    AppMethodBeat.o(115102);
  }
  
  protected VoipScoreState(Parcel paramParcel)
  {
    AppMethodBeat.i(115103);
    this.CdC = "";
    this.CdD = -1;
    this.roomId = -1;
    this.uLt = -1L;
    this.uMO = -1L;
    this.CdE = 0L;
    this.CdC = paramParcel.readString();
    this.CdD = paramParcel.readInt();
    this.roomId = paramParcel.readInt();
    this.uLt = paramParcel.readLong();
    this.uMO = paramParcel.readLong();
    this.CdE = paramParcel.readLong();
    AppMethodBeat.o(115103);
  }
  
  public static void exs()
  {
    AppMethodBeat.i(115105);
    long l = bj.aCb();
    g.ajD();
    g.ajC().ajl().set(al.a.IEh, Long.valueOf(l));
    ad.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(115105);
  }
  
  public final void c(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(115104);
    ad.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1) });
    this.roomId = paramInt2;
    this.uLt = paramLong;
    if (!bt.isNullOrNil(paramString)) {
      try
      {
        paramString = new String(Base64.decode(paramString.getBytes(), 0));
        ad.m("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
        this.CdD = paramInt1;
        this.CdC = paramString;
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
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean exr()
  {
    AppMethodBeat.i(216410);
    g.ajD();
    long l2 = ((Long)g.ajC().ajl().get(al.a.IEh, Long.valueOf(-1L))).longValue();
    if (l2 > 0L) {}
    for (long l1 = l2;; l1 = 0L)
    {
      this.CdE = l1;
      l1 = bj.aCb();
      ad.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.CdD) });
      if ((bt.isNullOrNil(this.CdC)) || (this.CdD <= 0) || ((l2 > 0L) && (l1 - l2 <= this.CdD * 86400000L))) {
        break;
      }
      ad.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
      AppMethodBeat.o(216410);
      return true;
    }
    AppMethodBeat.o(216410);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(115107);
    String str = "VoipScoreState{scoreTitle='" + this.CdC + '\'' + ", scoreIntervalDay=" + this.CdD + ", roomId=" + this.roomId + ", roomKey=" + this.uLt + ", startTalkTime=" + this.uMO + ", lastShowScoreTime=" + this.CdE + '}';
    AppMethodBeat.o(115107);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(115106);
    paramParcel.writeString(this.CdC);
    paramParcel.writeInt(this.CdD);
    paramParcel.writeInt(this.roomId);
    paramParcel.writeLong(this.uLt);
    paramParcel.writeLong(this.uMO);
    paramParcel.writeLong(this.CdE);
    AppMethodBeat.o(115106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipScoreState
 * JD-Core Version:    0.7.0.1
 */