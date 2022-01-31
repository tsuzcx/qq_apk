package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.n.d;

final class RecordMsgDetailUI$3$2
  implements n.d
{
  RecordMsgDetailUI$3$2(RecordMsgDetailUI.3 param3) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("select_is_ret", true);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("Retr_Msg_Type", 10);
      paramMenuItem.putExtra("Retr_Msg_Id", RecordMsgDetailUI.c(this.nua.ntZ));
      d.c(this.nua.ntZ, ".ui.transmit.SelectConversationUI", paramMenuItem, 1001);
      return;
    }
    paramMenuItem = new cj();
    e.a(paramMenuItem, RecordMsgDetailUI.c(this.nua.ntZ));
    paramMenuItem.bIw.bID = 9;
    paramMenuItem.bIw.activity = this.nua.ntZ;
    a.udP.m(paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.3.2
 * JD-Core Version:    0.7.0.1
 */