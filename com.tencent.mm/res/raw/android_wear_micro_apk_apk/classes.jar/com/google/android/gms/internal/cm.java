package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class cm
  implements Parcelable.Creator<zzayx>
{
  static void a(zzayx paramzzayx, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 2, paramzzayx.Qh);
    c.a(paramParcel, 3, paramzzayx.Qi, paramInt);
    c.a(paramParcel, 4, paramzzayx.Qj);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.cm
 * JD-Core Version:    0.7.0.1
 */