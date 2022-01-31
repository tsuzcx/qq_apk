package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;

public class PlaceReport
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new a();
  final int Hc;
  private final String RU;
  private final String RV;
  private final String bf;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.Hc = paramInt;
    this.RU = paramString1;
    this.bf = paramString2;
    this.RV = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport)) {}
    do
    {
      return false;
      paramObject = (PlaceReport)paramObject;
    } while ((!b.b(this.RU, paramObject.RU)) || (!b.b(this.bf, paramObject.bf)) || (!b.b(this.RV, paramObject.RV)));
    return true;
  }
  
  public final String getSource()
  {
    return this.RV;
  }
  
  public final String getTag()
  {
    return this.bf;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.RU, this.bf, this.RV });
  }
  
  public final String kl()
  {
    return this.RU;
  }
  
  public String toString()
  {
    c localc = b.t(this);
    localc.a("placeId", this.RU);
    localc.a("tag", this.bf);
    if (!"unknown".equals(this.RV)) {
      localc.a("source", this.RV);
    }
    return localc.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.location.places.PlaceReport
 * JD-Core Version:    0.7.0.1
 */