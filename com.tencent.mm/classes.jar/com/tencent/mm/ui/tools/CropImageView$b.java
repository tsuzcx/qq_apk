package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.TimerTask;

final class CropImageView$b
  extends TimerTask
{
  public final void run()
  {
    Message localMessage = new Message();
    if ((CropImageView.p(this.vZj)) || (CropImageView.q(this.vZj)) || (CropImageView.r(this.vZj)) || (CropImageView.s(this.vZj))) {}
    for (localMessage.what = 4654;; localMessage.what = 4653)
    {
      CropImageView.t(this.vZj).sendMessage(localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.b
 * JD-Core Version:    0.7.0.1
 */