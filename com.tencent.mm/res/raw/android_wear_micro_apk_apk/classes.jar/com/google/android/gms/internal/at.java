package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.api.ad;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.w;

public final class at<O extends b>
  extends y
{
  private final ad<O> OO;
  
  public at(ad<O> paramad)
  {
    super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    this.OO = paramad;
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    return this.OO.c(paramT);
  }
  
  public final void a(bp parambp) {}
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    return this.OO.d(paramT);
  }
  
  public final void b(bp parambp) {}
  
  public final Looper getLooper()
  {
    return this.OO.getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.at
 * JD-Core Version:    0.7.0.1
 */