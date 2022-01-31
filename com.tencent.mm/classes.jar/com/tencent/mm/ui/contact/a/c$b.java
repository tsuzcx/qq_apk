package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;

public final class c$b
  extends a.b
{
  public c$b(c paramc)
  {
    super(paramc);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105270);
    if (com.tencent.mm.cb.a.gt(paramContext)) {}
    for (paramViewGroup = LayoutInflater.from(paramContext).inflate(2130970665, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(2130970664, paramViewGroup, false))
    {
      c.a locala = (c.a)this.AfX.AfW;
      locala.egq = ((ImageView)paramViewGroup.findViewById(2131821210));
      locala.gpL = ((TextView)paramViewGroup.findViewById(2131821212));
      locala.gpL.setMaxWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 200));
      locala.gpM = ((TextView)paramViewGroup.findViewById(2131821007));
      locala.mYs = ((TextView)paramViewGroup.findViewById(2131821071));
      locala.contentView = paramViewGroup.findViewById(2131826406);
      locala.gpN = ((CheckBox)paramViewGroup.findViewById(2131821631));
      if (this.AfX.jTN) {
        locala.contentView.setBackgroundResource(2130838447);
      }
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(105270);
      return paramViewGroup;
    }
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(105271);
    parama = (c.a)parama;
    parama1 = (c)parama1;
    if ((parama1.username != null) && (parama1.username.length() > 0))
    {
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.egq, parama1.username, 0.1F, false);
      m.a(parama1.gpH, parama.gpL);
      if (!t.nK(parama1.username)) {
        break label184;
      }
      paramContext = paramContext.getResources().getDrawable(2131231831);
      paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
      parama.gpL.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
      label103:
      m.a(parama1.gpI, parama.gpM);
      m.a(parama1.sdI, parama.mYs);
      if (!this.AfX.Adl) {
        break label218;
      }
      if (!paramBoolean1) {
        break label198;
      }
      parama.gpN.setChecked(true);
      parama.gpN.setEnabled(false);
    }
    for (;;)
    {
      parama.gpN.setVisibility(0);
      AppMethodBeat.o(105271);
      return;
      parama.egq.setImageResource(2130838493);
      break;
      label184:
      parama.gpL.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label103;
      label198:
      parama.gpN.setChecked(paramBoolean2);
      parama.gpN.setEnabled(true);
    }
    label218:
    parama.gpN.setVisibility(8);
    AppMethodBeat.o(105271);
  }
  
  public final boolean aoZ()
  {
    AppMethodBeat.i(105272);
    if (this.AfX.hrL != null) {
      ((n)g.G(n.class)).updateTopHitsRank(this.AfX.query, this.AfX.hrL, 1);
    }
    AppMethodBeat.o(105272);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.c.b
 * JD-Core Version:    0.7.0.1
 */