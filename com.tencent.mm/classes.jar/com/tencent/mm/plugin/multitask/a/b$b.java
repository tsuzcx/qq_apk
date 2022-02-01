package com.tencent.mm.plugin.multitask.a;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.SwipeBackLayout.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter$createSwipeBackListener$1", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "canInterceptTouch", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "left", "top", "dx", "dy", "scrollPercent", "", "onViewReleased", "willSwipeBack", "shouldInterceptTouchEvent", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
  implements SwipeBackLayout.c
{
  b$b(b paramb) {}
  
  public final void aG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(303811);
    a.a locala = this.LBx.LBv;
    if (locala != null) {
      locala.aci(paramInt1);
    }
    AppMethodBeat.o(303811);
  }
  
  public final void cD(float paramFloat)
  {
    AppMethodBeat.i(303774);
    if (this.LBx.LBv != null)
    {
      a.a locala = this.LBx.LBv;
      if (locala != null) {
        locala.cC(paramFloat);
      }
    }
    AppMethodBeat.o(303774);
  }
  
  public final int cI(boolean paramBoolean)
  {
    AppMethodBeat.i(303783);
    if (this.LBx.LBv != null)
    {
      a.a locala = this.LBx.LBv;
      if (locala != null)
      {
        int i = locala.zE(paramBoolean);
        AppMethodBeat.o(303783);
        return i;
      }
    }
    AppMethodBeat.o(303783);
    return 1;
  }
  
  public final boolean gjA()
  {
    AppMethodBeat.i(303819);
    a.a locala = this.LBx.LBv;
    if (locala == null)
    {
      AppMethodBeat.o(303819);
      return false;
    }
    boolean bool = locala.gjA();
    AppMethodBeat.o(303819);
    return bool;
  }
  
  public final boolean gjD()
  {
    AppMethodBeat.i(303790);
    if (this.LBx.LBv != null)
    {
      a.a locala = this.LBx.LBv;
      if (locala != null)
      {
        boolean bool = locala.gjy();
        AppMethodBeat.o(303790);
        return bool;
      }
    }
    AppMethodBeat.o(303790);
    return false;
  }
  
  public final int gjz()
  {
    AppMethodBeat.i(303803);
    a.a locala = this.LBx.LBv;
    if (locala == null)
    {
      AppMethodBeat.o(303803);
      return 0;
    }
    int i = locala.gjz();
    AppMethodBeat.o(303803);
    return i;
  }
  
  public final boolean i(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(303796);
    s.u(paramMotionEvent, "ev");
    if (this.LBx.LBv != null)
    {
      a.a locala = this.LBx.LBv;
      if (locala != null)
      {
        boolean bool = locala.i(paramMotionEvent);
        AppMethodBeat.o(303796);
        return bool;
      }
    }
    AppMethodBeat.o(303796);
    return false;
  }
  
  public final void n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(303777);
    s.u(paramMotionEvent, "ev");
    if (this.LBx.LBv != null)
    {
      a.a locala = this.LBx.LBv;
      if (locala != null) {
        locala.n(paramMotionEvent);
      }
    }
    AppMethodBeat.o(303777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.a.b.b
 * JD-Core Version:    0.7.0.1
 */