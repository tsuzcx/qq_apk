package com.tencent.mm.plugin.topstory.ui.multitask;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/topstory/ui/multitask/TopStoryMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "ui-topstory_release"})
public final class b
  extends com.tencent.mm.plugin.multitask.a.b
{
  public b(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(236423);
    Activity localActivity = (Activity)Objects.requireNonNull(super.getActivity());
    AppMethodBeat.o(236423);
    return localActivity;
  }
  
  public final void setActivity(Activity paramActivity)
  {
    AppMethodBeat.i(236424);
    super.setActivity(paramActivity);
    AppMethodBeat.o(236424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.multitask.b
 * JD-Core Version:    0.7.0.1
 */