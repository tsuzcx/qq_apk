package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class VoipVideoFragment$a
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(4898);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
    Bitmap localBitmap = VoipVideoFragment.D(this.tEo);
    this.tEo.iMP.post(new VoipVideoFragment.a.1(this, localBitmap));
    AppMethodBeat.o(4898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.a
 * JD-Core Version:    0.7.0.1
 */