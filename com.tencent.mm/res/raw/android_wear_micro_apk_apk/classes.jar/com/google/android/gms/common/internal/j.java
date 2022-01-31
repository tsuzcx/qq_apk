package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class j
  implements Parcelable.Creator<zzan>
{
  static void a(zzan paramzzan, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzan.Hc);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.j
 * JD-Core Version:    0.7.0.1
 */