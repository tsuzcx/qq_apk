package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class dg
  implements Parcelable.Creator<zzbaw>
{
  static void a(zzbaw paramzzbaw, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzbaw.IR);
    c.a(paramParcel, 2, paramzzbaw.hg(), paramInt);
    c.a(paramParcel, 3, paramzzbaw.jV(), paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dg
 * JD-Core Version:    0.7.0.1
 */