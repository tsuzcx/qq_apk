package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class ak$a
  implements View.OnHoverListener
{
  private ak.b aelf;
  
  public ak$a(ak.b paramb)
  {
    this.aelf = paramb;
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34838);
    b localb = new b();
    localb.cH(paramView);
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.aYj());
    if (this.aelf != null)
    {
      boolean bool = this.aelf.p(paramView, paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(34838);
      return bool;
    }
    a.a(false, this, "com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(34838);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ak.a
 * JD-Core Version:    0.7.0.1
 */