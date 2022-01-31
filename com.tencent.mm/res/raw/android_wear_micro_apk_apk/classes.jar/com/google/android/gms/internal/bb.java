package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.d;

public final class bb<L>
{
  private volatile L JL;
  private final bc OZ;
  private final bd<L> Pa;
  
  bb(Looper paramLooper, L paramL, String paramString)
  {
    this.OZ = new bc(this, paramLooper);
    this.JL = d.e(paramL, "Listener must not be null");
    this.Pa = new bd(paramL, d.l(paramString));
  }
  
  public final void a(be<? super L> parambe)
  {
    d.e(parambe, "Notifier must not be null");
    parambe = this.OZ.obtainMessage(1, parambe);
    this.OZ.sendMessage(parambe);
  }
  
  final void b(be<? super L> parambe)
  {
    Object localObject = this.JL;
    if (localObject == null)
    {
      parambe.jc();
      return;
    }
    try
    {
      parambe.y(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      parambe.jc();
      throw localRuntimeException;
    }
  }
  
  public final void clear()
  {
    this.JL = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bb
 * JD-Core Version:    0.7.0.1
 */