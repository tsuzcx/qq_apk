package com.tencent.mm.ui.chatting.viewitems;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class q$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33000);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969074);
      ((View)localObject).setTag(new q.a().fh((View)localObject));
    }
    AppMethodBeat.o(33000);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33001);
    this.zzP = parama1;
    ((com.tencent.mm.ui.chatting.c.b.j)parama1.ay(com.tencent.mm.ui.chatting.c.b.j.class)).bh(parambi);
    q.a locala = (q.a)parama;
    paramString = parambi.field_content;
    parama = paramString;
    if (parama1.dJG())
    {
      int i = parambi.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = parambi.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = j.b.ab(parama, parambi.field_reserved);; parama = null)
    {
      f localf;
      if ((parama != null) && (parama.type == 1))
      {
        localf = g.ca(parama.appId, true);
        if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
          break label428;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!g.dF(paramString))) {
          break label438;
        }
        locala.mCZ.setText(parama1.zJz.getMMResources().getString(2131298326, new Object[] { g.b(parama1.zJz.getContext(), localf, paramString) }));
        locala.mCZ.setVisibility(0);
        a(parama1, locala.mCZ, parama.appId);
        a(parama1, locala.mCZ, parama.appId);
        label253:
        if ((parama.dGR == null) || (parama.dGR.length() <= 0)) {
          break label451;
        }
        b(parama1, locala.zRY, az.auv(parama.dGR));
        locala.zRY.setVisibility(0);
      }
      for (;;)
      {
        locala.zUr.setClickable(true);
        paramString = com.tencent.mm.pluginsdk.ui.d.j.d(locala.zUr.getContext(), parama.title, (int)locala.zUr.getTextSize());
        locala.zUr.af(paramString);
        locala.zUr.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
        aw.aaz();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.zUr.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.zUr.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
          }
        }
        AppMethodBeat.o(33001);
        return;
        label428:
        paramString = localf.field_appName;
        break;
        label438:
        locala.mCZ.setVisibility(8);
        break label253;
        label451:
        locala.zRY.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33002);
    int i = ((az)paramView.getTag()).position;
    paramContextMenu.add(i, 102, 0, this.zzP.zJz.getMMResources().getString(2131298229));
    paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
    if (d.ahR("favorite")) {
      paramContextMenu.add(i, 116, 0, this.zzP.zJz.getMMResources().getString(2131302102));
    }
    if (bh.o(parambi)) {
      paramContextMenu.clear();
    }
    if (!this.zzP.dJH()) {
      paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    }
    AppMethodBeat.o(33002);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33003);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33003);
      return false;
    case 102: 
      paramMenuItem = (ClipboardManager)ah.getContext().getSystemService("clipboard");
      parama = j.b.mY(bf.b(parama.dJF(), parambi.field_content, parambi.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.qEl;
      com.tencent.mm.plugin.secinforeport.a.a.i(1, parambi.field_msgSvrId, bo.apL(parama));
      AppMethodBeat.o(33003);
      return false;
    }
    paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
    parama.startActivity(paramMenuItem);
    AppMethodBeat.o(33003);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.b
 * JD-Core Version:    0.7.0.1
 */