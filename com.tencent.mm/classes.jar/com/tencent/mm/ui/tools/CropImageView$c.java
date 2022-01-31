package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.TimerTask;

final class CropImageView$c
  extends TimerTask
{
  public final void run()
  {
    AppMethodBeat.i(107605);
    ab.d("MicroMsg.CropImageView", "in timer task run");
    Message localMessage = new Message();
    if (CropImageView.j(this.Arw)) {
      localMessage.what = 4659;
    }
    for (;;)
    {
      CropImageView.l(this.Arw).sendMessage(localMessage);
      AppMethodBeat.o(107605);
      return;
      if (CropImageView.k(this.Arw)) {
        localMessage.what = 4658;
      } else {
        localMessage.what = 4660;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.c
 * JD-Core Version:    0.7.0.1
 */