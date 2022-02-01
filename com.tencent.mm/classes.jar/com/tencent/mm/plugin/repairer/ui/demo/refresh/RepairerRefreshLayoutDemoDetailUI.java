package com.tencent.mm.plugin.repairer.ui.demo.refresh;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoEightFragment;
import com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoFiveFragment;
import com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoFourFragment;
import com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoOneFragment;
import com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoSevFragment;
import com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoSixFragment;
import com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoThreeFragment;
import com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoTwoFragment;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.ui.widget.pulldown.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/RepairerRefreshLayoutDemoDetailUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "type", "", "getType", "()I", "setType", "(I)V", "createFragment", "Landroidx/fragment/app/Fragment;", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerRefreshLayoutDemoDetailUI
  extends MMSecDataActivity
{
  public static final RepairerRefreshLayoutDemoDetailUI.a OxK;
  private int type;
  
  static
  {
    AppMethodBeat.i(278439);
    OxK = new RepairerRefreshLayoutDemoDetailUI.a((byte)0);
    AppMethodBeat.o(278439);
  }
  
  public final int getLayoutId()
  {
    return b.d.OvF;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278456);
    super.onCreate(paramBundle);
    this.type = getIntent().getIntExtra("KEY_SHOW_TYPE", 0);
    r localr = getSupportFragmentManager().beginTransaction();
    s.s(localr, "supportFragmentManager.beginTransaction()");
    int i = b.c.fOk;
    switch (this.type)
    {
    default: 
      new DemoOneFragment();
      paramBundle = new Fragment();
    }
    for (;;)
    {
      localr.a(i, paramBundle).FW();
      AppMethodBeat.o(278456);
      return;
      setMMTitle("RecyclerView Demo");
      paramBundle = (Fragment)new DemoOneFragment();
      continue;
      setMMTitle("NestScrollView Demo");
      paramBundle = (Fragment)new DemoTwoFragment();
      continue;
      setMMTitle("CoordinatorLayout Demo");
      paramBundle = (Fragment)new DemoThreeFragment();
      continue;
      setMMTitle("ListView Demo");
      paramBundle = (Fragment)new DemoFourFragment();
      continue;
      setMMTitle("Stagger Layout Demo");
      paramBundle = (Fragment)new DemoFiveFragment();
      continue;
      setMMTitle("PageSnapHelper Demo");
      paramBundle = (Fragment)new DemoSixFragment();
      continue;
      setMMTitle("NoMoreData Demo");
      paramBundle = (Fragment)new DemoSevFragment();
      continue;
      setMMTitle("属性设置 Demo");
      paramBundle = (Fragment)new DemoEightFragment();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.RepairerRefreshLayoutDemoDetailUI
 * JD-Core Version:    0.7.0.1
 */