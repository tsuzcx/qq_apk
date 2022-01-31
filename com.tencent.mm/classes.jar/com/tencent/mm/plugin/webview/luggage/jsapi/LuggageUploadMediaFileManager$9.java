package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class LuggageUploadMediaFileManager$9
  implements DialogInterface.OnKeyListener
{
  LuggageUploadMediaFileManager$9(Context paramContext) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(6401);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      h.a(this.val$context, true, this.val$context.getString(2131305881), "", this.val$context.getString(2131305877), this.val$context.getString(2131305878), new LuggageUploadMediaFileManager.9.1(this), new LuggageUploadMediaFileManager.9.2(this));
      AppMethodBeat.o(6401);
      return true;
    }
    AppMethodBeat.o(6401);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.9
 * JD-Core Version:    0.7.0.1
 */