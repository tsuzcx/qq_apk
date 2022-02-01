package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.n.b;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import java.util.List;

public class ay
  extends a
  implements g, k.a, n.b, ab
{
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(35747);
    if (!this.cOd.ctF)
    {
      ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
      AppMethodBeat.o(35747);
      return;
    }
    ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange ".concat(String.valueOf(paramInt)));
    az.arV();
    paramn = c.apM().aHY(this.cOd.getTalkerUserName());
    if ((paramn != null) && ((int)paramn.fId != 0))
    {
      if (bt.isNullOrNil(paramn.field_nickname)) {
        paramn.nd(this.cOd.zgX.field_nickname);
      }
      this.cOd.am(paramn);
      ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).eXQ();
      ((com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class)).wg(true);
      this.cOd.bCM();
    }
    AppMethodBeat.o(35747);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(35748);
    a(0, null, null);
    AppMethodBeat.o(35748);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35743);
    az.aeS().a(137, this);
    az.arV();
    c.apM().a(this);
    AppMethodBeat.o(35743);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35744);
    az.aeS().b(137, this);
    if (az.afw())
    {
      az.arV();
      c.apM().b(this);
    }
    AppMethodBeat.o(35744);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35745);
    super.eWx();
    az.aeS().b(137, this);
    if (az.afw())
    {
      az.arV();
      c.apM().b(this);
    }
    AppMethodBeat.o(35745);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    int i = 1;
    AppMethodBeat.i(35746);
    ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cOd.dismissDialog();
    if (!this.cOd.ctF)
    {
      ad.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35746);
      return;
    }
    if (!bt.iM(this.cOd.GzJ.getContext()))
    {
      AppMethodBeat.o(35746);
      return;
    }
    Object localObject = this.cOd.GzJ.getContext();
    if (x.a.a((Context)localObject, paramInt1, paramInt2, paramString, 7)) {}
    while (i != 0)
    {
      AppMethodBeat.o(35746);
      return;
      if (!x.a((Activity)localObject, paramInt1, paramInt2, new Intent().setClass((Context)localObject, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
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
      paramString = ((o)paramn).BOW;
      if ((paramString == null) || (paramString.contains(this.cOd.zgX.field_username)))
      {
        localObject = this.cOd.zgX;
        az.arV();
        paramn = c.apM().aHY(((au)localObject).field_username);
        if (paramn != null)
        {
          paramString = paramn;
          if ((int)paramn.fId != 0) {}
        }
        else
        {
          az.arV();
          if (c.apM().ae((af)localObject)) {
            break label368;
          }
          ad.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + ((au)localObject).field_username);
        }
        for (paramString = null;; paramString = c.apM().aHY(((au)localObject).field_username))
        {
          if (paramString == null) {
            break label387;
          }
          com.tencent.mm.model.w.u(paramString);
          break;
          label368:
          az.arV();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ay
 * JD-Core Version:    0.7.0.1
 */