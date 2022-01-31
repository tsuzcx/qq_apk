package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class VoipScoreState
  implements Parcelable
{
  public static final Parcelable.Creator<VoipScoreState> CREATOR = new VoipScoreState.1();
  public int lpD = -1;
  public long lpE = -1L;
  public long lrc = -1L;
  public String pTn = "";
  public int pTo = -1;
  public long pTp = 0L;
  
  public VoipScoreState()
  {
    y.l("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
  }
  
  protected VoipScoreState(Parcel paramParcel)
  {
    this.pTn = paramParcel.readString();
    this.pTo = paramParcel.readInt();
    this.lpD = paramParcel.readInt();
    this.lpE = paramParcel.readLong();
    this.lrc = paramParcel.readLong();
    this.pTp = paramParcel.readLong();
  }
  
  public static void bRa()
  {
    long l = bd.HM();
    g.DQ();
    g.DP().Dz().c(ac.a.uzG, Long.valueOf(l));
    y.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", new Object[] { Long.valueOf(l) });
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    y.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1) });
    this.lpD = paramInt2;
    this.lpE = paramLong;
    if (!bk.bl(paramString)) {}
    try
    {
      paramString = new String(Base64.decode(paramString.getBytes(), 0));
      y.l("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
      this.pTo = paramInt1;
      this.pTn = paramString;
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.VoipScoreState", paramString, "setScoreState error: %s", new Object[] { paramString.getMessage() });
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "VoipScoreState{scoreTitle='" + this.pTn + '\'' + ", scoreIntervalDay=" + this.pTo + ", roomId=" + this.lpD + ", roomKey=" + this.lpE + ", startTalkTime=" + this.lrc + ", lastShowScoreTime=" + this.pTp + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.pTn);
    paramParcel.writeInt(this.pTo);
    paramParcel.writeInt(this.lpD);
    paramParcel.writeLong(this.lpE);
    paramParcel.writeLong(this.lrc);
    paramParcel.writeLong(this.pTp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipScoreState
 * JD-Core Version:    0.7.0.1
 */