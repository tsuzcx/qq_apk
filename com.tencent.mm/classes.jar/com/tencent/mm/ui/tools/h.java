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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
{
  public g IRL;
  View IRM;
  private Rect IRN;
  Rect IRO;
  View IRP;
  private ViewTreeObserver.OnGlobalLayoutListener IRQ;
  private ViewTreeObserver.OnGlobalLayoutListener IRR;
  private boolean IRS;
  private int IRT;
  private int IRU;
  private int IRV;
  private int IRW;
  private Activity activity;
  private boolean cBT;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(143101);
    this.IRN = new Rect();
    this.IRO = new Rect();
    this.cBT = false;
    this.IRS = true;
    this.activity = paramActivity;
    if ((paramActivity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
    {
      ac.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
      this.IRS = false;
    }
    this.IRP = paramActivity.findViewById(16908290);
    this.IRQ = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143099);
        if (h.this.IRM != null) {
          h.a(h.this);
        }
        AppMethodBeat.o(143099);
      }
    };
    this.IRR = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143100);
        if (h.this.IRM != null)
        {
          int i = h.this.IRO.bottom;
          h.this.IRP.getWindowVisibleDisplayFrame(h.this.IRO);
          if (h.this.IRO.bottom != i)
          {
            ac.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", new Object[] { Integer.valueOf(i), h.this.IRO.toShortString() });
            h.a(h.this);
          }
        }
        AppMethodBeat.o(143100);
      }
    };
    int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      this.IRV = Resources.getSystem().getDimensionPixelSize(i);
    }
    this.IRW = a.fromDPToPix(paramActivity, 96);
    AppMethodBeat.o(143101);
  }
  
  public final void close()
  {
    AppMethodBeat.i(143103);
    ac.i("MicroMsg.KeyboardHeightProvider", "close: ");
    this.IRP.getViewTreeObserver().removeOnGlobalLayoutListener(this.IRR);
    if ((this.cBT) && (this.IRM != null)) {
      this.IRM.getViewTreeObserver().removeOnGlobalLayoutListener(this.IRQ);
    }
    try
    {
      this.activity.getWindowManager().removeView(this.IRM);
      this.IRM = null;
      this.cBT = false;
      AppMethodBeat.o(143103);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
      }
    }
  }
  
  public final void setKeyboardHeightObserver(g paramg)
  {
    this.IRL = paramg;
  }
  
  public final void start()
  {
    AppMethodBeat.i(143102);
    if (this.IRP != null)
    {
      ac.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", new Object[] { Boolean.valueOf(this.cBT), this.IRP.getWindowToken() });
      if ((!this.cBT) && (this.IRP.getWindowToken() != null) && (!this.activity.isFinishing()))
      {
        this.cBT = true;
        this.IRM = new LinearLayout(this.activity);
        this.IRM.setBackgroundColor(0);
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
        localLayoutParams.width = 0;
        localLayoutParams.height = -1;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.softInputMode = 16;
        localLayoutParams.setTitle("KeyboardWindow@" + hashCode());
        try
        {
          this.activity.getWindowManager().addView(this.IRM, localLayoutParams);
          if (this.cBT)
          {
            this.IRM.getViewTreeObserver().addOnGlobalLayoutListener(this.IRQ);
            this.IRP.getViewTreeObserver().addOnGlobalLayoutListener(this.IRR);
          }
          this.IRT = 0;
          this.IRU = 0;
          if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
          {
            ac.w("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
            this.IRS = false;
            AppMethodBeat.o(143102);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
            this.cBT = false;
            this.IRM = null;
          }
          this.IRS = true;
        }
      }
    }
    AppMethodBeat.o(143102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */