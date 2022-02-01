package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import java.util.LinkedList;

final class bn$d
  implements View.OnCreateContextMenuListener
{
  private SnsInfo PNI;
  private dmz Qsr;
  private TimeLineObject RcF;
  private String hHB;
  private View nmf;
  private String url;
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(99236);
    paramContextMenuInfo = paramView.getTag();
    if ((paramContextMenuInfo instanceof s))
    {
      paramContextMenuInfo = (s)paramContextMenuInfo;
      TimeLineObject localTimeLineObject = paramContextMenuInfo.RcF;
      paramView.getContext();
      String str = bn.baN(localTimeLineObject.ContentObj.Url);
      if ((str == null) || (str.length() == 0))
      {
        AppMethodBeat.o(99236);
        return;
      }
      this.url = str;
      this.hHB = paramContextMenuInfo.hES;
      this.nmf = paramView;
      if (localTimeLineObject.ContentObj.Zpr.size() > 0) {}
      for (paramContextMenuInfo = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);; paramContextMenuInfo = null)
      {
        this.Qsr = paramContextMenuInfo;
        this.PNI = al.hgB().aZL(this.hHB);
        this.RcF = localTimeLineObject;
        if ((localTimeLineObject.ContentObj.Zpq != 10) && (localTimeLineObject.ContentObj.Zpq != 13)) {
          break;
        }
        AppMethodBeat.o(99236);
        return;
      }
      if (c.blq("favorite")) {
        switch (localTimeLineObject.ContentObj.Zpq)
        {
        default: 
          paramContextMenu.add(0, 3, 0, paramView.getContext().getString(b.j.plugin_favorite_opt));
        }
      }
    }
    for (;;)
    {
      if ((this.PNI != null) && (!this.PNI.getUserName().equals(al.hgg()))) {
        paramContextMenu.add(0, 8, 0, paramView.getContext().getString(b.j.contact_info_op_sns_permission));
      }
      AppMethodBeat.o(99236);
      return;
      paramContextMenu.add(0, 4, 0, paramView.getContext().getString(b.j.plugin_favorite_opt));
      continue;
      paramContextMenu.add(0, 11, 0, paramView.getContext().getString(b.j.plugin_favorite_opt));
      continue;
      paramContextMenu.add(0, 5, 0, paramView.getContext().getString(b.j.plugin_favorite_opt));
      continue;
      paramContextMenu.add(0, 9, 0, paramView.getContext().getString(b.j.plugin_favorite_opt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bn.d
 * JD-Core Version:    0.7.0.1
 */