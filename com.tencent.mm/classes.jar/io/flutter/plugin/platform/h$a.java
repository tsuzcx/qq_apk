package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(16)
final class h$a
  implements ViewTreeObserver.OnDrawListener
{
  Runnable STP;
  final View mView;
  
  private h$a(View paramView, Runnable paramRunnable)
  {
    this.mView = paramView;
    this.STP = paramRunnable;
  }
  
  static void h(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(9890);
    paramRunnable = new a(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnDrawListener(paramRunnable);
    AppMethodBeat.o(9890);
  }
  
  public final void onDraw()
  {
    AppMethodBeat.i(9891);
    if (this.STP == null)
    {
      AppMethodBeat.o(9891);
      return;
    }
    this.STP.run();
    this.STP = null;
    this.mView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9887);
        h.a.this.mView.getViewTreeObserver().removeOnDrawListener(h.a.this);
        AppMethodBeat.o(9887);
      }
    });
    AppMethodBeat.o(9891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.plugin.platform.h.a
 * JD-Core Version:    0.7.0.1
 */