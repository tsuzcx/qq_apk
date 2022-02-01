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
import com.tencent.mm.sdk.platformtools.Log;

public final class i
{
  private Activity activity;
  public h afIL;
  private boolean fhR;
  View uJe;
  private Rect uJf;
  Rect uJg;
  View uJh;
  private ViewTreeObserver.OnGlobalLayoutListener uJj;
  private ViewTreeObserver.OnGlobalLayoutListener uJk;
  private boolean uJl;
  private int uJm;
  private int uJn;
  private int uJo;
  private int uJp;
  
  public i(Activity paramActivity)
  {
    AppMethodBeat.i(143101);
    this.uJf = new Rect();
    this.uJg = new Rect();
    this.fhR = false;
    this.uJl = true;
    this.activity = paramActivity;
    if ((paramActivity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
    {
      Log.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
      this.uJl = false;
    }
    this.uJh = paramActivity.findViewById(16908290);
    this.uJj = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143099);
        if (i.this.uJe != null) {
          i.a(i.this);
        }
        AppMethodBeat.o(143099);
      }
    };
    this.uJk = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143100);
        if (i.this.uJe != null)
        {
          int i = i.this.uJg.bottom;
          i.this.uJh.getWindowVisibleDisplayFrame(i.this.uJg);
          if (i.this.uJg.bottom != i)
          {
            Log.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", new Object[] { Integer.valueOf(i), i.this.uJg.toShortString() });
            i.a(i.this);
          }
        }
        AppMethodBeat.o(143100);
      }
    };
    int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      this.uJo = Resources.getSystem().getDimensionPixelSize(i);
    }
    this.uJp = a.fromDPToPix(paramActivity, 96);
    AppMethodBeat.o(143101);
  }
  
  public final void close()
  {
    AppMethodBeat.i(143103);
    Log.i("MicroMsg.KeyboardHeightProvider", "close: ");
    this.uJh.getViewTreeObserver().removeOnGlobalLayoutListener(this.uJk);
    if ((this.fhR) && (this.uJe != null)) {
      this.uJe.getViewTreeObserver().removeOnGlobalLayoutListener(this.uJj);
    }
    try
    {
      this.activity.getWindowManager().removeView(this.uJe);
      this.uJe = null;
      this.fhR = false;
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
  
  public final void start()
  {
    AppMethodBeat.i(143102);
    if (this.uJh != null)
    {
      Log.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", new Object[] { Boolean.valueOf(this.fhR), this.uJh.getWindowToken() });
      if ((!this.fhR) && (this.uJh.getWindowToken() != null) && (!this.activity.isFinishing()))
      {
        this.fhR = true;
        this.uJe = new LinearLayout(this.activity);
        this.uJe.setBackgroundColor(0);
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
        localLayoutParams.width = 0;
        localLayoutParams.height = -1;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.softInputMode = 16;
        localLayoutParams.setTitle("KeyboardWindow@" + hashCode());
        try
        {
          this.activity.getWindowManager().addView(this.uJe, localLayoutParams);
          if (this.fhR)
          {
            this.uJe.getViewTreeObserver().addOnGlobalLayoutListener(this.uJj);
            this.uJh.getViewTreeObserver().addOnGlobalLayoutListener(this.uJk);
          }
          this.uJm = 0;
          this.uJn = 0;
          if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
          {
            Log.w("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
            this.uJl = false;
            AppMethodBeat.o(143102);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
            this.fhR = false;
            this.uJe = null;
          }
          this.uJl = true;
        }
      }
    }
    AppMethodBeat.o(143102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.i
 * JD-Core Version:    0.7.0.1
 */