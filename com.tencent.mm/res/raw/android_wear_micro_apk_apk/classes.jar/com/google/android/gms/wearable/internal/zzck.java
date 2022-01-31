package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzck
  extends zza
{
  public static final Parcelable.Creator<zzck> CREATOR = new bf();
  final int Hc;
  public final am TH;
  
  zzck(int paramInt, IBinder paramIBinder)
  {
    this.Hc = paramInt;
    if (paramIBinder != null)
    {
      this.TH = an.p(paramIBinder);
      return;
    }
    this.TH = null;
  }
  
  public zzck(am paramam)
  {
    this.Hc = 1;
    this.TH = paramam;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bf.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzck
 * JD-Core Version:    0.7.0.1
 */