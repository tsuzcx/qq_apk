package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

final class bd$i
  extends c.a
{
  TextView KeJ;
  View Khc = null;
  
  public static void a(i parami, bu parambu, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.e.a parama, bd.h paramh, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37539);
    if (parami == null)
    {
      AppMethodBeat.o(37539);
      return;
    }
    int i;
    if (parami.JYs != null)
    {
      ImageView localImageView = parami.JYs;
      if (parambu.field_status == 6)
      {
        i = 8;
        localImageView.setVisibility(i);
      }
    }
    else
    {
      parami.ofK.setTag(new bk(parambu, parama.fFv(), paramInt, null, '\000'));
      parami.ofK.setOnClickListener(paramh);
      parami.ofK.setOnLongClickListener(paramOnLongClickListener);
      parami.ofK.setOnTouchListener(((k)parama.bh(k.class)).fCu());
      paramh = parambu.eLs;
      if (bt.isNullOrNil(paramh)) {
        break label153;
      }
      parami.KeJ.setText(paramh);
    }
    for (;;)
    {
      if (parami.Khc != null) {
        break label181;
      }
      AppMethodBeat.o(37539);
      return;
      i = 0;
      break;
      label153:
      if (paramBoolean) {
        parami.KeJ.setText(2131764797);
      } else {
        parami.KeJ.setText(2131764798);
      }
    }
    label181:
    if ((parambu.field_content.equals(bu.IMd)) || (vC(parambu.field_content)))
    {
      if (paramBoolean)
      {
        parami.Khc.setBackground(ao.e(parama.JOR.getContext().getDrawable(2131691395), parama.JOR.getContext().getResources().getColor(2131099732)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.Khc.setBackgroundResource(2131691395);
      AppMethodBeat.o(37539);
      return;
    }
    if ((parambu.field_content.equals(bu.IMe)) || (vB(parambu.field_content)))
    {
      if (paramBoolean)
      {
        parami.Khc.setBackground(ao.e(parama.JOR.getContext().getDrawable(2131691392), parama.JOR.getContext().getResources().getColor(2131099732)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.Khc.setBackgroundResource(2131691393);
    }
    AppMethodBeat.o(37539);
  }
  
  private static boolean vB(String paramString)
  {
    AppMethodBeat.i(37541);
    yb localyb = new yb();
    localyb.dMo.dsi = 1;
    localyb.dMo.content = paramString;
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    if (localyb.dMp.type == 2)
    {
      AppMethodBeat.o(37541);
      return true;
    }
    AppMethodBeat.o(37541);
    return false;
  }
  
  private static boolean vC(String paramString)
  {
    AppMethodBeat.i(37540);
    yb localyb = new yb();
    localyb.dMo.dsi = 1;
    localyb.dMo.content = paramString;
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    if (localyb.dMp.type == 3)
    {
      AppMethodBeat.o(37540);
      return true;
    }
    AppMethodBeat.o(37540);
    return false;
  }
  
  public final c.a gI(View paramView)
  {
    AppMethodBeat.i(37538);
    super.gn(paramView);
    this.fTP = ((TextView)paramView.findViewById(2131298178));
    this.KeJ = ((TextView)paramView.findViewById(2131298211));
    this.ofK = paramView.findViewById(2131298069);
    this.Khc = paramView.findViewById(2131298210);
    this.JYs = ((ImageView)paramView.findViewById(2131298174));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    AppMethodBeat.o(37538);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.i
 * JD-Core Version:    0.7.0.1
 */