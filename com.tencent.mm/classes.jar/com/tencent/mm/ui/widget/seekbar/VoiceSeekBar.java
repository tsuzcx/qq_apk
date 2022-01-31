package com.tencent.mm.ui.widget.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceSeekBar
  extends RelativeLayout
{
  protected ImageView AKj;
  protected float AKk;
  protected int AKl;
  protected View contentView;
  protected ImageView qTC;
  protected ImageView qTD;
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112965);
    this.contentView = null;
    this.qTD = null;
    this.AKj = null;
    this.AKk = 0.0F;
    this.AKl = 0;
    init();
    AppMethodBeat.o(112965);
  }
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112966);
    this.contentView = null;
    this.qTD = null;
    this.AKj = null;
    this.AKk = 0.0F;
    this.AKl = 0;
    init();
    AppMethodBeat.o(112966);
  }
  
  private void init()
  {
    AppMethodBeat.i(112967);
    this.contentView = View.inflate(getContext(), 2130971102, this);
    this.qTC = ((ImageView)this.contentView.findViewById(2131828801));
    this.qTD = ((ImageView)this.contentView.findViewById(2131828800));
    this.AKj = ((ImageView)this.contentView.findViewById(2131828802));
    this.qTD.getViewTreeObserver().addOnPreDrawListener(new VoiceSeekBar.1(this));
    AppMethodBeat.o(112967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.seekbar.VoiceSeekBar
 * JD-Core Version:    0.7.0.1
 */