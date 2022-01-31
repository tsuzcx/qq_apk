package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public final class b
  extends RuntimeException
{
  public b(String paramString, Parcel paramParcel)
  {
    super(String.valueOf(paramString).length() + 41 + paramString + " Parcel: pos=" + i + " size=" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.b
 * JD-Core Version:    0.7.0.1
 */