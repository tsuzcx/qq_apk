package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.y.a;
import java.util.List;

public class bd
  extends a
  implements f, k.a, n.b, ad
{
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(35747);
    if (!this.cXJ.cCq)
    {
      ae.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
      AppMethodBeat.o(35747);
      return;
    }
    ae.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange ".concat(String.valueOf(paramInt)));
    bc.aCg();
    paramn = com.tencent.mm.model.c.azF().BH(this.cXJ.getTalkerUserName());
    if ((paramn != null) && ((int)paramn.ght != 0))
    {
      if (bu.isNullOrNil(paramn.field_nickname)) {
        paramn.to(this.cXJ.Cqh.field_nickname);
      }
      this.cXJ.au(paramn);
      ((com.tencent.mm.ui.chatting.d.b.y)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class)).fHr();
      ((com.tencent.mm.ui.chatting.d.b.y)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class)).yc(true);
      this.cXJ.bPl();
    }
    AppMethodBeat.o(35747);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(35748);
    a(0, null, null);
    AppMethodBeat.o(35748);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35743);
    bc.ajj().a(137, this);
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this);
    AppMethodBeat.o(35743);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35744);
    bc.ajj().b(137, this);
    if (bc.ajM())
    {
      bc.aCg();
      com.tencent.mm.model.c.azF().b(this);
    }
    AppMethodBeat.o(35744);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35745);
    super.fGE();
    bc.ajj().b(137, this);
    if (bc.ajM())
    {
      bc.aCg();
      com.tencent.mm.model.c.azF().b(this);
    }
    AppMethodBeat.o(35745);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    int i = 1;
    AppMethodBeat.i(35746);
    ae.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cXJ.dismissDialog();
    if (!this.cXJ.cCq)
    {
      ae.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35746);
      return;
    }
    if (!bu.jn(this.cXJ.Kkd.getContext()))
    {
      AppMethodBeat.o(35746);
      return;
    }
    Object localObject = this.cXJ.Kkd.getContext();
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
      paramString = ((o)paramn).Fes;
      if ((paramString == null) || (paramString.contains(this.cXJ.Cqh.field_username)))
      {
        localObject = this.cXJ.Cqh;
        bc.aCg();
        paramn = com.tencent.mm.model.c.azF().BH(((aw)localObject).field_username);
        if (paramn != null)
        {
          paramString = paramn;
          if ((int)paramn.ght != 0) {}
        }
        else
        {
          bc.aCg();
          if (com.tencent.mm.model.c.azF().am((an)localObject)) {
            break label368;
          }
          ae.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + ((aw)localObject).field_username);
        }
        for (paramString = null;; paramString = com.tencent.mm.model.c.azF().BH(((aw)localObject).field_username))
        {
          if (paramString == null) {
            break label387;
          }
          x.B(paramString);
          break;
          label368:
          bc.aCg();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bd
 * JD-Core Version:    0.7.0.1
 */