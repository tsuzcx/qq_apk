package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.c.a;

final class RecordMsgDetailUI$3$2
  implements n.d
{
  RecordMsgDetailUI$3$2(RecordMsgDetailUI.3 param3) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(24237);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24237);
      return;
      aw.aaz();
      if (!((Boolean)com.tencent.mm.model.c.Ru().get(327714, Boolean.FALSE)).booleanValue())
      {
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(327714, Boolean.TRUE);
        paramMenuItem = new c.a(this.pZI.pZH);
        paramMenuItem.avn(this.pZI.pZH.getResources().getString(2131302362));
        paramMenuItem.avm(this.pZI.pZH.getResources().getString(2131297087));
        paramMenuItem.Ri(2131300718).a(new RecordMsgDetailUI.3.2.1(this));
        paramMenuItem.aLZ().show();
        AppMethodBeat.o(24237);
        return;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("select_is_ret", true);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("Retr_Msg_Type", 10);
      paramMenuItem.putExtra("Retr_Msg_Id", RecordMsgDetailUI.c(this.pZI.pZH));
      d.b(this.pZI.pZH, ".ui.transmit.SelectConversationUI", paramMenuItem, 1001);
      AppMethodBeat.o(24237);
      return;
      AppMethodBeat.o(24237);
      return;
      paramMenuItem = new cm();
      e.a(paramMenuItem, RecordMsgDetailUI.c(this.pZI.pZH));
      paramMenuItem.cpR.cpY = 9;
      paramMenuItem.cpR.activity = this.pZI.pZH;
      a.ymk.l(paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.3.2
 * JD-Core Version:    0.7.0.1
 */