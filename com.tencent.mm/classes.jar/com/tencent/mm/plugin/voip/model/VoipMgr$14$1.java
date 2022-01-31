package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.a.vy.a;
import com.tencent.mm.plugin.voip.a.b;
import com.tencent.mm.plugin.voip.a.c;

final class VoipMgr$14$1
  implements Runnable
{
  VoipMgr$14$1(VoipMgr.14 param14, vy paramvy) {}
  
  public final void run()
  {
    AppMethodBeat.i(140152);
    switch (this.tyx.cNn.coO)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(140152);
      return;
      if (b.HR(VoipMgr.a(this.tyy.tyo).mState))
      {
        this.tyy.tyo.cML();
        AppMethodBeat.o(140152);
        return;
      }
      this.tyy.tyo.cMO();
      AppMethodBeat.o(140152);
      return;
      if (b.HR(VoipMgr.a(this.tyy.tyo).mState))
      {
        this.tyy.tyo.cMK();
        AppMethodBeat.o(140152);
        return;
      }
      this.tyy.tyo.cMN();
      AppMethodBeat.o(140152);
      return;
      this.tyy.tyo.cMI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.14.1
 * JD-Core Version:    0.7.0.1
 */