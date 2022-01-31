package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;

final class ScanTranslationCaptureUI$5
  implements View.OnTouchListener
{
  private Matrix aqv = new Matrix();
  private int mode = 0;
  private float nLG;
  private float nLH = 400.0F;
  private PointF nNo = new PointF();
  
  ScanTranslationCaptureUI$5(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((ScanTranslationCaptureUI.i(this.nNm) != 2) && (ScanTranslationCaptureUI.i(this.nNm) != 3)) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    y.d("MicroMsg.ScanTranslationCaptureUI", "pointIndex:%d", new Object[] { Integer.valueOf(j) });
    switch (i)
    {
    }
    float f1;
    do
    {
      for (;;)
      {
        return true;
        y.d("MicroMsg.ScanTranslationCaptureUI", "first down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
        this.nNo = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
        this.mode = 1;
        this.aqv.set(ScanTranslationCaptureUI.a(this.nNm).getImageMatrix());
        continue;
        y.d("MicroMsg.ScanTranslationCaptureUI", "down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX(j)), Float.valueOf(paramMotionEvent.getY(j)) });
        if (paramMotionEvent.getPointerCount() == 2)
        {
          this.nLG = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
          this.mode = 2;
          continue;
          y.d("MicroMsg.ScanTranslationCaptureUI", "last up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
          if (paramMotionEvent.getPointerCount() == 2) {
            this.nLG = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
          }
          this.mode = 0;
          continue;
          y.d("MicroMsg.ScanTranslationCaptureUI", "up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramMotionEvent.getX(j)), Float.valueOf(paramMotionEvent.getY(j)) });
          if (paramMotionEvent.getPointerCount() == 2) {
            this.nLG = ((float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D)));
          }
          this.mode = 0;
          continue;
          if (this.mode != 2) {
            break;
          }
          y.d("MicroMsg.ScanTranslationCaptureUI", "move,pointer:0,x:%f,y:%f", new Object[] { Float.valueOf(paramMotionEvent.getX(0)), Float.valueOf(paramMotionEvent.getY(0)) });
          y.d("MicroMsg.ScanTranslationCaptureUI", "move,pointer:1,x:%f,y:%f", new Object[] { Float.valueOf(paramMotionEvent.getX(1)), Float.valueOf(paramMotionEvent.getY(1)) });
          f5 = (float)(Math.pow(paramMotionEvent.getX(0) - paramMotionEvent.getX(1), 2.0D) + Math.pow(paramMotionEvent.getY(0) - paramMotionEvent.getY(1), 2.0D));
          y.d("MicroMsg.ScanTranslationCaptureUI", "distance:%f,lastDistance:%f,min move:%f, curScale %f", new Object[] { Float.valueOf(f5), Float.valueOf(this.nLG), Float.valueOf(this.nLH), Float.valueOf(ScanTranslationCaptureUI.u(this.nNm)) });
          if (Math.abs(f5 - this.nLG) > this.nLH) {
            if (f5 - this.nLG > 0.0F)
            {
              if (ScanTranslationCaptureUI.u(this.nNm) < 3.0F)
              {
                this.aqv.postScale(1.03F, 1.03F, ScanTranslationCaptureUI.a(this.nNm).getWidth() / 2, ScanTranslationCaptureUI.a(this.nNm).getHeight() / 2);
                ScanTranslationCaptureUI.a(this.nNm, ScanTranslationCaptureUI.u(this.nNm) * 1.03F);
                paramView = this.nNm;
                if (ScanTranslationCaptureUI.u(this.nNm) <= 3.0F) {}
                for (f1 = ScanTranslationCaptureUI.u(this.nNm);; f1 = 3.0F)
                {
                  ScanTranslationCaptureUI.a(paramView, f1);
                  ScanTranslationCaptureUI.a(this.nNm).setImageMatrix(this.aqv);
                  this.nLG = f5;
                  break;
                }
              }
            }
            else
            {
              paramView = new float[9];
              this.aqv.getValues(paramView);
              f6 = paramView[2];
              f7 = paramView[5];
              float f8 = (ScanTranslationCaptureUI.u(this.nNm) - 1.0F) * ScanTranslationCaptureUI.a(this.nNm).getWidth();
              f2 = (ScanTranslationCaptureUI.u(this.nNm) - 1.0F) * ScanTranslationCaptureUI.a(this.nNm).getHeight();
              y.d("MicroMsg.ScanTranslationCaptureUI", "maxTransX %f, maxTransY %f, matrixTransX %f, matrixTransY %f", new Object[] { Float.valueOf(f8), Float.valueOf(f2), Float.valueOf(f6), Float.valueOf(f7) });
              ScanTranslationCaptureUI.a(this.nNm, ScanTranslationCaptureUI.u(this.nNm) * 0.97F);
              if (ScanTranslationCaptureUI.u(this.nNm) > 1.0F)
              {
                f3 = ScanTranslationCaptureUI.a(this.nNm).getWidth() / 2;
                f4 = ScanTranslationCaptureUI.a(this.nNm).getHeight() / 2;
                if ((f6 >= 0.0F) && (f7 >= 0.0F))
                {
                  f1 = 0.0F;
                  f2 = 0.0F;
                }
                for (;;)
                {
                  this.aqv.postScale(0.97F, 0.97F, f1, f2);
                  ScanTranslationCaptureUI.a(this.nNm).setImageMatrix(this.aqv);
                  this.nLG = f5;
                  break;
                  if (f6 >= 0.0F)
                  {
                    f1 = 0.0F;
                    if (f7 <= -f2) {
                      f2 = ScanTranslationCaptureUI.a(this.nNm).getHeight();
                    } else {
                      f2 = ScanTranslationCaptureUI.a(this.nNm).getHeight() / 2;
                    }
                  }
                  else if (f7 >= 0.0F)
                  {
                    f2 = 0.0F;
                    if (f6 <= -f8) {
                      f1 = ScanTranslationCaptureUI.a(this.nNm).getWidth();
                    } else {
                      f1 = ScanTranslationCaptureUI.a(this.nNm).getWidth() / 2;
                    }
                  }
                  else
                  {
                    f1 = f3;
                    f2 = f4;
                    if (f6 <= -f8)
                    {
                      f1 = f3;
                      f2 = f4;
                      if (f7 <= -f7)
                      {
                        f1 = ScanTranslationCaptureUI.a(this.nNm).getWidth();
                        f2 = ScanTranslationCaptureUI.a(this.nNm).getHeight();
                      }
                    }
                  }
                }
              }
              ScanTranslationCaptureUI.a(this.nNm, 1.0F);
              if (ScanTranslationCaptureUI.i(this.nNm) == 2) {
                ScanTranslationCaptureUI.a(this.nNm, ScanTranslationCaptureUI.j(this.nNm), ScanTranslationCaptureUI.k(this.nNm));
              } else if (ScanTranslationCaptureUI.i(this.nNm) == 3) {
                ScanTranslationCaptureUI.a(this.nNm, ScanTranslationCaptureUI.n(this.nNm), ScanTranslationCaptureUI.k(this.nNm));
              }
            }
          }
        }
      }
    } while (this.mode != 1);
    y.d("MicroMsg.ScanTranslationCaptureUI", "move x:%f,y:%f, downX:%f, downY:%f", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(this.nNo.x), Float.valueOf(this.nNo.y) });
    float f6 = (ScanTranslationCaptureUI.u(this.nNm) - 1.0F) * ScanTranslationCaptureUI.a(this.nNm).getWidth();
    float f4 = (ScanTranslationCaptureUI.u(this.nNm) - 1.0F) * ScanTranslationCaptureUI.a(this.nNm).getHeight();
    paramView = new float[9];
    this.aqv.getValues(paramView);
    float f7 = paramView[2];
    float f5 = paramView[5];
    float f2 = paramMotionEvent.getX() - this.nNo.x;
    float f3 = paramMotionEvent.getY() - this.nNo.y;
    y.d("MicroMsg.ScanTranslationCaptureUI", "matrixTransX %f, matrixTransY %f, maxTransX %f, maxTransY %f, transX %f, transY %f", new Object[] { Float.valueOf(f7), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f4), Float.valueOf(f2), Float.valueOf(f3) });
    if (f2 > 0.0F)
    {
      f1 = f2;
      if (f2 + f7 > 0.0F) {
        f1 = -f7;
      }
      label1527:
      if (f3 <= 0.0F) {
        break label1663;
      }
      f2 = f3;
      if (f3 + f5 > 0.0F) {
        f2 = -f5;
      }
    }
    for (;;)
    {
      y.d("MicroMsg.ScanTranslationCaptureUI", "transX %f,transY %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
      this.aqv.postTranslate(f1, f2);
      this.nNo = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
      ScanTranslationCaptureUI.a(this.nNm).setImageMatrix(this.aqv);
      break;
      f1 = f2;
      if (f2 >= 0.0F) {
        break label1527;
      }
      f1 = f2;
      if (Math.abs(f2 + f7) <= f6) {
        break label1527;
      }
      f1 = -(f6 + f7);
      break label1527;
      label1663:
      f2 = f3;
      if (f3 < 0.0F)
      {
        f2 = f3;
        if (Math.abs(f3 + f5) > f4) {
          f2 = -(f4 + f5);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.5
 * JD-Core Version:    0.7.0.1
 */