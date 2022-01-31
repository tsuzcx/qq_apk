package com.tencent.mm.plugin.voip_cs.ui;

import android.telephony.PhoneStateListener;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class VoipCSMainUI$5
  extends PhoneStateListener
{
  VoipCSMainUI$5(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    y.d("MicroMsg.voipcs.VoipCSMainUI", "now phone state change!");
    if (paramInt == 2)
    {
      y.i("MicroMsg.voipcs.VoipCSMainUI", " phone is talking ! exist voipcs !");
      c.bSQ().qdv = 4;
      this.qeX.AB(7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.5
 * JD-Core Version:    0.7.0.1
 */