package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/widget/CropOperationContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "editorLayoutIds", "", "isEditorItemFirstTouch", "", "canReceiveEvent", "view", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "dispatchTransformedTouchEvent", "event", "cancel", "child", "setEditorItemFirstTouch", "", "enable", "Companion", "plugin-vlog_release"})
public final class CropOperationContainer
  extends RelativeLayout
{
  public static final CropOperationContainer.a GQh;
  private final Set<Integer> GQf;
  private boolean GQg;
  
  static
  {
    AppMethodBeat.i(192168);
    GQh = new CropOperationContainer.a((byte)0);
    AppMethodBeat.o(192168);
  }
  
  public CropOperationContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192166);
    this.GQf = ak.setOf(new Integer[] { Integer.valueOf(2131309759), Integer.valueOf(2131305913) });
    AppMethodBeat.o(192166);
  }
  
  public CropOperationContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192167);
    this.GQf = ak.setOf(new Integer[] { Integer.valueOf(2131309759), Integer.valueOf(2131305913) });
    AppMethodBeat.o(192167);
  }
  
  private final boolean a(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(192165);
    int i = paramMotionEvent.getAction();
    if (i == 3)
    {
      paramMotionEvent.setAction(3);
      bool = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(i);
      AppMethodBeat.o(192165);
      return bool;
    }
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    p.g(paramMotionEvent, "MotionEvent.obtain(event)");
    paramMotionEvent.offsetLocation(getScrollX() - paramView.getLeft(), getScrollY() - paramView.getTop());
    boolean bool = paramView.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
    AppMethodBeat.o(192165);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192164);
    Log.d("CropOperationContainer", "dispatchTouchEvent: ".concat(String.valueOf(paramMotionEvent)));
    if (!this.GQg)
    {
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(192164);
      return bool1;
    }
    int j = getChildCount() - 1;
    boolean bool1 = false;
    View localView;
    boolean bool2;
    if ((j >= 0) && (!bool1))
    {
      localView = getChildAt(j);
      if ((localView == null) || (paramMotionEvent == null)) {
        i = 0;
      }
      for (;;)
      {
        bool2 = bool1;
        if (i != 0)
        {
          Set localSet = this.GQf;
          p.g(localView, "childView");
          bool2 = bool1;
          if (localSet.contains(Integer.valueOf(localView.getId())))
          {
            if (paramMotionEvent == null) {
              p.hyc();
            }
            bool2 = a(paramMotionEvent, localView);
          }
        }
        j -= 1;
        bool1 = bool2;
        break;
        float f1 = paramMotionEvent.getX() + getScrollX() - localView.getLeft();
        float f2 = paramMotionEvent.getY() + getScrollY() - localView.getTop();
        if ((localView.getVisibility() == 0) && (f1 >= 0.0F) && (f1 < localView.getRight() - localView.getLeft()) && (f2 >= 0.0F) && (f2 < localView.getBottom() - localView.getTop())) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    int i = getChildCount() - 1;
    while ((i >= 0) && (!bool1))
    {
      localView = getChildAt(i);
      bool2 = bool1;
      if (localView != null)
      {
        bool2 = bool1;
        if (paramMotionEvent != null)
        {
          bool2 = bool1;
          if (localView.getVisibility() == 0)
          {
            bool2 = bool1;
            if (!this.GQf.contains(Integer.valueOf(localView.getId()))) {
              bool2 = a(paramMotionEvent, localView);
            }
          }
        }
      }
      i -= 1;
      bool1 = bool2;
    }
    AppMethodBeat.o(192164);
    return bool1;
  }
  
  public final void setEditorItemFirstTouch(boolean paramBoolean)
  {
    this.GQg = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.CropOperationContainer
 * JD-Core Version:    0.7.0.1
 */