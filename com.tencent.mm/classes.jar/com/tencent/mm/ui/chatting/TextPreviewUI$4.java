package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.chatting.view.b.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

final class TextPreviewUI$4
  implements b.a
{
  TextPreviewUI$4(TextPreviewUI paramTextPreviewUI, com.tencent.mm.ui.chatting.view.b paramb, bi parambi) {}
  
  public final void oB(long paramLong)
  {
    AppMethodBeat.i(31046);
    this.zCK.hide();
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(795L, 1L, 1L, false);
    if (!NetUtil.isConnected(this.zCJ.getContext()))
    {
      com.tencent.mm.ui.base.h.b(this.zCJ.getContext(), this.zCJ.getString(2131301788), this.zCJ.getString(2131302507), true);
      AppMethodBeat.o(31046);
      return;
    }
    btj localbtj = new btj();
    localbtj.lGW = ((int)(paramLong / 1000L));
    localbtj.jKs = 1;
    localbtj.xCa = 1;
    for (;;)
    {
      try
      {
        bfk localbfk = new bfk();
        localbfk.jJA = this.fkH.field_talker;
        localbfk.pIG = this.fkH.field_msgSvrId;
        localObject1 = this.zCJ;
        localObject2 = this.fkH;
        if ((!((bi)localObject2).isText()) && (!((bi)localObject2).dxU())) {
          continue;
        }
        localObject2 = ((dd)localObject2).field_content;
        int i = bf.pt((String)localObject2);
        localObject1 = localObject2;
        if (i != -1) {
          localObject1 = ((String)localObject2).substring(i + 1).trim();
        }
        localbfk.Title = ((String)localObject1);
        localbtj.wPb = new com.tencent.mm.bv.b(localbfk.toByteArray());
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        Object localObject2;
        ab.e("MicroMsg.TextPreviewUI", "[onOk] %s", new Object[] { localIOException.toString() });
        continue;
      }
      localObject1 = new y(1, localbtj);
      aw.Rc().a((m)localObject1, 0);
      AppMethodBeat.o(31046);
      return;
      localObject1 = AllRemindMsgUI.a(((TextPreviewUI)localObject1).getContext(), ((bi)localObject2).getType(), ((dd)localObject2).field_content, ((dd)localObject2).field_isSend);
      ab.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[] { Long.valueOf(((dd)localObject2).field_msgId), Integer.valueOf(((bi)localObject2).getType()), localObject1 });
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(31047);
    this.zCK.hide();
    AppMethodBeat.o(31047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.4
 * JD-Core Version:    0.7.0.1
 */