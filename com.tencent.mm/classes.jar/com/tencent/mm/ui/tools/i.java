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
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  public h XSx;
  private Activity activity;
  private boolean dic;
  View rya;
  private Rect ryb;
  Rect ryc;
  View ryd;
  private ViewTreeObserver.OnGlobalLayoutListener ryf;
  private ViewTreeObserver.OnGlobalLayoutListener ryg;
  private boolean ryh;
  private int ryi;
  private int ryj;
  private int ryk;
  private int ryl;
  
  public i(Activity paramActivity)
  {
    AppMethodBeat.i(143101);
    this.ryb = new Rect();
    this.ryc = new Rect();
    this.dic = false;
    this.ryh = true;
    this.activity = paramActivity;
    if ((paramActivity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
    {
      Log.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
      this.ryh = false;
    }
    this.ryd = paramActivity.findViewById(16908290);
    this.ryf = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143099);
        if (i.this.rya != null) {
          i.a(i.this);
        }
        AppMethodBeat.o(143099);
      }
    };
    this.ryg = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143100);
        if (i.this.rya != null)
        {
          int i = i.this.ryc.bottom;
          i.this.ryd.getWindowVisibleDisplayFrame(i.this.ryc);
          if (i.this.ryc.bottom != i)
          {
            Log.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", new Object[] { Integer.valueOf(i), i.this.ryc.toShortString() });
            i.a(i.this);
          }
        }
        AppMethodBeat.o(143100);
      }
    };
    int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      this.ryk = Resources.getSystem().getDimensionPixelSize(i);
    }
    this.ryl = a.fromDPToPix(paramActivity, 96);
    AppMethodBeat.o(143101);
  }
  
  public final void close()
  {
    AppMethodBeat.i(143103);
    Log.i("MicroMsg.KeyboardHeightProvider", "close: ");
    this.ryd.getViewTreeObserver().removeOnGlobalLayoutListener(this.ryg);
    if ((this.dic) && (this.rya != null)) {
      this.rya.getViewTreeObserver().removeOnGlobalLayoutListener(this.ryf);
    }
    try
    {
      this.activity.getWindowManager().removeView(this.rya);
      this.rya = null;
      this.dic = false;
      AppMethodBeat.o(143103);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
      }
    }
  }
  
  public final void setKeyboardHeightObserver(h paramh)
  {
    this.XSx = paramh;
  }
  
  public final void start()
  {
    AppMethodBeat.i(143102);
    if (this.ryd != null)
    {
      Log.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", new Object[] { Boolean.valueOf(this.dic), this.ryd.getWindowToken() });
      if ((!this.dic) && (this.ryd.getWindowToken() != null) && (!this.activity.isFinishing()))
      {
        this.dic = true;
        this.rya = new LinearLayout(this.activity);
        this.rya.setBackgroundColor(0);
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
        localLayoutParams.width = 0;
        localLayoutParams.height = -1;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.softInputMode = 16;
        localLayoutParams.setTitle("KeyboardWindow@" + hashCode());
        try
        {
          this.activity.getWindowManager().addView(this.rya, localLayoutParams);
          if (this.dic)
          {
            this.rya.getViewTreeObserver().addOnGlobalLayoutListener(this.ryf);
            this.ryd.getViewTreeObserver().addOnGlobalLayoutListener(this.ryg);
          }
          this.ryi = 0;
          this.ryj = 0;
          if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
          {
            Log.w("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
            this.ryh = false;
            AppMethodBeat.o(143102);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
            this.dic = false;
            this.rya = null;
          }
          this.ryh = true;
        }
      }
    }
    AppMethodBeat.o(143102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */