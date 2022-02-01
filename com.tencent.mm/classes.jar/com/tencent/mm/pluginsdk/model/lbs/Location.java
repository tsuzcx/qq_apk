package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class Location
  implements Parcelable
{
  public static final Parcelable.Creator<Location> CREATOR;
  public int accuracy;
  public int dAr;
  public String dAt;
  public float hXj;
  public float hXk;
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
    this.hXj = paramFloat1;
    this.hXk = paramFloat2;
    this.accuracy = paramInt1;
    this.dAr = paramInt2;
    this.mac = paramString1;
    this.dAt = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean fak()
  {
    AppMethodBeat.i(151845);
    if ((this.hXj == -85.0F) || (this.hXk == -1000.0F))
    {
      ad.d("MicroMsg.Radar.Location", "mac and cellId is null");
      AppMethodBeat.o(151845);
      return true;
    }
    AppMethodBeat.o(151845);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(151846);
    paramParcel.writeFloat(this.hXj);
    paramParcel.writeFloat(this.hXk);
    paramParcel.writeInt(this.accuracy);
    paramParcel.writeInt(this.dAr);
    paramParcel.writeString(this.mac);
    paramParcel.writeString(this.dAt);
    AppMethodBeat.o(151846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.lbs.Location
 * JD-Core Version:    0.7.0.1
 */