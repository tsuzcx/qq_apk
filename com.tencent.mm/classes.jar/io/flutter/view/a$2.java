package io.flutter.view;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;

final class a$2
  implements AccessibilityManager.AccessibilityStateChangeListener
{
  a$2(a parama) {}
  
  public final void onAccessibilityStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(9797);
    if (paramBoolean)
    {
      a.e(this.Jdb).a(a.d(this.Jdb));
      a.e(this.Jdb).IYd.setSemanticsEnabled(true);
    }
    for (;;)
    {
      if (a.f(this.Jdb) != null) {
        a.f(this.Jdb).aR(paramBoolean, a.g(this.Jdb).isTouchExplorationEnabled());
      }
      AppMethodBeat.o(9797);
      return;
      a.e(this.Jdb).a(null);
      a.e(this.Jdb).IYd.setSemanticsEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.view.a.2
 * JD-Core Version:    0.7.0.1
 */