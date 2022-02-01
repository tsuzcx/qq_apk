package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.d;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class bf
{
  private final Set<bb<?>> QS = Collections.newSetFromMap(new WeakHashMap());
  
  public final <L> bb<L> a(L paramL, Looper paramLooper, String paramString)
  {
    d.g(paramL, "Listener must not be null");
    d.g(paramLooper, "Looper must not be null");
    d.g(paramString, "Listener type must not be null");
    paramL = new bb(paramLooper, paramL, paramString);
    this.QS.add(paramL);
    return paramL;
  }
  
  public final void release()
  {
    Iterator localIterator = this.QS.iterator();
    while (localIterator.hasNext()) {
      ((bb)localIterator.next()).clear();
    }
    this.QS.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bf
 * JD-Core Version:    0.7.0.1
 */