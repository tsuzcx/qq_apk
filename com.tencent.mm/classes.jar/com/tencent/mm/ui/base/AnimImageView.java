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
import com.tencent.mm.ui.at;

public class AnimImageView
  extends TextView
{
  private boolean ONW;
  private AnimationDrawable ONX;
  private Context context;
  private boolean isRunning;
  private AlphaAnimation qUh;
  private AnimationDrawable qUi;
  private int type;
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33857);
    this.isRunning = false;
    this.ONW = false;
    this.type = 1;
    this.context = paramContext;
    blc();
    AppMethodBeat.o(33857);
  }
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33858);
    this.isRunning = false;
    this.ONW = false;
    this.type = 1;
    this.context = paramContext;
    blc();
    AppMethodBeat.o(33858);
  }
  
  private void blc()
  {
    AppMethodBeat.i(33859);
    this.qUh = new AlphaAnimation(0.1F, 1.0F);
    this.qUh.setDuration(1000L);
    this.qUh.setRepeatCount(-1);
    this.qUh.setRepeatMode(2);
    this.qUi = new com.tencent.mm.ui.f.a();
    Drawable localDrawable = at.aN(getContext(), 2130968753);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    localDrawable = at.aN(getContext(), 2130968754);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    localDrawable = at.aN(getContext(), 2130968755);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.qUi.addFrame(localDrawable, 300);
    this.qUi.setOneShot(false);
    this.qUi.setVisible(true, true);
    this.ONX = new com.tencent.mm.ui.f.a();
    localDrawable = getResources().getDrawable(2131689943);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ONX.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689944);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ONX.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689945);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ONX.addFrame(localDrawable, 300);
    this.ONX.setOneShot(false);
    this.ONX.setVisible(true, true);
    AppMethodBeat.o(33859);
  }
  
  public final void bWT()
  {
    AppMethodBeat.i(33855);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(33855);
      return;
    case 2: 
      if (this.ONW) {
        setBackgroundResource(2131100101);
      }
    case 1: 
      while (!this.isRunning)
      {
        this.isRunning = true;
        if (!this.ONW) {
          break label114;
        }
        setCompoundDrawablesWithIntrinsicBounds(this.qUi, null, null, null);
        this.qUi.stop();
        this.qUi.start();
        AppMethodBeat.o(33855);
        return;
        setBackgroundResource(2131100102);
      }
      label114:
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.ONX, null);
      this.ONX.stop();
      this.ONX.start();
      AppMethodBeat.o(33855);
      return;
    }
    if (this.ONW) {
      setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231670));
    }
    for (;;)
    {
      setAnimation(this.qUh);
      this.qUh.startNow();
      break;
      setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231796));
    }
  }
  
  public final void cEA()
  {
    AppMethodBeat.i(33856);
    if ((this.qUh != null) && (this.qUh.isInitialized())) {
      setAnimation(null);
    }
    if ((this.type == 1) || (this.type == 2))
    {
      this.isRunning = false;
      setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.qUi.stop();
      this.ONX.stop();
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
    this.ONW = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(33854);
    this.type = paramInt;
    if (this.ONW)
    {
      if (paramInt == 2)
      {
        setBackgroundResource(2131100101);
        AppMethodBeat.o(33854);
        return;
      }
      setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231670));
      AppMethodBeat.o(33854);
      return;
    }
    if (paramInt == 2)
    {
      setBackgroundResource(2131100102);
      AppMethodBeat.o(33854);
      return;
    }
    setBackgroundDrawable(com.tencent.mm.cb.a.l(this.context, 2131231796));
    AppMethodBeat.o(33854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.AnimImageView
 * JD-Core Version:    0.7.0.1
 */