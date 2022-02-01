package com.tencent.mm.view;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewAnimHelper$ViewInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ViewInfo> CREATOR;
  public Rect agcX;
  
  static
  {
    AppMethodBeat.i(143621);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(143621);
  }
  
  public ViewAnimHelper$ViewInfo(Rect paramRect)
  {
    AppMethodBeat.i(143618);
    this.agcX = new Rect();
    this.agcX.set(paramRect);
    AppMethodBeat.o(143618);
  }
  
  protected ViewAnimHelper$ViewInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(143620);
    this.agcX = new Rect();
    this.agcX = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
    AppMethodBeat.o(143620);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143619);
    paramParcel.writeParcelable(this.agcX, paramInt);
    AppMethodBeat.o(143619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.ViewAnimHelper.ViewInfo
 * JD-Core Version:    0.7.0.1
 */