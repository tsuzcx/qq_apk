package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.ai;

public final class an$a
  extends c
{
  private an.c zXz;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  private an.c dLw()
  {
    AppMethodBeat.i(33334);
    if (this.zXz == null) {
      this.zXz = new an.c(this.zzP);
    }
    an.c localc = this.zXz;
    AppMethodBeat.o(33334);
    return localc;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33335);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969087);
      ((View)localObject).setTag(new an.d().A((View)localObject, true));
    }
    AppMethodBeat.o(33335);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33336);
    this.zzP = parama1;
    parama = (an.d)parama;
    an.d.a(parama, parambi, true, paramInt, parama1, dLw(), c(parama1));
    parambi = parambi.dGR;
    if ((parambi == null) || (parambi.length() == 0))
    {
      parama.zRY.setVisibility(8);
      AppMethodBeat.o(33336);
      return;
    }
    parama.zRY.setVisibility(0);
    b(parama1, parama.zRY, az.auv(parambi));
    AppMethodBeat.o(33336);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33337);
    aw.aaz();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      int i = ((az)paramView.getTag()).position;
      s locals = o.alE().vd(parambi.field_imgPath);
      paramContextMenu.add(i, 130, 0, paramView.getContext().getString(2131298237));
      paramContextMenu.add(i, 107, 0, paramView.getContext().getString(2131302650));
      if (d.ahR("favorite")) {
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131302102));
      }
      dr localdr = new dr();
      localdr.crt.cpO = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.ymk.l(localdr);
      if (localdr.cru.cqS) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131298238));
      }
      if ((locals != null) && ((locals.status == 199) || (locals.status == 199)) && (f.aeQ()) && (!this.zzP.dJH())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131298228));
      }
      if (bh.o(parambi))
      {
        paramContextMenu.clear();
        paramContextMenu.add(i, 130, 0, paramView.getContext().getString(2131298237));
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298233));
      }
    }
    AppMethodBeat.o(33337);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33338);
    ((ai)parama.ay(ai.class)).a(paramMenuItem, parambi);
    AppMethodBeat.o(33338);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 43);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33339);
    dLw().onClick(paramView);
    AppMethodBeat.o(33339);
    return true;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.a
 * JD-Core Version:    0.7.0.1
 */