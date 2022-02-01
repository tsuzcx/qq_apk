package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class e
  implements Parcelable.Creator<BitmapTeleporter>
{
  static void a(BitmapTeleporter paramBitmapTeleporter, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramBitmapTeleporter.IR);
    c.a(paramParcel, 2, paramBitmapTeleporter.JQ, paramInt);
    c.c(paramParcel, 3, paramBitmapTeleporter.II);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.e
 * JD-Core Version:    0.7.0.1
 */