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
import com.tencent.mm.sdk.platformtools.Log;

public final class h
{
  public g Quk;
  View Qul;
  private Rect Qum;
  Rect Qun;
  View Quo;
  private ViewTreeObserver.OnGlobalLayoutListener Qup;
  private ViewTreeObserver.OnGlobalLayoutListener Quq;
  private boolean Qur;
  private int Qus;
  private int Qut;
  private int Quu;
  private int Quv;
  private Activity activity;
  private boolean ddZ;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(143101);
    this.Qum = new Rect();
    this.Qun = new Rect();
    this.ddZ = false;
    this.Qur = true;
    this.activity = paramActivity;
    if ((paramActivity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
    {
      Log.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
      this.Qur = false;
    }
    this.Quo = paramActivity.findViewById(16908290);
    this.Qup = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143099);
        if (h.this.Qul != null) {
          h.a(h.this);
        }
        AppMethodBeat.o(143099);
      }
    };
    this.Quq = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143100);
        if (h.this.Qul != null)
        {
          int i = h.this.Qun.bottom;
          h.this.Quo.getWindowVisibleDisplayFrame(h.this.Qun);
          if (h.this.Qun.bottom != i)
          {
            Log.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", new Object[] { Integer.valueOf(i), h.this.Qun.toShortString() });
            h.a(h.this);
          }
        }
        AppMethodBeat.o(143100);
      }
    };
    int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      this.Quu = Resources.getSystem().getDimensionPixelSize(i);
    }
    this.Quv = a.fromDPToPix(paramActivity, 96);
    AppMethodBeat.o(143101);
  }
  
  public final void close()
  {
    AppMethodBeat.i(143103);
    Log.i("MicroMsg.KeyboardHeightProvider", "close: ");
    this.Quo.getViewTreeObserver().removeOnGlobalLayoutListener(this.Quq);
    if ((this.ddZ) && (this.Qul != null)) {
      this.Qul.getViewTreeObserver().removeOnGlobalLayoutListener(this.Qup);
    }
    try
    {
      this.activity.getWindowManager().removeView(this.Qul);
      this.Qul = null;
      this.ddZ = false;
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
  
  public final void setKeyboardHeightObserver(g paramg)
  {
    this.Quk = paramg;
  }
  
  public final void start()
  {
    AppMethodBeat.i(143102);
    if (this.Quo != null)
    {
      Log.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", new Object[] { Boolean.valueOf(this.ddZ), this.Quo.getWindowToken() });
      if ((!this.ddZ) && (this.Quo.getWindowToken() != null) && (!this.activity.isFinishing()))
      {
        this.ddZ = true;
        this.Qul = new LinearLayout(this.activity);
        this.Qul.setBackgroundColor(0);
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
        localLayoutParams.width = 0;
        localLayoutParams.height = -1;
        localLayoutParams.gravity = 8388659;
        localLayoutParams.softInputMode = 16;
        localLayoutParams.setTitle("KeyboardWindow@" + hashCode());
        try
        {
          this.activity.getWindowManager().addView(this.Qul, localLayoutParams);
          if (this.ddZ)
          {
            this.Qul.getViewTreeObserver().addOnGlobalLayoutListener(this.Qup);
            this.Quo.getViewTreeObserver().addOnGlobalLayoutListener(this.Quq);
          }
          this.Qus = 0;
          this.Qut = 0;
          if ((this.activity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
          {
            Log.w("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
            this.Qur = false;
            AppMethodBeat.o(143102);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
            this.ddZ = false;
            this.Qul = null;
          }
          this.Qur = true;
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