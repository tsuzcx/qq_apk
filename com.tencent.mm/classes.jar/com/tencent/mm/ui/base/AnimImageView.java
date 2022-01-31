package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.cb.a;

public class AnimImageView
  extends TextView
{
  private Context context;
  private boolean isRunning = false;
  private AlphaAnimation kbs;
  private AnimationDrawable kbt;
  private int type = 1;
  private boolean uSI = false;
  private AnimationDrawable uSJ;
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    aRd();
  }
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    aRd();
  }
  
  private void aRd()
  {
    this.kbs = new AlphaAnimation(0.1F, 1.0F);
    this.kbs.setDuration(1000L);
    this.kbs.setRepeatCount(-1);
    this.kbs.setRepeatMode(2);
    this.kbt = new AnimationDrawable();
    Drawable localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.kbt.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.kbt.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatfrom_voice_playing_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.kbt.addFrame(localDrawable, 300);
    this.kbt.setOneShot(false);
    this.kbt.setVisible(true, true);
    this.uSJ = new AnimationDrawable();
    localDrawable = getResources().getDrawable(R.k.chatto_voice_playing_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uSJ.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatto_voice_playing_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uSJ.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatto_voice_playing_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uSJ.addFrame(localDrawable, 300);
    this.uSJ.setOneShot(false);
    this.uSJ.setVisible(true, true);
  }
  
  public final void bvP()
  {
    if ((this.kbs != null) && (this.kbs.isInitialized())) {
      setAnimation(null);
    }
    if ((this.type == 1) || (this.type == 2))
    {
      this.isRunning = false;
      setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.kbt.stop();
      this.uSJ.stop();
    }
  }
  
  public final void cAq()
  {
    switch (this.type)
    {
    default: 
      return;
    case 2: 
      if (this.uSI) {
        setBackgroundResource(R.e.bubble_chat_from_bg_color);
      }
    case 1: 
      while (!this.isRunning)
      {
        this.isRunning = true;
        if (!this.uSI) {
          break label102;
        }
        setCompoundDrawablesWithIntrinsicBounds(this.kbt, null, null, null);
        this.kbt.stop();
        this.kbt.start();
        return;
        setBackgroundResource(R.e.bubble_chat_to_bg_color);
      }
      label102:
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.uSJ, null);
      this.uSJ.stop();
      this.uSJ.start();
      return;
    }
    if (this.uSI) {
      setBackgroundDrawable(a.g(this.context, R.g.chatfrom_bg));
    }
    for (;;)
    {
      setAnimation(this.kbs);
      this.kbs.startNow();
      return;
      setBackgroundDrawable(a.g(this.context, R.g.chatto_bg));
    }
  }
  
  public int getBaseline()
  {
    try
    {
      int i = super.getBaseline();
      return i;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas) {}
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean onPreDraw()
  {
    try
    {
      boolean bool = super.onPreDraw();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public void setFromGroup(boolean paramBoolean) {}
  
  public void setFromVoice(boolean paramBoolean)
  {
    this.uSI = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
    if (this.uSI)
    {
      if (paramInt == 2)
      {
        setBackgroundResource(R.e.bubble_chat_from_bg_color);
        return;
      }
      setBackgroundDrawable(a.g(this.context, R.g.chatfrom_bg));
      return;
    }
    if (paramInt == 2)
    {
      setBackgroundResource(R.e.bubble_chat_to_bg_color);
      return;
    }
    setBackgroundDrawable(a.g(this.context, R.g.chatto_bg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.AnimImageView
 * JD-Core Version:    0.7.0.1
 */