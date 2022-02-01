package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
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
      localObject = new an(paramLayoutInflater, 2131493529);
      ((View)localObject).setTag(new k.b().gP((View)localObject));
    }
    AppMethodBeat.o(36917);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36918);
    Object localObject = paramca.field_content;
    paramString = null;
    if (localObject != null) {
      paramString = com.tencent.mm.ag.k.b.aD((String)localObject, paramca.field_reserved);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(36918);
      return;
    }
    paramca = (k.b)parama;
    paramString = (k.a)paramString.as(k.a.class);
    if (paramca.maskView != null) {
      paramca.maskView.setVisibility(8);
    }
    if (paramca.checkBox != null) {
      paramca.checkBox.setVisibility(8);
    }
    long l;
    if (paramString.state == 1)
    {
      paramca.PKa.setVisibility(0);
      paramca.PKc.setVisibility(8);
      paramca.oeJ.setText(paramString.appName);
      localObject = paramca.PKb;
      l = paramString.PJZ;
      if (l >= 1073741824L)
      {
        parama = String.format("%.1fGB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F / 1024.0F) });
        ((TextView)localObject).setText(parama);
        q.bcV().loadImage(paramString.iconUrl, paramca.qLw);
        if (!h.s(parama1.Pwc.getContext(), paramString.appId)) {
          break label330;
        }
        paramca.PKg.setText(2131758414);
      }
    }
    for (;;)
    {
      paramca.puO.setTag(paramString);
      paramca.puO.setOnClickListener(this);
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
      paramca.PKg.setText(2131758412);
      continue;
      paramca.PKa.setVisibility(8);
      paramca.PKc.setVisibility(0);
      paramca.PKd.setText(parama1.gOZ());
      a.b.c(paramca.PKe, parama1.getTalkerUserName());
      paramca.PKf.setText(parama1.Pwc.getContext().getResources().getString(2131758426, new Object[] { paramString.appName }));
      paramca.PKg.setText(2131758417);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 671088689);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36919);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = (k.a)paramView.getTag();
    if (localObject == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36919);
      return;
    }
    if (((k.a)localObject).state == 1) {
      if (h.s(paramView.getContext(), ((k.a)localObject).appId)) {
        ((com.tencent.mm.plugin.downloader_app.api.c)g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).at(paramView.getContext(), ((k.a)localObject).appId);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36919);
      return;
      ((com.tencent.mm.plugin.downloader_app.api.c)g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(paramView.getContext(), new Intent().putExtra("appId", ((k.a)localObject).appId), null);
      continue;
      ((com.tencent.mm.plugin.downloader_app.api.c)g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(paramView.getContext(), null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.c
 * JD-Core Version:    0.7.0.1
 */