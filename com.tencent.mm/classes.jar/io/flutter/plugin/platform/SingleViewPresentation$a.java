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
  private final View MGP;
  private final a accessibilityEventsDelegate;
  
  public SingleViewPresentation$a(Context paramContext, a parama, View paramView)
  {
    super(paramContext);
    this.accessibilityEventsDelegate = parama;
    this.MGP = paramView;
  }
  
  public final boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9888);
    Object localObject = this.accessibilityEventsDelegate;
    View localView = this.MGP;
    if (((a)localObject).MBQ == null)
    {
      AppMethodBeat.o(9888);
      return false;
    }
    localObject = ((a)localObject).MBQ;
    if (!((io.flutter.view.a)localObject).MHf.requestSendAccessibilityEvent(localView, paramView, paramAccessibilityEvent))
    {
      AppMethodBeat.o(9888);
      return false;
    }
    paramView = ((io.flutter.view.a)localObject).MHf.getRecordFlutterId(localView, paramAccessibilityEvent);
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
      ((io.flutter.view.a)localObject).MHp = null;
      continue;
      ((io.flutter.view.a)localObject).MHk = paramView;
      ((io.flutter.view.a)localObject).MHj = null;
      continue;
      ((io.flutter.view.a)localObject).MHl = null;
      ((io.flutter.view.a)localObject).MHk = null;
      continue;
      ((io.flutter.view.a)localObject).MHl = paramView;
      ((io.flutter.view.a)localObject).MHn = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.a
 * JD-Core Version:    0.7.0.1
 */