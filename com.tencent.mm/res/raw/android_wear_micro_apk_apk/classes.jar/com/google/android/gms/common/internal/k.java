package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class k
  implements Parcelable.Creator<zzd>
{
  static void a(zzd paramzzd, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzd.Hc);
    c.a(paramParcel, 2, paramzzd.Jd);
    c.a(paramParcel, 3, paramzzd.Jj, paramInt);
    c.a(paramParcel, 4, paramzzd.Jm);
    c.a(paramParcel, 5, paramzzd.Jn);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.k
 * JD-Core Version:    0.7.0.1
 */