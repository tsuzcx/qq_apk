package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class cf
  implements Parcelable.Creator<zzh>
{
  static void a(zzh paramzzh, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 2, paramzzh.kN());
    c.a(paramParcel, 3, paramzzh.kO());
    c.a(paramParcel, 4, paramzzh.getValue());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.cf
 * JD-Core Version:    0.7.0.1
 */