package com.tencent.mm.plugin.voip.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class VideoActivity$1$1
  implements Runnable
{
  VideoActivity$1$1(VideoActivity.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(4786);
    if ((VideoActivity.a(this.tCr.tCq) != null) && (VideoActivity.a(this.tCr.tCq).get() != null)) {
      ab.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent ret[%b, %b, %b]", new Object[] { Boolean.valueOf(((c)VideoActivity.a(this.tCr.tCq).get()).cMQ()), Boolean.valueOf(((c)VideoActivity.a(this.tCr.tCq).get()).cMP()), Boolean.valueOf(((c)VideoActivity.a(this.tCr.tCq).get()).cMI()) });
    }
    AppMethodBeat.o(4786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.1.1
 * JD-Core Version:    0.7.0.1
 */