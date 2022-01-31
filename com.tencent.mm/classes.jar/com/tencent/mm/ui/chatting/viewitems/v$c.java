package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.e;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class v$c
  extends c
  implements s.n
{
  private String zUX;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33113);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969115);
      ((View)localObject).setTag(new v.a().A((View)localObject, false));
    }
    AppMethodBeat.o(33113);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33118);
    parambi.dye();
    aw.aaz();
    com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
    ((e)parama.ay(e.class)).bc(parambi);
    AppMethodBeat.o(33118);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    int j = 1;
    AppMethodBeat.i(33114);
    this.zzP = parama1;
    v.a locala = (v.a)parama;
    aw.aaz();
    bi.a locala1 = com.tencent.mm.model.c.YC().Ty(parambi.field_content);
    if ((locala1.tac == null) || (locala1.tac.length() <= 0)) {
      ab.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
    }
    this.zUX = locala1.tac;
    ab.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[] { Boolean.valueOf(t.nU(this.zUX)), this.zUX });
    v.a.ar(locala.jYu, locala.zSN);
    if (t.ku(locala1.uOT))
    {
      locala.zUV.setText(2131298146);
      locala.zUW.setVisibility(8);
      if (d.fv(16))
      {
        locala.zUU.setBackground(null);
        x(locala.zUU, this.zUX);
        label177:
        locala.egr.setText(j.b(parama1.zJz.getContext(), locala1.nickname, locala.egr.getTextSize()));
        parama = locala1.dCJ;
        if (!ah.isNullOrNil(this.zUX))
        {
          aw.aaz();
          paramString = com.tencent.mm.model.c.YA().arw(this.zUX);
          if ((paramString != null) && (com.tencent.mm.n.a.je(paramString.field_type))) {
            break label688;
          }
        }
      }
    }
    label646:
    label688:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (ah.isNullOrNil(parama)))
      {
        paramString = this.zUX;
        i = j;
        parama = paramString;
        if (!ah.isNullOrNil(paramString))
        {
          i = j;
          parama = paramString;
          if (!ad.ari(paramString))
          {
            if (!t.nS(paramString)) {
              break label603;
            }
            parama = paramString;
            i = j;
          }
        }
      }
      for (;;)
      {
        label324:
        boolean bool = t.ku(locala1.uOT);
        if ((i != 0) || (bool)) {
          parama = "";
        }
        if (!ah.isNullOrNil(parama))
        {
          locala.zUW.setVisibility(0);
          locala.zUW.setText(parama);
          label373:
          v.a(parama1, this.zUX, locala1, locala);
          locala.jYu.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
          locala.jYu.setOnClickListener(d(parama1));
          locala.jYu.setOnLongClickListener(c(parama1));
          locala.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
          if (!dLr()) {
            break label646;
          }
          if (locala.pNd != null) {
            locala.pNd.setVisibility(8);
          }
          if ((parambi.field_status != 2) || (!a((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class), parambi.field_msgId))) {
            break label625;
          }
          if (locala.zSm != null) {
            locala.zSm.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramInt, locala, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
          AppMethodBeat.o(33114);
          return;
          locala.zUU.setBackgroundDrawable(null);
          break;
          locala.zUV.setText(2131298269);
          locala.zUU.setBackgroundResource(2130838493);
          w(locala.zUU, this.zUX);
          break label177;
          label603:
          i = 0;
          parama = paramString;
          break label324;
          locala.zUW.setVisibility(8);
          break label373;
          label625:
          if (locala.zSm != null)
          {
            locala.zSm.setVisibility(8);
            continue;
            if (locala.pNd != null)
            {
              locala.pNd.setVisibility(0);
              if (parambi.field_status >= 2) {
                locala.pNd.setVisibility(8);
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33115);
    int i = ((az)paramView.getTag()).position;
    aw.aaz();
    bi.a locala = com.tencent.mm.model.c.YC().Ty(parambi.field_content);
    if ((locala.tac == null) || (locala.tac.length() <= 0)) {
      ab.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
    }
    this.zUX = locala.tac;
    if (t.ku(locala.uOT)) {
      paramContextMenu.add(i, 118, 0, paramView.getContext().getString(2131302650));
    }
    if ((!parambi.dvV()) && ((parambi.field_status == 2) || (parambi.dGV == 1)) && (parambi.dxR()) && (a(parambi, this.zzP)) && (auk(parambi.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131298244));
    }
    if (!this.zzP.dJH()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298232));
    }
    AppMethodBeat.o(33115);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33116);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33116);
      return false;
    }
    paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 8);
    paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
    parama.startActivity(paramMenuItem);
    AppMethodBeat.o(33116);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 42) || (paramInt == 66));
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33117);
    paramView = (az)paramView.getTag();
    String str1 = paramView.userName;
    String str2 = parambi.field_content;
    boolean bool2 = paramView.zvB;
    if (parambi.field_isSend == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      v.a(parama, str1, str2, bool2, bool1, parambi);
      AppMethodBeat.o(33117);
      return true;
    }
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.c
 * JD-Core Version:    0.7.0.1
 */