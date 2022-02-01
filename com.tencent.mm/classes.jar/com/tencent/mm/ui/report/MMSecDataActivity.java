package com.tencent.mm.ui.report;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "ui-sec-data_release"})
public abstract class MMSecDataActivity
  extends MMActivity
{
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    return ak.setOf(SecDataUIC.class);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.report.MMSecDataActivity
 * JD-Core Version:    0.7.0.1
 */