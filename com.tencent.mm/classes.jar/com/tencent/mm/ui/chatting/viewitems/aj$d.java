package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.e;

public final class aj$d
  extends s.e
{
  private int scene;
  
  public aj$d(a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public aj$d(a parama, bo parambo)
  {
    super(parama);
    AppMethodBeat.i(37291);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      a(new bj(parambo, this.HNS.foQ(), 0, this.HNS.foM(), '\000'));
    }
    AppMethodBeat.o(37291);
  }
  
  private void a(bj parambj)
  {
    AppMethodBeat.i(37293);
    az.ayM();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(37293);
      return;
    }
    ((b)g.ab(b.class)).Wm(parambj.dpq.field_talker);
    Object localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambj.dpq.field_imgPath);
    if ((localObject == null) || (((EmojiInfo)localObject).CC()))
    {
      AppMethodBeat.o(37293);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", parambj.dpq.field_imgPath);
    localIntent.putExtra("custom_to_talker_name", parambj.dpq.field_talker);
    if ((((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.Jsr) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.Jsq) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.Jsp)) {
      localIntent.putExtra("custom_smiley_preview_productid", ((EmojiInfo)localObject).field_groupId);
    }
    localIntent.putExtra("msg_id", parambj.dpq.field_msgSvrId);
    localIntent.putExtra("msg_content", parambj.dpq.field_content);
    String str = parambj.dpq.field_talker;
    localObject = str;
    if (w.sQ(str))
    {
      localObject = bi.yl(parambj.dpq.field_content);
      localIntent.putExtra("room_id", this.HNS.getTalkerUserName());
    }
    localIntent.putExtra("msg_sender", (String)localObject);
    localIntent.putExtra("talker_username", this.HNS.getTalkerUserName());
    com.tencent.mm.br.d.b(this.HNS.HZF.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    h.wUl.f(11592, new Object[] { Integer.valueOf(0) });
    AppMethodBeat.o(37293);
  }
  
  public final void a(View paramView, a parama, bo parambo)
  {
    AppMethodBeat.i(37292);
    a((bj)paramView.getTag());
    AppMethodBeat.o(37292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.d
 * JD-Core Version:    0.7.0.1
 */