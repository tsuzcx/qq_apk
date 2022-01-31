package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.storage.ad;

public class e$b
  extends a.b
{
  public e$b(e parame)
  {
    super(parame);
  }
  
  public View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105279);
    if (com.tencent.mm.cb.a.gt(paramContext)) {}
    for (paramContext = LayoutInflater.from(paramContext).inflate(2130970665, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2130970664, paramViewGroup, false))
    {
      paramViewGroup = (e.a)this.Agh.cnj();
      paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
      paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
      paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
      paramViewGroup.contentView = paramContext.findViewById(2131826406);
      paramViewGroup.gpN = ((CheckBox)paramContext.findViewById(2131821631));
      paramViewGroup.Agg = ((CheckBox)paramContext.findViewById(2131827557));
      paramViewGroup.Aak = ((TextView)paramContext.findViewById(2131821107));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(105279);
      return paramContext;
    }
  }
  
  public void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(105280);
    parama = (e.a)parama;
    parama1 = (e)parama1;
    if ((parama1.username != null) && (parama1.username.length() > 0))
    {
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.egq, parama1.username, 0.1F, false);
      m.a(parama1.gpH, parama.gpL);
      m.a(parama1.gpI, parama.gpM);
      if (!this.Agh.Adl) {
        break label253;
      }
      parama.gpN.setBackgroundResource(2130839637);
      if (!paramBoolean1) {
        break label233;
      }
      parama.gpN.setChecked(true);
      parama.gpN.setEnabled(false);
      label110:
      parama.gpN.setVisibility(0);
      label118:
      if (!this.Agh.jTN) {
        break label383;
      }
      parama.contentView.setBackgroundResource(2130838447);
    }
    for (;;)
    {
      if (parama1.contact.field_deleteFlag == 1)
      {
        parama.gpM.setVisibility(0);
        parama.gpM.setText(paramContext.getString(2131303034));
      }
      if ((this.Agh.Agd) || (parama.Aak == null)) {
        break label404;
      }
      if (!ad.arf(parama1.username)) {
        break label395;
      }
      parama.Aak.setText(parama1.Agc);
      parama.Aak.setVisibility(0);
      AppMethodBeat.o(105280);
      return;
      parama.egq.setImageResource(2130838493);
      break;
      label233:
      parama.gpN.setChecked(paramBoolean2);
      parama.gpN.setEnabled(true);
      break label110;
      label253:
      if (this.Agh.AfR)
      {
        parama.gpN.setBackgroundResource(2130840179);
        if (paramBoolean1)
        {
          parama.gpN.setChecked(true);
          parama.gpN.setEnabled(false);
        }
        for (;;)
        {
          parama.gpN.setVisibility(0);
          break;
          parama.gpN.setChecked(paramBoolean2);
          parama.gpN.setEnabled(true);
        }
      }
      if (this.Agh.Adm)
      {
        parama.gpN.setVisibility(8);
        parama.Agg.setChecked(paramBoolean2);
        parama.Agg.setEnabled(true);
        parama.Agg.setVisibility(0);
        break label118;
      }
      parama.gpN.setVisibility(8);
      break label118;
      label383:
      parama.contentView.setBackgroundResource(2130838445);
    }
    label395:
    parama.Aak.setVisibility(8);
    label404:
    AppMethodBeat.o(105280);
  }
  
  public final boolean aoZ()
  {
    AppMethodBeat.i(105281);
    if (this.Agh.hrL != null) {
      ((n)g.G(n.class)).updateTopHitsRank(this.Agh.query, this.Agh.hrL, 1);
    }
    AppMethodBeat.o(105281);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.e.b
 * JD-Core Version:    0.7.0.1
 */