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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
public final class c
  extends View.AccessibilityDelegate
{
  private boolean FTq;
  
  public c()
  {
    AppMethodBeat.i(141503);
    this.FTq = false;
    a locala = a.a.eSf();
    AudioManager localAudioManager = (AudioManager)locala.FZ.getSystemService("audio");
    if ((locala.eSe()) && ((Settings.Secure.getInt(locala.FZ.getContentResolver(), "speak_password", 0) != 0) || (localAudioManager.isWiredHeadsetOn()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.FTq = bool;
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
    if (!this.FTq)
    {
      AppMethodBeat.o(141504);
      return;
    }
    Object localObject;
    if ((paramView != null) && ((paramInt == 128) || (paramInt == 1))) {
      if ((paramView instanceof EditText))
      {
        localObject = (EditText)paramView;
        if (!bt.ai(((EditText)localObject).getText())) {
          localObject = ((EditText)localObject).getText();
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", new Object[] { localObject });
      if (bt.ai((CharSequence)localObject))
      {
        AppMethodBeat.o(141504);
        return;
        if (!bt.ai(((EditText)localObject).getContentDescription()))
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
            if (bt.ai(paramView.getContentDescription()))
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
        a locala = a.a.eSf();
        String str = ((CharSequence)localObject).toString();
        if (locala.FTk == null) {
          locala.FTk = new TextToSpeech(locala.FZ, new a.1(locala, str));
        }
        try
        {
          localObject = View.class.getMethod("clearAccessibilityFocus", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramView, new Object[0]);
          localObject = View.class.getMethod("requestAccessibilityFocus", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramView, new Object[0]);
          if (locala.mHT != null) {
            locala.mHT = ((Vibrator)aj.getContext().getSystemService("vibrator"));
          }
          if (locala.mHT != null) {
            locala.mHT.vibrate(50L);
          }
          AppMethodBeat.o(141504);
          return;
          TextToSpeech localTextToSpeech = locala.FTk;
          if (ac.eFq()) {}
          for (localObject = Locale.CHINESE;; localObject = Locale.ENGLISH)
          {
            localTextToSpeech.setLanguage((Locale)localObject);
            locala.FTk.speak(str, 0, null);
            break;
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", paramView, "", new Object[0]);
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