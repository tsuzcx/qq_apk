package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbar
  extends zza
{
  public static final Parcelable.Creator<zzbar> CREATOR = new dd();
  private final Account GJ;
  private final String GN;
  final int Hc;
  private final Scope[] QI;
  
  zzbar(int paramInt, Account paramAccount, Scope[] paramArrayOfScope, String paramString)
  {
    this.Hc = paramInt;
    this.GJ = paramAccount;
    this.QI = paramArrayOfScope;
    this.GN = paramString;
  }
  
  public final Account fX()
  {
    return this.GJ;
  }
  
  public final String gb()
  {
    return this.GN;
  }
  
  public final Scope[] jL()
  {
    return this.QI;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dd.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzbar
 * JD-Core Version:    0.7.0.1
 */