package com.google.android.gms.internal;

import com.google.android.gms.b.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ab;
import com.google.android.gms.common.api.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class w
{
  private final Map<k<?>, Boolean> Pb = Collections.synchronizedMap(new WeakHashMap());
  private final Map<c<?>, Boolean> Pc = Collections.synchronizedMap(new WeakHashMap());
  
  private void a(boolean paramBoolean, Status paramStatus)
  {
    Object localObject2;
    synchronized (this.Pb)
    {
      localObject2 = new HashMap(this.Pb);
    }
    synchronized (this.Pc)
    {
      ??? = new HashMap(this.Pc);
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (Map.Entry)((Iterator)localObject2).next();
        if ((paramBoolean) || (((Boolean)((Map.Entry)???).getValue()).booleanValue()))
        {
          ((k)((Map.Entry)???).getKey()).b(paramStatus);
          continue;
          paramStatus = finally;
          throw paramStatus;
        }
      }
    }
    ??? = ((Map)???).entrySet().iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)???).next();
      if ((paramBoolean) || (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())) {
        ((c)((Map.Entry)localObject2).getKey()).b(new ab(paramStatus));
      }
    }
  }
  
  final void a(final k<? extends com.google.android.gms.common.api.w> paramk, boolean paramBoolean)
  {
    this.Pb.put(paramk, Boolean.valueOf(paramBoolean));
    paramk.a(new u()
    {
      public final void gL()
      {
        w.a(w.this).remove(paramk);
      }
    });
  }
  
  final boolean ix()
  {
    return (!this.Pb.isEmpty()) || (!this.Pc.isEmpty());
  }
  
  public final void iy()
  {
    a(false, aq.Qg);
  }
  
  public final void iz()
  {
    a(true, br.Rm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.w
 * JD-Core Version:    0.7.0.1
 */