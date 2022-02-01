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
import com.tencent.mm.av.g;
import com.tencent.mm.av.o;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.ky.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;

final class ap$d
  extends c.a
{
  ImageView Ijf;
  LinearLayout IoJ;
  TextView IoK;
  ProgressBar IoL;
  ImageView IoM;
  ProgressBar IoN;
  ImageView IoO;
  TextView Ioj;
  
  public static void a(d paramd, bo parambo, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.d.a parama, ap.c paramc, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37358);
    if (paramd == null)
    {
      AppMethodBeat.o(37358);
      return;
    }
    paramd.IoJ.setVisibility(8);
    int i = com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), 236);
    int j = com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), 90);
    paramd.IoK.setMaxLines(1);
    paramd.Ioj.setMaxLines(1);
    paramd.Ioj.setText("");
    Object localObject2;
    Object localObject1;
    if (d.aCT("location"))
    {
      ac.d("MicroMsg.LocationItemHolder", "plugin found!");
      localObject2 = new ky();
      ((ky)localObject2).dmP.dmJ = 1;
      ((ky)localObject2).dmP.cZc = parambo;
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject2);
      localObject1 = ((ky)localObject2).dmQ.diM;
      localObject2 = ((ky)localObject2).dmQ.dmS;
      if (((localObject1 == null) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("")) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("err_not_started"))))
      {
        ac.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
        paramd.IoN.setVisibility(8);
        paramd.IoJ.setVisibility(0);
        paramd.IoK.setText(2131760712);
        paramd.Ioj.setText("");
      }
    }
    for (;;)
    {
      paramd.IoM.setImageBitmap(o.aFx().l(i, j, paramBoolean));
      localObject1 = new ji();
      ((ji)localObject1).dkJ.cZc = parambo;
      ((ji)localObject1).dkJ.w = i;
      ((ji)localObject1).dkJ.h = j;
      ((ji)localObject1).dkJ.dkO = 2131233224;
      ((ji)localObject1).dkJ.dkL = paramd.IoM;
      ((ji)localObject1).dkJ.dkN = paramd.IoL;
      ((ji)localObject1).dkJ.dkM = paramd.IoO;
      com.tencent.mm.sdk.b.a.GpY.l((b)localObject1);
      paramd.nDl.setTag(new bj(parambo, parama.foQ(), paramInt, null, '\000'));
      paramd.nDl.setOnClickListener(paramc);
      paramd.nDl.setOnLongClickListener(paramOnLongClickListener);
      paramd.nDl.setOnTouchListener(((i)parama.bf(i.class)).fmb());
      AppMethodBeat.o(37358);
      return;
      paramd.IoN.setVisibility(8);
      paramd.IoJ.setVisibility(0);
      ac.d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(localObject1)));
      if (b((String)localObject2, parama))
      {
        paramd.IoK.setVisibility(0);
        paramd.IoK.setText((CharSequence)localObject2);
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          paramd.Ioj.setVisibility(8);
        }
        else
        {
          paramd.Ioj.setVisibility(0);
          paramd.Ioj.setText((CharSequence)localObject1);
        }
      }
      else
      {
        paramd.IoK.setMaxLines(2);
        paramd.IoK.setText(String.valueOf(localObject1));
        paramd.Ioj.setVisibility(8);
        continue;
        paramd.IoL.setVisibility(0);
        paramd.IoJ.setVisibility(8);
      }
    }
  }
  
  private static boolean b(String paramString, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(37359);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(parama.HZF.getMMResources().getString(2131760729))))
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
    super.fX(paramView);
    this.fAz = ((TextView)paramView.findViewById(2131298178));
    this.Ioj = ((TextView)paramView.findViewById(2131298143));
    this.IoK = ((TextView)paramView.findViewById(2131298145));
    this.IoJ = ((LinearLayout)paramView.findViewById(2131298144));
    this.IoL = ((ProgressBar)paramView.findViewById(2131298140));
    this.nDl = paramView.findViewById(2131298069);
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    this.IoM = ((ImageView)paramView.findViewById(2131298142));
    this.IoN = ((ProgressBar)paramView.findViewById(2131298141));
    this.IoO = ((ImageView)paramView.findViewById(2131298077));
    if (!paramBoolean)
    {
      this.IhW = ((ImageView)paramView.findViewById(2131298174));
      this.Ijf = ((ImageView)paramView.findViewById(2131298176));
    }
    this.IoK.setTextSize(1, 16.0F);
    this.Ioj.setTextSize(1, 12.0F);
    if (aj.DT()) {}
    for (int i = 0;; i = 8)
    {
      paramView.findViewById(2131302152).setVisibility(i);
      AppMethodBeat.o(37357);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.d
 * JD-Core Version:    0.7.0.1
 */