package com.tencent.mm.plugin.multitask.a;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter$createSwipeBackListener$1", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "canInterceptTouch", "", "enableSwipeBack", "getSwipeBackTouchState", "", "onDispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onEdgeDragStarted", "edgeFlags", "pointerId", "onPositionChange", "left", "top", "dx", "dy", "scrollPercent", "", "onViewReleased", "willSwipeBack", "shouldInterceptTouchEvent", "plugin-multitask_release"})
public final class b$c
  implements SwipeBackLayout.b
{
  public final void XV(int paramInt)
  {
    AppMethodBeat.i(247860);
    a.a locala = this.FFy.FFv;
    if (locala != null)
    {
      locala.XV(paramInt);
      AppMethodBeat.o(247860);
      return;
    }
    AppMethodBeat.o(247860);
  }
  
  public final void bz(float paramFloat)
  {
    AppMethodBeat.i(247847);
    if (this.FFy.FFv != null)
    {
      a.a locala = this.FFy.FFv;
      if (locala != null)
      {
        locala.by(paramFloat);
        AppMethodBeat.o(247847);
        return;
      }
    }
    AppMethodBeat.o(247847);
  }
  
  public final int cc(boolean paramBoolean)
  {
    AppMethodBeat.i(247850);
    if (this.FFy.FFv != null)
    {
      a.a locala = this.FFy.FFv;
      if (locala != null)
      {
        int i = locala.vm(paramBoolean);
        AppMethodBeat.o(247850);
        return i;
      }
    }
    AppMethodBeat.o(247850);
    return 1;
  }
  
  public final int fau()
  {
    AppMethodBeat.i(247856);
    a.a locala = this.FFy.FFv;
    if (locala != null)
    {
      int i = locala.fau();
      AppMethodBeat.o(247856);
      return i;
    }
    AppMethodBeat.o(247856);
    return 0;
  }
  
  public final boolean fav()
  {
    AppMethodBeat.i(247861);
    a.a locala = this.FFy.FFv;
    if (locala != null)
    {
      boolean bool = locala.fav();
      AppMethodBeat.o(247861);
      return bool;
    }
    AppMethodBeat.o(247861);
    return false;
  }
  
  public final boolean fay()
  {
    AppMethodBeat.i(247852);
    if (this.FFy.FFv != null)
    {
      a.a locala = this.FFy.FFv;
      if (locala != null)
      {
        boolean bool = locala.fat();
        AppMethodBeat.o(247852);
        return bool;
      }
    }
    AppMethodBeat.o(247852);
    return false;
  }
  
  public final boolean i(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247854);
    p.k(paramMotionEvent, "ev");
    if (this.FFy.FFv != null)
    {
      a.a locala = this.FFy.FFv;
      if (locala != null)
      {
        boolean bool = locala.i(paramMotionEvent);
        AppMethodBeat.o(247854);
        return bool;
      }
    }
    AppMethodBeat.o(247854);
    return false;
  }
  
  public final void n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247849);
    p.k(paramMotionEvent, "ev");
    if (this.FFy.FFv != null)
    {
      a.a locala = this.FFy.FFv;
      if (locala != null)
      {
        locala.n(paramMotionEvent);
        AppMethodBeat.o(247849);
        return;
      }
    }
    AppMethodBeat.o(247849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.a.b.c
 * JD-Core Version:    0.7.0.1
 */