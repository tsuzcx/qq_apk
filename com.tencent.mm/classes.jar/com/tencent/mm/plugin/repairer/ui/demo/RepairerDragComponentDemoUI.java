package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDragComponentDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerDragComponentDemoUI
  extends BaseRepairerUI
{
  private final String TAG = "MicroMsg.RepairerDragComponentDemoUI";
  
  private static final boolean a(RepairerDragComponentDemoUI paramRepairerDragComponentDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278607);
    s.u(paramRepairerDragComponentDemoUI, "this$0");
    paramRepairerDragComponentDemoUI.finish();
    AppMethodBeat.o(278607);
    return true;
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovt;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278623);
    super.onCreate(paramBundle);
    setMMTitle("滑动组件Demo");
    setBackBtn(new RepairerDragComponentDemoUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(278623);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerDragComponentDemoUI
 * JD-Core Version:    0.7.0.1
 */