package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cci;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ad;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@com.tencent.mm.ui.chatting.d.a.a(fJv=ad.class)
public class ak
  extends a
  implements f, ad
{
  private void bB(final bv parambv)
  {
    AppMethodBeat.i(35497);
    final com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(this.cXJ.Kkd.getContext());
    localc.Kuj = new c.a()
    {
      public final void Ep(long paramAnonymousLong)
      {
        AppMethodBeat.i(35491);
        localc.hide();
        g.yxI.idkeyStat(795L, 1L, 1L, false);
        if (!NetUtil.isConnected(ak.this.cXJ.Kkd.getContext()))
        {
          h.c(ak.this.cXJ.Kkd.getContext(), ak.this.cXJ.Kkd.getMMResources().getString(2131761535), ak.this.cXJ.Kkd.getMMResources().getString(2131762410), true);
          AppMethodBeat.o(35491);
          return;
        }
        Object localObject = new ctx();
        ((ctx)localObject).qlc = ((int)(paramAnonymousLong / 1000L));
        ((ctx)localObject).nJA = 1;
        ((ctx)localObject).Hzh = 1;
        try
        {
          cci localcci = new cci();
          localcci.nIJ = ak.this.cXJ.getTalkerUserName();
          localcci.xrk = parambv.field_msgSvrId;
          localcci.Title = ak.b(ak.this, parambv);
          ((ctx)localObject).GuM = new com.tencent.mm.bw.b(localcci.toByteArray());
          localObject = new z(1, (ctx)localObject);
          bc.ajj().a((n)localObject, 0);
          AppMethodBeat.o(35491);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ae.e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", new Object[] { localIOException.toString() });
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
    g.yxI.idkeyStat(795L, 0L, 1L, false);
    AppMethodBeat.o(35497);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35493);
    bc.ajj().a(525, this);
    AppMethodBeat.o(35493);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35494);
    bc.ajj().b(525, this);
    AppMethodBeat.o(35494);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35495);
    super.fGE();
    bc.ajj().b(525, this);
    AppMethodBeat.o(35495);
  }
  
  public final void h(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35496);
    final bv localbv = ((k)this.cXJ.bh(k.class)).adI(paramMenuItem.getGroupId());
    if (localbv == null)
    {
      ae.e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
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
      bc.aCg();
      if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.IMo, Boolean.TRUE)).booleanValue())
      {
        h.d(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131762413), this.cXJ.Kkd.getMMResources().getString(2131762414), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35490);
            ak.a(ak.this, localbv);
            AppMethodBeat.o(35490);
          }
        });
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(am.a.IMo, Boolean.FALSE);
        AppMethodBeat.o(35496);
        return;
      }
      bB(localbv);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(35498);
    ae.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cXJ.dismissDialog();
    if (!this.cXJ.cCq)
    {
      ae.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35498);
      return;
    }
    if (!bu.jn(this.cXJ.Kkd.getContext()))
    {
      AppMethodBeat.o(35498);
      return;
    }
    Activity localActivity = this.cXJ.Kkd.getContext();
    int i;
    if (y.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(35498);
      return;
      if (y.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
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
      ae.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getContentView(), this.cXJ.Kkd.getMMResources().getString(2131760231), "", null);
      AppMethodBeat.o(35498);
      return;
    }
    if (paramn.getType() == 525)
    {
      ae.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bu.nullAsNil(paramString) });
      localActivity = this.cXJ.Kkd.getContext();
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = this.cXJ.Kkd.getMMResources().getString(2131762409);
      }
      h.c(localActivity, paramn, this.cXJ.Kkd.getMMResources().getString(2131762410), true);
      g.yxI.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(35498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ak
 * JD-Core Version:    0.7.0.1
 */