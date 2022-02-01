package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.ui.base.t;

final class c$8
  implements View.OnClickListener
{
  c$8(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30819);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().X(-1, false);
    if (!e.XG())
    {
      t.g(this.val$context, null);
      AppMethodBeat.o(30819);
      return;
    }
    paramView = new Intent(this.val$context, FileExplorerUI.class);
    paramView.putExtra("key_title", this.val$context.getString(2131758949));
    ((Activity)this.val$context).startActivityForResult(paramView, 4099);
    AppMethodBeat.o(30819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.8
 * JD-Core Version:    0.7.0.1
 */