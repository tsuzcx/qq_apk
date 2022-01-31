package com.google.android.gms.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public abstract interface cx
  extends IInterface
{
  public abstract void a(ConnectionResult paramConnectionResult, zzbak paramzzbak);
  
  public abstract void a(Status paramStatus, GoogleSignInAccount paramGoogleSignInAccount);
  
  public abstract void a(zzbaw paramzzbaw);
  
  public abstract void g(Status paramStatus);
  
  public abstract void h(Status paramStatus);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.cx
 * JD-Core Version:    0.7.0.1
 */