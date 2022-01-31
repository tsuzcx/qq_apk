package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class aj
  implements Parcelable.Creator<ConnectionConfiguration>
{
  static void a(ConnectionConfiguration paramConnectionConfiguration, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 2, paramConnectionConfiguration.getName());
    c.a(paramParcel, 3, paramConnectionConfiguration.getAddress());
    c.c(paramParcel, 4, paramConnectionConfiguration.getType());
    c.c(paramParcel, 5, paramConnectionConfiguration.getRole());
    c.a(paramParcel, 6, paramConnectionConfiguration.isEnabled());
    c.a(paramParcel, 7, paramConnectionConfiguration.isConnected());
    c.a(paramParcel, 8, paramConnectionConfiguration.ks());
    c.a(paramParcel, 9, paramConnectionConfiguration.kt());
    c.a(paramParcel, 10, paramConnectionConfiguration.kq());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.aj
 * JD-Core Version:    0.7.0.1
 */