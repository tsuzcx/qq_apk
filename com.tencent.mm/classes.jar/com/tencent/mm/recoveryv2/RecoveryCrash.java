package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RecoveryCrash
{
  public c NBA;
  public long NBx;
  public String NBy;
  g NBz;
  final Context mContext;
  
  private RecoveryCrash(Context paramContext)
  {
    AppMethodBeat.i(193771);
    this.mContext = paramContext;
    this.NBz = new g.a(paramContext, "recovery_crash");
    AppMethodBeat.o(193771);
  }
  
  RecoveryCrash(Context paramContext, long paramLong, String paramString, g paramg, c paramc)
  {
    this.mContext = paramContext;
    this.NBx = paramLong;
    this.NBy = paramString;
    this.NBz = paramg;
    this.NBA = paramc;
  }
  
  private void guA()
  {
    AppMethodBeat.i(193772);
    this.NBA = c.iK(this.mContext);
    AppMethodBeat.o(193772);
  }
  
  public static RecoveryCrash iI(Context paramContext)
  {
    AppMethodBeat.i(193769);
    paramContext = new RecoveryCrash(paramContext);
    paramContext.guA();
    paramContext.guB();
    AppMethodBeat.o(193769);
    return paramContext;
  }
  
  public static RecoveryCrash iJ(Context paramContext)
  {
    AppMethodBeat.i(193770);
    paramContext = new RecoveryCrash(paramContext);
    paramContext.guA();
    AppMethodBeat.o(193770);
    return paramContext;
  }
  
  public final RecoveryCrash ajr(int paramInt)
  {
    this.NBA.NBC = paramInt;
    return this;
  }
  
  public final void guB()
  {
    AppMethodBeat.i(193773);
    this.NBz.guE();
    if (this.NBy != null)
    {
      AppMethodBeat.o(193773);
      return;
    }
    this.NBy = this.NBz.getString("crash_version", null);
    this.NBx = Math.max(this.NBz.getLong("crash_time", 0L), 0L);
    AppMethodBeat.o(193773);
  }
  
  public final RecoveryCrash guC()
  {
    this.NBA.NBC = 0;
    this.NBx = 0L;
    this.NBy = null;
    return this;
  }
  
  public final Record guD()
  {
    AppMethodBeat.i(193775);
    guB();
    Record localRecord = new Record();
    localRecord.crashCount = this.NBA.NBC;
    localRecord.LKH = this.NBx;
    localRecord.NBB = this.NBy;
    AppMethodBeat.o(193775);
    return localRecord;
  }
  
  public final void save()
  {
    AppMethodBeat.i(193774);
    this.NBA.save();
    this.NBz.mK("crash_version", this.NBy).bT("crash_time", this.NBx).guF();
    AppMethodBeat.o(193774);
  }
  
  public static class Record
    implements Parcelable
  {
    public static final Parcelable.Creator<Record> CREATOR;
    public long LKH;
    public String NBB;
    public int crashCount;
    
    static
    {
      AppMethodBeat.i(193768);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(193768);
    }
    
    Record() {}
    
    protected Record(Parcel paramParcel)
    {
      AppMethodBeat.i(193766);
      this.crashCount = paramParcel.readInt();
      this.LKH = paramParcel.readLong();
      this.NBB = paramParcel.readString();
      AppMethodBeat.o(193766);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(193767);
      paramParcel.writeInt(this.crashCount);
      paramParcel.writeLong(this.LKH);
      paramParcel.writeString(this.NBB);
      AppMethodBeat.o(193767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.RecoveryCrash
 * JD-Core Version:    0.7.0.1
 */