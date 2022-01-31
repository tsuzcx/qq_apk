package com.tencent.mm.plugin.sight.encode.ui;

import android.media.MediaPlayer;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class SightVideoTextureView$3
  implements Runnable
{
  SightVideoTextureView$3(SightVideoTextureView paramSightVideoTextureView) {}
  
  public final void run()
  {
    AppMethodBeat.i(25122);
    try
    {
      this.qXi.cnv();
      SightVideoTextureView.e(this.qXi).stop();
      SightVideoTextureView.e(this.qXi).release();
      if ((SightVideoTextureView.f(this.qXi) != null) && (SightVideoTextureView.f(this.qXi).isValid()))
      {
        SightVideoTextureView.f(this.qXi).release();
        SightVideoTextureView.a(this.qXi, null);
      }
      SightVideoTextureView.a(this.qXi, null);
      AppMethodBeat.o(25122);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.SightVideoTextureView", "stop play video error: %s, %s", new Object[] { localException.getMessage(), bo.l(localException) });
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(25123);
    String str = super.toString() + "|stopPlayVideo";
    AppMethodBeat.o(25123);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.3
 * JD-Core Version:    0.7.0.1
 */