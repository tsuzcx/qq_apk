package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandDebugUI;
import com.tencent.mm.plugin.appbrand.ui.f;

final class TaskBarSectionWeAppRecyclerView$a$2
  implements View.OnLongClickListener
{
  TaskBarSectionWeAppRecyclerView$a$2(TaskBarSectionWeAppRecyclerView.a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(238366);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
    if (f.bWW())
    {
      localObject = new Intent(this.FVZ.FVV.getContext(), AppBrandDebugUI.class);
      paramView = this.FVZ.FVV.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$2", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$2", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(238366);
      return true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppRecyclerView$ItemAdapter$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(238366);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView.a.2
 * JD-Core Version:    0.7.0.1
 */