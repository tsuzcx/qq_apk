package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.w;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class br
{
  public static final Status Rm = new Status(8, "The connection to Google Play services was lost");
  private static final k<?>[] Rn = new k[0];
  private final Map<h<?>, j> PM;
  final Set<k<?>> Ro = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
  private final bs Rp = new bs()
  {
    public final void c(k<?> paramAnonymousk)
    {
      br.this.Ro.remove(paramAnonymousk);
    }
  };
  
  public br(Map<h<?>, j> paramMap)
  {
    this.PM = paramMap;
  }
  
  final void b(k<? extends w> paramk)
  {
    this.Ro.add(paramk);
    paramk.a(this.Rp);
  }
  
  public final void dump(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(this.Ro.size());
  }
  
  public final void jq()
  {
    k[] arrayOfk = (k[])this.Ro.toArray(Rn);
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      arrayOfk[i].b(Rm);
      i += 1;
    }
  }
  
  public final void release()
  {
    k[] arrayOfk = (k[])this.Ro.toArray(Rn);
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      k localk = arrayOfk[i];
      localk.a(null);
      if (localk.io()) {
        this.Ro.remove(localk);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.br
 * JD-Core Version:    0.7.0.1
 */