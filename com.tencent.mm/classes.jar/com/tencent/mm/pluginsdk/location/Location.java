package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Location
  implements Parcelable
{
  public static final Parcelable.Creator<Location> CREATOR;
  public final float dpb;
  public final float dqQ;
  
  static
  {
    AppMethodBeat.i(169198);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(169198);
  }
  
  public Location(float paramFloat1, float paramFloat2)
  {
    this.dpb = paramFloat1;
    this.dqQ = paramFloat2;
  }
  
  protected Location(Parcel paramParcel)
  {
    AppMethodBeat.i(169196);
    this.dpb = paramParcel.readFloat();
    this.dqQ = paramParcel.readFloat();
    AppMethodBeat.o(169196);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(169197);
    paramParcel.writeFloat(this.dpb);
    paramParcel.writeFloat(this.dqQ);
    AppMethodBeat.o(169197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.location.Location
 * JD-Core Version:    0.7.0.1
 */