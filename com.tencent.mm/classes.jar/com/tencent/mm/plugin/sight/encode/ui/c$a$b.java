package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.e.b;

public final class c$a$b
  extends e.b
{
  public c$a$b(c.a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25060);
    paramContext = LayoutInflater.from(paramContext).inflate(2130970754, paramViewGroup, false);
    paramViewGroup = (c.a.a)this.qWl.cnj();
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
    paramViewGroup.contentView = paramContext.findViewById(2131826406);
    paramViewGroup.gpN = ((CheckBox)paramContext.findViewById(2131821631));
    paramViewGroup.qVf = paramContext.findViewById(2131827798);
    paramViewGroup.qWk = paramContext.findViewById(2131823242);
    paramContext.setTag(paramViewGroup);
    paramViewGroup.gpL.setTextColor(-1);
    paramViewGroup = (AbsListView.LayoutParams)paramContext.getLayoutParams();
    paramViewGroup.width = -1;
    paramContext.setLayoutParams(paramViewGroup);
    paramContext.setBackgroundResource(2131689763);
    AppMethodBeat.o(25060);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(25061);
    ad localad = parama1.contact;
    c.a.a locala = (c.a.a)parama;
    locala.contentView.setVisibility(0);
    locala.qWk.setVisibility(8);
    locala.qVf.setVisibility(8);
    if (c.Zs(localad.field_username))
    {
      locala.egq.setImageResource(2131231986);
      locala.gpL.setText(2131303720);
      locala.gpM.setText(2131303718);
      locala.gpM.setVisibility(0);
      locala.gpN.setEnabled(false);
      if (c.qWi)
      {
        locala.contentView.setBackgroundResource(2130840330);
        locala.gpN.setVisibility(0);
        locala.gpN.setBackgroundResource(2131231994);
        locala.qVf.setVisibility(0);
      }
      for (;;)
      {
        c.e(paramContext, locala.contentView);
        parama = locala.egq.getLayoutParams();
        parama.width = com.tencent.mm.cb.a.ao(paramContext, 2131428669);
        parama.height = com.tencent.mm.cb.a.ao(paramContext, 2131428669);
        locala.egq.setLayoutParams(parama);
        parama = (LinearLayout.LayoutParams)locala.gpN.getLayoutParams();
        parama.height = com.tencent.mm.cb.a.ao(paramContext, 2131428675);
        parama.width = com.tencent.mm.cb.a.ao(paramContext, 2131428675);
        parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
        locala.gpN.setLayoutParams(parama);
        AppMethodBeat.o(25061);
        return;
        locala.contentView.setBackgroundResource(2130840334);
        locala.gpN.setVisibility(8);
        locala.gpN.setBackgroundResource(2131231996);
        locala.qVf.setVisibility(8);
      }
    }
    if (c.Zq(localad.field_username))
    {
      locala.egq.setImageResource(2131231993);
      locala.gpN.setVisibility(8);
      locala.gpL.setText(paramContext.getString(2131303730));
      locala.gpM.setVisibility(8);
      if (c.qWh)
      {
        locala.contentView.setBackgroundResource(2130840334);
        locala.qVf.setVisibility(8);
        c.e(paramContext, locala.contentView);
      }
    }
    for (;;)
    {
      parama = locala.egq.getLayoutParams();
      parama.width = com.tencent.mm.cb.a.ao(paramContext, 2131428669);
      parama.height = com.tencent.mm.cb.a.ao(paramContext, 2131428669);
      locala.egq.setLayoutParams(parama);
      parama = (LinearLayout.LayoutParams)locala.gpN.getLayoutParams();
      parama.height = com.tencent.mm.cb.a.ao(paramContext, 2131428675);
      parama.width = com.tencent.mm.cb.a.ao(paramContext, 2131428675);
      parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
      locala.gpN.setLayoutParams(parama);
      locala.gpN.setBackgroundResource(2130840329);
      AppMethodBeat.o(25061);
      return;
      locala.contentView.setBackgroundResource(2130840330);
      locala.qVf.setVisibility(0);
      break;
      if (c.Zr(localad.field_username))
      {
        locala.contentView.setVisibility(8);
        locala.qWk.setVisibility(0);
        AppMethodBeat.o(25061);
        return;
      }
      super.a(paramContext, parama, parama1, paramBoolean1, paramBoolean2);
      locala.contentView.setBackgroundResource(2130840334);
      c.e(paramContext, locala.contentView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.c.a.b
 * JD-Core Version:    0.7.0.1
 */