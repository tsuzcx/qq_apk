package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

public final class l$c
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
      localObject = new ap(paramLayoutInflater, R.i.gfA);
      ((View)localObject).setTag(new l.b().lx((View)localObject));
    }
    AppMethodBeat.o(36917);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(36918);
    Object localObject = paramcc.field_content;
    paramString = null;
    if (localObject != null) {
      paramString = k.b.aP((String)localObject, paramcc.field_reserved);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(36918);
      return;
    }
    paramcc = (l.b)parama;
    paramString = (l.a)paramString.aK(l.a.class);
    if (paramcc.maskView != null) {
      paramcc.maskView.setVisibility(8);
    }
    if (paramcc.checkBox != null) {
      paramcc.checkBox.setVisibility(8);
    }
    long l;
    if (paramString.state == 1)
    {
      paramcc.XoW.setVisibility(0);
      paramcc.aePE.setVisibility(8);
      paramcc.uov.setText(paramString.appName);
      localObject = paramcc.aePD;
      l = paramString.aePC;
      if (l >= 1073741824L)
      {
        parama = String.format("%.1fGB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F / 1024.0F) });
        ((TextView)localObject).setText(parama);
        r.bKe().loadImage(paramString.iconUrl, paramcc.xsU);
        if (!com.tencent.mm.pluginsdk.model.app.h.y(parama1.aezO.getContext(), paramString.appId)) {
          break label331;
        }
        paramcc.aePI.setText(R.l.gEX);
      }
    }
    for (;;)
    {
      paramcc.vJU.setTag(paramString);
      paramcc.vJU.setOnClickListener(this);
      AppMethodBeat.o(36918);
      return;
      if (l >= 1048576L)
      {
        parama = String.format("%.1fMB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F) });
        break;
      }
      parama = String.format("%.2fMB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F) });
      break;
      label331:
      paramcc.aePI.setText(R.l.gEW);
      continue;
      paramcc.XoW.setVisibility(8);
      paramcc.aePE.setVisibility(0);
      paramcc.aePF.setText(parama1.jrh());
      a.b.g(paramcc.aePG, parama1.getTalkerUserName());
      paramcc.aePH.setText(parama1.aezO.getContext().getResources().getString(R.l.gFa, new Object[] { paramString.appName }));
      paramcc.aePI.setText(R.l.gEZ);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 671088689);
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36919);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    localObject = (l.a)paramView.getTag();
    if (localObject == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36919);
      return;
    }
    if (((l.a)localObject).state == 1) {
      if (com.tencent.mm.pluginsdk.model.app.h.y(paramView.getContext(), ((l.a)localObject).appId)) {
        ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).au(paramView.getContext(), ((l.a)localObject).appId);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36919);
      return;
      ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).a(paramView.getContext(), new Intent().putExtra("appId", ((l.a)localObject).appId), null);
      continue;
      ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).a(paramView.getContext(), null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.c
 * JD-Core Version:    0.7.0.1
 */