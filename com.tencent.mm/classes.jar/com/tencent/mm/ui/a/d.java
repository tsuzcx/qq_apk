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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(14)
public final class d
  extends View.AccessibilityDelegate
{
  private boolean OLZ;
  
  public d()
  {
    AppMethodBeat.i(141503);
    this.OLZ = false;
    this.OLZ = a.a.gKe().gKd();
    AppMethodBeat.o(141503);
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
    if (!this.OLZ)
    {
      if ((paramView != null) && ((paramInt == 128) || (paramInt == 1))) {
        a.a.gKe().gs(paramView);
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
      Log.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", new Object[] { localObject });
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
        a.a.gKe().g(paramView, ((CharSequence)localObject).toString());
        AppMethodBeat.o(141504);
        return;
      }
      localObject = null;
    }
  }
  
  public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.a.d
 * JD-Core Version:    0.7.0.1
 */