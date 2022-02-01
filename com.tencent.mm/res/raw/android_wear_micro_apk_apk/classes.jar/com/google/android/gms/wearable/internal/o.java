package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class o
  implements Parcelable.Creator<zzao>
{
  static void a(zzao paramzzao, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 2, paramzzao.getUri(), paramInt);
    c.a(paramParcel, 4, paramzzao.kM());
    c.a(paramParcel, 5, paramzzao.getData());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.o
 * JD-Core Version:    0.7.0.1
 */