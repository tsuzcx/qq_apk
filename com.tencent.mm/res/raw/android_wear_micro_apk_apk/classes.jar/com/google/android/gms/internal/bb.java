package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.d;

public final class bb<L>
{
  private volatile L LA;
  private final bc QO;
  private final bd<L> QP;
  
  bb(Looper paramLooper, L paramL, String paramString)
  {
    this.QO = new bc(this, paramLooper);
    this.LA = d.g(paramL, "Listener must not be null");
    this.QP = new bd(paramL, d.l(paramString));
  }
  
  public final void a(be<? super L> parambe)
  {
    d.g(parambe, "Notifier must not be null");
    parambe = this.QO.obtainMessage(1, parambe);
    this.QO.sendMessage(parambe);
  }
  
  final void b(be<? super L> parambe)
  {
    Object localObject = this.LA;
    if (localObject == null)
    {
      parambe.jl();
      return;
    }
    try
    {
      parambe.H(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      parambe.jl();
      throw localRuntimeException;
    }
  }
  
  public final void clear()
  {
    this.LA = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bb
 * JD-Core Version:    0.7.0.1
 */