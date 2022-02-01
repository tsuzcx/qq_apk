package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.mm.ui.z.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@com.tencent.mm.ui.chatting.d.a.a(gRF=af.class)
public class am
  extends a
  implements i, af
{
  private void bQ(final ca paramca)
  {
    AppMethodBeat.i(35497);
    final com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(this.dom.Pwc.getContext());
    localc.PGz = new c.a()
    {
      public final void Nt(long paramAnonymousLong)
      {
        AppMethodBeat.i(35491);
        localc.hide();
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(795L, 1L, 1L, false);
        if (!NetUtil.isConnected(am.this.dom.Pwc.getContext()))
        {
          com.tencent.mm.ui.base.h.c(am.this.dom.Pwc.getContext(), am.this.dom.Pwc.getMMResources().getString(2131763501), am.this.dom.Pwc.getMMResources().getString(2131764476), true);
          AppMethodBeat.o(35491);
          return;
        }
        Object localObject = new dmn();
        ((dmn)localObject).rBX = ((int)(paramAnonymousLong / 1000L));
        ((dmn)localObject).oUv = 1;
        ((dmn)localObject).MJT = 1;
        try
        {
          crk localcrk = new crk();
          localcrk.UserName = am.this.dom.getTalkerUserName();
          localcrk.Brn = paramca.field_msgSvrId;
          localcrk.Title = am.b(am.this, paramca);
          ((dmn)localObject).Lqr = new com.tencent.mm.bw.b(localcrk.toByteArray());
          localObject = new z(1, (dmn)localObject);
          bg.azz().a((q)localObject, 0);
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
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(795L, 0L, 1L, false);
    AppMethodBeat.o(35497);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35493);
    bg.azz().a(525, this);
    AppMethodBeat.o(35493);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35494);
    bg.azz().b(525, this);
    AppMethodBeat.o(35494);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35495);
    super.gOK();
    bg.azz().b(525, this);
    AppMethodBeat.o(35495);
  }
  
  public final void h(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35496);
    final ca localca = ((k)this.dom.bh(k.class)).amt(paramMenuItem.getGroupId());
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
      bg.aVF();
      if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NUq, Boolean.TRUE)).booleanValue())
      {
        com.tencent.mm.ui.base.h.d(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131764479), this.dom.Pwc.getMMResources().getString(2131764480), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35490);
            am.a(am.this, localca);
            AppMethodBeat.o(35490);
          }
        });
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.NUq, Boolean.FALSE);
        AppMethodBeat.o(35496);
        return;
      }
      bQ(localca);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(35498);
    Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramq.getType());
    this.dom.dismissDialog();
    if (!this.dom.cQp)
    {
      Log.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35498);
      return;
    }
    if (!Util.isTopActivity(this.dom.Pwc.getContext()))
    {
      AppMethodBeat.o(35498);
      return;
    }
    Activity localActivity = this.dom.Pwc.getContext();
    int i;
    if (z.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
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
      com.tencent.mm.ui.widget.snackbar.b.a(this.dom.Pwc.getContext(), this.dom.Pwc.getContentView(), this.dom.Pwc.getMMResources().getString(2131761617), "", null);
      AppMethodBeat.o(35498);
      return;
    }
    if (paramq.getType() == 525)
    {
      Log.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Util.nullAsNil(paramString) });
      localActivity = this.dom.Pwc.getContext();
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = this.dom.Pwc.getMMResources().getString(2131764475);
      }
      com.tencent.mm.ui.base.h.c(localActivity, paramq, this.dom.Pwc.getMMResources().getString(2131764476), true);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(35498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.am
 * JD-Core Version:    0.7.0.1
 */