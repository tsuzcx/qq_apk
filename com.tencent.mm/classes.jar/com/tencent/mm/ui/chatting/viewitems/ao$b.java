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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class ao$b
  extends c
{
  private String aeSA;
  private String aeSB;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37177);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.gfX);
      ((View)localObject).setTag(new ao.a().P((View)localObject, true));
    }
    AppMethodBeat.o(37177);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37179);
    this.aeiK = parama1;
    ao.a locala = (ao.a)parama;
    cc.a locala1;
    if (parama1.juG())
    {
      parama = br.JK(paramcc.field_content);
      bh.bCz();
      locala1 = com.tencent.mm.model.c.bzD().aLU(parama);
      if ((locala1.hgk == null) || (locala1.hgk.length() <= 0)) {
        Log.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
      }
      this.aeSA = locala1.hgk;
      this.aeSB = "";
      if (!com.tencent.mm.platformtools.ab.isNullOrNil(parama))
      {
        parama = XmlParser.parseXml(parama, "msg", null);
        if (parama == null) {
          Log.e("MicroMsg.ChattingItemCardFrom", "null==attrs");
        }
        if ((parama != null) && (parama.containsKey(".msg.$wechatid"))) {
          this.aeSB = ((String)parama.get(".msg.$wechatid"));
        }
      }
      com.tencent.mm.modelavatar.d.aS(this.aeSA, locala1.adky);
      locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
      if (!com.tencent.mm.model.ab.uY(locala1.WAW)) {
        break label455;
      }
      locala.aeQc.setText(R.l.gwS);
      locala.aeQd.setVisibility(8);
      if (!com.tencent.mm.compatible.util.d.rb(16)) {
        break label443;
      }
      locala.aeQb.setBackground(null);
      label221:
      E(locala.aeQb, this.aeSA);
      label233:
      parama = this.aeSB;
      if ((!com.tencent.mm.platformtools.ab.isNullOrNil(parama)) && (!au.bxb(parama)) && (!au.bxa(parama))) {
        break label508;
      }
    }
    label285:
    label443:
    label455:
    label495:
    label508:
    for (int i = 1;; i = 0)
    {
      boolean bool = com.tencent.mm.model.ab.uY(locala1.WAW);
      if ((i != 0) || (bool))
      {
        parama = "";
        if (com.tencent.mm.platformtools.ab.isNullOrNil(parama)) {
          break label495;
        }
        locala.aeQd.setVisibility(0);
        locala.aeQd.setText(parama);
      }
      for (;;)
      {
        locala.lBD.setText(p.d(parama1.aezO.getContext(), locala1.nickname, (int)locala.lBD.getTextSize()));
        ao.a(parama1, this.aeSA, locala1, locala);
        locala.clickArea.setTag(new bz(paramcc, parama1.juG(), paramInt, paramString, '\000'));
        locala.clickArea.setOnClickListener(d(parama1));
        locala.clickArea.setOnLongClickListener(c(parama1));
        locala.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
        AppMethodBeat.o(37179);
        return;
        parama = paramcc.field_content;
        break;
        locala.aeQb.setBackgroundDrawable(null);
        break label221;
        locala.aeQc.setText(R.l.gyT);
        locala.aeQb.setBackgroundResource(R.g.default_avatar);
        x(locala.aeQb, this.aeSA);
        break label233;
        break label285;
        locala.aeQd.setVisibility(8);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37181);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37181);
      return false;
    }
    paramMenuItem = parama.aezO.getContext();
    bh.bCz();
    if ((com.tencent.mm.model.ab.uY(com.tencent.mm.model.c.bzD().aLU(paramcc.field_content).WAW)) && (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramMenuItem)))
    {
      AppMethodBeat.o(37181);
      return true;
    }
    if (com.tencent.mm.ui.chatting.m.ca(paramcc))
    {
      k.a(paramMenuItem, paramMenuItem.getString(R.l.gIO), "", paramMenuItem.getString(R.l.welcome_i_know), null);
      AppMethodBeat.o(37181);
      return false;
    }
    if (com.tencent.mm.ui.chatting.m.cb(paramcc))
    {
      k.a(paramMenuItem, paramMenuItem.getString(R.l.gIP), "", paramMenuItem.getString(R.l.welcome_i_know), null);
      AppMethodBeat.o(37181);
      return false;
    }
    paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 8);
    paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37181);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255586);
    int j = ((bz)paramView.getTag()).position;
    bh.bCz();
    paramContextMenuInfo = com.tencent.mm.model.c.bzD().aLU(paramcc.field_content);
    if ((paramContextMenuInfo.hgk == null) || (paramContextMenuInfo.hgk.length() <= 0)) {
      Log.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
    }
    this.aeSA = paramContextMenuInfo.hgk;
    boolean bool = com.tencent.mm.model.ab.uY(paramContextMenuInfo.WAW);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVK, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (((i != 0) && (paramcc.getType() != 66) && (!au.bwO(this.aeiK.getTalkerUserName())) && (!au.bwP(this.aeiK.getTalkerUserName()))) || (bool)) {
        params.a(j, 118, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (!this.aeiK.juH()) {
        params.a(j, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      AppMethodBeat.o(255586);
      return true;
    }
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(37178);
    boolean bool = parama.juG();
    AppMethodBeat.o(37178);
    return bool;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37182);
    ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    paramView = (bz)paramView.getTag();
    String str1 = paramView.userName;
    String str2 = paramcc.field_content;
    boolean bool2 = paramView.aedO;
    if (paramcc.field_isSend == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ao.a(parama, str1, str2, bool2, bool1, paramcc);
      AppMethodBeat.o(37182);
      return true;
    }
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 42) || (paramInt == 66));
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.b
 * JD-Core Version:    0.7.0.1
 */