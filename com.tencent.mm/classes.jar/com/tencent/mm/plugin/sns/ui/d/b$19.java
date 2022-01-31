package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.protocal.c.btd;

final class b$19
  extends c
{
  b$19(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    long l;
    int i;
    if ((paramView.getTag() instanceof l))
    {
      paramView = (l)paramView.getTag();
      paramContextMenu.add(0, 11, 0, this.ppl.activity.getString(i.j.app_copy));
      if ((paramView.hPY != null) && (paramView.hPY.equals(q.Gj()))) {
        paramContextMenu.add(0, 7, 0, this.ppl.activity.getString(i.j.app_delete));
      }
      paramContextMenuInfo = paramView.oOn;
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramView.oqc.tJu == 0) {
        break label193;
      }
      l = paramView.oqc.tJu;
      paramContextMenuInfo = ap.eK(paramContextMenuInfo, l);
      if (paramView.scene != 1) {
        break label205;
      }
      i = 2;
    }
    for (;;)
    {
      label146:
      paramView = ap.NJ(paramContextMenuInfo);
      if ((paramView != null) && (paramView.dYj) && (!paramView.ebE) && ((i & paramView.cCu) != 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label225;
        }
        ap.a(paramContextMenu, false);
        return;
        label193:
        l = paramView.oqc.tJx;
        break;
        label205:
        if (paramView.scene != 2) {
          break label231;
        }
        i = 4;
        break label146;
      }
      label225:
      ap.b(paramContextMenu, false);
      return;
      label231:
      i = -1;
    }
  }
  
  public final boolean dd(View paramView)
  {
    if ((paramView.getTag() instanceof l))
    {
      Object localObject = (l)paramView.getTag();
      localObject = af.bDF().OA(((l)localObject).oOn);
      this.ppl.poz.a(paramView, ((n)localObject).bGE(), ((n)localObject).bGe());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.19
 * JD-Core Version:    0.7.0.1
 */