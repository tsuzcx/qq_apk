package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class e$1
  implements View.OnClickListener
{
  e$1(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(80989);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/webview/ui/tools/game/menu/GameSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (this.ECI.isShowing()) {
      this.ECI.cancel();
    }
    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/game/menu/GameSheetDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(80989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.e.1
 * JD-Core Version:    0.7.0.1
 */