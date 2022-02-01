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
import com.tencent.mm.sdk.platformtools.ad;

public final class h
{
  public g KIP;
  View KIQ;
  private Rect KIR;
  Rect KIS;
  View KIT;
  private ViewTreeObserver.OnGlobalLayoutListener KIU;
  private ViewTreeObserver.OnGlobalLayoutListener KIV;
  private boolean KIW;
  private int KIX;
  private int KIY;
  private int KIZ;
  private int KJa;
  private Activity activity;
  private boolean cMS;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(143101);
    this.KIR = new Rect();
    this.KIS = new Rect();
    this.cMS = false;
    this.KIW = true;
    this.activity = paramActivity;
    if ((paramActivity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
    {
      ad.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
      this.KIW = false;
    }
    this.KIT = paramActivity.findViewById(16908290);
    this.KIU = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143099);
        if (h.this.KIQ != null) {
          h.a(h.this);
        }
        AppMethodBeat.o(143099);
      }
    };
    this.KIV = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143100);
        if (h.this.KIQ != null)
        {
          int i = h.this.KIS.bottom;
          h.this.KIT.getWindowVisibleDisplayFrame(h.this.KIS);
          if (h.this.KIS.bottom != i)
          {
            ad.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", new Object[] { Integer.valueOf(i), h.this.KIS.toShortString() });
            h.a(h.this);
          }
        }
        AppMethodBeat.o(143100);
      }
    };
    int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      this.KIZ = Resources.getSystem().getDimensionPixelSize(i);
    }
    this.KJa = a.fromDPToPix(paramActivity, 96);
    AppMethodBeat.o(143101);
  }
  
  public final void close()
  {
    AppMethodBeat.i(143103);
    ad.i("MicroMsg.KeyboardHeightProvider", "close: ");
    this.KIT.getViewTreeObserver().removeOnGlobalLayoutListener(this.KIV);
    if ((this.cMS) && (this.KIQ != null)) {
      this.KIQ.getViewTreeObserver().removeOnGlobalLayoutListener(this.KIU);
    }
    try
    {
      this.activity.getWindowManager().removeView(this.KIQ);
      this.KIQ = null;
      this.cMS = false;
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
    this.KIP = paramg;
  }
  
  public final void start()
  {
    AppMethodBeat.i(143102);
    if (this.KIT != null)
    {
      ad.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", new Object[] { Boolean.valueOf(this.cMS), this.KIT.getWindowToken() });
      if ((!this.cMS) && (this.KIT.getWindowToken() != null) && (!this.activity.isFinishing()))
      {
        this.cMS = true;
        this.KIQ = new LinearLayout(this.activity);
        this.KIQ.setBackgroundColor(0);
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
        localLayoutParams.width = 0;
        localLayoutParams.height = -1;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.softInputMode = 16;
        localLayoutParams.setTitle("KeyboardWindow@" + hashCode());
        try
        {
          this.activity.getWindowManager().addView(this.KIQ, localLayoutParams);
          if (this.cMS)
          {
            this.KIQ.getViewTreeObserver().addOnGlobalLayoutListener(this.KIU);
            this.KIT.getViewTreeObserver().addOnGlobalLayoutListener(this.KIV);
          }
          this.KIX = 0;
          this.KIY = 0;
          if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
          {
            ad.w("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
            this.KIW = false;
            AppMethodBeat.o(143102);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
            this.cMS = false;
            this.KIQ = null;
          }
          this.KIW = true;
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