package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class ah
{
  private static ah JYJ;
  Object JYI;
  
  public static ah fGf()
  {
    try
    {
      AppMethodBeat.i(34839);
      if (JYJ == null) {
        JYJ = new ah();
      }
      ah localah = JYJ;
      AppMethodBeat.o(34839);
      return localah;
    }
    finally {}
  }
  
  @TargetApi(14)
  public static final class a
    implements View.OnHoverListener
  {
    private ah.b JYK;
    
    public a(ah.b paramb)
    {
      this.JYK = paramb;
    }
    
    public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34838);
      b localb = new b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
      if (this.JYK != null)
      {
        boolean bool = this.JYK.f(paramView, paramMotionEvent);
        a.a(bool, this, "com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(34838);
        return bool;
      }
      a.a(false, this, "com/tencent/mm/ui/chatting/OnHoverCompatibleHelper$CompatibleOnHoverListener", "android/view/View$OnHoverListener", "onHover", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(34838);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean f(View paramView, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ah
 * JD-Core Version:    0.7.0.1
 */