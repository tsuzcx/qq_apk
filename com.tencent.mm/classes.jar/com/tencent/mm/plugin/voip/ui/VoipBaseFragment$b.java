package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;

public final class VoipBaseFragment$b
  implements Runnable
{
  public VoipBaseFragment$b(VoipBaseFragment paramVoipBaseFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(4847);
    ab.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
    Bitmap localBitmap = d.Na(2130840778);
    ab.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
    this.tCD.iMP.post(new VoipBaseFragment.b.1(this, localBitmap));
    AppMethodBeat.o(4847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.b
 * JD-Core Version:    0.7.0.1
 */