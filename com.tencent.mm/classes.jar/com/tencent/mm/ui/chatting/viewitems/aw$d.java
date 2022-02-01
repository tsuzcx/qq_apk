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
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.ly.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;

final class aw$d
  extends c.a
{
  ImageView PIn;
  TextView PNK;
  LinearLayout POk;
  TextView POl;
  ProgressBar POm;
  ImageView POn;
  ProgressBar POo;
  ImageView POp;
  
  public static void a(d paramd, ca paramca, boolean paramBoolean, int paramInt, com.tencent.mm.ui.chatting.e.a parama, aw.c paramc, View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(37358);
    if (paramd == null)
    {
      AppMethodBeat.o(37358);
      return;
    }
    paramd.POk.setVisibility(8);
    int i = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), 236);
    int j = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), 90);
    paramd.POl.setMaxLines(1);
    paramd.PNK.setMaxLines(1);
    paramd.PNK.setText("");
    Object localObject2;
    Object localObject1;
    if (c.aZU("location"))
    {
      Log.d("MicroMsg.LocationItemHolder", "plugin found!");
      localObject2 = new ly();
      ((ly)localObject2).dRv.dRq = 1;
      ((ly)localObject2).dRv.dCM = paramca;
      EventCenter.instance.publish((IEvent)localObject2);
      localObject1 = ((ly)localObject2).dRw.dNk;
      localObject2 = ((ly)localObject2).dRw.dRy;
      if (((localObject1 == null) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("")) && (!b((String)localObject2, parama))) || ((localObject1 != null) && (((String)localObject1).equals("err_not_started"))))
      {
        Log.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
        paramd.POo.setVisibility(8);
        paramd.POk.setVisibility(0);
        paramd.POl.setText(2131762450);
        paramd.PNK.setText("");
      }
    }
    for (;;)
    {
      paramd.POn.setImageBitmap(q.bcR().m(i, j, paramBoolean));
      localObject1 = new kg();
      ((kg)localObject1).dPi.dCM = paramca;
      ((kg)localObject1).dPi.w = i;
      ((kg)localObject1).dPi.h = j;
      ((kg)localObject1).dPi.dPn = 2131233886;
      ((kg)localObject1).dPi.dPk = paramd.POn;
      ((kg)localObject1).dPi.dPm = paramd.POm;
      ((kg)localObject1).dPi.dPl = paramd.POp;
      EventCenter.instance.publish((IEvent)localObject1);
      paramd.clickArea.setTag(new bq(paramca, parama.gRM(), paramInt, null, '\000'));
      paramd.clickArea.setOnClickListener(paramc);
      paramd.clickArea.setOnLongClickListener(paramOnLongClickListener);
      paramd.clickArea.setOnTouchListener(((k)parama.bh(k.class)).gOC());
      AppMethodBeat.o(37358);
      return;
      paramd.POo.setVisibility(8);
      paramd.POk.setVisibility(0);
      Log.d("MicroMsg.LocationItemHolder", "location info : ".concat(String.valueOf(localObject1)));
      if (b((String)localObject2, parama))
      {
        paramd.POl.setVisibility(0);
        paramd.POl.setText((CharSequence)localObject2);
        if ((localObject1 == null) || (((String)localObject1).equals("")))
        {
          paramd.PNK.setVisibility(8);
        }
        else
        {
          paramd.PNK.setVisibility(0);
          paramd.PNK.setText((CharSequence)localObject1);
        }
      }
      else
      {
        paramd.POl.setMaxLines(2);
        paramd.POl.setText(String.valueOf(localObject1));
        paramd.PNK.setVisibility(8);
        continue;
        paramd.POm.setVisibility(0);
        paramd.POk.setVisibility(8);
      }
    }
  }
  
  private static boolean b(String paramString, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(37359);
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.equals(parama.Pwc.getMMResources().getString(2131762470))))
    {
      AppMethodBeat.o(37359);
      return true;
    }
    AppMethodBeat.o(37359);
    return false;
  }
  
  public final c.a G(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37357);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.PNK = ((TextView)paramView.findViewById(2131298504));
    this.POl = ((TextView)paramView.findViewById(2131298506));
    this.POk = ((LinearLayout)paramView.findViewById(2131298505));
    this.POm = ((ProgressBar)paramView.findViewById(2131298501));
    this.clickArea = paramView.findViewById(2131298411);
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    this.POn = ((ImageView)paramView.findViewById(2131298503));
    this.POo = ((ProgressBar)paramView.findViewById(2131298502));
    this.POp = ((ImageView)paramView.findViewById(2131298420));
    if (!paramBoolean)
    {
      this.stateIV = ((ImageView)paramView.findViewById(2131298554));
      this.PIn = ((ImageView)paramView.findViewById(2131298556));
    }
    this.POl.setTextSize(1, 16.0F);
    this.PNK.setTextSize(1, 12.0F);
    if (ao.isDarkMode()) {}
    for (int i = 0;; i = 8)
    {
      paramView.findViewById(2131304491).setVisibility(i);
      AppMethodBeat.o(37357);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.d
 * JD-Core Version:    0.7.0.1
 */