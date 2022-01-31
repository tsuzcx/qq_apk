package com.tencent.mm.plugin.sns.ui.d;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.vi;

final class b$30
  extends c
{
  b$30(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(40287);
    paramContextMenuInfo = paramView.getTag();
    Object localObject;
    if ((paramContextMenuInfo instanceof q))
    {
      paramContextMenuInfo = (q)paramContextMenuInfo;
      localObject = paramContextMenuInfo.rGk;
      if (d.ahR("favorite")) {
        switch (((TimeLineObject)localObject).xTS.wNZ)
        {
        default: 
          paramContextMenu.add(0, 3, 0, paramView.getContext().getString(2131302102));
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.abtest.a.a(paramContextMenu, ag.cpf().abv(paramContextMenuInfo.crk));
      AppMethodBeat.o(40287);
      return;
      paramContextMenu.add(0, 4, 0, paramView.getContext().getString(2131302102));
      localObject = new dr();
      ((dr)localObject).crt.crk = paramContextMenuInfo.crk;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if (((dr)localObject).cru.cqS)
      {
        paramContextMenu.add(0, 18, 0, paramView.getContext().getString(2131297019));
        continue;
        paramContextMenu.add(0, 5, 0, paramView.getContext().getString(2131302102));
        continue;
        paramContextMenu.add(0, 9, 0, paramView.getContext().getString(2131302102));
        continue;
        paramContextMenu.add(0, 3, 0, paramView.getContext().getString(2131302102));
        localObject = new dr();
        ((dr)localObject).crt.crk = paramContextMenuInfo.crk;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
        if (((dr)localObject).cru.cqS)
        {
          paramContextMenu.add(0, 18, 0, paramView.getContext().getString(2131297019));
          continue;
          paramContextMenu.add(0, 10, 0, paramView.getContext().getString(2131302102));
          continue;
          paramContextMenu.add(0, 22, 0, paramView.getContext().getString(2131302102));
          continue;
          paramContextMenu.add(0, 2, 0, paramView.getContext().getString(2131302102));
        }
      }
    }
  }
  
  public final boolean dU(View paramView)
  {
    AppMethodBeat.i(40286);
    Object localObject = paramView.getTag();
    if ((localObject instanceof q))
    {
      localObject = (q)localObject;
      TimeLineObject localTimeLineObject = ((q)localObject).rGk;
      if ((localTimeLineObject.xTS.wNZ == 10) || (localTimeLineObject.xTS.wNZ == 17) || (localTimeLineObject.xTS.wNZ == 22) || (localTimeLineObject.xTS.wNZ == 23))
      {
        AppMethodBeat.o(40286);
        return false;
      }
      this.skd.sjr.a(paramView, ((q)localObject).crk, localTimeLineObject);
      AppMethodBeat.o(40286);
      return true;
    }
    AppMethodBeat.o(40286);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.30
 * JD-Core Version:    0.7.0.1
 */