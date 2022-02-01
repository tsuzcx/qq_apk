package com.tencent.mm.sdk.platformtools;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BackwardSupportUtil$ExifHelper$LatLongData
  implements Parcelable
{
  public static final Parcelable.Creator<LatLongData> CREATOR;
  private static final float PRECISION = 1.0E-006F;
  public float latitude;
  public float longtitude;
  
  static
  {
    AppMethodBeat.i(156070);
    CREATOR = new Parcelable.Creator()
    {
      public final BackwardSupportUtil.ExifHelper.LatLongData createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(215290);
        BackwardSupportUtil.ExifHelper.LatLongData localLatLongData = new BackwardSupportUtil.ExifHelper.LatLongData();
        localLatLongData.latitude = paramAnonymousParcel.readFloat();
        localLatLongData.longtitude = paramAnonymousParcel.readFloat();
        AppMethodBeat.o(215290);
        return localLatLongData;
      }
      
      public final BackwardSupportUtil.ExifHelper.LatLongData[] newArray(int paramAnonymousInt)
      {
        return new BackwardSupportUtil.ExifHelper.LatLongData[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(156070);
  }
  
  public BackwardSupportUtil$ExifHelper$LatLongData()
  {
    this.latitude = 0.0F;
    this.longtitude = 0.0F;
  }
  
  public BackwardSupportUtil$ExifHelper$LatLongData(float paramFloat1, float paramFloat2)
  {
    this.latitude = paramFloat1;
    this.longtitude = paramFloat2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(156068);
    if (!(paramObject instanceof LatLongData))
    {
      AppMethodBeat.o(156068);
      return false;
    }
    paramObject = (LatLongData)paramObject;
    if ((Math.abs(this.latitude - paramObject.latitude) < 1.0E-006F) && (Math.abs(this.longtitude - paramObject.longtitude) < 1.0E-006F))
    {
      AppMethodBeat.o(156068);
      return true;
    }
    AppMethodBeat.o(156068);
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.latitude * 10000.0F) + (int)(this.longtitude * 10000.0F);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(156069);
    paramParcel.writeFloat(this.latitude);
    paramParcel.writeFloat(this.longtitude);
    AppMethodBeat.o(156069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData
 * JD-Core Version:    0.7.0.1
 */