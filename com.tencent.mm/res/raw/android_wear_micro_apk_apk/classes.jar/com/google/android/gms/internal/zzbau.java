package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzad;

public class zzbau
  extends zza
{
  public static final Parcelable.Creator<zzbau> CREATOR = new df();
  final int Hc;
  final zzad QK;
  
  zzbau(int paramInt, zzad paramzzad)
  {
    this.Hc = paramInt;
    this.QK = paramzzad;
  }
  
  public zzbau(zzad paramzzad)
  {
    this(1, paramzzad);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    df.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzbau
 * JD-Core Version:    0.7.0.1
 */