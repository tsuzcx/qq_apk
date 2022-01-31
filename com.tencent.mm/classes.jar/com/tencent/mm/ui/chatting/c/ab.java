package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;

@com.tencent.mm.ui.chatting.c.a.a(dJy=w.class)
public class ab
  extends a
  implements f, w
{
  private void bb(bi parambi)
  {
    AppMethodBeat.i(31601);
    com.tencent.mm.ui.chatting.view.b localb = new com.tencent.mm.ui.chatting.view.b(this.caz.zJz.getContext());
    localb.zRc = new ab.2(this, localb, parambi);
    localb.show();
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(795L, 0L, 1L, false);
    AppMethodBeat.o(31601);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31597);
    aw.Rc().a(525, this);
    AppMethodBeat.o(31597);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31598);
    aw.Rc().b(525, this);
    AppMethodBeat.o(31598);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31599);
    super.dHq();
    aw.Rc().b(525, this);
    AppMethodBeat.o(31599);
  }
  
  public final void g(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(31600);
    bi localbi = ((com.tencent.mm.ui.chatting.c.b.h)this.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class)).Pz(paramMenuItem.getGroupId());
    if (localbi == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
      AppMethodBeat.o(31600);
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31600);
      return;
      aw.aaz();
      if (((Boolean)c.Ru().get(ac.a.yzq, Boolean.TRUE)).booleanValue())
      {
        com.tencent.mm.ui.base.h.a(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131302510), this.caz.zJz.getMMResources().getString(2131302511), new ab.1(this, localbi));
        aw.aaz();
        c.Ru().set(ac.a.yzq, Boolean.FALSE);
        AppMethodBeat.o(31600);
        return;
      }
      bb(localbi);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(31602);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramm.getType());
    this.caz.dismissDialog();
    if (!this.caz.bSe)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(31602);
      return;
    }
    if (!bo.cB(this.caz.zJz.getContext()))
    {
      AppMethodBeat.o(31602);
      return;
    }
    Activity localActivity = this.caz.zJz.getContext();
    int i;
    if (v.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(31602);
      return;
      if (v.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramm.getType())
      {
      default: 
        AppMethodBeat.o(31602);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(this.caz.zJz.getContext(), this.caz.zJz.getContentView(), this.caz.zJz.getMMResources().getString(2131300635), "");
      AppMethodBeat.o(31602);
      return;
    }
    if (paramm.getType() == 525)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bo.nullAsNil(paramString) });
      localActivity = this.caz.zJz.getContext();
      paramm = paramString;
      if (bo.isNullOrNil(paramString)) {
        paramm = this.caz.zJz.getMMResources().getString(2131302506);
      }
      com.tencent.mm.ui.base.h.b(localActivity, paramm, this.caz.zJz.getMMResources().getString(2131302507), true);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(31602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ab
 * JD-Core Version:    0.7.0.1
 */