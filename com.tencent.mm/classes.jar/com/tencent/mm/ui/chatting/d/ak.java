package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.mm.ui.y.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.ad.class)
public class ak
  extends a
  implements f, com.tencent.mm.ui.chatting.d.b.ad
{
  private void bC(final bu parambu)
  {
    AppMethodBeat.i(35497);
    final com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(this.cWM.JOR.getContext());
    localc.JXQ = new c.a()
    {
      public final void DQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(35491);
        localc.hide();
        g.yhR.idkeyStat(795L, 1L, 1L, false);
        if (!NetUtil.isConnected(ak.this.cWM.JOR.getContext()))
        {
          h.c(ak.this.cWM.JOR.getContext(), ak.this.cWM.JOR.getMMResources().getString(2131761535), ak.this.cWM.JOR.getMMResources().getString(2131762410), true);
          AppMethodBeat.o(35491);
          return;
        }
        Object localObject = new ctd();
        ((ctd)localObject).qex = ((int)(paramAnonymousLong / 1000L));
        ((ctd)localObject).nEf = 1;
        ((ctd)localObject).HfH = 1;
        try
        {
          cbo localcbo = new cbo();
          localcbo.nDo = ak.this.cWM.getTalkerUserName();
          localcbo.xbt = parambu.field_msgSvrId;
          localcbo.Title = ak.b(ak.this, parambu);
          ((ctd)localObject).Gcf = new com.tencent.mm.bx.b(localcbo.toByteArray());
          localObject = new com.tencent.mm.modelsimple.y(1, (ctd)localObject);
          ba.aiU().a((n)localObject, 0);
          AppMethodBeat.o(35491);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", new Object[] { localIOException.toString() });
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
    g.yhR.idkeyStat(795L, 0L, 1L, false);
    AppMethodBeat.o(35497);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35495);
    super.fCC();
    ba.aiU().b(525, this);
    AppMethodBeat.o(35495);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35493);
    ba.aiU().a(525, this);
    AppMethodBeat.o(35493);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35494);
    ba.aiU().b(525, this);
    AppMethodBeat.o(35494);
  }
  
  public final void h(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35496);
    final bu localbu = ((k)this.cWM.bh(k.class)).ada(paramMenuItem.getGroupId());
    if (localbu == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
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
      ba.aBQ();
      if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IrS, Boolean.TRUE)).booleanValue())
      {
        h.d(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131762413), this.cWM.JOR.getMMResources().getString(2131762414), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35490);
            ak.a(ak.this, localbu);
            AppMethodBeat.o(35490);
          }
        });
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(al.a.IrS, Boolean.FALSE);
        AppMethodBeat.o(35496);
        return;
      }
      bC(localbu);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(35498);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cWM.dismissDialog();
    if (!this.cWM.cBJ)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35498);
      return;
    }
    if (!bt.jh(this.cWM.JOR.getContext()))
    {
      AppMethodBeat.o(35498);
      return;
    }
    Activity localActivity = this.cWM.JOR.getContext();
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(this.cWM.JOR.getContext(), this.cWM.JOR.getContentView(), this.cWM.JOR.getMMResources().getString(2131760231), "", null);
      AppMethodBeat.o(35498);
      return;
    }
    if (paramn.getType() == 525)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bt.nullAsNil(paramString) });
      localActivity = this.cWM.JOR.getContext();
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = this.cWM.JOR.getMMResources().getString(2131762409);
      }
      h.c(localActivity, paramn, this.cWM.JOR.getMMResources().getString(2131762410), true);
      g.yhR.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(35498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ak
 * JD-Core Version:    0.7.0.1
 */