package com.tencent.mm.ui.widget;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/PostCompactHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "attached", "", "getAttached", "()Z", "setAttached", "(Z)V", "postQueue", "", "Ljava/lang/Runnable;", "getPostQueue", "()Ljava/util/List;", "setPostQueue", "(Ljava/util/List;)V", "getView", "()Landroid/view/View;", "isNeedCompactPost", "onAttachedToWindow", "", "onDetachedFromWindow", "post", "action", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  boolean afUA;
  private List<Runnable> afUz;
  private final View view;
  
  public j(View paramView)
  {
    AppMethodBeat.i(251548);
    this.view = paramView;
    this.afUz = ((List)new ArrayList());
    AppMethodBeat.o(251548);
  }
  
  private static boolean jEX()
  {
    return Build.VERSION.SDK_INT <= 23;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(251555);
    this.afUA = true;
    Iterator localIterator = ((Iterable)this.afUz).iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      this.view.post(localRunnable);
    }
    this.afUz.clear();
    AppMethodBeat.o(251555);
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(251558);
    if ((jEX()) && (!this.afUA))
    {
      this.afUz.add(paramRunnable);
      AppMethodBeat.o(251558);
      return true;
    }
    AppMethodBeat.o(251558);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */