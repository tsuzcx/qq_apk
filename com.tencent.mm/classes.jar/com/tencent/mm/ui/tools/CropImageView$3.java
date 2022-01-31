package com.tencent.mm.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.f;
import java.util.Timer;

final class CropImageView$3
  implements View.OnTouchListener
{
  CropImageView$3(CropImageView paramCropImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!CropImageView.u(this.vZj)) {}
    do
    {
      int i;
      do
      {
        do
        {
          return false;
        } while (CropImageView.i(this.vZj) == null);
        i = paramMotionEvent.getAction() & 0xFF;
        y.d("MicroMsg.CropImageView", "on touch : event type=" + i + ", isDownOnImg=" + CropImageView.v(this.vZj));
      } while ((!CropImageView.v(this.vZj)) && (i != 0));
      switch (i)
      {
      case 3: 
      case 4: 
      default: 
        return false;
      case 0: 
        y.d("MicroMsg.CropImageView", "action_down");
        CropImageView.a(this.vZj, paramMotionEvent.getRawX());
        CropImageView.b(this.vZj, paramMotionEvent.getRawY());
        y.d("MicroMsg.CropImageView", "lastX=" + CropImageView.w(this.vZj) + ",lastY=" + CropImageView.x(this.vZj));
        CropImageView.c(this.vZj, CropImageView.w(this.vZj));
        CropImageView.d(this.vZj, CropImageView.x(this.vZj));
        paramView = this.vZj.getImageMatrix();
        paramMotionEvent = new RectF();
        paramMotionEvent.set(0.0F, 0.0F, CropImageView.i(this.vZj).getWidth(), CropImageView.i(this.vZj).getHeight());
        paramView.mapRect(paramMotionEvent);
        CropImageView.a(this.vZj, paramMotionEvent.contains(CropImageView.w(this.vZj), CropImageView.x(this.vZj)));
        CropImageView.a(this.vZj, System.currentTimeMillis());
        return false;
      case 5: 
        y.d("MicroMsg.CropImageView", "action_mult_down");
        CropImageView.b(this.vZj, true);
        this.vZj.oOR = f.I(paramMotionEvent);
      }
    } while (this.vZj.oOR <= 5.0F);
    this.vZj.vYS = true;
    f.a(CropImageView.h(this.vZj), paramMotionEvent);
    return true;
    y.d("MicroMsg.CropImageView", "action_mult_up");
    this.vZj.vYS = false;
    CropImageView.b(this.vZj, true);
    return true;
    y.d("MicroMsg.CropImageView", "action_move");
    float f1;
    if (this.vZj.vYS)
    {
      y.d("MicroMsg.CropImageView", "is valid mult down");
      this.vZj.oOS = f.I(paramMotionEvent);
      f1 = this.vZj.oOS - this.vZj.oOR;
      if ((this.vZj.oOS > 5.0F) && (Math.abs(f1) > 5.0F))
      {
        f.a(CropImageView.h(this.vZj), paramMotionEvent);
        y.d("MicroMsg.CropImageView", "mX=" + CropImageView.h(this.vZj).x + ",mY=" + CropImageView.h(this.vZj).y);
        if (f1 <= 0.0F) {
          break label690;
        }
        y.d("MicroMsg.CropImageView", "zoom in");
        this.vZj.zoomIn();
      }
    }
    for (;;)
    {
      this.vZj.oOR = this.vZj.oOS;
      if (!CropImageView.y(this.vZj))
      {
        f1 = paramMotionEvent.getRawX() - CropImageView.w(this.vZj);
        float f2 = paramMotionEvent.getRawY() - CropImageView.x(this.vZj);
        if ((Math.abs(f1) > 5.0F) || (Math.abs(f2) > 5.0F)) {
          this.vZj.getImageMatrix().postTranslate(f1, f2);
        }
        this.vZj.invalidate();
      }
      CropImageView.b(this.vZj, false);
      CropImageView.a(this.vZj, paramMotionEvent.getRawX());
      CropImageView.b(this.vZj, paramMotionEvent.getRawY());
      return false;
      label690:
      y.d("MicroMsg.CropImageView", "zoom out");
      this.vZj.zoomOut();
    }
    y.d("MicroMsg.CropImageView", "action_up");
    if (CropImageView.z(this.vZj))
    {
      CropImageView.c(this.vZj, false);
      if (CropImageView.A(this.vZj))
      {
        CropImageView.d(this.vZj, false);
        this.vZj.zoomOut();
        this.vZj.zoomOut();
        this.vZj.zoomOut();
        this.vZj.zoomOut();
        this.vZj.zoomOut();
        return false;
      }
      CropImageView.d(this.vZj, true);
      this.vZj.zoomIn();
      this.vZj.zoomIn();
      this.vZj.zoomIn();
      this.vZj.zoomIn();
      this.vZj.zoomIn();
      return false;
    }
    CropImageView.c(this.vZj, true);
    if (CropImageView.B(this.vZj) != null) {
      CropImageView.B(this.vZj).cancel();
    }
    CropImageView.a(this.vZj, new Timer());
    paramView = new CropImageView.3.1(this, paramMotionEvent);
    CropImageView.B(this.vZj).schedule(paramView, 200L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.3
 * JD-Core Version:    0.7.0.1
 */