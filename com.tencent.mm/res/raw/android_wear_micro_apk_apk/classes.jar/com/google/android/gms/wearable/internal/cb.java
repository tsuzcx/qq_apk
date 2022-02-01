package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class cb
  implements Parcelable.Creator<zzc>
{
  static void a(zzc paramzzc, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    if (paramzzc.Vw == null) {}
    for (IBinder localIBinder = null;; localIBinder = paramzzc.Vw.asBinder())
    {
      c.a(paramParcel, 2, localIBinder);
      c.a(paramParcel, 3, paramzzc.Vx, paramInt);
      c.a(paramParcel, 4, paramzzc.Vy);
      c.a(paramParcel, 5, paramzzc.Vz);
      c.v(paramParcel, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.cb
 * JD-Core Version:    0.7.0.1
 */