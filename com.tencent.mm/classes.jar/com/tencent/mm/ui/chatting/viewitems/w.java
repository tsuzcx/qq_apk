package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
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
import com.tencent.mm.ui.chatting.t.l;
import com.tencent.mm.ui.chatting.t.m;

public final class w
{
  public static final class b
    extends c
    implements t.m
  {
    protected t.l vEA;
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
        localObject = new t(paramLayoutInflater, R.i.chatting_item_to_emoji);
        ((View)localObject).setTag(new w.d().s((View)localObject, false));
      }
      return localObject;
    }
    
    public final void a(a parama, bi parambi)
    {
      parambi.cvz();
      au.Hx();
      com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
      ((l)parama.ac(l.class)).aX(parambi);
    }
    
    public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
    {
      this.vko = parama1;
      paramString = (w.d)parama;
      EmojiInfo localEmojiInfo = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.field_imgPath);
      ImageView localImageView;
      if (localEmojiInfo != null)
      {
        parama = ap.abP(parambi.field_content);
        paramString.vCP.a(localEmojiInfo, parambi.field_msgId, parama);
        if (paramString.vEB != null)
        {
          if (!parama.uAB) {
            break label628;
          }
          paramString.vEB.setVisibility(0);
          TextView localTextView = (TextView)paramString.kKz.findViewById(R.h.chatting_reward_tips_inflated).findViewById(R.h.chatting_emoji_reward_tv);
          localTextView.setText(Html.fromHtml(parama1.vtz.getMMResources().getString(R.l.emoji_chatting_reward_tips)));
          localImageView = (ImageView)paramString.kKz.findViewById(R.h.chatting_reward_tips_inflated).findViewById(R.h.chatting_emoji_reward_hand);
          localTextView.setTag(new aw(parambi, false, paramInt, parama1.cFB(), false, "", "", "", "", localEmojiInfo.field_groupId, "", true, false));
          localTextView.setOnClickListener(h(parama1));
          if (!((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHg()) {
            break label618;
          }
          localImageView.setVisibility(0);
          localImageView.setTag(new aw(parambi, parama1.cFE(), paramInt, parama1.cFB(), '\000'));
          if (this.vEA == null) {
            this.vEA = new t.l(parama1);
          }
          localImageView.setOnClickListener(this.vEA);
        }
        if ((localEmojiInfo.ZH()) && (!parama.eHB))
        {
          parama.eHB = true;
          parambi.setContent(parama.cuQ());
          au.Hx();
          parambi.setStatus(com.tencent.mm.model.c.Fy().fd(parambi.field_msgId).field_status);
          au.Hx();
          com.tencent.mm.model.c.Fy().V(parambi);
        }
        if (!cHc()) {
          break label662;
        }
        paramString.nhQ.setVisibility(8);
        if ((parambi.field_status != 2) || (!a((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi.field_msgId))) {
          break label641;
        }
        if (paramString.vBN != null) {
          paramString.vBN.setVisibility(0);
        }
      }
      label414:
      parama = "";
      if ((localEmojiInfo != null) && (localEmojiInfo.ZH())) {
        if (localEmojiInfo.field_name.startsWith("jsb_j")) {
          parama = this.vko.vtz.getContext().getString(R.l.emoji_jsb_j);
        }
      }
      for (;;)
      {
        paramString.vCP.setContentDescription(this.vko.vtz.getContext().getString(R.l.emoji_store_title) + parama);
        paramString.vCP.setTag(new aw(parambi, parama1.cFE(), paramInt, parama1.cFB(), '\000'));
        parama = paramString.vCP;
        if (this.vEz == null) {
          this.vEz = new w.c(parama1);
        }
        parama.setOnClickListener(this.vEz);
        paramString.vCP.setOnLongClickListener(c(parama1));
        paramString.vCP.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
        a(paramInt, paramString, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
        return;
        label618:
        localImageView.setVisibility(8);
        break;
        label628:
        paramString.vEB.setVisibility(8);
        break;
        label641:
        if (paramString.vBN == null) {
          break label414;
        }
        paramString.vBN.setVisibility(8);
        break label414;
        label662:
        if (paramString.vBN != null) {
          paramString.vBN.setVisibility(8);
        }
        if (paramString.nhQ == null) {
          break label414;
        }
        paramString.nhQ.setVisibility(0);
        if (parambi.field_status < 2) {
          break label414;
        }
        paramString.nhQ.setVisibility(8);
        break label414;
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
            break label80;
          }
          y.w("MicroMsg.emoji.ChattingItemEmojiTo", "emoji is null. md5:%s", new Object[] { parambi.field_imgPath });
        }
      }
      return true;
      label80:
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
          break label548;
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
        if ((!parambi.ctz()) && (parambi.cvo()) && ((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
          paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
        }
        if (!this.vko.cFF()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_emoji));
        }
        if (parambi.field_status == 5) {
          paramContextMenu.add(i, 103, 0, paramView.getContext().getString(R.l.chatting_resend_title));
        }
        h.nFQ.f(12789, new Object[] { Integer.valueOf(0), localEmojiInfo.Wv(), Integer.valueOf(0), localEmojiInfo.field_designerID, localEmojiInfo.field_groupId, "", "", "", "", "", localEmojiInfo.field_activityid });
        return true;
        y.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
        break;
        label548:
        y.i("MicroMsg.emoji.ChattingItemEmojiTo", "emoji file no exist. cannot save or resend.");
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
    {
      return ((l)parama.ac(l.class)).a(paramMenuItem, parama, parambi);
    }
    
    public final boolean au(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 47);
    }
    
    public final boolean b(View paramView, a parama, bi parambi)
    {
      return false;
    }
    
    public final boolean bfO()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w
 * JD-Core Version:    0.7.0.1
 */