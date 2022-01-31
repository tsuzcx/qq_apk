package com.tencent.mm.ui.chatting.viewitems;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class q$c
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33004);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969112);
      ((View)localObject).setTag(new q.a().fh((View)localObject));
    }
    AppMethodBeat.o(33004);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33008);
    if (parambi.bCn())
    {
      l.al(parambi);
      bf.gw(parambi.field_msgId);
      parama.qT(true);
      AppMethodBeat.o(33008);
      return;
    }
    AppMethodBeat.o(33008);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33005);
    q.a locala = (q.a)parama;
    this.zzP = parama1;
    ((com.tencent.mm.ui.chatting.c.b.j)parama1.ay(com.tencent.mm.ui.chatting.c.b.j.class)).bh(parambi);
    parama = parambi.field_content;
    if (parama != null) {}
    for (parama = j.b.ab(parama, parambi.field_reserved);; parama = null)
    {
      f localf;
      if ((parama != null) && (parama.type == 1))
      {
        paramString = com.tencent.mm.pluginsdk.ui.d.j.d(locala.zUr.getContext(), parama.title, (int)locala.zUr.getTextSize());
        locala.zUr.af(paramString);
        locala.zUr.setClickable(true);
        localf = g.ca(parama.appId, true);
        if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
          break label388;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!g.dF(paramString))) {
          break label398;
        }
        locala.mCZ.setText(parama1.zJz.getMMResources().getString(2131298326, new Object[] { g.b(parama1.zJz.getContext(), localf, paramString) }));
        locala.mCZ.setVisibility(0);
        a(parama1, locala.mCZ, parama.appId);
        a(parama1, locala.mCZ, parama.appId);
        label253:
        if ((parambi.field_status != 2) && (parambi.field_status != 5)) {
          break label411;
        }
        locala.pNd.setVisibility(8);
      }
      for (;;)
      {
        a(paramInt, locala, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
        locala.zUr.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
        aw.aaz();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.zUr.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.zUr.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
          }
        }
        AppMethodBeat.o(33005);
        return;
        label388:
        paramString = localf.field_appName;
        break;
        label398:
        locala.mCZ.setVisibility(8);
        break label253;
        label411:
        locala.pNd.setVisibility(0);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33006);
    int i = ((az)paramView.getTag()).position;
    paramContextMenu.add(i, 102, 0, this.zzP.zJz.getMMResources().getString(2131298229));
    paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
    if (d.ahR("favorite")) {
      paramContextMenu.add(i, 116, 0, this.zzP.zJz.getMMResources().getString(2131302102));
    }
    if ((!parambi.dvV()) && ((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131298244));
    }
    if (!this.zzP.dJH()) {
      paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    }
    AppMethodBeat.o(33006);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33007);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33007);
      return false;
    case 102: 
      parama = (ClipboardManager)ah.getContext().getSystemService("clipboard");
      paramMenuItem = j.b.mY(parambi.field_content).title;
      parama.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.qEl;
      com.tencent.mm.plugin.secinforeport.a.a.i(1, parambi.field_msgSvrId, bo.apL(paramMenuItem));
      AppMethodBeat.o(33007);
      return false;
    }
    paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", parambi.field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
    parama.startActivity(paramMenuItem);
    AppMethodBeat.o(33007);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.c
 * JD-Core Version:    0.7.0.1
 */