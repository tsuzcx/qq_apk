package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class SightCaptureUITest$16
  implements e.a
{
  SightCaptureUITest$16(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void Es()
  {
    AppMethodBeat.i(150474);
    SightCaptureUITest.I(this.oQq).e(0.0D, true);
    AppMethodBeat.o(150474);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(150473);
    if (SightCaptureUITest.I(this.oQq) != null)
    {
      SightCaptureUITest.I(this.oQq).start();
      SightCaptureUITest.I(this.oQq).setLoop(true);
    }
    al.ae(SightCaptureUITest.D(this.oQq));
    SightCaptureUITest.I(this.oQq).setOneTimeVideoTextureUpdateCallback(new SightCaptureUITest.16.1(this));
    AppMethodBeat.o(150473);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150472);
    ab.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.16
 * JD-Core Version:    0.7.0.1
 */