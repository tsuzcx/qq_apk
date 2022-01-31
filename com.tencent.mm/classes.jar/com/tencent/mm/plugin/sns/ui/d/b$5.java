package com.tencent.mm.plugin.sns.ui.d;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;

final class b$5
  extends c
{
  b$5(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(40248);
    paramContextMenuInfo = paramView.getTag();
    if (((paramContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramContextMenuInfo instanceof n)))
    {
      if (!(paramContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
        break label177;
      }
      paramContextMenuInfo = h.abu(((BaseTimeLineItem.BaseViewHolder)paramContextMenuInfo).czw);
    }
    for (;;)
    {
      Object localObject;
      com.tencent.mm.plugin.sns.storage.a locala;
      if (d.ahR("favorite"))
      {
        localObject = paramContextMenuInfo.csb();
        locala = b.a(this.skd, paramContextMenuInfo);
        if (((com.tencent.mm.plugin.sns.storage.b)localObject).cqo())
        {
          if (!((com.tencent.mm.plugin.sns.storage.b)localObject).cqk()) {
            break label192;
          }
          paramContextMenu.add(0, 2, 0, paramView.getContext().getString(2131302102));
        }
      }
      for (;;)
      {
        localObject = new dr();
        ((dr)localObject).crt.crk = paramContextMenuInfo.csH();
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
        if (((dr)localObject).cru.cqS) {
          paramContextMenu.add(0, 18, 0, paramView.getContext().getString(2131297019));
        }
        if (paramContextMenuInfo != null) {
          com.tencent.mm.plugin.sns.abtest.a.a(paramContextMenu, paramContextMenuInfo);
        }
        AppMethodBeat.o(40248);
        return;
        label177:
        if (!(paramContextMenuInfo instanceof n)) {
          break label222;
        }
        paramContextMenuInfo = (n)paramContextMenuInfo;
        break;
        label192:
        if (locala.rpg == 0) {
          paramContextMenu.add(0, 3, 0, paramView.getContext().getString(2131302102));
        }
      }
      label222:
      paramContextMenuInfo = null;
    }
  }
  
  public final boolean dU(View paramView)
  {
    AppMethodBeat.i(40247);
    Object localObject;
    if (((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramView.getTag() instanceof n)))
    {
      localObject = paramView.getTag();
      if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
        localObject = h.abu(((BaseTimeLineItem.BaseViewHolder)paramView.getTag()).czw);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        this.skd.sjr.a(paramView, ((n)localObject).csH(), ((n)localObject).csh());
      }
      AppMethodBeat.o(40247);
      return true;
      if ((localObject instanceof n))
      {
        localObject = (n)localObject;
        continue;
        AppMethodBeat.o(40247);
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