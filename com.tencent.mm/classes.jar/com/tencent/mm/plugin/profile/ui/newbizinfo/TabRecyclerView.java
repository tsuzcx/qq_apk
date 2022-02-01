package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/TabRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "app_release"})
public class TabRecyclerView
  extends RecyclerView
{
  public TabRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(39625);
    AppMethodBeat.o(39625);
  }
  
  public TabRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39626);
    AppMethodBeat.o(39626);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39624);
    k.h(paramMotionEvent, "ev");
    paramMotionEvent = new int[2];
    getLocationInWindow(paramMotionEvent);
    if (paramMotionEvent[0] < 30)
    {
      AppMethodBeat.o(39624);
      return true;
    }
    AppMethodBeat.o(39624);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.TabRecyclerView
 * JD-Core Version:    0.7.0.1
 */