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
    c.c(paramParcel, 2, paramzza.jn());
    c.a(paramParcel, 3, paramzza.jo());
    c.c(paramParcel, 4, paramzza.jp());
    c.a(paramParcel, 5, paramzza.jq());
    c.a(paramParcel, 6, paramzza.jr());
    c.c(paramParcel, 7, paramzza.js());
    c.a(paramParcel, 8, paramzza.jt());
    c.a(paramParcel, 9, paramzza.jv(), paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.by
 * JD-Core Version:    0.7.0.1
 */