package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class j$c
  extends c
  implements View.OnClickListener
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32933);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969067);
      ((View)localObject).setTag(new j.b().fb((View)localObject));
    }
    AppMethodBeat.o(32933);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32934);
    Object localObject = parambi.field_content;
    paramString = null;
    if (localObject != null) {
      paramString = com.tencent.mm.af.j.b.ab((String)localObject, parambi.field_reserved);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(32934);
      return;
    }
    parambi = (j.b)parama;
    paramString = (j.a)paramString.R(j.a.class);
    if (parambi.jbK != null) {
      parambi.jbK.setVisibility(8);
    }
    if (parambi.mCC != null) {
      parambi.mCC.setVisibility(8);
    }
    long l;
    if (paramString.state == 1)
    {
      parambi.zTL.setVisibility(0);
      parambi.zTN.setVisibility(8);
      parambi.iVS.setText(paramString.appName);
      localObject = parambi.zTM;
      l = paramString.zTK;
      if (l >= 1073741824L)
      {
        parama = String.format("%.1fGB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F / 1024.0F) });
        ((TextView)localObject).setText(parama);
        o.ahG().a(paramString.iconUrl, parambi.lbp);
        if (!com.tencent.mm.pluginsdk.model.app.g.u(parama1.zJz.getContext(), paramString.appId)) {
          break label330;
        }
        parambi.zTR.setText(2131299038);
      }
    }
    for (;;)
    {
      parambi.jXr.setTag(paramString);
      parambi.jXr.setOnClickListener(this);
      AppMethodBeat.o(32934);
      return;
      if (l >= 1048576L)
      {
        parama = String.format("%.1fMB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F) });
        break;
      }
      parama = String.format("%.2fMB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F) });
      break;
      label330:
      parambi.zTR.setText(2131299036);
      continue;
      parambi.zTL.setVisibility(8);
      parambi.zTN.setVisibility(0);
      parambi.zTO.setText(parama1.dHF());
      a.b.c(parambi.zTP, parama1.getTalkerUserName());
      parambi.zTQ.setText(parama1.zJz.getContext().getResources().getString(2131299050, new Object[] { paramString.appName }));
      parambi.zTR.setText(2131299041);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 671088689);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  final boolean dLp()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(32935);
    j.a locala = (j.a)paramView.getTag();
    if (locala == null)
    {
      AppMethodBeat.o(32935);
      return;
    }
    if (locala.state == 1)
    {
      if (com.tencent.mm.pluginsdk.model.app.g.u(paramView.getContext(), locala.appId))
      {
        ((d)com.tencent.mm.kernel.g.E(d.class)).aj(paramView.getContext(), locala.appId);
        AppMethodBeat.o(32935);
        return;
      }
      ((d)com.tencent.mm.kernel.g.E(d.class)).a(paramView.getContext(), new Intent().putExtra("appId", locala.appId), null);
      AppMethodBeat.o(32935);
      return;
    }
    ((d)com.tencent.mm.kernel.g.E(d.class)).a(paramView.getContext(), null, null);
    AppMethodBeat.o(32935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.c
 * JD-Core Version:    0.7.0.1
 */