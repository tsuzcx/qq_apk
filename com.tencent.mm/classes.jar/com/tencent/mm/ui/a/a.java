package com.tencent.mm.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a
{
  TextToSpeech OLT;
  private boolean OLU;
  private long OLV;
  private AccessibilityManager asr;
  public Context mAppContext;
  private Vibrator paT;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(141494);
    this.OLT = null;
    this.mAppContext = paramContext;
    this.asr = ((AccessibilityManager)this.mAppContext.getSystemService("accessibility"));
    AppMethodBeat.o(141494);
  }
  
  public final void a(View paramView, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(141497);
    if (!gKc())
    {
      AppMethodBeat.o(141497);
      return;
    }
    if ((this.mAppContext == null) || (paramView == null))
    {
      AppMethodBeat.o(141497);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
    {
      AppMethodBeat.o(141497);
      return;
    }
    b localb = new b();
    localb.blW(paramString1);
    if (paramInt > 0) {
      localb.blW(this.mAppContext.getResources().getQuantityString(2131623940, 1, new Object[] { Integer.valueOf(paramInt) }));
    }
    localb.blW(paramString2).blW(paramString3);
    localb.gt(paramView);
    AppMethodBeat.o(141497);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(141496);
    if (!gKc())
    {
      AppMethodBeat.o(141496);
      return;
    }
    if ((Util.isNullOrNil(paramString1)) || (this.mAppContext == null))
    {
      AppMethodBeat.o(141496);
      return;
    }
    b localb = new b();
    localb.blW(paramString1);
    if (!Util.isNullOrNil(paramString2)) {}
    for (;;)
    {
      try
      {
        i = Util.getInt(paramString2, 0);
        if (i > 0)
        {
          if (i > 0) {
            localb.blW(this.mAppContext.getResources().getQuantityString(2131623969, 1, new Object[] { Integer.valueOf(i) }));
          }
          localb.blW(this.mAppContext.getResources().getQuantityString(2131623970, 5, new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt + 1) }));
          localb.gt(paramView);
          AppMethodBeat.o(141496);
          return;
        }
      }
      catch (Exception paramString1) {}
      int i = 0;
    }
  }
  
  public final void aF(View paramView, int paramInt)
  {
    AppMethodBeat.i(141498);
    if (!gKc())
    {
      AppMethodBeat.o(141498);
      return;
    }
    if ((this.mAppContext == null) || (paramView == null))
    {
      AppMethodBeat.o(141498);
      return;
    }
    paramInt = Math.max(paramInt, 1);
    b localb = new b();
    localb.blW(this.mAppContext.getResources().getQuantityString(2131623939, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    localb.gt(paramView);
    AppMethodBeat.o(141498);
  }
  
  public final void g(View paramView, final String paramString)
  {
    AppMethodBeat.i(205153);
    if (this.OLT == null)
    {
      this.OLT = new TextToSpeech(this.mAppContext, new TextToSpeech.OnInitListener()
      {
        public final void onInit(int paramAnonymousInt)
        {
          AppMethodBeat.i(141492);
          TextToSpeech localTextToSpeech;
          if (a.this.OLT != null)
          {
            localTextToSpeech = a.this.OLT;
            if (!LocaleUtil.isChineseAppLang()) {
              break label62;
            }
          }
          label62:
          for (Locale localLocale = Locale.CHINESE;; localLocale = Locale.ENGLISH)
          {
            localTextToSpeech.setLanguage(localLocale);
            a.this.OLT.speak(paramString, 0, null);
            AppMethodBeat.o(141492);
            return;
          }
        }
      });
      gs(paramView);
      AppMethodBeat.o(205153);
      return;
    }
    TextToSpeech localTextToSpeech = this.OLT;
    if (LocaleUtil.isChineseAppLang()) {}
    for (Locale localLocale = Locale.CHINESE;; localLocale = Locale.ENGLISH)
    {
      localTextToSpeech.setLanguage(localLocale);
      this.OLT.speak(paramString, 0, null);
      break;
    }
  }
  
  public final boolean gKc()
  {
    AppMethodBeat.i(141495);
    if (SystemClock.uptimeMillis() - this.OLV > 2000L)
    {
      bool1 = this.asr.isEnabled();
      boolean bool2 = this.asr.isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.OLU = bool1;
      this.OLV = SystemClock.uptimeMillis();
      bool1 = this.OLU;
      AppMethodBeat.o(141495);
      return bool1;
    }
  }
  
  public final boolean gKd()
  {
    AppMethodBeat.i(205152);
    AudioManager localAudioManager = (AudioManager)this.mAppContext.getSystemService("audio");
    if ((gKc()) && ((Settings.Secure.getInt(this.mAppContext.getContentResolver(), "speak_password", 0) != 0) || (localAudioManager.isWiredHeadsetOn())))
    {
      AppMethodBeat.o(205152);
      return true;
    }
    AppMethodBeat.o(205152);
    return false;
  }
  
  public final void gs(View paramView)
  {
    AppMethodBeat.i(205154);
    if (paramView == null)
    {
      AppMethodBeat.o(205154);
      return;
    }
    try
    {
      Method localMethod = View.class.getMethod("clearAccessibilityFocus", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramView, new Object[0]);
      localMethod = View.class.getMethod("requestAccessibilityFocus", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramView, new Object[0]);
      if (this.paT != null) {
        this.paT = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
      }
      if (this.paT != null) {
        this.paT.vibrate(50L);
      }
      AppMethodBeat.o(205154);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", paramView, "", new Object[0]);
      }
    }
  }
  
  public final void p(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(141499);
    if (gKc())
    {
      AppMethodBeat.o(141499);
      return;
    }
    if ((Util.isNullOrNil(paramString)) || (paramActivity == null))
    {
      AppMethodBeat.o(141499);
      return;
    }
    paramString = paramActivity.getString(2131757755) + paramString;
    paramActivity.getWindow().getDecorView().setContentDescription(paramString);
    AppMethodBeat.o(141499);
  }
  
  public static final class a
  {
    private static final a OLX;
    
    static
    {
      AppMethodBeat.i(141493);
      OLX = new a(MMApplicationContext.getContext());
      AppMethodBeat.o(141493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.a.a
 * JD-Core Version:    0.7.0.1
 */