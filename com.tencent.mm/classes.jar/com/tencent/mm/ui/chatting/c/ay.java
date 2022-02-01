package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.n.b;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;
import java.util.List;

public class ay
  extends a
  implements g, k.a, n.b, ab
{
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(35747);
    if (!this.cLy.cqM)
    {
      ac.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
      AppMethodBeat.o(35747);
      return;
    }
    ac.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange ".concat(String.valueOf(paramInt)));
    az.ayM();
    paramn = c.awB().aNt(this.cLy.getTalkerUserName());
    if ((paramn != null) && ((int)paramn.fLJ != 0))
    {
      if (bs.isNullOrNil(paramn.field_nickname)) {
        paramn.qj(this.cLy.AzG.field_nickname);
      }
      this.cLy.an(paramn);
      ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).fnC();
      ((com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class)).xk(true);
      this.cLy.bJU();
    }
    AppMethodBeat.o(35747);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(35748);
    a(0, null, null);
    AppMethodBeat.o(35748);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35743);
    az.agi().a(137, this);
    az.ayM();
    c.awB().a(this);
    AppMethodBeat.o(35743);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35744);
    az.agi().b(137, this);
    if (az.agM())
    {
      az.ayM();
      c.awB().b(this);
    }
    AppMethodBeat.o(35744);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35745);
    super.fmj();
    az.agi().b(137, this);
    if (az.agM())
    {
      az.ayM();
      c.awB().b(this);
    }
    AppMethodBeat.o(35745);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    int i = 1;
    AppMethodBeat.i(35746);
    ac.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cLy.dismissDialog();
    if (!this.cLy.cqM)
    {
      ac.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35746);
      return;
    }
    if (!bs.iX(this.cLy.HZF.getContext()))
    {
      AppMethodBeat.o(35746);
      return;
    }
    Object localObject = this.cLy.HZF.getContext();
    if (y.a.a((Context)localObject, paramInt1, paramInt2, paramString, 7)) {}
    while (i != 0)
    {
      AppMethodBeat.o(35746);
      return;
      if (!y.a((Activity)localObject, paramInt1, paramInt2, new Intent().setClass((Context)localObject, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
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
      paramString = ((o)paramn).Dhk;
      if ((paramString == null) || (paramString.contains(this.cLy.AzG.field_username)))
      {
        localObject = this.cLy.AzG;
        az.ayM();
        paramn = c.awB().aNt(((av)localObject).field_username);
        if (paramn != null)
        {
          paramString = paramn;
          if ((int)paramn.fLJ != 0) {}
        }
        else
        {
          az.ayM();
          if (c.awB().af((ai)localObject)) {
            break label368;
          }
          ac.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + ((av)localObject).field_username);
        }
        for (paramString = null;; paramString = c.awB().aNt(((av)localObject).field_username))
        {
          if (paramString == null) {
            break label387;
          }
          com.tencent.mm.model.w.u(paramString);
          break;
          label368:
          az.ayM();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ay
 * JD-Core Version:    0.7.0.1
 */