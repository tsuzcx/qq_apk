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
import com.tencent.mm.ui.bd;

public class AnimImageView
  extends TextView
{
  private boolean Uz;
  private AnimationDrawable adOd;
  private Context context;
  private boolean hBF;
  private int type;
  private AlphaAnimation xCM;
  private AnimationDrawable xCN;
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33857);
    this.Uz = false;
    this.hBF = false;
    this.type = 1;
    this.context = paramContext;
    bTa();
    AppMethodBeat.o(33857);
  }
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33858);
    this.Uz = false;
    this.hBF = false;
    this.type = 1;
    this.context = paramContext;
    bTa();
    AppMethodBeat.o(33858);
  }
  
  private void bTa()
  {
    AppMethodBeat.i(33859);
    this.xCM = new AlphaAnimation(0.1F, 1.0F);
    this.xCM.setDuration(1000L);
    this.xCM.setRepeatCount(-1);
    this.xCM.setRepeatMode(2);
    this.xCN = new com.tencent.mm.ui.g.a();
    Drawable localDrawable = bd.by(getContext(), R.d.chatfrom_voice_playing_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    localDrawable = bd.by(getContext(), R.d.chatfrom_voice_playing_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    localDrawable = bd.by(getContext(), R.d.chatfrom_voice_playing_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.xCN.addFrame(localDrawable, 300);
    this.xCN.setOneShot(false);
    this.xCN.setVisible(true, true);
    this.adOd = new com.tencent.mm.ui.g.a();
    localDrawable = getResources().getDrawable(R.k.chatto_voice_playing_f1);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.adOd.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatto_voice_playing_f2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.adOd.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.chatto_voice_playing_f3);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.adOd.addFrame(localDrawable, 300);
    this.adOd.setOneShot(false);
    this.adOd.setVisible(true, true);
    AppMethodBeat.o(33859);
  }
  
  public final void cKI()
  {
    AppMethodBeat.i(33855);
    switch (this.type)
    {
    default: 
      AppMethodBeat.o(33855);
      return;
    case 2: 
      if (this.hBF) {
        setBackgroundResource(R.e.bubble_chat_from_bg_color);
      }
    case 1: 
      while (!this.Uz)
      {
        this.Uz = true;
        if (!this.hBF) {
          break label116;
        }
        setCompoundDrawablesWithIntrinsicBounds(this.xCN, null, null, null);
        this.xCN.stop();
        this.xCN.start();
        AppMethodBeat.o(33855);
        return;
        setBackgroundResource(R.e.bubble_chat_to_bg_color);
      }
      label116:
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.adOd, null);
      this.adOd.stop();
      this.adOd.start();
      AppMethodBeat.o(33855);
      return;
    }
    if (this.hBF) {
      setBackgroundDrawable(com.tencent.mm.cd.a.m(this.context, R.g.chatfrom_bg));
    }
    for (;;)
    {
      setAnimation(this.xCM);
      this.xCM.startNow();
      break;
      setBackgroundDrawable(com.tencent.mm.cd.a.m(this.context, R.g.chatto_bg));
    }
  }
  
  public final void dxz()
  {
    AppMethodBeat.i(33856);
    if ((this.xCM != null) && (this.xCM.isInitialized())) {
      setAnimation(null);
    }
    if ((this.type == 1) || (this.type == 2))
    {
      this.Uz = false;
      setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.xCN.stop();
      this.adOd.stop();
    }
    AppMethodBeat.o(33856);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(33862);
    try
    {
      int i = super.getBaseline();
      return i;
    }
    finally
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
      return;
    }
    finally
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
      return;
    }
    finally
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
      return bool;
    }
    finally
    {
      AppMethodBeat.o(33863);
    }
    return true;
  }
  
  public void setFromGroup(boolean paramBoolean) {}
  
  public void setFromVoice(boolean paramBoolean)
  {
    this.hBF = paramBoolean;
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(33854);
    this.type = paramInt;
    if (this.hBF)
    {
      if (paramInt == 2)
      {
        setBackgroundResource(R.e.bubble_chat_from_bg_color);
        AppMethodBeat.o(33854);
        return;
      }
      setBackgroundDrawable(com.tencent.mm.cd.a.m(this.context, R.g.chatfrom_bg));
      AppMethodBeat.o(33854);
      return;
    }
    if (paramInt == 2)
    {
      setBackgroundResource(R.e.bubble_chat_to_bg_color);
      AppMethodBeat.o(33854);
      return;
    }
    setBackgroundDrawable(com.tencent.mm.cd.a.m(this.context, R.g.chatto_bg));
    AppMethodBeat.o(33854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.AnimImageView
 * JD-Core Version:    0.7.0.1
 */