package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@com.tencent.mm.ui.chatting.d.a.a(hRc=af.class)
public class ao
  extends a
  implements i, af
{
  private void ck(final ca paramca)
  {
    AppMethodBeat.i(35497);
    final com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(this.fgR.WQv.getContext());
    localc.XbP = new c.a()
    {
      public final void VB(long paramAnonymousLong)
      {
        AppMethodBeat.i(35491);
        localc.hide();
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(795L, 1L, 1L, false);
        if (!NetUtil.isConnected(ao.this.fgR.WQv.getContext()))
        {
          com.tencent.mm.ui.base.h.c(ao.this.fgR.WQv.getContext(), ao.this.fgR.WQv.getMMResources().getString(R.l.net_warn_no_network), ao.this.fgR.WQv.getMMResources().getString(R.l.eQz), true);
          AppMethodBeat.o(35491);
          return;
        }
        Object localObject = new dwe();
        ((dwe)localObject).vhF = ((int)(paramAnonymousLong / 1000L));
        ((dwe)localObject).rWu = 1;
        ((dwe)localObject).TVM = 1;
        try
        {
          daf localdaf = new daf();
          localdaf.UserName = ao.this.fgR.getTalkerUserName();
          localdaf.HlH = paramca.field_msgSvrId;
          localdaf.fwr = ao.b(ao.this, paramca);
          ((dwe)localObject).SrO = new com.tencent.mm.cd.b(localdaf.toByteArray());
          localObject = new z(1, (dwe)localObject);
          bh.aGY().a((q)localObject, 0);
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
      
      public final void onCancel()
      {
        AppMethodBeat.i(35492);
        localc.hide();
        AppMethodBeat.o(35492);
      }
    };
    localc.show();
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(795L, 0L, 1L, false);
    AppMethodBeat.o(35497);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35493);
    bh.aGY().a(525, this);
    AppMethodBeat.o(35493);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35494);
    bh.aGY().b(525, this);
    AppMethodBeat.o(35494);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35495);
    super.hNZ();
    bh.aGY().b(525, this);
    AppMethodBeat.o(35495);
  }
  
  public final void i(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35496);
    final ca localca = ((k)this.fgR.bC(k.class)).avt(paramMenuItem.getGroupId());
    if (localca == null)
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
      bh.beI();
      if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Viq, Boolean.TRUE)).booleanValue())
      {
        com.tencent.mm.ui.base.h.d(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eQB), this.fgR.WQv.getMMResources().getString(R.l.eQC), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35490);
            ao.a(ao.this, localca);
            AppMethodBeat.o(35490);
          }
        });
        bh.beI();
        com.tencent.mm.model.c.aHp().set(ar.a.Viq, Boolean.FALSE);
        AppMethodBeat.o(35496);
        return;
      }
      ck(localca);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(35498);
    Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramq.getType());
    this.fgR.dismissDialog();
    if (!this.fgR.dgo)
    {
      Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35498);
      return;
    }
    if (!Util.isTopActivity(this.fgR.WQv.getContext()))
    {
      AppMethodBeat.o(35498);
      return;
    }
    Activity localActivity = this.fgR.WQv.getContext();
    int i;
    if (ac.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
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
      switch (paramq.getType())
      {
      default: 
        AppMethodBeat.o(35498);
        return;
      }
      Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(this.fgR.WQv.getContext(), this.fgR.WQv.getContentView(), this.fgR.WQv.getMMResources().getString(R.l.eHQ), "", null);
      AppMethodBeat.o(35498);
      return;
    }
    if (paramq.getType() == 525)
    {
      Log.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Util.nullAsNil(paramString) });
      localActivity = this.fgR.WQv.getContext();
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = this.fgR.WQv.getMMResources().getString(R.l.eQy);
      }
      com.tencent.mm.ui.base.h.c(localActivity, paramq, this.fgR.WQv.getMMResources().getString(R.l.eQz), true);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(35498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ao
 * JD-Core Version:    0.7.0.1
 */