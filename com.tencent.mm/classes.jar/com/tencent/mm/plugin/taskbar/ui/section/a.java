package com.tencent.mm.plugin.taskbar.ui.section;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarBaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;)V", "getItemView", "plugin-taskbar_release"})
public final class a
  extends RecyclerView.v
{
  public a(b paramb)
  {
    super((View)paramb);
    AppMethodBeat.i(238493);
    paramb.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, -2));
    AppMethodBeat.o(238493);
  }
  
  public final b fvh()
  {
    AppMethodBeat.i(238492);
    Object localObject = this.aus;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.taskbar.ui.section.TaskBarSectionBaseView");
      AppMethodBeat.o(238492);
      throw ((Throwable)localObject);
    }
    localObject = (b)localObject;
    AppMethodBeat.o(238492);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.a
 * JD-Core Version:    0.7.0.1
 */