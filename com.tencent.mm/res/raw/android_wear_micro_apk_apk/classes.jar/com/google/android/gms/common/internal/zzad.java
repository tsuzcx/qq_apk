package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzad
  extends zza
{
  public static final Parcelable.Creator<zzad> CREATOR = new e();
  final int IR;
  private final Account Iy;
  private final int KQ;
  private final GoogleSignInAccount KR;
  
  zzad(int paramInt1, Account paramAccount, int paramInt2, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this.IR = paramInt1;
    this.Iy = paramAccount;
    this.KQ = paramInt2;
    this.KR = paramGoogleSignInAccount;
  }
  
  public zzad(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }
  
  public final int getSessionId()
  {
    return this.KQ;
  }
  
  public final Account gi()
  {
    return this.Iy;
  }
  
  public final GoogleSignInAccount he()
  {
    return this.KR;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzad
 * JD-Core Version:    0.7.0.1
 */