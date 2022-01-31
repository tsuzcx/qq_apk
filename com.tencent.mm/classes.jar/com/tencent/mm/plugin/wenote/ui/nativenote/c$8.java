package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.ui.base.t;

final class c$8
  implements View.OnClickListener
{
  c$8(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27122);
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().aw(-1, false);
    if (!f.Mi())
    {
      t.ii(this.val$context);
      AppMethodBeat.o(27122);
      return;
    }
    paramView = new Intent(this.val$context, FileExplorerUI.class);
    paramView.putExtra("key_title", this.val$context.getString(2131299777));
    ((Activity)this.val$context).startActivityForResult(paramView, 4099);
    AppMethodBeat.o(27122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.8
 * JD-Core Version:    0.7.0.1
 */