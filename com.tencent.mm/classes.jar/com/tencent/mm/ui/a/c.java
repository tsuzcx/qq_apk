package com.tencent.mm.ui.a;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(14)
public final class c
  extends View.AccessibilityDelegate
{
  private boolean Wfy;
  
  public c()
  {
    AppMethodBeat.i(217597);
    this.Wfy = false;
    this.Wfy = a.a.hJg().hJf();
    AppMethodBeat.o(217597);
  }
  
  public final void sendAccessibilityEvent(View paramView, int paramInt)
  {
    AppMethodBeat.i(217601);
    if (!a.a.hJg().hJd())
    {
      AppMethodBeat.o(217601);
      return;
    }
    Log.i("MicroMsg.MMSecureAccessibilityAndroidRDelegate", "shouldSpeakPassWord: %s, sendAccessibilityEvent eventType:%s", new Object[] { Boolean.valueOf(this.Wfy), Integer.valueOf(paramInt) });
    if (paramInt == 32768)
    {
      super.sendAccessibilityEvent(paramView, paramInt);
      AppMethodBeat.o(217601);
      return;
    }
    if (!this.Wfy)
    {
      if ((paramView != null) && ((paramInt == 128) || (paramInt == 1))) {
        a.a.hJg().hD(paramView);
      }
      AppMethodBeat.o(217601);
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
        AppMethodBeat.o(217601);
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
        AppMethodBeat.o(217601);
        return;
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.a.c
 * JD-Core Version:    0.7.0.1
 */