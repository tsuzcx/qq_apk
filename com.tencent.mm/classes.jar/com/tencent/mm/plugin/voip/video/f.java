package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends View
{
  public int fx;
  private Matrix mMatrix;
  private Paint mPaint = new Paint();
  private int mRotateAngle;
  private int qaA;
  private int qaB;
  private int qaC;
  private RectF qaD;
  private boolean qaE;
  public int qaw;
  public int qax;
  public int qay;
  private int qaz;
  
  public f(Context paramContext)
  {
    super(paramContext);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(-65536);
    this.mPaint.setStrokeWidth(a.fromDPToPix(getContext(), 3));
    this.mMatrix = new Matrix();
  }
  
  private static int cH(int paramInt1, int paramInt2)
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
    if (this.qaD != null)
    {
      paramCanvas.save();
      paramCanvas.rotate(0.0F);
      paramCanvas.drawRect(this.qaD, this.mPaint);
      paramCanvas.restore();
    }
  }
  
  public final void setFaceLocation(int[] paramArrayOfInt)
  {
    int m;
    int n;
    int i1;
    int i2;
    int i;
    int j;
    if (paramArrayOfInt != null)
    {
      this.qaz = paramArrayOfInt[0];
      this.qaA = paramArrayOfInt[1];
      this.qaB = paramArrayOfInt[2];
      this.qaC = paramArrayOfInt[3];
      if ((this.qax != 0) && (this.qay != 0) && (this.fx != 0) && (this.qaw != 0))
      {
        m = this.qaB;
        n = this.qaz;
        i1 = this.qaC;
        i2 = this.qaA;
        y.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", new Object[] { Integer.valueOf(this.qaz), Integer.valueOf(this.qaA), Integer.valueOf(this.qaB), Integer.valueOf(this.qaB) });
        y.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", new Object[] { Integer.valueOf(this.qax), Integer.valueOf(this.qay), Boolean.valueOf(this.qaE), Integer.valueOf(this.mRotateAngle) });
        i = (this.qaB + this.qaz) / 2;
        j = (this.qaC + this.qaA) / 2;
        if ((this.mRotateAngle != 90) && (this.mRotateAngle != 270)) {
          break label542;
        }
      }
    }
    for (;;)
    {
      y.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      float f2;
      if ((this.mRotateAngle == 90) || (this.mRotateAngle == 270)) {
        f2 = this.fx / this.qax;
      }
      for (float f1 = this.qaw / this.qay;; f1 = this.fx / this.qay)
      {
        f1 = Math.max(f2, f1);
        f2 = (int)((m - n) * f1);
        float f3 = (int)((i1 - i2) * f1);
        j = (int)(j * f1);
        i = (int)(i * f1);
        this.qaz = cH((int)(j - f2 / 2.0F), this.qaw);
        this.qaA = cH((int)(i - f3 / 2.0F), this.fx);
        this.qaB = cH((int)(j + f2 / 2.0F), this.qaw);
        this.qaC = cH((int)(i + f3 / 2.0F), this.fx);
        this.qaD = new RectF(this.qaz, this.qaA, this.qaB, this.qaC);
        y.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", new Object[] { Float.valueOf(this.qaD.left), Float.valueOf(this.qaD.top), Float.valueOf(this.qaD.right), Float.valueOf(this.qaD.bottom) });
        return;
        f2 = this.qaw / this.qax;
      }
      label542:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.qaE = paramBoolean;
  }
  
  public final void setRotateAngle(int paramInt)
  {
    this.mRotateAngle = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.f
 * JD-Core Version:    0.7.0.1
 */