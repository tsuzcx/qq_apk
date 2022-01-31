package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class bk
  implements Parcelable.Creator<zzcs>
{
  static void a(zzcs paramzzcs, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 2, paramzzcs.statusCode);
    c.a(paramParcel, 3, paramzzcs.TQ);
    c.a(paramParcel, 4, paramzzcs.TU);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bk
 * JD-Core Version:    0.7.0.1
 */