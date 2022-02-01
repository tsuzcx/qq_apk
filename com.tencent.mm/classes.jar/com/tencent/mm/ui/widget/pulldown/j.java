package com.tencent.mm.ui.widget.pulldown;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/SimpleOverScrollCallback;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScrollCallback;", "()V", "mMinFlingVelocity", "", "canScroll", "", "overScroll", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "child", "Landroid/view/View;", "scrollDirection", "getDampingFactor", "", "getMaxFlingOffset", "getMinFlingVelocity", "onOffsetChanged", "", "offset", "onSpringBack", "onStopSpringingBack", "weui-native-android-lib_release"})
public final class j
{
  private int vZ;
  
  public static boolean a(f paramf, View paramView)
  {
    AppMethodBeat.i(249584);
    p.k(paramf, "overScroll");
    p.k(paramView, "child");
    AppMethodBeat.o(249584);
    return false;
  }
  
  public static int b(f paramf, View paramView, int paramInt)
  {
    AppMethodBeat.i(249581);
    p.k(paramf, "overScroll");
    p.k(paramView, "child");
    if ((paramInt == 2) || (paramInt == 8))
    {
      paramInt = paramView.getHeight() / 10;
      AppMethodBeat.o(249581);
      return paramInt;
    }
    paramInt = -paramView.getHeight() / 10;
    AppMethodBeat.o(249581);
    return paramInt;
  }
  
  public static boolean b(f paramf, View paramView)
  {
    AppMethodBeat.i(249580);
    p.k(paramf, "overScroll");
    p.k(paramView, "child");
    AppMethodBeat.o(249580);
    return true;
  }
  
  public static void d(f paramf, View paramView)
  {
    AppMethodBeat.i(249585);
    p.k(paramf, "overScroll");
    p.k(paramView, "child");
    AppMethodBeat.o(249585);
  }
  
  public static float e(f paramf, View paramView)
  {
    AppMethodBeat.i(292982);
    p.k(paramf, "overScroll");
    p.k(paramView, "child");
    float f1 = Math.abs(paramf.cm(paramView)) * 1.0F / paramView.getHeight();
    paramf = i.YtH;
    float f2 = i.idL();
    paramf = i.YtH;
    int i = i.idM();
    paramf = i.YtH;
    float f3 = i - i.idL();
    AppMethodBeat.o(292982);
    return f1 * f3 + f2;
  }
  
  public final int c(f paramf, View paramView)
  {
    AppMethodBeat.i(249583);
    p.k(paramf, "overScroll");
    p.k(paramView, "child");
    if (this.vZ <= 0)
    {
      paramf = ViewConfiguration.get(paramView.getContext());
      p.j(paramf, "ViewConfiguration.get(child.context)");
      this.vZ = (paramf.getScaledMinimumFlingVelocity() * 15);
    }
    int i = this.vZ;
    AppMethodBeat.o(249583);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.j
 * JD-Core Version:    0.7.0.1
 */