package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends View
{
  public int gu;
  private Matrix mMatrix;
  private Paint mPaint;
  private int mRotateAngle;
  public int tFW;
  public int tFX;
  public int tFY;
  private int tFZ;
  private int tGa;
  private int tGb;
  private int tGc;
  private RectF tGd;
  private boolean tGe;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(5061);
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(-65536);
    this.mPaint.setStrokeWidth(a.fromDPToPix(getContext(), 3));
    this.mMatrix = new Matrix();
    AppMethodBeat.o(5061);
  }
  
  private static int ef(int paramInt1, int paramInt2)
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
    AppMethodBeat.i(5063);
    if (this.tGd != null)
    {
      paramCanvas.save();
      paramCanvas.rotate(0.0F);
      paramCanvas.drawRect(this.tGd, this.mPaint);
      paramCanvas.restore();
    }
    AppMethodBeat.o(5063);
  }
  
  public final void setFaceLocation(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(5062);
    int m;
    int n;
    int i1;
    int i2;
    int i;
    int j;
    if (paramArrayOfInt != null)
    {
      this.tFZ = paramArrayOfInt[0];
      this.tGa = paramArrayOfInt[1];
      this.tGb = paramArrayOfInt[2];
      this.tGc = paramArrayOfInt[3];
      if ((this.tFX != 0) && (this.tFY != 0) && (this.gu != 0) && (this.tFW != 0))
      {
        m = this.tGb;
        n = this.tFZ;
        i1 = this.tGc;
        i2 = this.tGa;
        ab.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", new Object[] { Integer.valueOf(this.tFZ), Integer.valueOf(this.tGa), Integer.valueOf(this.tGb), Integer.valueOf(this.tGb) });
        ab.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", new Object[] { Integer.valueOf(this.tFX), Integer.valueOf(this.tFY), Boolean.valueOf(this.tGe), Integer.valueOf(this.mRotateAngle) });
        i = (this.tGb + this.tFZ) / 2;
        j = (this.tGc + this.tGa) / 2;
        if ((this.mRotateAngle != 90) && (this.mRotateAngle != 270)) {
          break label554;
        }
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      float f2;
      if ((this.mRotateAngle == 90) || (this.mRotateAngle == 270)) {
        f2 = this.gu / this.tFX;
      }
      for (float f1 = this.tFW / this.tFY;; f1 = this.gu / this.tFY)
      {
        f1 = Math.max(f2, f1);
        f2 = (int)((m - n) * f1);
        float f3 = (int)((i1 - i2) * f1);
        j = (int)(j * f1);
        i = (int)(i * f1);
        this.tFZ = ef((int)(j - f2 / 2.0F), this.tFW);
        this.tGa = ef((int)(i - f3 / 2.0F), this.gu);
        this.tGb = ef((int)(j + f2 / 2.0F), this.tFW);
        this.tGc = ef((int)(i + f3 / 2.0F), this.gu);
        this.tGd = new RectF(this.tFZ, this.tGa, this.tGb, this.tGc);
        ab.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", new Object[] { Float.valueOf(this.tGd.left), Float.valueOf(this.tGd.top), Float.valueOf(this.tGd.right), Float.valueOf(this.tGd.bottom) });
        AppMethodBeat.o(5062);
        return;
        f2 = this.tFW / this.tFX;
      }
      label554:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.tGe = paramBoolean;
  }
  
  public final void setRotateAngle(int paramInt)
  {
    this.mRotateAngle = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.e
 * JD-Core Version:    0.7.0.1
 */