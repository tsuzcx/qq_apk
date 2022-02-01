package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
    AppMethodBeat.i(78653);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      h.a(this.val$context, true, this.val$context.getString(2131766115), "", this.val$context.getString(2131766111), this.val$context.getString(2131766112), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78652);
          LuggageUploadMediaFileManager.ePS().cancel();
          AppMethodBeat.o(78652);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(78653);
      return true;
    }
    AppMethodBeat.o(78653);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.9
 * JD-Core Version:    0.7.0.1
 */