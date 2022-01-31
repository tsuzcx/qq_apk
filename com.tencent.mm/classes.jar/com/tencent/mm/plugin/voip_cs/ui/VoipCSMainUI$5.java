package com.tencent.mm.plugin.voip_cs.ui;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class VoipCSMainUI$5
  extends PhoneStateListener
{
  VoipCSMainUI$5(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(135393);
    ab.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
    if (paramInt == 2)
    {
      ab.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
      c.cQo().tKi = 4;
      this.tLK.Ic(7);
    }
    AppMethodBeat.o(135393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.5
 * JD-Core Version:    0.7.0.1
 */