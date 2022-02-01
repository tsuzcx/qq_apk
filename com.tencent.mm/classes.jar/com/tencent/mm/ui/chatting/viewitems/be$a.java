package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.e.a;

public final class be$a
  extends c
{
  private be.c PPr;
  private a PhN;
  
  private be.c cP(ca paramca)
  {
    AppMethodBeat.i(233944);
    if (this.PPr == null) {
      this.PPr = new be.c(this.PhN);
    }
    be.c.a(this.PPr, 0);
    if (br.D(paramca)) {
      be.c.a(this.PPr, 2);
    }
    paramca = this.PPr;
    AppMethodBeat.o(233944);
    return paramca;
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
      localObject = new an(paramLayoutInflater, 2131493562);
      ((View)localObject).setTag(new be.d().G((View)localObject, true));
    }
    AppMethodBeat.o(37437);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37438);
    this.PhN = parama1;
    be.d.a((be.d)parama, paramca, true, paramInt, parama1, cP(paramca), c(parama1));
    AppMethodBeat.o(37438);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37440);
    ((av)parama.bh(av.class)).a(paramMenuItem, paramca);
    AppMethodBeat.o(37440);
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233945);
    bg.aVF();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      int i = ((bq)paramView.getTag()).position;
      s locals = o.bhj().Qq(paramca.field_imgPath);
      paramm.a(i, 130, paramView.getContext().getString(2131757439), 2131690707);
      paramm.a(i, 107, paramView.getContext().getString(2131764628), 2131690674);
      if (com.tencent.mm.br.c.aZU("favorite")) {
        paramm.a(i, 116, paramView.getContext().getString(2131763947), 2131690551);
      }
      ef localef = new ef();
      localef.dHy.msgId = paramca.field_msgId;
      EventCenter.instance.publish(localef);
      if (localef.dHz.dGX) {
        paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
      }
      if ((locals != null) && ((locals.status == 199) || (locals.status == 199)) && (g.aZJ()) && (!this.PhN.gRN())) {
        paramm.add(i, 114, 0, paramView.getContext().getString(2131757429));
      }
      if ((br.B(paramca)) || (br.E(paramca)))
      {
        paramm.clear();
        paramm.a(i, 130, paramView.getContext().getString(2131757439), 2131690707);
      }
      if (!this.PhN.gRN()) {
        paramm.a(i, 100, paramView.getContext().getString(2131757434), 2131690529);
      }
      if (br.D(paramca))
      {
        paramm = new jc();
        paramm.emN = paramca.field_msgSvrId;
        paramm.eLn = paramca.getType();
        paramm.eQu = br.C(paramca);
        paramm.ejA = 3L;
        paramm.bfK();
      }
    }
    AppMethodBeat.o(233945);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37441);
    cP(paramca).onClick(paramView);
    AppMethodBeat.o(37441);
    return true;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be.a
 * JD-Core Version:    0.7.0.1
 */