package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class af
  implements Parcelable.Creator<Status>
{
  static void a(Status paramStatus, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramStatus.getStatusCode());
    c.a(paramParcel, 2, paramStatus.gG());
    c.a(paramParcel, 3, paramStatus.gF(), paramInt);
    c.c(paramParcel, 1000, paramStatus.Hc);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.af
 * JD-Core Version:    0.7.0.1
 */