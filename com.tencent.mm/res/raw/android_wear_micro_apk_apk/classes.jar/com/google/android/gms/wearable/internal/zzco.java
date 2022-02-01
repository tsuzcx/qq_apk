package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzco
  extends zza
{
  public static final Parcelable.Creator<zzco> CREATOR = new bh();
  public final int VG;
  public final int statusCode;
  
  public zzco(int paramInt1, int paramInt2)
  {
    this.statusCode = paramInt1;
    this.VG = paramInt2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bh.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzco
 * JD-Core Version:    0.7.0.1
 */