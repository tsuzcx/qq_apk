package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
{
  public g Hro;
  View Hrp;
  private Rect Hrq;
  Rect Hrr;
  View Hrs;
  private ViewTreeObserver.OnGlobalLayoutListener Hrt;
  private ViewTreeObserver.OnGlobalLayoutListener Hru;
  private boolean Hrv;
  private int Hrw;
  private int Hrx;
  private int Hry;
  private int Hrz;
  private Activity activity;
  private boolean cEL;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(143101);
    this.Hrq = new Rect();
    this.Hrr = new Rect();
    this.cEL = false;
    this.Hrv = true;
    this.activity = paramActivity;
    if ((paramActivity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
    {
      ad.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
      this.Hrv = false;
    }
    this.Hrs = paramActivity.findViewById(16908290);
    this.Hrt = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143099);
        if (h.this.Hrp != null) {
          h.a(h.this);
        }
        AppMethodBeat.o(143099);
      }
    };
    this.Hru = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143100);
        if (h.this.Hrp != null)
        {
          int i = h.this.Hrr.bottom;
          h.this.Hrs.getWindowVisibleDisplayFrame(h.this.Hrr);
          if (h.this.Hrr.bottom != i)
          {
            ad.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", new Object[] { Integer.valueOf(i), h.this.Hrr.toShortString() });
            h.a(h.this);
          }
        }
        AppMethodBeat.o(143100);
      }
    };
    int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      this.Hry = Resources.getSystem().getDimensionPixelSize(i);
    }
    this.Hrz = a.fromDPToPix(paramActivity, 96);
    AppMethodBeat.o(143101);
  }
  
  public final void close()
  {
    AppMethodBeat.i(143103);
    ad.i("MicroMsg.KeyboardHeightProvider", "close: ");
    this.Hrs.getViewTreeObserver().removeOnGlobalLayoutListener(this.Hru);
    if ((this.cEL) && (this.Hrp != null)) {
      this.Hrp.getViewTreeObserver().removeOnGlobalLayoutListener(this.Hrt);
    }
    try
    {
      this.activity.getWindowManager().removeView(this.Hrp);
      this.Hrp = null;
      this.cEL = false;
      AppMethodBeat.o(143103);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
      }
    }
  }
  
  public final void setKeyboardHeightObserver(g paramg)
  {
    this.Hro = paramg;
  }
  
  public final void start()
  {
    AppMethodBeat.i(143102);
    if (this.Hrs != null)
    {
      ad.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", new Object[] { Boolean.valueOf(this.cEL), this.Hrs.getWindowToken() });
      if ((!this.cEL) && (this.Hrs.getWindowToken() != null) && (!this.activity.isFinishing()))
      {
        this.cEL = true;
        this.Hrp = new LinearLayout(this.activity);
        this.Hrp.setBackgroundColor(0);
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
        localLayoutParams.width = 0;
        localLayoutParams.height = -1;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.softInputMode = 16;
        localLayoutParams.setTitle("KeyboardWindow@" + hashCode());
        try
        {
          this.activity.getWindowManager().addView(this.Hrp, localLayoutParams);
          if (this.cEL)
          {
            this.Hrp.getViewTreeObserver().addOnGlobalLayoutListener(this.Hrt);
            this.Hrs.getViewTreeObserver().addOnGlobalLayoutListener(this.Hru);
          }
          this.Hrw = 0;
          this.Hrx = 0;
          if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
          {
            ad.w("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
            this.Hrv = false;
            AppMethodBeat.o(143102);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
            this.cEL = false;
            this.Hrp = null;
          }
          this.Hrv = true;
        }
      }
    }
    AppMethodBeat.o(143102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */