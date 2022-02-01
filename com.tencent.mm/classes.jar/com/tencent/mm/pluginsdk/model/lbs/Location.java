package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class Location
  implements Parcelable
{
  public static final Parcelable.Creator<Location> CREATOR;
  public int accuracy;
  public int doD;
  public String doF;
  public float hEE;
  public float hEF;
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
    this.hEE = paramFloat1;
    this.hEF = paramFloat2;
    this.accuracy = paramInt1;
    this.doD = paramInt2;
    this.mac = paramString1;
    this.doF = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean eLp()
  {
    AppMethodBeat.i(151845);
    if ((this.hEE == -85.0F) || (this.hEF == -1000.0F))
    {
      ac.d("MicroMsg.Radar.Location", "mac and cellId is null");
      AppMethodBeat.o(151845);
      return true;
    }
    AppMethodBeat.o(151845);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(151846);
    paramParcel.writeFloat(this.hEE);
    paramParcel.writeFloat(this.hEF);
    paramParcel.writeInt(this.accuracy);
    paramParcel.writeInt(this.doD);
    paramParcel.writeString(this.mac);
    paramParcel.writeString(this.doF);
    AppMethodBeat.o(151846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.lbs.Location
 * JD-Core Version:    0.7.0.1
 */