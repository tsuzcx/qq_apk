package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.e;

public final class ak$d
  extends t.e
{
  private int scene;
  
  public ak$d(a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public ak$d(a parama, bv parambv)
  {
    super(parama);
    AppMethodBeat.i(37291);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      a(new bk(parambv, this.JWz.fJC(), 0, this.JWz.fJy(), '\000'));
    }
    AppMethodBeat.o(37291);
  }
  
  private void a(bk parambk)
  {
    AppMethodBeat.i(37293);
    bc.aCg();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(37293);
      return;
    }
    ((b)com.tencent.mm.kernel.g.ab(b.class)).aaK(parambk.dCi.field_talker);
    Object localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambk.dCi.field_imgPath);
    if ((localObject == null) || (((EmojiInfo)localObject).Ee()))
    {
      AppMethodBeat.o(37293);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", parambk.dCi.field_imgPath);
    localIntent.putExtra("custom_to_talker_name", parambk.dCi.field_talker);
    if ((((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.OzT) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.OzS) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.OzR)) {
      localIntent.putExtra("custom_smiley_preview_productid", ((EmojiInfo)localObject).field_groupId);
    }
    localIntent.putExtra("msg_id", parambk.dCi.field_msgSvrId);
    localIntent.putExtra("msg_content", parambk.dCi.field_content);
    String str = parambk.dCi.field_talker;
    localObject = str;
    if (x.wb(str))
    {
      localObject = bl.BM(parambk.dCi.field_content);
      localIntent.putExtra("room_id", this.JWz.getTalkerUserName());
    }
    localIntent.putExtra("msg_sender", (String)localObject);
    localIntent.putExtra("talker_username", this.JWz.getTalkerUserName());
    com.tencent.mm.br.d.b(this.JWz.Kkd.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    com.tencent.mm.plugin.report.service.g.yxI.f(11592, new Object[] { Integer.valueOf(0) });
    AppMethodBeat.o(37293);
  }
  
  public final void a(View paramView, a parama, bv parambv)
  {
    AppMethodBeat.i(37292);
    a((bk)paramView.getTag());
    AppMethodBeat.o(37292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.d
 * JD-Core Version:    0.7.0.1
 */