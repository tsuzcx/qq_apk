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
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends View
{
  public int ANm;
  public int ANn;
  public int ANo;
  private int ANp;
  private int ANq;
  private int ANr;
  private int ANs;
  private boolean ANt;
  private int ANu;
  private Matrix mMatrix;
  private Paint mPaint;
  private RectF mgi;
  public int qU;
  
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
    if (this.mgi != null)
    {
      paramCanvas.save();
      paramCanvas.rotate(0.0F);
      paramCanvas.drawRect(this.mgi, this.mPaint);
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
      this.ANp = paramArrayOfInt[0];
      this.ANq = paramArrayOfInt[1];
      this.ANr = paramArrayOfInt[2];
      this.ANs = paramArrayOfInt[3];
      if ((this.ANn != 0) && (this.ANo != 0) && (this.qU != 0) && (this.ANm != 0))
      {
        m = this.ANr;
        n = this.ANp;
        i1 = this.ANs;
        i2 = this.ANq;
        ac.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", new Object[] { Integer.valueOf(this.ANp), Integer.valueOf(this.ANq), Integer.valueOf(this.ANr), Integer.valueOf(this.ANr) });
        ac.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", new Object[] { Integer.valueOf(this.ANn), Integer.valueOf(this.ANo), Boolean.valueOf(this.ANt), Integer.valueOf(this.ANu) });
        i = (this.ANr + this.ANp) / 2;
        j = (this.ANs + this.ANq) / 2;
        if ((this.ANu != 90) && (this.ANu != 270)) {
          break label552;
        }
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      float f2;
      if ((this.ANu == 90) || (this.ANu == 270)) {
        f2 = this.qU / this.ANn;
      }
      for (float f1 = this.ANm / this.ANo;; f1 = this.qU / this.ANo)
      {
        f1 = Math.max(f2, f1);
        f2 = (int)((m - n) * f1);
        float f3 = (int)((i1 - i2) * f1);
        j = (int)(j * f1);
        i = (int)(i * f1);
        this.ANp = cX((int)(j - f2 / 2.0F), this.ANm);
        this.ANq = cX((int)(i - f3 / 2.0F), this.qU);
        this.ANr = cX((int)(j + f2 / 2.0F), this.ANm);
        this.ANs = cX((int)(i + f3 / 2.0F), this.qU);
        this.mgi = new RectF(this.ANp, this.ANq, this.ANr, this.ANs);
        ac.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", new Object[] { Float.valueOf(this.mgi.left), Float.valueOf(this.mgi.top), Float.valueOf(this.mgi.right), Float.valueOf(this.mgi.bottom) });
        AppMethodBeat.o(115581);
        return;
        f2 = this.ANm / this.ANn;
      }
      label552:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.ANt = paramBoolean;
  }
  
  public final void setRotateAngle(int paramInt)
  {
    this.ANu = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.e
 * JD-Core Version:    0.7.0.1
 */