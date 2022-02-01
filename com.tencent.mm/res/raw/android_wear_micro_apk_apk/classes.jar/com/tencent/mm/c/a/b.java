package com.tencent.mm.c.a;

import com.tencent.mm.sdk.platformtools.f;

public enum b
  implements a
{
  private a Xc = new c((byte)0);
  
  private b() {}
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    f.d("MicroMsg.ReportService", "idkeyStat [%d, %d] -> %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    this.Xc.a(paramLong1, paramLong2, paramLong3, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.c.a.b
 * JD-Core Version:    0.7.0.1
 */