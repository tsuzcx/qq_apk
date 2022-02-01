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
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bl;
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
      localObject = new af(paramLayoutInflater, 2131493434);
      ((View)localObject).setTag(new k.b().fQ((View)localObject));
    }
    AppMethodBeat.o(36917);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(36918);
    Object localObject = parambl.field_content;
    paramString = null;
    if (localObject != null) {
      paramString = com.tencent.mm.ai.k.b.ar((String)localObject, parambl.field_reserved);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(36918);
      return;
    }
    parambl = (k.b)parama;
    paramString = (k.a)paramString.ao(k.a.class);
    if (parambl.lRB != null) {
      parambl.lRB.setVisibility(8);
    }
    if (parambl.hIS != null) {
      parambl.hIS.setVisibility(8);
    }
    long l;
    if (paramString.state == 1)
    {
      parambl.GKX.setVisibility(0);
      parambl.GKZ.setVisibility(8);
      parambl.lKe.setText(paramString.appName);
      localObject = parambl.GKY;
      l = paramString.GKW;
      if (l >= 1073741824L)
      {
        parama = String.format("%.1fGB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F / 1024.0F) });
        ((TextView)localObject).setText(parama);
        o.ayJ().loadImage(paramString.iconUrl, parambl.oir);
        if (!h.t(parama1.GzJ.getContext(), paramString.appId)) {
          break label330;
        }
        parambl.GLd.setText(2131758141);
      }
    }
    for (;;)
    {
      parambl.mYI.setTag(paramString);
      parambl.mYI.setOnClickListener(this);
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
      parambl.GLd.setText(2131758139);
      continue;
      parambl.GKX.setVisibility(8);
      parambl.GKZ.setVisibility(0);
      parambl.GLa.setText(parama1.eWM());
      a.b.c(parambl.GLb, parama1.getTalkerUserName());
      parambl.GLc.setText(parama1.GzJ.getContext().getResources().getString(2131758153, new Object[] { paramString.appName }));
      parambl.GLd.setText(2131758144);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 671088689);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean faE()
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
        ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).ai(paramView.getContext(), locala.appId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.c
 * JD-Core Version:    0.7.0.1
 */