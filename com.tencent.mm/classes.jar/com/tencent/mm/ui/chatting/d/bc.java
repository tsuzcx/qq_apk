package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.o.b;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.y.a;
import java.util.List;

public class bc
  extends a
  implements f, k.a, n.b, ad
{
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(35747);
    if (!this.cWM.cBJ)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
      AppMethodBeat.o(35747);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange ".concat(String.valueOf(paramInt)));
    ba.aBQ();
    paramn = c.azp().Bf(this.cWM.getTalkerUserName());
    if ((paramn != null) && ((int)paramn.gfj != 0))
    {
      if (bt.isNullOrNil(paramn.field_nickname)) {
        paramn.sT(this.cWM.BYG.field_nickname);
      }
      this.cWM.an(paramn);
      ((com.tencent.mm.ui.chatting.d.b.y)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fDo();
      ((com.tencent.mm.ui.chatting.d.b.y)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.y.class)).xV(true);
      this.cWM.bOo();
    }
    AppMethodBeat.o(35747);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(35748);
    a(0, null, null);
    AppMethodBeat.o(35748);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35745);
    super.fCC();
    ba.aiU().b(137, this);
    if (ba.ajx())
    {
      ba.aBQ();
      c.azp().b(this);
    }
    AppMethodBeat.o(35745);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35743);
    ba.aiU().a(137, this);
    ba.aBQ();
    c.azp().a(this);
    AppMethodBeat.o(35743);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35744);
    ba.aiU().b(137, this);
    if (ba.ajx())
    {
      ba.aBQ();
      c.azp().b(this);
    }
    AppMethodBeat.o(35744);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    int i = 1;
    AppMethodBeat.i(35746);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cWM.dismissDialog();
    if (!this.cWM.cBJ)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35746);
      return;
    }
    if (!bt.jh(this.cWM.JOR.getContext()))
    {
      AppMethodBeat.o(35746);
      return;
    }
    Object localObject = this.cWM.JOR.getContext();
    if (y.a.a((Context)localObject, paramInt1, paramInt2, paramString, 7)) {}
    while (i != 0)
    {
      AppMethodBeat.o(35746);
      return;
      if (!com.tencent.mm.ui.y.a((Activity)localObject, paramInt1, paramInt2, new Intent().setClass((Context)localObject, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramn.getType())
      {
      }
    }
    label387:
    for (;;)
    {
      AppMethodBeat.o(35746);
      return;
      paramString = ((o)paramn).ELU;
      if ((paramString == null) || (paramString.contains(this.cWM.BYG.field_username)))
      {
        localObject = this.cWM.BYG;
        ba.aBQ();
        paramn = c.azp().Bf(((aw)localObject).field_username);
        if (paramn != null)
        {
          paramString = paramn;
          if ((int)paramn.gfj != 0) {}
        }
        else
        {
          ba.aBQ();
          if (c.azp().af((am)localObject)) {
            break label368;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + ((aw)localObject).field_username);
        }
        for (paramString = null;; paramString = c.azp().Bf(((aw)localObject).field_username))
        {
          if (paramString == null) {
            break label387;
          }
          w.u(paramString);
          break;
          label368:
          ba.aBQ();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bc
 * JD-Core Version:    0.7.0.1
 */