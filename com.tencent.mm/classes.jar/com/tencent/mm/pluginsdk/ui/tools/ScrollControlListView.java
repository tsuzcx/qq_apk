package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/ScrollControlListView;", "Landroid/widget/ListView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "hasControlMoveDown", "", "getHasControlMoveDown", "()Z", "setHasControlMoveDown", "(Z)V", "lastFirstVisiblePos", "", "getLastFirstVisiblePos", "()I", "setLastFirstVisiblePos", "(I)V", "mExtraScrollDistance", "mFirstY", "", "getMFirstY", "()F", "setMFirstY", "(F)V", "getExtraScrollDistance", "getExtraScrollTime", "position", "onScrollChanged", "", "l", "t", "oldl", "oldt", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "setExtraScrollDistance", "distance", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ScrollControlListView
  extends ListView
{
  public static final a Yub;
  private boolean Yuc;
  private float Yud;
  private int Yue;
  private int Yuf;
  
  static
  {
    AppMethodBeat.i(245584);
    Yub = new a((byte)0);
    AppMethodBeat.o(245584);
  }
  
  public ScrollControlListView(Context paramContext, byte paramByte)
  {
    this(paramContext);
    AppMethodBeat.i(245581);
    AppMethodBeat.o(245581);
  }
  
  public ScrollControlListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(245578);
    AppMethodBeat.o(245578);
  }
  
  public int axj(int paramInt)
  {
    return 0;
  }
  
  public int getExtraScrollDistance()
  {
    return this.Yuf;
  }
  
  public final boolean getHasControlMoveDown()
  {
    return this.Yuc;
  }
  
  public final int getLastFirstVisiblePos()
  {
    return this.Yue;
  }
  
  public final float getMFirstY()
  {
    return this.Yud;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(245596);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Yue > getFirstVisiblePosition()) {
      this.Yuc = true;
    }
    this.Yue = getFirstVisiblePosition();
    AppMethodBeat.o(245596);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(245599);
    s.u(paramMotionEvent, "ev");
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(245599);
      return bool;
      this.Yud = paramMotionEvent.getY();
      continue;
      if (paramMotionEvent.getY() - this.Yud > 0.0F) {
        this.Yuc = true;
      }
    }
  }
  
  public void setExtraScrollDistance(int paramInt)
  {
    this.Yuf = paramInt;
  }
  
  public final void setHasControlMoveDown(boolean paramBoolean)
  {
    this.Yuc = paramBoolean;
  }
  
  public final void setLastFirstVisiblePos(int paramInt)
  {
    this.Yue = paramInt;
  }
  
  public final void setMFirstY(float paramFloat)
  {
    this.Yud = paramFloat;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/ScrollControlListView$Companion;", "", "()V", "TAG", "", "getLastBottomGap", "", "listView", "Landroid/widget/ListView;", "hasControlMoveDown", "", "isChatListAtBottom", "resetHasControlMoveDown", "", "setHasControlMoveDown", "result", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean c(ListView paramListView)
    {
      AppMethodBeat.i(245612);
      if (paramListView == null)
      {
        AppMethodBeat.o(245612);
        return false;
      }
      if (q.e(paramListView) == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        s.u(paramListView, "listView");
        if ((paramListView instanceof ScrollControlListView)) {
          ((ScrollControlListView)paramListView).setHasControlMoveDown(false);
        }
        AppMethodBeat.o(245612);
        return true;
      }
      if ((paramListView instanceof ScrollControlListView)) {}
      for (boolean bool = ((ScrollControlListView)paramListView).getHasControlMoveDown(); !bool; bool = false)
      {
        AppMethodBeat.o(245612);
        return true;
      }
      AppMethodBeat.o(245612);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.ScrollControlListView
 * JD-Core Version:    0.7.0.1
 */