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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
{
  public g Lfj;
  View Lfk;
  private Rect Lfl;
  Rect Lfm;
  View Lfn;
  private ViewTreeObserver.OnGlobalLayoutListener Lfo;
  private ViewTreeObserver.OnGlobalLayoutListener Lfp;
  private boolean Lfq;
  private int Lfr;
  private int Lfs;
  private int Lft;
  private int Lfu;
  private Activity activity;
  private boolean cNB;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(143101);
    this.Lfl = new Rect();
    this.Lfm = new Rect();
    this.cNB = false;
    this.Lfq = true;
    this.activity = paramActivity;
    if ((paramActivity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
    {
      ae.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
      this.Lfq = false;
    }
    this.Lfn = paramActivity.findViewById(16908290);
    this.Lfo = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143099);
        if (h.this.Lfk != null) {
          h.a(h.this);
        }
        AppMethodBeat.o(143099);
      }
    };
    this.Lfp = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143100);
        if (h.this.Lfk != null)
        {
          int i = h.this.Lfm.bottom;
          h.this.Lfn.getWindowVisibleDisplayFrame(h.this.Lfm);
          if (h.this.Lfm.bottom != i)
          {
            ae.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", new Object[] { Integer.valueOf(i), h.this.Lfm.toShortString() });
            h.a(h.this);
          }
        }
        AppMethodBeat.o(143100);
      }
    };
    int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      this.Lft = Resources.getSystem().getDimensionPixelSize(i);
    }
    this.Lfu = a.fromDPToPix(paramActivity, 96);
    AppMethodBeat.o(143101);
  }
  
  public final void close()
  {
    AppMethodBeat.i(143103);
    ae.i("MicroMsg.KeyboardHeightProvider", "close: ");
    this.Lfn.getViewTreeObserver().removeOnGlobalLayoutListener(this.Lfp);
    if ((this.cNB) && (this.Lfk != null)) {
      this.Lfk.getViewTreeObserver().removeOnGlobalLayoutListener(this.Lfo);
    }
    try
    {
      this.activity.getWindowManager().removeView(this.Lfk);
      this.Lfk = null;
      this.cNB = false;
      AppMethodBeat.o(143103);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
      }
    }
  }
  
  public final void setKeyboardHeightObserver(g paramg)
  {
    this.Lfj = paramg;
  }
  
  public final void start()
  {
    AppMethodBeat.i(143102);
    if (this.Lfn != null)
    {
      ae.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", new Object[] { Boolean.valueOf(this.cNB), this.Lfn.getWindowToken() });
      if ((!this.cNB) && (this.Lfn.getWindowToken() != null) && (!this.activity.isFinishing()))
      {
        this.cNB = true;
        this.Lfk = new LinearLayout(this.activity);
        this.Lfk.setBackgroundColor(0);
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
        localLayoutParams.width = 0;
        localLayoutParams.height = -1;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.softInputMode = 16;
        localLayoutParams.setTitle("KeyboardWindow@" + hashCode());
        try
        {
          this.activity.getWindowManager().addView(this.Lfk, localLayoutParams);
          if (this.cNB)
          {
            this.Lfk.getViewTreeObserver().addOnGlobalLayoutListener(this.Lfo);
            this.Lfn.getViewTreeObserver().addOnGlobalLayoutListener(this.Lfp);
          }
          this.Lfr = 0;
          this.Lfs = 0;
          if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
          {
            ae.w("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
            this.Lfq = false;
            AppMethodBeat.o(143102);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
            this.cNB = false;
            this.Lfk = null;
          }
          this.Lfq = true;
        }
      }
    }
    AppMethodBeat.o(143102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */