package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ap;

public class MaskImageView
  extends TagImageView
{
  private int a;
  private int b;
  private boolean enable;
  private int g;
  private int r;
  private ap zOG;
  private Runnable zOH;
  
  public MaskImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97961);
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.enable = true;
    this.zOG = new ap(Looper.getMainLooper());
    this.zOH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97959);
        MaskImageView.this.setPressed(false);
        MaskImageView.this.invalidate();
        AppMethodBeat.o(97959);
      }
    };
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(97960);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/sns/ui/MaskImageView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (!MaskImageView.a(MaskImageView.this))
        {
          a.a(false, this, "com/tencent/mm/plugin/sns/ui/MaskImageView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(97960);
          return false;
        }
        boolean bool = MaskImageView.this.e(paramAnonymousView, paramAnonymousMotionEvent);
        a.a(bool, this, "com/tencent/mm/plugin/sns/ui/MaskImageView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(97960);
        return bool;
      }
    });
    super.setContentDescription(getContext().getResources().getString(2131763849));
    AppMethodBeat.o(97961);
  }
  
  public final boolean e(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97962);
    switch (paramMotionEvent.getAction())
    {
    }
    while ((!isClickable()) && (!isLongClickable()))
    {
      AppMethodBeat.o(97962);
      return true;
      paramView.setPressed(true);
      paramView.invalidate();
      this.zOG.removeCallbacks(this.zOH);
      continue;
      this.zOG.post(this.zOH);
    }
    AppMethodBeat.o(97962);
    return false;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(97964);
    super.onAttachedToWindow();
    AppMethodBeat.o(97964);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(97965);
    super.onDetachedFromWindow();
    AppMethodBeat.o(97965);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(97963);
    super.onDraw(paramCanvas);
    if (isPressed()) {
      paramCanvas.drawARGB(this.a, this.r, this.g, this.b);
    }
    AppMethodBeat.o(97963);
  }
  
  public void settouchEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskImageView
 * JD-Core Version:    0.7.0.1
 */