package com.tencent.mm.ui.chatting;

import android.media.ToneGenerator;
import com.tencent.mm.sdk.platformtools.y;

final class q$7
  implements Runnable
{
  q$7(q paramq) {}
  
  public final void run()
  {
    if (q.j(this.vjS) != null)
    {
      q.j(this.vjS).stopTone();
      y.i("MicroMsg.ChattingFooterEventImpl", "stopTone");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.7
 * JD-Core Version:    0.7.0.1
 */