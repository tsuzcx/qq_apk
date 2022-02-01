package com.tencent.mm.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.util.c;

final class HomeUI$7
  implements View.OnLongClickListener
{
  HomeUI$7(HomeUI paramHomeUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(186949);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$15", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahF());
    paramView = c.LDf;
    if (c.fSh())
    {
      localObject = new Intent();
      ((Intent)localObject).setClassName(HomeUI.b(this.Jta), "com.tencent.mm.plugin.websearch.ui.WebSearchExptSettingUI");
      paramView = HomeUI.b(this.Jta);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/HomeUI$15", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/HomeUI$15", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/HomeUI$15", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(186949);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.7
 * JD-Core Version:    0.7.0.1
 */