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
  public float YPr;
  public int ahwf;
  public List<Point> points;
  
  static
  {
    AppMethodBeat.i(3566);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(3566);
  }
  
  public DetectCode(int paramInt, List<Point> paramList, float paramFloat)
  {
    this.ahwf = paramInt;
    this.points = paramList;
    this.YPr = paramFloat;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(3565);
    paramParcel.writeInt(this.ahwf);
    paramParcel.writeTypedList(this.points);
    paramParcel.writeFloat(this.YPr);
    AppMethodBeat.o(3565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.model.DetectCode
 * JD-Core Version:    0.7.0.1
 */