package com.tencent.mm.plugin.voip_cs.ui;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.plugin.voip_cs.b.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class VoipCSMainUI$2
  implements f.a
{
  VoipCSMainUI$2(VoipCSMainUI paramVoipCSMainUI) {}
  
  public final void ew(int paramInt)
  {
    y.d("MicroMsg.voipcs.VoipCSMainUI", "onBluetoothHeadsetStateChange status: %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      f.yi().yk();
      return;
    case 4: 
      f.yi().yl();
      VoipCSMainUI.c(this.qeX).kj(true);
      return;
    case 1: 
      VoipCSMainUI.c(this.qeX).kj(false);
      return;
    }
    f.yi().yl();
    VoipCSMainUI.c(this.qeX).kj(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI.2
 * JD-Core Version:    0.7.0.1
 */