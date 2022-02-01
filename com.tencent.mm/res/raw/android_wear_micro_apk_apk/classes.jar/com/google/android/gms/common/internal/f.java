package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class f
  implements Parcelable.Creator<zzaf>
{
  static void a(zzaf paramzzaf, Parcel paramParcel, int paramInt)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramzzaf.IR);
    c.a(paramParcel, 2, paramzzaf.KS);
    c.a(paramParcel, 3, paramzzaf.hg(), paramInt);
    c.a(paramParcel, 4, paramzzaf.hh());
    c.a(paramParcel, 5, paramzzaf.hi());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.f
 * JD-Core Version:    0.7.0.1
 */