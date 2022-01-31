package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class FavaDiagnosticsEntity
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();
  final int Hc;
  public final String KJ;
  public final int KK;
  
  public FavaDiagnosticsEntity(int paramInt1, String paramString, int paramInt2)
  {
    this.Hc = paramInt1;
    this.KJ = paramString;
    this.KK = paramInt2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.server.FavaDiagnosticsEntity
 * JD-Core Version:    0.7.0.1
 */