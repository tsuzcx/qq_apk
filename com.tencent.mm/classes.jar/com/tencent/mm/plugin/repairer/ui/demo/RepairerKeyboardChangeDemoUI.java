package com.tencent.mm.plugin.repairer.ui.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.a;
import com.tencent.mm.plugin.repairer.ui.b.b;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.c.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerKeyboardChangeDemoUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onInputPanelChange", "isKeyboardShow", "", "keyboardHeight", "ui-repairer_release"})
public final class RepairerKeyboardChangeDemoUI
  extends MMSecDataActivity
  implements c.a
{
  public final int getLayoutId()
  {
    return b.b.IwI;
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(226966);
    if (paramBoolean)
    {
      localView = findViewById(b.a.Iwl);
      if (localView != null)
      {
        localView.setPadding(0, 0, 0, paramInt);
        AppMethodBeat.o(226966);
        return;
      }
      AppMethodBeat.o(226966);
      return;
    }
    View localView = findViewById(b.a.Iwl);
    if (localView != null)
    {
      localView.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(226966);
      return;
    }
    AppMethodBeat.o(226966);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(226964);
    super.onCreate(paramBundle);
    setMMTitle("键盘高度调整Demo");
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = (InputPanelLinearLayout)findViewById(b.a.Iwl);
    if (paramBundle != null)
    {
      paramBundle.setExternalListener((c.a)this);
      AppMethodBeat.o(226964);
      return;
    }
    AppMethodBeat.o(226964);
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
    a(RepairerKeyboardChangeDemoUI paramRepairerKeyboardChangeDemoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226572);
      this.IxG.finish();
      AppMethodBeat.o(226572);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerKeyboardChangeDemoUI
 * JD-Core Version:    0.7.0.1
 */