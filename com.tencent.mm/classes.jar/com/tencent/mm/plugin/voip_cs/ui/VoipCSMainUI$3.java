package com.tencent.mm.plugin.voip_cs.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip_cs.b.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class VoipCSMainUI$3
  implements HeadsetPlugReceiver.a
{
  VoipCSMainUI$3(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(135391);
    ab.d("MicroMsg.voipcs.VoipCSMainUI", "onHeadsetState, on:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (VoipCSMainUI.d(this.tLK) == paramBoolean)
    {
      ab.d("MicroMsg.voipcs.VoipCSMainUI", "same status, no changed");
      AppMethodBeat.o(135391);
      return;
    }
    VoipCSMainUI.a(this.tLK, paramBoolean);
    if (paramBoolean)
    {
      VoipCSMainUI.c(this.tLK).mR(false);
      Toast.makeText(ah.getContext(), ah.getContext().getString(2131304753), 0).show();
      AppMethodBeat.o(135391);
      return;
    }
    VoipCSMainUI.c(this.tLK).mR(true);
    Toast.makeText(ah.getContext(), ah.getContext().getString(2131304754), 0).show();
    AppMethodBeat.o(135391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.3
 * JD-Core Version:    0.7.0.1
 */