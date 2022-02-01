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
  private final String IC;
  final int IR;
  private final Account Iy;
  private final Scope[] Sx;
  
  zzbar(int paramInt, Account paramAccount, Scope[] paramArrayOfScope, String paramString)
  {
    this.IR = paramInt;
    this.Iy = paramAccount;
    this.Sx = paramArrayOfScope;
    this.IC = paramString;
  }
  
  public final Account gi()
  {
    return this.Iy;
  }
  
  public final String gm()
  {
    return this.IC;
  }
  
  public final Scope[] jU()
  {
    return this.Sx;
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