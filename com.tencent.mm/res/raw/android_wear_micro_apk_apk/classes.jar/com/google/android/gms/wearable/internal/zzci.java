package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzci
  extends zza
{
  public static final Parcelable.Creator<zzci> CREATOR = new be();
  public final zzao Tw;
  public final int statusCode;
  
  public zzci(int paramInt, zzao paramzzao)
  {
    this.statusCode = paramInt;
    this.Tw = paramzzao;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    be.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzci
 * JD-Core Version:    0.7.0.1
 */