package com.tencent.mm.plugin.repairer.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.uic.c;
import com.tencent.mm.plugin.repairer.ui.uic.e;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerPrefUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseRepairerPrefUI
  extends BaseRepairerUI
{
  private static final boolean a(BaseRepairerPrefUI paramBaseRepairerPrefUI, MenuItem paramMenuItem)
  {
    s.u(paramBaseRepairerPrefUI, "this$0");
    paramBaseRepairerPrefUI.onBackPressed();
    return true;
  }
  
  private static final boolean b(BaseRepairerPrefUI paramBaseRepairerPrefUI, MenuItem paramMenuItem)
  {
    s.u(paramBaseRepairerPrefUI, "this$0");
    paramMenuItem = paramBaseRepairerPrefUI.getStateCenter();
    if (paramMenuItem != null)
    {
      paramMenuItem = (com.tencent.mm.plugin.repairer.ui.d.b)paramMenuItem.getState();
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.Oyn;
        if (paramMenuItem != null) {
          paramBaseRepairerPrefUI.startActivityForResult(new Intent((Context)paramBaseRepairerPrefUI, RepairerSearchUI.class).putExtra("key_config_item_list", paramMenuItem.toByteArray()), 1);
        }
      }
    }
    return false;
  }
  
  public int getLayoutId()
  {
    return b.d.Owd;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new BaseRepairerPrefUI..ExternalSyntheticLambda1(this));
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.observe((q)this, (kotlin.g.a.b)new BaseRepairerPrefUI.a(this));
    }
    addIconOptionMenu(0, 0, b.e.actionbar_icon_light_search, new BaseRepairerPrefUI..ExternalSyntheticLambda0(this));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(e.class);
    paramHashSet.add(c.class);
    paramHashSet.add(com.tencent.mm.plugin.repairer.ui.uic.b.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.BaseRepairerPrefUI
 * JD-Core Version:    0.7.0.1
 */