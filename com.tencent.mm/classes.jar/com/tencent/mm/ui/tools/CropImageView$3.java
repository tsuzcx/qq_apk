package com.tencent.mm.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.f;
import java.util.Timer;

final class CropImageView$3
  implements View.OnTouchListener
{
  CropImageView$3(CropImageView paramCropImageView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107603);
    if (!CropImageView.u(this.Arw))
    {
      AppMethodBeat.o(107603);
      return false;
    }
    if (CropImageView.i(this.Arw) == null)
    {
      AppMethodBeat.o(107603);
      return false;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    ab.d("MicroMsg.CropImageView", "on touch : event type=" + i + ", isDownOnImg=" + CropImageView.v(this.Arw));
    if ((!CropImageView.v(this.Arw)) && (i != 0))
    {
      AppMethodBeat.o(107603);
      return false;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(107603);
      return false;
      ab.d("MicroMsg.CropImageView", "action_mult_down");
      CropImageView.b(this.Arw, true);
      this.Arw.rGE = f.S(paramMotionEvent);
      if (this.Arw.rGE > 5.0F)
      {
        this.Arw.Arf = true;
        f.a(CropImageView.h(this.Arw), paramMotionEvent);
        AppMethodBeat.o(107603);
        return true;
        ab.d("MicroMsg.CropImageView", "action_mult_up");
        this.Arw.Arf = false;
        CropImageView.b(this.Arw, true);
        AppMethodBeat.o(107603);
        return true;
        ab.d("MicroMsg.CropImageView", "action_down");
        CropImageView.a(this.Arw, paramMotionEvent.getRawX());
        CropImageView.b(this.Arw, paramMotionEvent.getRawY());
        ab.d("MicroMsg.CropImageView", "lastX=" + CropImageView.w(this.Arw) + ",lastY=" + CropImageView.x(this.Arw));
        CropImageView.c(this.Arw, CropImageView.w(this.Arw));
        CropImageView.d(this.Arw, CropImageView.x(this.Arw));
        paramView = this.Arw.getImageMatrix();
        paramMotionEvent = new RectF();
        paramMotionEvent.set(0.0F, 0.0F, CropImageView.i(this.Arw).getWidth(), CropImageView.i(this.Arw).getHeight());
        paramView.mapRect(paramMotionEvent);
        CropImageView.a(this.Arw, paramMotionEvent.contains(CropImageView.w(this.Arw), CropImageView.x(this.Arw)));
        CropImageView.a(this.Arw, System.currentTimeMillis());
        continue;
        ab.d("MicroMsg.CropImageView", "action_move");
        float f1;
        if (this.Arw.Arf)
        {
          ab.d("MicroMsg.CropImageView", "is valid mult down");
          this.Arw.rGF = f.S(paramMotionEvent);
          f1 = this.Arw.rGF - this.Arw.rGE;
          if ((this.Arw.rGF > 5.0F) && (Math.abs(f1) > 5.0F))
          {
            f.a(CropImageView.h(this.Arw), paramMotionEvent);
            ab.d("MicroMsg.CropImageView", "mX=" + CropImageView.h(this.Arw).x + ",mY=" + CropImageView.h(this.Arw).y);
            if (f1 <= 0.0F) {
              break label731;
            }
            ab.d("MicroMsg.CropImageView", "zoom in");
            this.Arw.zoomIn();
          }
        }
        for (;;)
        {
          this.Arw.rGE = this.Arw.rGF;
          if (!CropImageView.y(this.Arw))
          {
            f1 = paramMotionEvent.getRawX() - CropImageView.w(this.Arw);
            float f2 = paramMotionEvent.getRawY() - CropImageView.x(this.Arw);
            if ((Math.abs(f1) > 5.0F) || (Math.abs(f2) > 5.0F)) {
              this.Arw.getImageMatrix().postTranslate(f1, f2);
            }
            this.Arw.invalidate();
          }
          CropImageView.b(this.Arw, false);
          CropImageView.a(this.Arw, paramMotionEvent.getRawX());
          CropImageView.b(this.Arw, paramMotionEvent.getRawY());
          break;
          label731:
          ab.d("MicroMsg.CropImageView", "zoom out");
          this.Arw.zoomOut();
        }
        ab.d("MicroMsg.CropImageView", "action_up");
        if (CropImageView.z(this.Arw))
        {
          CropImageView.c(this.Arw, false);
          if (CropImageView.A(this.Arw))
          {
            CropImageView.d(this.Arw, false);
            this.Arw.zoomOut();
            this.Arw.zoomOut();
            this.Arw.zoomOut();
            this.Arw.zoomOut();
            this.Arw.zoomOut();
          }
          else
          {
            CropImageView.d(this.Arw, true);
            this.Arw.zoomIn();
            this.Arw.zoomIn();
            this.Arw.zoomIn();
            this.Arw.zoomIn();
            this.Arw.zoomIn();
          }
        }
        else
        {
          CropImageView.c(this.Arw, true);
          if (CropImageView.B(this.Arw) != null) {
            CropImageView.B(this.Arw).cancel();
          }
          CropImageView.a(this.Arw, new Timer());
          paramView = new CropImageView.3.1(this, paramMotionEvent);
          CropImageView.B(this.Arw).schedule(paramView, 200L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.3
 * JD-Core Version:    0.7.0.1
 */