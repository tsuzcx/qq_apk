package com.tencent.mm.plugin.nearlife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

final class BaseLifeUI$4
  implements View.OnClickListener
{
  BaseLifeUI$4(BaseLifeUI paramBaseLifeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26563);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    paramView = this.wqQ.vfv;
    paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahp(), "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.c.b((ListView)paramView.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.4
 * JD-Core Version:    0.7.0.1
 */