package com.tencent.mm.ui.tools;

import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.f;

final class CropImageView$1
  extends ah
{
  CropImageView$1(CropImageView paramCropImageView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    y.d("MicroMsg.CropImageView", "on handler");
    if (paramMessage.what == 4659) {
      this.vZj.zoomIn();
    }
    do
    {
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if (paramMessage.what == 4658)
        {
          this.vZj.zoomOut();
        }
        else
        {
          if (paramMessage.what != 4660) {
            break;
          }
          if ((CropImageView.a(this.vZj) != null) && (CropImageView.b(this.vZj) != null))
          {
            CropImageView.b(this.vZj).cancel();
            CropImageView.c(this.vZj);
          }
        }
      }
    } while (paramMessage.what != 4661);
    MotionEvent localMotionEvent = (MotionEvent)paramMessage.obj;
    CropImageView.a(this.vZj, System.currentTimeMillis());
    CropImageView.a(this.vZj, false);
    if ((localMotionEvent.getRawX() - CropImageView.d(this.vZj) > 10.0F) || (localMotionEvent.getRawY() - CropImageView.e(this.vZj) > 10.0F) || (localMotionEvent.getRawX() - CropImageView.d(this.vZj) < -10.0F) || (localMotionEvent.getRawY() - CropImageView.e(this.vZj) < -10.0F)) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        long l = System.currentTimeMillis();
        if ((CropImageView.f(this.vZj) != 0L) && (l - CropImageView.f(this.vZj) < 300L) && (l - CropImageView.f(this.vZj) >= 0L) && (CropImageView.g(this.vZj) != null)) {
          CropImageView.g(this.vZj).cIV();
        }
        CropImageView.a(this.vZj, 0L);
      }
      f.a(CropImageView.h(this.vZj), CropImageView.i(this.vZj));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.1
 * JD-Core Version:    0.7.0.1
 */