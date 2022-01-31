package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzg
  extends zza
{
  public static final Parcelable.Creator<zzg> CREATOR = new a();
  private int GT;
  private Bundle GU;
  final int versionCode;
  
  zzg(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.versionCode = paramInt1;
    this.GT = paramInt2;
    this.GU = paramBundle;
  }
  
  public final Bundle getBundle()
  {
    return this.GU;
  }
  
  public final int getType()
  {
    return this.GT;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzg
 * JD-Core Version:    0.7.0.1
 */