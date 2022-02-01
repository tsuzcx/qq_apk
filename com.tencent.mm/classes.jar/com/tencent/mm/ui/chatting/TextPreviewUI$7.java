package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.bx.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.drn;
import com.tencent.mm.protocal.protobuf.epi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.view.c;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

final class TextPreviewUI$7
  implements c.a
{
  TextPreviewUI$7(TextPreviewUI paramTextPreviewUI, c paramc, cc paramcc) {}
  
  public final void onCancel()
  {
    AppMethodBeat.i(253694);
    this.aemk.hide();
    AppMethodBeat.o(253694);
  }
  
  public final void zJ(long paramLong)
  {
    AppMethodBeat.i(253688);
    this.aemk.hide();
    h.OAn.idkeyStat(795L, 1L, 1L, false);
    if (!NetUtil.isConnected(this.aemj.getContext()))
    {
      k.c(this.aemj.getContext(), this.aemj.getString(R.l.net_warn_no_network), this.aemj.getString(R.l.gTf), true);
      AppMethodBeat.o(253688);
      return;
    }
    epi localepi = new epi();
    localepi.crm = ((int)(paramLong / 1000L));
    localepi.vhJ = 1;
    localepi.abmA = 1;
    for (;;)
    {
      try
      {
        drn localdrn = new drn();
        localdrn.UserName = this.oiL.field_talker;
        localdrn.Njv = this.oiL.field_msgSvrId;
        localTextPreviewUI = this.aemj;
        localObject2 = this.oiL;
        if ((!((cc)localObject2).iYl()) && (!((cc)localObject2).jbJ())) {
          continue;
        }
        localObject2 = ((fi)localObject2).field_content;
        i = br.JG((String)localObject2);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = ((String)localObject2).substring(i + 1).trim();
        }
        localdrn.hAP = ((String)localObject1);
        localepi.ZqS = new b(localdrn.toByteArray());
      }
      catch (IOException localIOException)
      {
        TextPreviewUI localTextPreviewUI;
        Object localObject2;
        int i;
        Object localObject1;
        Log.e("MicroMsg.TextPreviewUI", "[onOk] %s", new Object[] { localIOException.toString() });
        continue;
      }
      localObject1 = new aa(1, localepi);
      bh.aZW().a((p)localObject1, 0);
      AppMethodBeat.o(253688);
      return;
      if ((((cc)localObject2).jbR()) || (((cc)localObject2).jbS()))
      {
        localObject1 = ((fi)localObject2).field_content;
        i = ((fi)localObject2).field_content.indexOf(':');
        if (i != -1) {
          localObject1 = ((fi)localObject2).field_content.substring(i + 1);
        }
        if (localObject1 != null)
        {
          localObject1 = k.b.aP((String)localObject1, ((fi)localObject2).field_reserved);
          if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
          {
            localObject1 = ((k.b)localObject1).title;
            continue;
          }
        }
      }
      localObject1 = AllRemindMsgUI.a(localTextPreviewUI.getContext(), ((cc)localObject2).getType(), ((fi)localObject2).field_content, ((fi)localObject2).field_isSend);
      Log.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[] { Long.valueOf(((fi)localObject2).field_msgId), Integer.valueOf(((cc)localObject2).getType()), localObject1 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.7
 * JD-Core Version:    0.7.0.1
 */