package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.protocal.c.bxk;

final class b$3
  extends c
{
  b$3(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (ar)paramView.getTag();
    paramContextMenuInfo = af.bDF().OA(paramView.bRV);
    if (paramContextMenuInfo == null) {
      return;
    }
    paramContextMenu.add(0, 0, 0, this.ppl.activity.getString(i.j.app_copy));
    if (d.SP("favorite")) {
      paramContextMenu.add(0, 1, 0, this.ppl.activity.getString(i.j.plugin_favorite_opt));
    }
    bxk localbxk = paramContextMenuInfo.bGe();
    if ((paramView.pbD) || ((localbxk != null) && (localbxk.tNt != 1) && (!paramView.pbE)))
    {
      if (paramView.bJh()) {
        break label130;
      }
      ap.a(paramContextMenu, true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.a(paramContextMenu, paramContextMenuInfo);
      return;
      label130:
      ap.b(paramContextMenu, true);
    }
  }
  
  public final boolean dd(View paramView)
  {
    if ((paramView.getTag() instanceof ar))
    {
      Object localObject = (ar)paramView.getTag();
      localObject = af.bDF().OA(((ar)localObject).bRV);
      if (localObject == null) {
        return false;
      }
      String str = ((n)localObject).bGE();
      this.ppl.poz.a(paramView, str, ((n)localObject).bGe());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.3
 * JD-Core Version:    0.7.0.1
 */