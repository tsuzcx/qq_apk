package com.tencent.mm.plugin.sns.ui.a.a;

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
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.ui.m;

public final class a$b
  extends com.tencent.mm.ui.contact.a.a.b
{
  public a$b(a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(145683);
    paramContext = LayoutInflater.from(paramContext).inflate(2130970859, paramViewGroup, false);
    paramViewGroup = (a.a)this.sdL.sdK;
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131828069));
    paramViewGroup.egr = ((TextView)paramContext.findViewById(2131828070));
    paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131828072));
    paramViewGroup.gpM.setVisibility(8);
    paramViewGroup.mYs = ((TextView)paramContext.findViewById(2131828071));
    paramViewGroup.gpN = ((CheckBox)paramContext.findViewById(2131828068));
    paramViewGroup.rSC = ((ImageView)paramContext.findViewById(2131828073));
    paramViewGroup.rSC.setImageResource(2131232009);
    paramViewGroup.rSC.setOnClickListener(new a.b.1(this));
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(145683);
    return paramContext;
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(145684);
    parama = (a.a)parama;
    parama1 = (a)parama1;
    if ((parama1.username != null) && (parama1.username.length() > 0))
    {
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.egq, parama1.username, 0.1F, false);
      m.a(parama1.gpH, parama.egr);
      if (!t.nK(parama1.username)) {
        break label198;
      }
      paramContext = paramContext.getResources().getDrawable(2131231831);
      paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
      parama.egr.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
      label103:
      m.a(parama1.gpI, parama.gpM);
      m.a(parama1.sdI, parama.mYs);
      if (!this.sdL.Adl) {
        break label232;
      }
      if (!paramBoolean1) {
        break label212;
      }
      parama.gpN.setChecked(true);
      parama.gpN.setEnabled(false);
      label158:
      parama.gpN.setVisibility(0);
    }
    for (;;)
    {
      parama.rSC.setTag(this.sdL.contact);
      AppMethodBeat.o(145684);
      return;
      parama.egq.setImageResource(2130838493);
      break;
      label198:
      parama.egr.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label103;
      label212:
      parama.gpN.setChecked(paramBoolean2);
      parama.gpN.setEnabled(true);
      break label158;
      label232:
      parama.gpN.setVisibility(8);
    }
  }
  
  public final boolean aoZ()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */