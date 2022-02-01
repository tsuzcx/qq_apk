package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sensitive.d;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.sensitive.d.f;
import com.tencent.mm.ui.base.aa;

final class c$8
  implements View.OnClickListener
{
  c$8(c paramc, Context paramContext) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(30819);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().aw(-1, false);
    if (!e.aPU())
    {
      aa.j(this.val$context, null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(30819);
      return;
    }
    paramView = new Intent(this.val$context, FileExplorerUI.class);
    paramView.putExtra("key_title", this.val$context.getString(R.l.favorite_post_title_file));
    if (((d)h.az(d.class)).checkAndShowPermissionDialog(d.c.actw, new d.f()
    {
      public final void onOp(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(275193);
        if (paramAnonymousBoolean.booleanValue())
        {
          paramAnonymousBoolean = (Activity)c.8.this.val$context;
          Intent localIntent = paramView;
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousBoolean, com.tencent.mm.hellhoundlib.b.c.a(4099, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$4$1", "onOp", "(Ljava/lang/Boolean;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        }
        AppMethodBeat.o(275193);
      }
    }))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(30819);
      return;
    }
    com.tencent.mm.hellhoundlib.a.a.a((Activity)this.val$context, com.tencent.mm.hellhoundlib.b.c.a(4099, new com.tencent.mm.hellhoundlib.b.a()).cG(paramView).aYi(), "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$4", "onClick", "(Landroid/view/View;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/WNNoteFootPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(30819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c.8
 * JD-Core Version:    0.7.0.1
 */