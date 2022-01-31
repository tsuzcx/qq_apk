package com.tencent.mm.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;

public final class a
{
  private AccessibilityManager fU;
  Vibrator kqP;
  public Context zF;
  TextToSpeech zfT;
  private boolean zfU;
  private long zfV;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(106134);
    this.zfT = null;
    this.zF = paramContext;
    this.fU = ((AccessibilityManager)this.zF.getSystemService("accessibility"));
    AppMethodBeat.o(106134);
  }
  
  public final void a(View paramView, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(106137);
    if (!dDs())
    {
      AppMethodBeat.o(106137);
      return;
    }
    if ((this.zF == null) || (paramView == null))
    {
      AppMethodBeat.o(106137);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
    {
      AppMethodBeat.o(106137);
      return;
    }
    b localb = new b();
    localb.atr(paramString1);
    if (paramInt > 0) {
      localb.atr(this.zF.getResources().getQuantityString(2131361796, 1, new Object[] { Integer.valueOf(paramInt) }));
    }
    localb.atr(paramString2).atr(paramString3);
    localb.eK(paramView);
    AppMethodBeat.o(106137);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(106136);
    if (!dDs())
    {
      AppMethodBeat.o(106136);
      return;
    }
    if ((bo.isNullOrNil(paramString1)) || (this.zF == null))
    {
      AppMethodBeat.o(106136);
      return;
    }
    b localb = new b();
    localb.atr(paramString1);
    if (!bo.isNullOrNil(paramString2)) {}
    for (;;)
    {
      try
      {
        i = bo.getInt(paramString2, 0);
        if (i > 0)
        {
          if (i > 0) {
            localb.atr(this.zF.getResources().getQuantityString(2131361823, 1, new Object[] { Integer.valueOf(i) }));
          }
          localb.atr(this.zF.getResources().getQuantityString(2131361824, 5, new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt + 1) }));
          localb.eK(paramView);
          AppMethodBeat.o(106136);
          return;
        }
      }
      catch (Exception paramString1) {}
      int i = 0;
    }
  }
  
  public final void al(View paramView, int paramInt)
  {
    AppMethodBeat.i(106138);
    if (!dDs())
    {
      AppMethodBeat.o(106138);
      return;
    }
    if ((this.zF == null) || (paramView == null))
    {
      AppMethodBeat.o(106138);
      return;
    }
    paramInt = Math.max(paramInt, 1);
    b localb = new b();
    localb.atr(this.zF.getResources().getQuantityString(2131361795, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    localb.eK(paramView);
    AppMethodBeat.o(106138);
  }
  
  public final boolean dDs()
  {
    AppMethodBeat.i(106135);
    if (SystemClock.uptimeMillis() - this.zfV > 2000L)
    {
      bool1 = this.fU.isEnabled();
      boolean bool2 = this.fU.isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zfU = bool1;
      this.zfV = SystemClock.uptimeMillis();
      bool1 = this.zfU;
      AppMethodBeat.o(106135);
      return bool1;
    }
  }
  
  public final void k(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(106139);
    if (dDs())
    {
      AppMethodBeat.o(106139);
      return;
    }
    if ((bo.isNullOrNil(paramString)) || (paramActivity == null))
    {
      AppMethodBeat.o(106139);
      return;
    }
    paramString = paramActivity.getString(2131298492) + paramString;
    paramActivity.getWindow().getDecorView().setContentDescription(paramString);
    AppMethodBeat.o(106139);
  }
  
  public static final class a
  {
    private static final a zfX;
    
    static
    {
      AppMethodBeat.i(106133);
      zfX = new a(ah.getContext());
      AppMethodBeat.o(106133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.a.a
 * JD-Core Version:    0.7.0.1
 */