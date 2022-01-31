package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzah
  extends zza
{
  public static final Parcelable.Creator<zzah> CREATOR = new g();
  final int Hc;
  private final int Jh;
  private final int Ji;
  @Deprecated
  private final Scope[] Jj;
  
  public zzah(int paramInt1, int paramInt2)
  {
    this(1, paramInt1, paramInt2, null);
  }
  
  zzah(int paramInt1, int paramInt2, int paramInt3, Scope[] paramArrayOfScope)
  {
    this.Hc = paramInt1;
    this.Jh = paramInt2;
    this.Ji = paramInt3;
    this.Jj = paramArrayOfScope;
  }
  
  public final int gZ()
  {
    return this.Jh;
  }
  
  public final int ha()
  {
    return this.Ji;
  }
  
  @Deprecated
  public final Scope[] hb()
  {
    return this.Jj;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzah
 * JD-Core Version:    0.7.0.1
 */