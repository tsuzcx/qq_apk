package com.tencent.mm.plugin.taskbar.ui.section;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarBaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;)V", "getItemView", "plugin-taskbar_release"})
public final class a
  extends RecyclerView.v
{
  public a(b paramb)
  {
    super((View)paramb);
    AppMethodBeat.i(214212);
    paramb.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, -2));
    AppMethodBeat.o(214212);
  }
  
  public final b gkf()
  {
    AppMethodBeat.i(214210);
    Object localObject = this.amk;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.taskbar.ui.section.TaskBarSectionBaseView");
      AppMethodBeat.o(214210);
      throw ((Throwable)localObject);
    }
    localObject = (b)localObject;
    AppMethodBeat.o(214210);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.a
 * JD-Core Version:    0.7.0.1
 */