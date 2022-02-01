package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class bz
  implements Parcelable.Creator<zzacw.zzb>
{
  static void a(zzacw.zzb paramzzb, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzb.versionCode);
    c.a(paramParcel, 2, paramzzb.RL);
    c.a(paramParcel, 3, paramzzb.RM, paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bz
 * JD-Core Version:    0.7.0.1
 */