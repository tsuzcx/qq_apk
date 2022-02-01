package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends View
{
  public int NYn;
  public int NYo;
  public int NYp;
  private int NYq;
  private int NYr;
  private int NYs;
  private int NYt;
  private boolean NYu;
  private int NYv;
  private Matrix aqj;
  public int bZ;
  private Paint mPaint;
  private RectF raG;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(115580);
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(-65536);
    this.mPaint.setStrokeWidth(a.fromDPToPix(getContext(), 3));
    this.aqj = new Matrix();
    AppMethodBeat.o(115580);
  }
  
  private static int kT(int paramInt1, int paramInt2)
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
    if (this.raG != null)
    {
      paramCanvas.save();
      paramCanvas.rotate(0.0F);
      paramCanvas.drawRect(this.raG, this.mPaint);
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
      this.NYq = paramArrayOfInt[0];
      this.NYr = paramArrayOfInt[1];
      this.NYs = paramArrayOfInt[2];
      this.NYt = paramArrayOfInt[3];
      if ((this.NYo != 0) && (this.NYp != 0) && (this.bZ != 0) && (this.NYn != 0))
      {
        m = this.NYs;
        n = this.NYq;
        i1 = this.NYt;
        i2 = this.NYr;
        Log.d("MicroMsg.FaceRectView", "mLeftTopX:%d, mLeftTopY:%d, mRightBottomX:%d, mRightBottomY:%d", new Object[] { Integer.valueOf(this.NYq), Integer.valueOf(this.NYr), Integer.valueOf(this.NYs), Integer.valueOf(this.NYs) });
        Log.d("MicroMsg.FaceRectView", "mPicWidth:%d, mPicHeight:%d, mirror:%b, angle:%d", new Object[] { Integer.valueOf(this.NYo), Integer.valueOf(this.NYp), Boolean.valueOf(this.NYu), Integer.valueOf(this.NYv) });
        i = (this.NYs + this.NYq) / 2;
        j = (this.NYt + this.NYr) / 2;
        if ((this.NYv != 90) && (this.NYv != 270)) {
          break label552;
        }
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.FaceRectView", "centerX:%d, centerY:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      float f2;
      if ((this.NYv == 90) || (this.NYv == 270)) {
        f2 = this.bZ / this.NYo;
      }
      for (float f1 = this.NYn / this.NYp;; f1 = this.bZ / this.NYp)
      {
        f1 = Math.max(f2, f1);
        f2 = (int)((m - n) * f1);
        float f3 = (int)((i1 - i2) * f1);
        j = (int)(j * f1);
        i = (int)(i * f1);
        this.NYq = kT((int)(j - f2 / 2.0F), this.NYn);
        this.NYr = kT((int)(i - f3 / 2.0F), this.bZ);
        this.NYs = kT((int)(j + f2 / 2.0F), this.NYn);
        this.NYt = kT((int)(i + f3 / 2.0F), this.bZ);
        this.raG = new RectF(this.NYq, this.NYr, this.NYs, this.NYt);
        Log.d("MicroMsg.FaceRectView", "after translate, mLeftTopX:%.2f, mLeftTopY:%.2f, mRightBottomX:%.2f, mRightBottomY:%.2f", new Object[] { Float.valueOf(this.raG.left), Float.valueOf(this.raG.top), Float.valueOf(this.raG.right), Float.valueOf(this.raG.bottom) });
        AppMethodBeat.o(115581);
        return;
        f2 = this.NYn / this.NYo;
      }
      label552:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.NYu = paramBoolean;
  }
  
  public final void setRotateAngle(int paramInt)
  {
    this.NYv = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.d
 * JD-Core Version:    0.7.0.1
 */