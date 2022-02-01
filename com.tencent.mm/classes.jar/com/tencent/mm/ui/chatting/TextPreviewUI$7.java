package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.chatting.view.c;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

final class TextPreviewUI$7
  implements c.a
{
  TextPreviewUI$7(TextPreviewUI paramTextPreviewUI, c paramc, ca paramca) {}
  
  public final void VB(long paramLong)
  {
    AppMethodBeat.i(290213);
    this.WEK.hide();
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(795L, 1L, 1L, false);
    if (!NetUtil.isConnected(this.WEJ.getContext()))
    {
      com.tencent.mm.ui.base.h.c(this.WEJ.getContext(), this.WEJ.getString(R.l.net_warn_no_network), this.WEJ.getString(R.l.eQz), true);
      AppMethodBeat.o(290213);
      return;
    }
    dwe localdwe = new dwe();
    localdwe.vhF = ((int)(paramLong / 1000L));
    localdwe.rWu = 1;
    localdwe.TVM = 1;
    for (;;)
    {
      try
      {
        daf localdaf = new daf();
        localdaf.UserName = this.lrk.field_talker;
        localdaf.HlH = this.lrk.field_msgSvrId;
        localTextPreviewUI = this.WEJ;
        localObject2 = this.lrk;
        if ((!((ca)localObject2).hwH()) && (!((ca)localObject2).hzE())) {
          continue;
        }
        localObject2 = ((et)localObject2).field_content;
        i = bq.RI((String)localObject2);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = ((String)localObject2).substring(i + 1).trim();
        }
        localdaf.fwr = ((String)localObject1);
        localdwe.SrO = new b(localdaf.toByteArray());
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
      localObject1 = new z(1, localdwe);
      bh.aGY().a((q)localObject1, 0);
      AppMethodBeat.o(290213);
      return;
      if ((((ca)localObject2).hzM()) || (((ca)localObject2).hzN()))
      {
        localObject1 = ((et)localObject2).field_content;
        i = ((et)localObject2).field_content.indexOf(':');
        if (i != -1) {
          localObject1 = ((et)localObject2).field_content.substring(i + 1);
        }
        if (localObject1 != null)
        {
          localObject1 = k.b.aG((String)localObject1, ((et)localObject2).field_reserved);
          if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
          {
            localObject1 = ((k.b)localObject1).title;
            continue;
          }
        }
      }
      localObject1 = AllRemindMsgUI.a(localTextPreviewUI.getContext(), ((ca)localObject2).getType(), ((et)localObject2).field_content, ((et)localObject2).field_isSend);
      Log.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[] { Long.valueOf(((et)localObject2).field_msgId), Integer.valueOf(((ca)localObject2).getType()), localObject1 });
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(290214);
    this.WEK.hide();
    AppMethodBeat.o(290214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.7
 * JD-Core Version:    0.7.0.1
 */