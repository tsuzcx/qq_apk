package com.tencent.mm.plugin.profile.ui.tab;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "app_release"})
public final class ContactWidgetTabBizInfo$g
  extends GestureDetector.SimpleOnGestureListener
{
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(292369);
    b localb = new b();
    localb.bn(paramMotionEvent);
    a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(292369);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(292366);
    b localb = new b();
    localb.bn(paramMotionEvent);
    a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    ContactWidgetTabBizInfo.k(this.HgP);
    a.a(true, this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(292366);
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(292368);
    b localb = new b();
    localb.bn(paramMotionEvent);
    a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    super.onLongPress(paramMotionEvent);
    a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(292368);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(292367);
    b localb = new b();
    localb.bn(paramMotionEvent);
    a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizInfo$initActionBar$detector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(292367);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizInfo.g
 * JD-Core Version:    0.7.0.1
 */