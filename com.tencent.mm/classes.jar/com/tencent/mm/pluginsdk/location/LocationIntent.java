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
  public String JTr = "";
  public int JTs = 0;
  public int dRt = 0;
  public Addr iVi = null;
  public String kHV = "";
  public String label = "";
  public double lat;
  public double lng;
  public String yFB;
  public String yFz;
  
  static
  {
    AppMethodBeat.i(151630);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(151630);
  }
  
  public final String aBz()
  {
    AppMethodBeat.i(151628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lat " + this.lat + ";");
    ((StringBuffer)localObject).append("lng " + this.lng + ";");
    ((StringBuffer)localObject).append("scale " + this.dRt + ";");
    ((StringBuffer)localObject).append("label " + this.label + ";");
    ((StringBuffer)localObject).append("poiname " + this.kHV + ";");
    ((StringBuffer)localObject).append("infourl " + this.JTr + ";");
    ((StringBuffer)localObject).append("locTypeId " + this.yFz + ";");
    ((StringBuffer)localObject).append("poiType " + this.JTs + ";");
    if (this.iVi != null) {
      ((StringBuffer)localObject).append("addr " + this.iVi.toString() + ";");
    }
    ((StringBuffer)localObject).append("poiid " + this.yFB + ";");
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
    paramParcel.writeInt(this.dRt);
    paramParcel.writeString(this.label);
    paramParcel.writeString(this.kHV);
    paramParcel.writeString(this.JTr);
    paramParcel.writeString(this.yFz);
    paramParcel.writeInt(this.JTs);
    paramParcel.writeParcelable(this.iVi, paramInt);
    paramParcel.writeString(this.yFB);
    AppMethodBeat.o(151629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationIntent
 * JD-Core Version:    0.7.0.1
 */