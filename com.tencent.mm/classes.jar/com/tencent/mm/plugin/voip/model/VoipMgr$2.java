package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;

final class VoipMgr$2
  implements Runnable
{
  VoipMgr$2(VoipMgr paramVoipMgr) {}
  
  public final void run()
  {
    AppMethodBeat.i(4458);
    VoipMgr localVoipMgr = this.tyo;
    ab.i("MicroMsg.Voip.VoipMgr", "it is uninit voip report");
    localVoipMgr.tyf.removeCallbacksAndMessages(null);
    if (localVoipMgr.tye != null)
    {
      localVoipMgr.tye.oNc.quit();
      localVoipMgr.tye = null;
    }
    if (!localVoipMgr.tyb)
    {
      if (localVoipMgr.tym == 0) {
        localVoipMgr.Hs(localVoipMgr.tya);
      }
      if (localVoipMgr.tym != 0)
      {
        localVoipMgr.tyb = true;
        if (!localVoipMgr.txk) {
          break label193;
        }
      }
    }
    label193:
    for (int i = 0;; i = 1)
    {
      a.a(i, System.currentTimeMillis(), localVoipMgr.tya, localVoipMgr.tya, 0, 0, VoipMgr.ihF / localVoipMgr.tym);
      VoipMgr.ihF = 0;
      VoipMgr.tyg[0] = 0;
      VoipMgr.tyg[1] = 0;
      localVoipMgr.tym = 0;
      if (localVoipMgr.tyh != null) {
        localVoipMgr.tyh.listen(localVoipMgr.tyd, 0);
      }
      if (localVoipMgr.tyc != null)
      {
        ah.getContext().unregisterReceiver(localVoipMgr.tyc);
        localVoipMgr.tyc = null;
      }
      VoipMgr.r(this.tyo);
      AppMethodBeat.o(4458);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.2
 * JD-Core Version:    0.7.0.1
 */