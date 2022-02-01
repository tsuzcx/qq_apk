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
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/widget/CropOperationContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "editorLayoutIds", "", "isEditorItemFirstTouch", "", "canReceiveEvent", "view", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "dispatchTransformedTouchEvent", "event", "cancel", "child", "setEditorItemFirstTouch", "", "enable", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CropOperationContainer
  extends RelativeLayout
{
  public static final CropOperationContainer.a Usc;
  private final Set<Integer> Usd;
  private boolean Use;
  
  static
  {
    AppMethodBeat.i(281767);
    Usc = new CropOperationContainer.a((byte)0);
    AppMethodBeat.o(281767);
  }
  
  public CropOperationContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281742);
    this.Usd = ar.setOf(new Integer[] { Integer.valueOf(a.f.video_editor_item_container), Integer.valueOf(a.f.photo_editor_item_container) });
    AppMethodBeat.o(281742);
  }
  
  public CropOperationContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281749);
    this.Usd = ar.setOf(new Integer[] { Integer.valueOf(a.f.video_editor_item_container), Integer.valueOf(a.f.photo_editor_item_container) });
    AppMethodBeat.o(281749);
  }
  
  private final boolean a(MotionEvent paramMotionEvent, View paramView)
  {
    AppMethodBeat.i(281761);
    int i = paramMotionEvent.getAction();
    if (i == 3)
    {
      paramMotionEvent.setAction(3);
      bool = paramView.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.setAction(i);
      AppMethodBeat.o(281761);
      return bool;
    }
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    s.s(paramMotionEvent, "obtain(event)");
    paramMotionEvent.offsetLocation(getScrollX() - paramView.getLeft(), getScrollY() - paramView.getTop());
    boolean bool = paramView.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
    AppMethodBeat.o(281761);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(281783);
    Log.d("CropOperationContainer", s.X("dispatchTouchEvent: ", paramMotionEvent));
    if (!this.Use)
    {
      bool1 = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(281783);
      return bool1;
    }
    int i = getChildCount() - 1;
    if (i >= 0) {}
    boolean bool2;
    for (bool1 = false;; bool1 = bool2)
    {
      int j = i - 1;
      bool2 = bool1;
      View localView;
      if (!bool1)
      {
        localView = getChildAt(i);
        if ((localView == null) || (paramMotionEvent == null))
        {
          i = 0;
          bool2 = bool1;
          if (i != 0)
          {
            bool2 = bool1;
            if (this.Usd.contains(Integer.valueOf(localView.getId())))
            {
              s.checkNotNull(paramMotionEvent);
              s.s(localView, "childView");
              bool2 = a(paramMotionEvent, localView);
            }
          }
          if (j >= 0) {
            break label382;
          }
        }
      }
      else
      {
        bool1 = bool2;
        i = getChildCount() - 1;
        bool2 = bool1;
        if (i < 0) {}
      }
      for (;;)
      {
        j = i - 1;
        bool2 = bool1;
        if (!bool1)
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
                if (!this.Usd.contains(Integer.valueOf(localView.getId()))) {
                  bool2 = a(paramMotionEvent, localView);
                }
              }
            }
          }
          if (j >= 0) {}
        }
        else
        {
          AppMethodBeat.o(281783);
          return bool2;
          float f1 = paramMotionEvent.getX() + getScrollX() - localView.getLeft();
          float f2 = paramMotionEvent.getY() + getScrollY() - localView.getTop();
          if ((localView.getVisibility() == 0) && (f1 >= 0.0F) && (f1 < localView.getRight() - localView.getLeft()) && (f2 >= 0.0F) && (f2 < localView.getBottom() - localView.getTop()))
          {
            i = 1;
            break;
          }
          i = 0;
          break;
        }
        i = j;
        bool1 = bool2;
      }
      label382:
      i = j;
    }
  }
  
  public final void setEditorItemFirstTouch(boolean paramBoolean)
  {
    this.Use = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.CropOperationContainer
 * JD-Core Version:    0.7.0.1
 */