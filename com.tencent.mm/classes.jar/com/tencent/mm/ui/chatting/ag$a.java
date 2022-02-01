package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

@TargetApi(14)
public final class ag$a
  implements View.OnHoverListener
{
  private ag.b JDT;
  
  public ag$a(ag.b paramb)
  {
    this.JDT = paramb;
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34838);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (this.JDT != null)
    {
      boolean bool = this.JDT.f(paramView, paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(34838);
      return bool;
    }
    a.a(false, this, "com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(34838);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ag.a
 * JD-Core Version:    0.7.0.1
 */