package com.tencent.mm.ui.chatting.b;

import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.view.b.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

final class aa$2
  implements b.a
{
  aa$2(aa paramaa, com.tencent.mm.ui.chatting.view.b paramb, bi parambi) {}
  
  public final void hP(long paramLong)
  {
    this.vno.hide();
    com.tencent.mm.plugin.report.service.h.nFQ.a(795L, 1L, 1L, false);
    if (!NetUtil.isConnected(this.vrx.byx.vtz.getContext()))
    {
      com.tencent.mm.ui.base.h.b(this.vrx.byx.vtz.getContext(), this.vrx.byx.vtz.getMMResources().getString(R.l.net_warn_no_network), this.vrx.byx.vtz.getMMResources().getString(R.l.remind_err_title), true);
      return;
    }
    Object localObject = new bkj();
    ((bkj)localObject).jxx = ((int)(paramLong / 1000L));
    ((bkj)localObject).hQR = 1;
    ((bkj)localObject).tAu = 1;
    try
    {
      ayn localayn = new ayn();
      localayn.hPY = this.vrx.byx.getTalkerUserName();
      localayn.ndp = this.dUy.field_msgSvrId;
      localayn.bGw = aa.b(this.vrx, this.dUy);
      ((bkj)localObject).sQA = new com.tencent.mm.bv.b(localayn.toByteArray());
      localObject = new x(1, (bkj)localObject);
      au.Dk().a((m)localObject, 0);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", new Object[] { localIOException.toString() });
      }
    }
  }
  
  public final void onCancel()
  {
    this.vno.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.aa.2
 * JD-Core Version:    0.7.0.1
 */