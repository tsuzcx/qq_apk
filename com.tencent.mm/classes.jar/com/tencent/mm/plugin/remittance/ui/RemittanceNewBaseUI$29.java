package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.gu;
import com.tencent.mm.f.a.gu.a;
import com.tencent.mm.plugin.remittance.model.ak;
import com.tencent.mm.plugin.remittance.model.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

final class RemittanceNewBaseUI$29
  extends IListener<gu>
{
  RemittanceNewBaseUI$29(RemittanceNewBaseUI paramRemittanceNewBaseUI)
  {
    AppMethodBeat.i(160850);
    this.__eventId = gu.class.getName().hashCode();
    AppMethodBeat.o(160850);
  }
  
  private boolean a(gu paramgu)
  {
    int j = 1;
    AppMethodBeat.i(271443);
    String str = paramgu.fDj.fwv;
    RemittanceNewBaseUI.a(this.IuE, str, paramgu.fDj.fww);
    if (paramgu.fDj.isKinda)
    {
      Log.f("MicroMsg.RemittanceNewBaseUI", "F2fPayCheckEvent is from kinda");
      this.IuE.Iru = false;
      MMHandlerThread.postToMainThreadDelayed(RemittanceNewBaseUI.r(this.IuE), 300L);
      if (paramgu.fDj.fwx == 1)
      {
        RemittanceNewBaseUI.a(this.IuE, str, paramgu.fDj.fww);
        if (paramgu.fDj.fDk == this.IuE.getContext().hashCode()) {
          if (!Util.isNullOrNil(this.IuE.auA))
          {
            com.tencent.mm.plugin.remittance.a.c.fzJ().fzM().aA(RemittanceNewBaseUI.s(this.IuE), this.IuE.auA, this.IuE.iSn);
            if (RemittanceNewBaseUI.t(this.IuE) > 0L)
            {
              if (Util.isNullOrNil(this.IuE.auA)) {
                break label304;
              }
              f.Iln.a(this.IuE.auA, RemittanceNewBaseUI.t(this.IuE), RemittanceNewBaseUI.u(this.IuE), RemittanceNewBaseUI.s(this.IuE), RemittanceNewBaseUI.v(this.IuE));
            }
          }
        }
      }
      label304:
      while (paramgu.fDj.fwx != 2) {
        for (;;)
        {
          AppMethodBeat.o(271443);
          return false;
          com.tencent.mm.plugin.remittance.a.c.fzJ().fzM().kd(RemittanceNewBaseUI.s(this.IuE), this.IuE.iSn);
          continue;
          Log.w("MicroMsg.RemittanceNewBaseUI", "callback to wrong page: %s, %s", new Object[] { Integer.valueOf(paramgu.fDj.fDk), Integer.valueOf(this.IuE.getContext().hashCode()) });
          continue;
          f.Iln.a(this.IuE.iSn, RemittanceNewBaseUI.t(this.IuE), RemittanceNewBaseUI.u(this.IuE), RemittanceNewBaseUI.s(this.IuE), RemittanceNewBaseUI.v(this.IuE));
        }
      }
      i = j;
      if (this.IuE.mScene != 2) {
        if (this.IuE.mScene != 5) {
          break label462;
        }
      }
    }
    label462:
    for (int i = j;; i = 0)
    {
      if ((!Util.isNullOrNil(this.IuE.iSn)) && (i == 0))
      {
        paramgu = new Intent();
        paramgu.putExtra("Chat_User", this.IuE.iSn);
        paramgu.putExtra("finish_direct", false);
        com.tencent.mm.by.c.f(this.IuE, ".ui.chatting.ChattingUI", paramgu);
        break;
      }
      this.IuE.finish();
      break;
      AppMethodBeat.o(271443);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.29
 * JD-Core Version:    0.7.0.1
 */