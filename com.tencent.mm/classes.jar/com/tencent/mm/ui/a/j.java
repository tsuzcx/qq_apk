package com.tencent.mm.ui.a;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  extends View.AccessibilityDelegate
{
  private boolean shouldSpeakPassWord;
  
  public j()
  {
    AppMethodBeat.i(250082);
    this.shouldSpeakPassWord = false;
    this.shouldSpeakPassWord = a.a.jlv().jlt();
    AppMethodBeat.o(250082);
  }
  
  public final void sendAccessibilityEvent(View paramView, int paramInt)
  {
    AppMethodBeat.i(250093);
    if (!a.a.jlv().jls())
    {
      AppMethodBeat.o(250093);
      return;
    }
    Log.i("MicroMsg.MMSecureAccessibilityAndroidRDelegate", "shouldSpeakPassWord: %s, sendAccessibilityEvent eventType:%s", new Object[] { Boolean.valueOf(this.shouldSpeakPassWord), Integer.valueOf(paramInt) });
    if (paramInt == 32768)
    {
      super.sendAccessibilityEvent(paramView, paramInt);
      AppMethodBeat.o(250093);
      return;
    }
    if (!this.shouldSpeakPassWord)
    {
      if ((paramView != null) && ((paramInt == 128) || (paramInt == 1))) {
        a.a.jlv().kW(paramView);
      }
      AppMethodBeat.o(250093);
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
        AppMethodBeat.o(250093);
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
        a.a.jlv().l(paramView, ((CharSequence)localObject).toString());
        AppMethodBeat.o(250093);
        return;
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.a.j
 * JD-Core Version:    0.7.0.1
 */