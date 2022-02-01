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
import com.tencent.mm.R.d;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.ui.aw;

public class AnimImageView
  extends TextView
{
  private boolean Whh;
  private AnimationDrawable Whi;
  private Context context;
  private boolean isRunning;
  private int type;
  private AlphaAnimation uwn;
  private AnimationDrawable uwo;
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33857);
    this.isRunning = false;
    this.Whh = false;
    this.type = 1;
    this.context = paramContext;
    buR();
    AppMethodBeat.o(33857);
  }
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33858);
    this.isRunning = false;
    this.Whh = false;
    this.type = 1;
    this.context = paramContext;
    buR();
    AppMethodBeat.o(33858);
  }
  
  private void buR()
  {
    AppMethodBeat.i(33859);
    this.uwn = new AlphaAnimation(0.1F, 1.0F);
    this.uwn.setDuration(1000L);
    this.uwn.setRepeatCount(-1);
    this.uwn.setRepeatMode(2);
    this.uwo = new com.tencent.mm.ui.g.a();
    Drawable localDrawable = aw.bf(getContext(), R.d.chatfrom_voice_playing_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uwo.addFrame(localDrawable, 300);
    localDrawable = aw.bf(getContext(), R.d.chatfrom_voice_playing_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uwo.addFrame(localDrawable, 300);
    localDrawable = aw.bf(getContext(), R.d.chatfrom_voice_playing_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.uwo.addFrame(localDrawable, 300);
    this.uwo.setOneShot(false);
    this.uwo.setVisible(true, true);
    this.Whi = new com.tencent.mm.ui.g.a();
    localDrawable = getResources().getDrawable(R.k.chatto_voice_playing_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.Whi.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatto_voice_playing_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.Whi.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatto_voice_playing_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.Whi.addFrame(localDrawable, 300);
    this.Whi.setOneShot(false);
    this.Whi.setVisible(true, true);
    AppMethodBeat.o(33859);
  }
  
  public final void cTg()
  {
    AppMethodBeat.i(33856);
    if ((this.uwn != null) && (this.uwn.isInitialized())) {
      setAnimation(null);
    }
    if ((this.type == 1) || (this.type == 2))
    {
      this.isRunning = false;
      setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.uwo.stop();
      this.Whi.stop();
    }
    AppMethodBeat.o(33856);
  }
  
  public final void cjx()
  {
    AppMethodBeat.i(33855);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(33855);
      return;
    case 2: 
      if (this.Whh) {
        setBackgroundResource(R.e.bubble_chat_from_bg_color);
      }
    case 1: 
      while (!this.isRunning)
      {
        this.isRunning = true;
        if (!this.Whh) {
          break label116;
        }
        setCompoundDrawablesWithIntrinsicBounds(this.uwo, null, null, null);
        this.uwo.stop();
        this.uwo.start();
        AppMethodBeat.o(33855);
        return;
        setBackgroundResource(R.e.bubble_chat_to_bg_color);
      }
      label116:
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.Whi, null);
      this.Whi.stop();
      this.Whi.start();
      AppMethodBeat.o(33855);
      return;
    }
    if (this.Whh) {
      setBackgroundDrawable(com.tencent.mm.ci.a.m(this.context, R.g.chatfrom_bg));
    }
    for (;;)
    {
      setAnimation(this.uwn);
      this.uwn.startNow();
      break;
      setBackgroundDrawable(com.tencent.mm.ci.a.m(this.context, R.g.chatto_bg));
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
    this.Whh = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(33854);
    this.type = paramInt;
    if (this.Whh)
    {
      if (paramInt == 2)
      {
        setBackgroundResource(R.e.bubble_chat_from_bg_color);
        AppMethodBeat.o(33854);
        return;
      }
      setBackgroundDrawable(com.tencent.mm.ci.a.m(this.context, R.g.chatfrom_bg));
      AppMethodBeat.o(33854);
      return;
    }
    if (paramInt == 2)
    {
      setBackgroundResource(R.e.bubble_chat_to_bg_color);
      AppMethodBeat.o(33854);
      return;
    }
    setBackgroundDrawable(com.tencent.mm.ci.a.m(this.context, R.g.chatto_bg));
    AppMethodBeat.o(33854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.AnimImageView
 * JD-Core Version:    0.7.0.1
 */