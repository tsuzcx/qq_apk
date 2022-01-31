package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.internal.bb;

final class u<T>
  extends ci<Status>
{
  private T JL;
  private bb<T> Ph;
  private v<T> Tp;
  
  private u(p paramp, T paramT, bb<T> parambb, v<T> paramv)
  {
    super(paramp);
    this.JL = d.u(paramT);
    this.Ph = ((bb)d.u(parambb));
    this.Tp = ((v)d.u(paramv));
  }
  
  static <T> t<Status> a(p paramp, v<T> paramv, T paramT)
  {
    return paramp.a(new u(paramp, paramT, paramp.s(paramT), paramv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.u
 * JD-Core Version:    0.7.0.1
 */