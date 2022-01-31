package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class bb
  implements Parcelable.Creator<zzcc>
{
  static void a(zzcc paramzzcc, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 2, paramzzcc.getId());
    c.a(paramParcel, 3, paramzzcc.getDisplayName());
    c.c(paramParcel, 4, paramzzcc.getHopCount());
    c.a(paramParcel, 5, paramzzcc.kJ());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bb
 * JD-Core Version:    0.7.0.1
 */