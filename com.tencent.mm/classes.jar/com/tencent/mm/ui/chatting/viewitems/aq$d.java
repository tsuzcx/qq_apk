package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.e;

public final class aq$d
  extends t.e
{
  private int scene;
  
  public aq$d(a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public aq$d(a parama, ca paramca)
  {
    super(parama);
    AppMethodBeat.i(37291);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      a(new bq(paramca, this.PhN.gRM(), 0, this.PhN.gRI(), '\000'));
    }
    AppMethodBeat.o(37291);
  }
  
  private void a(bq parambq)
  {
    AppMethodBeat.i(37293);
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      AppMethodBeat.o(37293);
      return;
    }
    ((b)g.af(b.class)).akR(parambq.dTX.field_talker);
    Object localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(parambq.dTX.field_imgPath);
    if ((localObject == null) || (((EmojiInfo)localObject).NA()))
    {
      AppMethodBeat.o(37293);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", parambq.dTX.field_imgPath);
    localIntent.putExtra("custom_to_talker_name", parambq.dTX.field_talker);
    if ((((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.Uuo) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.Uun) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.Uum)) {
      localIntent.putExtra("custom_smiley_preview_productid", ((EmojiInfo)localObject).field_groupId);
    }
    localIntent.putExtra("msg_id", parambq.dTX.field_msgSvrId);
    localIntent.putExtra("msg_content", parambq.dTX.field_content);
    String str = parambq.dTX.field_talker;
    localObject = str;
    if (ab.Eq(str))
    {
      localObject = bp.Ks(parambq.dTX.field_content);
      localIntent.putExtra("room_id", this.PhN.getTalkerUserName());
    }
    localIntent.putExtra("msg_sender", (String)localObject);
    localIntent.putExtra("talker_username", this.PhN.getTalkerUserName());
    com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    h.CyF.a(11592, new Object[] { Integer.valueOf(0) });
    AppMethodBeat.o(37293);
  }
  
  public final void a(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37292);
    a((bq)paramView.getTag());
    AppMethodBeat.o(37292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.d
 * JD-Core Version:    0.7.0.1
 */