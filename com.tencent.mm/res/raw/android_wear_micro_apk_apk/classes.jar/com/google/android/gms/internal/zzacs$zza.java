package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Map;

public class zzacs$zza<I, O>
  extends zza
{
  public static final by CREATOR = new by();
  private final int Hc;
  protected final int PI;
  protected final boolean PJ;
  protected final int PK;
  protected final boolean PL;
  protected final String PM;
  protected final int PN;
  protected final Class<? extends zzacs> PO;
  protected final String PP;
  private zzacw PQ;
  private bx<I, O> PR;
  
  zzacs$zza(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, zzacn paramzzacn)
  {
    this.Hc = paramInt1;
    this.PI = paramInt2;
    this.PJ = paramBoolean1;
    this.PK = paramInt3;
    this.PL = paramBoolean2;
    this.PM = paramString1;
    this.PN = paramInt4;
    if (paramString2 == null) {
      this.PO = null;
    }
    for (this.PP = null; paramzzacn == null; this.PP = paramString2)
    {
      this.PR = null;
      return;
      this.PO = zzacz.class;
    }
    this.PR = paramzzacn.jj();
  }
  
  public final void a(zzacw paramzzacw)
  {
    this.PQ = paramzzacw;
  }
  
  public final I convertBack(O paramO)
  {
    return this.PR.convertBack(paramO);
  }
  
  public final int getVersionCode()
  {
    return this.Hc;
  }
  
  public final int jn()
  {
    return this.PI;
  }
  
  public final boolean jo()
  {
    return this.PJ;
  }
  
  public final int jp()
  {
    return this.PK;
  }
  
  public final boolean jq()
  {
    return this.PL;
  }
  
  public final String jr()
  {
    return this.PM;
  }
  
  public final int js()
  {
    return this.PN;
  }
  
  final String jt()
  {
    if (this.PP == null) {
      return null;
    }
    return this.PP;
  }
  
  public final boolean ju()
  {
    return this.PR != null;
  }
  
  final zzacn jv()
  {
    if (this.PR == null) {
      return null;
    }
    return zzacn.a(this.PR);
  }
  
  public final Map<String, zza<?, ?>> jw()
  {
    d.u(this.PP);
    d.u(this.PQ);
    return this.PQ.p(this.PP);
  }
  
  public String toString()
  {
    c localc = b.t(this).a("versionCode", Integer.valueOf(this.Hc)).a("typeIn", Integer.valueOf(this.PI)).a("typeInArray", Boolean.valueOf(this.PJ)).a("typeOut", Integer.valueOf(this.PK)).a("typeOutArray", Boolean.valueOf(this.PL)).a("outputFieldName", this.PM).a("safeParcelFieldId", Integer.valueOf(this.PN)).a("concreteTypeName", jt());
    Class localClass = this.PO;
    if (localClass != null) {
      localc.a("concreteType.class", localClass.getCanonicalName());
    }
    if (this.PR != null) {
      localc.a("converterName", this.PR.getClass().getCanonicalName());
    }
    return localc.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    by.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzacs.zza
 * JD-Core Version:    0.7.0.1
 */