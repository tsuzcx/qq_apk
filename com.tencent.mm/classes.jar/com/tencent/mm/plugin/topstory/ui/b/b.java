package com.tencent.mm.plugin.topstory.ui.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/topstory/ui/multitask/TopStoryMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "ui-topstory_release"})
public final class b
  extends com.tencent.mm.plugin.multitask.a.b
{
  public b(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(204150);
    Activity localActivity = (Activity)Objects.requireNonNull(super.getActivity());
    AppMethodBeat.o(204150);
    return localActivity;
  }
  
  public final void setActivity(Activity paramActivity)
  {
    AppMethodBeat.i(204151);
    super.setActivity(paramActivity);
    AppMethodBeat.o(204151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.b.b
 * JD-Core Version:    0.7.0.1
 */