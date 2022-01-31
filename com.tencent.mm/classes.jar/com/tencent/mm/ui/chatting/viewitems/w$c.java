package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.t.d;

public final class w$c
  extends t.d
{
  public w$c(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    parambi = (aw)paramView.getTag();
    au.Hx();
    if (c.isSDCardAvailable())
    {
      paramView = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.bWO.field_imgPath);
      if ((paramView != null) && (!paramView.ZH())) {}
    }
    else
    {
      return;
    }
    parama = new Intent();
    parama.putExtra("custom_smiley_preview_md5", parambi.bWO.field_imgPath);
    parama.putExtra("custom_to_talker_name", parambi.bWO.field_talker);
    if ((paramView.field_catalog != EmojiGroupInfo.uCS) && (paramView.field_catalog != EmojiGroupInfo.uCR) && (paramView.field_catalog != EmojiGroupInfo.uCQ)) {
      parama.putExtra("custom_smiley_preview_productid", paramView.field_groupId);
    }
    parama.putExtra("msg_id", parambi.bWO.field_msgSvrId);
    parama.putExtra("msg_content", parambi.bWO.field_content);
    paramView = parambi.bWO.field_talker;
    if (s.fn(paramView))
    {
      paramView = bd.iI(parambi.bWO.field_content);
      parama.putExtra("room_id", this.vko.getTalkerUserName());
    }
    for (;;)
    {
      parama.putExtra("msg_sender", paramView);
      com.tencent.mm.br.d.b(this.vko.vtz.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", parama);
      h.nFQ.f(11592, new Object[] { Integer.valueOf(0) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w.c
 * JD-Core Version:    0.7.0.1
 */