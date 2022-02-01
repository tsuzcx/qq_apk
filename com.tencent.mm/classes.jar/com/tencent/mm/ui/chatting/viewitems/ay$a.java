package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.d.b.as;

public final class ay$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  private ay.c KCB;
  
  private ay.c fLN()
  {
    AppMethodBeat.i(37436);
    if (this.KCB == null) {
      this.KCB = new ay.c(this.JWz);
    }
    ay.c localc = this.KCB;
    AppMethodBeat.o(37436);
    return localc;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37437);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493460);
      ((View)localObject).setTag(new ay.d().E((View)localObject, true));
    }
    AppMethodBeat.o(37437);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37438);
    this.JWz = parama1;
    ay.d.a((ay.d)parama, parambv, true, paramInt, parama1, fLN(), c(parama1));
    AppMethodBeat.o(37438);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37440);
    ((as)parama.bh(as.class)).a(paramMenuItem, parambv);
    AppMethodBeat.o(37440);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187897);
    bc.aCg();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      int i = ((bk)paramView.getTag()).position;
      s locals = o.aNh().HD(parambv.field_imgPath);
      paraml.a(i, 130, paramView.getContext().getString(2131757227), 2131690498);
      paraml.a(i, 107, paramView.getContext().getString(2131762559), 2131690478);
      if (d.aJN("favorite")) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
      ec localec = new ec();
      localec.dql.msgId = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l(localec);
      if (localec.dqm.dpK) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((locals != null) && ((locals.status == 199) || (locals.status == 199)) && (g.aFR()) && (!this.JWz.fJD())) {
        paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
      if (bn.z(parambv))
      {
        paraml.clear();
        paraml.a(i, 130, paramView.getContext().getString(2131757227), 2131690498);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757222), 2131690384);
      }
    }
    AppMethodBeat.o(187897);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37441);
    fLN().onClick(paramView);
    AppMethodBeat.o(37441);
    return true;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay.a
 * JD-Core Version:    0.7.0.1
 */