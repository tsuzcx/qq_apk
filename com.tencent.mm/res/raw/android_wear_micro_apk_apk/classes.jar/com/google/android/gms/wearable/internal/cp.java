package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class cp
  implements Parcelable.Creator<zzu>
{
  static void a(zzu paramzzu, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 2, paramzzu.kY());
    c.a(paramParcel, 3, paramzzu.kq());
    c.a(paramParcel, 4, paramzzu.getPath());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.cp
 * JD-Core Version:    0.7.0.1
 */