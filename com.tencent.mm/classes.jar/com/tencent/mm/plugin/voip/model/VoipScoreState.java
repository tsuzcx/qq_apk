package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class VoipScoreState
  implements Parcelable
{
  public static final Parcelable.Creator<VoipScoreState> CREATOR;
  public int nMZ;
  public long nNa;
  public long nOy;
  public String tyO;
  public int tyP;
  public long tyQ;
  
  static
  {
    AppMethodBeat.i(4600);
    CREATOR = new VoipScoreState.1();
    AppMethodBeat.o(4600);
  }
  
  public VoipScoreState()
  {
    AppMethodBeat.i(4594);
    this.tyO = "";
    this.tyP = -1;
    this.nMZ = -1;
    this.nNa = -1L;
    this.nOy = -1L;
    this.tyQ = 0L;
    ab.b("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
    AppMethodBeat.o(4594);
  }
  
  protected VoipScoreState(Parcel paramParcel)
  {
    AppMethodBeat.i(4595);
    this.tyO = "";
    this.tyP = -1;
    this.nMZ = -1;
    this.nNa = -1L;
    this.nOy = -1L;
    this.tyQ = 0L;
    this.tyO = paramParcel.readString();
    this.tyP = paramParcel.readInt();
    this.nMZ = paramParcel.readInt();
    this.nNa = paramParcel.readLong();
    this.nOy = paramParcel.readLong();
    this.tyQ = paramParcel.readLong();
    AppMethodBeat.o(4595);
  }
  
  public static void cNR()
  {
    AppMethodBeat.i(4597);
    long l = bf.aaM();
    g.RM();
    g.RL().Ru().set(ac.a.yKy, Long.valueOf(l));
    ab.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", new Object[] { Long.valueOf(l) });
    AppMethodBeat.o(4597);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(4596);
    ab.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1) });
    this.nMZ = paramInt2;
    this.nNa = paramLong;
    if (!bo.isNullOrNil(paramString)) {
      try
      {
        paramString = new String(Base64.decode(paramString.getBytes(), 0));
        ab.b("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", new Object[] { paramString, Integer.valueOf(paramInt1) });
        this.tyP = paramInt1;
        this.tyO = paramString;
        AppMethodBeat.o(4596);
        return;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.VoipScoreState", paramString, "setScoreState error: %s", new Object[] { paramString.getMessage() });
      }
    }
    AppMethodBeat.o(4596);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(4599);
    String str = "VoipScoreState{scoreTitle='" + this.tyO + '\'' + ", scoreIntervalDay=" + this.tyP + ", roomId=" + this.nMZ + ", roomKey=" + this.nNa + ", startTalkTime=" + this.nOy + ", lastShowScoreTime=" + this.tyQ + '}';
    AppMethodBeat.o(4599);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4598);
    paramParcel.writeString(this.tyO);
    paramParcel.writeInt(this.tyP);
    paramParcel.writeInt(this.nMZ);
    paramParcel.writeLong(this.nNa);
    paramParcel.writeLong(this.nOy);
    paramParcel.writeLong(this.tyQ);
    AppMethodBeat.o(4598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipScoreState
 * JD-Core Version:    0.7.0.1
 */