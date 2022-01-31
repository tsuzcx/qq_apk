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
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public class f$b
  extends a.b
{
  public f$b(f paramf)
  {
    super(paramf);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105285);
    if (com.tencent.mm.cb.a.gt(paramContext)) {}
    for (paramContext = LayoutInflater.from(paramContext).inflate(2130970665, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2130970664, paramViewGroup, false))
    {
      paramViewGroup = (f.a)this.Agm.Agl;
      paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
      paramViewGroup.egr = ((TextView)paramContext.findViewById(2131821212));
      paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
      paramViewGroup.gpM.setVisibility(8);
      paramViewGroup.gpN = ((CheckBox)paramContext.findViewById(2131821631));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(105285);
      return paramContext;
    }
  }
  
  public void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(105286);
    parama1 = (f)parama1;
    parama = (f.a)parama;
    parama.egr.setCompoundDrawables(null, null, null, null);
    if ((this.Agm.Agj != 0) && (this.Agm.Agi != null))
    {
      parama.egq.setImageResource(this.Agm.Agj);
      parama.egr.setText(this.Agm.Agi);
      AppMethodBeat.o(105286);
      return;
    }
    m.a(parama1.gpH, parama.egr);
    if (ad.arf(parama1.username))
    {
      g.RM();
      ad localad = ((j)g.E(j.class)).YA().arw(parama1.username);
      ((b)g.E(b.class)).a(paramContext, parama.egr, parama1.gpH, localad.field_openImAppid, localad.field_descWordingId, (int)parama.egr.getTextSize());
    }
    com.tencent.mm.pluginsdk.ui.a.b.c(parama.egq, parama1.username);
    if (t.nK(parama1.username))
    {
      paramContext = paramContext.getResources().getDrawable(2131231831);
      paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight());
      parama.egr.setCompoundDrawablesWithIntrinsicBounds(null, null, paramContext, null);
      if (!this.Agm.Adl) {
        break label305;
      }
      if (!paramBoolean1) {
        break label285;
      }
      parama.gpN.setChecked(true);
      parama.gpN.setEnabled(false);
    }
    for (;;)
    {
      parama.gpN.setVisibility(0);
      AppMethodBeat.o(105286);
      return;
      parama.egr.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break;
      label285:
      parama.gpN.setChecked(paramBoolean2);
      parama.gpN.setEnabled(true);
    }
    label305:
    parama.gpN.setVisibility(8);
    AppMethodBeat.o(105286);
  }
  
  public final boolean aoZ()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f.b
 * JD-Core Version:    0.7.0.1
 */