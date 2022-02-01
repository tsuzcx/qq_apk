package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Location
  implements Parcelable
{
  public static final Parcelable.Creator<Location> CREATOR;
  public final float dAp;
  public final float dyz;
  
  static
  {
    AppMethodBeat.i(169198);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(169198);
  }
  
  public Location(float paramFloat1, float paramFloat2)
  {
    this.dyz = paramFloat1;
    this.dAp = paramFloat2;
  }
  
  protected Location(Parcel paramParcel)
  {
    AppMethodBeat.i(169196);
    this.dyz = paramParcel.readFloat();
    this.dAp = paramParcel.readFloat();
    AppMethodBeat.o(169196);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(169197);
    paramParcel.writeFloat(this.dyz);
    paramParcel.writeFloat(this.dAp);
    AppMethodBeat.o(169197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.Location
 * JD-Core Version:    0.7.0.1
 */