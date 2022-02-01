package com.tencent.mm.ui.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmWizardActivity;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/report/MMSecDataWizzardActivity;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmWizardActivity;", "()V", "superImportUIComponents", "", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "ui-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class MMSecDataWizzardActivity
  extends BaseMvvmWizardActivity
{
  public void _$_clearFindViewByIdCache() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(a.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.report.MMSecDataWizzardActivity
 * JD-Core Version:    0.7.0.1
 */