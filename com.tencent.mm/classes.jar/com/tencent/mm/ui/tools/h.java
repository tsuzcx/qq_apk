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
import com.tencent.mm.sdk.platformtools.ab;

public final class h
{
  private int AvA;
  public g Avp;
  View Avq;
  private Rect Avr;
  Rect Avs;
  View Avt;
  private ViewTreeObserver.OnGlobalLayoutListener Avu;
  private ViewTreeObserver.OnGlobalLayoutListener Avv;
  private boolean Avw;
  private int Avx;
  private int Avy;
  private int Avz;
  private Activity activity;
  private boolean bTs;
  
  public h(Activity paramActivity)
  {
    AppMethodBeat.i(142764);
    this.Avr = new Rect();
    this.Avs = new Rect();
    this.bTs = false;
    this.Avw = true;
    this.activity = paramActivity;
    if ((paramActivity.getWindow().getAttributes().softInputMode & 0xF0) != 48)
    {
      ab.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
      this.Avw = false;
    }
    this.Avt = paramActivity.findViewById(16908290);
    this.Avu = new h.1(this);
    this.Avv = new h.2(this);
    int i = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      this.Avz = Resources.getSystem().getDimensionPixelSize(i);
    }
    this.AvA = a.fromDPToPix(paramActivity, 96);
    AppMethodBeat.o(142764);
  }
  
  public final void close()
  {
    AppMethodBeat.i(142766);
    ab.i("MicroMsg.KeyboardHeightProvider", "close: ");
    this.Avt.getViewTreeObserver().removeOnGlobalLayoutListener(this.Avv);
    if ((this.bTs) && (this.Avq != null))
    {
      this.Avq.getViewTreeObserver().removeOnGlobalLayoutListener(this.Avu);
      this.activity.getWindowManager().removeView(this.Avq);
      this.Avq = null;
    }
    this.bTs = false;
    AppMethodBeat.o(142766);
  }
  
  public final void start()
  {
    AppMethodBeat.i(142765);
    ab.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", new Object[] { Boolean.valueOf(this.bTs), this.Avt.getWindowToken() });
    WindowManager.LayoutParams localLayoutParams;
    if ((!this.bTs) && (this.Avt.getWindowToken() != null) && (!this.activity.isFinishing()))
    {
      this.bTs = true;
      this.Avq = new LinearLayout(this.activity);
      this.Avq.setBackgroundColor(0);
      localLayoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
      localLayoutParams.width = 0;
      localLayoutParams.height = -1;
      localLayoutParams.gravity = 8388659;
      localLayoutParams.softInputMode = 16;
      localLayoutParams.setTitle("KeyboardWindow@" + hashCode());
    }
    try
    {
      this.activity.getWindowManager().addView(this.Avq, localLayoutParams);
      if (this.bTs)
      {
        this.Avq.getViewTreeObserver().addOnGlobalLayoutListener(this.Avu);
        this.Avt.getViewTreeObserver().addOnGlobalLayoutListener(this.Avv);
      }
      this.Avx = 0;
      this.Avy = 0;
      AppMethodBeat.o(142765);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.KeyboardHeightProvider", localException, "", new Object[0]);
        this.bTs = false;
        this.Avq = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */