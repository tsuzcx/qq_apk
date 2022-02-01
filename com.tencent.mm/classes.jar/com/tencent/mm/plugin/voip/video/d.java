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
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends View
{
  public int HhA;
  private int HhB;
  private int HhC;
  private int HhD;
  private int HhE;
  private boolean HhF;
  private int HhG;
  public int Hhy;
  public int Hhz;
  private Matrix mMatrix;
  private Paint mPaint;
  private RectF nYV;
  public int sT;
  
  public d(Context paramContext)
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
  
  private static int di(int paramInt1, int paramInt2)
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
    if (this.nYV != null)
    {
      paramCanvas.save();
      paramCanvas.rotate(0.0F);
      paramCanvas.drawRect(this.nYV, this.mPaint);
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
      this.HhB = paramArrayOfInt[0];
      this.HhC = paramArrayOfInt[1];
      this.HhD = paramArrayOfInt[2];
      this.HhE = paramArrayOfInt[3];
      if ((this.Hhz != 0) && (this.HhA != 0) && (this.sT != 0) && (this.Hhy != 0))
      {
        m = this.HhD;
        n = this.HhB;
        i1 = this.HhE;
        i2 = this.HhC;
        Log.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", new Object[] { Integer.valueOf(this.HhB), Integer.valueOf(this.HhC), Integer.valueOf(this.HhD), Integer.valueOf(this.HhD) });
        Log.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", new Object[] { Integer.valueOf(this.Hhz), Integer.valueOf(this.HhA), Boolean.valueOf(this.HhF), Integer.valueOf(this.HhG) });
        i = (this.HhD + this.HhB) / 2;
        j = (this.HhE + this.HhC) / 2;
        if ((this.HhG != 90) && (this.HhG != 270)) {
          break label552;
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      float f2;
      if ((this.HhG == 90) || (this.HhG == 270)) {
        f2 = this.sT / this.Hhz;
      }
      for (float f1 = this.Hhy / this.HhA;; f1 = this.sT / this.HhA)
      {
        f1 = Math.max(f2, f1);
        f2 = (int)((m - n) * f1);
        float f3 = (int)((i1 - i2) * f1);
        j = (int)(j * f1);
        i = (int)(i * f1);
        this.HhB = di((int)(j - f2 / 2.0F), this.Hhy);
        this.HhC = di((int)(i - f3 / 2.0F), this.sT);
        this.HhD = di((int)(j + f2 / 2.0F), this.Hhy);
        this.HhE = di((int)(i + f3 / 2.0F), this.sT);
        this.nYV = new RectF(this.HhB, this.HhC, this.HhD, this.HhE);
        Log.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", new Object[] { Float.valueOf(this.nYV.left), Float.valueOf(this.nYV.top), Float.valueOf(this.nYV.right), Float.valueOf(this.nYV.bottom) });
        AppMethodBeat.o(115581);
        return;
        f2 = this.Hhy / this.Hhz;
      }
      label552:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.HhF = paramBoolean;
  }
  
  public final void setRotateAngle(int paramInt)
  {
    this.HhG = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.d
 * JD-Core Version:    0.7.0.1
 */