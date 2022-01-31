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
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bf;
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
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class aj$a
  extends c
  implements NeatTextView.b
{
  private static final int vFH = R.h.chatting_item_text_msgid;
  private static final int vFI = R.h.chatting_item_text_is_in_chatting;
  private aj.d vFJ;
  private com.tencent.mm.ui.chatting.c.a vko;
  
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
  
  public View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from);
      ((View)localObject).setTag(new aj.e().s((View)localObject, true));
    }
    return localObject;
  }
  
  public void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    aj.e locale = (aj.e)parama;
    String str = parambi.field_content;
    Object localObject2 = parama1.getTalkerUserName();
    locale.vFN.setTag(vFH, Long.valueOf(parambi.field_msgId));
    locale.vFN.setTag(vFI, Boolean.valueOf(true));
    Object localObject1 = ChattingItemTranslate.b.vGa;
    if (com.tencent.mm.app.plugin.b.tx()) {
      if ((parambi.cvw()) && (parambi.cvB()))
      {
        parama = parambi.field_transContent;
        localObject1 = ((ag)parama1.ac(ag.class)).ba(parambi);
      }
    }
    for (paramString = parama;; paramString = null)
    {
      int i;
      if ((parama1.cFE()) && (!((com.tencent.mm.ui.chatting.b.b.c)parama1.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG()))
      {
        i = bd.iH(str);
        if (i != -1)
        {
          parama = str.substring(0, i).trim();
          if ((parama != null) && (parama.length() > 0))
          {
            str = str.substring(i + 1).trim();
            if (!bk.bl(paramString)) {
              paramString = paramString.substring(i + 1).trim();
            }
          }
        }
      }
      for (;;)
      {
        a(locale, parama1, parambi, parama);
        a(locale, parama1, parama, parambi);
        if ((parambi.czr != null) && (parambi.cvJ()))
        {
          i = 1;
          if (i != 0) {
            break label907;
          }
          parama = j.a(locale.vFN.getContext(), str, (int)locale.vFN.getTextSize(), null, bA(parambi));
          localObject2 = (com.tencent.mm.ui.chatting.b.b.y)parama1.ac(com.tencent.mm.ui.chatting.b.b.y.class);
          if (!((com.tencent.mm.ui.chatting.b.b.y)localObject2).hR(parambi.field_msgId)) {
            break label886;
          }
          localObject2 = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, ((com.tencent.mm.ui.chatting.b.b.y)localObject2).cFd(), d.a.kwt, b.b.kzZ));
          locale.vFN.R(((com.tencent.mm.plugin.fts.a.a.e)localObject2).kwz);
          label344:
          parama = (n[])parama.getSpans(0, parama.length(), n.class);
          int j = parama.length;
          i = 0;
          label367:
          if (i < j)
          {
            if (parama[i].getType() != 44) {
              break label898;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(12809, new Object[] { Integer.valueOf(7), "" });
          }
          label413:
          parama = new ChattingItemTranslate.a(parambi, parama1.cFE(), paramInt);
          locale.vFP.setOnClickListener(new aj.a.1(this, locale));
          locale.vFN.setOnLongClickListener(c(parama1));
          locale.vFN.setOnClickListener(cHe());
          locale.vFN.setOnDoubleClickListener(this);
          locale.vFN.setTag(parama);
          locale.vFN.setTag(vFH, Long.valueOf(parambi.field_msgId));
          locale.vFN.setTextListener(new aj.a.2(this, locale));
          locale.vFP.setVisibility(8);
          locale.vFO.setVisibility(8);
          locale.vFN.setMaxLines(2147483647);
          i = com.tencent.mm.m.g.AA().getInt("InvalidateTextFoldLineNum", 5);
          if (bf.m(parambi))
          {
            parama = locale.vFN.Je(locale.vFN.getContext().getResources().getDimensionPixelSize(R.f.chatting_normal_item_width));
            if ((parama != null) && (parama.cNL() > i))
            {
              locale.vFN.setMaxLines(i);
              locale.vFP.setVisibility(0);
              locale.vFO.setVisibility(0);
            }
          }
          if ((bk.bl(paramString)) && (localObject1 == ChattingItemTranslate.b.vGa)) {
            break label1049;
          }
          if (locale.vFR == null)
          {
            locale.vFR = ((ChattingItemTranslate)locale.vFQ.inflate());
            locale.vFR.init();
          }
          parama = j.a(locale.vFN.getContext(), paramString, (int)locale.vFN.getTextSize(), null, bA(parambi));
          locale.vFR.a(parama, (ChattingItemTranslate.b)localObject1);
          localObject1 = locale.vFR;
          if (!bk.bl(parambi.field_transBrandWording)) {
            break label1040;
          }
          parama = parama1.vtz.getMMResources().getString(R.l.text_trans_text_finish);
          ((ChattingItemTranslate)localObject1).setBrandWording(parama);
          if (!bk.bl(paramString))
          {
            parama = new ChattingItemTranslate.a(parambi, parama1.cFE(), paramInt);
            parama.vHo = false;
            parama.ivk = 2;
            locale.vFR.setTag(parama);
            locale.vFR.setOnClickListener(cHe());
            locale.vFR.setOnDoubleClickListener(this);
            locale.vFR.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
            locale.vFR.setOnLongClickListener(c(parama1));
            locale.vFR.setVisibility(0);
          }
        }
        label886:
        while (locale.vFR == null) {
          for (;;)
          {
            return;
            i = 0;
            break;
            locale.vFN.R(parama);
            break label344;
            i += 1;
            break label367;
            if (i == 0) {
              break label413;
            }
            if (parambi.czr.contains("notify@all")) {}
            for (parama = "";; parama = locale.vFN.getContext().getString(R.l.room_notice_at_all, new Object[] { "@" }) + "\n")
            {
              parama = j.a(locale.vFN.getContext(), parama + str, (int)locale.vFN.getTextSize(), Integer.valueOf(31), bA(parambi));
              locale.vFN.R(parama);
              break;
            }
            parama = parambi.field_transBrandWording;
          }
        }
        label898:
        label907:
        label1040:
        label1049:
        locale.vFR.setVisibility(8);
        return;
        continue;
        parama = (c.a)localObject2;
        break;
        parama = (c.a)localObject2;
      }
      parama = null;
      break;
    }
  }
  
  public boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    if ((!parambi.isText()) && (!parambi.cvi())) {
      return true;
    }
    ChattingItemTranslate.a locala = (ChattingItemTranslate.a)paramView.getTag();
    int i = locala.position;
    if (locala.ivk == 1)
    {
      if (parambi.isText()) {
        paramContextMenu.add(i, 102, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_copy_msg));
      }
      paramContextMenu.add(i, 108, 0, paramView.getContext().getString(R.l.retransmit));
      if (com.tencent.mm.br.d.SP("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
      }
      if (com.tencent.mm.pluginsdk.model.app.g.S(this.vko.vtz.getContext(), parambi.getType())) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_open));
      }
      if ((parambi.isText()) && (com.tencent.mm.ai.f.Mh())) {
        this.vko.cFF();
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
      }
      if (com.tencent.mm.app.plugin.b.tx())
      {
        if ((parambi.cvw()) && (parambi.cvB())) {
          paramContextMenu.add(i, 124, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_switch_original));
        }
      }
      else if (bf.k(parambi))
      {
        paramContextMenu.clear();
        if (!this.vko.cFF()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
        }
      }
    }
    while (locala.ivk != 2) {
      for (;;)
      {
        return true;
        paramContextMenu.add(i, 124, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_translate));
      }
    }
    paramContextMenu.add(i, 141, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_copy_msg));
    paramContextMenu.add(i, 142, 0, paramView.getContext().getString(R.l.retransmit));
    if (com.tencent.mm.br.d.SP("favorite")) {
      paramContextMenu.add(i, 143, 0, paramView.getContext().getString(R.l.plugin_favorite_opt));
    }
    if ((com.tencent.mm.app.plugin.b.ty()) && (parambi.cvD())) {
      paramContextMenu.add(i, 125, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_retranslate));
    }
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    int i;
    Object localObject1;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 141: 
      parambi = parambi.field_transContent;
      paramMenuItem = parambi;
      if (parama.cFE())
      {
        paramMenuItem = parambi;
        if (!((com.tencent.mm.ui.chatting.b.b.c)parama.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG())
        {
          i = bd.iH(parambi);
          paramMenuItem = parambi;
          if (i != -1) {
            paramMenuItem = parambi.substring(i + 1).trim();
          }
        }
      }
      parambi = (android.text.ClipboardManager)parama.vtz.getContext().getSystemService("clipboard");
      if (!bk.bl(paramMenuItem)) {
        parambi.setText(paramMenuItem);
      }
      com.tencent.mm.ui.base.h.bC(parama.vtz.getContext(), parama.vtz.getContext().getString(R.l.app_copy_ok));
      return true;
    case 142: 
      localObject1 = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
      paramMenuItem = parambi.field_transContent;
      if ((parama.cFE()) && (!((com.tencent.mm.ui.chatting.b.b.c)parama.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG()))
      {
        i = bd.iH(paramMenuItem);
        if (i != -1) {
          paramMenuItem = paramMenuItem.substring(i + 1).trim();
        }
      }
      break;
    }
    for (;;)
    {
      if (parambi.cvi())
      {
        ((Intent)localObject1).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        parama.startActivity((Intent)localObject1);
        return true;
        ((Intent)localObject1).putExtra("Retr_Msg_content", paramMenuItem);
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 4);
      }
      Object localObject2 = new cj();
      localObject1 = parambi.field_transContent;
      if ((parama.cFE()) && (!((com.tencent.mm.ui.chatting.b.b.c)parama.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG()))
      {
        i = bd.iH((String)localObject1);
        if (i != -1) {
          localObject1 = ((String)localObject1).substring(i + 1).trim();
        }
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.model.e.b((cj)localObject2, (String)localObject1, 1);
        ((cj)localObject2).bIw.uD = parama.vtz;
        ((cj)localObject2).bIw.bID = 43;
        if (((cj)localObject2).bIw.bIy != null)
        {
          localObject1 = ((cj)localObject2).bIw.bIy.sXa;
          if (localObject1 != null)
          {
            ((yp)localObject1).Yq(parambi.field_talker);
            ((yp)localObject1).Yr(q.Gj());
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        for (;;)
        {
          localObject1 = (android.content.ClipboardManager)parama.vtz.getContext().getSystemService("clipboard");
          localObject2 = parambi.field_content;
          paramMenuItem = new StringBuilder("groupId = ").append(paramMenuItem.getGroupId()).append(", content length: ");
          if (localObject2 == null)
          {
            i = 0;
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingItemTextFrom", i);
            paramMenuItem = ((ag)parama.ac(ag.class)).bb(parambi);
          }
          try
          {
            ((android.content.ClipboardManager)localObject1).setText(paramMenuItem);
            com.tencent.mm.ui.base.h.bC(parama.vtz.getContext(), parama.vtz.getContext().getString(R.l.app_copy_ok));
            parama = com.tencent.mm.plugin.secinforeport.a.a.nQo;
            com.tencent.mm.plugin.secinforeport.a.a.f(1, parambi.field_msgSvrId, bk.ZH(paramMenuItem));
            return true;
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingItemTextFrom", "alvinluo transform text fav failed");
            continue;
            i = ((String)localObject2).length();
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingItemTextFrom", "clip.setText error ");
            }
          }
        }
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
        ((ag)parama.ac(ag.class)).b(paramMenuItem, parambi);
        return false;
      }
    }
  }
  
  public boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 1) || (paramInt == 11) || (paramInt == 21) || (paramInt == 31) || (paramInt == 36) || (paramInt == 301989937));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    if ((paramView instanceof MMTextView))
    {
      paramView = (MMTextView)paramView;
      com.tencent.mm.ui.chatting.j.a.a.cGT();
      com.tencent.mm.ui.chatting.j.a.a.a(paramView.getText(), parambi);
    }
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.c.a parama)
  {
    return parama.cFE();
  }
  
  public final boolean bfO()
  {
    return false;
  }
  
  protected boolean cHb()
  {
    return false;
  }
  
  public final boolean eb(View paramView)
  {
    Intent localIntent = new Intent(paramView.getContext(), TextPreviewUI.class);
    localIntent.addFlags(67108864);
    aw localaw = (aw)paramView.getTag();
    if (localaw != null)
    {
      CharSequence localCharSequence = ((MMNeatTextView)paramView).mText;
      localIntent.putExtra("Chat_Msg_Id", localaw.bWO.field_msgId);
      localIntent.putExtra("key_chat_text", localCharSequence);
      paramView.getContext().startActivity(localIntent);
      com.tencent.mm.ui.base.b.gJ(paramView.getContext());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.a
 * JD-Core Version:    0.7.0.1
 */