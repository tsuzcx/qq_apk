package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class ae
  implements Parcelable.Creator<zzbp>
{
  static void a(zzbp paramzzbp, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 2, paramzzbp.statusCode);
    c.a(paramParcel, 3, paramzzbp.Tx, paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ae
 * JD-Core Version:    0.7.0.1
 */