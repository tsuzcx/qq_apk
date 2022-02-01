package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cci;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.view.c;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

final class TextPreviewUI$5
  implements c.a
{
  TextPreviewUI$5(TextPreviewUI paramTextPreviewUI, c paramc, bv parambv) {}
  
  public final void Ep(long paramLong)
  {
    AppMethodBeat.i(187185);
    this.JZE.hide();
    g.yxI.idkeyStat(795L, 1L, 1L, false);
    if (!NetUtil.isConnected(this.JZD.getContext()))
    {
      h.c(this.JZD.getContext(), this.JZD.getString(2131761535), this.JZD.getString(2131762410), true);
      AppMethodBeat.o(187185);
      return;
    }
    ctx localctx = new ctx();
    localctx.qlc = ((int)(paramLong / 1000L));
    localctx.nJA = 1;
    localctx.Hzh = 1;
    for (;;)
    {
      try
      {
        cci localcci = new cci();
        localcci.nIJ = this.hHv.field_talker;
        localcci.xrk = this.hHv.field_msgSvrId;
        localTextPreviewUI = this.JZD;
        localObject2 = this.hHv;
        if ((!((bv)localObject2).isText()) && (!((bv)localObject2).fvJ())) {
          continue;
        }
        localObject2 = ((ei)localObject2).field_content;
        i = bl.BJ((String)localObject2);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = ((String)localObject2).substring(i + 1).trim();
        }
        localcci.Title = ((String)localObject1);
        localctx.GuM = new b(localcci.toByteArray());
      }
      catch (IOException localIOException)
      {
        TextPreviewUI localTextPreviewUI;
        Object localObject2;
        int i;
        Object localObject1;
        ae.e("MicroMsg.TextPreviewUI", "[onOk] %s", new Object[] { localIOException.toString() });
        continue;
      }
      localObject1 = new z(1, localctx);
      bc.ajj().a((n)localObject1, 0);
      AppMethodBeat.o(187185);
      return;
      if ((((bv)localObject2).fvQ()) || (((bv)localObject2).fvR()))
      {
        localObject1 = ((ei)localObject2).field_content;
        i = ((ei)localObject2).field_content.indexOf(':');
        if (i != -1) {
          localObject1 = ((ei)localObject2).field_content.substring(i + 1);
        }
        if (localObject1 != null)
        {
          localObject1 = k.b.aB((String)localObject1, ((ei)localObject2).field_reserved);
          if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
          {
            localObject1 = ((k.b)localObject1).title;
            continue;
          }
        }
      }
      localObject1 = AllRemindMsgUI.a(localTextPreviewUI.getContext(), ((bv)localObject2).getType(), ((ei)localObject2).field_content, ((ei)localObject2).field_isSend);
      ae.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[] { Long.valueOf(((ei)localObject2).field_msgId), Integer.valueOf(((bv)localObject2).getType()), localObject1 });
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(187186);
    this.JZE.hide();
    AppMethodBeat.o(187186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.5
 * JD-Core Version:    0.7.0.1
 */