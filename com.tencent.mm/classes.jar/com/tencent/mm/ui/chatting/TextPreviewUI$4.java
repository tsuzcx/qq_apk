package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.chatting.view.c;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

final class TextPreviewUI$4
  implements c.a
{
  TextPreviewUI$4(TextPreviewUI paramTextPreviewUI, c paramc, bo parambo) {}
  
  public final void Bc(long paramLong)
  {
    AppMethodBeat.i(34932);
    this.HQX.hide();
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(795L, 1L, 1L, false);
    if (!NetUtil.isConnected(this.HQW.getContext()))
    {
      com.tencent.mm.ui.base.h.c(this.HQW.getContext(), this.HQW.getString(2131761535), this.HQW.getString(2131762410), true);
      AppMethodBeat.o(34932);
      return;
    }
    coa localcoa = new coa();
    localcoa.pAS = ((int)(paramLong / 1000L));
    localcoa.ndI = 1;
    localcoa.FvC = 1;
    for (;;)
    {
      try
      {
        bwy localbwy = new bwy();
        localbwy.ncR = this.hmq.field_talker;
        localbwy.vTQ = this.hmq.field_msgSvrId;
        localTextPreviewUI = this.HQW;
        localObject2 = this.hmq;
        if ((!((bo)localObject2).isText()) && (!((bo)localObject2).fbF())) {
          continue;
        }
        localObject2 = ((dy)localObject2).field_content;
        i = bi.yi((String)localObject2);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = ((String)localObject2).substring(i + 1).trim();
        }
        localbwy.Title = ((String)localObject1);
        localcoa.EuL = new b(localbwy.toByteArray());
      }
      catch (IOException localIOException)
      {
        TextPreviewUI localTextPreviewUI;
        Object localObject2;
        int i;
        Object localObject1;
        ac.e("MicroMsg.TextPreviewUI", "[onOk] %s", new Object[] { localIOException.toString() });
        continue;
      }
      localObject1 = new y(1, localcoa);
      az.agi().a((n)localObject1, 0);
      AppMethodBeat.o(34932);
      return;
      if ((((bo)localObject2).fbM()) || (((bo)localObject2).fbN()))
      {
        localObject1 = ((dy)localObject2).field_content;
        i = ((dy)localObject2).field_content.indexOf(':');
        if (i != -1) {
          localObject1 = ((dy)localObject2).field_content.substring(i + 1);
        }
        if (localObject1 != null)
        {
          localObject1 = k.b.az((String)localObject1, ((dy)localObject2).field_reserved);
          if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
          {
            localObject1 = ((k.b)localObject1).title;
            continue;
          }
        }
      }
      localObject1 = AllRemindMsgUI.a(localTextPreviewUI.getContext(), ((bo)localObject2).getType(), ((dy)localObject2).field_content, ((dy)localObject2).field_isSend);
      ac.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[] { Long.valueOf(((dy)localObject2).field_msgId), Integer.valueOf(((bo)localObject2).getType()), localObject1 });
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(34933);
    this.HQX.hide();
    AppMethodBeat.o(34933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.4
 * JD-Core Version:    0.7.0.1
 */