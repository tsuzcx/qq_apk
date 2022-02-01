package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzd
  extends zza
{
  public static final Parcelable.Creator<zzd> CREATOR = new k();
  final int IR;
  final IBinder KS;
  final Scope[] KY;
  Integer Lb;
  Integer Lc;
  
  zzd(int paramInt, IBinder paramIBinder, Scope[] paramArrayOfScope, Integer paramInteger1, Integer paramInteger2)
  {
    this.IR = paramInt;
    this.KS = paramIBinder;
    this.KY = paramArrayOfScope;
    this.Lb = paramInteger1;
    this.Lc = paramInteger2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzd
 * JD-Core Version:    0.7.0.1
 */