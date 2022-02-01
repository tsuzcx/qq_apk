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
  private final int IR;
  protected final boolean RA;
  protected final String RB;
  protected final int RC;
  protected final Class<? extends zzacs> RD;
  protected final String RE;
  private zzacw RF;
  private bx<I, O> RG;
  protected final int Rx;
  protected final boolean Ry;
  protected final int Rz;
  
  zzacs$zza(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, zzacn paramzzacn)
  {
    this.IR = paramInt1;
    this.Rx = paramInt2;
    this.Ry = paramBoolean1;
    this.Rz = paramInt3;
    this.RA = paramBoolean2;
    this.RB = paramString1;
    this.RC = paramInt4;
    if (paramString2 == null) {
      this.RD = null;
    }
    for (this.RE = null; paramzzacn == null; this.RE = paramString2)
    {
      this.RG = null;
      return;
      this.RD = zzacz.class;
    }
    this.RG = paramzzacn.js();
  }
  
  public final void a(zzacw paramzzacw)
  {
    this.RF = paramzzacw;
  }
  
  public final I convertBack(O paramO)
  {
    return this.RG.convertBack(paramO);
  }
  
  public final int getVersionCode()
  {
    return this.IR;
  }
  
  public final String jA()
  {
    return this.RB;
  }
  
  public final int jB()
  {
    return this.RC;
  }
  
  final String jC()
  {
    if (this.RE == null) {
      return null;
    }
    return this.RE;
  }
  
  public final boolean jD()
  {
    return this.RG != null;
  }
  
  final zzacn jE()
  {
    if (this.RG == null) {
      return null;
    }
    return zzacn.a(this.RG);
  }
  
  public final Map<String, zza<?, ?>> jF()
  {
    d.D(this.RE);
    d.D(this.RF);
    return this.RF.p(this.RE);
  }
  
  public final int jw()
  {
    return this.Rx;
  }
  
  public final boolean jx()
  {
    return this.Ry;
  }
  
  public final int jy()
  {
    return this.Rz;
  }
  
  public final boolean jz()
  {
    return this.RA;
  }
  
  public String toString()
  {
    c localc = b.C(this).a("versionCode", Integer.valueOf(this.IR)).a("typeIn", Integer.valueOf(this.Rx)).a("typeInArray", Boolean.valueOf(this.Ry)).a("typeOut", Integer.valueOf(this.Rz)).a("typeOutArray", Boolean.valueOf(this.RA)).a("outputFieldName", this.RB).a("safeParcelFieldId", Integer.valueOf(this.RC)).a("concreteTypeName", jC());
    Class localClass = this.RD;
    if (localClass != null) {
      localc.a("concreteType.class", localClass.getCanonicalName());
    }
    if (this.RG != null) {
      localc.a("converterName", this.RG.getClass().getCanonicalName());
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