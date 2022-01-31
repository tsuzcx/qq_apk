package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.r;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

final class ab
  implements r
{
  private final a<?> HU;
  private final boolean MH;
  private final WeakReference<aa> NI;
  
  public ab(aa paramaa, a<?> parama, boolean paramBoolean)
  {
    this.NI = new WeakReference(paramaa);
    this.HU = parama;
    this.MH = paramBoolean;
  }
  
  public final void c(ConnectionResult paramConnectionResult)
  {
    aa localaa = (aa)this.NI.get();
    if (localaa == null) {
      return;
    }
    boolean bool;
    if (Looper.myLooper() == aa.d(localaa).MJ.getLooper()) {
      bool = true;
    }
    for (;;)
    {
      d.a(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
      aa.c(localaa).lock();
      try
      {
        bool = aa.k(localaa);
        if (!bool)
        {
          return;
          bool = false;
          continue;
        }
        if (!paramConnectionResult.gm()) {
          aa.a(localaa, paramConnectionResult, this.HU, this.MH);
        }
        if (aa.l(localaa)) {
          aa.j(localaa);
        }
        return;
      }
      finally
      {
        aa.c(localaa).unlock();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ab
 * JD-Core Version:    0.7.0.1
 */