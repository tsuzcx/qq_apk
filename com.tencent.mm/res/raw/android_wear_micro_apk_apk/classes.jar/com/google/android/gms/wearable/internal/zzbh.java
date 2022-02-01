package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class zzbh
  extends zza
{
  public static final Parcelable.Creator<zzbh> CREATOR = new aa();
  public final ConnectionConfiguration Vi;
  public final int statusCode;
  
  public zzbh(int paramInt, ConnectionConfiguration paramConnectionConfiguration)
  {
    this.statusCode = paramInt;
    this.Vi = paramConnectionConfiguration;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aa.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbh
 * JD-Core Version:    0.7.0.1
 */