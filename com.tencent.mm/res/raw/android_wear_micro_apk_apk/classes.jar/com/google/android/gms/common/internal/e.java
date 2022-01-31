package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class e
  implements Parcelable.Creator<zzad>
{
  static void a(zzad paramzzad, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzad.Hc);
    c.a(paramParcel, 2, paramzzad.fX(), paramInt);
    c.c(paramParcel, 3, paramzzad.getSessionId());
    c.a(paramParcel, 4, paramzzad.gU(), paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.e
 * JD-Core Version:    0.7.0.1
 */