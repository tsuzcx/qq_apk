package com.tencent.mm.wear.app.d;

import com.tencent.mm.wear.app.a.e;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.g.a;

final class b
  extends a
{
  public byte[] data;
  
  protected final void execute()
  {
    com.tencent.mm.wear.app.a.g localg = new com.tencent.mm.wear.app.a.g();
    localg.aep = 11035;
    localg.data = this.data;
    e locale = new e(h.mO().mF());
    locale.mB();
    locale.a(localg);
  }
  
  protected final String getName()
  {
    return "KvReportTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.b
 * JD-Core Version:    0.7.0.1
 */