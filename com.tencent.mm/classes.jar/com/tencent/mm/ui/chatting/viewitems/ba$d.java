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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ma;
import com.tencent.mm.autogen.a.nw;
import com.tencent.mm.autogen.a.nw.b;
import com.tencent.mm.br.c;
import com.tencent.mm.ce.b;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;

final class ba$d
  extends c.a
{
  ImageView aeNG;
  LinearLayout aeUW;
  TextView aeUX;
  ProgressBar aeUY;
  ImageView aeUZ;
  TextView aeUc;
  ProgressBar aeVa;
  ImageView aeVb;
  
  public static void a(d paramd, cc paramcc, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.d.a parama, ba.c paramc, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37358);
    if (paramd == null)
    {
      AppMethodBeat.o(37358);
      return;
    }
    paramd.aeUW.setVisibility(8);
    int i = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), 236);
    int j = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), 90);
    paramd.aeUX.setMaxLines(1);
    paramd.aeUc.setMaxLines(1);
    paramd.aeUc.setText("");
    Object localObject2;
    Object localObject1;
    if (c.blq("location"))
    {
      Log.d("MicroMsg.LocationItemHolder", "plugin found!");
      localObject2 = new nw();
      ((nw)localObject2).hQs.hQm = 1;
      ((nw)localObject2).hQs.hzO = paramcc;
      ((nw)localObject2).publish();
      localObject1 = ((nw)localObject2).hQt.hLS;
      localObject2 = ((nw)localObject2).hQt.hQv;
      if (((localObject1 == null) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("")) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("err_not_started"))))
      {
        Log.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
        paramd.aeVa.setVisibility(8);
        paramd.aeUW.setVisibility(0);
        paramd.aeUX.setText(R.l.location_conversation);
        paramd.aeUc.setText("");
      }
    }
    for (;;)
    {
      paramd.aeUZ.setImageBitmap(r.bKa().b(R.g.location_msg, R.g.map_bg_mask_normal, i, j, paramBoolean));
      localObject1 = new ma();
      ((ma)localObject1).hNT.hzO = paramcc;
      ((ma)localObject1).hNT.w = i;
      ((ma)localObject1).hNT.h = j;
      ((ma)localObject1).hNT.hNY = R.g.map_bg_mask_normal;
      ((ma)localObject1).hNT.hNV = paramd.aeUZ;
      ((ma)localObject1).hNT.hNX = paramd.aeUY;
      ((ma)localObject1).hNT.hNW = paramd.aeVb;
      ((ma)localObject1).publish();
      paramd.clickArea.setTag(new bz(paramcc, parama.juG(), paramInt, null, '\000'));
      paramd.clickArea.setOnClickListener(paramc);
      paramd.clickArea.setOnLongClickListener(paramOnLongClickListener);
      paramd.clickArea.setOnTouchListener(((m)parama.cm(m.class)).jqv());
      AppMethodBeat.o(37358);
      return;
      paramd.aeVa.setVisibility(8);
      paramd.aeUW.setVisibility(0);
      Log.d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(localObject1)));
      if (b((String)localObject2, parama))
      {
        paramd.aeUX.setVisibility(0);
        paramd.aeUX.setText((CharSequence)localObject2);
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          paramd.aeUc.setVisibility(8);
        }
        else
        {
          paramd.aeUc.setVisibility(0);
          paramd.aeUc.setText((CharSequence)localObject1);
        }
      }
      else
      {
        paramd.aeUX.setMaxLines(2);
        paramd.aeUX.setText(String.valueOf(localObject1));
        paramd.aeUc.setVisibility(8);
        continue;
        paramd.aeUY.setVisibility(0);
        paramd.aeUW.setVisibility(8);
      }
    }
  }
  
  private static boolean b(String paramString, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(37359);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(parama.aezO.getMMResources().getString(R.l.location_selected))))
    {
      AppMethodBeat.o(37359);
      return true;
    }
    AppMethodBeat.o(37359);
    return false;
  }
  
  public final c.a P(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37357);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.aeUc = ((TextView)paramView.findViewById(R.h.fzi));
    this.aeUX = ((TextView)paramView.findViewById(R.h.fzk));
    this.aeUW = ((LinearLayout)paramView.findViewById(R.h.fzj));
    this.aeUY = ((ProgressBar)paramView.findViewById(R.h.chatting_load_progress));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.aeUZ = ((ImageView)paramView.findViewById(R.h.fzh));
    this.aeVa = ((ProgressBar)paramView.findViewById(R.h.fzg));
    this.aeVb = ((ImageView)paramView.findViewById(R.h.fxC));
    if (b.iRp()) {
      this.aeVb.setImageResource(R.g.location_current_marker_easy_mode);
    }
    if (!paramBoolean)
    {
      this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
      this.aeNG = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
    this.aeUX.setTextSize(1, 16.0F);
    this.aeUc.setTextSize(1, 12.0F);
    if (aw.isDarkMode()) {}
    for (int i = 0;; i = 8)
    {
      paramView.findViewById(R.h.map_dark_view).setVisibility(i);
      AppMethodBeat.o(37357);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba.d
 * JD-Core Version:    0.7.0.1
 */