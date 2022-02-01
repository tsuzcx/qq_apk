package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public class VoipScoreState
  implements Parcelable
{
  public static final Parcelable.Creator<VoipScoreState> CREATOR;
  public long Hnt;
  public long JIn;
  public String UBB;
  public int UBC;
  public long UBD;
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
    this.UBB = "";
    this.UBC = -1;
    this.roomId = -1;
    this.Hnt = -1L;
    this.JIn = -1L;
    this.UBD = 0L;
    Log.printInfoStack("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
    AppMethodBeat.o(115102);
  }
  
  protected VoipScoreState(Parcel paramParcel)
  {
    AppMethodBeat.i(115103);
    this.UBB = "";
    this.UBC = -1;
    this.roomId = -1;
    this.Hnt = -1L;
    this.JIn = -1L;
    this.UBD = 0L;
    this.UBB = paramParcel.readString();
    this.UBC = paramParcel.readInt();
    this.roomId = paramParcel.readInt();
    this.Hnt = paramParcel.readLong();
    this.JIn = paramParcel.readLong();
    this.UBD = paramParcel.readLong();
    AppMethodBeat.o(115103);
  }
  
  public static void hYk()
  {
    AppMethodBeat.i(115105);
    long l = br.bCJ();
    h.baF();
    h.baE().ban().set(at.a.acXd, Long.valueOf(l));
    Log.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(115105);
  }
  
  public final void d(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(115104);
    Log.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1) });
    this.roomId = paramInt2;
    this.Hnt = paramLong;
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        paramString = new String(Base64.decode(paramString.getBytes(), 0));
        Log.printInfoStack("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
        this.UBC = paramInt1;
        this.UBB = paramString;
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
  
  public final boolean hYj()
  {
    AppMethodBeat.i(293333);
    h.baF();
    long l2 = ((Long)h.baE().ban().get(at.a.acXd, Long.valueOf(-1L))).longValue();
    if (l2 > 0L) {}
    for (long l1 = l2;; l1 = 0L)
    {
      this.UBD = l1;
      l1 = br.bCJ();
      Log.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.UBC) });
      if ((Util.isNullOrNil(this.UBB)) || (this.UBC <= 0) || ((l2 > 0L) && (l1 - l2 <= this.UBC * 86400000L))) {
        break;
      }
      Log.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
      AppMethodBeat.o(293333);
      return true;
    }
    AppMethodBeat.o(293333);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(115107);
    String str = "VoipScoreState{scoreTitle='" + this.UBB + '\'' + ", scoreIntervalDay=" + this.UBC + ", roomId=" + this.roomId + ", roomKey=" + this.Hnt + ", startTalkTime=" + this.JIn + ", lastShowScoreTime=" + this.UBD + '}';
    AppMethodBeat.o(115107);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(115106);
    paramParcel.writeString(this.UBB);
    paramParcel.writeInt(this.UBC);
    paramParcel.writeInt(this.roomId);
    paramParcel.writeLong(this.Hnt);
    paramParcel.writeLong(this.JIn);
    paramParcel.writeLong(this.UBD);
    AppMethodBeat.o(115106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipScoreState
 * JD-Core Version:    0.7.0.1
 */