package com.tencent.mm.plugin.sns.ui.d;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.c.a.c;

final class b$5
  extends c
{
  b$5(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenuInfo = paramView.getTag();
    if (((paramContextMenuInfo instanceof a.c)) || ((paramContextMenuInfo instanceof n)))
    {
      if (!(paramContextMenuInfo instanceof a.c)) {
        break label169;
      }
      paramContextMenuInfo = h.OA(((a.c)paramContextMenuInfo).bRV);
    }
    for (;;)
    {
      Object localObject;
      com.tencent.mm.plugin.sns.storage.a locala;
      if (d.SP("favorite"))
      {
        localObject = paramContextMenuInfo.bFZ();
        locala = b.a(this.ppl, paramContextMenuInfo);
        if (((com.tencent.mm.plugin.sns.storage.b)localObject).bEI())
        {
          if (!((com.tencent.mm.plugin.sns.storage.b)localObject).bEE()) {
            break label184;
          }
          paramContextMenu.add(0, 2, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
        }
      }
      for (;;)
      {
        localObject = new do();
        ((do)localObject).bJZ.bJQ = paramContextMenuInfo.bGE();
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        if (((do)localObject).bKa.bJy) {
          paramContextMenu.add(0, 18, 0, paramView.getContext().getString(i.j.app_open));
        }
        if (paramContextMenuInfo != null) {
          com.tencent.mm.plugin.sns.abtest.a.a(paramContextMenu, paramContextMenuInfo);
        }
        return;
        label169:
        if (!(paramContextMenuInfo instanceof n)) {
          break label215;
        }
        paramContextMenuInfo = (n)paramContextMenuInfo;
        break;
        label184:
        if (locala.ozW == 0) {
          paramContextMenu.add(0, 3, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
        }
      }
      label215:
      paramContextMenuInfo = null;
    }
  }
  
  public final boolean dd(View paramView)
  {
    Object localObject;
    if (((paramView.getTag() instanceof a.c)) || ((paramView.getTag() instanceof n)))
    {
      localObject = paramView.getTag();
      if ((localObject instanceof a.c)) {
        localObject = h.OA(((a.c)paramView.getTag()).bRV);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        this.ppl.poz.a(paramView, ((n)localObject).bGE(), ((n)localObject).bGe());
      }
      return true;
      if ((localObject instanceof n))
      {
        localObject = (n)localObject;
        continue;
        return false;
      }
      else
      {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.5
 * JD-Core Version:    0.7.0.1
 */