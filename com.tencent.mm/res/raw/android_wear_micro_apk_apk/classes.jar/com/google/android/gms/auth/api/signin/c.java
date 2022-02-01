package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class c
  implements Parcelable.Creator<GoogleSignInOptions>
{
  static void a(GoogleSignInOptions paramGoogleSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.b(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.c(paramParcel, 1, paramGoogleSignInOptions.versionCode);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramGoogleSignInOptions.gh());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramGoogleSignInOptions.gi(), paramInt);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramGoogleSignInOptions.gj());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramGoogleSignInOptions.gk());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramGoogleSignInOptions.gl());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, paramGoogleSignInOptions.gm());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 8, paramGoogleSignInOptions.gn());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 9, paramGoogleSignInOptions.go());
    com.google.android.gms.common.internal.safeparcel.c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.c
 * JD-Core Version:    0.7.0.1
 */