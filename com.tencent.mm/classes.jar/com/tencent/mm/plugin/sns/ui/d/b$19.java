package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.plugin.sns.ui.widget.d;
import com.tencent.mm.protocal.protobuf.cds;

final class b$19
  extends c
{
  b$19(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(40267);
    long l;
    int i;
    if ((paramView.getTag() instanceof l))
    {
      paramView = (l)paramView.getTag();
      if (!d.fS(paramView.reJ.xOc, 16)) {
        paramContextMenu.add(0, 11, 0, this.skd.activity.getString(2131296895));
      }
      if ((paramView.jJA != null) && (paramView.jJA.equals(r.Zn()))) {
        paramContextMenu.add(0, 7, 0, this.skd.activity.getString(2131296901));
      }
      if (!d.fS(paramView.reJ.xOc, 16))
      {
        paramContextMenuInfo = paramView.rFY;
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramView.reJ.xNY != 0)
        {
          l = paramView.reJ.xNY;
          paramContextMenuInfo = aq.gm(paramContextMenuInfo, l);
          if (paramView.scene != 1) {
            break label243;
          }
          i = 2;
        }
      }
    }
    for (;;)
    {
      label179:
      paramView = aq.aaD(paramContextMenuInfo);
      if ((paramView != null) && (paramView.fon) && (!paramView.frX) && ((i & paramView.dqG) != 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label263;
        }
        aq.a(paramContextMenu, false);
        AppMethodBeat.o(40267);
        return;
        l = paramView.reJ.xOa;
        break;
        label243:
        if (paramView.scene != 2) {
          break label274;
        }
        i = 4;
        break label179;
      }
      label263:
      aq.b(paramContextMenu, false);
      AppMethodBeat.o(40267);
      return;
      label274:
      i = -1;
    }
  }
  
  public final boolean dU(View paramView)
  {
    AppMethodBeat.i(40268);
    if ((paramView.getTag() instanceof l))
    {
      Object localObject = (l)paramView.getTag();
      localObject = ag.cpf().abu(((l)localObject).rFY);
      this.skd.sjr.a(paramView, ((n)localObject).csH(), ((n)localObject).csh());
      AppMethodBeat.o(40268);
      return true;
    }
    AppMethodBeat.o(40268);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.19
 * JD-Core Version:    0.7.0.1
 */