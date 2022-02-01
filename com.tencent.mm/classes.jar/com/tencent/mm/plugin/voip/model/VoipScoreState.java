package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public class VoipScoreState
  implements Parcelable
{
  public static final Parcelable.Creator<VoipScoreState> CREATOR;
  public String Cvd;
  public int Cve;
  public long Cvf;
  public int roomId;
  public long uXg;
  public long uYB;
  
  static
  {
    AppMethodBeat.i(115108);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(115108);
  }
  
  public VoipScoreState()
  {
    AppMethodBeat.i(115102);
    this.Cvd = "";
    this.Cve = -1;
    this.roomId = -1;
    this.uXg = -1L;
    this.uYB = -1L;
    this.Cvf = 0L;
    ae.m("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
    AppMethodBeat.o(115102);
  }
  
  protected VoipScoreState(Parcel paramParcel)
  {
    AppMethodBeat.i(115103);
    this.Cvd = "";
    this.Cve = -1;
    this.roomId = -1;
    this.uXg = -1L;
    this.uYB = -1L;
    this.Cvf = 0L;
    this.Cvd = paramParcel.readString();
    this.Cve = paramParcel.readInt();
    this.roomId = paramParcel.readInt();
    this.uXg = paramParcel.readLong();
    this.uYB = paramParcel.readLong();
    this.Cvf = paramParcel.readLong();
    AppMethodBeat.o(115103);
  }
  
  public static void eAZ()
  {
    AppMethodBeat.i(115105);
    long l = bl.aCr();
    g.ajS();
    g.ajR().ajA().set(am.a.IYH, Long.valueOf(l));
    ae.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(115105);
  }
  
  public final void c(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(115104);
    ae.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1) });
    this.roomId = paramInt2;
    this.uXg = paramLong;
    if (!bu.isNullOrNil(paramString)) {
      try
      {
        paramString = new String(Base64.decode(paramString.getBytes(), 0));
        ae.m("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
        this.Cve = paramInt1;
        this.Cvd = paramString;
        AppMethodBeat.o(115104);
        return;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.VoipScoreState", paramString, "setScoreState error: %s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(115104);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean eAY()
  {
    AppMethodBeat.i(210089);
    g.ajS();
    long l2 = ((Long)g.ajR().ajA().get(am.a.IYH, Long.valueOf(-1L))).longValue();
    if (l2 > 0L) {}
    for (long l1 = l2;; l1 = 0L)
    {
      this.Cvf = l1;
      l1 = bl.aCr();
      ae.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.Cve) });
      if ((bu.isNullOrNil(this.Cvd)) || (this.Cve <= 0) || ((l2 > 0L) && (l1 - l2 <= this.Cve * 86400000L))) {
        break;
      }
      ae.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
      AppMethodBeat.o(210089);
      return true;
    }
    AppMethodBeat.o(210089);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(115107);
    String str = "VoipScoreState{scoreTitle='" + this.Cvd + '\'' + ", scoreIntervalDay=" + this.Cve + ", roomId=" + this.roomId + ", roomKey=" + this.uXg + ", startTalkTime=" + this.uYB + ", lastShowScoreTime=" + this.Cvf + '}';
    AppMethodBeat.o(115107);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(115106);
    paramParcel.writeString(this.Cvd);
    paramParcel.writeInt(this.Cve);
    paramParcel.writeInt(this.roomId);
    paramParcel.writeLong(this.uXg);
    paramParcel.writeLong(this.uYB);
    paramParcel.writeLong(this.Cvf);
    AppMethodBeat.o(115106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipScoreState
 * JD-Core Version:    0.7.0.1
 */