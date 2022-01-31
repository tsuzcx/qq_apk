package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import java.util.LinkedList;

final class av$c
  implements View.OnCreateContextMenuListener
{
  private String ctV;
  private TimeLineObject rGk;
  private n rMD;
  private bcs reH;
  private View targetView;
  private String url;
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(39415);
    paramContextMenuInfo = paramView.getTag();
    if ((paramContextMenuInfo instanceof q))
    {
      paramContextMenuInfo = (q)paramContextMenuInfo;
      TimeLineObject localTimeLineObject = paramContextMenuInfo.rGk;
      paramView.getContext();
      String str = av.ack(localTimeLineObject.xTS.Url);
      if ((str == null) || (str.length() == 0))
      {
        AppMethodBeat.o(39415);
        return;
      }
      this.url = str;
      this.ctV = paramContextMenuInfo.crk;
      this.targetView = paramView;
      if (localTimeLineObject.xTS.wOa.size() > 0) {}
      for (paramContextMenuInfo = (bcs)localTimeLineObject.xTS.wOa.get(0);; paramContextMenuInfo = null)
      {
        this.reH = paramContextMenuInfo;
        this.rMD = ag.cpf().abv(this.ctV);
        this.rGk = localTimeLineObject;
        if ((localTimeLineObject.xTS.wNZ != 10) && (localTimeLineObject.xTS.wNZ != 13)) {
          break;
        }
        AppMethodBeat.o(39415);
        return;
      }
      if (d.ahR("favorite")) {
        switch (localTimeLineObject.xTS.wNZ)
        {
        default: 
          paramContextMenu.add(0, 3, 0, paramView.getContext().getString(2131302102));
        }
      }
    }
    for (;;)
    {
      if ((this.rMD != null) && (!this.rMD.field_userName.equals(ag.coK()))) {
        paramContextMenu.add(0, 8, 0, paramView.getContext().getString(2131298685));
      }
      AppMethodBeat.o(39415);
      return;
      paramContextMenu.add(0, 4, 0, paramView.getContext().getString(2131302102));
      continue;
      paramContextMenu.add(0, 5, 0, paramView.getContext().getString(2131302102));
      continue;
      paramContextMenu.add(0, 9, 0, paramView.getContext().getString(2131302102));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av.c
 * JD-Core Version:    0.7.0.1
 */