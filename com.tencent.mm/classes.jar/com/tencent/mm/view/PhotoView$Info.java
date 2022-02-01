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
  RectF Cfp;
  ImageView.ScaleType YLX;
  Rect YME;
  float YMi;
  RectF YMn;
  RectF YMo;
  PointF YMq;
  float eYO;
  public RectF raG;
  
  static
  {
    AppMethodBeat.i(164266);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(164266);
  }
  
  public PhotoView$Info(Rect paramRect1, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, PointF paramPointF, float paramFloat1, float paramFloat2, ImageView.ScaleType paramScaleType, Rect paramRect2)
  {
    AppMethodBeat.i(164262);
    this.raG = new RectF();
    this.YMo = new RectF();
    this.Cfp = new RectF();
    this.YMn = new RectF();
    this.YMq = new PointF();
    this.YME = new Rect();
    this.raG.set(paramRect1);
    this.YMo.set(paramRectF1);
    this.Cfp.set(paramRectF2);
    this.eYO = paramFloat1;
    this.YLX = paramScaleType;
    this.YMi = paramFloat2;
    this.YMn.set(paramRectF3);
    this.YMq.set(paramPointF);
    this.YME.set(paramRect2);
    AppMethodBeat.o(164262);
  }
  
  protected PhotoView$Info(Parcel paramParcel)
  {
    AppMethodBeat.i(164265);
    this.raG = new RectF();
    this.YMo = new RectF();
    this.Cfp = new RectF();
    this.YMn = new RectF();
    this.YMq = new PointF();
    this.YME = new Rect();
    this.raG = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.YMo = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.Cfp = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.YMn = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.YMq = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.YME = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
    this.eYO = paramParcel.readFloat();
    this.YMi = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i == -1) {}
    for (paramParcel = null;; paramParcel = ImageView.ScaleType.values()[i])
    {
      this.YLX = paramParcel;
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
    String str = "Info{mRect=" + this.raG + ", mImgRect=" + this.YMo + ", mWidgetRect=" + this.Cfp + ", mBaseRect=" + this.YMn + ", mScale=" + this.eYO + '}';
    AppMethodBeat.o(164263);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(164264);
    paramParcel.writeParcelable(this.raG, paramInt);
    paramParcel.writeParcelable(this.YMo, paramInt);
    paramParcel.writeParcelable(this.Cfp, paramInt);
    paramParcel.writeParcelable(this.YMn, paramInt);
    paramParcel.writeParcelable(this.YMq, paramInt);
    paramParcel.writeParcelable(this.YME, paramInt);
    paramParcel.writeFloat(this.eYO);
    paramParcel.writeFloat(this.YMi);
    if (this.YLX == null) {}
    for (paramInt = -1;; paramInt = this.YLX.ordinal())
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(164264);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView.Info
 * JD-Core Version:    0.7.0.1
 */