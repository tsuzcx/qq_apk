package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzce
  extends zza
{
  public static final Parcelable.Creator<zzce> CREATOR = new bc();
  public final zzu TP;
  public final int statusCode;
  
  public zzce(int paramInt, zzu paramzzu)
  {
    this.statusCode = paramInt;
    this.TP = paramzzu;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bc.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzce
 * JD-Core Version:    0.7.0.1
 */