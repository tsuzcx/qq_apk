package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsMsgUI$16
  implements View.OnTouchListener
{
  SnsMsgUI$16(SnsMsgUI paramSnsMsgUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219910);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/sns/ui/SnsMsgUI$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(219910);
      return false;
      this.AwR.hideVKB();
      SnsMsgUI.i(this.AwR)[0] = ((int)paramMotionEvent.getRawX());
      SnsMsgUI.i(this.AwR)[1] = ((int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.16
 * JD-Core Version:    0.7.0.1
 */