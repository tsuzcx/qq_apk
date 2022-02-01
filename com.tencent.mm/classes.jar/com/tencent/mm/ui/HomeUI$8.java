package com.tencent.mm.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.util.c;

final class HomeUI$8
  implements View.OnLongClickListener
{
  HomeUI$8(HomeUI paramHomeUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(232554);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$16", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
    paramView = c.QYz;
    if (c.hdg())
    {
      localObject = new Intent();
      ((Intent)localObject).setClassName(HomeUI.b(this.ODr), "com.tencent.mm.plugin.websearch.ui.WebSearchExptSettingUI");
      paramView = HomeUI.b(this.ODr);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/HomeUI$16", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/HomeUI$16", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/HomeUI$16", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(232554);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.8
 * JD-Core Version:    0.7.0.1
 */