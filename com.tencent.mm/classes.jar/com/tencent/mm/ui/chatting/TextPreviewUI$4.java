package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.chatting.view.c;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

final class TextPreviewUI$4
  implements c.a
{
  TextPreviewUI$4(TextPreviewUI paramTextPreviewUI, c paramc, bl parambl) {}
  
  public final void onCancel()
  {
    AppMethodBeat.i(34933);
    this.Grf.hide();
    AppMethodBeat.o(34933);
  }
  
  public final void wz(long paramLong)
  {
    AppMethodBeat.i(34932);
    this.Grf.hide();
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(795L, 1L, 1L, false);
    if (!NetUtil.isConnected(this.Gre.getContext()))
    {
      com.tencent.mm.ui.base.h.c(this.Gre.getContext(), this.Gre.getString(2131761535), this.Gre.getString(2131762410), true);
      AppMethodBeat.o(34932);
      return;
    }
    cit localcit = new cit();
    localcit.oXH = ((int)(paramLong / 1000L));
    localcit.mBH = 1;
    localcit.DYI = 1;
    for (;;)
    {
      try
      {
        bsh localbsh = new bsh();
        localbsh.mAQ = this.gLQ.field_talker;
        localbsh.uKZ = this.gLQ.field_msgSvrId;
        localTextPreviewUI = this.Gre;
        localObject2 = this.gLQ;
        if ((!((bl)localObject2).isText()) && (!((bl)localObject2).eMa())) {
          continue;
        }
        localObject2 = ((du)localObject2).field_content;
        i = bi.uc((String)localObject2);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = ((String)localObject2).substring(i + 1).trim();
        }
        localbsh.Title = ((String)localObject1);
        localcit.DbF = new b(localbsh.toByteArray());
      }
      catch (IOException localIOException)
      {
        TextPreviewUI localTextPreviewUI;
        Object localObject2;
        int i;
        Object localObject1;
        ad.e("MicroMsg.TextPreviewUI", "[onOk] %s", new Object[] { localIOException.toString() });
        continue;
      }
      localObject1 = new y(1, localcit);
      az.aeS().a((n)localObject1, 0);
      AppMethodBeat.o(34932);
      return;
      if ((((bl)localObject2).eMh()) || (((bl)localObject2).eMi()))
      {
        localObject1 = ((du)localObject2).field_content;
        i = ((du)localObject2).field_content.indexOf(':');
        if (i != -1) {
          localObject1 = ((du)localObject2).field_content.substring(i + 1);
        }
        if (localObject1 != null)
        {
          localObject1 = k.b.ar((String)localObject1, ((du)localObject2).field_reserved);
          if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
          {
            localObject1 = ((k.b)localObject1).title;
            continue;
          }
        }
      }
      localObject1 = AllRemindMsgUI.a(localTextPreviewUI.getContext(), ((bl)localObject2).getType(), ((du)localObject2).field_content, ((du)localObject2).field_isSend);
      ad.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[] { Long.valueOf(((du)localObject2).field_msgId), Integer.valueOf(((bl)localObject2).getType()), localObject1 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.4
 * JD-Core Version:    0.7.0.1
 */