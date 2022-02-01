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
    c.c(paramParcel, 2, paramzzj.LM);
    c.c(paramParcel, 3, paramzzj.LN);
    c.a(paramParcel, 4, paramzzj.LO);
    c.a(paramParcel, 5, paramzzj.LP);
    c.a(paramParcel, 6, paramzzj.LQ, paramInt);
    c.a(paramParcel, 7, paramzzj.LR);
    c.a(paramParcel, 8, paramzzj.LS, paramInt);
    c.a(paramParcel, 10, paramzzj.LT, paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ab
 * JD-Core Version:    0.7.0.1
 */