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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  TextToSpeech FTk;
  private boolean FTl;
  private long FTm;
  public Context FZ;
  private AccessibilityManager apt;
  Vibrator mHT;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(141494);
    this.FTk = null;
    this.FZ = paramContext;
    this.apt = ((AccessibilityManager)this.FZ.getSystemService("accessibility"));
    AppMethodBeat.o(141494);
  }
  
  public final void a(View paramView, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(141497);
    if (!eSe())
    {
      AppMethodBeat.o(141497);
      return;
    }
    if ((this.FZ == null) || (paramView == null))
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
    localb.aKd(paramString1);
    if (paramInt > 0) {
      localb.aKd(this.FZ.getResources().getQuantityString(2131623940, 1, new Object[] { Integer.valueOf(paramInt) }));
    }
    localb.aKd(paramString2).aKd(paramString3);
    localb.fB(paramView);
    AppMethodBeat.o(141497);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(141496);
    if (!eSe())
    {
      AppMethodBeat.o(141496);
      return;
    }
    if ((bt.isNullOrNil(paramString1)) || (this.FZ == null))
    {
      AppMethodBeat.o(141496);
      return;
    }
    b localb = new b();
    localb.aKd(paramString1);
    if (!bt.isNullOrNil(paramString2)) {}
    for (;;)
    {
      try
      {
        i = bt.getInt(paramString2, 0);
        if (i > 0)
        {
          if (i > 0) {
            localb.aKd(this.FZ.getResources().getQuantityString(2131623969, 1, new Object[] { Integer.valueOf(i) }));
          }
          localb.aKd(this.FZ.getResources().getQuantityString(2131623970, 5, new Object[] { Integer.valueOf(3), Integer.valueOf(paramInt + 1) }));
          localb.fB(paramView);
          AppMethodBeat.o(141496);
          return;
        }
      }
      catch (Exception paramString1) {}
      int i = 0;
    }
  }
  
  public final void aw(View paramView, int paramInt)
  {
    AppMethodBeat.i(141498);
    if (!eSe())
    {
      AppMethodBeat.o(141498);
      return;
    }
    if ((this.FZ == null) || (paramView == null))
    {
      AppMethodBeat.o(141498);
      return;
    }
    paramInt = Math.max(paramInt, 1);
    b localb = new b();
    localb.aKd(this.FZ.getResources().getQuantityString(2131623939, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    localb.fB(paramView);
    AppMethodBeat.o(141498);
  }
  
  public final boolean eSe()
  {
    AppMethodBeat.i(141495);
    if (SystemClock.uptimeMillis() - this.FTm > 2000L)
    {
      bool1 = this.apt.isEnabled();
      boolean bool2 = this.apt.isTouchExplorationEnabled();
      if ((!bool1) || (!bool2)) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.FTl = bool1;
      this.FTm = SystemClock.uptimeMillis();
      bool1 = this.FTl;
      AppMethodBeat.o(141495);
      return bool1;
    }
  }
  
  public final void l(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(141499);
    if (eSe())
    {
      AppMethodBeat.o(141499);
      return;
    }
    if ((bt.isNullOrNil(paramString)) || (paramActivity == null))
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
    private static final a FTo;
    
    static
    {
      AppMethodBeat.i(141493);
      FTo = new a(aj.getContext());
      AppMethodBeat.o(141493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.a.a
 * JD-Core Version:    0.7.0.1
 */