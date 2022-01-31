package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class VoipMgr$16
  implements HeadsetPlugReceiver.a
{
  VoipMgr$16(VoipMgr paramVoipMgr) {}
  
  public final void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(4477);
    boolean bool = g.KC().KH();
    ab.i("MicroMsg.Voip.VoipMgr", "onHeadsetState, on:%b, bluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    if (((paramBoolean) && (3 == VoipMgr.f(this.tyo))) || ((!paramBoolean) && (3 != VoipMgr.f(this.tyo))))
    {
      ab.i("MicroMsg.Voip.VoipMgr", "same status, no changed");
      AppMethodBeat.o(4477);
      return;
    }
    if (com.tencent.mm.plugin.voip.a.b.HR(VoipMgr.a(this.tyo).mState)) {
      if ((paramBoolean) || (bool))
      {
        VoipMgr.b(this.tyo, false);
        if (paramBoolean) {
          VoipMgr.a(this.tyo, 3);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.voip.b.cLC().jA(paramBoolean);
      VoipMgr.b(this.tyo, VoipMgr.f(this.tyo));
      AppMethodBeat.o(4477);
      return;
      VoipMgr.a(this.tyo, 4);
      continue;
      if (!com.tencent.mm.plugin.voip.b.cLC().tyR.cOm())
      {
        VoipMgr.b(this.tyo, false);
        VoipMgr.a(this.tyo, 2);
      }
      else
      {
        Toast.makeText(VoipMgr.g(this.tyo), VoipMgr.g(this.tyo).getString(2131304754), 0).show();
        VoipMgr.b(this.tyo, true);
        VoipMgr.a(this.tyo, 1);
        continue;
        if ((paramBoolean) || (bool))
        {
          if (1 == VoipMgr.f(this.tyo))
          {
            VoipMgr.b(this.tyo, false);
            VoipMgr.c(this.tyo, true);
          }
          for (;;)
          {
            if (!paramBoolean) {
              break label309;
            }
            VoipMgr.a(this.tyo, 3);
            break;
            VoipMgr.c(this.tyo, false);
          }
          label309:
          VoipMgr.a(this.tyo, 4);
        }
        else
        {
          if (com.tencent.mm.plugin.voip.b.cLC().tyR.cOm()) {
            break;
          }
          VoipMgr.b(this.tyo, false);
          VoipMgr.a(this.tyo, 2);
        }
      }
    }
    if ((VoipMgr.h(this.tyo)) || (2 == VoipMgr.i(this.tyo)))
    {
      Toast.makeText(VoipMgr.g(this.tyo), VoipMgr.g(this.tyo).getString(2131304754), 0).show();
      VoipMgr.b(this.tyo, true);
      VoipMgr.a(this.tyo, 1);
    }
    for (;;)
    {
      VoipMgr.c(this.tyo, false);
      break;
      Toast.makeText(VoipMgr.g(this.tyo), VoipMgr.g(this.tyo).getString(2131304753), 0).show();
      VoipMgr.a(this.tyo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.16
 * JD-Core Version:    0.7.0.1
 */