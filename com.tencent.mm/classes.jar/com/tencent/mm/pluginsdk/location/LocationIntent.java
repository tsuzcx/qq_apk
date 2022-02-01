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
  public String DfY = "";
  public int DfZ = 0;
  public int dmN = 0;
  public String gPy = "";
  public Addr hEN = null;
  public String label = "";
  public double lat;
  public double lng;
  public String tWN;
  public String tWP;
  
  static
  {
    AppMethodBeat.i(151630);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(151630);
  }
  
  public final String aif()
  {
    AppMethodBeat.i(151628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lat " + this.lat + ";");
    ((StringBuffer)localObject).append("lng " + this.lng + ";");
    ((StringBuffer)localObject).append("scale " + this.dmN + ";");
    ((StringBuffer)localObject).append("label " + this.label + ";");
    ((StringBuffer)localObject).append("poiname " + this.gPy + ";");
    ((StringBuffer)localObject).append("infourl " + this.DfY + ";");
    ((StringBuffer)localObject).append("locTypeId " + this.tWN + ";");
    ((StringBuffer)localObject).append("poiType " + this.DfZ + ";");
    if (this.hEN != null) {
      ((StringBuffer)localObject).append("addr " + this.hEN.toString() + ";");
    }
    ((StringBuffer)localObject).append("poiid " + this.tWP + ";");
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
    paramParcel.writeInt(this.dmN);
    paramParcel.writeString(this.label);
    paramParcel.writeString(this.gPy);
    paramParcel.writeString(this.DfY);
    paramParcel.writeString(this.tWN);
    paramParcel.writeInt(this.DfZ);
    paramParcel.writeParcelable(this.hEN, paramInt);
    paramParcel.writeString(this.tWP);
    AppMethodBeat.o(151629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.LocationIntent
 * JD-Core Version:    0.7.0.1
 */