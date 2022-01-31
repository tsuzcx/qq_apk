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
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.if;
import com.tencent.mm.g.a.jm;
import com.tencent.mm.g.a.jm.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;

final class af$d
  extends c.a
{
  ImageView zSm;
  TextView zVQ;
  LinearLayout zWq;
  TextView zWr;
  ProgressBar zWs;
  ImageView zWt;
  ProgressBar zWu;
  ImageView zWv;
  
  public static void a(d paramd, bi parambi, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.d.a parama, af.c paramc, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(33262);
    if (paramd == null)
    {
      AppMethodBeat.o(33262);
      return;
    }
    paramd.zWq.setVisibility(8);
    int i = com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), 236);
    int j = com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), 90);
    paramd.zWr.setMaxLines(1);
    paramd.zVQ.setMaxLines(1);
    paramd.zVQ.setText("");
    Object localObject2;
    Object localObject1;
    if (d.ahR("location"))
    {
      ab.d("MicroMsg.LocationItemHolder", "plugin found!");
      localObject2 = new jm();
      ((jm)localObject2).cyZ.cyU = 1;
      ((jm)localObject2).cyZ.cmQ = parambi;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
      localObject1 = ((jm)localObject2).cza.cvF;
      localObject2 = ((jm)localObject2).cza.czc;
      if (((localObject1 == null) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("")) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("err_not_started"))))
      {
        ab.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
        paramd.zWu.setVisibility(8);
        paramd.zWq.setVisibility(0);
        paramd.zWr.setText(2131301088);
        paramd.zVQ.setText("");
      }
    }
    for (;;)
    {
      paramd.zWt.setImageBitmap(o.ahC().g(i, j, paramBoolean));
      localObject1 = new if();
      ((if)localObject1).cxw.cmQ = parambi;
      ((if)localObject1).cxw.w = i;
      ((if)localObject1).cxw.h = j;
      ((if)localObject1).cxw.cxB = 2130839603;
      ((if)localObject1).cxw.cxy = paramd.zWt;
      ((if)localObject1).cxw.cxA = paramd.zWs;
      ((if)localObject1).cxw.cxz = paramd.zWv;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
      paramd.jYu.setTag(new az(parambi, parama.dJG(), paramInt, null, '\000'));
      paramd.jYu.setOnClickListener(paramc);
      paramd.jYu.setOnLongClickListener(paramOnLongClickListener);
      paramd.jYu.setOnTouchListener(((h)parama.ay(h.class)).dHi());
      AppMethodBeat.o(33262);
      return;
      paramd.zWu.setVisibility(8);
      paramd.zWq.setVisibility(0);
      ab.d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(localObject1)));
      if (b((String)localObject2, parama))
      {
        paramd.zWr.setVisibility(0);
        paramd.zWr.setText((CharSequence)localObject2);
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          paramd.zVQ.setVisibility(8);
        }
        else
        {
          paramd.zVQ.setVisibility(0);
          paramd.zVQ.setText((CharSequence)localObject1);
        }
      }
      else
      {
        paramd.zWr.setMaxLines(2);
        paramd.zWr.setText(String.valueOf(localObject1));
        paramd.zVQ.setVisibility(8);
        continue;
        paramd.zWs.setVisibility(0);
        paramd.zWq.setVisibility(8);
      }
    }
  }
  
  private static boolean b(String paramString, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(33263);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(parama.zJz.getMMResources().getString(2131301105))))
    {
      AppMethodBeat.o(33263);
      return true;
    }
    AppMethodBeat.o(33263);
    return false;
  }
  
  public final c.a A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(33261);
    super.eV(paramView);
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.zVQ = ((TextView)paramView.findViewById(2131822676));
    this.zWr = ((TextView)paramView.findViewById(2131822675));
    this.zWq = ((LinearLayout)paramView.findViewById(2131822674));
    this.zWs = ((ProgressBar)paramView.findViewById(2131822228));
    this.jYu = paramView.findViewById(2131822580);
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.zWt = ((ImageView)paramView.findViewById(2131822678));
    this.zWu = ((ProgressBar)paramView.findViewById(2131822677));
    this.zWv = ((ImageView)paramView.findViewById(2131822679));
    if (!paramBoolean)
    {
      this.zRC = ((ImageView)paramView.findViewById(2131822695));
      this.zSm = ((ImageView)paramView.findViewById(2131822729));
    }
    this.zWr.setTextSize(1, 16.0F);
    this.zVQ.setTextSize(1, 12.0F);
    AppMethodBeat.o(33261);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.d
 * JD-Core Version:    0.7.0.1
 */