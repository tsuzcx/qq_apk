package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbc
  extends zza
{
  public static final Parcelable.Creator<zzbc> CREATOR = new x();
  public final boolean Vf;
  public final int statusCode;
  
  public zzbc(int paramInt, boolean paramBoolean)
  {
    this.statusCode = paramInt;
    this.Vf = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    x.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbc
 * JD-Core Version:    0.7.0.1
 */