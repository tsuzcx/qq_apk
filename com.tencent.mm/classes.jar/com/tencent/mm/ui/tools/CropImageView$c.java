package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.TimerTask;

final class CropImageView$c
  extends TimerTask
{
  public final void run()
  {
    y.d("MicroMsg.CropImageView", "in timer task run");
    Message localMessage = new Message();
    if (CropImageView.j(this.vZj)) {
      localMessage.what = 4659;
    }
    for (;;)
    {
      CropImageView.l(this.vZj).sendMessage(localMessage);
      return;
      if (CropImageView.k(this.vZj)) {
        localMessage.what = 4658;
      } else {
        localMessage.what = 4660;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.c
 * JD-Core Version:    0.7.0.1
 */