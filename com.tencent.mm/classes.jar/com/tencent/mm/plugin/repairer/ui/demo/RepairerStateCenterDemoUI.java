package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerStateCenterDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "superImportUIComponents", "", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerStateCenterDemoUI
  extends BaseRepairerUI
{
  public final int getLayoutId()
  {
    return b.d.OvT;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(278577);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(i.class);
    paramHashSet.add(a.class);
    paramHashSet.add(b.class);
    paramHashSet.add(c.class);
    AppMethodBeat.o(278577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerStateCenterDemoUI
 * JD-Core Version:    0.7.0.1
 */