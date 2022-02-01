package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.cn.a;
import com.tencent.mm.g.a.cn.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

final class TVInfoUI$6
  implements h.d
{
  TVInfoUI$6(TVInfoUI paramTVInfoUI) {}
  
  public final void ct(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28585);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28585);
      return;
      h.a(this.xBW.getContext(), this.xBW.getContext().getString(2131755709), null, null, this.xBW.getContext().getString(2131755707), new h.d()
      {
        public final void ct(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(28584);
          switch (paramAnonymousInt2)
          {
          default: 
            ac.d("MicroMsg.TVInfoUI", "do del cancel");
          }
          cn localcn;
          do
          {
            AppMethodBeat.o(28584);
            return;
            localcn = new cn();
            localcn.dce.dcg = TVInfoUI.6.this.xBW.getIntent().getLongExtra("key_favorite_local_id", -1L);
            a.GpY.l(localcn);
            ac.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", new Object[] { Long.valueOf(localcn.dce.dcg), Boolean.valueOf(localcn.dcf.dbS) });
          } while (!localcn.dcf.dbS);
          TVInfoUI.6.this.xBW.finish();
          AppMethodBeat.o(28584);
        }
      });
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.b(this.xBW);
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.c(this.xBW);
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.d(this.xBW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.6
 * JD-Core Version:    0.7.0.1
 */