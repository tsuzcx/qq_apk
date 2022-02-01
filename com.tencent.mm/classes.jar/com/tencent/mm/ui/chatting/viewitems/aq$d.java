package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.lh.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

final class aq$d
  extends c.a
{
  ImageView JZD;
  TextView KeJ;
  LinearLayout Kfj;
  TextView Kfk;
  ProgressBar Kfl;
  ImageView Kfm;
  ProgressBar Kfn;
  ImageView Kfo;
  
  public static void a(d paramd, bu parambu, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.e.a parama, aq.c paramc, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37358);
    if (paramd == null)
    {
      AppMethodBeat.o(37358);
      return;
    }
    paramd.Kfj.setVisibility(8);
    int i = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), 236);
    int j = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), 90);
    paramd.Kfk.setMaxLines(1);
    paramd.KeJ.setMaxLines(1);
    paramd.KeJ.setText("");
    Object localObject2;
    Object localObject1;
    if (d.aIu("location"))
    {
      ad.d("MicroMsg.LocationItemHolder", "plugin found!");
      localObject2 = new lh();
      ((lh)localObject2).dyD.dyx = 1;
      ((lh)localObject2).dyD.dku = parambu;
      com.tencent.mm.sdk.b.a.IbL.l((b)localObject2);
      localObject1 = ((lh)localObject2).dyE.duy;
      localObject2 = ((lh)localObject2).dyE.dyG;
      if (((localObject1 == null) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("")) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("err_not_started"))))
      {
        ad.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
        paramd.Kfn.setVisibility(8);
        paramd.Kfj.setVisibility(0);
        paramd.Kfk.setText(2131760712);
        paramd.KeJ.setText("");
      }
    }
    for (;;)
    {
      paramd.Kfm.setImageBitmap(q.aIF().l(i, j, paramBoolean));
      localObject1 = new jq();
      ((jq)localObject1).dww.dku = parambu;
      ((jq)localObject1).dww.w = i;
      ((jq)localObject1).dww.h = j;
      ((jq)localObject1).dww.dwB = 2131233224;
      ((jq)localObject1).dww.dwy = paramd.Kfm;
      ((jq)localObject1).dww.dwA = paramd.Kfl;
      ((jq)localObject1).dww.dwz = paramd.Kfo;
      com.tencent.mm.sdk.b.a.IbL.l((b)localObject1);
      paramd.ofK.setTag(new bk(parambu, parama.fFv(), paramInt, null, '\000'));
      paramd.ofK.setOnClickListener(paramc);
      paramd.ofK.setOnLongClickListener(paramOnLongClickListener);
      paramd.ofK.setOnTouchListener(((k)parama.bh(k.class)).fCu());
      AppMethodBeat.o(37358);
      return;
      paramd.Kfn.setVisibility(8);
      paramd.Kfj.setVisibility(0);
      ad.d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(localObject1)));
      if (b((String)localObject2, parama))
      {
        paramd.Kfk.setVisibility(0);
        paramd.Kfk.setText((CharSequence)localObject2);
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          paramd.KeJ.setVisibility(8);
        }
        else
        {
          paramd.KeJ.setVisibility(0);
          paramd.KeJ.setText((CharSequence)localObject1);
        }
      }
      else
      {
        paramd.Kfk.setMaxLines(2);
        paramd.Kfk.setText(String.valueOf(localObject1));
        paramd.KeJ.setVisibility(8);
        continue;
        paramd.Kfl.setVisibility(0);
        paramd.Kfj.setVisibility(8);
      }
    }
  }
  
  private static boolean b(String paramString, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(37359);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(parama.JOR.getMMResources().getString(2131760729))))
    {
      AppMethodBeat.o(37359);
      return true;
    }
    AppMethodBeat.o(37359);
    return false;
  }
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37357);
    super.gn(paramView);
    this.fTP = ((TextView)paramView.findViewById(2131298178));
    this.KeJ = ((TextView)paramView.findViewById(2131298143));
    this.Kfk = ((TextView)paramView.findViewById(2131298145));
    this.Kfj = ((LinearLayout)paramView.findViewById(2131298144));
    this.Kfl = ((ProgressBar)paramView.findViewById(2131298140));
    this.ofK = paramView.findViewById(2131298069);
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    this.Kfm = ((ImageView)paramView.findViewById(2131298142));
    this.Kfn = ((ProgressBar)paramView.findViewById(2131298141));
    this.Kfo = ((ImageView)paramView.findViewById(2131298077));
    if (!paramBoolean)
    {
      this.JYs = ((ImageView)paramView.findViewById(2131298174));
      this.JZD = ((ImageView)paramView.findViewById(2131298176));
    }
    this.Kfk.setTextSize(1, 16.0F);
    this.KeJ.setTextSize(1, 12.0F);
    if (al.isDarkMode()) {}
    for (int i = 0;; i = 8)
    {
      paramView.findViewById(2131302152).setVisibility(i);
      AppMethodBeat.o(37357);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.d
 * JD-Core Version:    0.7.0.1
 */