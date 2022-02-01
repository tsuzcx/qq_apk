package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class bf
  implements Parcelable.Creator<zzck>
{
  static void a(zzck paramzzck, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzck.IR);
    if (paramzzck.Vw == null) {}
    for (paramzzck = null;; paramzzck = paramzzck.Vw.asBinder())
    {
      c.a(paramParcel, 2, paramzzck);
      c.v(paramParcel, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bf
 * JD-Core Version:    0.7.0.1
 */