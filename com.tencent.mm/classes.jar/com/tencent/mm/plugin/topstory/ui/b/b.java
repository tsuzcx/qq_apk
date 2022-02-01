package com.tencent.mm.plugin.topstory.ui.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/topstory/ui/multitask/TopStoryMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "ui-topstory_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.multitask.a.b
{
  public b(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final Activity getActivity()
  {
    AppMethodBeat.i(271676);
    Activity localActivity = (Activity)Objects.requireNonNull(super.getActivity());
    AppMethodBeat.o(271676);
    return localActivity;
  }
  
  public final void setActivity(Activity paramActivity)
  {
    AppMethodBeat.i(271680);
    super.setActivity(paramActivity);
    AppMethodBeat.o(271680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.b.b
 * JD-Core Version:    0.7.0.1
 */