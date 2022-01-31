package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.fts.a.a.d.a;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class aj$b
  extends c
  implements t.m, NeatTextView.b
{
  private static final int vFH = R.h.chatting_item_text_msgid;
  private static final int vFI = R.h.chatting_item_text_is_in_chatting;
  private aj.d vFJ;
  private com.tencent.mm.ui.chatting.c.a vko;
  
  private void aL(bi parambi)
  {
    if (!this.vko.getTalkerUserName().equals("medianote"))
    {
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.d(parambi.field_talker, parambi.field_msgSvrId));
    }
    am.aL(parambi);
    this.vko.cCW();
  }
  
  private String bA(bi parambi)
  {
    if (parambi != null)
    {
      String str = u.ij(parambi.field_msgSvrId);
      u.b localb = u.Hc().v(str, true);
      localb.h("prePublishId", "msg_" + parambi.field_msgSvrId);
      localb.h("preUsername", b(this.vko, parambi));
      localb.h("preChatName", c(this.vko, parambi));
      return str;
    }
    return null;
  }
  
  private aj.d cHe()
  {
    if (this.vFJ == null) {
      this.vFJ = new aj.d(this.vko);
    }
    return this.vFJ;
  }
  
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to);
      ((View)localObject).setTag(new aj.e().s((View)localObject, false));
    }
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    parambi.cvz();
    au.Hx();
    com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
    if ((parambi.isText()) && (parambi.field_isSend == 1)) {
      aL(parambi);
    }
  }
  
  public void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    aj.e locale = (aj.e)parama;
    locale.vFN.setTag(vFH, Long.valueOf(parambi.field_msgId));
    locale.vFN.setTag(vFI, Boolean.valueOf(true));
    locale.vFN.setMaxLines(2147483647);
    int i;
    if (cHc())
    {
      if (locale.nhQ != null) {
        locale.nhQ.setVisibility(8);
      }
      if ((parambi.field_status == 1) || (parambi.field_status == 5))
      {
        if (locale.vBN != null) {
          locale.vBN.setVisibility(8);
        }
        locale.vFN.setBackgroundResource(R.g.chatto_bg_alpha);
        parambi.uBR = true;
        paramString = parambi.field_content;
        if (bk.bl(paramString)) {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgSvrId) });
        }
        if ((parambi.czr == null) || (!parambi.cvJ())) {
          break label900;
        }
        i = 1;
        label201:
        if (i != 0) {
          break label927;
        }
        parama = j.a(locale.vFN.getContext(), paramString, (int)locale.vFN.getTextSize(), null, bA(parambi));
        paramString = (com.tencent.mm.ui.chatting.b.b.y)parama1.ac(com.tencent.mm.ui.chatting.b.b.y.class);
        if (!paramString.hR(parambi.field_msgId)) {
          break label906;
        }
        paramString = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, paramString.cFd(), d.a.kwt, b.b.kAa));
        locale.vFN.R(paramString.kwz);
        label298:
        parama = (n[])parama.getSpans(0, parama.length(), n.class);
        int j = parama.length;
        i = 0;
        label321:
        if (i < j)
        {
          if (parama[i].getType() != 44) {
            break label918;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(12809, new Object[] { Integer.valueOf(6), "" });
        }
        parama = new ChattingItemTranslate.a(parambi, parama1.cFE(), paramInt);
        parama.vHo = false;
        locale.vFN.setTag(parama);
        locale.vFN.setOnClickListener(cHe());
        locale.vFN.setOnLongClickListener(c(parama1));
        locale.vFN.setOnDoubleClickListener(this);
        locale.vFN.setTextListener(new aj.b.1(this, locale));
        paramString = ChattingItemTranslate.b.vGa;
        if (!com.tencent.mm.app.plugin.b.tx()) {
          break label1091;
        }
        if ((!parambi.cvw()) || (!parambi.cvB())) {
          break label1086;
        }
        parama = parambi.field_transContent;
        label481:
        paramString = ((ag)parama1.ac(ag.class)).ba(parambi);
      }
    }
    for (;;)
    {
      if ((!bk.bl(parama)) || (paramString != ChattingItemTranslate.b.vGa))
      {
        if (locale.vFR == null)
        {
          locale.vFR = ((ChattingItemTranslate)locale.vFQ.inflate());
          locale.vFR.init();
        }
        Object localObject = j.a(locale.vFN.getContext(), parama, (int)locale.vFN.getTextSize(), null, bA(parambi));
        locale.vFR.a((CharSequence)localObject, paramString);
        localObject = locale.vFR;
        if (bk.bl(parambi.field_transBrandWording))
        {
          paramString = parama1.vtz.getMMResources().getString(R.l.text_trans_text_finish);
          label622:
          ((ChattingItemTranslate)localObject).setBrandWording(paramString);
          if (!bk.bl(parama))
          {
            parama = new ChattingItemTranslate.a(parambi, parama1.cFE(), paramInt);
            parama.ivk = 2;
            locale.vFR.setTag(parama);
            locale.vFR.setOnClickListener(cHe());
            locale.vFR.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
            locale.vFR.setOnDoubleClickListener(this);
            locale.vFR.setOnLongClickListener(c(parama1));
            locale.vFR.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        a(paramInt, locale, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
        return;
        locale.vFN.setBackgroundResource(R.g.chatto_bg);
        if (locale.vBN == null) {
          break;
        }
        if (a((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi.field_msgId))
        {
          if (parambi.uBR)
          {
            parama = new AlphaAnimation(0.5F, 1.0F);
            parama.setDuration(300L);
            locale.vFN.startAnimation(parama);
            parambi.uBR = false;
          }
          locale.vBN.setVisibility(0);
          break;
        }
        locale.vBN.setVisibility(8);
        break;
        if (locale.nhQ == null) {
          break;
        }
        parama = locale.nhQ;
        if (parambi.field_status >= 2) {}
        for (i = 8;; i = 0)
        {
          parama.setVisibility(i);
          break;
        }
        label900:
        i = 0;
        break label201;
        label906:
        locale.vFN.R(parama);
        break label298;
        label918:
        i += 1;
        break label321;
        label927:
        if (parambi.czr.contains("notify@all")) {}
        for (parama = "";; parama = locale.vFN.getContext().getString(R.l.room_notice_at_all, new Object[] { "@" }) + "\n")
        {
          parama = j.a(locale.vFN.getContext(), parama + paramString, (int)locale.vFN.getTextSize(), Integer.valueOf(31), bA(parambi));
          locale.vFN.R(parama);
          break;
        }
        paramString = parambi.field_transBrandWording;
        break label622;
        if (locale.vFR != null) {
          locale.vFR.setVisibility(8);
        }
      }
      label1086:
      parama = null;
      break label481;
      label1091:
      parama = null;
    }
  }
  
  public boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i;
    if ((parambi.czr != null) && (parambi.czr.contains("announcement@all")))
    {
      i = 1;
      if ((parambi.isText()) || (parambi.cvi())) {
        break label45;
      }
    }
    label45:
    ChattingItemTranslate.a locala;
    int j;
    label400:
    do
    {
      return true;
      i = 0;
      break;
      locala = (ChattingItemTranslate.a)paramView.getTag();
      j = locala.position;
      if (locala.ivk == 1)
      {
        if (parambi.isText()) {
          paramContextMenu.add(j, 102, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_copy_msg));
        }
        paramContextMenu.add(j, 108, 0, paramView.getContext().getString(R.l.retransmit));
        if (parambi.field_status == 5) {
          paramContextMenu.add(j, 103, 0, paramView.getContext().getString(R.l.chatting_resend_title));
        }
        if (com.tencent.mm.br.d.SP("favorite")) {
          paramContextMenu.add(j, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
        }
        if (com.tencent.mm.pluginsdk.model.app.g.S(this.vko.vtz.getContext(), parambi.getType())) {
          paramContextMenu.add(j, 129, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_open));
        }
        if ((i == 0) && (!parambi.ctz()) && (parambi.isText()) && ((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
          paramContextMenu.add(j, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
        }
        if (com.tencent.mm.app.plugin.b.tx())
        {
          if ((!parambi.cvw()) || (!parambi.cvB())) {
            break label400;
          }
          paramContextMenu.add(j, 124, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_switch_original));
        }
        for (;;)
        {
          if ((parambi.isText()) && (com.tencent.mm.ai.f.Mh())) {
            this.vko.cFF();
          }
          if (this.vko.cFF()) {
            break;
          }
          paramContextMenu.add(j, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
          return true;
          paramContextMenu.add(j, 124, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_translate));
        }
      }
    } while (locala.ivk != 2);
    paramContextMenu.add(j, 141, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_copy_msg));
    paramContextMenu.add(j, 142, 0, paramView.getContext().getString(R.l.retransmit));
    if (com.tencent.mm.br.d.SP("favorite")) {
      paramContextMenu.add(j, 143, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
    }
    if ((com.tencent.mm.app.plugin.b.ty()) && (parambi.cvD())) {
      paramContextMenu.add(j, 125, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_retranslate));
    }
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 141: 
      paramMenuItem = (android.text.ClipboardManager)parama.vtz.getContext().getSystemService("clipboard");
      parambi = parambi.field_transContent;
      if (!bk.bl(parambi)) {
        paramMenuItem.setText(parambi);
      }
      com.tencent.mm.ui.base.h.bC(parama.vtz.getContext(), parama.vtz.getContext().getString(R.l.app_copy_ok));
      return true;
    case 142: 
      paramMenuItem = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
      localObject1 = parambi.field_transContent;
      if (parambi.cvi())
      {
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
        paramMenuItem.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        parama.startActivity(paramMenuItem);
        return true;
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
    case 143: 
      localObject1 = new cj();
      com.tencent.mm.pluginsdk.model.e.b((cj)localObject1, parambi.field_transContent, 1);
      ((cj)localObject1).bIw.uD = parama.vtz;
      ((cj)localObject1).bIw.bID = 43;
      if (((cj)localObject1).bIw.bIy != null)
      {
        localObject2 = ((cj)localObject1).bIw.bIy.sXa;
        if (localObject2 != null)
        {
          ((yp)localObject2).Yq(parambi.field_talker);
          ((yp)localObject2).Yr(q.Gj());
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
    case 102: 
      for (;;)
      {
        localObject1 = (android.content.ClipboardManager)parama.vtz.getContext().getSystemService("clipboard");
        localObject2 = parambi.field_content;
        paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
        if (localObject2 == null)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingItemTextTo", i);
          paramMenuItem = ((ag)parama.ac(ag.class)).bb(parambi);
        }
        try
        {
          ((android.content.ClipboardManager)localObject1).setText(paramMenuItem);
          com.tencent.mm.ui.base.h.bC(parama.vtz.getContext(), parama.vtz.getContext().getString(R.l.app_copy_ok));
          parama = com.tencent.mm.plugin.secinforeport.a.a.nQo;
          com.tencent.mm.plugin.secinforeport.a.a.f(1, parambi.field_msgSvrId, bk.ZH(paramMenuItem));
          return true;
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingItemTextTo", "alvinluo transform text fav failed");
          continue;
          i = ((String)localObject2).length();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingItemTextTo", "clip.setText error ");
          }
        }
      }
    case 108: 
      paramMenuItem = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
      String str = ((ag)parama.ac(ag.class)).bb(parambi);
      if (parambi.cvi())
      {
        paramMenuItem.putExtra("Retr_Msg_content", str);
        paramMenuItem.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        parama.startActivity(paramMenuItem);
        return false;
        paramMenuItem.putExtra("Retr_Msg_content", str);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
    case 103: 
      aL(parambi);
      return false;
    }
    ((ag)parama.ac(ag.class)).b(paramMenuItem, parambi);
    return false;
  }
  
  public boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean bfO()
  {
    return true;
  }
  
  public final boolean eb(View paramView)
  {
    Object localObject = ((MMNeatTextView)paramView).mText;
    Intent localIntent = new Intent(paramView.getContext(), TextPreviewUI.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_chat_text", (CharSequence)localObject);
    if ((paramView.getTag() instanceof aw))
    {
      localObject = (aw)paramView.getTag();
      if (localObject != null) {
        localIntent.putExtra("Chat_Msg_Id", ((aw)localObject).bWO.field_msgId);
      }
    }
    paramView.getContext().startActivity(localIntent);
    com.tencent.mm.ui.base.b.gJ(paramView.getContext());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.b
 * JD-Core Version:    0.7.0.1
 */