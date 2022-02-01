package com.tencent.mm.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  public Context GX;
  TextToSpeech HsZ;
  private boolean Hta;
  private long Htb;
  private AccessibilityManager aqo;
  Vibrator njY;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(141494);
    this.HsZ = null;
    this.GX = paramContext;
    this.aqo = ((AccessibilityManager)this.GX.getSystemService("accessibility"));
    AppMethodBeat.o(141494);
  }
  
  public final void a(View paramView, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(141497);
    if (!fhO())
    {
      AppMethodBeat.o(141497);
      return;
    }
    if ((this.GX == null) || (paramView == null))
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
    localb.aPF(paramString1);
    if (paramInt > 0) {
      localb.aPF(this.GX.getResources().getQuantityString(2131623940, 1, new Object[] { Integer.valueOf(paramInt) }));
    }
    localb.aPF(paramString2).aPF(paramString3);
    localb.fO(paramView);
    AppMethodBeat.o(141497);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(141496);
    if (!fhO())
    {
      AppMethodBeat.o(141496);
      return;
    }
    if ((bs.isNullOrNil(paramString1)) || (this.GX == null))
    {
      AppMethodBeat.o(141496);
      return;
    }
    b localb = new b();
    localb.aPF(paramString1);
    if (!bs.isNullOrNil(paramString2)) {}
    for (;;)
    {
      try
      {
        i = bs.getInt(paramString2, 0);
        if (i > 0)
        {
          if (i > 0) {
            localb.aPF(this.GX.getResources().getQuantityString(2131623969, 1, new Object[] { Integer.valueOf(i) }));
          }
          localb.aPF(this.GX.getResources().getQuantityString(2131623970, 5, new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt + 1) }));
          localb.fO(paramView);
          AppMethodBeat.o(141496);
          return;
        }
      }
      catch (Exception paramString1) {}
      int i = 0;
    }
  }
  
  public final void ay(View paramView, int paramInt)
  {
    AppMethodBeat.i(141498);
    if (!fhO())
    {
      AppMethodBeat.o(141498);
      return;
    }
    if ((this.GX == null) || (paramView == null))
    {
      AppMethodBeat.o(141498);
      return;
    }
    paramInt = Math.max(paramInt, 1);
    b localb = new b();
    localb.aPF(this.GX.getResources().getQuantityString(2131623939, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    localb.fO(paramView);
    AppMethodBeat.o(141498);
  }
  
  public final boolean fhO()
  {
    AppMethodBeat.i(141495);
    if (SystemClock.uptimeMillis() - this.Htb > 2000L)
    {
      bool1 = this.aqo.isEnabled();
      boolean bool2 = this.aqo.isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.Hta = bool1;
      this.Htb = SystemClock.uptimeMillis();
      bool1 = this.Hta;
      AppMethodBeat.o(141495);
      return bool1;
    }
  }
  
  public final void l(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(141499);
    if (fhO())
    {
      AppMethodBeat.o(141499);
      return;
    }
    if ((bs.isNullOrNil(paramString)) || (paramActivity == null))
    {
      AppMethodBeat.o(141499);
      return;
    }
    paramString = paramActivity.getString(2131757533) + paramString;
    paramActivity.getWindow().getDecorView().setContentDescription(paramString);
    AppMethodBeat.o(141499);
  }
  
  public static final class a
  {
    private static final a Htd;
    
    static
    {
      AppMethodBeat.i(141493);
      Htd = new a(ai.getContext());
      AppMethodBeat.o(141493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.a.a
 * JD-Core Version:    0.7.0.1
 */