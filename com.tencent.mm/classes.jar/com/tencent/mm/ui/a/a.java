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
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a
{
  TextToSpeech Wfs;
  private boolean Wft;
  private long Wfu;
  private AccessibilityManager akm;
  public Context mAppContext;
  private Vibrator rqC;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(141494);
    this.Wfs = null;
    this.mAppContext = paramContext;
    this.akm = ((AccessibilityManager)this.mAppContext.getSystemService("accessibility"));
    AppMethodBeat.o(141494);
  }
  
  public static final a hJc()
  {
    AppMethodBeat.i(293190);
    a locala = a.a.hJg();
    AppMethodBeat.o(293190);
    return locala;
  }
  
  public final void a(View paramView, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(141497);
    if (!hJd())
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
    localb.byv(paramString1);
    if (paramInt > 0) {
      localb.byv(this.mAppContext.getResources().getQuantityString(a.i.conversation_item_desc_unread, 1, new Object[] { Integer.valueOf(paramInt) }));
    }
    localb.byv(paramString2).byv(paramString3);
    localb.hE(paramView);
    AppMethodBeat.o(141497);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(141496);
    if (!hJd())
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
    localb.byv(paramString1);
    if (!Util.isNullOrNil(paramString2)) {}
    for (;;)
    {
      try
      {
        i = Util.getInt(paramString2, 0);
        if (i > 0)
        {
          if (i > 0) {
            localb.byv(this.mAppContext.getResources().getQuantityString(a.i.tab_desc_unread, 1, new Object[] { Integer.valueOf(i) }));
          }
          localb.byv(this.mAppContext.getResources().getQuantityString(a.i.tab_name_site_desc, 5, new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt + 1) }));
          localb.hE(paramView);
          AppMethodBeat.o(141496);
          return;
        }
      }
      catch (Exception paramString1) {}
      int i = 0;
    }
  }
  
  public final void aK(View paramView, int paramInt)
  {
    AppMethodBeat.i(141498);
    if (!hJd())
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
    localb.byv(this.mAppContext.getResources().getQuantityString(a.i.chatting_voice_item_desc, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    localb.hE(paramView);
    AppMethodBeat.o(141498);
  }
  
  public final void hD(View paramView)
  {
    AppMethodBeat.i(200048);
    if (paramView == null)
    {
      AppMethodBeat.o(200048);
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
      if (this.rqC != null) {
        this.rqC = ((Vibrator)MMApplicationContext.getContext().getSystemService("vibrator"));
      }
      if (this.rqC != null) {
        this.rqC.vibrate(50L);
      }
      AppMethodBeat.o(200048);
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
  
  public final boolean hJd()
  {
    AppMethodBeat.i(141495);
    if (SystemClock.uptimeMillis() - this.Wfu > 2000L)
    {
      bool1 = this.akm.isEnabled();
      boolean bool2 = this.akm.isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.Wft = bool1;
      this.Wfu = SystemClock.uptimeMillis();
      bool1 = this.Wft;
      AppMethodBeat.o(141495);
      return bool1;
    }
  }
  
  public final boolean hJe()
  {
    AppMethodBeat.i(293191);
    boolean bool = hJd();
    AppMethodBeat.o(293191);
    return bool;
  }
  
  public final boolean hJf()
  {
    AppMethodBeat.i(200039);
    AudioManager localAudioManager = (AudioManager)this.mAppContext.getSystemService("audio");
    if ((hJd()) && ((Settings.Secure.getInt(this.mAppContext.getContentResolver(), "speak_password", 0) != 0) || (localAudioManager.isWiredHeadsetOn())))
    {
      AppMethodBeat.o(200039);
      return true;
    }
    AppMethodBeat.o(200039);
    return false;
  }
  
  public final void j(View paramView, final String paramString)
  {
    AppMethodBeat.i(200041);
    if (this.Wfs == null)
    {
      this.Wfs = new TextToSpeech(this.mAppContext, new TextToSpeech.OnInitListener()
      {
        public final void onInit(int paramAnonymousInt)
        {
          AppMethodBeat.i(141492);
          TextToSpeech localTextToSpeech;
          if (a.this.Wfs != null)
          {
            localTextToSpeech = a.this.Wfs;
            if (!LocaleUtil.isChineseAppLang()) {
              break label62;
            }
          }
          label62:
          for (Locale localLocale = Locale.CHINESE;; localLocale = Locale.ENGLISH)
          {
            localTextToSpeech.setLanguage(localLocale);
            a.this.Wfs.speak(paramString, 0, null);
            AppMethodBeat.o(141492);
            return;
          }
        }
      });
      hD(paramView);
      AppMethodBeat.o(200041);
      return;
    }
    TextToSpeech localTextToSpeech = this.Wfs;
    if (LocaleUtil.isChineseAppLang()) {}
    for (Locale localLocale = Locale.CHINESE;; localLocale = Locale.ENGLISH)
    {
      localTextToSpeech.setLanguage(localLocale);
      this.Wfs.speak(paramString, 0, null);
      break;
    }
  }
  
  public final void p(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(141499);
    if (hJd())
    {
      AppMethodBeat.o(141499);
      return;
    }
    if ((Util.isNullOrNil(paramString)) || (paramActivity == null))
    {
      AppMethodBeat.o(141499);
      return;
    }
    paramString = paramActivity.getString(a.k.common_enter_activity) + paramString;
    paramActivity.getWindow().getDecorView().setContentDescription(paramString);
    AppMethodBeat.o(141499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.a.a
 * JD-Core Version:    0.7.0.1
 */