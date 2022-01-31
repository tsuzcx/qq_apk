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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
public final class c
  extends View.AccessibilityDelegate
{
  private boolean uRy = false;
  
  public c()
  {
    a locala = a.a.cAj();
    AudioManager localAudioManager = (AudioManager)locala.ze.getSystemService("audio");
    if ((locala.cAi()) && ((Settings.Secure.getInt(locala.ze.getContentResolver(), "speak_password", 0) != 0) || (localAudioManager.isWiredHeadsetOn()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.uRy = bool;
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
    if (!this.uRy) {
      break label7;
    }
    label7:
    while ((paramView == null) || ((paramInt != 128) && (paramInt != 1))) {
      return;
    }
    Object localObject;
    if ((paramView instanceof EditText))
    {
      localObject = (EditText)paramView;
      if (!bk.L(((EditText)localObject).getText())) {
        localObject = ((EditText)localObject).getText();
      }
    }
    for (;;)
    {
      for (;;)
      {
        y.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", new Object[] { localObject });
        if (bk.L((CharSequence)localObject)) {
          break;
        }
        a locala = a.a.cAj();
        String str = ((CharSequence)localObject).toString();
        if (locala.uRu == null) {
          locala.uRu = new TextToSpeech(locala.ze, new a.1(locala, str));
        }
        try
        {
          localObject = View.class.getMethod("clearAccessibilityFocus", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramView, new Object[0]);
          localObject = View.class.getMethod("requestAccessibilityFocus", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramView, new Object[0]);
          if (locala.ibr != null) {
            locala.ibr = ((Vibrator)ae.getContext().getSystemService("vibrator"));
          }
          if (locala.ibr == null) {
            break label7;
          }
          locala.ibr.vibrate(50L);
          return;
          if (!bk.L(((EditText)localObject).getContentDescription()))
          {
            localObject = ((EditText)localObject).getContentDescription();
          }
          else if (((EditText)localObject).getHint() != null)
          {
            localObject = ((EditText)localObject).getHint();
            continue;
            if ((paramView instanceof TextView))
            {
              if (bk.L(paramView.getContentDescription()))
              {
                localObject = ((TextView)paramView).getText();
                continue;
              }
              localObject = paramView.getContentDescription();
              continue;
            }
            localObject = paramView.getContentDescription();
            continue;
            TextToSpeech localTextToSpeech = locala.uRu;
            if (x.cqF()) {}
            for (localObject = Locale.CHINESE;; localObject = Locale.ENGLISH)
            {
              localTextToSpeech.setLanguage((Locale)localObject);
              locala.uRu.speak(str, 0, null);
              break;
            }
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", paramView, "", new Object[0]);
          }
          localObject = null;
        }
      }
    }
  }
  
  public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.a.c
 * JD-Core Version:    0.7.0.1
 */