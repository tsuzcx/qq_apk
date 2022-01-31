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
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e;

public final class j$c
  extends c
  implements View.OnClickListener
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_appmsg_downloader);
      ((View)localObject).setTag(new j.b().dR((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    String str = parambi.field_content;
    paramString = null;
    if (str != null) {
      paramString = g.a.M(str, parambi.field_reserved);
    }
    if (paramString == null) {
      return;
    }
    parambi = (j.b)parama;
    paramString = (j.a)paramString.A(j.a.class);
    if (parambi.hoY != null) {
      parambi.hoY.setVisibility(8);
    }
    if (parambi.khV != null) {
      parambi.khV.setVisibility(8);
    }
    long l;
    if (paramString.state == 1)
    {
      parambi.vCI.setVisibility(0);
      parambi.vCK.setVisibility(8);
      parambi.izy.setText(paramString.appName);
      parama1 = parambi.vCJ;
      l = paramString.vCH;
      if (l >= 1073741824L)
      {
        parama = String.format("%.1fGB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F / 1024.0F) });
        parama1.setText(parama);
        o.ON().a(paramString.iconUrl, parambi.iSF);
        parambi.vCO.setText(R.l.downloaderapp_install);
      }
    }
    for (;;)
    {
      parambi.ifA.setTag(paramString);
      parambi.ifA.setOnClickListener(this);
      return;
      if (l >= 1048576L)
      {
        parama = String.format("%.1fMB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F) });
        break;
      }
      parama = String.format("%.2fMB", new Object[] { Float.valueOf((float)l / 1024.0F / 1024.0F) });
      break;
      parambi.vCI.setVisibility(8);
      parambi.vCK.setVisibility(0);
      parambi.vCL.setText(parama1.cDP());
      a.b.a(parambi.vCM, parama1.getTalkerUserName());
      parambi.vCN.setText(parama1.vtz.getContext().getResources().getString(R.l.downloaderapp_welcome, new Object[] { paramString.appName }));
      parambi.vCO.setText(R.l.downloaderapp_progress);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 671088689);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return false;
  }
  
  final boolean bfO()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    j.a locala = (j.a)paramView.getTag();
    if (locala == null) {
      return;
    }
    if (locala.state == 1)
    {
      ((com.tencent.mm.plugin.downloader_app.a.a)g.r(com.tencent.mm.plugin.downloader_app.a.a.class)).a(paramView.getContext(), new Intent().putExtra("appId", locala.appId), null);
      return;
    }
    ((com.tencent.mm.plugin.downloader_app.a.a)g.r(com.tencent.mm.plugin.downloader_app.a.a.class)).a(paramView.getContext(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.j.c
 * JD-Core Version:    0.7.0.1
 */