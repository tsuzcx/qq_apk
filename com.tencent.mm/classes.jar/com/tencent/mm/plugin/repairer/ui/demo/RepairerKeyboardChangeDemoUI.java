package com.tencent.mm.plugin.repairer.ui.demo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(1)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerKeyboardChangeDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerKeyboardChangeDemoUI
  extends BaseRepairerUI
{
  private static final void a(RepairerKeyboardChangeDemoUI paramRepairerKeyboardChangeDemoUI, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(278254);
    s.u(paramRepairerKeyboardChangeDemoUI, "this$0");
    paramView = k.aeZF;
    ((com.tencent.mm.plugin.mvvmbase.b.a)k.d((AppCompatActivity)paramRepairerKeyboardChangeDemoUI).q(com.tencent.mm.plugin.mvvmbase.b.a.class)).Aa(paramBoolean);
    AppMethodBeat.o(278254);
  }
  
  private static final boolean a(RepairerKeyboardChangeDemoUI paramRepairerKeyboardChangeDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278249);
    s.u(paramRepairerKeyboardChangeDemoUI, "this$0");
    paramRepairerKeyboardChangeDemoUI.finish();
    AppMethodBeat.o(278249);
    return true;
  }
  
  public final int getLayoutId()
  {
    return b.d.Ovu;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278291);
    super.onCreate(paramBundle);
    setMMTitle("键盘高度调整Demo");
    setBackBtn(new RepairerKeyboardChangeDemoUI..ExternalSyntheticLambda0(this));
    paramBundle = new RepairerKeyboardChangeDemoUI..ExternalSyntheticLambda1(this);
    MMClearEditText localMMClearEditText = (MMClearEditText)findViewById(b.c.Ouf);
    if (localMMClearEditText != null) {
      localMMClearEditText.setOnFocusChangeListener(paramBundle);
    }
    localMMClearEditText = (MMClearEditText)findViewById(b.c.Oug);
    if (localMMClearEditText != null) {
      localMMClearEditText.setOnFocusChangeListener(paramBundle);
    }
    localMMClearEditText = (MMClearEditText)findViewById(b.c.Ouh);
    if (localMMClearEditText != null) {
      localMMClearEditText.setOnFocusChangeListener(paramBundle);
    }
    localMMClearEditText = (MMClearEditText)findViewById(b.c.Oui);
    if (localMMClearEditText != null) {
      localMMClearEditText.setOnFocusChangeListener(paramBundle);
    }
    localMMClearEditText = (MMClearEditText)findViewById(b.c.Ouj);
    if (localMMClearEditText != null) {
      localMMClearEditText.setOnFocusChangeListener(paramBundle);
    }
    localMMClearEditText = (MMClearEditText)findViewById(b.c.Ouk);
    if (localMMClearEditText != null) {
      localMMClearEditText.setOnFocusChangeListener(paramBundle);
    }
    AppMethodBeat.o(278291);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(278276);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.mvvmbase.b.a.class);
    AppMethodBeat.o(278276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerKeyboardChangeDemoUI
 * JD-Core Version:    0.7.0.1
 */