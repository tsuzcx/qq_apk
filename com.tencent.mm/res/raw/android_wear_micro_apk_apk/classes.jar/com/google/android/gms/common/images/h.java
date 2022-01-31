package com.google.android.gms.common.images;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class h
  implements Parcelable.Creator<WebImage>
{
  static void a(WebImage paramWebImage, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramWebImage.Hc);
    c.a(paramParcel, 2, paramWebImage.getUrl(), paramInt);
    c.c(paramParcel, 3, paramWebImage.getWidth());
    c.c(paramParcel, 4, paramWebImage.getHeight());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.h
 * JD-Core Version:    0.7.0.1
 */