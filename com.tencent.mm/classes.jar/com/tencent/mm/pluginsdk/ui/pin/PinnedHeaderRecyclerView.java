package com.tencent.mm.pluginsdk.ui.pin;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPinnedHeaderClickListener", "Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderRecyclerView$OnPinnedHeaderClickListener;", "mPinnedHeaderHandle", "", "pinnedHeaderDecoration", "Lcom/tencent/mm/pluginsdk/ui/pin/IPinnedHeaderDecoration;", "getPinnedHeaderDecoration", "()Lcom/tencent/mm/pluginsdk/ui/pin/IPinnedHeaderDecoration;", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "ev", "setOnPinnedHeaderClickListener", "", "listener", "OnPinnedHeaderClickListener", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PinnedHeaderRecyclerView
  extends RecyclerView
{
  private PinnedHeaderRecyclerView.a YlK;
  private boolean YlL;
  
  public PinnedHeaderRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(245088);
    AppMethodBeat.o(245088);
  }
  
  public PinnedHeaderRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(245089);
    AppMethodBeat.o(245089);
  }
  
  public final a getPinnedHeaderDecoration()
  {
    AppMethodBeat.i(245094);
    int i = 0;
    for (;;)
    {
      Object localObject = fR(i);
      s.s(localObject, "getItemDecorationAt(decorationIndex)");
      if ((localObject instanceof a))
      {
        localObject = (a)localObject;
        AppMethodBeat.o(245094);
        return localObject;
      }
      i += 1;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(245092);
    s.u(paramMotionEvent, "e");
    if (this.YlK == null)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(245092);
      return bool;
    }
    a locala = getPinnedHeaderDecoration();
    if (locala == null)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(245092);
      return bool;
    }
    Rect localRect = locala.iNu();
    int i = locala.iNv();
    if ((localRect == null) || (i == -1))
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(245092);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 0) && (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
    {
      AppMethodBeat.o(245092);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(245092);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(245093);
    s.u(paramMotionEvent, "ev");
    boolean bool;
    if (this.YlK == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(245093);
      return bool;
    }
    Object localObject = getPinnedHeaderDecoration();
    if (localObject == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(245093);
      return bool;
    }
    Rect localRect = ((a)localObject).iNu();
    int i = ((a)localObject).iNv();
    if ((localRect == null) || (i == -1))
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(245093);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(245093);
      return bool;
      this.YlL = false;
      if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        this.YlL = true;
        AppMethodBeat.o(245093);
        return true;
        if (this.YlL)
        {
          if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
          {
            localObject = MotionEvent.obtain(paramMotionEvent);
            ((MotionEvent)localObject).setAction(3);
            super.dispatchTouchEvent((MotionEvent)localObject);
            paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
            paramMotionEvent.setAction(0);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(245093);
            return bool;
          }
          AppMethodBeat.o(245093);
          return true;
          float f1 = paramMotionEvent.getX();
          float f2 = paramMotionEvent.getY();
          if ((this.YlL) && (localRect.contains((int)f1, (int)f2)))
          {
            this.YlL = false;
            AppMethodBeat.o(245093);
            return true;
          }
          this.YlL = false;
        }
      }
    }
  }
  
  public final void setOnPinnedHeaderClickListener(PinnedHeaderRecyclerView.a parama)
  {
    this.YlK = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.pin.PinnedHeaderRecyclerView
 * JD-Core Version:    0.7.0.1
 */