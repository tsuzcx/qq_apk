package com.tencent.mm.ui.widget.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceSeekBar
  extends RelativeLayout
{
  protected ImageView Lzu;
  protected float Lzv;
  protected int Lzw;
  protected View contentView;
  protected ImageView lvR;
  protected ImageView lvS;
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159692);
    this.contentView = null;
    this.lvS = null;
    this.Lzu = null;
    this.Lzv = 0.0F;
    this.Lzw = 0;
    init();
    AppMethodBeat.o(159692);
  }
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159693);
    this.contentView = null;
    this.lvS = null;
    this.Lzu = null;
    this.Lzv = 0.0F;
    this.Lzw = 0;
    init();
    AppMethodBeat.o(159693);
  }
  
  private void init()
  {
    AppMethodBeat.i(159694);
    this.contentView = View.inflate(getContext(), 2131495872, this);
    this.lvR = ((ImageView)this.contentView.findViewById(2131304488));
    this.lvS = ((ImageView)this.contentView.findViewById(2131304487));
    this.Lzu = ((ImageView)this.contentView.findViewById(2131304486));
    this.lvS.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(159691);
        VoiceSeekBar.this.lvS.getViewTreeObserver().removeOnPreDrawListener(this);
        VoiceSeekBar.this.Lzw = VoiceSeekBar.this.lvS.getHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)VoiceSeekBar.this.lvR.getLayoutParams();
        localLayoutParams.topMargin = ((int)((1.0F - VoiceSeekBar.this.Lzv) * VoiceSeekBar.this.Lzw));
        VoiceSeekBar.this.lvR.setLayoutParams(localLayoutParams);
        VoiceSeekBar.this.requestLayout();
        AppMethodBeat.o(159691);
        return false;
      }
    });
    AppMethodBeat.o(159694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.seekbar.VoiceSeekBar
 * JD-Core Version:    0.7.0.1
 */