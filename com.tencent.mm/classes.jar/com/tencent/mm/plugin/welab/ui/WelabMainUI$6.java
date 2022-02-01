package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.util.d;

final class WelabMainUI$6
  implements View.OnLongClickListener
{
  WelabMainUI$6(WelabMainUI paramWelabMainUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(248491);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/welab/ui/WelabMainUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
    paramView = paramView.getTag();
    if (((paramView instanceof com.tencent.mm.plugin.welab.d.a.a)) && ("wximeplugin".equals(((com.tencent.mm.plugin.welab.d.a.a)paramView).field_LabsAppId)))
    {
      paramView = d.YyA;
      if (!d.ien()) {}
    }
    try
    {
      localObject = new Intent(this.QFN.getContext(), Class.forName("com.tencent.mm.plugin.hld.ui.HldDebugUI"));
      ((Intent)localObject).setFlags(268435456);
      paramView = this.QFN;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/welab/ui/WelabMainUI$6", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/welab/ui/WelabMainUI$6", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      label163:
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(248491);
      return true;
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/welab/ui/WelabMainUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(248491);
      return false;
    }
    catch (ClassNotFoundException paramView)
    {
      break label163;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI.6
 * JD-Core Version:    0.7.0.1
 */