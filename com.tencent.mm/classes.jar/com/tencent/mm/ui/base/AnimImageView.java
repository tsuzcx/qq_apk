package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aq;

public class AnimImageView
  extends TextView
{
  private boolean Jiq;
  private AnimationDrawable Jir;
  private Context context;
  private boolean isRunning;
  private AlphaAnimation pym;
  private AnimationDrawable pyn;
  private int type;
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33857);
    this.isRunning = false;
    this.Jiq = false;
    this.type = 1;
    this.context = paramContext;
    aPY();
    AppMethodBeat.o(33857);
  }
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33858);
    this.isRunning = false;
    this.Jiq = false;
    this.type = 1;
    this.context = paramContext;
    aPY();
    AppMethodBeat.o(33858);
  }
  
  private void aPY()
  {
    AppMethodBeat.i(33859);
    this.pym = new AlphaAnimation(0.1F, 1.0F);
    this.pym.setDuration(1000L);
    this.pym.setRepeatCount(-1);
    this.pym.setRepeatMode(2);
    this.pyn = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = aq.aM(getContext(), 2130968738);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    localDrawable = aq.aM(getContext(), 2130968739);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    localDrawable = aq.aM(getContext(), 2130968740);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pyn.addFrame(localDrawable, 300);
    this.pyn.setOneShot(false);
    this.pyn.setVisible(true, true);
    this.Jir = new com.tencent.mm.ui.e.a();
    localDrawable = getResources().getDrawable(2131689928);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.Jir.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689929);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.Jir.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689930);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.Jir.addFrame(localDrawable, 300);
    this.Jir.setOneShot(false);
    this.Jir.setVisible(true, true);
    AppMethodBeat.o(33859);
  }
  
  public final void bzc()
  {
    AppMethodBeat.i(33855);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(33855);
      return;
    case 2: 
      if (this.Jiq) {
        setBackgroundResource(2131100073);
      }
    case 1: 
      while (!this.isRunning)
      {
        this.isRunning = true;
        if (!this.Jiq) {
          break label114;
        }
        setCompoundDrawablesWithIntrinsicBounds(this.pyn, null, null, null);
        this.pyn.stop();
        this.pyn.start();
        AppMethodBeat.o(33855);
        return;
        setBackgroundResource(2131100074);
      }
      label114:
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.Jir, null);
      this.Jir.stop();
      this.Jir.start();
      AppMethodBeat.o(33855);
      return;
    }
    if (this.Jiq) {
      setBackgroundDrawable(com.tencent.mm.cc.a.l(this.context, 2131231606));
    }
    for (;;)
    {
      setAnimation(this.pym);
      this.pym.startNow();
      break;
      setBackgroundDrawable(com.tencent.mm.cc.a.l(this.context, 2131231725));
    }
  }
  
  public final void cfx()
  {
    AppMethodBeat.i(33856);
    if ((this.pym != null) && (this.pym.isInitialized())) {
      setAnimation(null);
    }
    if ((this.type == 1) || (this.type == 2))
    {
      this.isRunning = false;
      setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.pyn.stop();
      this.Jir.stop();
    }
    AppMethodBeat.o(33856);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(33862);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(33862);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(33862);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(33861);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(33861);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(33861);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33860);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(33860);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(33860);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(33863);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(33863);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(33863);
    }
    return true;
  }
  
  public void setFromGroup(boolean paramBoolean) {}
  
  public void setFromVoice(boolean paramBoolean)
  {
    this.Jiq = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(33854);
    this.type = paramInt;
    if (this.Jiq)
    {
      if (paramInt == 2)
      {
        setBackgroundResource(2131100073);
        AppMethodBeat.o(33854);
        return;
      }
      setBackgroundDrawable(com.tencent.mm.cc.a.l(this.context, 2131231606));
      AppMethodBeat.o(33854);
      return;
    }
    if (paramInt == 2)
    {
      setBackgroundResource(2131100074);
      AppMethodBeat.o(33854);
      return;
    }
    setBackgroundDrawable(com.tencent.mm.cc.a.l(this.context, 2131231725));
    AppMethodBeat.o(33854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.AnimImageView
 * JD-Core Version:    0.7.0.1
 */