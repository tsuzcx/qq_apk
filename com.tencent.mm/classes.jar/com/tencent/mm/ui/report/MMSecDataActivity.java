package com.tencent.mm.ui.report;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "ui-sec-data_release"})
public abstract class MMSecDataActivity
  extends MMActivity
{
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    Set localSet = super.importUIComponents();
    if (localSet != null) {
      return ak.b(localSet, (Iterable)ak.setOf(new Class[] { com.tencent.mm.plugin.livebase.a.a.class, com.tencent.mm.plugin.secdata.ui.a.class }));
    }
    return null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.report.MMSecDataActivity
 * JD-Core Version:    0.7.0.1
 */