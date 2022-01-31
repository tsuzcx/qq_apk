package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.view.b.a;
import com.tencent.mm.ui.s;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

final class TextPreviewUI$4
  implements b.a
{
  TextPreviewUI$4(TextPreviewUI paramTextPreviewUI, com.tencent.mm.ui.chatting.view.b paramb, bi parambi) {}
  
  public final void hP(long paramLong)
  {
    this.vno.hide();
    com.tencent.mm.plugin.report.service.h.nFQ.a(795L, 1L, 1L, false);
    if (!NetUtil.isConnected(this.vnn.mController.uMN))
    {
      com.tencent.mm.ui.base.h.b(this.vnn.mController.uMN, this.vnn.getString(R.l.net_warn_no_network), this.vnn.getString(R.l.remind_err_title), true);
      return;
    }
    bkj localbkj = new bkj();
    localbkj.jxx = ((int)(paramLong / 1000L));
    localbkj.hQR = 1;
    localbkj.tAu = 1;
    for (;;)
    {
      try
      {
        ayn localayn = new ayn();
        localayn.hPY = this.dUy.field_talker;
        localayn.ndp = this.dUy.field_msgSvrId;
        localObject1 = this.vnn;
        localObject2 = this.dUy;
        if ((!((bi)localObject2).isText()) && (!((bi)localObject2).cvq())) {
          continue;
        }
        localObject2 = ((cs)localObject2).field_content;
        i = bd.iH((String)localObject2);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = ((String)localObject2).substring(i + 1).trim();
        }
        localayn.bGw = ((String)localObject1);
        localbkj.sQA = new com.tencent.mm.bv.b(localayn.toByteArray());
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        Object localObject2;
        int i;
        String str1;
        String str2;
        y.e("MicroMsg.TextPreviewUI", "[onOk] %s", new Object[] { localIOException.toString() });
        continue;
      }
      localObject1 = new x(1, localbkj);
      au.Dk().a((m)localObject1, 0);
      return;
      localObject1 = ((MMActivity)localObject1).mController.uMN;
      i = ((bi)localObject2).getType();
      str1 = ((cs)localObject2).field_content;
      str2 = ((cs)localObject2).field_talker;
      localObject1 = AllRemindMsgUI.a((Context)localObject1, i, str1, ((cs)localObject2).field_isSend);
      y.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[] { Long.valueOf(((cs)localObject2).field_msgId), Integer.valueOf(((bi)localObject2).getType()), localObject1 });
    }
  }
  
  public final void onCancel()
  {
    this.vno.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.4
 * JD-Core Version:    0.7.0.1
 */