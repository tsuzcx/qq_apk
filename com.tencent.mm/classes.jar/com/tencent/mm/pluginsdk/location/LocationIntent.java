package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;

public class LocationIntent
  implements Parcelable
{
  public static final Parcelable.Creator<LocationIntent> CREATOR;
  public String EJU = "";
  public int EJV = 0;
  public int dyB = 0;
  public Addr hXs = null;
  public String jDf = "";
  public String label = "";
  public double lat;
  public double lng;
  public String uZw;
  public String uZy;
  
  static
  {
    AppMethodBeat.i(151630);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(151630);
  }
  
  public final String akR()
  {
    AppMethodBeat.i(151628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lat " + this.lat + ";");
    ((StringBuffer)localObject).append("lng " + this.lng + ";");
    ((StringBuffer)localObject).append("scale " + this.dyB + ";");
    ((StringBuffer)localObject).append("label " + this.label + ";");
    ((StringBuffer)localObject).append("poiname " + this.jDf + ";");
    ((StringBuffer)localObject).append("infourl " + this.EJU + ";");
    ((StringBuffer)localObject).append("locTypeId " + this.uZw + ";");
    ((StringBuffer)localObject).append("poiType " + this.EJV + ";");
    if (this.hXs != null) {
      ((StringBuffer)localObject).append("addr " + this.hXs.toString() + ";");
    }
    ((StringBuffer)localObject).append("poiid " + this.uZy + ";");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(151628);
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(151629);
    paramParcel.writeDouble(this.lat);
    paramParcel.writeDouble(this.lng);
    paramParcel.writeInt(this.dyB);
    paramParcel.writeString(this.label);
    paramParcel.writeString(this.jDf);
    paramParcel.writeString(this.EJU);
    paramParcel.writeString(this.uZw);
    paramParcel.writeInt(this.EJV);
    paramParcel.writeParcelable(this.hXs, paramInt);
    paramParcel.writeString(this.uZy);
    AppMethodBeat.o(151629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationIntent
 * JD-Core Version:    0.7.0.1
 */