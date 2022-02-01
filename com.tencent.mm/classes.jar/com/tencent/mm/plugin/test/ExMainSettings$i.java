package com.tencent.mm.plugin.test;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/test/ExMainSettings$initList$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
public final class ExMainSettings$i
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196999);
    Object localObject = new Intent((Context)this.zYc, Class.forName("com.tencent.mm.plugin.finder.ui.FinderSettingsUI"));
    paramView = this.zYc;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/test/ExMainSettings$initList$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(196999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.test.ExMainSettings.i
 * JD-Core Version:    0.7.0.1
 */