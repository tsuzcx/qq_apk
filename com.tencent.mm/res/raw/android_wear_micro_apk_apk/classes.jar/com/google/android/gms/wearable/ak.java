package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class ak
  implements Parcelable.Creator<PutDataRequest>
{
  static void a(PutDataRequest paramPutDataRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 2, paramPutDataRequest.getUri(), paramInt);
    c.a(paramParcel, 4, paramPutDataRequest.kM());
    c.a(paramParcel, 5, paramPutDataRequest.getData());
    c.a(paramParcel, 6, paramPutDataRequest.kN());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.ak
 * JD-Core Version:    0.7.0.1
 */