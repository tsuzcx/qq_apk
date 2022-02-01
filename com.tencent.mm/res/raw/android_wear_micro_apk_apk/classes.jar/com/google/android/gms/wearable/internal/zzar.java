package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzar
  extends zza
{
  public static final Parcelable.Creator<zzar> CREATOR = new q();
  public final int Va;
  public final int statusCode;
  
  public zzar(int paramInt1, int paramInt2)
  {
    this.statusCode = paramInt1;
    this.Va = paramInt2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzar
 * JD-Core Version:    0.7.0.1
 */