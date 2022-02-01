package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class ch
  implements Parcelable.Creator<zzk>
{
  static void a(zzk paramzzk, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 2, paramzzk.getId());
    c.a(paramParcel, 3, paramzzk.kY());
    c.a(paramParcel, 4, paramzzk.kZ());
    c.a(paramParcel, 5, paramzzk.la());
    c.a(paramParcel, 6, paramzzk.getTitle());
    c.a(paramParcel, 7, paramzzk.lb());
    c.a(paramParcel, 8, paramzzk.getDisplayName());
    c.a(paramParcel, 9, paramzzk.lc());
    c.a(paramParcel, 10, paramzzk.ld());
    c.a(paramParcel, 11, paramzzk.le());
    c.a(paramParcel, 12, paramzzk.lf());
    c.a(paramParcel, 13, paramzzk.getPackageName());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ch
 * JD-Core Version:    0.7.0.1
 */