package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class b
  implements Parcelable.Creator<GoogleSignInAccount>
{
  static void a(GoogleSignInAccount paramGoogleSignInAccount, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramGoogleSignInAccount.versionCode);
    c.a(paramParcel, 2, paramGoogleSignInAccount.getId());
    c.a(paramParcel, 3, paramGoogleSignInAccount.fX());
    c.a(paramParcel, 4, paramGoogleSignInAccount.fY());
    c.a(paramParcel, 5, paramGoogleSignInAccount.getDisplayName());
    c.a(paramParcel, 6, paramGoogleSignInAccount.gb(), paramInt);
    c.a(paramParcel, 7, paramGoogleSignInAccount.gd());
    c.a(paramParcel, 8, paramGoogleSignInAccount.ge());
    c.a(paramParcel, 9, paramGoogleSignInAccount.gf());
    c.a(paramParcel, 10, paramGoogleSignInAccount.In);
    c.a(paramParcel, 11, paramGoogleSignInAccount.fZ());
    c.a(paramParcel, 12, paramGoogleSignInAccount.ga());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.b
 * JD-Core Version:    0.7.0.1
 */