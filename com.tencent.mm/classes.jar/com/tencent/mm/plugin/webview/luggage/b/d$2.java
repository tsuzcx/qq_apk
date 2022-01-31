package com.tencent.mm.plugin.webview.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import com.tencent.mm.ui.base.h.d;

final class d$2
  implements h.d
{
  d$2(d paramd, e parame, Context paramContext) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    FavUrlTask localFavUrlTask;
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putLong("fav_local_id", this.kNu.biV.getLong("fav_local_id", -1L));
      localFavUrlTask = new FavUrlTask();
      localFavUrlTask.actionType = 4;
      localFavUrlTask.kke = localBundle;
      LuggageMainProcessService.b(localFavUrlTask);
    } while (!localFavUrlTask.bFQ);
    ((Activity)this.val$context).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.d.2
 * JD-Core Version:    0.7.0.1
 */