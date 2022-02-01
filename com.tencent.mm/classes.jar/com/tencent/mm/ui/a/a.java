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
import com.tencent.mm.ah.a.i;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a
{
  TextToSpeech adLk;
  private boolean adLl;
  private long adLm;
  private AccessibilityManager bYO;
  public Context mAppContext;
  private Vibrator uAL;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(141494);
    this.adLk = null;
    this.mAppContext = paramContext;
    this.bYO = ((AccessibilityManager)this.mAppContext.getSystemService("accessibility"));
    AppMethodBeat.o(141494);
  }
  
  public static boolean jlu()
  {
    AppMethodBeat.i(250110);
    if (((c)h.ax(c.class)).a(c.a.zbG, 1) == 1)
    {
      AppMethodBeat.o(250110);
      return true;
    }
    AppMethodBeat.o(250110);
    return false;
  }
  
  public final void a(View paramView, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(141497);
    if (!jls())
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
    localb.bzT(paramString1);
    if (paramInt > 0) {
      localb.bzT(this.mAppContext.getResources().getQuantityString(a.i.conversation_item_desc_unread, 1, new Object[] { Integer.valueOf(paramInt) }));
    }
    localb.bzT(paramString2).bzT(paramString3);
    localb.kX(paramView);
    AppMethodBeat.o(141497);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(141496);
    if (!jls())
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
    localb.bzT(paramString1);
    if (!Util.isNullOrNil(paramString2)) {}
    for (;;)
    {
      try
      {
        i = Util.getInt(paramString2, 0);
        if (i > 0)
        {
          if (i > 0) {
            localb.bzT(this.mAppContext.getResources().getQuantityString(a.i.tab_desc_unread, 1, new Object[] { Integer.valueOf(i) }));
          }
          localb.bzT(this.mAppContext.getResources().getQuantityString(a.i.tab_name_site_desc, 5, new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt + 1) }));
          localb.kX(paramView);
          AppMethodBeat.o(141496);
          return;
        }
      }
      catch (Exception paramString1) {}
      int i = 0;
    }
  }
  
  public final void bh(View paramView, int paramInt)
  {
    AppMethodBeat.i(141498);
    if (!jls())
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
    localb.bzT(this.mAppContext.getResources().getQuantityString(a.i.chatting_voice_item_desc, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    localb.kX(paramView);
    AppMethodBeat.o(141498);
  }
  
  public final boolean jls()
  {
    AppMethodBeat.i(141495);
    if (SystemClock.uptimeMillis() - this.adLm > 2000L)
    {
      bool1 = this.bYO.isEnabled();
      boolean bool2 = this.bYO.isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.adLl = bool1;
      this.adLm = SystemClock.uptimeMillis();
      bool1 = this.adLl;
      AppMethodBeat.o(141495);
      return bool1;
    }
  }
  
  public final boolean jlt()
  {
    AppMethodBeat.i(250116);
    AudioManager localAudioManager = (AudioManager)this.mAppContext.getSystemService("audio");
    if ((jls()) && ((Settings.Secure.getInt(this.mAppContext.getContentResolver(), "speak_password", 0) != 0) || (localAudioManager.isWiredHeadsetOn())))
    {
      AppMethodBeat.o(250116);
      return true;
    }
    AppMethodBeat.o(250116);
    return false;
  }
  
  public final void kW(View paramView)
  {
    AppMethodBeat.i(250132);
    if (paramView == null)
    {
      AppMethodBeat.o(250132);
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
      if (this.uAL != null) {
        this.uAL = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
      }
      if (this.uAL != null) {
        this.uAL.vibrate(50L);
      }
      AppMethodBeat.o(250132);
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
  
  public final void l(View paramView, final String paramString)
  {
    AppMethodBeat.i(250126);
    if (this.adLk == null)
    {
      this.adLk = new TextToSpeech(this.mAppContext, new TextToSpeech.OnInitListener()
      {
        public final void onInit(int paramAnonymousInt)
        {
          AppMethodBeat.i(141492);
          TextToSpeech localTextToSpeech;
          if (a.this.adLk != null)
          {
            localTextToSpeech = a.this.adLk;
            if (!LocaleUtil.isChineseAppLang()) {
              break label62;
            }
          }
          label62:
          for (Locale localLocale = Locale.CHINESE;; localLocale = Locale.ENGLISH)
          {
            localTextToSpeech.setLanguage(localLocale);
            a.this.adLk.speak(paramString, 0, null);
            AppMethodBeat.o(141492);
            return;
          }
        }
      });
      kW(paramView);
      AppMethodBeat.o(250126);
      return;
    }
    TextToSpeech localTextToSpeech = this.adLk;
    if (LocaleUtil.isChineseAppLang()) {}
    for (Locale localLocale = Locale.CHINESE;; localLocale = Locale.ENGLISH)
    {
      localTextToSpeech.setLanguage(localLocale);
      this.adLk.speak(paramString, 0, null);
      break;
    }
  }
  
  public final void r(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(141499);
    if (!jls())
    {
      AppMethodBeat.o(141499);
      return;
    }
    if ((Util.isNullOrNil(paramString)) || (paramActivity == null))
    {
      AppMethodBeat.o(141499);
      return;
    }
    String str = paramActivity.getString(a.k.common_enter_activity) + paramString;
    paramActivity.getWindow().getDecorView().setContentDescription(str);
    paramActivity.getWindow().setTitle(paramString);
    AppMethodBeat.o(141499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.a.a
 * JD-Core Version:    0.7.0.1
 */