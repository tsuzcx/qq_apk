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
  public String Fcs = "";
  public int Fct = 0;
  public int dzG = 0;
  public Addr iak = null;
  public String jGd = "";
  public String label = "";
  public double lat;
  public double lng;
  public String vlH;
  public String vlJ;
  
  static
  {
    AppMethodBeat.i(151630);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(151630);
  }
  
  public final String alg()
  {
    AppMethodBeat.i(151628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lat " + this.lat + ";");
    ((StringBuffer)localObject).append("lng " + this.lng + ";");
    ((StringBuffer)localObject).append("scale " + this.dzG + ";");
    ((StringBuffer)localObject).append("label " + this.label + ";");
    ((StringBuffer)localObject).append("poiname " + this.jGd + ";");
    ((StringBuffer)localObject).append("infourl " + this.Fcs + ";");
    ((StringBuffer)localObject).append("locTypeId " + this.vlH + ";");
    ((StringBuffer)localObject).append("poiType " + this.Fct + ";");
    if (this.iak != null) {
      ((StringBuffer)localObject).append("addr " + this.iak.toString() + ";");
    }
    ((StringBuffer)localObject).append("poiid " + this.vlJ + ";");
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
    paramParcel.writeInt(this.dzG);
    paramParcel.writeString(this.label);
    paramParcel.writeString(this.jGd);
    paramParcel.writeString(this.Fcs);
    paramParcel.writeString(this.vlH);
    paramParcel.writeInt(this.Fct);
    paramParcel.writeParcelable(this.iak, paramInt);
    paramParcel.writeString(this.vlJ);
    AppMethodBeat.o(151629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationIntent
 * JD-Core Version:    0.7.0.1
 */