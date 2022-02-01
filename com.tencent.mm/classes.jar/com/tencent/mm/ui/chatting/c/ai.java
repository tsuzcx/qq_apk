package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ab;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.mm.ui.y.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@com.tencent.mm.ui.chatting.c.a.a(foJ=ab.class)
public class ai
  extends a
  implements g, ab
{
  private void by(final bo parambo)
  {
    AppMethodBeat.i(35497);
    final com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(this.cLy.HZF.getContext());
    localc.Ihv = new c.a()
    {
      public final void Bc(long paramAnonymousLong)
      {
        AppMethodBeat.i(35491);
        localc.hide();
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(795L, 1L, 1L, false);
        if (!NetUtil.isConnected(ai.this.cLy.HZF.getContext()))
        {
          com.tencent.mm.ui.base.h.c(ai.this.cLy.HZF.getContext(), ai.this.cLy.HZF.getMMResources().getString(2131761535), ai.this.cLy.HZF.getMMResources().getString(2131762410), true);
          AppMethodBeat.o(35491);
          return;
        }
        Object localObject = new coa();
        ((coa)localObject).pAS = ((int)(paramAnonymousLong / 1000L));
        ((coa)localObject).ndI = 1;
        ((coa)localObject).FvC = 1;
        try
        {
          bwy localbwy = new bwy();
          localbwy.ncR = ai.this.cLy.getTalkerUserName();
          localbwy.vTQ = parambo.field_msgSvrId;
          localbwy.Title = ai.b(ai.this, parambo);
          ((coa)localObject).EuL = new com.tencent.mm.bw.b(localbwy.toByteArray());
          localObject = new com.tencent.mm.modelsimple.y(1, (coa)localObject);
          az.agi().a((n)localObject, 0);
          AppMethodBeat.o(35491);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ac.e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", new Object[] { localIOException.toString() });
          }
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(35492);
        localc.hide();
        AppMethodBeat.o(35492);
      }
    };
    localc.show();
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(795L, 0L, 1L, false);
    AppMethodBeat.o(35497);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35493);
    az.agi().a(525, this);
    AppMethodBeat.o(35493);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35494);
    az.agi().b(525, this);
    AppMethodBeat.o(35494);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35495);
    super.fmj();
    az.agi().b(525, this);
    AppMethodBeat.o(35495);
  }
  
  public final void h(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35496);
    final bo localbo = ((i)this.cLy.bf(i.class)).aaP(paramMenuItem.getGroupId());
    if (localbo == null)
    {
      ac.e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
      AppMethodBeat.o(35496);
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35496);
      return;
      az.ayM();
      if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GFA, Boolean.TRUE)).booleanValue())
      {
        com.tencent.mm.ui.base.h.d(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131762413), this.cLy.HZF.getMMResources().getString(2131762414), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35490);
            ai.a(ai.this, localbo);
            AppMethodBeat.o(35490);
          }
        });
        az.ayM();
        com.tencent.mm.model.c.agA().set(ah.a.GFA, Boolean.FALSE);
        AppMethodBeat.o(35496);
        return;
      }
      by(localbo);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(35498);
    ac.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cLy.dismissDialog();
    if (!this.cLy.cqM)
    {
      ac.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35498);
      return;
    }
    if (!bs.iX(this.cLy.HZF.getContext()))
    {
      AppMethodBeat.o(35498);
      return;
    }
    Activity localActivity = this.cLy.HZF.getContext();
    int i;
    if (y.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(35498);
      return;
      if (com.tencent.mm.ui.y.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramn.getType())
      {
      default: 
        AppMethodBeat.o(35498);
        return;
      }
      ac.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(this.cLy.HZF.getContext(), this.cLy.HZF.getContentView(), this.cLy.HZF.getMMResources().getString(2131760231), "", null);
      AppMethodBeat.o(35498);
      return;
    }
    if (paramn.getType() == 525)
    {
      ac.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bs.nullAsNil(paramString) });
      localActivity = this.cLy.HZF.getContext();
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramn = this.cLy.HZF.getMMResources().getString(2131762409);
      }
      com.tencent.mm.ui.base.h.c(localActivity, paramn, this.cLy.HZF.getMMResources().getString(2131762410), true);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(35498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ai
 * JD-Core Version:    0.7.0.1
 */