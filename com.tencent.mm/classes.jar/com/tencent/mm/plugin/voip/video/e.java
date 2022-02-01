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
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends View
{
  public int CEd;
  public int CEe;
  public int CEf;
  private int CEg;
  private int CEh;
  private int CEi;
  private int CEj;
  private boolean CEk;
  private int CEl;
  private RectF mLN;
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
    if (this.mLN != null)
    {
      paramCanvas.save();
      paramCanvas.rotate(0.0F);
      paramCanvas.drawRect(this.mLN, this.mPaint);
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
      this.CEg = paramArrayOfInt[0];
      this.CEh = paramArrayOfInt[1];
      this.CEi = paramArrayOfInt[2];
      this.CEj = paramArrayOfInt[3];
      if ((this.CEe != 0) && (this.CEf != 0) && (this.sP != 0) && (this.CEd != 0))
      {
        m = this.CEi;
        n = this.CEg;
        i1 = this.CEj;
        i2 = this.CEh;
        ae.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", new Object[] { Integer.valueOf(this.CEg), Integer.valueOf(this.CEh), Integer.valueOf(this.CEi), Integer.valueOf(this.CEi) });
        ae.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", new Object[] { Integer.valueOf(this.CEe), Integer.valueOf(this.CEf), Boolean.valueOf(this.CEk), Integer.valueOf(this.CEl) });
        i = (this.CEi + this.CEg) / 2;
        j = (this.CEj + this.CEh) / 2;
        if ((this.CEl != 90) && (this.CEl != 270)) {
          break label552;
        }
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      float f2;
      if ((this.CEl == 90) || (this.CEl == 270)) {
        f2 = this.sP / this.CEe;
      }
      for (float f1 = this.CEd / this.CEf;; f1 = this.sP / this.CEf)
      {
        f1 = Math.max(f2, f1);
        f2 = (int)((m - n) * f1);
        float f3 = (int)((i1 - i2) * f1);
        j = (int)(j * f1);
        i = (int)(i * f1);
        this.CEg = cZ((int)(j - f2 / 2.0F), this.CEd);
        this.CEh = cZ((int)(i - f3 / 2.0F), this.sP);
        this.CEi = cZ((int)(j + f2 / 2.0F), this.CEd);
        this.CEj = cZ((int)(i + f3 / 2.0F), this.sP);
        this.mLN = new RectF(this.CEg, this.CEh, this.CEi, this.CEj);
        ae.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", new Object[] { Float.valueOf(this.mLN.left), Float.valueOf(this.mLN.top), Float.valueOf(this.mLN.right), Float.valueOf(this.mLN.bottom) });
        AppMethodBeat.o(115581);
        return;
        f2 = this.CEd / this.CEe;
      }
      label552:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.CEk = paramBoolean;
  }
  
  public final void setRotateAngle(int paramInt)
  {
    this.CEl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.e
 * JD-Core Version:    0.7.0.1
 */