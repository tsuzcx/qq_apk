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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.e.a;

public class AnimImageView
  extends TextView
{
  private boolean FUM;
  private AnimationDrawable FUN;
  private Context context;
  private boolean isRunning;
  private AlphaAnimation orc;
  private AnimationDrawable ord;
  private int type;
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33857);
    this.isRunning = false;
    this.FUM = false;
    this.type = 1;
    this.context = paramContext;
    aGa();
    AppMethodBeat.o(33857);
  }
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33858);
    this.isRunning = false;
    this.FUM = false;
    this.type = 1;
    this.context = paramContext;
    aGa();
    AppMethodBeat.o(33858);
  }
  
  private void aGa()
  {
    AppMethodBeat.i(33859);
    this.orc = new AlphaAnimation(0.1F, 1.0F);
    this.orc.setDuration(1000L);
    this.orc.setRepeatCount(-1);
    this.orc.setRepeatMode(2);
    this.ord = new a();
    Drawable localDrawable = ao.aC(getContext(), 2130968738);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ord.addFrame(localDrawable, 300);
    localDrawable = ao.aC(getContext(), 2130968739);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ord.addFrame(localDrawable, 300);
    localDrawable = ao.aC(getContext(), 2130968740);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.ord.addFrame(localDrawable, 300);
    this.ord.setOneShot(false);
    this.ord.setVisible(true, true);
    this.FUN = new a();
    localDrawable = getResources().getDrawable(2131689928);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.FUN.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689929);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.FUN.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131689930);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.FUN.addFrame(localDrawable, 300);
    this.FUN.setOneShot(false);
    this.FUN.setVisible(true, true);
    AppMethodBeat.o(33859);
  }
  
  public final void bTF()
  {
    AppMethodBeat.i(33856);
    if ((this.orc != null) && (this.orc.isInitialized())) {
      setAnimation(null);
    }
    if ((this.type == 1) || (this.type == 2))
    {
      this.isRunning = false;
      setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.ord.stop();
      this.FUN.stop();
    }
    AppMethodBeat.o(33856);
  }
  
  public final void eSq()
  {
    AppMethodBeat.i(33855);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(33855);
      return;
    case 2: 
      if (this.FUM) {
        setBackgroundResource(2131100073);
      }
    case 1: 
      while (!this.isRunning)
      {
        this.isRunning = true;
        if (!this.FUM) {
          break label114;
        }
        setCompoundDrawablesWithIntrinsicBounds(this.ord, null, null, null);
        this.ord.stop();
        this.ord.start();
        AppMethodBeat.o(33855);
        return;
        setBackgroundResource(2131100074);
      }
      label114:
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.FUN, null);
      this.FUN.stop();
      this.FUN.start();
      AppMethodBeat.o(33855);
      return;
    }
    if (this.FUM) {
      setBackgroundDrawable(ao.aC(this.context, 2130968736));
    }
    for (;;)
    {
      setAnimation(this.orc);
      this.orc.startNow();
      break;
      setBackgroundDrawable(ao.aC(this.context, 2130968741));
    }
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
    this.FUM = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(33854);
    this.type = paramInt;
    if (this.FUM)
    {
      if (paramInt == 2)
      {
        setBackgroundResource(2131100073);
        AppMethodBeat.o(33854);
        return;
      }
      setBackgroundDrawable(ao.aC(this.context, 2130968736));
      AppMethodBeat.o(33854);
      return;
    }
    if (paramInt == 2)
    {
      setBackgroundResource(2131100074);
      AppMethodBeat.o(33854);
      return;
    }
    setBackgroundDrawable(ao.aC(this.context, 2130968741));
    AppMethodBeat.o(33854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.AnimImageView
 * JD-Core Version:    0.7.0.1
 */