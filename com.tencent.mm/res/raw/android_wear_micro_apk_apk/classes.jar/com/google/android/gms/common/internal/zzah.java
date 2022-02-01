package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzah
  extends zza
{
  public static final Parcelable.Creator<zzah> CREATOR = new g();
  final int IR;
  private final int KW;
  private final int KX;
  @Deprecated
  private final Scope[] KY;
  
  public zzah(int paramInt1, int paramInt2)
  {
    this(1, paramInt1, paramInt2, null);
  }
  
  zzah(int paramInt1, int paramInt2, int paramInt3, Scope[] paramArrayOfScope)
  {
    this.IR = paramInt1;
    this.KW = paramInt2;
    this.KX = paramInt3;
    this.KY = paramArrayOfScope;
  }
  
  public final int hj()
  {
    return this.KW;
  }
  
  public final int hk()
  {
    return this.KX;
  }
  
  @Deprecated
  public final Scope[] hl()
  {
    return this.KY;
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