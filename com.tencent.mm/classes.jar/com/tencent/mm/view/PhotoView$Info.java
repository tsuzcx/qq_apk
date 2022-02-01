package com.tencent.mm.view;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PhotoView$Info
  implements Parcelable
{
  public static final Parcelable.Creator<Info> CREATOR;
  float RkD;
  RectF RkI;
  RectF RkJ;
  PointF RkL;
  Rect RkZ;
  ImageView.ScaleType Rks;
  float dhh;
  public RectF nYV;
  RectF xsQ;
  
  static
  {
    AppMethodBeat.i(164266);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(164266);
  }
  
  public PhotoView$Info(Rect paramRect1, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, PointF paramPointF, float paramFloat1, float paramFloat2, ImageView.ScaleType paramScaleType, Rect paramRect2)
  {
    AppMethodBeat.i(164262);
    this.nYV = new RectF();
    this.RkJ = new RectF();
    this.xsQ = new RectF();
    this.RkI = new RectF();
    this.RkL = new PointF();
    this.RkZ = new Rect();
    this.nYV.set(paramRect1);
    this.RkJ.set(paramRectF1);
    this.xsQ.set(paramRectF2);
    this.dhh = paramFloat1;
    this.Rks = paramScaleType;
    this.RkD = paramFloat2;
    this.RkI.set(paramRectF3);
    this.RkL.set(paramPointF);
    this.RkZ.set(paramRect2);
    AppMethodBeat.o(164262);
  }
  
  protected PhotoView$Info(Parcel paramParcel)
  {
    AppMethodBeat.i(164265);
    this.nYV = new RectF();
    this.RkJ = new RectF();
    this.xsQ = new RectF();
    this.RkI = new RectF();
    this.RkL = new PointF();
    this.RkZ = new Rect();
    this.nYV = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.RkJ = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.xsQ = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.RkI = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.RkL = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.RkZ = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
    this.dhh = paramParcel.readFloat();
    this.RkD = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i == -1) {}
    for (paramParcel = null;; paramParcel = ImageView.ScaleType.values()[i])
    {
      this.Rks = paramParcel;
      AppMethodBeat.o(164265);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(164263);
    String str = "Info{mRect=" + this.nYV + ", mImgRect=" + this.RkJ + ", mWidgetRect=" + this.xsQ + ", mBaseRect=" + this.RkI + ", mScale=" + this.dhh + '}';
    AppMethodBeat.o(164263);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(164264);
    paramParcel.writeParcelable(this.nYV, paramInt);
    paramParcel.writeParcelable(this.RkJ, paramInt);
    paramParcel.writeParcelable(this.xsQ, paramInt);
    paramParcel.writeParcelable(this.RkI, paramInt);
    paramParcel.writeParcelable(this.RkL, paramInt);
    paramParcel.writeParcelable(this.RkZ, paramInt);
    paramParcel.writeFloat(this.dhh);
    paramParcel.writeFloat(this.RkD);
    if (this.Rks == null) {}
    for (paramInt = -1;; paramInt = this.Rks.ordinal())
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(164264);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView.Info
 * JD-Core Version:    0.7.0.1
 */