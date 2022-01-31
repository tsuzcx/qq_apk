package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class bw
  implements Parcelable.Creator<zzacp.zza>
{
  static void a(zzacp.zza paramzza, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzza.versionCode);
    c.a(paramParcel, 2, paramzza.PG);
    c.c(paramParcel, 3, paramzza.PH);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bw
 * JD-Core Version:    0.7.0.1
 */