package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.exception.InvalidLatLngBoundsException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LatLngBounds
  implements Parcelable
{
  public static final Parcelable.Creator<LatLngBounds> CREATOR;
  private final double latitudeNorth;
  private final double latitudeSouth;
  private final double longitudeEast;
  private final double longitudeWest;
  public final LatLng northeast;
  public final LatLng southwest;
  
  static
  {
    AppMethodBeat.i(173196);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(173196);
  }
  
  LatLngBounds(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(173163);
    this.latitudeNorth = paramDouble1;
    this.longitudeEast = paramDouble2;
    this.latitudeSouth = paramDouble3;
    this.longitudeWest = paramDouble4;
    this.northeast = new LatLng(paramDouble1, paramDouble2);
    this.southwest = new LatLng(paramDouble3, paramDouble4);
    AppMethodBeat.o(173163);
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this.northeast = paramLatLng1;
    this.southwest = paramLatLng2;
    this.latitudeNorth = paramLatLng1.latitude;
    this.longitudeEast = paramLatLng1.longitude;
    this.latitudeSouth = paramLatLng2.latitude;
    this.longitudeWest = paramLatLng2.longitude;
  }
  
  public static Builder builder()
  {
    AppMethodBeat.i(173165);
    Builder localBuilder = new Builder();
    AppMethodBeat.o(173165);
    return localBuilder;
  }
  
  private static void checkParams(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(181064);
    IllegalArgumentException localIllegalArgumentException;
    if ((Double.isNaN(paramDouble1)) || (Double.isNaN(paramDouble3)))
    {
      localIllegalArgumentException = new IllegalArgumentException("latitude must not be NaN");
      AppMethodBeat.o(181064);
      throw localIllegalArgumentException;
    }
    if ((Double.isNaN(paramDouble2)) || (Double.isNaN(paramDouble4)))
    {
      localIllegalArgumentException = new IllegalArgumentException("longitude must not be NaN");
      AppMethodBeat.o(181064);
      throw localIllegalArgumentException;
    }
    if ((Double.isInfinite(paramDouble2)) || (Double.isInfinite(paramDouble4)))
    {
      localIllegalArgumentException = new IllegalArgumentException("longitude must not be infinite");
      AppMethodBeat.o(181064);
      throw localIllegalArgumentException;
    }
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D) || (paramDouble3 > 90.0D) || (paramDouble3 < -90.0D))
    {
      localIllegalArgumentException = new IllegalArgumentException("latitude must be between -90 and 90");
      AppMethodBeat.o(181064);
      throw localIllegalArgumentException;
    }
    if (paramDouble1 < paramDouble3)
    {
      localIllegalArgumentException = new IllegalArgumentException("latNorth cannot be less than latSouth");
      AppMethodBeat.o(181064);
      throw localIllegalArgumentException;
    }
    if (paramDouble2 < paramDouble4)
    {
      localIllegalArgumentException = new IllegalArgumentException("lonEast cannot be less than lonWest");
      AppMethodBeat.o(181064);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(181064);
  }
  
  private boolean containsLatitude(double paramDouble)
  {
    return (paramDouble <= this.latitudeNorth) && (paramDouble >= this.latitudeSouth);
  }
  
  private boolean containsLongitude(double paramDouble)
  {
    return (paramDouble <= this.longitudeEast) && (paramDouble >= this.longitudeWest);
  }
  
  public static LatLngBounds from(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(173179);
    checkParams(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    LatLngBounds localLatLngBounds = new LatLngBounds(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    AppMethodBeat.o(173179);
    return localLatLngBounds;
  }
  
  public static LatLngBounds from(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(173183);
    LatLngBounds localLatLngBounds = new LatLngBounds(lat_(paramInt1, paramInt3), lon_(paramInt1, paramInt2 + 1), lat_(paramInt1, paramInt3 + 1), lon_(paramInt1, paramInt2));
    AppMethodBeat.o(173183);
    return localLatLngBounds;
  }
  
  static LatLngBounds fromLatLngs(List<? extends LatLng> paramList)
  {
    AppMethodBeat.i(181063);
    double d4 = 90.0D;
    double d2 = 1.7976931348623157E+308D;
    double d3 = -90.0D;
    double d1 = -1.797693134862316E+308D;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LatLng localLatLng = (LatLng)paramList.next();
      if (localLatLng != null)
      {
        double d6 = localLatLng.getLatitude();
        double d5 = localLatLng.getLongitude();
        d4 = Math.min(d4, d6);
        d2 = Math.min(d2, d5);
        d3 = Math.max(d3, d6);
        d1 = Math.max(d1, d5);
      }
    }
    paramList = new LatLngBounds(d3, d1, d4, d2);
    AppMethodBeat.o(181063);
    return paramList;
  }
  
  private LatLngBounds intersectNoParamCheck(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(181068);
    paramDouble4 = Math.max(this.longitudeWest, paramDouble4);
    paramDouble2 = Math.min(this.longitudeEast, paramDouble2);
    if (paramDouble2 >= paramDouble4)
    {
      paramDouble3 = Math.max(this.latitudeSouth, paramDouble3);
      paramDouble1 = Math.min(this.latitudeNorth, paramDouble1);
      if (paramDouble1 >= paramDouble3)
      {
        LatLngBounds localLatLngBounds = new LatLngBounds(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
        AppMethodBeat.o(181068);
        return localLatLngBounds;
      }
    }
    AppMethodBeat.o(181068);
    return null;
  }
  
  private static double lat_(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181065);
    double d = 3.141592653589793D - 6.283185307179586D * paramInt2 / Math.pow(2.0D, paramInt1);
    d = Math.toDegrees(Math.atan((Math.exp(d) - Math.exp(-d)) * 0.5D));
    AppMethodBeat.o(181065);
    return d;
  }
  
  private static double lon_(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181066);
    double d = paramInt2 / Math.pow(2.0D, paramInt1);
    AppMethodBeat.o(181066);
    return d * 360.0D - 180.0D;
  }
  
  protected static LatLngBounds readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(173195);
    paramParcel = new LatLngBounds(paramParcel.readDouble(), paramParcel.readDouble(), paramParcel.readDouble(), paramParcel.readDouble());
    AppMethodBeat.o(173195);
    return paramParcel;
  }
  
  private LatLngBounds unionNoParamCheck(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(181067);
    if (this.latitudeNorth < paramDouble1)
    {
      if (this.longitudeEast >= paramDouble2) {
        break label74;
      }
      label23:
      if (this.latitudeSouth <= paramDouble3) {
        break label82;
      }
      label33:
      if (this.longitudeWest <= paramDouble4) {
        break label91;
      }
    }
    for (;;)
    {
      LatLngBounds localLatLngBounds = new LatLngBounds(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      AppMethodBeat.o(181067);
      return localLatLngBounds;
      paramDouble1 = this.latitudeNorth;
      break;
      label74:
      paramDouble2 = this.longitudeEast;
      break label23;
      label82:
      paramDouble3 = this.latitudeSouth;
      break label33;
      label91:
      paramDouble4 = this.longitudeWest;
    }
  }
  
  public static LatLngBounds world()
  {
    AppMethodBeat.i(173164);
    LatLngBounds localLatLngBounds = from(90.0D, 180.0D, -90.0D, -180.0D);
    AppMethodBeat.o(173164);
    return localLatLngBounds;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(173186);
    if ((containsLatitude(paramLatLng.getLatitude())) && (containsLongitude(paramLatLng.getLongitude())))
    {
      AppMethodBeat.o(173186);
      return true;
    }
    AppMethodBeat.o(173186);
    return false;
  }
  
  public boolean contains(LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(173187);
    if ((contains(paramLatLngBounds.getNorthEast())) && (contains(paramLatLngBounds.getSouthWest())))
    {
      AppMethodBeat.o(173187);
      return true;
    }
    AppMethodBeat.o(173187);
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(173185);
    if (this == paramObject)
    {
      AppMethodBeat.o(173185);
      return true;
    }
    if ((paramObject instanceof LatLngBounds))
    {
      paramObject = (LatLngBounds)paramObject;
      if ((this.latitudeNorth == paramObject.getLatNorth()) && (this.latitudeSouth == paramObject.getLatSouth()) && (this.longitudeEast == paramObject.getLonEast()) && (this.longitudeWest == paramObject.getLonWest()))
      {
        AppMethodBeat.o(173185);
        return true;
      }
      AppMethodBeat.o(173185);
      return false;
    }
    AppMethodBeat.o(173185);
    return false;
  }
  
  public LatLng getCenter()
  {
    AppMethodBeat.i(173167);
    LatLng localLatLng = new LatLng((this.latitudeNorth + this.latitudeSouth) / 2.0D, (this.longitudeEast + this.longitudeWest) / 2.0D);
    AppMethodBeat.o(173167);
    return localLatLng;
  }
  
  public double getLatNorth()
  {
    return this.latitudeNorth;
  }
  
  public double getLatSouth()
  {
    return this.latitudeSouth;
  }
  
  public double getLatitudeSpan()
  {
    AppMethodBeat.i(173173);
    double d = Math.abs(this.latitudeNorth - this.latitudeSouth);
    AppMethodBeat.o(173173);
    return d;
  }
  
  public double getLonEast()
  {
    return this.longitudeEast;
  }
  
  public double getLonWest()
  {
    return this.longitudeWest;
  }
  
  public double getLongitudeSpan()
  {
    AppMethodBeat.i(173174);
    double d = Math.abs(this.longitudeEast - this.longitudeWest);
    AppMethodBeat.o(173174);
    return d;
  }
  
  public LatLng getNorthEast()
  {
    AppMethodBeat.i(173169);
    LatLng localLatLng = new LatLng(this.latitudeNorth, this.longitudeEast);
    AppMethodBeat.o(173169);
    return localLatLng;
  }
  
  public LatLng getNorthWest()
  {
    AppMethodBeat.i(173171);
    LatLng localLatLng = new LatLng(this.latitudeNorth, this.longitudeWest);
    AppMethodBeat.o(173171);
    return localLatLng;
  }
  
  public LatLng getSouthEast()
  {
    AppMethodBeat.i(173170);
    LatLng localLatLng = new LatLng(this.latitudeSouth, this.longitudeEast);
    AppMethodBeat.o(173170);
    return localLatLng;
  }
  
  public LatLng getSouthWest()
  {
    AppMethodBeat.i(173168);
    LatLng localLatLng = new LatLng(this.latitudeSouth, this.longitudeWest);
    AppMethodBeat.o(173168);
    return localLatLng;
  }
  
  public LatLngSpan getSpan()
  {
    AppMethodBeat.i(181062);
    LatLngSpan localLatLngSpan = new LatLngSpan(getLatitudeSpan(), getLongitudeSpan());
    AppMethodBeat.o(181062);
    return localLatLngSpan;
  }
  
  public int hashCode()
  {
    return (int)(this.latitudeNorth + 90.0D + (this.latitudeSouth + 90.0D) * 1000.0D + (this.longitudeEast + 180.0D) * 1000000.0D + (this.longitudeWest + 180.0D) * 1000000000.0D);
  }
  
  public LatLngBounds include(LatLng paramLatLng)
  {
    AppMethodBeat.i(173184);
    paramLatLng = new Builder().include(getNorthEast()).include(getSouthWest()).include(paramLatLng).build();
    AppMethodBeat.o(173184);
    return paramLatLng;
  }
  
  public LatLngBounds including(LatLng paramLatLng)
  {
    AppMethodBeat.i(173166);
    paramLatLng = include(paramLatLng);
    AppMethodBeat.o(173166);
    return paramLatLng;
  }
  
  public LatLngBounds intersect(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(173192);
    checkParams(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    LatLngBounds localLatLngBounds = intersectNoParamCheck(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    AppMethodBeat.o(173192);
    return localLatLngBounds;
  }
  
  public LatLngBounds intersect(LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(173191);
    paramLatLngBounds = intersectNoParamCheck(paramLatLngBounds.getLatNorth(), paramLatLngBounds.getLonEast(), paramLatLngBounds.getLatSouth(), paramLatLngBounds.getLonWest());
    AppMethodBeat.o(173191);
    return paramLatLngBounds;
  }
  
  public boolean isEmptySpan()
  {
    AppMethodBeat.i(173175);
    if ((getLongitudeSpan() == 0.0D) || (getLatitudeSpan() == 0.0D))
    {
      AppMethodBeat.o(173175);
      return true;
    }
    AppMethodBeat.o(173175);
    return false;
  }
  
  public LatLng[] toLatLngs()
  {
    AppMethodBeat.i(173178);
    LatLng localLatLng1 = getNorthEast();
    LatLng localLatLng2 = getSouthWest();
    AppMethodBeat.o(173178);
    return new LatLng[] { localLatLng1, localLatLng2 };
  }
  
  public String toString()
  {
    AppMethodBeat.i(173176);
    String str = "N:" + this.latitudeNorth + "; E:" + this.longitudeEast + "; S:" + this.latitudeSouth + "; W:" + this.longitudeWest;
    AppMethodBeat.o(173176);
    return str;
  }
  
  public LatLngBounds union(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    AppMethodBeat.i(173189);
    checkParams(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    LatLngBounds localLatLngBounds = unionNoParamCheck(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
    AppMethodBeat.o(173189);
    return localLatLngBounds;
  }
  
  public LatLngBounds union(LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(173188);
    paramLatLngBounds = unionNoParamCheck(paramLatLngBounds.getLatNorth(), paramLatLngBounds.getLonEast(), paramLatLngBounds.getLatSouth(), paramLatLngBounds.getLonWest());
    AppMethodBeat.o(173188);
    return paramLatLngBounds;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(173194);
    paramParcel.writeDouble(this.latitudeNorth);
    paramParcel.writeDouble(this.longitudeEast);
    paramParcel.writeDouble(this.latitudeSouth);
    paramParcel.writeDouble(this.longitudeWest);
    AppMethodBeat.o(173194);
  }
  
  public static final class Builder
  {
    private final List<LatLng> latLngList;
    
    public Builder()
    {
      AppMethodBeat.i(173159);
      this.latLngList = new ArrayList();
      AppMethodBeat.o(173159);
    }
    
    public final LatLngBounds build()
    {
      AppMethodBeat.i(173160);
      if (this.latLngList.size() < 2)
      {
        localObject = new InvalidLatLngBoundsException(this.latLngList.size());
        AppMethodBeat.o(173160);
        throw ((Throwable)localObject);
      }
      Object localObject = LatLngBounds.fromLatLngs(this.latLngList);
      AppMethodBeat.o(173160);
      return localObject;
    }
    
    public final Builder include(LatLng paramLatLng)
    {
      AppMethodBeat.i(173162);
      this.latLngList.add(paramLatLng);
      AppMethodBeat.o(173162);
      return this;
    }
    
    public final Builder include(List<LatLng> paramList)
    {
      AppMethodBeat.i(173161);
      this.latLngList.addAll(paramList);
      AppMethodBeat.o(173161);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds
 * JD-Core Version:    0.7.0.1
 */