package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.w;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class br
{
  public static final Status Px = new Status(8, "The connection to Google Play services was lost");
  private static final k<?>[] Py = new k[0];
  private final Map<h<?>, j> NX;
  private final bs PA = new bs()
  {
    public final void c(k<?> paramAnonymousk)
    {
      br.this.Pz.remove(paramAnonymousk);
    }
  };
  final Set<k<?>> Pz = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  
  public br(Map<h<?>, j> paramMap)
  {
    this.NX = paramMap;
  }
  
  final void b(k<? extends w> paramk)
  {
    this.Pz.add(paramk);
    paramk.a(this.PA);
  }
  
  public final void jh()
  {
    k[] arrayOfk = (k[])this.Pz.toArray(Py);
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      arrayOfk[i].b(Px);
      i += 1;
    }
  }
  
  public final void release()
  {
    k[] arrayOfk = (k[])this.Pz.toArray(Py);
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      k localk = arrayOfk[i];
      localk.a(null);
      if (localk.ig()) {
        this.Pz.remove(localk);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.br
 * JD-Core Version:    0.7.0.1
 */