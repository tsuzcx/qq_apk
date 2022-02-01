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
  public int fMG;
  public String fMI;
  public float lLr;
  public float lLs;
  public String mac;
  public int zHu;
  
  static
  {
    AppMethodBeat.i(151847);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(151847);
  }
  
  public Location() {}
  
  public Location(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.lLr = paramFloat1;
    this.lLs = paramFloat2;
    this.zHu = paramInt1;
    this.fMG = paramInt2;
    this.mac = paramString1;
    this.fMI = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean hhP()
  {
    AppMethodBeat.i(151845);
    if ((this.lLr == -85.0F) || (this.lLs == -1000.0F))
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
    paramParcel.writeFloat(this.lLr);
    paramParcel.writeFloat(this.lLs);
    paramParcel.writeInt(this.zHu);
    paramParcel.writeInt(this.fMG);
    paramParcel.writeString(this.mac);
    paramParcel.writeString(this.fMI);
    AppMethodBeat.o(151846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.lbs.Location
 * JD-Core Version:    0.7.0.1
 */