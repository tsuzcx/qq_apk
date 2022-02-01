package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RecoveryCrash
{
  public long InZ;
  public String Ioa;
  g Iob;
  public c Ioc;
  final Context mContext;
  
  private RecoveryCrash(Context paramContext)
  {
    AppMethodBeat.i(195283);
    this.mContext = paramContext;
    this.Iob = new g.a(paramContext, "recovery_crash");
    AppMethodBeat.o(195283);
  }
  
  RecoveryCrash(Context paramContext, long paramLong, String paramString, g paramg, c paramc)
  {
    this.mContext = paramContext;
    this.InZ = paramLong;
    this.Ioa = paramString;
    this.Iob = paramg;
    this.Ioc = paramc;
  }
  
  private void fkP()
  {
    AppMethodBeat.i(195284);
    this.Ioc = c.hR(this.mContext);
    AppMethodBeat.o(195284);
  }
  
  public static RecoveryCrash hP(Context paramContext)
  {
    AppMethodBeat.i(195281);
    paramContext = new RecoveryCrash(paramContext);
    paramContext.fkP();
    paramContext.fkQ();
    AppMethodBeat.o(195281);
    return paramContext;
  }
  
  public static RecoveryCrash hQ(Context paramContext)
  {
    AppMethodBeat.i(195282);
    paramContext = new RecoveryCrash(paramContext);
    paramContext.fkP();
    AppMethodBeat.o(195282);
    return paramContext;
  }
  
  public final RecoveryCrash aaC(int paramInt)
  {
    this.Ioc.Ioe = paramInt;
    return this;
  }
  
  public final void fkQ()
  {
    AppMethodBeat.i(195285);
    this.Iob.fkT();
    if (this.Ioa != null)
    {
      AppMethodBeat.o(195285);
      return;
    }
    this.Ioa = this.Iob.getString("crash_version", null);
    this.InZ = Math.max(this.Iob.getLong("crash_time", 0L), 0L);
    AppMethodBeat.o(195285);
  }
  
  public final RecoveryCrash fkR()
  {
    this.Ioc.Ioe = 0;
    this.InZ = 0L;
    this.Ioa = null;
    return this;
  }
  
  public final Record fkS()
  {
    AppMethodBeat.i(195287);
    fkQ();
    Record localRecord = new Record();
    localRecord.crashCount = this.Ioc.Ioe;
    localRecord.GIb = this.InZ;
    localRecord.Iod = this.Ioa;
    AppMethodBeat.o(195287);
    return localRecord;
  }
  
  public final void save()
  {
    AppMethodBeat.i(195286);
    this.Ioc.save();
    this.Iob.lM("crash_version", this.Ioa).bS("crash_time", this.InZ).fkU();
    AppMethodBeat.o(195286);
  }
  
  public static class Record
    implements Parcelable
  {
    public static final Parcelable.Creator<Record> CREATOR;
    public long GIb;
    public String Iod;
    public int crashCount;
    
    static
    {
      AppMethodBeat.i(195280);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195280);
    }
    
    Record() {}
    
    protected Record(Parcel paramParcel)
    {
      AppMethodBeat.i(195278);
      this.crashCount = paramParcel.readInt();
      this.GIb = paramParcel.readLong();
      this.Iod = paramParcel.readString();
      AppMethodBeat.o(195278);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(195279);
      paramParcel.writeInt(this.crashCount);
      paramParcel.writeLong(this.GIb);
      paramParcel.writeString(this.Iod);
      AppMethodBeat.o(195279);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.RecoveryCrash
 * JD-Core Version:    0.7.0.1
 */