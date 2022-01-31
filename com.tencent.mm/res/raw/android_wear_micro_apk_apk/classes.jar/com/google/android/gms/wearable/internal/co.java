package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class co
  implements Parcelable.Creator<zzs>
{
  static void a(zzs paramzzs, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 2, paramzzs.TP, paramInt);
    c.c(paramParcel, 3, paramzzs.type);
    c.c(paramParcel, 4, paramzzs.UT);
    c.c(paramParcel, 5, paramzzs.UU);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.co
 * JD-Core Version:    0.7.0.1
 */