package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class ab
  implements Parcelable.Creator<zzj>
{
  static void a(zzj paramzzj, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzj.version);
    c.c(paramParcel, 2, paramzzj.JX);
    c.c(paramParcel, 3, paramzzj.JY);
    c.a(paramParcel, 4, paramzzj.JZ);
    c.a(paramParcel, 5, paramzzj.Ka);
    c.a(paramParcel, 6, paramzzj.Kb, paramInt);
    c.a(paramParcel, 7, paramzzj.Kc);
    c.a(paramParcel, 8, paramzzj.Kd, paramInt);
    c.a(paramParcel, 10, paramzzj.Ke, paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ab
 * JD-Core Version:    0.7.0.1
 */