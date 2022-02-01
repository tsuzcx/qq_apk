package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzacw$zzb
  extends zza
{
  public static final Parcelable.Creator<zzb> CREATOR = new bz();
  final String RL;
  final zzacs.zza<?, ?> RM;
  final int versionCode;
  
  zzacw$zzb(int paramInt, String paramString, zzacs.zza<?, ?> paramzza)
  {
    this.versionCode = paramInt;
    this.RL = paramString;
    this.RM = paramzza;
  }
  
  zzacw$zzb(String paramString, zzacs.zza<?, ?> paramzza)
  {
    this.versionCode = 1;
    this.RL = paramString;
    this.RM = paramzza;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bz.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzacw.zzb
 * JD-Core Version:    0.7.0.1
 */