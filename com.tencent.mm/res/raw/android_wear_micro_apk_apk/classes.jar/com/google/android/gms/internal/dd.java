package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class dd
  implements Parcelable.Creator<zzbar>
{
  static void a(zzbar paramzzbar, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzbar.Hc);
    c.a(paramParcel, 2, paramzzbar.fX(), paramInt);
    c.a(paramParcel, 3, paramzzbar.jL(), paramInt);
    c.a(paramParcel, 4, paramzzbar.gb());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dd
 * JD-Core Version:    0.7.0.1
 */