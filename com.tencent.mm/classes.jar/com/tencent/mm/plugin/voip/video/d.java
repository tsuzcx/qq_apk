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
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends View
{
  public int UMk;
  public int UMl;
  public int UMm;
  private int UMn;
  private int UMo;
  private int UMp;
  private int UMq;
  private boolean UMr;
  private int UMs;
  private Matrix avQ;
  public int bZ;
  private Paint mPaint;
  private RectF ugw;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(115580);
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(-65536);
    this.mPaint.setStrokeWidth(a.fromDPToPix(getContext(), 3));
    this.avQ = new Matrix();
    AppMethodBeat.o(115580);
  }
  
  private static int mF(int paramInt1, int paramInt2)
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
    if (this.ugw != null)
    {
      paramCanvas.save();
      paramCanvas.rotate(0.0F);
      paramCanvas.drawRect(this.ugw, this.mPaint);
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
      this.UMn = paramArrayOfInt[0];
      this.UMo = paramArrayOfInt[1];
      this.UMp = paramArrayOfInt[2];
      this.UMq = paramArrayOfInt[3];
      if ((this.UMl != 0) && (this.UMm != 0) && (this.bZ != 0) && (this.UMk != 0))
      {
        m = this.UMp;
        n = this.UMn;
        i1 = this.UMq;
        i2 = this.UMo;
        Log.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", new Object[] { Integer.valueOf(this.UMn), Integer.valueOf(this.UMo), Integer.valueOf(this.UMp), Integer.valueOf(this.UMp) });
        Log.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", new Object[] { Integer.valueOf(this.UMl), Integer.valueOf(this.UMm), Boolean.valueOf(this.UMr), Integer.valueOf(this.UMs) });
        i = (this.UMp + this.UMn) / 2;
        j = (this.UMq + this.UMo) / 2;
        if ((this.UMs != 90) && (this.UMs != 270)) {
          break label552;
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      float f2;
      if ((this.UMs == 90) || (this.UMs == 270)) {
        f2 = this.bZ / this.UMl;
      }
      for (float f1 = this.UMk / this.UMm;; f1 = this.bZ / this.UMm)
      {
        f1 = Math.max(f2, f1);
        f2 = (int)((m - n) * f1);
        float f3 = (int)((i1 - i2) * f1);
        j = (int)(j * f1);
        i = (int)(i * f1);
        this.UMn = mF((int)(j - f2 / 2.0F), this.UMk);
        this.UMo = mF((int)(i - f3 / 2.0F), this.bZ);
        this.UMp = mF((int)(j + f2 / 2.0F), this.UMk);
        this.UMq = mF((int)(i + f3 / 2.0F), this.bZ);
        this.ugw = new RectF(this.UMn, this.UMo, this.UMp, this.UMq);
        Log.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", new Object[] { Float.valueOf(this.ugw.left), Float.valueOf(this.ugw.top), Float.valueOf(this.ugw.right), Float.valueOf(this.ugw.bottom) });
        AppMethodBeat.o(115581);
        return;
        f2 = this.UMk / this.UMl;
      }
      label552:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.UMr = paramBoolean;
  }
  
  public final void setRotateAngle(int paramInt)
  {
    this.UMs = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.d
 * JD-Core Version:    0.7.0.1
 */