package io.flutter.plugin.platform;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements View.OnAttachStateChangeListener
{
  h$1(h paramh, View paramView, Runnable paramRunnable) {}
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(9892);
    h.a.h(this.STL, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9932);
        h.1.this.STL.postDelayed(h.1.this.STM, 128L);
        AppMethodBeat.o(9932);
      }
    });
    this.STL.removeOnAttachStateChangeListener(this);
    AppMethodBeat.o(9892);
  }
  
  public final void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.plugin.platform.h.1
 * JD-Core Version:    0.7.0.1
 */