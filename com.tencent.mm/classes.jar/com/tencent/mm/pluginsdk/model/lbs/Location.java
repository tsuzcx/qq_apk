package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class Location
  implements Parcelable
{
  public static final Parcelable.Creator<Location> CREATOR;
  public int accuracy;
  public int dTl;
  public String dTn;
  public float iUY;
  public float iUZ;
  public String mac;
  
  static
  {
    AppMethodBeat.i(151847);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(151847);
  }
  
  public Location() {}
  
  public Location(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.iUY = paramFloat1;
    this.iUZ = paramFloat2;
    this.accuracy = paramInt1;
    this.dTl = paramInt2;
    this.mac = paramString1;
    this.dTn = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean gnj()
  {
    AppMethodBeat.i(151845);
    if ((this.iUY == -85.0F) || (this.iUZ == -1000.0F))
    {
      Log.d("MicroMsg.Radar.Location", "mac and cellId is null");
      AppMethodBeat.o(151845);
      return true;
    }
    AppMethodBeat.o(151845);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(151846);
    paramParcel.writeFloat(this.iUY);
    paramParcel.writeFloat(this.iUZ);
    paramParcel.writeInt(this.accuracy);
    paramParcel.writeInt(this.dTl);
    paramParcel.writeString(this.mac);
    paramParcel.writeString(this.dTn);
    AppMethodBeat.o(151846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.lbs.Location
 * JD-Core Version:    0.7.0.1
 */