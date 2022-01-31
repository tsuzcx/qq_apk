package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzav
  extends zza
{
  public static final Parcelable.Creator<zzav> CREATOR = new s();
  public final zzo Tn;
  public final int statusCode;
  
  public zzav(int paramInt, zzo paramzzo)
  {
    this.statusCode = paramInt;
    this.Tn = paramzzo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzav
 * JD-Core Version:    0.7.0.1
 */