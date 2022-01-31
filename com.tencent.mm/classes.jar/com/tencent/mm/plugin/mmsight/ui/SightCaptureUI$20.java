package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class SightCaptureUI$20
  implements e.a
{
  SightCaptureUI$20(SightCaptureUI paramSightCaptureUI) {}
  
  public final void Es()
  {
    AppMethodBeat.i(55217);
    SightCaptureUI.T(this.oQf).e(0.0D, true);
    AppMethodBeat.o(55217);
  }
  
  public final int dP(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void dQ(int paramInt1, int paramInt2) {}
  
  public final void mG()
  {
    AppMethodBeat.i(55216);
    if (SightCaptureUI.T(this.oQf) != null)
    {
      SightCaptureUI.T(this.oQf).start();
      SightCaptureUI.T(this.oQf).setLoop(true);
    }
    al.ae(SightCaptureUI.N(this.oQf));
    SightCaptureUI.T(this.oQf).setOneTimeVideoTextureUpdateCallback(new SightCaptureUI.20.1(this));
    AppMethodBeat.o(55216);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55215);
    ab.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[] { Integer.valueOf(this.oQf.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(55215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.20
 * JD-Core Version:    0.7.0.1
 */