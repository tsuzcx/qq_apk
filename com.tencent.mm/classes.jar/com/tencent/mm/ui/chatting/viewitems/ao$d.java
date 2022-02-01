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
import com.tencent.mm.aw.g;
import com.tencent.mm.aw.o;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.kp.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

final class ao$d
  extends c.a
{
  ImageView GJi;
  LinearLayout GOH;
  TextView GOI;
  ProgressBar GOJ;
  ImageView GOK;
  ProgressBar GOL;
  ImageView GOM;
  TextView GOh;
  
  public static void a(d paramd, bl parambl, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.d.a parama, ao.c paramc, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37358);
    if (paramd == null)
    {
      AppMethodBeat.o(37358);
      return;
    }
    paramd.GOH.setVisibility(8);
    int i = com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), 236);
    int j = com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), 90);
    paramd.GOI.setMaxLines(1);
    paramd.GOh.setMaxLines(1);
    paramd.GOh.setText("");
    Object localObject2;
    Object localObject1;
    if (d.axB("location"))
    {
      ad.d("MicroMsg.LocationItemHolder", "plugin found!");
      localObject2 = new kp();
      ((kp)localObject2).dpf.doZ = 1;
      ((kp)localObject2).dpf.dbD = parambl;
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject2);
      localObject1 = ((kp)localObject2).dpg.dld;
      localObject2 = ((kp)localObject2).dpg.dpi;
      if (((localObject1 == null) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("")) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("err_not_started"))))
      {
        ad.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
        paramd.GOL.setVisibility(8);
        paramd.GOH.setVisibility(0);
        paramd.GOI.setText(2131760712);
        paramd.GOh.setText("");
      }
    }
    for (;;)
    {
      paramd.GOK.setImageBitmap(o.ayF().l(i, j, paramBoolean));
      localObject1 = new jb();
      ((jb)localObject1).dnb.dbD = parambl;
      ((jb)localObject1).dnb.w = i;
      ((jb)localObject1).dnb.h = j;
      ((jb)localObject1).dnb.dng = 2131233224;
      ((jb)localObject1).dnb.dnd = paramd.GOK;
      ((jb)localObject1).dnb.dnf = paramd.GOJ;
      ((jb)localObject1).dnb.dne = paramd.GOM;
      com.tencent.mm.sdk.b.a.ESL.l((b)localObject1);
      paramd.naN.setTag(new bi(parambl, parama.eZb(), paramInt, null, '\000'));
      paramd.naN.setOnClickListener(paramc);
      paramd.naN.setOnLongClickListener(paramOnLongClickListener);
      paramd.naN.setOnTouchListener(((i)parama.be(i.class)).eWp());
      AppMethodBeat.o(37358);
      return;
      paramd.GOL.setVisibility(8);
      paramd.GOH.setVisibility(0);
      ad.d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(localObject1)));
      if (b((String)localObject2, parama))
      {
        paramd.GOI.setVisibility(0);
        paramd.GOI.setText((CharSequence)localObject2);
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          paramd.GOh.setVisibility(8);
        }
        else
        {
          paramd.GOh.setVisibility(0);
          paramd.GOh.setText((CharSequence)localObject1);
        }
      }
      else
      {
        paramd.GOI.setMaxLines(2);
        paramd.GOI.setText(String.valueOf(localObject1));
        paramd.GOh.setVisibility(8);
        continue;
        paramd.GOJ.setVisibility(0);
        paramd.GOH.setVisibility(8);
      }
    }
  }
  
  private static boolean b(String paramString, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(37359);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(parama.GzJ.getMMResources().getString(2131760729))))
    {
      AppMethodBeat.o(37359);
      return true;
    }
    AppMethodBeat.o(37359);
    return false;
  }
  
  public final c.a z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37357);
    super.fK(paramView);
    this.fwS = ((TextView)paramView.findViewById(2131298178));
    this.GOh = ((TextView)paramView.findViewById(2131298143));
    this.GOI = ((TextView)paramView.findViewById(2131298145));
    this.GOH = ((LinearLayout)paramView.findViewById(2131298144));
    this.GOJ = ((ProgressBar)paramView.findViewById(2131298140));
    this.naN = paramView.findViewById(2131298069);
    this.wet = ((TextView)paramView.findViewById(2131298185));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    this.GOK = ((ImageView)paramView.findViewById(2131298142));
    this.GOL = ((ProgressBar)paramView.findViewById(2131298141));
    this.GOM = ((ImageView)paramView.findViewById(2131298077));
    if (!paramBoolean)
    {
      this.GHZ = ((ImageView)paramView.findViewById(2131298174));
      this.GJi = ((ImageView)paramView.findViewById(2131298176));
    }
    this.GOI.setTextSize(1, 16.0F);
    this.GOh.setTextSize(1, 12.0F);
    if (ai.Eq()) {}
    for (int i = 0;; i = 8)
    {
      paramView.findViewById(2131302152).setVisibility(i);
      AppMethodBeat.o(37357);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.d
 * JD-Core Version:    0.7.0.1
 */