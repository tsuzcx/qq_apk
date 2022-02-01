package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LatLngSpan
  implements Parcelable
{
  public static final Parcelable.Creator<LatLngSpan> CREATOR;
  private double mLatitudeSpan;
  private double mLongitudeSpan;
  
  static
  {
    AppMethodBeat.i(181074);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(181074);
  }
  
  public LatLngSpan(double paramDouble1, double paramDouble2)
  {
    this.mLatitudeSpan = paramDouble1;
    this.mLongitudeSpan = paramDouble2;
  }
  
  private LatLngSpan(Parcel paramParcel)
  {
    AppMethodBeat.i(181070);
    this.mLatitudeSpan = paramParcel.readDouble();
    this.mLongitudeSpan = paramParcel.readDouble();
    AppMethodBeat.o(181070);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(181071);
    if (this == paramObject)
    {
      AppMethodBeat.o(181071);
      return true;
    }
    if ((paramObject instanceof LatLngSpan))
    {
      paramObject = (LatLngSpan)paramObject;
      if ((this.mLongitudeSpan == paramObject.getLongitudeSpan()) && (this.mLatitudeSpan == paramObject.getLatitudeSpan()))
      {
        AppMethodBeat.o(181071);
        return true;
      }
      AppMethodBeat.o(181071);
      return false;
    }
    AppMethodBeat.o(181071);
    return false;
  }
  
  public double getLatitudeSpan()
  {
    return this.mLatitudeSpan;
  }
  
  public double getLongitudeSpan()
  {
    return this.mLongitudeSpan;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(181073);
    long l = Double.doubleToLongBits(this.mLatitudeSpan);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.mLongitudeSpan);
    int j = (int)(l ^ l >>> 32);
    AppMethodBeat.o(181073);
    return i * 31 + j;
  }
  
  public void setLatitudeSpan(double paramDouble)
  {
    this.mLatitudeSpan = paramDouble;
  }
  
  public void setLongitudeSpan(double paramDouble)
  {
    this.mLongitudeSpan = paramDouble;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(181072);
    paramParcel.writeDouble(this.mLatitudeSpan);
    paramParcel.writeDouble(this.mLongitudeSpan);
    AppMethodBeat.o(181072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.LatLngSpan
 * JD-Core Version:    0.7.0.1
 */