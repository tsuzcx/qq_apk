package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class Location
  implements Parcelable
{
  public static final Parcelable.Creator<Location> CREATOR;
  public int accuracy;
  public int dBw;
  public String dBy;
  public float iab;
  public float iac;
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
    this.iab = paramFloat1;
    this.iac = paramFloat2;
    this.accuracy = paramInt1;
    this.dBw = paramInt2;
    this.mac = paramString1;
    this.dBy = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean fdY()
  {
    AppMethodBeat.i(151845);
    if ((this.iab == -85.0F) || (this.iac == -1000.0F))
    {
      ae.d("MicroMsg.Radar.Location", "mac and cellId is null");
      AppMethodBeat.o(151845);
      return true;
    }
    AppMethodBeat.o(151845);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(151846);
    paramParcel.writeFloat(this.iab);
    paramParcel.writeFloat(this.iac);
    paramParcel.writeInt(this.accuracy);
    paramParcel.writeInt(this.dBw);
    paramParcel.writeString(this.mac);
    paramParcel.writeString(this.dBy);
    AppMethodBeat.o(151846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.lbs.Location
 * JD-Core Version:    0.7.0.1
 */