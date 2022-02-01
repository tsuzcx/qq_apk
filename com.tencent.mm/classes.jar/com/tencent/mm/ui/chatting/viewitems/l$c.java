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
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
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
      localObject = new aq(paramLayoutInflater, R.i.ecK);
      ((View)localObject).setTag(new l.b().ib((View)localObject));
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
      paramString = k.b.aG((String)localObject, paramca.field_reserved);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(36918);
      return;
    }
    paramca = (l.b)parama;
    paramString = (l.a)paramString.ar(l.a.class);
    if (paramca.maskView != null) {
      paramca.maskView.setVisibility(8);
    }
    if (paramca.checkBox != null) {
      paramca.checkBox.setVisibility(8);
    }
    long l;
    if (paramString.state == 1)
    {
      paramca.XfA.setVisibility(0);
      paramca.XfC.setVisibility(8);
      paramca.rgv.setText(paramString.appName);
      localObject = paramca.XfB;
      l = paramString.Xfz;
      if (l >= 1073741824L)
      {
        parama = String.format("%.1fGB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F / 1024.0F) });
        ((TextView)localObject).setText(parama);
        q.bml().loadImage(paramString.iconUrl, paramca.umI);
        if (!com.tencent.mm.pluginsdk.model.app.h.u(parama1.WQv.getContext(), paramString.appId)) {
          break label331;
        }
        paramca.XfG.setText(R.l.eBP);
      }
    }
    for (;;)
    {
      paramca.sEi.setTag(paramString);
      paramca.sEi.setOnClickListener(this);
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
      paramca.XfG.setText(R.l.eBO);
      continue;
      paramca.XfA.setVisibility(8);
      paramca.XfC.setVisibility(0);
      paramca.XfD.setText(parama1.hOp());
      a.b.c(paramca.XfE, parama1.getTalkerUserName());
      paramca.XfF.setText(parama1.WQv.getContext().getResources().getString(R.l.eBS, new Object[] { paramString.appName }));
      paramca.XfG.setText(R.l.eBR);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 671088689);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36919);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    localObject = (l.a)paramView.getTag();
    if (localObject == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36919);
      return;
    }
    if (((l.a)localObject).state == 1) {
      if (com.tencent.mm.pluginsdk.model.app.h.u(paramView.getContext(), ((l.a)localObject).appId)) {
        ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).at(paramView.getContext(), ((l.a)localObject).appId);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgDownloader$ChattingItemAppMsgDownloaderFrom", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36919);
      return;
      ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).a(paramView.getContext(), new Intent().putExtra("appId", ((l.a)localObject).appId), null);
      continue;
      ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).a(paramView.getContext(), null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.c
 * JD-Core Version:    0.7.0.1
 */