package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class y
  implements Parcelable.Creator<zzbe>
{
  static void a(zzbe paramzzbe, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 2, paramzzbe.statusCode);
    c.a(paramParcel, 3, paramzzbe.Tr);
    c.a(paramParcel, 4, paramzzbe.Ts);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.y
 * JD-Core Version:    0.7.0.1
 */