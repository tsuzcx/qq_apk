package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbr
  extends zza
{
  public static final Parcelable.Creator<zzbr> CREATOR = new af();
  public final zzcc Ty;
  public final int statusCode;
  
  public zzbr(int paramInt, zzcc paramzzcc)
  {
    this.statusCode = paramInt;
    this.Ty = paramzzcc;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    af.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbr
 * JD-Core Version:    0.7.0.1
 */