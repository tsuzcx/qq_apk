package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.w;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public final class ah
  implements al
{
  private final am Ns;
  
  public ah(am paramam)
  {
    this.Ns = paramam;
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    this.Ns.MJ.Nf.add(paramT);
    return paramT;
  }
  
  public final void a(ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean) {}
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final void bd(int paramInt) {}
  
  public final void begin()
  {
    Iterator localIterator = this.Ns.NX.values().iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).disconnect();
    }
    this.Ns.MJ.NY = Collections.emptySet();
  }
  
  public final void connect()
  {
    this.Ns.iE();
  }
  
  public final boolean disconnect()
  {
    return true;
  }
  
  public final void h(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ah
 * JD-Core Version:    0.7.0.1
 */