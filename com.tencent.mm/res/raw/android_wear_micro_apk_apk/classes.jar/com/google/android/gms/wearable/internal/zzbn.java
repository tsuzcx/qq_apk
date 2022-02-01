package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbn
  extends zza
{
  public static final Parcelable.Creator<zzbn> CREATOR = new ad();
  public final zzao Vl;
  public final int statusCode;
  
  public zzbn(int paramInt, zzao paramzzao)
  {
    this.statusCode = paramInt;
    this.Vl = paramzzao;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ad.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbn
 * JD-Core Version:    0.7.0.1
 */