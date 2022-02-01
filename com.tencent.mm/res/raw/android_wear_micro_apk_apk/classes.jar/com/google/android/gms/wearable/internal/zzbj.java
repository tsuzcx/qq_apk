package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzbj
  extends zza
{
  public static final Parcelable.Creator<zzbj> CREATOR = new ab();
  public final ConnectionConfiguration[] Vj;
  public final int statusCode;
  
  public zzbj(int paramInt, ConnectionConfiguration[] paramArrayOfConnectionConfiguration)
  {
    this.statusCode = paramInt;
    this.Vj = paramArrayOfConnectionConfiguration;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ab.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbj
 * JD-Core Version:    0.7.0.1
 */