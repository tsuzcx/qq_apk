package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

@Deprecated
public class zzan
  extends zza
{
  public static final Parcelable.Creator<zzan> CREATOR = new j();
  final int IR;
  
  zzan(int paramInt)
  {
    this.IR = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzan
 * JD-Core Version:    0.7.0.1
 */