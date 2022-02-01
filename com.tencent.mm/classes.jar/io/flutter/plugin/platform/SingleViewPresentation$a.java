package io.flutter.plugin.platform;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.AccessibilityViewEmbedder;

final class SingleViewPresentation$a
  extends FrameLayout
{
  private final View NdT;
  private final a accessibilityEventsDelegate;
  
  public SingleViewPresentation$a(Context paramContext, a parama, View paramView)
  {
    super(paramContext);
    this.accessibilityEventsDelegate = parama;
    this.NdT = paramView;
  }
  
  public final boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9888);
    Object localObject = this.accessibilityEventsDelegate;
    View localView = this.NdT;
    if (((a)localObject).MYV == null)
    {
      AppMethodBeat.o(9888);
      return false;
    }
    localObject = ((a)localObject).MYV;
    if (!((io.flutter.view.a)localObject).Nej.requestSendAccessibilityEvent(localView, paramView, paramAccessibilityEvent))
    {
      AppMethodBeat.o(9888);
      return false;
    }
    paramView = ((io.flutter.view.a)localObject).Nej.getRecordFlutterId(localView, paramAccessibilityEvent);
    if (paramView == null)
    {
      AppMethodBeat.o(9888);
      return false;
    }
    switch (paramAccessibilityEvent.getEventType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9888);
      return true;
      ((io.flutter.view.a)localObject).Net = null;
      continue;
      ((io.flutter.view.a)localObject).Neo = paramView;
      ((io.flutter.view.a)localObject).Nen = null;
      continue;
      ((io.flutter.view.a)localObject).Nep = null;
      ((io.flutter.view.a)localObject).Neo = null;
      continue;
      ((io.flutter.view.a)localObject).Nep = paramView;
      ((io.flutter.view.a)localObject).Ner = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.a
 * JD-Core Version:    0.7.0.1
 */