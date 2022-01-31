package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.b.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ab;
import java.util.Map;

public final class ed
  extends eb
{
  public final bd<?> RR;
  
  public ed(bd<?> parambd, c<Void> paramc)
  {
    super(paramc);
    this.RR = parambd;
  }
  
  public final void d(ar<?> paramar)
  {
    paramar = (bi)paramar.iP().remove(this.RR);
    if (paramar != null)
    {
      paramar.Pi.jd();
      return;
    }
    Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
    this.RP.b(new ab(Status.HN));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ed
 * JD-Core Version:    0.7.0.1
 */