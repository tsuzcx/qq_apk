package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.v;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w.a;
import com.tencent.mm.ui.x;

@com.tencent.mm.ui.chatting.b.a.a(cFA=v.class)
public class aa
  extends a
  implements f, v
{
  private void aQ(bi parambi)
  {
    com.tencent.mm.ui.chatting.view.b localb = new com.tencent.mm.ui.chatting.view.b(this.byx.vtz.getContext());
    localb.vAD = new aa.2(this, localb, parambi);
    localb.show();
    com.tencent.mm.plugin.report.service.h.nFQ.a(795L, 0L, 1L, false);
  }
  
  public final void cyO()
  {
    au.Dk().a(525, this);
  }
  
  public final void cyR()
  {
    au.Dk().b(525, this);
  }
  
  public final void j(MenuItem paramMenuItem)
  {
    bi localbi = ((g)this.byx.ac(g.class)).GW(paramMenuItem.getGroupId());
    if (localbi == null)
    {
      y.e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    }
    au.Hx();
    if (((Boolean)c.Dz().get(ac.a.upu, Boolean.valueOf(true))).booleanValue())
    {
      com.tencent.mm.ui.base.h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.remind_tip_desc), this.byx.vtz.getMMResources().getString(R.l.remind_tip_title), new aa.1(this, localbi));
      au.Hx();
      c.Dz().c(ac.a.upu, Boolean.valueOf(false));
      return;
    }
    aQ(localbi);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramm.getType());
    this.byx.dismissDialog();
    if (!this.byx.euf) {
      y.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
    }
    label270:
    do
    {
      for (;;)
      {
        return;
        if (bk.bU(this.byx.vtz.getContext()))
        {
          localActivity = this.byx.vtz.getContext();
          int i;
          if (w.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
            i = 1;
          }
          while (i == 0)
          {
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
              break label270;
            }
            switch (paramm.getType())
            {
            default: 
              return;
            }
            y.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
            com.tencent.mm.ui.widget.snackbar.b.a(this.byx.vtz.getContext(), this.byx.vtz.getView(), this.byx.vtz.getMMResources().getString(R.l.has_remind_tip), "");
            return;
            if (w.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
              i = 1;
            } else {
              i = 0;
            }
          }
        }
      }
    } while (paramm.getType() != 525);
    y.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bk.pm(paramString) });
    Activity localActivity = this.byx.vtz.getContext();
    paramm = paramString;
    if (bk.bl(paramString)) {
      paramm = this.byx.vtz.getMMResources().getString(R.l.remind_err_desc);
    }
    com.tencent.mm.ui.base.h.b(localActivity, paramm, this.byx.vtz.getMMResources().getString(R.l.remind_err_title), true);
    com.tencent.mm.plugin.report.service.h.nFQ.a(795L, 4L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.aa
 * JD-Core Version:    0.7.0.1
 */