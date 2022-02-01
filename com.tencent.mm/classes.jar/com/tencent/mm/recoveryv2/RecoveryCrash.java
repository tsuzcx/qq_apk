package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RecoveryCrash
{
  long UPa;
  String UPb;
  h UPc;
  c UPd;
  final Context mContext;
  
  private RecoveryCrash(Context paramContext)
  {
    AppMethodBeat.i(189951);
    this.mContext = paramContext;
    this.UPc = new h.a(paramContext, "recovery_crash");
    AppMethodBeat.o(189951);
  }
  
  RecoveryCrash(Context paramContext, long paramLong, String paramString, h paramh, c paramc)
  {
    this.mContext = paramContext;
    this.UPa = paramLong;
    this.UPb = paramString;
    this.UPc = paramh;
    this.UPd = paramc;
  }
  
  private void hpY()
  {
    AppMethodBeat.i(189955);
    this.UPd = c.jN(this.mContext);
    AppMethodBeat.o(189955);
  }
  
  public static RecoveryCrash jL(Context paramContext)
  {
    AppMethodBeat.i(189946);
    paramContext = new RecoveryCrash(paramContext);
    paramContext.hpY();
    paramContext.hpZ();
    AppMethodBeat.o(189946);
    return paramContext;
  }
  
  public static RecoveryCrash jM(Context paramContext)
  {
    AppMethodBeat.i(189947);
    paramContext = new RecoveryCrash(paramContext);
    paramContext.hpY();
    AppMethodBeat.o(189947);
    return paramContext;
  }
  
  public final RecoveryCrash Uf(long paramLong)
  {
    this.UPa = paramLong;
    return this;
  }
  
  public final RecoveryCrash arG(int paramInt)
  {
    this.UPd.UPf = paramInt;
    return this;
  }
  
  public final void arg()
  {
    AppMethodBeat.i(189962);
    c localc = this.UPd;
    localc.UPc.hu("crash_count", localc.UPf).hqg();
    this.UPc.nB("crash_version", this.UPb).ca("crash_time", this.UPa).hqg();
    AppMethodBeat.o(189962);
  }
  
  public final void hpZ()
  {
    AppMethodBeat.i(189957);
    this.UPc.hqf();
    if (this.UPb != null)
    {
      AppMethodBeat.o(189957);
      return;
    }
    this.UPb = this.UPc.getString("crash_version", null);
    this.UPa = Math.max(this.UPc.getLong("crash_time", 0L), 0L);
    AppMethodBeat.o(189957);
  }
  
  public final long hqa()
  {
    return this.UPa;
  }
  
  public final int hqb()
  {
    return this.UPd.UPf;
  }
  
  public final String hqc()
  {
    return this.UPb;
  }
  
  public final RecoveryCrash hqd()
  {
    this.UPd.UPf = 0;
    this.UPa = 0L;
    this.UPb = null;
    return this;
  }
  
  public final Record hqe()
  {
    AppMethodBeat.i(189963);
    hpZ();
    Record localRecord = new Record();
    localRecord.SSh = this.UPd.UPf;
    localRecord.SSg = this.UPa;
    localRecord.UPe = this.UPb;
    AppMethodBeat.o(189963);
    return localRecord;
  }
  
  public static class Record
    implements Parcelable
  {
    public static final Parcelable.Creator<Record> CREATOR;
    public long SSg;
    public int SSh;
    public String UPe;
    
    static
    {
      AppMethodBeat.i(189943);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(189943);
    }
    
    Record() {}
    
    protected Record(Parcel paramParcel)
    {
      AppMethodBeat.i(189938);
      this.SSh = paramParcel.readInt();
      this.SSg = paramParcel.readLong();
      this.UPe = paramParcel.readString();
      AppMethodBeat.o(189938);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(189942);
      paramParcel.writeInt(this.SSh);
      paramParcel.writeLong(this.SSg);
      paramParcel.writeString(this.UPe);
      AppMethodBeat.o(189942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.RecoveryCrash
 * JD-Core Version:    0.7.0.1
 */