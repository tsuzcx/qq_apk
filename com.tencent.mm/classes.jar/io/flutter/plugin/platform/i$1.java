package io.flutter.plugin.platform;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$1
  implements View.OnAttachStateChangeListener
{
  i$1(i parami, View paramView, Runnable paramRunnable) {}
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(9892);
    i.a.g(this.MGY, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9932);
        i.1.this.MGY.postDelayed(i.1.this.MGZ, 128L);
        AppMethodBeat.o(9932);
      }
    });
    this.MGY.removeOnAttachStateChangeListener(this);
    AppMethodBeat.o(9892);
  }
  
  public final void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.i.1
 * JD-Core Version:    0.7.0.1
 */