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
  private final View STB;
  private final a accessibilityEventsDelegate;
  
  public SingleViewPresentation$a(Context paramContext, a parama, View paramView)
  {
    super(paramContext);
    this.accessibilityEventsDelegate = parama;
    this.STB = paramView;
  }
  
  public final boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9888);
    Object localObject = this.accessibilityEventsDelegate;
    View localView = this.STB;
    if (((a)localObject).SNs == null)
    {
      AppMethodBeat.o(9888);
      return false;
    }
    localObject = ((a)localObject).SNs;
    if (!((io.flutter.view.a)localObject).STS.requestSendAccessibilityEvent(localView, paramView, paramAccessibilityEvent))
    {
      AppMethodBeat.o(9888);
      return false;
    }
    paramView = ((io.flutter.view.a)localObject).STS.getRecordFlutterId(localView, paramAccessibilityEvent);
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
      ((io.flutter.view.a)localObject).SUc = null;
      continue;
      ((io.flutter.view.a)localObject).STX = paramView;
      ((io.flutter.view.a)localObject).STW = null;
      continue;
      ((io.flutter.view.a)localObject).STY = null;
      ((io.flutter.view.a)localObject).STX = null;
      continue;
      ((io.flutter.view.a)localObject).STY = paramView;
      ((io.flutter.view.a)localObject).SUa = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.plugin.platform.SingleViewPresentation.a
 * JD-Core Version:    0.7.0.1
 */