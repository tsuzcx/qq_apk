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
  RectF HRw;
  ImageView.ScaleType agHJ;
  float agHU;
  RectF agHZ;
  RectF agIa;
  PointF agIc;
  Rect agIq;
  float hco;
  public RectF ugw;
  
  static
  {
    AppMethodBeat.i(164266);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(164266);
  }
  
  public PhotoView$Info(Rect paramRect1, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, PointF paramPointF, float paramFloat1, float paramFloat2, ImageView.ScaleType paramScaleType, Rect paramRect2)
  {
    AppMethodBeat.i(164262);
    this.ugw = new RectF();
    this.agIa = new RectF();
    this.HRw = new RectF();
    this.agHZ = new RectF();
    this.agIc = new PointF();
    this.agIq = new Rect();
    this.ugw.set(paramRect1);
    this.agIa.set(paramRectF1);
    this.HRw.set(paramRectF2);
    this.hco = paramFloat1;
    this.agHJ = paramScaleType;
    this.agHU = paramFloat2;
    this.agHZ.set(paramRectF3);
    this.agIc.set(paramPointF);
    this.agIq.set(paramRect2);
    AppMethodBeat.o(164262);
  }
  
  protected PhotoView$Info(Parcel paramParcel)
  {
    AppMethodBeat.i(164265);
    this.ugw = new RectF();
    this.agIa = new RectF();
    this.HRw = new RectF();
    this.agHZ = new RectF();
    this.agIc = new PointF();
    this.agIq = new Rect();
    this.ugw = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.agIa = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.HRw = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.agHZ = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.agIc = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.agIq = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
    this.hco = paramParcel.readFloat();
    this.agHU = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i == -1) {}
    for (paramParcel = null;; paramParcel = ImageView.ScaleType.values()[i])
    {
      this.agHJ = paramParcel;
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
    String str = "Info{mRect=" + this.ugw + ", mImgRect=" + this.agIa + ", mWidgetRect=" + this.HRw + ", mBaseRect=" + this.agHZ + ", mScale=" + this.hco + '}';
    AppMethodBeat.o(164263);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(164264);
    paramParcel.writeParcelable(this.ugw, paramInt);
    paramParcel.writeParcelable(this.agIa, paramInt);
    paramParcel.writeParcelable(this.HRw, paramInt);
    paramParcel.writeParcelable(this.agHZ, paramInt);
    paramParcel.writeParcelable(this.agIc, paramInt);
    paramParcel.writeParcelable(this.agIq, paramInt);
    paramParcel.writeFloat(this.hco);
    paramParcel.writeFloat(this.agHU);
    if (this.agHJ == null) {}
    for (paramInt = -1;; paramInt = this.agHJ.ordinal())
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(164264);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView.Info
 * JD-Core Version:    0.7.0.1
 */