package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.TimerTask;

final class CropImageView$b
  extends TimerTask
{
  public final void run()
  {
    AppMethodBeat.i(107604);
    Message localMessage = new Message();
    if ((CropImageView.p(this.Arw)) || (CropImageView.q(this.Arw)) || (CropImageView.r(this.Arw)) || (CropImageView.s(this.Arw))) {}
    for (localMessage.what = 4654;; localMessage.what = 4653)
    {
      CropImageView.t(this.Arw).sendMessage(localMessage);
      AppMethodBeat.o(107604);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.b
 * JD-Core Version:    0.7.0.1
 */