package com.tencent.scanlib.model;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class DetectCode
  implements Parcelable
{
  public static final Parcelable.Creator<DetectCode> CREATOR;
  public int ROK;
  public float ROL;
  public List<Point> points;
  
  static
  {
    AppMethodBeat.i(3566);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(3566);
  }
  
  public DetectCode(int paramInt, List<Point> paramList, float paramFloat)
  {
    this.ROK = paramInt;
    this.points = paramList;
    this.ROL = paramFloat;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(3565);
    paramParcel.writeInt(this.ROK);
    paramParcel.writeTypedList(this.points);
    paramParcel.writeFloat(this.ROL);
    AppMethodBeat.o(3565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.scanlib.model.DetectCode
 * JD-Core Version:    0.7.0.1
 */