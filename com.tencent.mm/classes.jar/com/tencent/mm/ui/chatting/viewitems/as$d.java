package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.v.e;

public final class as$d
  extends v.e
{
  private int scene;
  
  public as$d(a parama)
  {
    super(parama);
    this.scene = 0;
  }
  
  public as$d(a parama, cc paramcc)
  {
    super(parama);
    AppMethodBeat.i(37291);
    this.scene = 0;
    this.scene = 1;
    if (this.scene == 1) {
      a(new bz(paramcc, this.aeiK.juG(), 0, this.aeiK.getSelfUserName(), '\000'));
    }
    AppMethodBeat.o(37291);
  }
  
  private void a(bz parambz)
  {
    AppMethodBeat.i(37293);
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      AppMethodBeat.o(37293);
      return;
    }
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(parambz.hTm.field_talker);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      Log.i("MicroMsg.EmojiClickListener", "exit in teen mode");
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(this.aeiK.aezO.getContext());
      AppMethodBeat.o(37293);
      return;
    }
    Object localObject = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(parambz.hTm.field_imgPath);
    if ((localObject == null) || (((EmojiInfo)localObject).aqJ()))
    {
      AppMethodBeat.o(37293);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("custom_smiley_preview_md5", parambz.hTm.field_imgPath);
    localIntent.putExtra("custom_to_talker_name", parambz.hTm.field_talker);
    if ((((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.aklF) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.aklE) && (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.aklD)) {
      localIntent.putExtra("custom_smiley_preview_productid", ((EmojiInfo)localObject).field_groupId);
    }
    localIntent.putExtra("msg_id", parambz.hTm.field_msgSvrId);
    localIntent.putExtra("msg_content", parambz.hTm.field_content);
    String str = parambz.hTm.field_talker;
    localObject = str;
    if (au.bwE(str))
    {
      localObject = br.JJ(parambz.hTm.field_content);
      localIntent.putExtra("room_id", this.aeiK.getTalkerUserName());
    }
    localIntent.putExtra("msg_sender", (String)localObject);
    localIntent.putExtra("talker_username", this.aeiK.getTalkerUserName());
    com.tencent.mm.br.c.b(this.aeiK.aezO.getContext(), "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
    com.tencent.mm.plugin.report.service.h.OAn.b(11592, new Object[] { Integer.valueOf(0) });
    AppMethodBeat.o(37293);
  }
  
  public final void a(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(37292);
    a((bz)paramView.getTag());
    AppMethodBeat.o(37292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.d
 * JD-Core Version:    0.7.0.1
 */