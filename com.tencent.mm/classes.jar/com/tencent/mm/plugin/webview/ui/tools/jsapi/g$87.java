package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class g$87
  implements DialogInterface.OnKeyListener
{
  g$87(g paramg) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(155007);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1))
    {
      h.a(g.j(this.vqm), true, g.j(this.vqm).getString(2131305881), "", g.j(this.vqm).getString(2131305877), g.j(this.vqm).getString(2131305878), new DialogInterface.OnClickListener()new g.87.2
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(155006);
          g.E(g.87.this.vqm).cancel();
          AppMethodBeat.o(155006);
        }
      }, new g.87.2(this));
      AppMethodBeat.o(155007);
      return true;
    }
    AppMethodBeat.o(155007);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.87
 * JD-Core Version:    0.7.0.1
 */