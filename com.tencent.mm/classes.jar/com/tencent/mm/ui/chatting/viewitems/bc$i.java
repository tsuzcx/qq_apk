package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

final class bc$i
  extends c.a
{
  TextView Ioj;
  View IqA = null;
  
  public static void a(i parami, bo parambo, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.d.a parama, bc.h paramh, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37539);
    if (parami == null)
    {
      AppMethodBeat.o(37539);
      return;
    }
    int i;
    if (parami.IhW != null)
    {
      ImageView localImageView = parami.IhW;
      if (parambo.field_status == 6)
      {
        i = 8;
        localImageView.setVisibility(i);
      }
    }
    else
    {
      parami.nDl.setTag(new bj(parambo, parama.foQ(), paramInt, null, '\000'));
      parami.nDl.setOnClickListener(paramh);
      parami.nDl.setOnLongClickListener(paramOnLongClickListener);
      parami.nDl.setOnTouchListener(((i)parama.bf(i.class)).fmb());
      paramh = parambo.eul;
      if (bs.isNullOrNil(paramh)) {
        break label153;
      }
      parami.Ioj.setText(paramh);
    }
    for (;;)
    {
      if (parami.IqA != null) {
        break label181;
      }
      AppMethodBeat.o(37539);
      return;
      i = 0;
      break;
      label153:
      if (paramBoolean) {
        parami.Ioj.setText(2131764797);
      } else {
        parami.Ioj.setText(2131764798);
      }
    }
    label181:
    if ((parambo.field_content.equals(bo.GYO)) || (sN(parambo.field_content)))
    {
      if (paramBoolean)
      {
        parami.IqA.setBackground(am.e(parama.HZF.getContext().getDrawable(2131691395), ao.aJ(parama.HZF.getContext(), 2130968584)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.IqA.setBackgroundResource(2131691395);
      AppMethodBeat.o(37539);
      return;
    }
    if ((parambo.field_content.equals(bo.GYP)) || (sM(parambo.field_content)))
    {
      if (paramBoolean)
      {
        parami.IqA.setBackground(am.e(parama.HZF.getContext().getDrawable(2131691392), ao.aJ(parama.HZF.getContext(), 2130968584)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.IqA.setBackgroundResource(2131691393);
    }
    AppMethodBeat.o(37539);
  }
  
  private static boolean sM(String paramString)
  {
    AppMethodBeat.i(37541);
    xh localxh = new xh();
    localxh.dAb.dgL = 1;
    localxh.dAb.content = paramString;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    if (localxh.dAc.type == 2)
    {
      AppMethodBeat.o(37541);
      return true;
    }
    AppMethodBeat.o(37541);
    return false;
  }
  
  private static boolean sN(String paramString)
  {
    AppMethodBeat.i(37540);
    xh localxh = new xh();
    localxh.dAb.dgL = 1;
    localxh.dAb.content = paramString;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    if (localxh.dAc.type == 3)
    {
      AppMethodBeat.o(37540);
      return true;
    }
    AppMethodBeat.o(37540);
    return false;
  }
  
  public final c.a gr(View paramView)
  {
    AppMethodBeat.i(37538);
    super.fX(paramView);
    this.fAz = ((TextView)paramView.findViewById(2131298178));
    this.Ioj = ((TextView)paramView.findViewById(2131298211));
    this.nDl = paramView.findViewById(2131298069);
    this.IqA = paramView.findViewById(2131298210);
    this.IhW = ((ImageView)paramView.findViewById(2131298174));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    AppMethodBeat.o(37538);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc.i
 * JD-Core Version:    0.7.0.1
 */