package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzy
  extends zza
{
  public static final Parcelable.Creator<zzy> CREATOR = new cq();
  public final int statusCode;
  
  public zzy(int paramInt)
  {
    this.statusCode = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cq.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzy
 * JD-Core Version:    0.7.0.1
 */