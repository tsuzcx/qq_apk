package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc
  extends zza
{
  public static final Parcelable.Creator<zzc> CREATOR = new cb();
  public final am Vw;
  public final IntentFilter[] Vx;
  public final String Vy;
  public final String Vz;
  
  zzc(IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter, String paramString1, String paramString2)
  {
    if (paramIBinder != null) {}
    for (this.Vw = an.p(paramIBinder);; this.Vw = null)
    {
      this.Vx = paramArrayOfIntentFilter;
      this.Vy = paramString1;
      this.Vz = paramString2;
      return;
    }
  }
  
  public zzc(bz parambz)
  {
    this.Vw = parambz;
    this.Vx = parambz.kU();
    this.Vy = parambz.kV();
    this.Vz = null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cb.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzc
 * JD-Core Version:    0.7.0.1
 */