package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.k;

public final class ay$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  private ay.c Kgi;
  
  private ay.c fHv()
  {
    AppMethodBeat.i(37442);
    if (this.Kgi == null) {
      this.Kgi = new ay.c(this.JBI);
    }
    ay.c localc = this.Kgi;
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
      ((View)localObject).setTag(new ay.d().z((View)localObject, false));
    }
    AppMethodBeat.o(37443);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37444);
    this.JBI = parama1;
    parama = (ay.d)parama;
    ay.d.a(parama, parambu, false, paramInt, parama1, fHv(), c(parama1));
    if (fHj())
    {
      paramString = u.Hy(parambu.field_imgPath);
      if ((paramString != null) && (paramString.status == 199) && (b((k)parama1.bh(k.class), parambu.field_msgId)))
      {
        if (parama.JZD != null)
        {
          parama.JZD.setVisibility(0);
          AppMethodBeat.o(37444);
        }
      }
      else if (parama.JZD != null) {
        parama.JZD.setVisibility(8);
      }
    }
    AppMethodBeat.o(37444);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37446);
    ((ar)parama.bh(ar.class)).a(paramMenuItem, parambu);
    AppMethodBeat.o(37446);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194503);
    ba.aBQ();
    int i;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      if (paramView == null)
      {
        AppMethodBeat.o(194503);
        return false;
      }
      i = ((bk)paramView.getTag()).position;
      s locals = o.aMJ().Hb(parambu.field_imgPath);
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
      if (d.aIu("favorite")) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
      localObject = new eb();
      ((eb)localObject).dpg.msgId = parambu.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.l((b)localObject);
      if (((eb)localObject).dph.doF) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((!parambu.fpd()) && ((parambu.cxf()) || (parambu.cxh())) && (b(parambu, this.JBI)) && ((locals.status == 199) || (locals.status == 199) || (parambu.fku == 1)) && (aWy(parambu.field_talker))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      if ((g.aFB()) && (!this.JBI.fFw())) {
        paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
    }
    for (;;)
    {
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757222), 2131690384);
      }
      AppMethodBeat.o(194503);
      return true;
      label495:
      if (!parambu.cxg()) {
        break;
      }
      paraml.a(i, 107, paramView.getContext().getString(2131762559), 2131690478);
      break;
      label525:
      if ((parambu.cxg()) && (d.aIu("favorite"))) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37447);
    fHv().onClick(paramView);
    AppMethodBeat.o(37447);
    return true;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay.b
 * JD-Core Version:    0.7.0.1
 */