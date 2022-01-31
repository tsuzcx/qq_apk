package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class ah
  implements Parcelable.Creator<Asset>
{
  static void a(Asset paramAsset, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 2, paramAsset.getData());
    c.a(paramParcel, 3, paramAsset.kp());
    c.a(paramParcel, 4, paramAsset.Sj, paramInt);
    c.a(paramParcel, 5, paramAsset.uri, paramInt);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.ah
 * JD-Core Version:    0.7.0.1
 */