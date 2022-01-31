package com.tencent.mm.ui.tools;

import android.os.Message;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.f;

final class CropImageView$1
  extends ak
{
  CropImageView$1(CropImageView paramCropImageView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(107600);
    ab.d("MicroMsg.CropImageView", "on handler");
    if (paramMessage.what == 4659) {
      this.Arw.zoomIn();
    }
    do
    {
      for (;;)
      {
        super.handleMessage(paramMessage);
        AppMethodBeat.o(107600);
        return;
        if (paramMessage.what == 4658)
        {
          this.Arw.zoomOut();
        }
        else
        {
          if (paramMessage.what != 4660) {
            break;
          }
          if ((CropImageView.a(this.Arw) != null) && (CropImageView.b(this.Arw) != null))
          {
            CropImageView.b(this.Arw).cancel();
            CropImageView.c(this.Arw);
          }
        }
      }
    } while (paramMessage.what != 4661);
    MotionEvent localMotionEvent = (MotionEvent)paramMessage.obj;
    CropImageView.a(this.Arw, System.currentTimeMillis());
    CropImageView.a(this.Arw, false);
    if ((localMotionEvent.getRawX() - CropImageView.d(this.Arw) > 10.0F) || (localMotionEvent.getRawY() - CropImageView.e(this.Arw) > 10.0F) || (localMotionEvent.getRawX() - CropImageView.d(this.Arw) < -10.0F) || (localMotionEvent.getRawY() - CropImageView.e(this.Arw) < -10.0F)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        long l = System.currentTimeMillis();
        if ((CropImageView.f(this.Arw) != 0L) && (l - CropImageView.f(this.Arw) < 300L) && (l - CropImageView.f(this.Arw) >= 0L) && (CropImageView.g(this.Arw) != null)) {
          CropImageView.g(this.Arw).dNJ();
        }
        CropImageView.a(this.Arw, 0L);
      }
      f.a(CropImageView.h(this.Arw), CropImageView.i(this.Arw));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.1
 * JD-Core Version:    0.7.0.1
 */