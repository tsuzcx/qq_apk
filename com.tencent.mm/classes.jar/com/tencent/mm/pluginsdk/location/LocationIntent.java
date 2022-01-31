package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelgeo.Addr;

public class LocationIntent
  implements Parcelable
{
  public static final Parcelable.Creator<LocationIntent> CREATOR = new LocationIntent.1();
  public int bRv = 0;
  public Addr els = null;
  public String lCO;
  public String lCQ;
  public String lFn = "";
  public String label = "";
  public double lat;
  public double lng;
  public String rSW = "";
  public int rSX = 0;
  
  public final String bLE()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("lat " + this.lat + ";");
    localStringBuffer.append("lng " + this.lng + ";");
    localStringBuffer.append("scale " + this.bRv + ";");
    localStringBuffer.append("label " + this.label + ";");
    localStringBuffer.append("poiname " + this.lFn + ";");
    localStringBuffer.append("infourl " + this.rSW + ";");
    localStringBuffer.append("locTypeId " + this.lCO + ";");
    localStringBuffer.append("poiType " + this.rSX + ";");
    if (this.els != null) {
      localStringBuffer.append("addr " + this.els.toString() + ";");
    }
    localStringBuffer.append("poiid " + this.lCQ + ";");
    return localStringBuffer.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.lat);
    paramParcel.writeDouble(this.lng);
    paramParcel.writeInt(this.bRv);
    paramParcel.writeString(this.label);
    paramParcel.writeString(this.lFn);
    paramParcel.writeString(this.rSW);
    paramParcel.writeString(this.lCO);
    paramParcel.writeInt(this.rSX);
    paramParcel.writeParcelable(this.els, paramInt);
    paramParcel.writeString(this.lCQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationIntent
 * JD-Core Version:    0.7.0.1
 */