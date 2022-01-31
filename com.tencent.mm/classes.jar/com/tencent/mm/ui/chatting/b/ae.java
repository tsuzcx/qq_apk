package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.an.a;
import com.tencent.mm.ui.chatting.b.b.x;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w.a;

@com.tencent.mm.ui.chatting.b.a.a(cFA=x.class)
public class ae
  extends a
  implements f, x
{
  private final com.tencent.mm.sdk.b.c dji = new an(an.a.vmL, null);
  private com.tencent.mm.ui.widget.a.c vrK = null;
  
  public final void aY(bi parambi)
  {
    t localt = new t(parambi, this.byx.vtz.getMMResources().getString(R.l.chatting_revoke_msg_tips));
    this.byx.d(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.chatting_revoke_msg_loading), new ae.1(this, parambi, localt));
    au.Dk().a(localt, 0);
  }
  
  public final void cyO()
  {
    au.Dk().a(594, this);
  }
  
  public final void cyP()
  {
    if (!com.tencent.mm.sdk.b.a.udP.e(this.dji)) {
      com.tencent.mm.sdk.b.a.udP.c(this.dji);
    }
  }
  
  public final void cyQ()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.dji);
  }
  
  public final void cyR()
  {
    au.Dk().b(594, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramm.getType());
    this.byx.dismissDialog();
    if (this.vrK != null)
    {
      this.vrK.dismiss();
      this.vrK = null;
    }
    if (!this.byx.euf) {
      y.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
    }
    label293:
    label295:
    do
    {
      for (;;)
      {
        return;
        if (bk.bU(this.byx.vtz.getContext()))
        {
          Activity localActivity = this.byx.vtz.getContext();
          int i;
          if (w.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label293;
            }
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
              break label295;
            }
            switch (paramm.getType())
            {
            default: 
              return;
            }
            paramString = ((t)paramm).QN();
            if (bk.bl(paramString.tFF)) {
              break;
            }
            h.a(this.byx.vtz.getContext(), paramString.tFF, "", this.byx.vtz.getMMResources().getString(R.l.chatting_revoke_msg_dialog_confirm), new ae.2(this));
            return;
            if (w.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
              i = 1;
            } else {
              i = 0;
            }
          }
        }
      }
    } while (paramm.getType() != 594);
    paramString = ((t)paramm).QN();
    y.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", new Object[] { paramString.tFG });
    if ((paramInt2 != 0) && (!bk.bl(paramString.tFG))) {}
    for (paramInt1 = 0; paramInt1 == 0; paramInt1 = 1)
    {
      y.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", new Object[] { paramString.tFG });
      this.vrK = h.a(this.byx.vtz.getContext(), paramString.tFG, "", this.byx.vtz.getMMResources().getString(R.l.chatting_revoke_msg_dialog_confirm), new ae.3(this));
      return;
    }
    y.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", new Object[] { Integer.valueOf(paramInt2), paramString.tFG });
    this.vrK = h.a(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.chatting_revoke_msg_dialog_failure), "", this.byx.vtz.getMMResources().getString(R.l.chatting_revoke_msg_dialog_confirm), new ae.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ae
 * JD-Core Version:    0.7.0.1
 */