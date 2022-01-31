package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class bv
  implements Parcelable.Creator<zzacp>
{
  static void a(zzacp paramzzacp, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzacp.Hc);
    c.a(paramParcel, 2, paramzzacp.jk());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bv
 * JD-Core Version:    0.7.0.1
 */