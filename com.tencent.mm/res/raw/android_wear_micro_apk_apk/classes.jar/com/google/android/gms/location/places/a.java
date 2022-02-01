package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.c;

public final class a
  implements Parcelable.Creator<PlaceReport>
{
  static void a(PlaceReport paramPlaceReport, Parcel paramParcel)
  {
    int i = c.b(paramParcel);
    c.c(paramParcel, 1, paramPlaceReport.IR);
    c.a(paramParcel, 2, paramPlaceReport.ku());
    c.a(paramParcel, 3, paramPlaceReport.getTag());
    c.a(paramParcel, 4, paramPlaceReport.getSource());
    c.v(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.location.places.a
 * JD-Core Version:    0.7.0.1
 */