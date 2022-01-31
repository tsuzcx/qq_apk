package com.tencent.mm.ui.tools;

import android.os.Message;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.TimerTask;

final class CropImageView$3$1
  extends TimerTask
{
  CropImageView$3$1(CropImageView.3 param3, MotionEvent paramMotionEvent) {}
  
  public final void run()
  {
    if (CropImageView.z(this.vZl.vZj))
    {
      Message localMessage = new Message();
      localMessage.what = 4661;
      localMessage.obj = this.vZk;
      CropImageView.l(this.vZl.vZj).sendMessage(localMessage);
      CropImageView.c(this.vZl.vZj, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.3.1
 * JD-Core Version:    0.7.0.1
 */