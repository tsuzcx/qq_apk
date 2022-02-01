package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.e;

public final class at$d
  extends t.e
{
  private int scene;
  
  public at$d(a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public at$d(a parama, ca paramca)
  {
    super(parama);
    AppMethodBeat.i(37291);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      a(new by(paramca, this.WBq.hRi(), 0, this.WBq.getSelfUserName(), '\000'));
    }
    AppMethodBeat.o(37291);
  }
  
  private void a(by paramby)
  {
    AppMethodBeat.i(37293);
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      AppMethodBeat.o(37293);
      return;
    }
    ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(paramby.fNz.field_talker);
    Object localObject = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramby.fNz.field_imgPath);
    if ((localObject == null) || (((EmojiInfo)localObject).Qv()))
    {
      AppMethodBeat.o(37293);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", paramby.fNz.field_imgPath);
    localIntent.putExtra("custom_to_talker_name", paramby.fNz.field_talker);
    if ((((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.YCw) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.YCv) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.YCu)) {
      localIntent.putExtra("custom_smiley_preview_productid", ((EmojiInfo)localObject).field_groupId);
    }
    localIntent.putExtra("msg_id", paramby.fNz.field_msgSvrId);
    localIntent.putExtra("msg_content", paramby.fNz.field_content);
    String str = paramby.fNz.field_talker;
    localObject = str;
    if (ab.Lj(str))
    {
      localObject = bq.RL(paramby.fNz.field_content);
      localIntent.putExtra("room_id", this.WBq.getTalkerUserName());
    }
    localIntent.putExtra("msg_sender", (String)localObject);
    localIntent.putExtra("talker_username", this.WBq.getTalkerUserName());
    com.tencent.mm.by.c.b(this.WBq.WQv.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    com.tencent.mm.plugin.report.service.h.IzE.a(11592, new Object[] { Integer.valueOf(0) });
    AppMethodBeat.o(37293);
  }
  
  public final void a(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37292);
    a((by)paramView.getTag());
    AppMethodBeat.o(37292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.d
 * JD-Core Version:    0.7.0.1
 */