package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class g
  implements Parcelable.Creator<zzah>
{
  static void a(zzah paramzzah, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzah.IR);
    c.c(paramParcel, 2, paramzzah.hj());
    c.c(paramParcel, 3, paramzzah.hk());
    c.a(paramParcel, 4, paramzzah.hl(), paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.g
 * JD-Core Version:    0.7.0.1
 */