package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.di;
import com.tencent.mm.autogen.a.di.a;
import com.tencent.mm.autogen.a.di.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;

final class TVInfoUI$6
  implements k.e
{
  TVInfoUI$6(TVInfoUI paramTVInfoUI) {}
  
  public final void onClick(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28585);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28585);
      return;
      k.a(this.PEH.getContext(), this.PEH.getContext().getString(R.l.app_delete_tips), null, null, this.PEH.getContext().getString(R.l.app_delete), new k.e()
      {
        public final void onClick(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(28584);
          switch (paramAnonymousInt2)
          {
          default: 
            Log.d("MicroMsg.TVInfoUI", "do del cancel");
          }
          di localdi;
          do
          {
            AppMethodBeat.o(28584);
            return;
            localdi = new di();
            localdi.hDl.hDn = TVInfoUI.6.this.PEH.getIntent().getLongExtra("key_favorite_local_id", -1L);
            localdi.publish();
            Log.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", new Object[] { Long.valueOf(localdi.hDl.hDn), Boolean.valueOf(localdi.hDm.hCQ) });
          } while (!localdi.hDm.hCQ);
          TVInfoUI.6.this.PEH.finish();
          AppMethodBeat.o(28584);
        }
      });
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.b(this.PEH);
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.c(this.PEH);
      AppMethodBeat.o(28585);
      return;
      TVInfoUI.d(this.PEH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.6
 * JD-Core Version:    0.7.0.1
 */