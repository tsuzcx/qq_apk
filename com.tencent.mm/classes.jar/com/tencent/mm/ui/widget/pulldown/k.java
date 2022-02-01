package com.tencent.mm.ui.widget.pulldown;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/SimpleOverScrollCallback;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScrollCallback;", "()V", "mMinFlingVelocity", "", "canScroll", "", "overScroll", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "child", "Landroid/view/View;", "scrollDirection", "getDampingFactor", "", "getMaxFlingOffset", "getMinFlingVelocity", "onOffsetChanged", "", "offset", "onSpringBack", "onStopSpringingBack", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private int wV;
  
  public static int a(h paramh, View paramView, int paramInt)
  {
    AppMethodBeat.i(251947);
    s.u(paramh, "overScroll");
    s.u(paramView, "child");
    switch (paramInt)
    {
    default: 
      paramInt = -paramView.getHeight() / 10;
      AppMethodBeat.o(251947);
      return paramInt;
    }
    paramInt = paramView.getHeight() / 10;
    AppMethodBeat.o(251947);
    return paramInt;
  }
  
  public static boolean a(h paramh, View paramView)
  {
    AppMethodBeat.i(251960);
    s.u(paramh, "overScroll");
    s.u(paramView, "child");
    AppMethodBeat.o(251960);
    return false;
  }
  
  public static boolean b(h paramh, View paramView)
  {
    AppMethodBeat.i(251938);
    s.u(paramh, "overScroll");
    s.u(paramView, "child");
    AppMethodBeat.o(251938);
    return true;
  }
  
  public static float c(h paramh, View paramView)
  {
    AppMethodBeat.i(251954);
    s.u(paramh, "overScroll");
    s.u(paramView, "child");
    float f1 = Math.abs(paramh.cI(paramView)) * 1.0F / paramView.getHeight();
    paramh = j.aglL;
    float f2 = j.jIT();
    paramh = j.aglL;
    int i = j.jIU();
    paramh = j.aglL;
    float f3 = i - j.jIT();
    AppMethodBeat.o(251954);
    return f1 * f3 + f2;
  }
  
  public static void e(h paramh, View paramView)
  {
    AppMethodBeat.i(251967);
    s.u(paramh, "overScroll");
    s.u(paramView, "child");
    AppMethodBeat.o(251967);
  }
  
  public final int d(h paramh, View paramView)
  {
    AppMethodBeat.i(251974);
    s.u(paramh, "overScroll");
    s.u(paramView, "child");
    if (this.wV <= 0) {
      this.wV = (ViewConfiguration.get(paramView.getContext()).getScaledMinimumFlingVelocity() * 15);
    }
    int i = this.wV;
    AppMethodBeat.o(251974);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.k
 * JD-Core Version:    0.7.0.1
 */