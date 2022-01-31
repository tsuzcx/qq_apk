package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class bu
  implements Parcelable.Creator<zzacn>
{
  static void a(zzacn paramzzacn, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzacn.Hc);
    c.a(paramParcel, 2, paramzzacn.ji(), paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bu
 * JD-Core Version:    0.7.0.1
 */