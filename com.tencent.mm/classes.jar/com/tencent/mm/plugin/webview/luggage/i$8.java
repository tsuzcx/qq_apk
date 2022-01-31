package com.tencent.mm.plugin.webview.luggage;

import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class i$8
  implements a.b
{
  i$8(i parami) {}
  
  public final void amw()
  {
    FavUrlTask localFavUrlTask = new FavUrlTask();
    localFavUrlTask.actionType = 2;
    LuggageMainProcessService.a(localFavUrlTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.i.8
 * JD-Core Version:    0.7.0.1
 */