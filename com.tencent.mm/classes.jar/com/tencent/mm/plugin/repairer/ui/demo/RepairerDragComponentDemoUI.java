package com.tencent.mm.plugin.repairer.ui.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.b;
import com.tencent.mm.ui.report.MMSecDataActivity;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerDragComponentDemoUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"})
public final class RepairerDragComponentDemoUI
  extends MMSecDataActivity
{
  private final String TAG = "MicroMsg.RepairerDragComponentDemoUI";
  
  public final int getLayoutId()
  {
    return b.b.IwH;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227508);
    super.onCreate(paramBundle);
    setMMTitle("滑动组件Demo");
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    AppMethodBeat.o(227508);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(RepairerDragComponentDemoUI paramRepairerDragComponentDemoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226940);
      this.IxF.finish();
      AppMethodBeat.o(226940);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerDragComponentDemoUI
 * JD-Core Version:    0.7.0.1
 */