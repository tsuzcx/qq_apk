package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.h;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

final class bv
  extends bn<com.google.android.gms.wearable.f>
{
  private final List<FutureTask<Boolean>> TW;
  
  bv(h<com.google.android.gms.wearable.f> paramh, List<FutureTask<Boolean>> paramList)
  {
    super(paramh);
    this.TW = paramList;
  }
  
  public final void a(zzci paramzzci)
  {
    B(new f(bj.bF(paramzzci.statusCode), paramzzci.Tw));
    if (paramzzci.statusCode != 0)
    {
      paramzzci = this.TW.iterator();
      while (paramzzci.hasNext()) {
        ((FutureTask)paramzzci.next()).cancel(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bv
 * JD-Core Version:    0.7.0.1
 */