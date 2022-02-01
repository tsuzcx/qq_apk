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
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;

public class VoiceSeekBar
  extends RelativeLayout
{
  protected ImageView YtV;
  protected float YtW;
  protected int YtX;
  protected View contentView;
  protected ImageView pBZ;
  protected ImageView pCa;
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159692);
    this.contentView = null;
    this.pCa = null;
    this.YtV = null;
    this.YtW = 0.0F;
    this.YtX = 0;
    init();
    AppMethodBeat.o(159692);
  }
  
  public VoiceSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159693);
    this.contentView = null;
    this.pCa = null;
    this.YtV = null;
    this.YtW = 0.0F;
    this.YtX = 0;
    init();
    AppMethodBeat.o(159693);
  }
  
  private void init()
  {
    AppMethodBeat.i(159694);
    this.contentView = View.inflate(getContext(), a.g.voice_seek_bar, this);
    this.pBZ = ((ImageView)this.contentView.findViewById(a.f.seek_bar_front));
    this.pCa = ((ImageView)this.contentView.findViewById(a.f.seek_bar_background));
    this.YtV = ((ImageView)this.contentView.findViewById(a.f.seek_bar_IV));
    this.pCa.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(159691);
        VoiceSeekBar.this.pCa.getViewTreeObserver().removeOnPreDrawListener(this);
        VoiceSeekBar.this.YtX = VoiceSeekBar.this.pCa.getHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)VoiceSeekBar.this.pBZ.getLayoutParams();
        localLayoutParams.topMargin = ((int)((1.0F - VoiceSeekBar.this.YtW) * VoiceSeekBar.this.YtX));
        VoiceSeekBar.this.pBZ.setLayoutParams(localLayoutParams);
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