package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.zzc;

public class zzj
  extends zza
{
  public static final Parcelable.Creator<zzj> CREATOR = new ab();
  final int JX;
  int JY;
  String JZ;
  IBinder Ka;
  Scope[] Kb;
  Bundle Kc;
  Account Kd;
  zzc[] Ke;
  final int version;
  
  public zzj(int paramInt)
  {
    this.version = 3;
    this.JY = h.Hi;
    this.JX = paramInt;
  }
  
  zzj(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, zzc[] paramArrayOfzzc)
  {
    this.version = paramInt1;
    this.JX = paramInt2;
    this.JY = paramInt3;
    if ("com.google.android.gms".equals(paramString))
    {
      this.JZ = "com.google.android.gms";
      if (paramInt1 >= 2) {
        break label92;
      }
      paramString = null;
      if (paramIBinder != null) {
        paramString = a.a(al.f(paramIBinder));
      }
    }
    for (this.Kd = paramString;; this.Kd = paramAccount)
    {
      this.Kb = paramArrayOfScope;
      this.Kc = paramBundle;
      this.Ke = paramArrayOfzzc;
      return;
      this.JZ = paramString;
      break;
      label92:
      this.Ka = paramIBinder;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ab.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzj
 * JD-Core Version:    0.7.0.1
 */