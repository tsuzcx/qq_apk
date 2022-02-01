package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

final class bo$i
  extends c.a
{
  TextView XjK;
  View Xmp = null;
  
  private static boolean Lf(String paramString)
  {
    AppMethodBeat.i(37541);
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 1;
    localaaq.fZM.content = paramString;
    EventCenter.instance.publish(localaaq);
    if (localaaq.fZN.type == 2)
    {
      AppMethodBeat.o(37541);
      return true;
    }
    AppMethodBeat.o(37541);
    return false;
  }
  
  private static boolean Lg(String paramString)
  {
    AppMethodBeat.i(37540);
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 1;
    localaaq.fZM.content = paramString;
    EventCenter.instance.publish(localaaq);
    if (localaaq.fZN.type == 3)
    {
      AppMethodBeat.o(37540);
      return true;
    }
    AppMethodBeat.o(37540);
    return false;
  }
  
  public static void a(i parami, ca paramca, boolean paramBoolean, int paramInt, a parama, bo.h paramh, View.OnLongClickListener paramOnLongClickListener)
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
      parami.clickArea.setTag(new by(paramca, parama.hRi(), paramInt, null, '\000'));
      parami.clickArea.setOnClickListener(paramh);
      parami.clickArea.setOnLongClickListener(paramOnLongClickListener);
      parami.clickArea.setOnTouchListener(((k)parama.bC(k.class)).hNO());
      paramh = paramca.hxy;
      if (Util.isNullOrNil(paramh)) {
        break label153;
      }
      parami.XjK.setText(paramh);
    }
    for (;;)
    {
      if (parami.Xmp != null) {
        break label183;
      }
      AppMethodBeat.o(37539);
      return;
      i = 0;
      break;
      label153:
      if (paramBoolean) {
        parami.XjK.setText(R.l.voip_call_cancel_msg_from);
      } else {
        parami.XjK.setText(R.l.voip_call_cancel_msg_to);
      }
    }
    label183:
    if ((paramca.field_content.equals(ca.VGx)) || (Lg(paramca.field_content)))
    {
      if (paramBoolean)
      {
        parami.Xmp.setBackground(au.e(parama.WQv.getContext().getDrawable(R.k.voip_voicecall), parama.WQv.getContext().getResources().getColor(R.e.FG_0)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.Xmp.setBackgroundResource(R.k.voip_voicecall);
      AppMethodBeat.o(37539);
      return;
    }
    if ((paramca.field_content.equals(ca.VGy)) || (Lf(paramca.field_content)))
    {
      if (paramBoolean)
      {
        parami.Xmp.setBackground(au.e(parama.WQv.getContext().getDrawable(R.k.voip_videocall), parama.WQv.getContext().getResources().getColor(R.e.FG_0)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.Xmp.setBackgroundResource(R.k.voip_videocall_to);
    }
    AppMethodBeat.o(37539);
  }
  
  public final c.a ip(View paramView)
  {
    AppMethodBeat.i(37538);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.XjK = ((TextView)paramView.findViewById(R.h.dzT));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.Xmp = paramView.findViewById(R.h.dzS);
    this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    AppMethodBeat.o(37538);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bo.i
 * JD-Core Version:    0.7.0.1
 */