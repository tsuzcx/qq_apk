package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/widget/CropOperationContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "editorLayoutIds", "", "isEditorItemFirstTouch", "", "canReceiveEvent", "view", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "dispatchTransformedTouchEvent", "event", "cancel", "child", "setEditorItemFirstTouch", "", "enable", "Companion", "plugin-vlog_release"})
public final class CropOperationContainer
  extends RelativeLayout
{
  public static final a NFY;
  private final Set<Integer> NFW;
  private boolean NFX;
  
  static
  {
    AppMethodBeat.i(226288);
    NFY = new a((byte)0);
    AppMethodBeat.o(226288);
  }
  
  public CropOperationContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(226285);
    this.NFW = ak.setOf(new Integer[] { Integer.valueOf(a.f.video_editor_item_container), Integer.valueOf(a.f.photo_editor_item_container) });
    AppMethodBeat.o(226285);
  }
  
  public CropOperationContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(226287);
    this.NFW = ak.setOf(new Integer[] { Integer.valueOf(a.f.video_editor_item_container), Integer.valueOf(a.f.photo_editor_item_container) });
    AppMethodBeat.o(226287);
  }
  
  private final boolean a(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(226283);
    int i = paramMotionEvent.getAction();
    if (i == 3)
    {
      paramMotionEvent.setAction(3);
      bool = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(i);
      AppMethodBeat.o(226283);
      return bool;
    }
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    p.j(paramMotionEvent, "MotionEvent.obtain(event)");
    paramMotionEvent.offsetLocation(getScrollX() - paramView.getLeft(), getScrollY() - paramView.getTop());
    boolean bool = paramView.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
    AppMethodBeat.o(226283);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(226281);
    Log.d("CropOperationContainer", "dispatchTouchEvent: ".concat(String.valueOf(paramMotionEvent)));
    if (!this.NFX)
    {
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(226281);
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
          Set localSet = this.NFW;
          p.j(localView, "childView");
          bool2 = bool1;
          if (localSet.contains(Integer.valueOf(localView.getId())))
          {
            if (paramMotionEvent == null) {
              p.iCn();
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
            if (!this.NFW.contains(Integer.valueOf(localView.getId()))) {
              bool2 = a(paramMotionEvent, localView);
            }
          }
        }
      }
      i -= 1;
      bool1 = bool2;
    }
    AppMethodBeat.o(226281);
    return bool1;
  }
  
  public final void setEditorItemFirstTouch(boolean paramBoolean)
  {
    this.NFX = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/widget/CropOperationContainer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.CropOperationContainer
 * JD-Core Version:    0.7.0.1
 */