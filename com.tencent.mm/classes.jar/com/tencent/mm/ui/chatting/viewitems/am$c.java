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
import com.tencent.mm.g.c.ax;
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
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.e;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class am$c
  extends c
  implements t.n
{
  private String PMA;
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493602);
      ((View)localObject).setTag(new am.a().G((View)localObject, false));
    }
    AppMethodBeat.o(37183);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(37184);
    this.PhN = parama1;
    paramString = (am.a)parama;
    bg.aVF();
    ca.a locala = com.tencent.mm.model.c.aSQ().aEK(paramca.field_content);
    if ((locala.dkU == null) || (locala.dkU.length() <= 0)) {
      Log.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
    }
    this.PMA = locala.dkU;
    Log.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[] { Boolean.valueOf(ab.IT(this.PMA)), this.PMA });
    paramString.resetChatBubbleWidth(paramString.clickArea, paramString.PJa);
    if (ab.rR(locala.IOs))
    {
      paramString.PKu.setText(2131757339);
      paramString.PKv.setVisibility(8);
      if (d.oD(16))
      {
        paramString.PKt.setBackground(null);
        E(paramString.PKt, this.PMA);
        label179:
        paramString.gvw.setText(l.b(parama1.Pwc.getContext(), locala.nickname, paramString.gvw.getTextSize()));
        parama = locala.fMb;
        if (!af.isNullOrNil(this.PMA))
        {
          bg.aVF();
          as localas = com.tencent.mm.model.c.aSN().Kn(this.PMA);
          if ((localas != null) && (com.tencent.mm.contact.c.oR(localas.field_type))) {
            break label640;
          }
        }
      }
    }
    label640:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (af.isNullOrNil(parama)))
      {
        parama = this.PMA;
        if ((af.isNullOrNil(parama)) || (as.bjx(parama)) || (ab.IR(parama))) {
          i = 1;
        }
      }
      for (;;)
      {
        label304:
        boolean bool2 = ab.rR(locala.IOs);
        if ((i != 0) || (bool2)) {
          parama = "";
        }
        if (!af.isNullOrNil(parama))
        {
          paramString.PKv.setVisibility(0);
          paramString.PKv.setText(parama);
          label352:
          am.a(parama1, this.PMA, locala, paramString);
          paramString.clickArea.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
          paramString.clickArea.setOnClickListener(d(parama1));
          paramString.clickArea.setOnLongClickListener(c(parama1));
          paramString.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
          if (!gTW()) {
            break label611;
          }
          b(paramString, false);
          if ((paramca.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), paramca.field_msgId))) {
            break label590;
          }
          if (paramString.PIn != null) {
            paramString.PIn.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramInt, paramString, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
          AppMethodBeat.o(37184);
          return;
          paramString.PKt.setBackgroundDrawable(null);
          break;
          paramString.PKu.setText(2131757474);
          paramString.PKt.setBackgroundResource(2131231957);
          D(paramString.PKt, this.PMA);
          break label179;
          i = 0;
          break label304;
          paramString.PKv.setVisibility(8);
          break label352;
          label590:
          if (paramString.PIn != null) {
            paramString.PIn.setVisibility(8);
          }
        }
        label611:
        if (paramca.field_status < 2) {}
        for (;;)
        {
          b(paramString, bool1);
          break;
          bool1 = false;
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37186);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37186);
      return false;
    }
    paramMenuItem = parama.Pwc.getContext();
    if (com.tencent.mm.ui.chatting.k.bs(paramca))
    {
      h.a(paramMenuItem, paramMenuItem.getString(2131760907), "", paramMenuItem.getString(2131768713), null);
      AppMethodBeat.o(37186);
      return false;
    }
    if (com.tencent.mm.ui.chatting.k.bt(paramca))
    {
      h.a(paramMenuItem, paramMenuItem.getString(2131760908), "", paramMenuItem.getString(2131768713), null);
      AppMethodBeat.o(37186);
      return false;
    }
    paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 8);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37186);
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233823);
    int j = ((bq)paramView.getTag()).position;
    bg.aVF();
    ca.a locala = com.tencent.mm.model.c.aSQ().aEK(paramca.field_content);
    if ((locala.dkU == null) || (locala.dkU.length() <= 0)) {
      Log.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
    }
    this.PMA = locala.dkU;
    boolean bool = ab.rR(locala.IOs);
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZh, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (((i != 0) && (paramca.getType() != 66) && (!as.bjp(this.PhN.getTalkerUserName())) && (!as.bjq(this.PhN.getTalkerUserName()))) || (bool)) {
        paramm.a(j, 118, paramView.getContext().getString(2131764628), 2131690674);
      }
      if ((!paramca.gAt()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (paramca.gDl()) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker))) {
        paramm.a(j, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
      if (!this.PhN.gRN()) {
        paramm.a(j, 100, paramView.getContext().getString(2131757433), 2131690529);
      }
      AppMethodBeat.o(233823);
      return true;
    }
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233824);
    paramca.unsetOmittedFailResend();
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
    ((e)parama.bh(e.class)).bU(paramca);
    AppMethodBeat.o(233824);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 42) || (paramInt == 66));
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37187);
    ((com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
    paramView = (bq)paramView.getTag();
    String str1 = paramView.userName;
    String str2 = paramca.field_content;
    boolean bool2 = paramView.Pdm;
    if (paramca.field_isSend == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      am.a(parama, str1, str2, bool2, bool1, paramca);
      AppMethodBeat.o(37187);
      return true;
    }
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.c
 * JD-Core Version:    0.7.0.1
 */