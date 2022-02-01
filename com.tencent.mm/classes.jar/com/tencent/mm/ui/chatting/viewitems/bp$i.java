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
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.d.a;

final class bp$i
  extends c.a
{
  TextView aeUc;
  View aeXs = null;
  
  private static boolean DM(String paramString)
  {
    AppMethodBeat.i(37541);
    acn localacn = new acn();
    localacn.ifU.hId = 1;
    localacn.ifU.content = paramString;
    localacn.publish();
    if (localacn.ifV.type == 2)
    {
      AppMethodBeat.o(37541);
      return true;
    }
    AppMethodBeat.o(37541);
    return false;
  }
  
  private static boolean DN(String paramString)
  {
    AppMethodBeat.i(37540);
    acn localacn = new acn();
    localacn.ifU.hId = 1;
    localacn.ifU.content = paramString;
    localacn.publish();
    if (localacn.ifV.type == 3)
    {
      AppMethodBeat.o(37540);
      return true;
    }
    AppMethodBeat.o(37540);
    return false;
  }
  
  public static void a(i parami, cc paramcc, boolean paramBoolean, int paramInt, a parama, bp.h paramh, View.OnLongClickListener paramOnLongClickListener)
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
      if (paramcc.field_status == 6)
      {
        i = 8;
        localImageView.setVisibility(i);
      }
    }
    else
    {
      parami.clickArea.setTag(new bz(paramcc, parama.juG(), paramInt, null, '\000'));
      parami.clickArea.setOnClickListener(paramh);
      parami.clickArea.setOnLongClickListener(paramOnLongClickListener);
      parami.clickArea.setOnTouchListener(((m)parama.cm(m.class)).jqv());
      paramh = paramcc.jUr;
      if (Util.isNullOrNil(paramh)) {
        break label153;
      }
      parami.aeUc.setText(paramh);
    }
    for (;;)
    {
      if (parami.aeXs != null) {
        break label183;
      }
      AppMethodBeat.o(37539);
      return;
      i = 0;
      break;
      label153:
      if (paramBoolean) {
        parami.aeUc.setText(R.l.voip_call_cancel_msg_from);
      } else {
        parami.aeUc.setText(R.l.voip_call_cancel_msg_to);
      }
    }
    label183:
    if ((paramcc.field_content.equals(cc.adko)) || (DN(paramcc.field_content)))
    {
      if (paramBoolean)
      {
        parami.aeXs.setBackground(bb.e(parama.aezO.getContext().getDrawable(R.k.voip_voicecall), parama.aezO.getContext().getResources().getColor(R.e.FG_0)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.aeXs.setBackgroundResource(R.k.voip_voicecall);
      AppMethodBeat.o(37539);
      return;
    }
    if ((paramcc.field_content.equals(cc.adkp)) || (DM(paramcc.field_content)))
    {
      if (paramBoolean)
      {
        parami.aeXs.setBackground(bb.e(parama.aezO.getContext().getDrawable(R.k.voip_videocall), parama.aezO.getContext().getResources().getColor(R.e.FG_0)));
        AppMethodBeat.o(37539);
        return;
      }
      parami.aeXs.setBackgroundResource(R.k.voip_videocall_to);
    }
    AppMethodBeat.o(37539);
  }
  
  public final c.a lM(View paramView)
  {
    AppMethodBeat.i(37538);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.aeUc = ((TextView)paramView.findViewById(R.h.fAN));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.aeXs = paramView.findViewById(R.h.fAM);
    this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(37538);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bp.i
 * JD-Core Version:    0.7.0.1
 */