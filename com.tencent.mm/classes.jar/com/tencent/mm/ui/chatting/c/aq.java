package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.v.a;
import java.util.List;

public class aq
  extends a
  implements f, k.a, n.b, v
{
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(31845);
    if (!this.caz.bSe)
    {
      ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
      AppMethodBeat.o(31845);
      return;
    }
    ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange ".concat(String.valueOf(paramInt)));
    aw.aaz();
    paramn = c.YA().arw(this.caz.getTalkerUserName());
    if ((paramn != null) && ((int)paramn.euF != 0))
    {
      if (bo.isNullOrNil(paramn.field_nickname)) {
        paramn.jp(this.caz.txj.field_nickname);
      }
      this.caz.ae(paramn);
      ((r)this.caz.ay(r.class)).dIv();
      ((r)this.caz.ay(r.class)).qV(true);
      this.caz.aWN();
    }
    AppMethodBeat.o(31845);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    label0:
    break label0;
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31841);
    aw.Rc().a(137, this);
    aw.aaz();
    c.YA().a(this);
    AppMethodBeat.o(31841);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31842);
    aw.Rc().b(137, this);
    if (aw.RG())
    {
      aw.aaz();
      c.YA().b(this);
    }
    AppMethodBeat.o(31842);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31843);
    super.dHq();
    aw.Rc().b(137, this);
    if (aw.RG())
    {
      aw.aaz();
      c.YA().b(this);
    }
    AppMethodBeat.o(31843);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    int i = 1;
    AppMethodBeat.i(31844);
    ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramm.getType());
    this.caz.dismissDialog();
    if (!this.caz.bSe)
    {
      ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(31844);
      return;
    }
    if (!bo.cB(this.caz.zJz.getContext()))
    {
      AppMethodBeat.o(31844);
      return;
    }
    Object localObject = this.caz.zJz.getContext();
    if (v.a.a((Context)localObject, paramInt1, paramInt2, paramString, 7)) {}
    while (i != 0)
    {
      AppMethodBeat.o(31844);
      return;
      if (!com.tencent.mm.ui.v.a((Activity)localObject, paramInt1, paramInt2, new Intent().setClass((Context)localObject, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramm.getType())
      {
      }
    }
    label392:
    for (;;)
    {
      AppMethodBeat.o(31844);
      return;
      paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).vKs;
      if ((paramString == null) || (paramString.contains(this.caz.txj.field_username)))
      {
        localObject = this.caz.txj;
        aw.aaz();
        paramm = c.YA().arw(((com.tencent.mm.g.c.aq)localObject).field_username);
        if (paramm != null)
        {
          paramString = paramm;
          if ((int)paramm.euF != 0) {}
        }
        else
        {
          aw.aaz();
          if (c.YA().X((ad)localObject)) {
            break label373;
          }
          ab.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + ((com.tencent.mm.g.c.aq)localObject).field_username);
        }
        for (paramString = null;; paramString = c.YA().arw(((com.tencent.mm.g.c.aq)localObject).field_username))
        {
          if (paramString == null) {
            break label392;
          }
          t.q(paramString);
          break;
          label373:
          aw.aaz();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aq
 * JD-Core Version:    0.7.0.1
 */