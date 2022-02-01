package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class am$b
  extends c
{
  private String PMA;
  private String PMB;
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493551);
      ((View)localObject).setTag(new am.a().G((View)localObject, true));
    }
    AppMethodBeat.o(37177);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37179);
    this.PhN = parama1;
    am.a locala = (am.a)parama;
    ca.a locala1;
    if (parama1.gRM())
    {
      parama = bp.Kt(paramca.field_content);
      bg.aVF();
      locala1 = com.tencent.mm.model.c.aSQ().aEK(parama);
      if ((locala1.dkU == null) || (locala1.dkU.length() <= 0)) {
        Log.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
      }
      this.PMA = locala1.dkU;
      this.PMB = "";
      if (!af.isNullOrNil(parama))
      {
        parama = XmlParser.parseXml(parama, "msg", null);
        if (parama == null) {
          Log.e("MicroMsg.ChattingItemCardFrom", "null==attrs");
        }
        if ((parama != null) && (parama.containsKey(".msg.$wechatid"))) {
          this.PMB = ((String)parama.get(".msg.$wechatid"));
        }
      }
      com.tencent.mm.aj.c.ap(this.PMA, locala1.OqJ);
      locala.resetChatBubbleWidth(locala.clickArea, locala.PJa);
      if (!ab.rR(locala1.IOs)) {
        break label454;
      }
      locala.PKu.setText(2131757339);
      locala.PKv.setVisibility(8);
      if (!d.oD(16)) {
        break label442;
      }
      locala.PKt.setBackground(null);
      label220:
      E(locala.PKt, this.PMA);
      label232:
      parama = this.PMB;
      if ((!af.isNullOrNil(parama)) && (!as.bjx(parama)) && (!ab.IR(parama))) {
        break label507;
      }
    }
    label284:
    label442:
    label454:
    label494:
    label507:
    for (int i = 1;; i = 0)
    {
      boolean bool = ab.rR(locala1.IOs);
      if ((i != 0) || (bool))
      {
        parama = "";
        if (af.isNullOrNil(parama)) {
          break label494;
        }
        locala.PKv.setVisibility(0);
        locala.PKv.setText(parama);
      }
      for (;;)
      {
        locala.gvw.setText(l.e(parama1.Pwc.getContext(), locala1.nickname, (int)locala.gvw.getTextSize()));
        am.a(parama1, this.PMA, locala1, locala);
        locala.clickArea.setTag(new bq(paramca, parama1.gRM(), paramInt, paramString, '\000'));
        locala.clickArea.setOnClickListener(d(parama1));
        locala.clickArea.setOnLongClickListener(c(parama1));
        locala.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
        AppMethodBeat.o(37179);
        return;
        parama = paramca.field_content;
        break;
        locala.PKt.setBackgroundDrawable(null);
        break label220;
        locala.PKu.setText(2131757474);
        locala.PKt.setBackgroundResource(2131231957);
        D(locala.PKt, this.PMA);
        break label232;
        break label284;
        locala.PKv.setVisibility(8);
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37181);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37181);
      return false;
    }
    paramMenuItem = parama.Pwc.getContext();
    bg.aVF();
    if ((ab.rR(com.tencent.mm.model.c.aSQ().aEK(paramca.field_content).IOs)) && (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramMenuItem)))
    {
      AppMethodBeat.o(37181);
      return true;
    }
    if (com.tencent.mm.ui.chatting.k.bs(paramca))
    {
      h.a(paramMenuItem, paramMenuItem.getString(2131760907), "", paramMenuItem.getString(2131768713), null);
      AppMethodBeat.o(37181);
      return false;
    }
    if (com.tencent.mm.ui.chatting.k.bt(paramca))
    {
      h.a(paramMenuItem, paramMenuItem.getString(2131760908), "", paramMenuItem.getString(2131768713), null);
      AppMethodBeat.o(37181);
      return false;
    }
    paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 8);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37181);
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233822);
    int j = ((bq)paramView.getTag()).position;
    bg.aVF();
    ca.a locala = com.tencent.mm.model.c.aSQ().aEK(paramca.field_content);
    if ((locala.dkU == null) || (locala.dkU.length() <= 0)) {
      Log.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
    }
    this.PMA = locala.dkU;
    boolean bool = ab.rR(locala.IOs);
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZh, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (((i != 0) && (paramca.getType() != 66) && (!as.bjp(this.PhN.getTalkerUserName())) && (!as.bjq(this.PhN.getTalkerUserName()))) || (bool)) {
        paramm.a(j, 118, paramView.getContext().getString(2131764628), 2131690674);
      }
      if (!this.PhN.gRN()) {
        paramm.a(j, 100, paramView.getContext().getString(2131757433), 2131690529);
      }
      AppMethodBeat.o(233822);
      return true;
    }
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(37178);
    boolean bool = parama.gRM();
    AppMethodBeat.o(37178);
    return bool;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 42) || (paramInt == 66));
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37182);
    ((com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
    paramView = (bq)paramView.getTag();
    String str1 = paramView.userName;
    String str2 = paramca.field_content;
    boolean bool2 = paramView.Pdm;
    if (paramca.field_isSend == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      am.a(parama, str1, str2, bool2, bool1, paramca);
      AppMethodBeat.o(37182);
      return true;
    }
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.b
 * JD-Core Version:    0.7.0.1
 */