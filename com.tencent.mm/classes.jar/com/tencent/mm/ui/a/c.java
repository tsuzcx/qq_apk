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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
public final class c
  extends View.AccessibilityDelegate
{
  private boolean Htf;
  
  public c()
  {
    AppMethodBeat.i(141503);
    this.Htf = false;
    a locala = a.a.fhP();
    AudioManager localAudioManager = (AudioManager)locala.GX.getSystemService("audio");
    if ((locala.fhO()) && ((Settings.Secure.getInt(locala.GX.getContentResolver(), "speak_password", 0) != 0) || (localAudioManager.isWiredHeadsetOn()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.Htf = bool;
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
    if (!this.Htf)
    {
      AppMethodBeat.o(141504);
      return;
    }
    Object localObject;
    if ((paramView != null) && ((paramInt == 128) || (paramInt == 1))) {
      if ((paramView instanceof EditText))
      {
        localObject = (EditText)paramView;
        if (!bs.aj(((EditText)localObject).getText())) {
          localObject = ((EditText)localObject).getText();
        }
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", new Object[] { localObject });
      if (bs.aj((CharSequence)localObject))
      {
        AppMethodBeat.o(141504);
        return;
        if (!bs.aj(((EditText)localObject).getContentDescription()))
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
            if (bs.aj(paramView.getContentDescription()))
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
        a locala = a.a.fhP();
        String str = ((CharSequence)localObject).toString();
        if (locala.HsZ == null) {
          locala.HsZ = new TextToSpeech(locala.GX, new a.1(locala, str));
        }
        try
        {
          localObject = View.class.getMethod("clearAccessibilityFocus", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramView, new Object[0]);
          localObject = View.class.getMethod("requestAccessibilityFocus", new Class[0]);
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramView, new Object[0]);
          if (locala.njY != null) {
            locala.njY = ((Vibrator)ai.getContext().getSystemService("vibrator"));
          }
          if (locala.njY != null) {
            locala.njY.vibrate(50L);
          }
          AppMethodBeat.o(141504);
          return;
          TextToSpeech localTextToSpeech = locala.HsZ;
          if (ab.eUK()) {}
          for (localObject = Locale.CHINESE;; localObject = Locale.ENGLISH)
          {
            localTextToSpeech.setLanguage((Locale)localObject);
            locala.HsZ.speak(str, 0, null);
            break;
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", paramView, "", new Object[0]);
          }
        }
      }
      localObject = null;
    }
  }
  
  public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.a.c
 * JD-Core Version:    0.7.0.1
 */