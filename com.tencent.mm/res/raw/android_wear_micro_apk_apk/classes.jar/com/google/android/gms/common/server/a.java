package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class a
  implements Parcelable.Creator<FavaDiagnosticsEntity>
{
  static void a(FavaDiagnosticsEntity paramFavaDiagnosticsEntity, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramFavaDiagnosticsEntity.Hc);
    c.a(paramParcel, 2, paramFavaDiagnosticsEntity.KJ);
    c.c(paramParcel, 3, paramFavaDiagnosticsEntity.KK);
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.server.a
 * JD-Core Version:    0.7.0.1
 */