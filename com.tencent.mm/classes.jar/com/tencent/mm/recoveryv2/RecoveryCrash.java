package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RecoveryCrash
{
  public long HTR;
  public String HTS;
  g HTT;
  public c HTU;
  final Context mContext;
  
  private RecoveryCrash(Context paramContext)
  {
    AppMethodBeat.i(206975);
    this.mContext = paramContext;
    this.HTT = new g.a(paramContext, "recovery_crash");
    AppMethodBeat.o(206975);
  }
  
  RecoveryCrash(Context paramContext, long paramLong, String paramString, g paramg, c paramc)
  {
    this.mContext = paramContext;
    this.HTR = paramLong;
    this.HTS = paramString;
    this.HTT = paramg;
    this.HTU = paramc;
  }
  
  private void fgX()
  {
    AppMethodBeat.i(206976);
    this.HTU = c.hL(this.mContext);
    AppMethodBeat.o(206976);
  }
  
  public static RecoveryCrash hJ(Context paramContext)
  {
    AppMethodBeat.i(206973);
    paramContext = new RecoveryCrash(paramContext);
    paramContext.fgX();
    paramContext.fgY();
    AppMethodBeat.o(206973);
    return paramContext;
  }
  
  public static RecoveryCrash hK(Context paramContext)
  {
    AppMethodBeat.i(206974);
    paramContext = new RecoveryCrash(paramContext);
    paramContext.fgX();
    AppMethodBeat.o(206974);
    return paramContext;
  }
  
  public final RecoveryCrash ZW(int paramInt)
  {
    this.HTU.HTW = paramInt;
    return this;
  }
  
  public final void fgY()
  {
    AppMethodBeat.i(206977);
    this.HTT.fhb();
    if (this.HTS != null)
    {
      AppMethodBeat.o(206977);
      return;
    }
    this.HTS = this.HTT.getString("crash_version", null);
    this.HTR = Math.max(this.HTT.getLong("crash_time", 0L), 0L);
    AppMethodBeat.o(206977);
  }
  
  public final RecoveryCrash fgZ()
  {
    this.HTU.HTW = 0;
    this.HTR = 0L;
    this.HTS = null;
    return this;
  }
  
  public final Record fha()
  {
    AppMethodBeat.i(206979);
    fgY();
    Record localRecord = new Record();
    localRecord.crashCount = this.HTU.HTW;
    localRecord.GoL = this.HTR;
    localRecord.HTV = this.HTS;
    AppMethodBeat.o(206979);
    return localRecord;
  }
  
  public final void save()
  {
    AppMethodBeat.i(206978);
    this.HTU.save();
    this.HTT.lF("crash_version", this.HTS).bR("crash_time", this.HTR).fhc();
    AppMethodBeat.o(206978);
  }
  
  public static class Record
    implements Parcelable
  {
    public static final Parcelable.Creator<Record> CREATOR;
    public long GoL;
    public String HTV;
    public int crashCount;
    
    static
    {
      AppMethodBeat.i(206972);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(206972);
    }
    
    Record() {}
    
    protected Record(Parcel paramParcel)
    {
      AppMethodBeat.i(206970);
      this.crashCount = paramParcel.readInt();
      this.GoL = paramParcel.readLong();
      this.HTV = paramParcel.readString();
      AppMethodBeat.o(206970);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(206971);
      paramParcel.writeInt(this.crashCount);
      paramParcel.writeLong(this.GoL);
      paramParcel.writeString(this.HTV);
      AppMethodBeat.o(206971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.RecoveryCrash
 * JD-Core Version:    0.7.0.1
 */