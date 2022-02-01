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
  protected ImageView QVk;
  protected float QVl;
  protected int QVm;
  protected View contentView;
  protected ImageView mCM;
  protected ImageView mCN;
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159692);
    this.contentView = null;
    this.mCN = null;
    this.QVk = null;
    this.QVl = 0.0F;
    this.QVm = 0;
    init();
    AppMethodBeat.o(159692);
  }
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159693);
    this.contentView = null;
    this.mCN = null;
    this.QVk = null;
    this.QVl = 0.0F;
    this.QVm = 0;
    init();
    AppMethodBeat.o(159693);
  }
  
  private void init()
  {
    AppMethodBeat.i(159694);
    this.contentView = View.inflate(getContext(), 2131496852, this);
    this.mCM = ((ImageView)this.contentView.findViewById(2131307485));
    this.mCN = ((ImageView)this.contentView.findViewById(2131307484));
    this.QVk = ((ImageView)this.contentView.findViewById(2131307483));
    this.mCN.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(159691);
        VoiceSeekBar.this.mCN.getViewTreeObserver().removeOnPreDrawListener(this);
        VoiceSeekBar.this.QVm = VoiceSeekBar.this.mCN.getHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)VoiceSeekBar.this.mCM.getLayoutParams();
        localLayoutParams.topMargin = ((int)((1.0F - VoiceSeekBar.this.QVl) * VoiceSeekBar.this.QVm));
        VoiceSeekBar.this.mCM.setLayoutParams(localLayoutParams);
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