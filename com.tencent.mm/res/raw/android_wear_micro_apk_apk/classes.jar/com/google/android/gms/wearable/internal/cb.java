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
    if (paramzzc.TH == null) {}
    for (IBinder localIBinder = null;; localIBinder = paramzzc.TH.asBinder())
    {
      c.a(paramParcel, 2, localIBinder);
      c.a(paramParcel, 3, paramzzc.TI, paramInt);
      c.a(paramParcel, 4, paramzzc.TJ);
      c.a(paramParcel, 5, paramzzc.TK);
      c.v(paramParcel, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.cb
 * JD-Core Version:    0.7.0.1
 */