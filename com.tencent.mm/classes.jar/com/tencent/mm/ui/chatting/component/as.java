package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.protocal.protobuf.drn;
import com.tencent.mm.protocal.protobuf.epi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ai;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ai.class)
public class as
  extends a
  implements com.tencent.mm.am.h, ai
{
  private void cy(final cc paramcc)
  {
    AppMethodBeat.i(35497);
    final com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(this.hlc.aezO.getContext());
    localc.aeLx = new c.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(35492);
        localc.hide();
        AppMethodBeat.o(35492);
      }
      
      public final void zJ(long paramAnonymousLong)
      {
        AppMethodBeat.i(35491);
        localc.hide();
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(795L, 1L, 1L, false);
        if (!NetUtil.isConnected(as.this.hlc.aezO.getContext()))
        {
          k.c(as.this.hlc.aezO.getContext(), as.this.hlc.aezO.getMMResources().getString(R.l.net_warn_no_network), as.this.hlc.aezO.getMMResources().getString(R.l.gTf), true);
          AppMethodBeat.o(35491);
          return;
        }
        Object localObject = new epi();
        ((epi)localObject).crm = ((int)(paramAnonymousLong / 1000L));
        ((epi)localObject).vhJ = 1;
        ((epi)localObject).abmA = 1;
        try
        {
          drn localdrn = new drn();
          localdrn.UserName = as.this.hlc.getTalkerUserName();
          localdrn.Njv = paramcc.field_msgSvrId;
          localdrn.hAP = as.b(as.this, paramcc);
          ((epi)localObject).ZqS = new com.tencent.mm.bx.b(localdrn.toByteArray());
          localObject = new aa(1, (epi)localObject);
          bh.aZW().a((p)localObject, 0);
          AppMethodBeat.o(35491);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", new Object[] { localIOException.toString() });
          }
        }
      }
    };
    localc.show();
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(795L, 0L, 1L, false);
    AppMethodBeat.o(35497);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35493);
    bh.aZW().a(525, this);
    AppMethodBeat.o(35493);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35494);
    bh.aZW().b(525, this);
    AppMethodBeat.o(35494);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35495);
    super.jqF();
    bh.aZW().b(525, this);
    AppMethodBeat.o(35495);
  }
  
  public final void k(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35496);
    final cc localcc = ((m)this.hlc.cm(m.class)).aBV(paramMenuItem.getGroupId());
    if (localcc == null)
    {
      Log.e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
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
      bh.bCz();
      if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acJK, Boolean.TRUE)).booleanValue())
      {
        k.d(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gTh), this.hlc.aezO.getMMResources().getString(R.l.gTi), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35490);
            as.a(as.this, localcc);
            AppMethodBeat.o(35490);
          }
        });
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acJK, Boolean.FALSE);
        AppMethodBeat.o(35496);
        return;
      }
      cy(localcc);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(35498);
    Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramp.getType());
    this.hlc.aDM();
    if (!this.hlc.ffv)
    {
      Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35498);
      return;
    }
    if (!Util.isTopActivity(this.hlc.aezO.getContext()))
    {
      AppMethodBeat.o(35498);
      return;
    }
    Activity localActivity = this.hlc.aezO.getContext();
    int i;
    if (ae.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(35498);
      return;
      if (com.tencent.mm.plugin.account.ui.a.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramp.getType())
      {
      default: 
        AppMethodBeat.o(35498);
        return;
      }
      Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(this.hlc.aezO.getContext(), this.hlc.aezO.getContentView(), this.hlc.aezO.getMMResources().getString(R.l.gJw), "", null);
      AppMethodBeat.o(35498);
      return;
    }
    if (paramp.getType() == 525)
    {
      Log.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Util.nullAsNil(paramString) });
      localActivity = this.hlc.aezO.getContext();
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = this.hlc.aezO.getMMResources().getString(R.l.gTe);
      }
      k.c(localActivity, paramp, this.hlc.aezO.getMMResources().getString(R.l.gTf), true);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(35498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.as
 * JD-Core Version:    0.7.0.1
 */