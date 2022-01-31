package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.n.d;

final class RecordMsgImageUI$12
  implements n.d
{
  RecordMsgImageUI$12(RecordMsgImageUI paramRecordMsgImageUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(153616);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(153616);
      return;
      RecordMsgImageUI.h(this.pZV);
      AppMethodBeat.o(153616);
      return;
      paramMenuItem = this.pZV;
      cm localcm = new cm();
      e.a(localcm, paramMenuItem.getIntent().getIntExtra("key_favorite_source_type", 1), paramMenuItem.cge());
      localcm.cpR.cpY = 10;
      localcm.cpR.activity = paramMenuItem;
      a.ymk.l(localcm);
      AppMethodBeat.o(153616);
      return;
      RecordMsgImageUI.i(this.pZV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgImageUI.12
 * JD-Core Version:    0.7.0.1
 */