package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

final class bd$i
  extends c.a
{
  TextView KBc;
  View KDx = null;
  
  public static void a(i parami, bv parambv, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.e.a parama, bd.h paramh, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37539);
    if (parami == null)
    {
      AppMethodBeat.o(37539);
      return;
    }
    int i;
    if (parami.KuL != null)
    {
      ImageView localImageView = parami.KuL;
      if (parambv.field_status == 6)
      {
        i = 8;
        localImageView.setVisibility(i);
      }
    }
    else
    {
      parami.olI.setTag(new bk(parambv, parama.fJC(), paramInt, null, '\000'));
      parami.olI.setOnClickListener(paramh);
      parami.olI.setOnLongClickListener(paramOnLongClickListener);
      parami.olI.setOnTouchListener(((k)parama.bh(k.class)).fGw());
      paramh = parambv.eNd;
      if (bu.isNullOrNil(paramh)) {
        break label153;
      }
      parami.KBc.setText(paramh);
    }
    for (;;)
    {
      if (parami.KDx != null) {
        break label181;
      }
      AppMethodBeat.o(37539);
      return;
      i = 0;
      break;
      label153:
      if (paramBoolean) {
        parami.KBc.setText(2131764797);
      } else {
        parami.KBc.setText(2131764798);
      }
    }
    label181:
    if ((parambv.field_content.equals(bv.JgK)) || (vY(parambv.field_content)))
    {
      if (paramBoolean)
      {
        parami.KDx.setBackground(ao.e(parama.Kkd.getContext().getDrawable(2131691395), parama.Kkd.getContext().getResources().getColor(2131099732)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.KDx.setBackgroundResource(2131691395);
      AppMethodBeat.o(37539);
      return;
    }
    if ((parambv.field_content.equals(bv.JgL)) || (vX(parambv.field_content)))
    {
      if (paramBoolean)
      {
        parami.KDx.setBackground(ao.e(parama.Kkd.getContext().getDrawable(2131691392), parama.Kkd.getContext().getResources().getColor(2131099732)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.KDx.setBackgroundResource(2131691393);
    }
    AppMethodBeat.o(37539);
  }
  
  private static boolean vX(String paramString)
  {
    AppMethodBeat.i(37541);
    yh localyh = new yh();
    localyh.dNE.dto = 1;
    localyh.dNE.content = paramString;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    if (localyh.dNF.type == 2)
    {
      AppMethodBeat.o(37541);
      return true;
    }
    AppMethodBeat.o(37541);
    return false;
  }
  
  private static boolean vY(String paramString)
  {
    AppMethodBeat.i(37540);
    yh localyh = new yh();
    localyh.dNE.dto = 1;
    localyh.dNE.content = paramString;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    if (localyh.dNF.type == 3)
    {
      AppMethodBeat.o(37540);
      return true;
    }
    AppMethodBeat.o(37540);
    return false;
  }
  
  public final c.a gN(View paramView)
  {
    AppMethodBeat.i(37538);
    super.gs(paramView);
    this.fVV = ((TextView)paramView.findViewById(2131298178));
    this.KBc = ((TextView)paramView.findViewById(2131298211));
    this.olI = paramView.findViewById(2131298069);
    this.KDx = paramView.findViewById(2131298210);
    this.KuL = ((ImageView)paramView.findViewById(2131298174));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    AppMethodBeat.o(37538);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.i
 * JD-Core Version:    0.7.0.1
 */