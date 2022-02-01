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
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.li.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

final class aq$d
  extends c.a
{
  LinearLayout KBC;
  TextView KBD;
  ProgressBar KBE;
  ImageView KBF;
  ProgressBar KBG;
  ImageView KBH;
  TextView KBc;
  ImageView KvW;
  
  public static void a(d paramd, bv parambv, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.e.a parama, aq.c paramc, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37358);
    if (paramd == null)
    {
      AppMethodBeat.o(37358);
      return;
    }
    paramd.KBC.setVisibility(8);
    int i = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), 236);
    int j = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), 90);
    paramd.KBD.setMaxLines(1);
    paramd.KBc.setMaxLines(1);
    paramd.KBc.setText("");
    Object localObject2;
    Object localObject1;
    if (d.aJN("location"))
    {
      ae.d("MicroMsg.LocationItemHolder", "plugin found!");
      localObject2 = new li();
      ((li)localObject2).dzI.dzC = 1;
      ((li)localObject2).dzI.dlw = parambv;
      com.tencent.mm.sdk.b.a.IvT.l((b)localObject2);
      localObject1 = ((li)localObject2).dzJ.dvD;
      localObject2 = ((li)localObject2).dzJ.dzL;
      if (((localObject1 == null) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("")) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("err_not_started"))))
      {
        ae.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
        paramd.KBG.setVisibility(8);
        paramd.KBC.setVisibility(0);
        paramd.KBD.setText(2131760712);
        paramd.KBc.setText("");
      }
    }
    for (;;)
    {
      paramd.KBF.setImageBitmap(q.aIX().l(i, j, paramBoolean));
      localObject1 = new jr();
      ((jr)localObject1).dxB.dlw = parambv;
      ((jr)localObject1).dxB.w = i;
      ((jr)localObject1).dxB.h = j;
      ((jr)localObject1).dxB.dxG = 2131233224;
      ((jr)localObject1).dxB.dxD = paramd.KBF;
      ((jr)localObject1).dxB.dxF = paramd.KBE;
      ((jr)localObject1).dxB.dxE = paramd.KBH;
      com.tencent.mm.sdk.b.a.IvT.l((b)localObject1);
      paramd.olI.setTag(new bk(parambv, parama.fJC(), paramInt, null, '\000'));
      paramd.olI.setOnClickListener(paramc);
      paramd.olI.setOnLongClickListener(paramOnLongClickListener);
      paramd.olI.setOnTouchListener(((k)parama.bh(k.class)).fGw());
      AppMethodBeat.o(37358);
      return;
      paramd.KBG.setVisibility(8);
      paramd.KBC.setVisibility(0);
      ae.d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(localObject1)));
      if (b((String)localObject2, parama))
      {
        paramd.KBD.setVisibility(0);
        paramd.KBD.setText((CharSequence)localObject2);
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          paramd.KBc.setVisibility(8);
        }
        else
        {
          paramd.KBc.setVisibility(0);
          paramd.KBc.setText((CharSequence)localObject1);
        }
      }
      else
      {
        paramd.KBD.setMaxLines(2);
        paramd.KBD.setText(String.valueOf(localObject1));
        paramd.KBc.setVisibility(8);
        continue;
        paramd.KBE.setVisibility(0);
        paramd.KBC.setVisibility(8);
      }
    }
  }
  
  private static boolean b(String paramString, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(37359);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(parama.Kkd.getMMResources().getString(2131760729))))
    {
      AppMethodBeat.o(37359);
      return true;
    }
    AppMethodBeat.o(37359);
    return false;
  }
  
  public final c.a E(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37357);
    super.gs(paramView);
    this.fVV = ((TextView)paramView.findViewById(2131298178));
    this.KBc = ((TextView)paramView.findViewById(2131298143));
    this.KBD = ((TextView)paramView.findViewById(2131298145));
    this.KBC = ((LinearLayout)paramView.findViewById(2131298144));
    this.KBE = ((ProgressBar)paramView.findViewById(2131298140));
    this.olI = paramView.findViewById(2131298069);
    this.yUp = ((TextView)paramView.findViewById(2131298185));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    this.KBF = ((ImageView)paramView.findViewById(2131298142));
    this.KBG = ((ProgressBar)paramView.findViewById(2131298141));
    this.KBH = ((ImageView)paramView.findViewById(2131298077));
    if (!paramBoolean)
    {
      this.KuL = ((ImageView)paramView.findViewById(2131298174));
      this.KvW = ((ImageView)paramView.findViewById(2131298176));
    }
    this.KBD.setTextSize(1, 16.0F);
    this.KBc.setTextSize(1, 12.0F);
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