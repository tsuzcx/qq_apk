package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class cw
  implements Parcelable.Creator<zzban>
{
  static void a(zzban paramzzban, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzban.Hc);
    c.a(paramParcel, 2, paramzzban.QG);
    c.a(paramParcel, 3, paramzzban.QH);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.cw
 * JD-Core Version:    0.7.0.1
 */