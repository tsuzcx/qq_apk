package com.tencent.mm.plugin.music.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;

public class MusicSeekBar
  extends FrameLayout
{
  private Context context;
  boolean isLoading = false;
  private TextView mCe;
  private TextView mCf;
  private SeekBar mCg;
  ValueAnimator mCh;
  boolean mCi = false;
  c mCj;
  Drawable mCk;
  private MusicSeekBar.a mCl;
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MusicSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    paramContext = LayoutInflater.from(this.context).inflate(a.e.music_seek_bar, this);
    this.mCe = ((TextView)paramContext.findViewById(a.d.current_time));
    this.mCf = ((TextView)paramContext.findViewById(a.d.end_time));
    this.mCg = ((SeekBar)paramContext.findViewById(a.d.seek_bar));
    this.mCe.setText("00:00");
    this.mCf.setText("--:--");
    this.mCj = new c(getResources().getDrawable(a.c.music_seek_bar_loading));
    this.mCk = getResources().getDrawable(a.c.music_seek_bar_tumb);
  }
  
  private static String va(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long l1 = paramInt / 60000;
    long l2 = Math.floor(paramInt % 60000 / 1000L);
    if (l1 < 10L) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(l1 + ":");
    if (l2 < 10L) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(l2);
    return localStringBuilder.toString();
  }
  
  public final void hU(boolean paramBoolean)
  {
    if (this.mCh == null)
    {
      this.mCh = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
      this.mCh.setTarget(this.mCg);
      this.mCh.setRepeatCount(100);
      this.mCh.setDuration(5000L);
      this.mCh.setInterpolator(new LinearInterpolator());
      this.mCh.addUpdateListener(new MusicSeekBar.1(this));
    }
    this.isLoading = paramBoolean;
    if (paramBoolean)
    {
      this.mCh.start();
      return;
    }
    this.mCh.cancel();
    this.mCg.setThumb(this.mCk);
  }
  
  public void setColor(int paramInt)
  {
    this.mCe.setTextColor(paramInt);
    this.mCf.setTextColor(paramInt);
    this.mCg.getProgressDrawable().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.mCg.getThumb().setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.mCk.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.mCj.setColorFilter(paramInt, PorterDuff.Mode.MULTIPLY);
    this.mCg.setOnSeekBarChangeListener(new MusicSeekBar.2(this));
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.mCf.setText(va(paramInt));
    this.mCg.setMax(paramInt);
  }
  
  public void setOnSeekBarChange(MusicSeekBar.a parama)
  {
    this.mCl = parama;
  }
  
  public void setProgress(int paramInt)
  {
    if ((this.isLoading) || (this.mCi)) {
      return;
    }
    this.mCe.setText(va(paramInt));
    this.mCg.setProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicSeekBar
 * JD-Core Version:    0.7.0.1
 */