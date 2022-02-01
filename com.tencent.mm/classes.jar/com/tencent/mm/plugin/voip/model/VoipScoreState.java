package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public class VoipScoreState
  implements Parcelable
{
  public static final Parcelable.Creator<VoipScoreState> CREATOR;
  public long DPJ;
  public long DRd;
  public String NPc;
  public int NPd;
  public long NPe;
  public int roomId;
  
  static
  {
    AppMethodBeat.i(115108);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(115108);
  }
  
  public VoipScoreState()
  {
    AppMethodBeat.i(115102);
    this.NPc = "";
    this.NPd = -1;
    this.roomId = -1;
    this.DPJ = -1L;
    this.DRd = -1L;
    this.NPe = 0L;
    Log.printInfoStack("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
    AppMethodBeat.o(115102);
  }
  
  protected VoipScoreState(Parcel paramParcel)
  {
    AppMethodBeat.i(115103);
    this.NPc = "";
    this.NPd = -1;
    this.roomId = -1;
    this.DPJ = -1L;
    this.DRd = -1L;
    this.NPe = 0L;
    this.NPc = paramParcel.readString();
    this.NPd = paramParcel.readInt();
    this.roomId = paramParcel.readInt();
    this.DPJ = paramParcel.readLong();
    this.DRd = paramParcel.readLong();
    this.NPe = paramParcel.readLong();
    AppMethodBeat.o(115103);
  }
  
  public static void gAe()
  {
    AppMethodBeat.i(115105);
    long l = bq.beS();
    h.aHH();
    h.aHG().aHp().set(ar.a.Vvu, Long.valueOf(l));
    Log.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(115105);
  }
  
  public final void d(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(115104);
    Log.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1) });
    this.roomId = paramInt2;
    this.DPJ = paramLong;
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = new String(Base64.decode(paramString.getBytes(), 0));
        Log.printInfoStack("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
        this.NPd = paramInt1;
        this.NPc = paramString;
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
  
  public final boolean gAd()
  {
    AppMethodBeat.i(242146);
    h.aHH();
    long l2 = ((Long)h.aHG().aHp().get(ar.a.Vvu, Long.valueOf(-1L))).longValue();
    if (l2 > 0L) {}
    for (long l1 = l2;; l1 = 0L)
    {
      this.NPe = l1;
      l1 = bq.beS();
      Log.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.NPd) });
      if ((Util.isNullOrNil(this.NPc)) || (this.NPd <= 0) || ((l2 > 0L) && (l1 - l2 <= this.NPd * 86400000L))) {
        break;
      }
      Log.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
      AppMethodBeat.o(242146);
      return true;
    }
    AppMethodBeat.o(242146);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(115107);
    String str = "VoipScoreState{scoreTitle='" + this.NPc + '\'' + ", scoreIntervalDay=" + this.NPd + ", roomId=" + this.roomId + ", roomKey=" + this.DPJ + ", startTalkTime=" + this.DRd + ", lastShowScoreTime=" + this.NPe + '}';
    AppMethodBeat.o(115107);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(115106);
    paramParcel.writeString(this.NPc);
    paramParcel.writeInt(this.NPd);
    paramParcel.writeInt(this.roomId);
    paramParcel.writeLong(this.DPJ);
    paramParcel.writeLong(this.DRd);
    paramParcel.writeLong(this.NPe);
    AppMethodBeat.o(115106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipScoreState
 * JD-Core Version:    0.7.0.1
 */