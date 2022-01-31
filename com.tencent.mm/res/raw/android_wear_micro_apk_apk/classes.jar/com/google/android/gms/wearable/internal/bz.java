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
  private bb<Object> Un;
  private bb<Object> Uo;
  private bb<g> Up;
  private bb<q> Uq;
  private bb<x> Ur;
  private bb<Object> Us;
  private bb<c> Ut;
  private bb<Object> Uu;
  private final IntentFilter[] Uv;
  private final String Uw;
  
  private bz(IntentFilter[] paramArrayOfIntentFilter, String paramString)
  {
    this.Uv = ((IntentFilter[])d.u(paramArrayOfIntentFilter));
    this.Uw = null;
  }
  
  public static bz<c> a(bb<c> parambb, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new bz(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.Ut = ((bb)d.u(parambb));
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
    if (this.Up != null)
    {
      this.Up.a(new be()
      {
        public final void jc()
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
    if (this.Uq != null) {
      this.Uq.a(new be()
      {
        public final void jc() {}
      });
    }
  }
  
  public final void a(zzcc paramzzcc)
  {
    if (this.Ur != null) {
      this.Ur.a(new be()
      {
        public final void jc() {}
      });
    }
  }
  
  public final void a(zzh paramzzh) {}
  
  public final void a(zzk paramzzk) {}
  
  public final void a(zzo paramzzo)
  {
    if (this.Uu != null) {
      this.Uu.a(new be()
      {
        public final void jc() {}
      });
    }
  }
  
  public final void a(zzs paramzzs)
  {
    if (this.Ut != null) {
      this.Ut.a(new be()
      {
        public final void jc() {}
      });
    }
  }
  
  public final void b(zzcc paramzzcc)
  {
    if (this.Ur != null) {
      this.Ur.a(new be()
      {
        public final void jc() {}
      });
    }
  }
  
  public final void clear()
  {
    a(null);
    this.Un = null;
    a(null);
    this.Uo = null;
    a(this.Up);
    this.Up = null;
    a(this.Uq);
    this.Uq = null;
    a(this.Ur);
    this.Ur = null;
    a(null);
    this.Us = null;
    a(this.Ut);
    this.Ut = null;
    a(this.Uu);
    this.Uu = null;
  }
  
  public final void j(List<zzcc> paramList) {}
  
  public final IntentFilter[] kL()
  {
    return this.Uv;
  }
  
  public final String kM()
  {
    return this.Uw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bz
 * JD-Core Version:    0.7.0.1
 */