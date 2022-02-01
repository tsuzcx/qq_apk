package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.ui.base.t;

final class c$8
  implements View.OnClickListener
{
  c$8(c paramc, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30819);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().Z(-1, false);
    if (!e.abo())
    {
      t.g(this.val$context, null);
      a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(30819);
      return;
    }
    paramView = new Intent(this.val$context, FileExplorerUI.class);
    paramView.putExtra("key_title", this.val$context.getString(2131758949));
    ((Activity)this.val$context).startActivityForResult(paramView, 4099);
    a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(30819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.8
 * JD-Core Version:    0.7.0.1
 */