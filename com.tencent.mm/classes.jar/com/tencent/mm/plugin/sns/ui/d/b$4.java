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
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;

final class b$4
  extends c
{
  b$4(b paramb) {}
  
  public final void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(40246);
    paramContextMenuInfo = paramView.getTag();
    if (((paramContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramContextMenuInfo instanceof n)) || ((paramContextMenuInfo instanceof aj)) || ((paramContextMenuInfo instanceof ao)) || ((paramContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.c.a.a))) {
      if ((paramContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
        paramContextMenuInfo = h.abu(((BaseTimeLineItem.BaseViewHolder)paramContextMenuInfo).czw);
      }
    }
    for (;;)
    {
      if (!paramContextMenuInfo.Ex(32))
      {
        AppMethodBeat.o(40246);
        return;
        if ((paramContextMenuInfo instanceof n))
        {
          paramContextMenuInfo = (n)paramContextMenuInfo;
          continue;
        }
        if ((paramContextMenuInfo instanceof aj))
        {
          paramContextMenuInfo = (aj)paramContextMenuInfo;
          paramContextMenuInfo = ag.cpf().abv(paramContextMenuInfo.crk);
          continue;
        }
        if ((paramView.getTag() instanceof ao))
        {
          paramContextMenuInfo = ((ao)paramView.getTag()).ctV;
          paramContextMenuInfo = ag.cpf().abv(paramContextMenuInfo);
          continue;
        }
        if ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
          paramContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramView.getTag()).rMD;
        }
      }
      else
      {
        if ((paramContextMenuInfo.csb() == null) || (!paramContextMenuInfo.csb().cqp()))
        {
          AppMethodBeat.o(40246);
          return;
        }
        if (b.a(this.skd, paramContextMenuInfo).rpy != null)
        {
          AppMethodBeat.o(40246);
          return;
        }
        if (d.ahR("favorite"))
        {
          if (paramContextMenuInfo.csb().cqp()) {
            paramContextMenu.add(0, 20, 0, paramView.getContext().getString(2131302102));
          }
          dr localdr = new dr();
          localdr.crt.crk = paramContextMenuInfo.csH();
          com.tencent.mm.sdk.b.a.ymk.l(localdr);
          if (localdr.cru.cqS) {
            paramContextMenu.add(0, 18, 0, paramView.getContext().getString(2131297019));
          }
        }
        if (paramContextMenuInfo != null) {
          com.tencent.mm.plugin.sns.abtest.a.a(paramContextMenu, paramContextMenuInfo);
        }
        AppMethodBeat.o(40246);
        return;
      }
      paramContextMenuInfo = null;
    }
  }
  
  public final boolean dU(View paramView)
  {
    AppMethodBeat.i(40245);
    Object localObject;
    if (((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramView.getTag() instanceof n)) || ((paramView.getTag() instanceof aj)) || ((paramView.getTag() instanceof ao)) || ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)))
    {
      localObject = paramView.getTag();
      if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
        localObject = h.abu(((BaseTimeLineItem.BaseViewHolder)paramView.getTag()).czw);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (!((n)localObject).Ex(32))
        {
          AppMethodBeat.o(40245);
          return false;
          if ((localObject instanceof n))
          {
            localObject = (n)localObject;
            continue;
          }
          if ((localObject instanceof aj))
          {
            localObject = (aj)localObject;
            localObject = ag.cpf().abv(((aj)localObject).crk);
            continue;
          }
          if ((paramView.getTag() instanceof ao))
          {
            localObject = ((ao)paramView.getTag()).ctV;
            localObject = ag.cpf().abv((String)localObject);
            continue;
          }
          if ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
            localObject = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramView.getTag()).rMD;
          }
        }
        else
        {
          if ((((n)localObject).csb() == null) || (!((n)localObject).csb().cqp()))
          {
            AppMethodBeat.o(40245);
            return false;
          }
          this.skd.sjr.a(paramView, ((n)localObject).csH(), ((n)localObject).csh());
        }
      }
      else
      {
        AppMethodBeat.o(40245);
        return true;
        AppMethodBeat.o(40245);
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