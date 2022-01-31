package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.e;

public final class z$d
  extends s.e
{
  public z$d(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    AppMethodBeat.i(33201);
    parambi = (az)paramView.getTag();
    aw.aaz();
    if (c.isSDCardAvailable())
    {
      paramView = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.cEE.field_imgPath);
      if ((paramView == null) || (paramView.vY()))
      {
        AppMethodBeat.o(33201);
        return;
      }
      parama = new Intent();
      parama.putExtra("custom_smiley_preview_md5", parambi.cEE.field_imgPath);
      parama.putExtra("custom_to_talker_name", parambi.cEE.field_talker);
      if ((paramView.field_catalog != EmojiGroupInfo.yPf) && (paramView.field_catalog != EmojiGroupInfo.yPe) && (paramView.field_catalog != EmojiGroupInfo.yPd)) {
        parama.putExtra("custom_smiley_preview_productid", paramView.field_groupId);
      }
      parama.putExtra("msg_id", parambi.cEE.field_msgSvrId);
      parama.putExtra("msg_content", parambi.cEE.field_content);
      paramView = parambi.cEE.field_talker;
      if (!t.lA(paramView)) {
        break label266;
      }
      paramView = bf.pu(parambi.cEE.field_content);
      parama.putExtra("room_id", this.zzP.getTalkerUserName());
    }
    label266:
    for (;;)
    {
      parama.putExtra("msg_sender", paramView);
      com.tencent.mm.bq.d.b(this.zzP.zJz.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", parama, 1111);
      h.qsU.e(11592, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(33201);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.d
 * JD-Core Version:    0.7.0.1
 */