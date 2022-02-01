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
      a.e(this.NeB).a(a.d(this.NeB));
      a.e(this.NeB).MZl.setSemanticsEnabled(true);
    }
    for (;;)
    {
      if (a.f(this.NeB) != null) {
        a.f(this.NeB).bc(paramBoolean, a.g(this.NeB).isTouchExplorationEnabled());
      }
      AppMethodBeat.o(9797);
      return;
      a.e(this.NeB).a(null);
      a.e(this.NeB).MZl.setSemanticsEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.view.a.2
 * JD-Core Version:    0.7.0.1
 */