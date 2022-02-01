package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.cy;
import com.tencent.mm.f.a.cy.a;
import com.tencent.mm.f.a.cy.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;

final class TVInfoUI$6
  implements h.e
{
  TVInfoUI$6(TVInfoUI paramTVInfoUI) {}
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28585);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28585);
      return;
      h.a(this.Jrj.getContext(), this.Jrj.getContext().getString(R.l.app_delete_tips), null, null, this.Jrj.getContext().getString(R.l.app_delete), new h.e()
      {
        public final void cS(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(28584);
          switch (paramAnonymousInt2)
          {
          default: 
            Log.d("MicroMsg.TVInfoUI", "do del cancel");
          }
          cy localcy;
          do
          {
            AppMethodBeat.o(28584);
            return;
            localcy = new cy();
            localcy.fyC.fyE = TVInfoUI.6.this.Jrj.getIntent().getLongExtra("key_favorite_local_id", -1L);
            EventCenter.instance.publish(localcy);
            Log.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", new Object[] { Long.valueOf(localcy.fyC.fyE), Boolean.valueOf(localcy.fyD.fyl) });
          } while (!localcy.fyD.fyl);
          TVInfoUI.6.this.Jrj.finish();
          AppMethodBeat.o(28584);
        }
      });
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.b(this.Jrj);
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.c(this.Jrj);
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.d(this.Jrj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.6
 * JD-Core Version:    0.7.0.1
 */