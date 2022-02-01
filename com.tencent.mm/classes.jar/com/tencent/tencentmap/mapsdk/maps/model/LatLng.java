package com.tencent.tencentmap.mapsdk.maps.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class LatLng
  extends JsonComposer
  implements Parcelable
{
  public static final Parcelable.Creator<LatLng> CREATOR;
  public double altitude;
  @Json(name="lat")
  public double latitude;
  @Json(name="lng")
  public double longitude;
  
  static
  {
    AppMethodBeat.i(173157);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(173157);
  }
  
  public LatLng()
  {
    this.altitude = 0.0D;
    this.latitude = 0.0D;
    this.longitude = 0.0D;
  }
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(173146);
    this.altitude = 0.0D;
    setLatitude(paramDouble1);
    setLongitude(paramDouble2);
    AppMethodBeat.o(173146);
  }
  
  public LatLng(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(173147);
    this.altitude = 0.0D;
    setLatitude(paramDouble1);
    setLongitude(paramDouble2);
    setAltitude(paramDouble3);
    AppMethodBeat.o(173147);
  }
  
  public LatLng(Location paramLocation)
  {
    this(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAltitude());
    AppMethodBeat.i(173148);
    AppMethodBeat.o(173148);
  }
  
  public LatLng(Parcel paramParcel)
  {
    AppMethodBeat.i(173149);
    this.altitude = 0.0D;
    setLatitude(paramParcel.readDouble());
    setLongitude(paramParcel.readDouble());
    setAltitude(paramParcel.readDouble());
    AppMethodBeat.o(173149);
  }
  
  public LatLng(LatLng paramLatLng)
  {
    this.altitude = 0.0D;
    this.latitude = paramLatLng.latitude;
    this.longitude = paramLatLng.longitude;
    this.altitude = paramLatLng.altitude;
  }
  
  static double wrap(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    double d = paramDouble3 - paramDouble2;
    d = ((paramDouble1 - paramDouble2) % d + d) % d;
    if ((paramDouble1 >= paramDouble3) && (d == 0.0D)) {
      return paramDouble3;
    }
    return d + paramDouble2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(173153);
    if (this == paramObject)
    {
      AppMethodBeat.o(173153);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(173153);
      return false;
    }
    paramObject = (LatLng)paramObject;
    if ((Double.compare(paramObject.altitude, this.altitude) == 0) && (Double.compare(paramObject.latitude, this.latitude) == 0) && (Double.compare(paramObject.longitude, this.longitude) == 0))
    {
      AppMethodBeat.o(173153);
      return true;
    }
    AppMethodBeat.o(173153);
    return false;
  }
  
  public double getAltitude()
  {
    return this.altitude;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(173154);
    long l = Double.doubleToLongBits(this.latitude);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.longitude);
    int j = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.altitude);
    int k = (int)(l ^ l >>> 32);
    AppMethodBeat.o(173154);
    return (i * 31 + j) * 31 + k;
  }
  
  public void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(181061);
    super.parse(paramJSONObject);
    AppMethodBeat.o(181061);
  }
  
  public void setAltitude(double paramDouble)
  {
    this.altitude = paramDouble;
  }
  
  public void setLatitude(double paramDouble)
  {
    AppMethodBeat.i(173150);
    IllegalArgumentException localIllegalArgumentException;
    if (Double.isNaN(paramDouble))
    {
      localIllegalArgumentException = new IllegalArgumentException("latitude must not be NaN");
      AppMethodBeat.o(173150);
      throw localIllegalArgumentException;
    }
    if (Math.abs(paramDouble) > 90.0D)
    {
      localIllegalArgumentException = new IllegalArgumentException("latitude must be between -90 and 90");
      AppMethodBeat.o(173150);
      throw localIllegalArgumentException;
    }
    this.latitude = paramDouble;
    AppMethodBeat.o(173150);
  }
  
  public void setLongitude(double paramDouble)
  {
    AppMethodBeat.i(173151);
    IllegalArgumentException localIllegalArgumentException;
    if (Double.isNaN(paramDouble))
    {
      localIllegalArgumentException = new IllegalArgumentException("longitude must not be NaN");
      AppMethodBeat.o(173151);
      throw localIllegalArgumentException;
    }
    if (Double.isInfinite(paramDouble))
    {
      localIllegalArgumentException = new IllegalArgumentException("longitude must not be infinite");
      AppMethodBeat.o(173151);
      throw localIllegalArgumentException;
    }
    this.longitude = paramDouble;
    AppMethodBeat.o(173151);
  }
  
  public String toString()
  {
    AppMethodBeat.i(173155);
    String str = "LatLng [latitude=" + this.latitude + ", longitude=" + this.longitude + ", altitude=" + this.altitude + "]";
    AppMethodBeat.o(173155);
    return str;
  }
  
  public LatLng wrap()
  {
    AppMethodBeat.i(173152);
    LatLng localLatLng = new LatLng(this.latitude, wrap(this.longitude, -180.0D, 180.0D));
    AppMethodBeat.o(173152);
    return localLatLng;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(173156);
    paramParcel.writeDouble(this.latitude);
    paramParcel.writeDouble(this.longitude);
    paramParcel.writeDouble(this.altitude);
    AppMethodBeat.o(173156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.LatLng
 * JD-Core Version:    0.7.0.1
 */