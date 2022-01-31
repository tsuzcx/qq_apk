package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class f
  implements Parcelable.Creator<ConnectionResult>
{
  static void a(ConnectionResult paramConnectionResult, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramConnectionResult.Hc);
    c.c(paramParcel, 2, paramConnectionResult.getErrorCode());
    c.a(paramParcel, 3, paramConnectionResult.gn(), paramInt);
    c.a(paramParcel, 4, paramConnectionResult.go());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.f
 * JD-Core Version:    0.7.0.1
 */