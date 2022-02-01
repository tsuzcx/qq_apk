package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.k;

public final class ay$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  private ay.c KCB;
  
  private ay.c fLN()
  {
    AppMethodBeat.i(37442);
    if (this.KCB == null) {
      this.KCB = new ay.c(this.JWz);
    }
    ay.c localc = this.KCB;
    AppMethodBeat.o(37442);
    return localc;
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
      localObject = new ah(paramLayoutInflater, 2131493503);
      ((View)localObject).setTag(new ay.d().E((View)localObject, false));
    }
    AppMethodBeat.o(37443);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37444);
    this.JWz = parama1;
    parama = (ay.d)parama;
    ay.d.a(parama, parambv, false, paramInt, parama1, fLN(), c(parama1));
    if (fLB())
    {
      paramString = u.Ia(parambv.field_imgPath);
      if ((paramString != null) && (paramString.status == 199) && (b((k)parama1.bh(k.class), parambv.field_msgId)))
      {
        if (parama.KvW != null)
        {
          parama.KvW.setVisibility(0);
          AppMethodBeat.o(37444);
        }
      }
      else if (parama.KvW != null) {
        parama.KvW.setVisibility(8);
      }
    }
    AppMethodBeat.o(37444);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37446);
    ((as)parama.bh(as.class)).a(paramMenuItem, parambv);
    AppMethodBeat.o(37446);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187898);
    bc.aCg();
    int i;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (paramView == null)
      {
        AppMethodBeat.o(187898);
        return false;
      }
      i = ((bk)paramView.getTag()).position;
      s locals = o.aNh().HD(parambv.field_imgPath);
      Object localObject = paraml.a(i, 130, paramView.getContext().getString(2131757227), 2131690498);
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      Intent localIntent = new Intent();
      localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", k).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
      ((MenuItem)localObject).setIntent(localIntent);
      if (locals == null) {
        break label495;
      }
      j = locals.status;
      if ((104 != j) && (103 != j) && (105 != j) && (106 != j)) {
        paraml.a(i, 107, paramView.getContext().getString(2131762559), 2131690478);
      }
      if ((locals == null) || ((locals.status != 199) && (locals.status != 199))) {
        break label525;
      }
      if (d.aJN("favorite")) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
      localObject = new ec();
      ((ec)localObject).dql.msgId = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l((b)localObject);
      if (((ec)localObject).dqm.dpK) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((!parambv.fta()) && ((parambv.cyG()) || (parambv.cyI())) && (b(parambv, this.JWz)) && ((locals.status == 199) || (locals.status == 199) || (parambv.fmr == 1)) && (aYa(parambv.field_talker))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if ((g.aFR()) && (!this.JWz.fJD())) {
        paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
    }
    for (;;)
    {
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757222), 2131690384);
      }
      AppMethodBeat.o(187898);
      return true;
      label495:
      if (!parambv.cyH()) {
        break;
      }
      paraml.a(i, 107, paramView.getContext().getString(2131762559), 2131690478);
      break;
      label525:
      if ((parambv.cyH()) && (d.aJN("favorite"))) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37447);
    fLN().onClick(paramView);
    AppMethodBeat.o(37447);
    return true;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay.b
 * JD-Core Version:    0.7.0.1
 */