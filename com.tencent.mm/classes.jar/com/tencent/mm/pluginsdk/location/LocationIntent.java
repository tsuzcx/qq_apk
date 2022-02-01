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
  public String BNO = "";
  public int BNP = 0;
  public int dpd = 0;
  public String goQ = "";
  public Addr hek = null;
  public String label = "";
  public double lat;
  public double lng;
  public String sOA;
  public String sOC;
  
  static
  {
    AppMethodBeat.i(151630);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(151630);
  }
  
  public final String agO()
  {
    AppMethodBeat.i(151628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lat " + this.lat + ";");
    ((StringBuffer)localObject).append("lng " + this.lng + ";");
    ((StringBuffer)localObject).append("scale " + this.dpd + ";");
    ((StringBuffer)localObject).append("label " + this.label + ";");
    ((StringBuffer)localObject).append("poiname " + this.goQ + ";");
    ((StringBuffer)localObject).append("infourl " + this.BNO + ";");
    ((StringBuffer)localObject).append("locTypeId " + this.sOA + ";");
    ((StringBuffer)localObject).append("poiType " + this.BNP + ";");
    if (this.hek != null) {
      ((StringBuffer)localObject).append("addr " + this.hek.toString() + ";");
    }
    ((StringBuffer)localObject).append("poiid " + this.sOC + ";");
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
    paramParcel.writeInt(this.dpd);
    paramParcel.writeString(this.label);
    paramParcel.writeString(this.goQ);
    paramParcel.writeString(this.BNO);
    paramParcel.writeString(this.sOA);
    paramParcel.writeInt(this.BNP);
    paramParcel.writeParcelable(this.hek, paramInt);
    paramParcel.writeString(this.sOC);
    AppMethodBeat.o(151629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationIntent
 * JD-Core Version:    0.7.0.1
 */