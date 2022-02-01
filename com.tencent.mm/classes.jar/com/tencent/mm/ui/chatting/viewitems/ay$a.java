package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.d.b.ar;

public final class ay$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  private ay.c Kgi;
  
  private ay.c fHv()
  {
    AppMethodBeat.i(37436);
    if (this.Kgi == null) {
      this.Kgi = new ay.c(this.JBI);
    }
    ay.c localc = this.Kgi;
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
      ((View)localObject).setTag(new ay.d().z((View)localObject, true));
    }
    AppMethodBeat.o(37437);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37438);
    this.JBI = parama1;
    ay.d.a((ay.d)parama, parambu, true, paramInt, parama1, fHv(), c(parama1));
    AppMethodBeat.o(37438);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37440);
    ((ar)parama.bh(ar.class)).a(paramMenuItem, parambu);
    AppMethodBeat.o(37440);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194502);
    ba.aBQ();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      int i = ((bk)paramView.getTag()).position;
      s locals = o.aMJ().Hb(parambu.field_imgPath);
      paraml.a(i, 130, paramView.getContext().getString(2131757227), 2131690498);
      paraml.a(i, 107, paramView.getContext().getString(2131762559), 2131690478);
      if (d.aIu("favorite")) {
        paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
      }
      eb localeb = new eb();
      localeb.dpg.msgId = parambu.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.l(localeb);
      if (localeb.dph.doF) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if ((locals != null) && ((locals.status == 199) || (locals.status == 199)) && (g.aFB()) && (!this.JBI.fFw())) {
        paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
      }
      if (bl.z(parambu))
      {
        paraml.clear();
        paraml.a(i, 130, paramView.getContext().getString(2131757227), 2131690498);
      }
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, paramView.getContext().getString(2131757222), 2131690384);
      }
    }
    AppMethodBeat.o(194502);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37441);
    fHv().onClick(paramView);
    AppMethodBeat.o(37441);
    return true;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && ((paramInt == 43) || (paramInt == 486539313));
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay.a
 * JD-Core Version:    0.7.0.1
 */