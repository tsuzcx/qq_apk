package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends View
{
  public int CmA;
  public int CmB;
  private int CmC;
  private int CmD;
  private int CmE;
  private int CmF;
  private boolean CmG;
  private int CmH;
  public int Cmz;
  private RectF mGJ;
  private Matrix mMatrix;
  private Paint mPaint;
  public int sP;
  
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
  
  private static int cZ(int paramInt1, int paramInt2)
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
    if (this.mGJ != null)
    {
      paramCanvas.save();
      paramCanvas.rotate(0.0F);
      paramCanvas.drawRect(this.mGJ, this.mPaint);
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
      this.CmC = paramArrayOfInt[0];
      this.CmD = paramArrayOfInt[1];
      this.CmE = paramArrayOfInt[2];
      this.CmF = paramArrayOfInt[3];
      if ((this.CmA != 0) && (this.CmB != 0) && (this.sP != 0) && (this.Cmz != 0))
      {
        m = this.CmE;
        n = this.CmC;
        i1 = this.CmF;
        i2 = this.CmD;
        ad.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", new Object[] { Integer.valueOf(this.CmC), Integer.valueOf(this.CmD), Integer.valueOf(this.CmE), Integer.valueOf(this.CmE) });
        ad.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", new Object[] { Integer.valueOf(this.CmA), Integer.valueOf(this.CmB), Boolean.valueOf(this.CmG), Integer.valueOf(this.CmH) });
        i = (this.CmE + this.CmC) / 2;
        j = (this.CmF + this.CmD) / 2;
        if ((this.CmH != 90) && (this.CmH != 270)) {
          break label552;
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      float f2;
      if ((this.CmH == 90) || (this.CmH == 270)) {
        f2 = this.sP / this.CmA;
      }
      for (float f1 = this.Cmz / this.CmB;; f1 = this.sP / this.CmB)
      {
        f1 = Math.max(f2, f1);
        f2 = (int)((m - n) * f1);
        float f3 = (int)((i1 - i2) * f1);
        j = (int)(j * f1);
        i = (int)(i * f1);
        this.CmC = cZ((int)(j - f2 / 2.0F), this.Cmz);
        this.CmD = cZ((int)(i - f3 / 2.0F), this.sP);
        this.CmE = cZ((int)(j + f2 / 2.0F), this.Cmz);
        this.CmF = cZ((int)(i + f3 / 2.0F), this.sP);
        this.mGJ = new RectF(this.CmC, this.CmD, this.CmE, this.CmF);
        ad.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", new Object[] { Float.valueOf(this.mGJ.left), Float.valueOf(this.mGJ.top), Float.valueOf(this.mGJ.right), Float.valueOf(this.mGJ.bottom) });
        AppMethodBeat.o(115581);
        return;
        f2 = this.Cmz / this.CmA;
      }
      label552:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.CmG = paramBoolean;
  }
  
  public final void setRotateAngle(int paramInt)
  {
    this.CmH = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.e
 * JD-Core Version:    0.7.0.1
 */