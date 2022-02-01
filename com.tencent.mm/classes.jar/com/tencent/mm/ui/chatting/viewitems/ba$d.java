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
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.kw;
import com.tencent.mm.f.a.mp;
import com.tencent.mm.f.a.mp.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

final class ba$d
  extends c.a
{
  ImageView XdI;
  TextView XjK;
  LinearLayout Xkl;
  TextView Xkm;
  ProgressBar Xkn;
  ImageView Xko;
  ProgressBar Xkp;
  ImageView Xkq;
  
  public static void a(d paramd, ca paramca, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.e.a parama, ba.c paramc, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37358);
    if (paramd == null)
    {
      AppMethodBeat.o(37358);
      return;
    }
    paramd.Xkl.setVisibility(8);
    int i = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), 236);
    int j = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), 90);
    paramd.Xkm.setMaxLines(1);
    paramd.XjK.setMaxLines(1);
    paramd.XjK.setText("");
    Object localObject2;
    Object localObject1;
    if (c.blP("location"))
    {
      Log.d("MicroMsg.LocationItemHolder", "plugin found!");
      localObject2 = new mp();
      ((mp)localObject2).fKL.fKG = 1;
      ((mp)localObject2).fKL.fvt = paramca;
      EventCenter.instance.publish((IEvent)localObject2);
      localObject1 = ((mp)localObject2).fKM.fGw;
      localObject2 = ((mp)localObject2).fKM.fKO;
      if (((localObject1 == null) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("")) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("err_not_started"))))
      {
        Log.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
        paramd.Xkp.setVisibility(8);
        paramd.Xkl.setVisibility(0);
        paramd.Xkm.setText(R.l.location_conversation);
        paramd.XjK.setText("");
      }
    }
    for (;;)
    {
      paramd.Xko.setImageBitmap(q.bmh().b(R.g.location_msg, R.g.map_bg_mask_normal, i, j, paramBoolean));
      localObject1 = new kw();
      ((kw)localObject1).fIt.fvt = paramca;
      ((kw)localObject1).fIt.w = i;
      ((kw)localObject1).fIt.h = j;
      ((kw)localObject1).fIt.fIy = R.g.map_bg_mask_normal;
      ((kw)localObject1).fIt.fIv = paramd.Xko;
      ((kw)localObject1).fIt.fIx = paramd.Xkn;
      ((kw)localObject1).fIt.fIw = paramd.Xkq;
      EventCenter.instance.publish((IEvent)localObject1);
      paramd.clickArea.setTag(new by(paramca, parama.hRi(), paramInt, null, '\000'));
      paramd.clickArea.setOnClickListener(paramc);
      paramd.clickArea.setOnLongClickListener(paramOnLongClickListener);
      paramd.clickArea.setOnTouchListener(((k)parama.bC(k.class)).hNO());
      AppMethodBeat.o(37358);
      return;
      paramd.Xkp.setVisibility(8);
      paramd.Xkl.setVisibility(0);
      Log.d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(localObject1)));
      if (b((String)localObject2, parama))
      {
        paramd.Xkm.setVisibility(0);
        paramd.Xkm.setText((CharSequence)localObject2);
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          paramd.XjK.setVisibility(8);
        }
        else
        {
          paramd.XjK.setVisibility(0);
          paramd.XjK.setText((CharSequence)localObject1);
        }
      }
      else
      {
        paramd.Xkm.setMaxLines(2);
        paramd.Xkm.setText(String.valueOf(localObject1));
        paramd.XjK.setVisibility(8);
        continue;
        paramd.Xkn.setVisibility(0);
        paramd.Xkl.setVisibility(8);
      }
    }
  }
  
  private static boolean b(String paramString, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(37359);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(parama.WQv.getMMResources().getString(R.l.location_selected))))
    {
      AppMethodBeat.o(37359);
      return true;
    }
    AppMethodBeat.o(37359);
    return false;
  }
  
  public final c.a J(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37357);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.XjK = ((TextView)paramView.findViewById(R.h.dyy));
    this.Xkm = ((TextView)paramView.findViewById(R.h.dyA));
    this.Xkl = ((LinearLayout)paramView.findViewById(R.h.dyz));
    this.Xkn = ((ProgressBar)paramView.findViewById(R.h.chatting_load_progress));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    this.Xko = ((ImageView)paramView.findViewById(R.h.dyx));
    this.Xkp = ((ProgressBar)paramView.findViewById(R.h.dyw));
    this.Xkq = ((ImageView)paramView.findViewById(R.h.dxh));
    if (!paramBoolean)
    {
      this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
      this.XdI = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
    this.Xkm.setTextSize(1, 16.0F);
    this.XjK.setTextSize(1, 12.0F);
    if (ar.isDarkMode()) {}
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