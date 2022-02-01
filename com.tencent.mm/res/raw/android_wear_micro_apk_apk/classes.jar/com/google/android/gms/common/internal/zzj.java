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
  final int LM;
  int LN;
  String LO;
  IBinder LP;
  Scope[] LQ;
  Bundle LR;
  Account LS;
  zzc[] LT;
  final int version;
  
  public zzj(int paramInt)
  {
    this.version = 3;
    this.LN = h.IX;
    this.LM = paramInt;
  }
  
  zzj(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, zzc[] paramArrayOfzzc)
  {
    this.version = paramInt1;
    this.LM = paramInt2;
    this.LN = paramInt3;
    if ("com.google.android.gms".equals(paramString))
    {
      this.LO = "com.google.android.gms";
      if (paramInt1 >= 2) {
        break label92;
      }
      paramString = null;
      if (paramIBinder != null) {
        paramString = a.a(al.f(paramIBinder));
      }
    }
    for (this.LS = paramString;; this.LS = paramAccount)
    {
      this.LQ = paramArrayOfScope;
      this.LR = paramBundle;
      this.LT = paramArrayOfzzc;
      return;
      this.LO = paramString;
      break;
      label92:
      this.LP = paramIBinder;
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