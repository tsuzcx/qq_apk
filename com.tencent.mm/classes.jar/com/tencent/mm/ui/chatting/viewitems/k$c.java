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
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class k$c
  extends c
  implements View.OnClickListener
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36917);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493434);
      ((View)localObject).setTag(new k.b().gd((View)localObject));
    }
    AppMethodBeat.o(36917);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(36918);
    Object localObject = parambo.field_content;
    paramString = null;
    if (localObject != null) {
      paramString = com.tencent.mm.ah.k.b.az((String)localObject, parambo.field_reserved);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(36918);
      return;
    }
    parambo = (k.b)parama;
    paramString = (k.a)paramString.ao(k.a.class);
    if (parambo.gGk != null) {
      parambo.gGk.setVisibility(8);
    }
    if (parambo.ijt != null) {
      parambo.ijt.setVisibility(8);
    }
    long l;
    if (paramString.state == 1)
    {
      parambo.IkU.setVisibility(0);
      parambo.IkW.setVisibility(8);
      parambo.mmb.setText(paramString.appName);
      localObject = parambo.IkV;
      l = paramString.IkT;
      if (l >= 1073741824L)
      {
        parama = String.format("%.1fGB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F / 1024.0F) });
        ((TextView)localObject).setText(parama);
        o.aFB().loadImage(paramString.iconUrl, parambo.oLR);
        if (!h.t(parama1.HZF.getContext(), paramString.appId)) {
          break label330;
        }
        parambo.Ila.setText(2131758141);
      }
    }
    for (;;)
    {
      parambo.nBh.setTag(paramString);
      parambo.nBh.setOnClickListener(this);
      AppMethodBeat.o(36918);
      return;
      if (l >= 1048576L)
      {
        parama = String.format("%.1fMB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F) });
        break;
      }
      parama = String.format("%.2fMB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F) });
      break;
      label330:
      parambo.Ila.setText(2131758139);
      continue;
      parambo.IkU.setVisibility(8);
      parambo.IkW.setVisibility(0);
      parambo.IkX.setText(parama1.fmy());
      a.b.c(parambo.IkY, parama1.getTalkerUserName());
      parambo.IkZ.setText(parama1.HZF.getContext().getResources().getString(2131758153, new Object[] { paramString.appName }));
      parambo.Ila.setText(2131758144);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 671088689);
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36919);
    k.a locala = (k.a)paramView.getTag();
    if (locala == null)
    {
      AppMethodBeat.o(36919);
      return;
    }
    if (locala.state == 1)
    {
      if (h.t(paramView.getContext(), locala.appId))
      {
        ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).aj(paramView.getContext(), locala.appId);
        AppMethodBeat.o(36919);
        return;
      }
      ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(paramView.getContext(), new Intent().putExtra("appId", locala.appId), null);
      AppMethodBeat.o(36919);
      return;
    }
    ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(paramView.getContext(), null, null);
    AppMethodBeat.o(36919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.c
 * JD-Core Version:    0.7.0.1
 */