package io.flutter.a.c;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.b;
import io.flutter.view.b.a;
import io.flutter.view.b.b;
import java.util.Map;

final class h$a
  extends FrameLayout
{
  private final a Jcd;
  private final View Jcs;
  
  public h$a(Context paramContext, a parama, View paramView)
  {
    super(paramContext);
    this.Jcd = parama;
    this.Jcs = paramView;
  }
  
  public final boolean requestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9888);
    Object localObject1 = this.Jcd;
    View localView = this.Jcs;
    if (((a)localObject1).IXS == null)
    {
      AppMethodBeat.o(9888);
      return false;
    }
    io.flutter.view.a locala = ((a)localObject1).IXS;
    b localb = locala.JcK;
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramAccessibilityEvent);
    localObject1 = localb.JeL.a(paramAccessibilityEvent);
    boolean bool;
    if (localObject1 == null) {
      bool = false;
    }
    int i;
    while (!bool)
    {
      AppMethodBeat.o(9888);
      return false;
      i = (int)(((Long)localObject1).longValue() >> 32);
      Object localObject2 = (Integer)localb.JeN.get(new b.b(localView, i, (byte)0));
      localObject1 = localObject2;
      int j;
      if (localObject2 == null)
      {
        j = localb.JeP;
        localb.JeP = (j + 1);
        localObject1 = Integer.valueOf(j);
        localb.B(localView, i, ((Integer)localObject1).intValue());
      }
      localAccessibilityEvent.setSource(localb.JcJ, ((Integer)localObject1).intValue());
      localAccessibilityEvent.setClassName(paramAccessibilityEvent.getClassName());
      localAccessibilityEvent.setPackageName(paramAccessibilityEvent.getPackageName());
      i = 0;
      for (;;)
      {
        if (i >= localAccessibilityEvent.getRecordCount()) {
          break label323;
        }
        localObject1 = localAccessibilityEvent.getRecord(i);
        localObject2 = localb.JeL.a((AccessibilityRecord)localObject1);
        if (localObject2 == null)
        {
          bool = false;
          break;
        }
        localObject2 = new b.b(localView, (int)(((Long)localObject2).longValue() >> 32), (byte)0);
        if (!localb.JeN.containsKey(localObject2))
        {
          bool = false;
          break;
        }
        j = ((Integer)localb.JeN.get(localObject2)).intValue();
        ((AccessibilityRecord)localObject1).setSource(localb.JcJ, j);
        i += 1;
      }
      label323:
      bool = localb.JcJ.getParent().requestSendAccessibilityEvent(paramView, localAccessibilityEvent);
    }
    paramView = locala.JcK;
    localObject1 = paramView.JeL.a(paramAccessibilityEvent);
    if (localObject1 == null) {}
    for (paramView = null; paramView == null; paramView = (Integer)paramView.JeN.get(new b.b(localView, i, (byte)0)))
    {
      AppMethodBeat.o(9888);
      return false;
      i = (int)(((Long)localObject1).longValue() >> 32);
    }
    switch (paramAccessibilityEvent.getEventType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9888);
      return true;
      locala.JcT = null;
      continue;
      locala.JcP = paramView;
      locala.JcO = null;
      continue;
      locala.JcQ = null;
      locala.JcP = null;
      continue;
      locala.JcQ = paramView;
      locala.JcS = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.a.c.h.a
 * JD-Core Version:    0.7.0.1
 */