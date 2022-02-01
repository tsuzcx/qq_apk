package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class co
  implements Parcelable.Creator<zzayz>
{
  static void a(zzayz paramzzayz, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.a(paramParcel, 2, paramzzayz.name);
    c.a(paramParcel, 3, paramzzayz.Sa);
    c.a(paramParcel, 4, paramzzayz.Sb);
    c.a(paramParcel, paramzzayz.Sc);
    c.a(paramParcel, 6, paramzzayz.Rv);
    c.a(paramParcel, 7, paramzzayz.Sd);
    c.c(paramParcel, 8, paramzzayz.Se);
    c.c(paramParcel, 9, paramzzayz.Sf);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.co
 * JD-Core Version:    0.7.0.1
 */