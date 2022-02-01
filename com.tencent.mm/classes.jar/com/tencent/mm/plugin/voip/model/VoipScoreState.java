package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public class VoipScoreState
  implements Parcelable
{
  public static final Parcelable.Creator<VoipScoreState> CREATOR;
  public String GYP;
  public int GYQ;
  public long GYR;
  public int roomId;
  public long ypH;
  public long yrb;
  
  static
  {
    AppMethodBeat.i(115108);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(115108);
  }
  
  public VoipScoreState()
  {
    AppMethodBeat.i(115102);
    this.GYP = "";
    this.GYQ = -1;
    this.roomId = -1;
    this.ypH = -1L;
    this.yrb = -1L;
    this.GYR = 0L;
    Log.printInfoStack("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
    AppMethodBeat.o(115102);
  }
  
  protected VoipScoreState(Parcel paramParcel)
  {
    AppMethodBeat.i(115103);
    this.GYP = "";
    this.GYQ = -1;
    this.roomId = -1;
    this.ypH = -1L;
    this.yrb = -1L;
    this.GYR = 0L;
    this.GYP = paramParcel.readString();
    this.GYQ = paramParcel.readInt();
    this.roomId = paramParcel.readInt();
    this.ypH = paramParcel.readLong();
    this.yrb = paramParcel.readLong();
    this.GYR = paramParcel.readLong();
    AppMethodBeat.o(115103);
  }
  
  public static void fHQ()
  {
    AppMethodBeat.i(115105);
    long l = bp.aVP();
    g.aAi();
    g.aAh().azQ().set(ar.a.Ohe, Long.valueOf(l));
    Log.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(115105);
  }
  
  public final void d(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(115104);
    Log.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1) });
    this.roomId = paramInt2;
    this.ypH = paramLong;
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = new String(Base64.decode(paramString.getBytes(), 0));
        Log.printInfoStack("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
        this.GYQ = paramInt1;
        this.GYP = paramString;
        AppMethodBeat.o(115104);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.VoipScoreState", paramString, "setScoreState error: %s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(115104);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean fHP()
  {
    AppMethodBeat.i(235665);
    g.aAi();
    long l2 = ((Long)g.aAh().azQ().get(ar.a.Ohe, Long.valueOf(-1L))).longValue();
    if (l2 > 0L) {}
    for (long l1 = l2;; l1 = 0L)
    {
      this.GYR = l1;
      l1 = bp.aVP();
      Log.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.GYQ) });
      if ((Util.isNullOrNil(this.GYP)) || (this.GYQ <= 0) || ((l2 > 0L) && (l1 - l2 <= this.GYQ * 86400000L))) {
        break;
      }
      Log.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
      AppMethodBeat.o(235665);
      return true;
    }
    AppMethodBeat.o(235665);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(115107);
    String str = "VoipScoreState{scoreTitle='" + this.GYP + '\'' + ", scoreIntervalDay=" + this.GYQ + ", roomId=" + this.roomId + ", roomKey=" + this.ypH + ", startTalkTime=" + this.yrb + ", lastShowScoreTime=" + this.GYR + '}';
    AppMethodBeat.o(115107);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(115106);
    paramParcel.writeString(this.GYP);
    paramParcel.writeInt(this.GYQ);
    paramParcel.writeInt(this.roomId);
    paramParcel.writeLong(this.ypH);
    paramParcel.writeLong(this.yrb);
    paramParcel.writeLong(this.GYR);
    AppMethodBeat.o(115106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipScoreState
 * JD-Core Version:    0.7.0.1
 */