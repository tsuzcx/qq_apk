package com.tencent.mm.plugin.nearlife.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseLifeUI$5$1
  implements View.OnTouchListener
{
  BaseLifeUI$5$1(BaseLifeUI.5 param5) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(26564);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$5$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    this.wGA.wGz.hideVKB();
    a.a(false, this, "com/tencent/mm/plugin/nearlife/ui/BaseLifeUI$5$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(26564);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.5.1
 * JD-Core Version:    0.7.0.1
 */