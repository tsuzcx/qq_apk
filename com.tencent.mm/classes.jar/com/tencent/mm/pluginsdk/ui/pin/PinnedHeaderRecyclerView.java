package com.tencent.mm.pluginsdk.ui.pin;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPinnedHeaderClickListener", "Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderRecyclerView$OnPinnedHeaderClickListener;", "mPinnedHeaderHandle", "", "pinnedHeaderDecoration", "Lcom/tencent/mm/pluginsdk/ui/pin/IPinnedHeaderDecoration;", "getPinnedHeaderDecoration", "()Lcom/tencent/mm/pluginsdk/ui/pin/IPinnedHeaderDecoration;", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "ev", "setOnPinnedHeaderClickListener", "", "listener", "OnPinnedHeaderClickListener", "app_release"})
public final class PinnedHeaderRecyclerView
  extends RecyclerView
{
  private a Rpu;
  private boolean Rpv;
  
  public PinnedHeaderRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(287463);
    AppMethodBeat.o(287463);
  }
  
  public PinnedHeaderRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(287464);
    AppMethodBeat.o(287464);
  }
  
  public final a getPinnedHeaderDecoration()
  {
    AppMethodBeat.i(287462);
    int i = 0;
    Object localObject;
    do
    {
      localObject = cH(i);
      p.j(localObject, "getItemDecorationAt(decorationIndex)");
      if ((localObject instanceof a))
      {
        localObject = (a)localObject;
        AppMethodBeat.o(287462);
        return localObject;
      }
      i += 1;
    } while (localObject != null);
    AppMethodBeat.o(287462);
    return null;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(287457);
    p.k(paramMotionEvent, "e");
    boolean bool;
    if (this.Rpu == null)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(287457);
      return bool;
    }
    a locala = getPinnedHeaderDecoration();
    if (locala == null)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(287457);
      return bool;
    }
    Rect localRect = locala.hmE();
    int i = locala.hmF();
    if ((localRect == null) || (i == -1))
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(287457);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(287457);
      return bool;
    } while (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()));
    AppMethodBeat.o(287457);
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(287460);
    p.k(paramMotionEvent, "ev");
    boolean bool;
    if (this.Rpu == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(287460);
      return bool;
    }
    Object localObject = getPinnedHeaderDecoration();
    if (localObject == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(287460);
      return bool;
    }
    Rect localRect = ((a)localObject).hmE();
    int i = ((a)localObject).hmF();
    if ((localRect == null) || (i == -1))
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(287460);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(287460);
      return bool;
      this.Rpv = false;
      if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        this.Rpv = true;
        AppMethodBeat.o(287460);
        return true;
        if (this.Rpv)
        {
          if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
          {
            localObject = MotionEvent.obtain(paramMotionEvent);
            p.j(localObject, "cancel");
            ((MotionEvent)localObject).setAction(3);
            super.dispatchTouchEvent((MotionEvent)localObject);
            paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
            p.j(paramMotionEvent, "down");
            paramMotionEvent.setAction(0);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(287460);
            return bool;
          }
          AppMethodBeat.o(287460);
          return true;
          float f1 = paramMotionEvent.getX();
          float f2 = paramMotionEvent.getY();
          if ((this.Rpv) && (localRect.contains((int)f1, (int)f2)))
          {
            this.Rpv = false;
            AppMethodBeat.o(287460);
            return true;
          }
          this.Rpv = false;
        }
      }
    }
  }
  
  public final void setOnPinnedHeaderClickListener(a parama)
  {
    this.Rpu = parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderRecyclerView$OnPinnedHeaderClickListener;", "", "onPinnedHeaderClick", "", "adapterPosition", "", "app_release"})
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.pin.PinnedHeaderRecyclerView
 * JD-Core Version:    0.7.0.1
 */