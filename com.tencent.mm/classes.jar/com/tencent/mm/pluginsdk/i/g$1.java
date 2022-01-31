package com.tencent.mm.pluginsdk.i;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g$1
  implements Camera.AutoFocusCallback
{
  g$1(g paramg) {}
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(27483);
    ab.d("MicroMsg.YuvReocrder", "auto focus callback");
    g.a(this.vPn);
    AppMethodBeat.o(27483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.g.1
 * JD-Core Version:    0.7.0.1
 */