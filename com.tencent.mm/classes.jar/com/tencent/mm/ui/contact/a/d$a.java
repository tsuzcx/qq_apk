package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;

final class d$a
  extends f.b
{
  d$a(d paramd)
  {
    super(paramd);
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(105276);
    super.a(paramContext, parama, parama1, paramBoolean1, paramBoolean2);
    parama = (f.a)parama;
    if (!bo.aa(this.Agb.AfY))
    {
      parama.gpM.setVisibility(0);
      this.Agb.AfY = j.b(paramContext, this.Agb.AfY, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
      paramContext = parama.gpM;
      parama = parama.gpM.getContext().getResources();
      if (this.Agb.AfZ) {}
      for (int i = 2131298577;; i = 2131298576)
      {
        paramContext.setText(parama.getString(i, new Object[] { this.Agb.AfY }));
        AppMethodBeat.o(105276);
        return;
      }
    }
    parama.gpM.setVisibility(8);
    AppMethodBeat.o(105276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d.a
 * JD-Core Version:    0.7.0.1
 */