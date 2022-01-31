package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

final class b$3
  extends c
{
  b$3(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(40243);
    paramView = (as)paramView.getTag();
    paramContextMenuInfo = ag.cpf().abu(paramView.czw);
    if (paramContextMenuInfo == null)
    {
      AppMethodBeat.o(40243);
      return;
    }
    paramContextMenu.add(0, 0, 0, this.skd.activity.getString(2131296895));
    if (d.ahR("favorite")) {
      paramContextMenu.add(0, 1, 0, this.skd.activity.getString(2131302102));
    }
    TimeLineObject localTimeLineObject = paramContextMenuInfo.csh();
    if ((paramView.rUm) || ((localTimeLineObject != null) && (localTimeLineObject.xTU != 1) && (!paramView.rUn)))
    {
      if (paramView.cvI()) {
        break label143;
      }
      aq.a(paramContextMenu, true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.a(paramContextMenu, paramContextMenuInfo);
      AppMethodBeat.o(40243);
      return;
      label143:
      aq.b(paramContextMenu, true);
    }
  }
  
  public final boolean dU(View paramView)
  {
    AppMethodBeat.i(40244);
    if ((paramView.getTag() instanceof as))
    {
      Object localObject = (as)paramView.getTag();
      localObject = ag.cpf().abu(((as)localObject).czw);
      if (localObject == null)
      {
        AppMethodBeat.o(40244);
        return false;
      }
      String str = ((n)localObject).csH();
      this.skd.sjr.a(paramView, str, ((n)localObject).csh());
      AppMethodBeat.o(40244);
      return true;
    }
    AppMethodBeat.o(40244);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.3
 * JD-Core Version:    0.7.0.1
 */