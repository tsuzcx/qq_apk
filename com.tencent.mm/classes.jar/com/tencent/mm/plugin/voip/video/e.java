package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends View
{
  private RectF lEo;
  private Matrix mMatrix;
  private Paint mPaint;
  public int pU;
  private int zuA;
  private boolean zuB;
  private int zuC;
  public int zuu;
  public int zuv;
  public int zuw;
  private int zux;
  private int zuy;
  private int zuz;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(115580);
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(-65536);
    this.mPaint.setStrokeWidth(a.fromDPToPix(getContext(), 3));
    this.mMatrix = new Matrix();
    AppMethodBeat.o(115580);
  }
  
  private static int cX(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > paramInt2) {
        return paramInt2;
      }
      return paramInt1;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(115582);
    if (this.lEo != null)
    {
      paramCanvas.save();
      paramCanvas.rotate(0.0F);
      paramCanvas.drawRect(this.lEo, this.mPaint);
      paramCanvas.restore();
    }
    AppMethodBeat.o(115582);
  }
  
  public final void setFaceLocation(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(115581);
    int m;
    int n;
    int i1;
    int i2;
    int i;
    int j;
    if (paramArrayOfInt != null)
    {
      this.zux = paramArrayOfInt[0];
      this.zuy = paramArrayOfInt[1];
      this.zuz = paramArrayOfInt[2];
      this.zuA = paramArrayOfInt[3];
      if ((this.zuv != 0) && (this.zuw != 0) && (this.pU != 0) && (this.zuu != 0))
      {
        m = this.zuz;
        n = this.zux;
        i1 = this.zuA;
        i2 = this.zuy;
        ad.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", new Object[] { Integer.valueOf(this.zux), Integer.valueOf(this.zuy), Integer.valueOf(this.zuz), Integer.valueOf(this.zuz) });
        ad.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", new Object[] { Integer.valueOf(this.zuv), Integer.valueOf(this.zuw), Boolean.valueOf(this.zuB), Integer.valueOf(this.zuC) });
        i = (this.zuz + this.zux) / 2;
        j = (this.zuA + this.zuy) / 2;
        if ((this.zuC != 90) && (this.zuC != 270)) {
          break label552;
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      float f2;
      if ((this.zuC == 90) || (this.zuC == 270)) {
        f2 = this.pU / this.zuv;
      }
      for (float f1 = this.zuu / this.zuw;; f1 = this.pU / this.zuw)
      {
        f1 = Math.max(f2, f1);
        f2 = (int)((m - n) * f1);
        float f3 = (int)((i1 - i2) * f1);
        j = (int)(j * f1);
        i = (int)(i * f1);
        this.zux = cX((int)(j - f2 / 2.0F), this.zuu);
        this.zuy = cX((int)(i - f3 / 2.0F), this.pU);
        this.zuz = cX((int)(j + f2 / 2.0F), this.zuu);
        this.zuA = cX((int)(i + f3 / 2.0F), this.pU);
        this.lEo = new RectF(this.zux, this.zuy, this.zuz, this.zuA);
        ad.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", new Object[] { Float.valueOf(this.lEo.left), Float.valueOf(this.lEo.top), Float.valueOf(this.lEo.right), Float.valueOf(this.lEo.bottom) });
        AppMethodBeat.o(115581);
        return;
        f2 = this.zuu / this.zuv;
      }
      label552:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.zuB = paramBoolean;
  }
  
  public final void setRotateAngle(int paramInt)
  {
    this.zuC = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.e
 * JD-Core Version:    0.7.0.1
 */