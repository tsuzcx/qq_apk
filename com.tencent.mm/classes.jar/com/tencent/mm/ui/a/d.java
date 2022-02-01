package com.tencent.mm.ui.a;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(14)
public final class d
  extends View.AccessibilityDelegate
{
  private boolean Wfy;
  
  private d()
  {
    AppMethodBeat.i(141503);
    this.Wfy = false;
    this.Wfy = a.a.hJg().hJf();
    AppMethodBeat.o(141503);
  }
  
  public static View.AccessibilityDelegate hJh()
  {
    AppMethodBeat.i(205897);
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vLg, 1) == 1) {}
    for (int i = 1; (i != 0) && (com.tencent.mm.compatible.util.d.qV(30)) && (a.a.hJg().hJd()); i = 0)
    {
      com.tencent.mm.plugin.report.service.h.IzE.el(1624, 11);
      localObject = new c();
      AppMethodBeat.o(205897);
      return localObject;
    }
    Object localObject = new d();
    AppMethodBeat.o(205897);
    return localObject;
  }
  
  public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public final AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    return null;
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo) {}
  
  public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return true;
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return true;
  }
  
  public final void sendAccessibilityEvent(View paramView, int paramInt)
  {
    AppMethodBeat.i(141504);
    if (!a.a.hJg().hJd())
    {
      AppMethodBeat.o(141504);
      return;
    }
    Log.i("MicroMsg.MMSecureAccessibilityDelegate", "sendAccessibilityEvent shouldSpeakPassWord: %s, eventType: %s", new Object[] { Boolean.valueOf(this.Wfy), Integer.valueOf(paramInt) });
    if (!this.Wfy)
    {
      if ((paramView != null) && ((paramInt == 128) || (paramInt == 1))) {
        a.a.hJg().hD(paramView);
      }
      AppMethodBeat.o(141504);
      return;
    }
    Object localObject;
    if ((paramView != null) && ((paramInt == 128) || (paramInt == 1))) {
      if ((paramView instanceof EditText))
      {
        localObject = (EditText)paramView;
        if (!Util.isNullOrNil(((EditText)localObject).getText())) {
          localObject = ((EditText)localObject).getText();
        }
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil((CharSequence)localObject))
      {
        AppMethodBeat.o(141504);
        return;
        if (!Util.isNullOrNil(((EditText)localObject).getContentDescription()))
        {
          localObject = ((EditText)localObject).getContentDescription();
          continue;
        }
        if (((EditText)localObject).getHint() != null)
        {
          localObject = ((EditText)localObject).getHint();
          continue;
          if ((paramView instanceof TextView))
          {
            if (Util.isNullOrNil(paramView.getContentDescription()))
            {
              localObject = ((TextView)paramView).getText();
              continue;
            }
            localObject = paramView.getContentDescription();
            continue;
          }
          localObject = paramView.getContentDescription();
        }
      }
      else
      {
        a.a.hJg().j(paramView, ((CharSequence)localObject).toString());
        AppMethodBeat.o(141504);
        return;
      }
      localObject = null;
    }
  }
  
  public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.a.d
 * JD-Core Version:    0.7.0.1
 */