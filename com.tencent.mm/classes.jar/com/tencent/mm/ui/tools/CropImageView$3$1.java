package com.tencent.mm.ui.tools;

import android.os.Message;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.TimerTask;

final class CropImageView$3$1
  extends TimerTask
{
  CropImageView$3$1(CropImageView.3 param3, MotionEvent paramMotionEvent) {}
  
  public final void run()
  {
    AppMethodBeat.i(107602);
    if (CropImageView.z(this.Ary.Arw))
    {
      Message localMessage = new Message();
      localMessage.what = 4661;
      localMessage.obj = this.Arx;
      CropImageView.l(this.Ary.Arw).sendMessage(localMessage);
      CropImageView.c(this.Ary.Arw, false);
    }
    AppMethodBeat.o(107602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.3.1
 * JD-Core Version:    0.7.0.1
 */