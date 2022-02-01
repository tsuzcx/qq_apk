package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.e;

public final class ai$d
  extends s.e
{
  private int scene;
  
  public ai$d(a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public ai$d(a parama, bl parambl)
  {
    super(parama);
    AppMethodBeat.i(37291);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      a(new bi(parambl, this.Gob.eZb(), 0, this.Gob.eYX(), '\000'));
    }
    AppMethodBeat.o(37291);
  }
  
  private void a(bi parambi)
  {
    AppMethodBeat.i(37293);
    az.arV();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(37293);
      return;
    }
    ((b)g.ab(b.class)).Sa(parambi.drF.field_talker);
    Object localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambi.drF.field_imgPath);
    if ((localObject == null) || (((EmojiInfo)localObject).CZ()))
    {
      AppMethodBeat.o(37293);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", parambi.drF.field_imgPath);
    localIntent.putExtra("custom_to_talker_name", parambi.drF.field_talker);
    if ((((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.LBP) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.LBO) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.LBN)) {
      localIntent.putExtra("custom_smiley_preview_productid", ((EmojiInfo)localObject).field_groupId);
    }
    localIntent.putExtra("msg_id", parambi.drF.field_msgSvrId);
    localIntent.putExtra("msg_content", parambi.drF.field_content);
    String str = parambi.drF.field_talker;
    localObject = str;
    if (w.pF(str))
    {
      localObject = com.tencent.mm.model.bi.uf(parambi.drF.field_content);
      localIntent.putExtra("room_id", this.Gob.getTalkerUserName());
    }
    localIntent.putExtra("msg_sender", (String)localObject);
    localIntent.putExtra("talker_username", this.Gob.getTalkerUserName());
    com.tencent.mm.bs.d.b(this.Gob.GzJ.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    h.vKh.f(11592, new Object[] { Integer.valueOf(0) });
    AppMethodBeat.o(37293);
  }
  
  public final void a(View paramView, a parama, bl parambl)
  {
    AppMethodBeat.i(37292);
    a((bi)paramView.getTag());
    AppMethodBeat.o(37292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.d
 * JD-Core Version:    0.7.0.1
 */