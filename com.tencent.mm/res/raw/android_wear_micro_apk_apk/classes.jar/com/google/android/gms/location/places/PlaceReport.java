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
  final int IR;
  private final String TJ;
  private final String TK;
  private final String cQ;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.IR = paramInt;
    this.TJ = paramString1;
    this.cQ = paramString2;
    this.TK = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport)) {}
    do
    {
      return false;
      paramObject = (PlaceReport)paramObject;
    } while ((!b.c(this.TJ, paramObject.TJ)) || (!b.c(this.cQ, paramObject.cQ)) || (!b.c(this.TK, paramObject.TK)));
    return true;
  }
  
  public final String getSource()
  {
    return this.TK;
  }
  
  public final String getTag()
  {
    return this.cQ;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.TJ, this.cQ, this.TK });
  }
  
  public final String ku()
  {
    return this.TJ;
  }
  
  public String toString()
  {
    c localc = b.C(this);
    localc.a("placeId", this.TJ);
    localc.a("tag", this.cQ);
    if (!"unknown".equals(this.TK)) {
      localc.a("source", this.TK);
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