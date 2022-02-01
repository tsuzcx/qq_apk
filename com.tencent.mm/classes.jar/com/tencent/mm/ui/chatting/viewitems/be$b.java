package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class be$b
  extends c
{
  private be.c PPr;
  private a PhN;
  
  private be.c cP(ca paramca)
  {
    AppMethodBeat.i(233946);
    if (this.PPr == null) {
      this.PPr = new be.c(this.PhN);
    }
    be.c.a(this.PPr, 0);
    if (br.D(paramca)) {
      be.c.a(this.PPr, 2);
    }
    paramca = this.PPr;
    AppMethodBeat.o(233946);
    return paramca;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37443);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493612);
      ((View)localObject).setTag(new be.d().G((View)localObject, false));
    }
    AppMethodBeat.o(37443);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37444);
    this.PhN = parama1;
    parama = (be.d)parama;
    be.d.a(parama, paramca, false, paramInt, parama1, cP(paramca), c(parama1));
    if (gTW())
    {
      paramString = u.QN(paramca.field_imgPath);
      if ((paramString != null) && (paramString.status == 199) && (b((k)parama1.bh(k.class), paramca.field_msgId)))
      {
        if (parama.PIn != null)
        {
          parama.PIn.setVisibility(0);
          AppMethodBeat.o(37444);
        }
      }
      else if (parama.PIn != null) {
        parama.PIn.setVisibility(8);
      }
    }
    AppMethodBeat.o(37444);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37446);
    ((av)parama.bh(av.class)).a(paramMenuItem, paramca);
    AppMethodBeat.o(37446);
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233947);
    bg.aVF();
    int i;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (paramView == null)
      {
        AppMethodBeat.o(233947);
        return false;
      }
      i = ((bq)paramView.getTag()).position;
      s locals = o.bhj().Qq(paramca.field_imgPath);
      Object localObject = paramm.a(i, 130, paramView.getContext().getString(2131757439), 2131690707);
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
      ((MenuItem)localObject).setIntent(localIntent);
      if (locals == null) {
        break label550;
      }
      j = locals.status;
      if ((104 != j) && (103 != j) && (105 != j) && (106 != j)) {
        paramm.a(i, 107, paramView.getContext().getString(2131764628), 2131690674);
      }
      if ((locals == null) || ((locals.status != 199) && (locals.status != 199))) {
        break label580;
      }
      if (com.tencent.mm.br.c.aZU("favorite")) {
        paramm.a(i, 116, paramView.getContext().getString(2131763947), 2131690551);
      }
      localObject = new ef();
      ((ef)localObject).dHy.msgId = paramca.field_msgId;
      EventCenter.instance.publish((IEvent)localObject);
      if (((ef)localObject).dHz.dGX) {
        paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
      }
      if ((!paramca.gAt()) && ((paramca.cWJ()) || (paramca.cWL())) && (b(paramca, this.PhN)) && ((locals.status == 199) || (locals.status == 199) || (paramca.fQV == 1)) && (bnf(paramca.field_talker))) {
        paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
      if ((g.aZJ()) && (!this.PhN.gRN())) {
        paramm.add(i, 114, 0, paramView.getContext().getString(2131757429));
      }
    }
    for (;;)
    {
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
      AppMethodBeat.o(233947);
      return true;
      label550:
      if (!paramca.cWK()) {
        break;
      }
      paramm.a(i, 107, paramView.getContext().getString(2131764628), 2131690674);
      break;
      label580:
      if ((paramca.cWK()) && (com.tencent.mm.br.c.aZU("favorite"))) {
        paramm.a(i, 116, paramView.getContext().getString(2131763947), 2131690551);
      }
    }
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37447);
    cP(paramca).onClick(paramView);
    AppMethodBeat.o(37447);
    return true;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be.b
 * JD-Core Version:    0.7.0.1
 */