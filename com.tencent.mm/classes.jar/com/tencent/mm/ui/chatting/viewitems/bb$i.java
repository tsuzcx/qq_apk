package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

final class bb$i
  extends c.a
{
  TextView GOh;
  View GQz = null;
  
  public static void a(i parami, bl parambl, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.d.a parama, bb.h paramh, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37539);
    if (parami == null)
    {
      AppMethodBeat.o(37539);
      return;
    }
    int i;
    if (parami.GHZ != null)
    {
      ImageView localImageView = parami.GHZ;
      if (parambl.field_status == 6)
      {
        i = 8;
        localImageView.setVisibility(i);
      }
    }
    else
    {
      parami.naN.setTag(new bi(parambl, parama.eZb(), paramInt, null, '\000'));
      parami.naN.setOnClickListener(paramh);
      parami.naN.setOnLongClickListener(paramOnLongClickListener);
      parami.naN.setOnTouchListener(((i)parama.be(i.class)).eWp());
      paramh = parambl.esh;
      if (bt.isNullOrNil(paramh)) {
        break label153;
      }
      parami.GOh.setText(paramh);
    }
    for (;;)
    {
      if (parami.GQz != null) {
        break label181;
      }
      AppMethodBeat.o(37539);
      return;
      i = 0;
      break;
      label153:
      if (paramBoolean) {
        parami.GOh.setText(2131764797);
      } else {
        parami.GOh.setText(2131764798);
      }
    }
    label181:
    if ((parambl.field_content.equals(bl.FzM)) || (pC(parambl.field_content)))
    {
      if (paramBoolean)
      {
        parami.GQz.setBackground(am.e(parama.GzJ.getContext().getDrawable(2131691395), ao.aD(parama.GzJ.getContext(), 2130968584)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.GQz.setBackgroundResource(2131691395);
      AppMethodBeat.o(37539);
      return;
    }
    if ((parambl.field_content.equals(bl.FzN)) || (pB(parambl.field_content)))
    {
      if (paramBoolean)
      {
        parami.GQz.setBackground(am.e(parama.GzJ.getContext().getDrawable(2131691392), ao.aD(parama.GzJ.getContext(), 2130968584)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.GQz.setBackgroundResource(2131691393);
    }
    AppMethodBeat.o(37539);
  }
  
  private static boolean pB(String paramString)
  {
    AppMethodBeat.i(37541);
    ww localww = new ww();
    localww.dCp.djq = 1;
    localww.dCp.content = paramString;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    if (localww.dCq.type == 2)
    {
      AppMethodBeat.o(37541);
      return true;
    }
    AppMethodBeat.o(37541);
    return false;
  }
  
  private static boolean pC(String paramString)
  {
    AppMethodBeat.i(37540);
    ww localww = new ww();
    localww.dCp.djq = 1;
    localww.dCp.content = paramString;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    if (localww.dCq.type == 3)
    {
      AppMethodBeat.o(37540);
      return true;
    }
    AppMethodBeat.o(37540);
    return false;
  }
  
  public final c.a ge(View paramView)
  {
    AppMethodBeat.i(37538);
    super.fK(paramView);
    this.fwS = ((TextView)paramView.findViewById(2131298178));
    this.GOh = ((TextView)paramView.findViewById(2131298211));
    this.naN = paramView.findViewById(2131298069);
    this.GQz = paramView.findViewById(2131298210);
    this.GHZ = ((ImageView)paramView.findViewById(2131298174));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    AppMethodBeat.o(37538);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bb.i
 * JD-Core Version:    0.7.0.1
 */