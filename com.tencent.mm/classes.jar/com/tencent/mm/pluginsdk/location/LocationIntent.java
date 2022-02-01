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
  public String Kcb;
  public String Kcd;
  public String XOv = "";
  public int XOw = 0;
  public int hQp = 0;
  public String label = "";
  public double lat;
  public double lng;
  public Addr oEd = null;
  public String poiName = "";
  
  static
  {
    AppMethodBeat.i(151630);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(151630);
  }
  
  public final String bbZ()
  {
    AppMethodBeat.i(151628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lat " + this.lat + ";");
    ((StringBuffer)localObject).append("lng " + this.lng + ";");
    ((StringBuffer)localObject).append("scale " + this.hQp + ";");
    ((StringBuffer)localObject).append("label " + this.label + ";");
    ((StringBuffer)localObject).append("poiname " + this.poiName + ";");
    ((StringBuffer)localObject).append("infourl " + this.XOv + ";");
    ((StringBuffer)localObject).append("locTypeId " + this.Kcb + ";");
    ((StringBuffer)localObject).append("poiType " + this.XOw + ";");
    if (this.oEd != null) {
      ((StringBuffer)localObject).append("addr " + this.oEd.toString() + ";");
    }
    ((StringBuffer)localObject).append("poiid " + this.Kcd + ";");
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
    paramParcel.writeInt(this.hQp);
    paramParcel.writeString(this.label);
    paramParcel.writeString(this.poiName);
    paramParcel.writeString(this.XOv);
    paramParcel.writeString(this.Kcb);
    paramParcel.writeInt(this.XOw);
    paramParcel.writeParcelable(this.oEd, paramInt);
    paramParcel.writeString(this.Kcd);
    AppMethodBeat.o(151629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationIntent
 * JD-Core Version:    0.7.0.1
 */