package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class h
  implements Parcelable.Creator<DataHolder>
{
  static void a(DataHolder paramDataHolder, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 1, paramDataHolder.gM());
    c.a(paramParcel, 2, paramDataHolder.gN(), paramInt);
    c.c(paramParcel, 3, paramDataHolder.getStatusCode());
    c.a(paramParcel, 4, paramDataHolder.gO());
    c.c(paramParcel, 1000, paramDataHolder.Hc);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.h
 * JD-Core Version:    0.7.0.1
 */