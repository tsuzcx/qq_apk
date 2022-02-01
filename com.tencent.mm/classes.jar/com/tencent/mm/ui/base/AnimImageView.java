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
  private boolean JDe;
  private AnimationDrawable JDf;
  private Context context;
  private boolean isRunning;
  private AlphaAnimation pEQ;
  private AnimationDrawable pER;
  private int type;
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33857);
    this.isRunning = false;
    this.JDe = false;
    this.type = 1;
    this.context = paramContext;
    aQx();
    AppMethodBeat.o(33857);
  }
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33858);
    this.isRunning = false;
    this.JDe = false;
    this.type = 1;
    this.context = paramContext;
    aQx();
    AppMethodBeat.o(33858);
  }
  
  private void aQx()
  {
    AppMethodBeat.i(33859);
    this.pEQ = new AlphaAnimation(0.1F, 1.0F);
    this.pEQ.setDuration(1000L);
    this.pEQ.setRepeatCount(-1);
    this.pEQ.setRepeatMode(2);
    this.pER = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = aq.aM(getContext(), 2130968738);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    localDrawable = aq.aM(getContext(), 2130968739);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    localDrawable = aq.aM(getContext(), 2130968740);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.pER.addFrame(localDrawable, 300);
    this.pER.setOneShot(false);
    this.pER.setVisible(true, true);
    this.JDf = new com.tencent.mm.ui.e.a();
    localDrawable = getResources().getDrawable(2131689928);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.JDf.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689929);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.JDf.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689930);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.JDf.addFrame(localDrawable, 300);
    this.JDf.setOneShot(false);
    this.JDf.setVisible(true, true);
    AppMethodBeat.o(33859);
  }
  
  public final void bzX()
  {
    AppMethodBeat.i(33855);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(33855);
      return;
    case 2: 
      if (this.JDe) {
        setBackgroundResource(2131100073);
      }
    case 1: 
      while (!this.isRunning)
      {
        this.isRunning = true;
        if (!this.JDe) {
          break label114;
        }
        setCompoundDrawablesWithIntrinsicBounds(this.pER, null, null, null);
        this.pER.stop();
        this.pER.start();
        AppMethodBeat.o(33855);
        return;
        setBackgroundResource(2131100074);
      }
      label114:
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.JDf, null);
      this.JDf.stop();
      this.JDf.start();
      AppMethodBeat.o(33855);
      return;
    }
    if (this.JDe) {
      setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231606));
    }
    for (;;)
    {
      setAnimation(this.pEQ);
      this.pEQ.startNow();
      break;
      setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231725));
    }
  }
  
  public final void cgN()
  {
    AppMethodBeat.i(33856);
    if ((this.pEQ != null) && (this.pEQ.isInitialized())) {
      setAnimation(null);
    }
    if ((this.type == 1) || (this.type == 2))
    {
      this.isRunning = false;
      setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.pER.stop();
      this.JDf.stop();
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
    this.JDe = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(33854);
    this.type = paramInt;
    if (this.JDe)
    {
      if (paramInt == 2)
      {
        setBackgroundResource(2131100073);
        AppMethodBeat.o(33854);
        return;
      }
      setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231606));
      AppMethodBeat.o(33854);
      return;
    }
    if (paramInt == 2)
    {
      setBackgroundResource(2131100074);
      AppMethodBeat.o(33854);
      return;
    }
    setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231725));
    AppMethodBeat.o(33854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.AnimImageView
 * JD-Core Version:    0.7.0.1
 */