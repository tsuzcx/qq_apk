package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class c
  implements Parcelable.Creator<zzae>
{
  static void a(zzae paramzzae, Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.b(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.c(paramParcel, 2, paramzzae.statusCode);
    com.google.android.gms.common.internal.safeparcel.c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.c
 * JD-Core Version:    0.7.0.1
 */