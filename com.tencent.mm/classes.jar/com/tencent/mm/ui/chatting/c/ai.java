package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.ab.class)
public class ai
  extends a
  implements g, com.tencent.mm.ui.chatting.c.b.ab
{
  private void bw(final bl parambl)
  {
    AppMethodBeat.i(35497);
    final com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(this.cOd.GzJ.getContext());
    localc.GHz = new c.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(35492);
        localc.hide();
        AppMethodBeat.o(35492);
      }
      
      public final void wz(long paramAnonymousLong)
      {
        AppMethodBeat.i(35491);
        localc.hide();
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(795L, 1L, 1L, false);
        if (!NetUtil.isConnected(ai.this.cOd.GzJ.getContext()))
        {
          com.tencent.mm.ui.base.h.c(ai.this.cOd.GzJ.getContext(), ai.this.cOd.GzJ.getMMResources().getString(2131761535), ai.this.cOd.GzJ.getMMResources().getString(2131762410), true);
          AppMethodBeat.o(35491);
          return;
        }
        Object localObject = new cit();
        ((cit)localObject).oXH = ((int)(paramAnonymousLong / 1000L));
        ((cit)localObject).mBH = 1;
        ((cit)localObject).DYI = 1;
        try
        {
          bsh localbsh = new bsh();
          localbsh.mAQ = ai.this.cOd.getTalkerUserName();
          localbsh.uKZ = parambl.field_msgSvrId;
          localbsh.Title = ai.b(ai.this, parambl);
          ((cit)localObject).DbF = new com.tencent.mm.bx.b(localbsh.toByteArray());
          localObject = new y(1, (cit)localObject);
          az.aeS().a((n)localObject, 0);
          AppMethodBeat.o(35491);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ad.e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", new Object[] { localIOException.toString() });
          }
        }
      }
    };
    localc.show();
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(795L, 0L, 1L, false);
    AppMethodBeat.o(35497);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35493);
    az.aeS().a(525, this);
    AppMethodBeat.o(35493);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35494);
    az.aeS().b(525, this);
    AppMethodBeat.o(35494);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35495);
    super.eWx();
    az.aeS().b(525, this);
    AppMethodBeat.o(35495);
  }
  
  public final void h(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35496);
    final bl localbl = ((i)this.cOd.be(i.class)).YE(paramMenuItem.getGroupId());
    if (localbl == null)
    {
      ad.e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
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
      az.arV();
      if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FhL, Boolean.TRUE)).booleanValue())
      {
        com.tencent.mm.ui.base.h.d(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131762413), this.cOd.GzJ.getMMResources().getString(2131762414), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35490);
            ai.a(ai.this, localbl);
            AppMethodBeat.o(35490);
          }
        });
        az.arV();
        com.tencent.mm.model.c.afk().set(ae.a.FhL, Boolean.FALSE);
        AppMethodBeat.o(35496);
        return;
      }
      bw(localbl);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(35498);
    ad.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cOd.dismissDialog();
    if (!this.cOd.ctF)
    {
      ad.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35498);
      return;
    }
    if (!bt.iM(this.cOd.GzJ.getContext()))
    {
      AppMethodBeat.o(35498);
      return;
    }
    Activity localActivity = this.cOd.GzJ.getContext();
    int i;
    if (x.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(35498);
      return;
      if (x.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
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
      ad.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(this.cOd.GzJ.getContext(), this.cOd.GzJ.getContentView(), this.cOd.GzJ.getMMResources().getString(2131760231), "", null);
      AppMethodBeat.o(35498);
      return;
    }
    if (paramn.getType() == 525)
    {
      ad.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bt.nullAsNil(paramString) });
      localActivity = this.cOd.GzJ.getContext();
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = this.cOd.GzJ.getMMResources().getString(2131762409);
      }
      com.tencent.mm.ui.base.h.c(localActivity, paramn, this.cOd.GzJ.getMMResources().getString(2131762410), true);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(35498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ai
 * JD-Core Version:    0.7.0.1
 */