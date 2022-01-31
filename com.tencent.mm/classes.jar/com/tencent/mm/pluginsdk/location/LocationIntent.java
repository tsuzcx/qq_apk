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
  public int cyX = 0;
  public String eSM = "";
  public Addr fBK = null;
  public String label = "";
  public double lat;
  public double lng;
  public String oaa;
  public String oac;
  public String vJU = "";
  public int vJV = 0;
  
  static
  {
    AppMethodBeat.i(79209);
    CREATOR = new LocationIntent.1();
    AppMethodBeat.o(79209);
  }
  
  public final String SU()
  {
    AppMethodBeat.i(79207);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lat " + this.lat + ";");
    ((StringBuffer)localObject).append("lng " + this.lng + ";");
    ((StringBuffer)localObject).append("scale " + this.cyX + ";");
    ((StringBuffer)localObject).append("label " + this.label + ";");
    ((StringBuffer)localObject).append("poiname " + this.eSM + ";");
    ((StringBuffer)localObject).append("infourl " + this.vJU + ";");
    ((StringBuffer)localObject).append("locTypeId " + this.oaa + ";");
    ((StringBuffer)localObject).append("poiType " + this.vJV + ";");
    if (this.fBK != null) {
      ((StringBuffer)localObject).append("addr " + this.fBK.toString() + ";");
    }
    ((StringBuffer)localObject).append("poiid " + this.oac + ";");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(79207);
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79208);
    paramParcel.writeDouble(this.lat);
    paramParcel.writeDouble(this.lng);
    paramParcel.writeInt(this.cyX);
    paramParcel.writeString(this.label);
    paramParcel.writeString(this.eSM);
    paramParcel.writeString(this.vJU);
    paramParcel.writeString(this.oaa);
    paramParcel.writeInt(this.vJV);
    paramParcel.writeParcelable(this.fBK, paramInt);
    paramParcel.writeString(this.oac);
    AppMethodBeat.o(79208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationIntent
 * JD-Core Version:    0.7.0.1
 */