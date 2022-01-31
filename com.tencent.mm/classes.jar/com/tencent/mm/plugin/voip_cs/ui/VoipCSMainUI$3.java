package com.tencent.mm.plugin.voip_cs.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip_cs.a.e;
import com.tencent.mm.plugin.voip_cs.b.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class VoipCSMainUI$3
  implements HeadsetPlugReceiver.a
{
  VoipCSMainUI$3(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void eH(boolean paramBoolean)
  {
    y.d("MicroMsg.voipcs.VoipCSMainUI", "onHeadsetState, on:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (VoipCSMainUI.d(this.qeX) == paramBoolean)
    {
      y.d("MicroMsg.voipcs.VoipCSMainUI", "same status, no changed");
      return;
    }
    VoipCSMainUI.a(this.qeX, paramBoolean);
    if (paramBoolean)
    {
      VoipCSMainUI.c(this.qeX).kj(false);
      Toast.makeText(ae.getContext(), ae.getContext().getString(a.e.voip_voice_come_from_earpiece), 0).show();
      return;
    }
    VoipCSMainUI.c(this.qeX).kj(true);
    Toast.makeText(ae.getContext(), ae.getContext().getString(a.e.voip_voice_come_from_speaker), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.3
 * JD-Core Version:    0.7.0.1
 */