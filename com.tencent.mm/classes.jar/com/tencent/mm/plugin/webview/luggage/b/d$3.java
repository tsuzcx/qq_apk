package com.tencent.mm.plugin.webview.luggage.b;

import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class d$3
  implements a.b
{
  d$3(d paramd) {}
  
  public final void amw()
  {
    FavUrlTask localFavUrlTask = new FavUrlTask();
    localFavUrlTask.actionType = 2;
    LuggageMainProcessService.a(localFavUrlTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.d.3
 * JD-Core Version:    0.7.0.1
 */