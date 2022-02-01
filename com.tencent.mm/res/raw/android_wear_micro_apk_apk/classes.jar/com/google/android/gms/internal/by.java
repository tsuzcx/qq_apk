package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class by
  implements Parcelable.Creator<zzacs.zza>
{
  static void a(zzacs.zza paramzza, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzza.getVersionCode());
    c.c(paramParcel, 2, paramzza.jw());
    c.a(paramParcel, 3, paramzza.jx());
    c.c(paramParcel, 4, paramzza.jy());
    c.a(paramParcel, 5, paramzza.jz());
    c.a(paramParcel, 6, paramzza.jA());
    c.c(paramParcel, 7, paramzza.jB());
    c.a(paramParcel, 8, paramzza.jC());
    c.a(paramParcel, 9, paramzza.jE(), paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.by
 * JD-Core Version:    0.7.0.1
 */