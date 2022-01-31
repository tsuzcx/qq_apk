package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class bd
  implements Parcelable.Creator<zzcg>
{
  static void a(zzcg paramzzcg, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 2, paramzzcg.packageName);
    c.a(paramParcel, 3, paramzzcg.label);
    c.a(paramParcel, 4, paramzzcg.TQ);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bd
 * JD-Core Version:    0.7.0.1
 */