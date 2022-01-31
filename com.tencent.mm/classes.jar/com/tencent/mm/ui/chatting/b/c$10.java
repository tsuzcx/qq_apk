package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.a.a;
import com.tencent.mm.ai.e.a.b;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class c$10
  implements e.a
{
  c$10(c paramc) {}
  
  public final void a(e.a.b paramb)
  {
    ad localad;
    if ((paramb != null) && (paramb.egi == e.a.a.egg) && (paramb.eeM != null) && (paramb.eeM.equals(this.voK.byx.getTalkerUserName())))
    {
      au.Hx();
      localad = com.tencent.mm.model.c.Fw().abl(paramb.eeM);
      if ((localad == null) || ((int)localad.dBe == 0)) {
        y.i("MicroMsg.ChattingUI.BizComponent", "Get contact from db return null.(username : %s)", new Object[] { paramb.eeM });
      }
    }
    else
    {
      return;
    }
    ai.d(new c.10.1(this, paramb, localad));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.10
 * JD-Core Version:    0.7.0.1
 */