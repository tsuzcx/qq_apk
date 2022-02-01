package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RecoveryCrash
{
  public long acjR;
  public String acjS;
  final f acjT;
  public final b acjU;
  
  private RecoveryCrash(long paramLong, String paramString, b paramb, f paramf)
  {
    this.acjR = paramLong;
    this.acjS = paramString;
    this.acjT = paramf;
    this.acjU = paramb;
  }
  
  private RecoveryCrash(b paramb, f paramf)
  {
    this.acjT = paramf;
    this.acjU = paramb;
  }
  
  public static RecoveryCrash lK(Context paramContext)
  {
    AppMethodBeat.i(237960);
    paramContext = new RecoveryCrash(b.lN(paramContext), g.lQ(paramContext));
    paramContext.acjU.reload();
    AppMethodBeat.o(237960);
    return paramContext;
  }
  
  public static RecoveryCrash lL(Context paramContext)
  {
    AppMethodBeat.i(237968);
    paramContext = new RecoveryCrash(b.lN(paramContext), g.lQ(paramContext));
    paramContext.acjU.reload();
    paramContext.iQB();
    AppMethodBeat.o(237968);
    return paramContext;
  }
  
  public static RecoveryCrash lM(Context paramContext)
  {
    AppMethodBeat.i(237973);
    paramContext = new RecoveryCrash(new b(new f.a(paramContext, "recovery_crash_count_isolated").iQF()), new f.a(paramContext, "recovery_crash_isolated"));
    paramContext.acjU.reload();
    paramContext.iQB();
    AppMethodBeat.o(237973);
    return paramContext;
  }
  
  public final RecoveryCrash axO(int paramInt)
  {
    this.acjU.acjW = paramInt;
    return this;
  }
  
  public final void iQB()
  {
    AppMethodBeat.i(237992);
    this.acjT.iQF();
    if (this.acjS != null)
    {
      AppMethodBeat.o(237992);
      return;
    }
    this.acjS = this.acjT.getString("crash_version", null);
    this.acjR = Math.max(this.acjT.getLong("crash_time", 0L), 0L);
    AppMethodBeat.o(237992);
  }
  
  public final RecoveryCrash iQC()
  {
    AppMethodBeat.i(237998);
    long l = this.acjR;
    Object localObject = this.acjS;
    b localb = this.acjU;
    localObject = new RecoveryCrash(l, (String)localObject, new b(localb.acjW, localb.acjT), this.acjT);
    AppMethodBeat.o(237998);
    return localObject;
  }
  
  public final RecoveryCrash iQD()
  {
    AppMethodBeat.i(238010);
    k.b.a.log(5, "MicroMsg.recovery.crash", "reset crash record!");
    this.acjU.acjW = 0;
    this.acjR = 0L;
    this.acjS = null;
    AppMethodBeat.o(238010);
    return this;
  }
  
  public final Record iQE()
  {
    AppMethodBeat.i(238028);
    iQB();
    Record localRecord = new Record();
    localRecord.aabv = this.acjU.acjW;
    localRecord.aabu = this.acjR;
    localRecord.acjV = this.acjS;
    AppMethodBeat.o(238028);
    return localRecord;
  }
  
  public final void sz()
  {
    AppMethodBeat.i(238019);
    this.acjU.sz();
    this.acjT.px("crash_version", this.acjS).cm("crash_time", this.acjR).iQG();
    AppMethodBeat.o(238019);
  }
  
  public static class Record
    implements Parcelable
  {
    public static final Parcelable.Creator<Record> CREATOR;
    public long aabu;
    public int aabv;
    public String acjV;
    
    static
    {
      AppMethodBeat.i(238064);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(238064);
    }
    
    Record() {}
    
    protected Record(Parcel paramParcel)
    {
      AppMethodBeat.i(238058);
      this.aabv = paramParcel.readInt();
      this.aabu = paramParcel.readLong();
      this.acjV = paramParcel.readString();
      AppMethodBeat.o(238058);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(238074);
      paramParcel.writeInt(this.aabv);
      paramParcel.writeLong(this.aabu);
      paramParcel.writeString(this.acjV);
      AppMethodBeat.o(238074);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.RecoveryCrash
 * JD-Core Version:    0.7.0.1
 */