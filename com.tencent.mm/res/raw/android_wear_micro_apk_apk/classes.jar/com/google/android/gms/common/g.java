package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class g
  implements Parcelable.Creator<zzc>
{
  static void a(zzc paramzzc, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 1, paramzzc.name);
    c.c(paramParcel, 2, paramzzc.version);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.g
 * JD-Core Version:    0.7.0.1
 */