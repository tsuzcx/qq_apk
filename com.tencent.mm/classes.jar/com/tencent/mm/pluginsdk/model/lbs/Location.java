package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class Location
  implements Parcelable
{
  public static final Parcelable.Creator<Location> CREATOR;
  public int accuracy;
  public int cAJ;
  public String cAL;
  public float fBB;
  public float fBC;
  public String mac;
  
  static
  {
    AppMethodBeat.i(79410);
    CREATOR = new Location.1();
    AppMethodBeat.o(79410);
  }
  
  public Location() {}
  
  public Location(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.fBB = paramFloat1;
    this.fBC = paramFloat2;
    this.accuracy = paramInt1;
    this.cAJ = paramInt2;
    this.mac = paramString1;
    this.cAL = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean dlP()
  {
    AppMethodBeat.i(79408);
    if ((this.fBB == -85.0F) || (this.fBC == -1000.0F))
    {
      ab.d("MicroMsg.Radar.Location", "mac and cellId is null");
      AppMethodBeat.o(79408);
      return true;
    }
    AppMethodBeat.o(79408);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79409);
    paramParcel.writeFloat(this.fBB);
    paramParcel.writeFloat(this.fBC);
    paramParcel.writeInt(this.accuracy);
    paramParcel.writeInt(this.cAJ);
    paramParcel.writeString(this.mac);
    paramParcel.writeString(this.cAL);
    AppMethodBeat.o(79409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.lbs.Location
 * JD-Core Version:    0.7.0.1
 */