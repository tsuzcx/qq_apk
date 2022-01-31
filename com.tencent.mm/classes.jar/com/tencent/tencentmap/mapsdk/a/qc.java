package com.tencent.tencentmap.mapsdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class qc
  implements Parcelable
{
  public static final Parcelable.Creator<qc> CREATOR = new qc.1();
  public double a;
  public double b;
  
  public qc(double paramDouble1, double paramDouble2)
  {
    if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D)) {}
    for (this.b = paramDouble2;; this.b = (((paramDouble2 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D))
    {
      this.a = Math.max(-90.0D, Math.min(90.0D, paramDouble1));
      return;
    }
  }
  
  private qc(Parcel paramParcel)
  {
    this.a = paramParcel.readDouble();
    this.b = paramParcel.readDouble();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof qc)) {
        return false;
      }
      paramObject = (qc)paramObject;
    } while ((Double.doubleToLongBits(this.a) == Double.doubleToLongBits(paramObject.a)) && (Double.doubleToLongBits(this.b) == Double.doubleToLongBits(paramObject.b)));
    return false;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.a);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.b);
    return (i + 31) * 31 + (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    return "lat/lng: (" + this.a + "," + this.b + ")";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.a);
    paramParcel.writeDouble(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qc
 * JD-Core Version:    0.7.0.1
 */