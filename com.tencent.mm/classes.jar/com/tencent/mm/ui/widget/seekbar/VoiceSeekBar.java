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
  protected ImageView LcT;
  protected float LcU;
  protected int LcV;
  protected View contentView;
  protected ImageView lrr;
  protected ImageView lrs;
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159692);
    this.contentView = null;
    this.lrs = null;
    this.LcT = null;
    this.LcU = 0.0F;
    this.LcV = 0;
    init();
    AppMethodBeat.o(159692);
  }
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159693);
    this.contentView = null;
    this.lrs = null;
    this.LcT = null;
    this.LcU = 0.0F;
    this.LcV = 0;
    init();
    AppMethodBeat.o(159693);
  }
  
  private void init()
  {
    AppMethodBeat.i(159694);
    this.contentView = View.inflate(getContext(), 2131495872, this);
    this.lrr = ((ImageView)this.contentView.findViewById(2131304488));
    this.lrs = ((ImageView)this.contentView.findViewById(2131304487));
    this.LcT = ((ImageView)this.contentView.findViewById(2131304486));
    this.lrs.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(159691);
        VoiceSeekBar.this.lrs.getViewTreeObserver().removeOnPreDrawListener(this);
        VoiceSeekBar.this.LcV = VoiceSeekBar.this.lrs.getHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)VoiceSeekBar.this.lrr.getLayoutParams();
        localLayoutParams.topMargin = ((int)((1.0F - VoiceSeekBar.this.LcU) * VoiceSeekBar.this.LcV));
        VoiceSeekBar.this.lrr.setLayoutParams(localLayoutParams);
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