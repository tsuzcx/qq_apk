package com.tencent.mm.plugin.voip.video;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Camera.AutoFocusCallback
{
  a$1(a parama) {}
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(5020);
    ab.d("MicroMsg.Voip.CaptureRender", "onAutoFocus, success:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tFR.tFK = true;
    AppMethodBeat.o(5020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.1
 * JD-Core Version:    0.7.0.1
 */