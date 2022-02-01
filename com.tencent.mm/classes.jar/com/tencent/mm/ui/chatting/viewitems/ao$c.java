package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.f;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class ao$c
  extends c
  implements v.n
{
  private String aeSA;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37183);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggX);
      ((View)localObject).setTag(new ao.a().P((View)localObject, false));
    }
    AppMethodBeat.o(37183);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(37184);
    this.aeiK = parama1;
    paramString = (ao.a)parama;
    bh.bCz();
    cc.a locala = com.tencent.mm.model.c.bzD().aLU(paramcc.field_content);
    if ((locala.hgk == null) || (locala.hgk.length() <= 0)) {
      Log.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
    }
    this.aeSA = locala.hgk;
    Log.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[] { Boolean.valueOf(com.tencent.mm.model.ab.IS(this.aeSA)), this.aeSA });
    paramString.resetChatBubbleWidth(paramString.clickArea, paramString.aeOt);
    if (com.tencent.mm.model.ab.uY(locala.WAW))
    {
      paramString.aeQc.setText(R.l.gwS);
      paramString.aeQd.setVisibility(8);
      if (com.tencent.mm.compatible.util.d.rb(16))
      {
        paramString.aeQb.setBackground(null);
        E(paramString.aeQb, this.aeSA);
        label180:
        paramString.lBD.setText(p.b(parama1.aezO.getContext(), locala.nickname, paramString.lBD.getTextSize()));
        parama = locala.kDc;
        if (!com.tencent.mm.platformtools.ab.isNullOrNil(this.aeSA))
        {
          bh.bCz();
          au localau = com.tencent.mm.model.c.bzA().JE(this.aeSA);
          if ((localau != null) && (com.tencent.mm.contact.d.rs(localau.field_type))) {
            break label641;
          }
        }
      }
    }
    label641:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (com.tencent.mm.platformtools.ab.isNullOrNil(parama)))
      {
        parama = this.aeSA;
        if ((com.tencent.mm.platformtools.ab.isNullOrNil(parama)) || (au.bxb(parama)) || (au.bxa(parama))) {
          i = 1;
        }
      }
      for (;;)
      {
        label305:
        boolean bool2 = com.tencent.mm.model.ab.uY(locala.WAW);
        if ((i != 0) || (bool2)) {
          parama = "";
        }
        if (!com.tencent.mm.platformtools.ab.isNullOrNil(parama))
        {
          paramString.aeQd.setVisibility(0);
          paramString.aeQd.setText(parama);
          label353:
          ao.a(parama1, this.aeSA, locala, paramString);
          paramString.clickArea.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
          if (!jxj()) {
            break label612;
          }
          b(paramString, false);
          if ((paramcc.field_status != 2) || (!b((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class), paramcc.field_msgId))) {
            break label591;
          }
          if (paramString.aeNG != null) {
            paramString.aeNG.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramInt, paramString, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
          AppMethodBeat.o(37184);
          return;
          paramString.aeQb.setBackgroundDrawable(null);
          break;
          paramString.aeQc.setText(R.l.gyT);
          paramString.aeQb.setBackgroundResource(R.g.default_avatar);
          x(paramString.aeQb, this.aeSA);
          break label180;
          i = 0;
          break label305;
          paramString.aeQd.setVisibility(8);
          break label353;
          label591:
          if (paramString.aeNG != null) {
            paramString.aeNG.setVisibility(8);
          }
        }
        label612:
        if (paramcc.field_status < 2) {}
        for (;;)
        {
          b(paramString, bool1);
          break;
          bool1 = false;
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37186);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37186);
      return false;
    }
    paramMenuItem = parama.aezO.getContext();
    if (com.tencent.mm.ui.chatting.m.ca(paramcc))
    {
      k.a(paramMenuItem, paramMenuItem.getString(R.l.gIO), "", paramMenuItem.getString(R.l.welcome_i_know), null);
      AppMethodBeat.o(37186);
      return false;
    }
    if (com.tencent.mm.ui.chatting.m.cb(paramcc))
    {
      k.a(paramMenuItem, paramMenuItem.getString(R.l.gIP), "", paramMenuItem.getString(R.l.welcome_i_know), null);
      AppMethodBeat.o(37186);
      return false;
    }
    paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 8);
    paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37186);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255576);
    int j = ((bz)paramView.getTag()).position;
    bh.bCz();
    paramContextMenuInfo = com.tencent.mm.model.c.bzD().aLU(paramcc.field_content);
    if ((paramContextMenuInfo.hgk == null) || (paramContextMenuInfo.hgk.length() <= 0)) {
      Log.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
    }
    this.aeSA = paramContextMenuInfo.hgk;
    boolean bool = com.tencent.mm.model.ab.uY(paramContextMenuInfo.WAW);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVK, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (((i != 0) && (paramcc.getType() != 66) && (!au.bwO(this.aeiK.getTalkerUserName())) && (!au.bwP(this.aeiK.getTalkerUserName()))) || (bool)) {
        params.a(j, 118, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if ((!paramcc.iYe()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (paramcc.jbB()) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker))) {
        params.a(j, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
      }
      if (!this.aeiK.juH()) {
        params.a(j, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      AppMethodBeat.o(255576);
      return true;
    }
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255588);
    paramcc.unsetOmittedFailResend();
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
    ((f)parama.cm(f.class)).cK(paramcc);
    AppMethodBeat.o(255588);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37187);
    ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    paramView = (bz)paramView.getTag();
    String str1 = paramView.userName;
    String str2 = paramcc.field_content;
    boolean bool2 = paramView.aedO;
    if (paramcc.field_isSend == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ao.a(parama, str1, str2, bool2, bool1, paramcc);
      AppMethodBeat.o(37187);
      return true;
    }
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 42) || (paramInt == 66));
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.c
 * JD-Core Version:    0.7.0.1
 */