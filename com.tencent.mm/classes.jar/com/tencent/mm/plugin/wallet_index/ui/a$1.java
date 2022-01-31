package com.tencent.mm.plugin.wallet_index.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class a$1
  extends BroadcastReceiver
{
  a$1(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE".equals(paramContext)) {
      a.a(this.qLD, com.tencent.mm.plugin.wallet_index.b.a.a.a(paramIntent, a.a(this.qLD)));
    }
    while (!"com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE".equals(paramContext)) {
      return;
    }
    com.tencent.mm.plugin.wallet_index.b.a.a.a(paramIntent, new a.1.1(this, paramIntent.getBooleanExtra("is_direct", true)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.a.1
 * JD-Core Version:    0.7.0.1
 */