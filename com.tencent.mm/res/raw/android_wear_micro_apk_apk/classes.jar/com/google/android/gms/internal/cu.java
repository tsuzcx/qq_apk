package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class cu
  implements Parcelable.Creator<zzbak>
{
  static void a(zzbak paramzzbak, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzbak.Hc);
    c.c(paramParcel, 2, paramzzbak.jJ());
    c.a(paramParcel, 3, paramzzbak.jK(), paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.cu
 * JD-Core Version:    0.7.0.1
 */