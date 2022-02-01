package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(16)
final class i$a
  implements ViewTreeObserver.OnDrawListener
{
  Runnable KQd;
  final View mView;
  
  private i$a(View paramView, Runnable paramRunnable)
  {
    this.mView = paramView;
    this.KQd = paramRunnable;
  }
  
  static void f(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(9890);
    paramRunnable = new a(paramView, paramRunnable);
    paramView.getViewTreeObserver().addOnDrawListener(paramRunnable);
    AppMethodBeat.o(9890);
  }
  
  public final void onDraw()
  {
    AppMethodBeat.i(9891);
    if (this.KQd == null)
    {
      AppMethodBeat.o(9891);
      return;
    }
    this.KQd.run();
    this.KQd = null;
    this.mView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9887);
        i.a.this.mView.getViewTreeObserver().removeOnDrawListener(i.a.this);
        AppMethodBeat.o(9887);
      }
    });
    AppMethodBeat.o(9891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.plugin.platform.i.a
 * JD-Core Version:    0.7.0.1
 */