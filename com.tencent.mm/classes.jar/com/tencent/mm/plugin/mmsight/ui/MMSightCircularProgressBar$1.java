package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class MMSightCircularProgressBar$1
  implements c.a
{
  MMSightCircularProgressBar$1(MMSightCircularProgressBar paramMMSightCircularProgressBar) {}
  
  public final void aQ(float paramFloat)
  {
    AppMethodBeat.i(55080);
    MMSightCircularProgressBar.a(this.oNE, paramFloat);
    this.oNE.invalidate();
    AppMethodBeat.o(55080);
  }
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(55081);
    ab.i("MicroMsg.MMSightCircularProgressBar", "onAnimationEnd");
    al.d(new MMSightCircularProgressBar.1.1(this));
    AppMethodBeat.o(55081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.1
 * JD-Core Version:    0.7.0.1
 */