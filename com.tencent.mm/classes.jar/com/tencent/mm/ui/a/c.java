package com.tencent.mm.ui.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
public final class c
  extends View.AccessibilityDelegate
{
  private boolean JBG;
  
  public c()
  {
    AppMethodBeat.i(141503);
    this.JBG = false;
    a locala = a.a.fCh();
    AudioManager localAudioManager = (AudioManager)locala.IR.getSystemService("audio");
    if ((locala.fCg()) && ((Settings.Secure.getInt(locala.IR.getContentResolver(), "speak_password", 0) != 0) || (localAudioManager.isWiredHeadsetOn()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.JBG = bool;
      AppMethodBeat.o(141503);
      return;
    }
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
    if (!this.JBG)
    {
      AppMethodBeat.o(141504);
      return;
    }
    Object localObject;
    if ((paramView != null) && ((paramInt == 128) || (paramInt == 1))) {
      if ((paramView instanceof EditText))
      {
        localObject = (EditText)paramView;
        if (!bu.ah(((EditText)localObject).getText())) {
          localObject = ((EditText)localObject).getText();
        }
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", new Object[] { localObject });
      if (bu.ah((CharSequence)localObject))
      {
        AppMethodBeat.o(141504);
        return;
        if (!bu.ah(((EditText)localObject).getContentDescription()))
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
            if (bu.ah(paramView.getContentDescription()))
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
        a locala = a.a.fCh();
        String str = ((CharSequence)localObject).toString();
        if (locala.JBA == null) {
          locala.JBA = new TextToSpeech(locala.IR, new a.1(locala, str));
        }
        try
        {
          localObject = View.class.getMethod("clearAccessibilityFocus", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramView, new Object[0]);
          localObject = View.class.getMethod("requestAccessibilityFocus", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramView, new Object[0]);
          if (locala.nQa != null) {
            locala.nQa = ((Vibrator)ak.getContext().getSystemService("vibrator"));
          }
          if (locala.nQa != null) {
            locala.nQa.vibrate(50L);
          }
          AppMethodBeat.o(141504);
          return;
          TextToSpeech localTextToSpeech = locala.JBA;
          if (ad.foi()) {}
          for (localObject = Locale.CHINESE;; localObject = Locale.ENGLISH)
          {
            localTextToSpeech.setLanguage((Locale)localObject);
            locala.JBA.speak(str, 0, null);
            break;
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", paramView, "", new Object[0]);
          }
        }
      }
      localObject = null;
    }
  }
  
  public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.a.c
 * JD-Core Version:    0.7.0.1
 */