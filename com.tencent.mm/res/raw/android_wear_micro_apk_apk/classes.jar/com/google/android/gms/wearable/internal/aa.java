package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class aa
  implements Parcelable.Creator<zzbh>
{
  static void a(zzbh paramzzbh, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 2, paramzzbh.statusCode);
    c.a(paramParcel, 3, paramzzbh.Vi, paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.aa
 * JD-Core Version:    0.7.0.1
 */