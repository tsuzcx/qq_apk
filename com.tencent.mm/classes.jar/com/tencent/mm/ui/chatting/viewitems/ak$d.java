package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.s.e;

public final class ak$d
  extends s.e
{
  private int scene;
  
  public ak$d(a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public ak$d(a parama, bu parambu)
  {
    super(parama);
    AppMethodBeat.i(37291);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      a(new bk(parambu, this.JBI.fFv(), 0, this.JBI.fFr(), '\000'));
    }
    AppMethodBeat.o(37291);
  }
  
  private void a(bk parambk)
  {
    AppMethodBeat.i(37293);
    ba.aBQ();
    if (!c.isSDCardAvailable())
    {
      AppMethodBeat.o(37293);
      return;
    }
    ((b)com.tencent.mm.kernel.g.ab(b.class)).ZT(parambk.dBd.field_talker);
    Object localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambk.dBd.field_imgPath);
    if ((localObject == null) || (((EmojiInfo)localObject).Eb()))
    {
      AppMethodBeat.o(37293);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", parambk.dBd.field_imgPath);
    localIntent.putExtra("custom_to_talker_name", parambk.dBd.field_talker);
    if ((((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.OeM) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.OeL) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.OeK)) {
      localIntent.putExtra("custom_smiley_preview_productid", ((EmojiInfo)localObject).field_groupId);
    }
    localIntent.putExtra("msg_id", parambk.dBd.field_msgSvrId);
    localIntent.putExtra("msg_content", parambk.dBd.field_content);
    String str = parambk.dBd.field_talker;
    localObject = str;
    if (w.vF(str))
    {
      localObject = bj.Bk(parambk.dBd.field_content);
      localIntent.putExtra("room_id", this.JBI.getTalkerUserName());
    }
    localIntent.putExtra("msg_sender", (String)localObject);
    localIntent.putExtra("talker_username", this.JBI.getTalkerUserName());
    com.tencent.mm.bs.d.b(this.JBI.JOR.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    com.tencent.mm.plugin.report.service.g.yhR.f(11592, new Object[] { Integer.valueOf(0) });
    AppMethodBeat.o(37293);
  }
  
  public final void a(View paramView, a parama, bu parambu)
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