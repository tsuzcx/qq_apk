package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.b.b.l;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

public final class w$a
  extends c
{
  protected w.c vEz;
  private a vko;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_emoji);
      ((View)localObject).setTag(new w.d().s((View)localObject, true));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    if (parambi == null)
    {
      y.e("MicroMsg.emoji.ChattingItemEmojiFrom", "msg is null for: %s", new Object[] { paramString });
      return;
    }
    this.vko = parama1;
    EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.field_imgPath);
    w.d locald = (w.d)parama;
    if (localEmojiInfo != null)
    {
      localEmojiInfo.talker = parambi.field_talker;
      parama = ap.abP(parambi.field_content);
      locald.vCP.a(localEmojiInfo, parambi.field_msgId, parama);
      if ((localEmojiInfo.ZH()) && (!parama.eHB))
      {
        parama.eHB = true;
        parambi.setContent(parama.cuQ());
        au.Hx();
        com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
      }
    }
    parama = "";
    if ((localEmojiInfo != null) && (localEmojiInfo.ZH())) {
      if (localEmojiInfo.field_name.startsWith("jsb_j")) {
        parama = this.vko.vtz.getContext().getString(R.l.emoji_jsb_j);
      }
    }
    for (;;)
    {
      locald.vCP.setContentDescription(this.vko.vtz.getContext().getString(R.l.emoji_store_title) + parama);
      locald.vCP.setTag(new aw(parambi, parama1.cFE(), paramInt, paramString, '\000'));
      parama = locald.vCP;
      if (this.vEz == null) {
        this.vEz = new w.c(parama1);
      }
      parama.setOnClickListener(this.vEz);
      locald.vCP.setOnLongClickListener(c(parama1));
      locald.vCP.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      return;
      if (localEmojiInfo.field_name.startsWith("jsb_s"))
      {
        parama = this.vko.vtz.getContext().getString(R.l.emoji_jsb_s);
      }
      else if (localEmojiInfo.field_name.startsWith("jsb_b"))
      {
        parama = this.vko.vtz.getContext().getString(R.l.emoji_jsb_b);
      }
      else if (localEmojiInfo.field_name.startsWith("dice"))
      {
        parama = localEmojiInfo.field_name.replace("dice_", "").replace(".png", "");
        continue;
        if (localEmojiInfo != null) {
          parama = bk.aM(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(localEmojiInfo.Wv()), "");
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i;
    EmojiInfo localEmojiInfo;
    if (parambi.cvo())
    {
      au.Hx();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        i = ((aw)paramView.getTag()).position;
        localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.field_imgPath);
        if (localEmojiInfo != null) {
          break label79;
        }
        y.w("MicroMsg.emoji.ChattingItemEmojiFrom", "emoji is null. md5:%s", new Object[] { parambi.field_imgPath });
      }
    }
    return true;
    label79:
    boolean bool = localEmojiInfo.cwz();
    if ((localEmojiInfo.field_catalog != EmojiInfo.uCZ) && (!localEmojiInfo.cwC()) && (!localEmojiInfo.cwD()))
    {
      if (bool) {
        paramContextMenu.add(i, 104, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_save_emoji));
      }
    }
    else if ((localEmojiInfo.field_catalog == EmojiInfo.uCZ) || (bk.bl(localEmojiInfo.field_groupId)) || ((!bk.bl(localEmojiInfo.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ax(localEmojiInfo.field_groupId))))
    {
      if (!bool) {
        break label437;
      }
      paramContextMenu.add(i, 113, 0, R.l.retransmit);
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().h(localEmojiInfo)) {
        paramContextMenu.add(i, 135, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_imitate_emoji));
      }
      if ((!bk.bl(localEmojiInfo.field_groupId)) && (!localEmojiInfo.ZH()) && (!localEmojiInfo.cwD())) {
        paramContextMenu.add(i, 128, 0, R.l.chatting_long_click_menu_show_emoji_detail);
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_emoji));
      }
      h.nFQ.f(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.Wv(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", localEmojiInfo.field_activityid });
      return true;
      y.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
      break;
      label437:
      y.i("MicroMsg.emoji.ChattingItemEmojiFrom", "file do no exist. cant do add or resend.");
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return ((l)parama.ac(l.class)).a(paramMenuItem, parama, parambi);
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 47);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  protected final boolean b(a parama)
  {
    return parama.cFE();
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w.a
 * JD-Core Version:    0.7.0.1
 */