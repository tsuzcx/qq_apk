package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cu.a;
import com.tencent.mm.g.a.cu.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;

final class TVInfoUI$6
  implements h.e
{
  TVInfoUI$6(TVInfoUI paramTVInfoUI) {}
  
  public final void cy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28585);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28585);
      return;
      h.a(this.DlH.getContext(), this.DlH.getContext().getString(2131755780), null, null, this.DlH.getContext().getString(2131755778), new h.e()
      {
        public final void cy(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(28584);
          switch (paramAnonymousInt2)
          {
          default: 
            Log.d("MicroMsg.TVInfoUI", "do del cancel");
          }
          cu localcu;
          do
          {
            AppMethodBeat.o(28584);
            return;
            localcu = new cu();
            localcu.dFU.dFW = TVInfoUI.6.this.DlH.getIntent().getLongExtra("key_favorite_local_id", -1L);
            EventCenter.instance.publish(localcu);
            Log.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", new Object[] { Long.valueOf(localcu.dFU.dFW), Boolean.valueOf(localcu.dFV.dFE) });
          } while (!localcu.dFV.dFE);
          TVInfoUI.6.this.DlH.finish();
          AppMethodBeat.o(28584);
        }
      });
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.b(this.DlH);
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.c(this.DlH);
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.d(this.DlH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.6
 * JD-Core Version:    0.7.0.1
 */