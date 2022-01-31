package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class a
  implements Parcelable.Creator<zzg>
{
  static void a(zzg paramzzg, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzg.versionCode);
    c.c(paramParcel, 2, paramzzg.getType());
    c.a(paramParcel, 3, paramzzg.getBundle());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.a
 * JD-Core Version:    0.7.0.1
 */