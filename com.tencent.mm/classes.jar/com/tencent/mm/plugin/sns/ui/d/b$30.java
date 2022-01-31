package com.tencent.mm.plugin.sns.ui.d;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;

final class b$30
  extends c
{
  b$30(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenuInfo = paramView.getTag();
    Object localObject;
    if ((paramContextMenuInfo instanceof q))
    {
      paramContextMenuInfo = (q)paramContextMenuInfo;
      localObject = paramContextMenuInfo.oOz;
      if (d.SP("favorite")) {
        switch (((bxk)localObject).tNr.sPI)
        {
        default: 
          paramContextMenu.add(0, 3, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.a(paramContextMenu, af.bDF().OB(paramContextMenuInfo.bJQ));
      return;
      paramContextMenu.add(0, 4, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
      localObject = new do();
      ((do)localObject).bJZ.bJQ = paramContextMenuInfo.bJQ;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      if (((do)localObject).bKa.bJy)
      {
        paramContextMenu.add(0, 18, 0, paramView.getContext().getString(i.j.app_open));
        continue;
        paramContextMenu.add(0, 5, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
        continue;
        paramContextMenu.add(0, 9, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
        continue;
        paramContextMenu.add(0, 3, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
        localObject = new do();
        ((do)localObject).bJZ.bJQ = paramContextMenuInfo.bJQ;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        if (((do)localObject).bKa.bJy)
        {
          paramContextMenu.add(0, 18, 0, paramView.getContext().getString(i.j.app_open));
          continue;
          paramContextMenu.add(0, 10, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
          continue;
          paramContextMenu.add(0, 22, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
          continue;
          paramContextMenu.add(0, 2, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
        }
      }
    }
  }
  
  public final boolean dd(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof q))
    {
      localObject = (q)localObject;
      bxk localbxk = ((q)localObject).oOz;
      if ((localbxk.tNr.sPI == 10) || (localbxk.tNr.sPI == 17) || (localbxk.tNr.sPI == 22) || (localbxk.tNr.sPI == 23)) {
        return false;
      }
      this.ppl.poz.a(paramView, ((q)localObject).bJQ, localbxk);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.30
 * JD-Core Version:    0.7.0.1
 */