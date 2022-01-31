package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class zzacp$zza
  extends zza
{
  public static final Parcelable.Creator<zza> CREATOR = new bw();
  final String PG;
  final int PH;
  final int versionCode;
  
  zzacp$zza(int paramInt1, String paramString, int paramInt2)
  {
    this.versionCode = paramInt1;
    this.PG = paramString;
    this.PH = paramInt2;
  }
  
  zzacp$zza(String paramString, int paramInt)
  {
    this.versionCode = 1;
    this.PG = paramString;
    this.PH = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bw.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzacp.zza
 * JD-Core Version:    0.7.0.1
 */