package com.tencent.mm.plugin.taskbar.ui.section;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$UnClipRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onAttachedToWindow", "", "setClipChild", "plugin-taskbar_release"})
public final class e$c
  extends RecyclerView
{
  public e$c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(238511);
    AppMethodBeat.o(238511);
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(238510);
    super.onAttachedToWindow();
    setClipChildren(false);
    View localView = getRootView();
    Object localObject = getParent();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(238510);
      throw ((Throwable)localObject);
    }
    for (localObject = (View)localObject; (localObject != localView) && ((localObject instanceof ViewGroup)); localObject = (View)localObject)
    {
      ((ViewGroup)localObject).setClipChildren(false);
      if ((localObject instanceof RecyclerView)) {
        break;
      }
      localObject = ((View)localObject).getParent();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(238510);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(238510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.e.c
 * JD-Core Version:    0.7.0.1
 */