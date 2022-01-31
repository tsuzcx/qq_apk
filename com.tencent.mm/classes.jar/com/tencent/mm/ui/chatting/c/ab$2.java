package com.tencent.mm.ui.chatting.c;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.view.b.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

final class ab$2
  implements b.a
{
  ab$2(ab paramab, com.tencent.mm.ui.chatting.view.b paramb, bi parambi) {}
  
  public final void oB(long paramLong)
  {
    AppMethodBeat.i(31595);
    this.zCK.hide();
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(795L, 1L, 1L, false);
    if (!NetUtil.isConnected(this.zHc.caz.zJz.getContext()))
    {
      com.tencent.mm.ui.base.h.b(this.zHc.caz.zJz.getContext(), this.zHc.caz.zJz.getMMResources().getString(2131301788), this.zHc.caz.zJz.getMMResources().getString(2131302507), true);
      AppMethodBeat.o(31595);
      return;
    }
    Object localObject = new btj();
    ((btj)localObject).lGW = ((int)(paramLong / 1000L));
    ((btj)localObject).jKs = 1;
    ((btj)localObject).xCa = 1;
    try
    {
      bfk localbfk = new bfk();
      localbfk.jJA = this.zHc.caz.getTalkerUserName();
      localbfk.pIG = this.fkH.field_msgSvrId;
      localbfk.Title = ab.b(this.zHc, this.fkH);
      ((btj)localObject).wPb = new com.tencent.mm.bv.b(localbfk.toByteArray());
      localObject = new y(1, (btj)localObject);
      aw.Rc().a((m)localObject, 0);
      AppMethodBeat.o(31595);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", new Object[] { localIOException.toString() });
      }
    }
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(31596);
    this.zCK.hide();
    AppMethodBeat.o(31596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ab.2
 * JD-Core Version:    0.7.0.1
 */