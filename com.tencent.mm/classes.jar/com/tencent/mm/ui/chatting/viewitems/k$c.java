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
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
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
      localObject = new ah(paramLayoutInflater, 2131493434);
      ((View)localObject).setTag(new k.b().gu((View)localObject));
    }
    AppMethodBeat.o(36917);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(36918);
    Object localObject = parambu.field_content;
    paramString = null;
    if (localObject != null) {
      paramString = com.tencent.mm.ai.k.b.aA((String)localObject, parambu.field_reserved);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(36918);
      return;
    }
    parambu = (k.b)parama;
    paramString = (k.a)paramString.ao(k.a.class);
    if (parambu.gZU != null) {
      parambu.gZU.setVisibility(8);
    }
    if (parambu.iCK != null) {
      parambu.iCK.setVisibility(8);
    }
    long l;
    if (paramString.state == 1)
    {
      parambu.Kbs.setVisibility(0);
      parambu.Kbu.setVisibility(8);
      parambu.mMD.setText(paramString.appName);
      localObject = parambu.Kbt;
      l = paramString.Kbr;
      if (l >= 1073741824L)
      {
        parama = String.format("%.1fGB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F / 1024.0F) });
        ((TextView)localObject).setText(parama);
        q.aIJ().loadImage(paramString.iconUrl, parambu.ppz);
        if (!h.s(parama1.JOR.getContext(), paramString.appId)) {
          break label330;
        }
        parambu.Kby.setText(2131758141);
      }
    }
    for (;;)
    {
      parambu.odh.setTag(paramString);
      parambu.odh.setOnClickListener(this);
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
      parambu.Kby.setText(2131758139);
      continue;
      parambu.Kbs.setVisibility(8);
      parambu.Kbu.setVisibility(0);
      parambu.Kbv.setText(parama1.fCR());
      a.b.c(parambu.Kbw, parama1.getTalkerUserName());
      parambu.Kbx.setText(parama1.JOR.getContext().getResources().getString(2131758153, new Object[] { paramString.appName }));
      parambu.Kby.setText(2131758144);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 671088689);
  }
  
  public final boolean fHh()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36919);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    localObject = (k.a)paramView.getTag();
    if (localObject == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36919);
      return;
    }
    if (((k.a)localObject).state == 1) {
      if (h.s(paramView.getContext(), ((k.a)localObject).appId)) {
        ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).ai(paramView.getContext(), ((k.a)localObject).appId);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36919);
      return;
      ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(paramView.getContext(), new Intent().putExtra("appId", ((k.a)localObject).appId), null);
      continue;
      ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(paramView.getContext(), null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.k.c
 * JD-Core Version:    0.7.0.1
 */