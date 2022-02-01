package com.tencent.mm.ui.a;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(14)
public final class c
  extends View.AccessibilityDelegate
{
  private boolean OLZ;
  
  public c()
  {
    AppMethodBeat.i(205155);
    this.OLZ = false;
    this.OLZ = a.a.gKe().gKd();
    AppMethodBeat.o(205155);
  }
  
  public final void sendAccessibilityEvent(View paramView, int paramInt)
  {
    AppMethodBeat.i(205156);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MMSecureAccessibilityAndroidRDelegate", "sendAccessibilityEventt: eventType:%s, trace: %s", new Object[] { Integer.valueOf(paramInt), android.util.Log.getStackTraceString(new Throwable()) });
    if (paramInt == 32768)
    {
      super.sendAccessibilityEvent(paramView, paramInt);
      AppMethodBeat.o(205156);
      return;
    }
    if (!this.OLZ)
    {
      if ((paramView != null) && ((paramInt == 128) || (paramInt == 1))) {
        a.a.gKe().gs(paramView);
      }
      AppMethodBeat.o(205156);
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
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MMSecureAccessibilityAndroidRDelegate", "speak content: %s", new Object[] { localObject });
      if (Util.isNullOrNil((CharSequence)localObject))
      {
        AppMethodBeat.o(205156);
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
        AppMethodBeat.o(205156);
        return;
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.a.c
 * JD-Core Version:    0.7.0.1
 */