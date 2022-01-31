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

public class AnimImageView
  extends TextView
{
  private Context context;
  private boolean isRunning;
  private AlphaAnimation mvO;
  private AnimationDrawable mvP;
  private int type;
  private boolean zhj;
  private AnimationDrawable zhk;
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29999);
    this.isRunning = false;
    this.zhj = false;
    this.type = 1;
    this.context = paramContext;
    bxr();
    AppMethodBeat.o(29999);
  }
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(30000);
    this.isRunning = false;
    this.zhj = false;
    this.type = 1;
    this.context = paramContext;
    bxr();
    AppMethodBeat.o(30000);
  }
  
  private void bxr()
  {
    AppMethodBeat.i(30001);
    this.mvO = new AlphaAnimation(0.1F, 1.0F);
    this.mvO.setDuration(1000L);
    this.mvO.setRepeatCount(-1);
    this.mvO.setRepeatMode(2);
    this.mvP = new com.tencent.mm.ui.e.a();
    Drawable localDrawable = getResources().getDrawable(2131231094);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.mvP.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131231095);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.mvP.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131231096);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.mvP.addFrame(localDrawable, 300);
    this.mvP.setOneShot(false);
    this.mvP.setVisible(true, true);
    this.zhk = new com.tencent.mm.ui.e.a();
    localDrawable = getResources().getDrawable(2131231134);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.zhk.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131231135);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.zhk.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(2131231136);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.zhk.addFrame(localDrawable, 300);
    this.zhk.setOneShot(false);
    this.zhk.setVisible(true, true);
    AppMethodBeat.o(30001);
  }
  
  public final void cgf()
  {
    AppMethodBeat.i(29998);
    if ((this.mvO != null) && (this.mvO.isInitialized())) {
      setAnimation(null);
    }
    if ((this.type == 1) || (this.type == 2))
    {
      this.isRunning = false;
      setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.mvP.stop();
      this.zhk.stop();
    }
    AppMethodBeat.o(29998);
  }
  
  public final void dDA()
  {
    AppMethodBeat.i(29997);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(29997);
      return;
    case 2: 
      if (this.zhj) {
        setBackgroundResource(2131689813);
      }
    case 1: 
      while (!this.isRunning)
      {
        this.isRunning = true;
        if (!this.zhj) {
          break label116;
        }
        setCompoundDrawablesWithIntrinsicBounds(this.mvP, null, null, null);
        this.mvP.stop();
        this.mvP.start();
        AppMethodBeat.o(29997);
        return;
        setBackgroundResource(2131689814);
      }
      label116:
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.zhk, null);
      this.zhk.stop();
      this.zhk.start();
      AppMethodBeat.o(29997);
      return;
    }
    if (this.zhj) {
      setBackgroundDrawable(com.tencent.mm.cb.a.k(this.context, 2130838263));
    }
    for (;;)
    {
      setAnimation(this.mvO);
      this.mvO.startNow();
      break;
      setBackgroundDrawable(com.tencent.mm.cb.a.k(this.context, 2130838367));
    }
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(30004);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(30004);
      return i;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(30004);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(30003);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(30003);
      return;
    }
    catch (Throwable paramCanvas)
    {
      AppMethodBeat.o(30003);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30002);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(30002);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(30002);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(30005);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(30005);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(30005);
    }
    return true;
  }
  
  public void setFromGroup(boolean paramBoolean) {}
  
  public void setFromVoice(boolean paramBoolean)
  {
    this.zhj = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(29996);
    this.type = paramInt;
    if (this.zhj)
    {
      if (paramInt == 2)
      {
        setBackgroundResource(2131689813);
        AppMethodBeat.o(29996);
        return;
      }
      setBackgroundDrawable(com.tencent.mm.cb.a.k(this.context, 2130838263));
      AppMethodBeat.o(29996);
      return;
    }
    if (paramInt == 2)
    {
      setBackgroundResource(2131689814);
      AppMethodBeat.o(29996);
      return;
    }
    setBackgroundDrawable(com.tencent.mm.cb.a.k(this.context, 2130838367));
    AppMethodBeat.o(29996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.AnimImageView
 * JD-Core Version:    0.7.0.1
 */