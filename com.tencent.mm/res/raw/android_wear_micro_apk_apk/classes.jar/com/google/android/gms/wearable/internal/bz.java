package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.be;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.g;
import com.google.android.gms.wearable.q;
import com.google.android.gms.wearable.x;
import java.util.List;

public final class bz<T>
  extends an
{
  private bb<Object> Wc;
  private bb<Object> Wd;
  private bb<g> We;
  private bb<q> Wf;
  private bb<x> Wg;
  private bb<Object> Wh;
  private bb<c> Wi;
  private bb<Object> Wj;
  private final IntentFilter[] Wk;
  private final String Wl;
  
  private bz(IntentFilter[] paramArrayOfIntentFilter, String paramString)
  {
    this.Wk = ((IntentFilter[])d.D(paramArrayOfIntentFilter));
    this.Wl = null;
  }
  
  public static bz<c> a(bb<c> parambb, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new bz(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.Wi = ((bb)d.D(parambb));
    return paramArrayOfIntentFilter;
  }
  
  private static void a(bb<?> parambb)
  {
    if (parambb != null) {
      parambb.clear();
    }
  }
  
  public final void a(DataHolder paramDataHolder)
  {
    if (this.We != null)
    {
      this.We.a(new be()
      {
        public final void jl()
        {
          bz.this.close();
        }
      });
      return;
    }
    paramDataHolder.close();
  }
  
  public final void a(zzbz paramzzbz)
  {
    if (this.Wf != null) {
      this.Wf.a(new be()
      {
        public final void jl() {}
      });
    }
  }
  
  public final void a(zzcc paramzzcc)
  {
    if (this.Wg != null) {
      this.Wg.a(new be()
      {
        public final void jl() {}
      });
    }
  }
  
  public final void a(zzh paramzzh) {}
  
  public final void a(zzk paramzzk) {}
  
  public final void a(zzo paramzzo)
  {
    if (this.Wj != null) {
      this.Wj.a(new be()
      {
        public final void jl() {}
      });
    }
  }
  
  public final void a(zzs paramzzs)
  {
    if (this.Wi != null) {
      this.Wi.a(new be()
      {
        public final void jl() {}
      });
    }
  }
  
  public final void b(zzcc paramzzcc)
  {
    if (this.Wg != null) {
      this.Wg.a(new be()
      {
        public final void jl() {}
      });
    }
  }
  
  public final void clear()
  {
    this.Wc = null;
    this.Wd = null;
    a(this.We);
    this.We = null;
    a(this.Wf);
    this.Wf = null;
    a(this.Wg);
    this.Wg = null;
    this.Wh = null;
    a(this.Wi);
    this.Wi = null;
    a(this.Wj);
    this.Wj = null;
  }
  
  public final void j(List<zzcc> paramList) {}
  
  public final IntentFilter[] kU()
  {
    return this.Wk;
  }
  
  public final String kV()
  {
    return this.Wl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bz
 * JD-Core Version:    0.7.0.1
 */