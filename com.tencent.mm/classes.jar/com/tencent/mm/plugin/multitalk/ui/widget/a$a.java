package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.e.a;
import com.tencent.mm.ui.contact.a.e.b;

public final class a$a
  extends e.b
{
  public a$a(a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(54182);
    paramContext = LayoutInflater.from(paramContext).inflate(2130970320, paramViewGroup, false);
    paramViewGroup = (e.a)a.a(this.oVl);
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
    paramViewGroup.contentView = paramContext.findViewById(2131826406);
    paramViewGroup.gpN = ((CheckBox)paramContext.findViewById(2131821631));
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(54182);
    return paramContext;
  }
  
  public final void a(Context paramContext, com.tencent.mm.ui.contact.a.a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(54183);
    paramContext = (e.a)parama;
    parama = (e)parama1;
    if ((parama.username != null) && (parama.username.length() > 0))
    {
      a.b.c(paramContext.egq, parama.username);
      m.a(parama.gpH, paramContext.gpL);
      if (!this.oVl.Adl) {
        break label132;
      }
      if (!paramBoolean1) {
        break label112;
      }
      paramContext.gpN.setChecked(true);
      paramContext.gpN.setEnabled(false);
    }
    for (;;)
    {
      paramContext.gpN.setVisibility(0);
      AppMethodBeat.o(54183);
      return;
      paramContext.egq.setImageResource(2130838493);
      break;
      label112:
      paramContext.gpN.setChecked(paramBoolean2);
      paramContext.gpN.setEnabled(true);
    }
    label132:
    paramContext.gpN.setVisibility(8);
    AppMethodBeat.o(54183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.a.a
 * JD-Core Version:    0.7.0.1
 */