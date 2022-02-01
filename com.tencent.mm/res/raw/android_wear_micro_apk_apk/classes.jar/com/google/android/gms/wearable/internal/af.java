package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class af
  implements Parcelable.Creator<zzbr>
{
  static void a(zzbr paramzzbr, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 2, paramzzbr.statusCode);
    c.a(paramParcel, 3, paramzzbr.Vn, paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.af
 * JD-Core Version:    0.7.0.1
 */