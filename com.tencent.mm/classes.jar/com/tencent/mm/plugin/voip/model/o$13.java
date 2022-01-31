package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class o$13
  implements HeadsetPlugReceiver.a
{
  o$13(o paramo) {}
  
  public final void eH(boolean paramBoolean)
  {
    boolean bool = f.yi().yn();
    y.i("MicroMsg.Voip.VoipMgr", "onHeadsetState, on:%b, bluetooth: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    if (((true == paramBoolean) && (3 == o.f(this.pSP))) || ((!paramBoolean) && (3 != o.f(this.pSP))))
    {
      y.i("MicroMsg.Voip.VoipMgr", "same status, no changed");
      return;
    }
    if (com.tencent.mm.plugin.voip.a.b.Ax(o.a(this.pSP).mState)) {
      if ((paramBoolean) || (bool))
      {
        o.b(this.pSP, false);
        if (paramBoolean) {
          o.a(this.pSP, 3);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.voip.b.bPx().hH(paramBoolean);
      o.b(this.pSP, o.f(this.pSP));
      return;
      o.a(this.pSP, 4);
      continue;
      if (!com.tencent.mm.plugin.voip.b.bPx().bRj())
      {
        o.b(this.pSP, false);
        o.a(this.pSP, 3);
      }
      else
      {
        Toast.makeText(o.g(this.pSP), o.g(this.pSP).getString(a.e.voip_voice_come_from_speaker), 0).show();
        o.b(this.pSP, true);
        o.a(this.pSP, 1);
        continue;
        if ((paramBoolean) || (bool))
        {
          if (1 == o.f(this.pSP))
          {
            o.b(this.pSP, false);
            o.c(this.pSP, true);
          }
          for (;;)
          {
            if (!paramBoolean) {
              break label290;
            }
            o.a(this.pSP, 3);
            break;
            o.c(this.pSP, false);
          }
          label290:
          o.a(this.pSP, 4);
        }
        else
        {
          if (com.tencent.mm.plugin.voip.b.bPx().bRj()) {
            break;
          }
          o.b(this.pSP, false);
          o.a(this.pSP, 2);
        }
      }
    }
    if ((o.h(this.pSP)) || (2 == o.i(this.pSP)))
    {
      Toast.makeText(o.g(this.pSP), o.g(this.pSP).getString(a.e.voip_voice_come_from_speaker), 0).show();
      o.b(this.pSP, true);
      o.a(this.pSP, 1);
    }
    for (;;)
    {
      o.c(this.pSP, false);
      break;
      Toast.makeText(o.g(this.pSP), o.g(this.pSP).getString(a.e.voip_voice_come_from_earpiece), 0).show();
      o.a(this.pSP, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o.13
 * JD-Core Version:    0.7.0.1
 */