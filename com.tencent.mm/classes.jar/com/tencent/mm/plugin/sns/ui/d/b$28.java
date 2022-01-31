package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class b$28
  implements AdapterView.OnItemClickListener
{
  b$28(b paramb) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(40284);
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
    {
      paramAdapterView = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
      if (paramInt < paramAdapterView.rba.scr.rpz.cqj().size())
      {
        if (paramAdapterView.rba.scr.rpD)
        {
          AppMethodBeat.o(40284);
          return;
        }
        a.b.a locala = (a.b.a)paramAdapterView.rba.scr.rpz.cqj().get(paramInt);
        ab.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[] { locala.rpJ, Integer.valueOf(locala.rpM) });
        n localn = ag.cpf().abv(paramAdapterView.crk);
        if (localn == null)
        {
          AppMethodBeat.o(40284);
          return;
        }
        locala.rbb = paramAdapterView.rbb;
        locala.rpN = System.currentTimeMillis();
        paramAdapterView = new r(localn.field_snsId, 8, locala);
        g.RM();
        g.RK().eHt.a(paramAdapterView, 0);
        this.skd.dO(paramView);
      }
    }
    AppMethodBeat.o(40284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.28
 * JD-Core Version:    0.7.0.1
 */