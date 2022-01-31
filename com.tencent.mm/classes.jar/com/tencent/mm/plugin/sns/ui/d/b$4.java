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
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.c.a.c;

final class b$4
  extends c
{
  b$4(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenuInfo = paramView.getTag();
    if (((paramContextMenuInfo instanceof a.c)) || ((paramContextMenuInfo instanceof n)) || ((paramContextMenuInfo instanceof aj)) || ((paramContextMenuInfo instanceof ao)) || ((paramContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.b.a.a)))
    {
      if (!(paramContextMenuInfo instanceof a.c)) {
        break label68;
      }
      paramContextMenuInfo = h.OA(((a.c)paramContextMenuInfo).bRV);
    }
    for (;;)
    {
      if (!paramContextMenuInfo.yr(32)) {}
      label68:
      do
      {
        do
        {
          return;
          if ((paramContextMenuInfo instanceof n))
          {
            paramContextMenuInfo = (n)paramContextMenuInfo;
            break;
          }
          if ((paramContextMenuInfo instanceof aj))
          {
            paramContextMenuInfo = (aj)paramContextMenuInfo;
            paramContextMenuInfo = af.bDF().OB(paramContextMenuInfo.bJQ);
            break;
          }
          if ((paramView.getTag() instanceof ao))
          {
            paramContextMenuInfo = ((ao)paramView.getTag()).bMB;
            paramContextMenuInfo = af.bDF().OB(paramContextMenuInfo);
            break;
          }
          if (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a)) {
            break label307;
          }
          paramContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.b.a.a)paramView.getTag()).oUH;
          break;
        } while ((paramContextMenuInfo.bFZ() == null) || (!paramContextMenuInfo.bFZ().bEJ()) || (b.a(this.ppl, paramContextMenuInfo).oAo != null));
        if (d.SP("favorite"))
        {
          if (paramContextMenuInfo.bFZ().bEJ()) {
            paramContextMenu.add(0, 20, 0, paramView.getContext().getString(i.j.plugin_favorite_opt));
          }
          do localdo = new do();
          localdo.bJZ.bJQ = paramContextMenuInfo.bGE();
          com.tencent.mm.sdk.b.a.udP.m(localdo);
          if (localdo.bKa.bJy) {
            paramContextMenu.add(0, 18, 0, paramView.getContext().getString(i.j.app_open));
          }
        }
      } while (paramContextMenuInfo == null);
      com.tencent.mm.plugin.sns.abtest.a.a(paramContextMenu, paramContextMenuInfo);
      return;
      label307:
      paramContextMenuInfo = null;
    }
  }
  
  public final boolean dd(View paramView)
  {
    Object localObject;
    if (((paramView.getTag() instanceof a.c)) || ((paramView.getTag() instanceof n)) || ((paramView.getTag() instanceof aj)) || ((paramView.getTag() instanceof ao)) || ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a)))
    {
      localObject = paramView.getTag();
      if ((localObject instanceof a.c)) {
        localObject = h.OA(((a.c)paramView.getTag()).bRV);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (!((n)localObject).yr(32))
        {
          return false;
          if ((localObject instanceof n))
          {
            localObject = (n)localObject;
            continue;
          }
          if ((localObject instanceof aj))
          {
            localObject = (aj)localObject;
            localObject = af.bDF().OB(((aj)localObject).bJQ);
            continue;
          }
          if ((paramView.getTag() instanceof ao))
          {
            localObject = ((ao)paramView.getTag()).bMB;
            localObject = af.bDF().OB((String)localObject);
            continue;
          }
          if ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a)) {
            localObject = ((com.tencent.mm.plugin.sns.ui.b.a.a)paramView.getTag()).oUH;
          }
        }
        else
        {
          if ((((n)localObject).bFZ() == null) || (!((n)localObject).bFZ().bEJ())) {
            return false;
          }
          this.ppl.poz.a(paramView, ((n)localObject).bGE(), ((n)localObject).bGe());
        }
      }
      else
      {
        return true;
        return false;
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.4
 * JD-Core Version:    0.7.0.1
 */