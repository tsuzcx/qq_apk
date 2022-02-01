package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbe
  extends zza
{
  public static final Parcelable.Creator<zzbe> CREATOR = new y();
  public final boolean Vg;
  public final boolean Vh;
  public final int statusCode;
  
  public zzbe(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.statusCode = paramInt;
    this.Vg = paramBoolean1;
    this.Vh = paramBoolean2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    y.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbe
 * JD-Core Version:    0.7.0.1
 */