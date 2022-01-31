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
  public final am TH;
  public final IntentFilter[] TI;
  public final String TJ;
  public final String TK;
  
  zzc(IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter, String paramString1, String paramString2)
  {
    if (paramIBinder != null) {}
    for (this.TH = an.p(paramIBinder);; this.TH = null)
    {
      this.TI = paramArrayOfIntentFilter;
      this.TJ = paramString1;
      this.TK = paramString2;
      return;
    }
  }
  
  public zzc(bz parambz)
  {
    this.TH = parambz;
    this.TI = parambz.kL();
    this.TJ = parambz.kM();
    this.TK = null;
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