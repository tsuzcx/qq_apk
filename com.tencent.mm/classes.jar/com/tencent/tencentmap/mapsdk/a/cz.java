package com.tencent.tencentmap.mapsdk.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class cz
  implements Parcelable
{
  public static final Parcelable.Creator<cz> CREATOR;
  public double a;
  public double b;
  
  static
  {
    AppMethodBeat.i(150035);
    CREATOR = new Parcelable.Creator()
    {
      public final cz a(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(150026);
        paramAnonymousParcel = new cz(paramAnonymousParcel, null);
        AppMethodBeat.o(150026);
        return paramAnonymousParcel;
      }
      
      public final cz[] a(int paramAnonymousInt)
      {
        return new cz[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(150035);
  }
  
  public cz(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150029);
    if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D)) {}
    for (this.b = paramDouble2;; this.b = (((paramDouble2 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D))
    {
      this.a = Math.max(-90.0D, Math.min(90.0D, paramDouble1));
      AppMethodBeat.o(150029);
      return;
    }
  }
  
  private cz(Parcel paramParcel)
  {
    AppMethodBeat.i(150030);
    this.a = paramParcel.readDouble();
    this.b = paramParcel.readDouble();
    AppMethodBeat.o(150030);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(150032);
    if (this == paramObject)
    {
      AppMethodBeat.o(150032);
      return true;
    }
    if (!(paramObject instanceof cz))
    {
      AppMethodBeat.o(150032);
      return false;
    }
    paramObject = (cz)paramObject;
    if ((Double.doubleToLongBits(this.a) == Double.doubleToLongBits(paramObject.a)) && (Double.doubleToLongBits(this.b) == Double.doubleToLongBits(paramObject.b)))
    {
      AppMethodBeat.o(150032);
      return true;
    }
    AppMethodBeat.o(150032);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(150031);
    long l = Double.doubleToLongBits(this.a);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.b);
    int j = (int)(l ^ l >>> 32);
    AppMethodBeat.o(150031);
    return (i + 31) * 31 + j;
  }
  
  public String toString()
  {
    AppMethodBeat.i(150033);
    String str = "lat/lng: (" + this.a + "," + this.b + ")";
    AppMethodBeat.o(150033);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(150034);
    paramParcel.writeDouble(this.a);
    paramParcel.writeDouble(this.b);
    AppMethodBeat.o(150034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cz
 * JD-Core Version:    0.7.0.1
 */