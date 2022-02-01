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
  Rect LMK;
  ImageView.ScaleType LMd;
  float LMo;
  RectF LMt;
  RectF LMu;
  PointF LMw;
  float cQN;
  public RectF mLN;
  RectF ubC;
  
  static
  {
    AppMethodBeat.i(164266);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(164266);
  }
  
  public PhotoView$Info(Rect paramRect1, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, PointF paramPointF, float paramFloat1, float paramFloat2, ImageView.ScaleType paramScaleType, Rect paramRect2)
  {
    AppMethodBeat.i(164262);
    this.mLN = new RectF();
    this.LMu = new RectF();
    this.ubC = new RectF();
    this.LMt = new RectF();
    this.LMw = new PointF();
    this.LMK = new Rect();
    this.mLN.set(paramRect1);
    this.LMu.set(paramRectF1);
    this.ubC.set(paramRectF2);
    this.cQN = paramFloat1;
    this.LMd = paramScaleType;
    this.LMo = paramFloat2;
    this.LMt.set(paramRectF3);
    this.LMw.set(paramPointF);
    this.LMK.set(paramRect2);
    AppMethodBeat.o(164262);
  }
  
  protected PhotoView$Info(Parcel paramParcel)
  {
    AppMethodBeat.i(164265);
    this.mLN = new RectF();
    this.LMu = new RectF();
    this.ubC = new RectF();
    this.LMt = new RectF();
    this.LMw = new PointF();
    this.LMK = new Rect();
    this.mLN = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.LMu = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.ubC = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.LMt = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.LMw = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.LMK = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
    this.cQN = paramParcel.readFloat();
    this.LMo = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i == -1) {}
    for (paramParcel = null;; paramParcel = ImageView.ScaleType.values()[i])
    {
      this.LMd = paramParcel;
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
    String str = "Info{mRect=" + this.mLN + ", mImgRect=" + this.LMu + ", mWidgetRect=" + this.ubC + ", mBaseRect=" + this.LMt + ", mScale=" + this.cQN + '}';
    AppMethodBeat.o(164263);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(164264);
    paramParcel.writeParcelable(this.mLN, paramInt);
    paramParcel.writeParcelable(this.LMu, paramInt);
    paramParcel.writeParcelable(this.ubC, paramInt);
    paramParcel.writeParcelable(this.LMt, paramInt);
    paramParcel.writeParcelable(this.LMw, paramInt);
    paramParcel.writeParcelable(this.LMK, paramInt);
    paramParcel.writeFloat(this.cQN);
    paramParcel.writeFloat(this.LMo);
    if (this.LMd == null) {}
    for (paramInt = -1;; paramInt = this.LMd.ordinal())
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