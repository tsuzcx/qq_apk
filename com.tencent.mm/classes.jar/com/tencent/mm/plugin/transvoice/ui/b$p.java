package com.tencent.mm.plugin.transvoice.ui;

import a.f.b.j;
import a.l;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.MMBottomSheetBehavior.b;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$ExternalTouchHelper;", "downY", "", "getDownY", "()F", "setDownY", "(F)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onNeedJudge", "plugin-transvoice_release"})
public final class b$p
  implements MMBottomSheetBehavior.b
{
  private float bTF;
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(156326);
    j.q(paramMotionEvent, "event");
    j.q(paramMotionEvent, "event");
    Object localObject = b.n(this.tqJ);
    int i;
    if (localObject != null)
    {
      MMEditText localMMEditText = b.e(this.tqJ);
      if (localMMEditText == null) {
        j.ebi();
      }
      if (true == ((CoordinatorLayout)localObject).d((View)localMMEditText, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
      {
        i = 1;
        if (i != 0)
        {
          localObject = b.e(this.tqJ);
          if (localObject == null) {
            break label268;
          }
          localObject = Boolean.valueOf(((MMEditText)localObject).canScrollVertically(-1));
          label106:
          localMMEditText = b.e(this.tqJ);
          if (localMMEditText != null) {
            localBoolean = Boolean.valueOf(localMMEditText.canScrollVertically(1));
          }
          ab.d("MicroMsg.TransVoiceDialog", "can scroll up, %s.", new Object[] { localObject });
          ab.d("MicroMsg.TransVoiceDialog", "can scroll down, %s.", new Object[] { localBoolean });
          ab.d("MicroMsg.TransVoiceDialog", "action: %d, x: %f, y: %f, rawX: %f, rawY: %f.", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()) });
          switch (paramMotionEvent.getAction())
          {
          }
        }
      }
    }
    label268:
    float f;
    do
    {
      for (;;)
      {
        AppMethodBeat.o(156326);
        return false;
        i = 0;
        break;
        localObject = null;
        break label106;
        this.bTF = paramMotionEvent.getY();
      }
      f = paramMotionEvent.getY() - this.bTF;
      ab.d("MicroMsg.TransVoiceDialog", "yOffset: %f.", new Object[] { Float.valueOf(f) });
      if (f > 0.0F)
      {
        bool = j.e(Boolean.TRUE, localObject);
        AppMethodBeat.o(156326);
        return bool;
      }
    } while (f >= 0.0F);
    boolean bool = j.e(Boolean.TRUE, localBoolean);
    AppMethodBeat.o(156326);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.p
 * JD-Core Version:    0.7.0.1
 */