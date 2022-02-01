package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

final class bj$i
  extends c.a
{
  TextView PNK;
  View PQn = null;
  
  private static boolean Em(String paramString)
  {
    AppMethodBeat.i(37541);
    zj localzj = new zj();
    localzj.efx.dKy = 1;
    localzj.efx.content = paramString;
    EventCenter.instance.publish(localzj);
    if (localzj.efy.type == 2)
    {
      AppMethodBeat.o(37541);
      return true;
    }
    AppMethodBeat.o(37541);
    return false;
  }
  
  private static boolean En(String paramString)
  {
    AppMethodBeat.i(37540);
    zj localzj = new zj();
    localzj.efx.dKy = 1;
    localzj.efx.content = paramString;
    EventCenter.instance.publish(localzj);
    if (localzj.efy.type == 3)
    {
      AppMethodBeat.o(37540);
      return true;
    }
    AppMethodBeat.o(37540);
    return false;
  }
  
  public static void a(i parami, ca paramca, boolean paramBoolean, int paramInt, a parama, bj.h paramh, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37539);
    if (parami == null)
    {
      AppMethodBeat.o(37539);
      return;
    }
    int i;
    if (parami.stateIV != null)
    {
      ImageView localImageView = parami.stateIV;
      if (paramca.field_status == 6)
      {
        i = 8;
        localImageView.setVisibility(i);
      }
    }
    else
    {
      parami.clickArea.setTag(new bq(paramca, parama.gRM(), paramInt, null, '\000'));
      parami.clickArea.setOnClickListener(paramh);
      parami.clickArea.setOnLongClickListener(paramOnLongClickListener);
      parami.clickArea.setOnTouchListener(((k)parama.bh(k.class)).gOC());
      paramh = paramca.fqK;
      if (Util.isNullOrNil(paramh)) {
        break label153;
      }
      parami.PNK.setText(paramh);
    }
    for (;;)
    {
      if (parami.PQn != null) {
        break label181;
      }
      AppMethodBeat.o(37539);
      return;
      i = 0;
      break;
      label153:
      if (paramBoolean) {
        parami.PNK.setText(2131767235);
      } else {
        parami.PNK.setText(2131767236);
      }
    }
    label181:
    if ((paramca.field_content.equals(ca.OqB)) || (En(paramca.field_content)))
    {
      if (paramBoolean)
      {
        parami.PQn.setBackground(ar.e(parama.Pwc.getContext().getDrawable(2131691729), parama.Pwc.getContext().getResources().getColor(2131099746)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.PQn.setBackgroundResource(2131691729);
      AppMethodBeat.o(37539);
      return;
    }
    if ((paramca.field_content.equals(ca.OqC)) || (Em(paramca.field_content)))
    {
      if (paramBoolean)
      {
        parami.PQn.setBackground(ar.e(parama.Pwc.getContext().getDrawable(2131691726), parama.Pwc.getContext().getResources().getColor(2131099746)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.PQn.setBackgroundResource(2131691727);
    }
    AppMethodBeat.o(37539);
  }
  
  public final c.a hd(View paramView)
  {
    AppMethodBeat.i(37538);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.PNK = ((TextView)paramView.findViewById(2131298593));
    this.clickArea = paramView.findViewById(2131298411);
    this.PQn = paramView.findViewById(2131298592);
    this.stateIV = ((ImageView)paramView.findViewById(2131298554));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    AppMethodBeat.o(37538);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.i
 * JD-Core Version:    0.7.0.1
 */