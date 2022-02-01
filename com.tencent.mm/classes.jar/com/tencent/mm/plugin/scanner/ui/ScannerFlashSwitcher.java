package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.z;

public class ScannerFlashSwitcher
  extends LinearLayout
{
  public boolean Tz;
  boolean cBT;
  private ImageView xgl;
  private TextView xgm;
  private boolean xgn;
  
  public ScannerFlashSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91061);
    this.xgn = false;
    init();
    AppMethodBeat.o(91061);
  }
  
  public ScannerFlashSwitcher(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91062);
    this.xgn = false;
    init();
    AppMethodBeat.o(91062);
  }
  
  private void init()
  {
    AppMethodBeat.i(91063);
    z.jD(getContext()).inflate(2131495308, this, true);
    this.xgl = ((ImageView)findViewById(2131300127));
    this.xgm = ((TextView)findViewById(2131300126));
    this.xgn = true;
    AppMethodBeat.o(91063);
  }
  
  public final void dAK()
  {
    AppMethodBeat.i(91066);
    ac.i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
    this.Tz = true;
    this.xgl.setImageResource(2131691128);
    this.xgm.setText(2131762814);
    AppMethodBeat.o(91066);
  }
  
  public final void dAL()
  {
    AppMethodBeat.i(91067);
    ac.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
    this.Tz = false;
    this.xgl.setImageResource(2131691127);
    this.xgm.setText(2131762815);
    AppMethodBeat.o(91067);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(91065);
    ac.i("MicroMsg.ScannerFlashSwitcher", "hide");
    setEnabled(false);
    this.cBT = false;
    this.xgl.animate().alpha(0.0F).setDuration(500L);
    this.xgm.animate().alpha(0.0F).setDuration(500L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(91060);
        ScannerFlashSwitcher.this.setVisibility(8);
        AppMethodBeat.o(91060);
      }
    });
    this.Tz = false;
    AppMethodBeat.o(91065);
  }
  
  public final void show()
  {
    AppMethodBeat.i(91064);
    ac.i("MicroMsg.ScannerFlashSwitcher", "show, isFirstShow: %s", new Object[] { Boolean.valueOf(this.xgn) });
    this.cBT = true;
    if (this.xgn)
    {
      this.xgl.setAlpha(0.0F);
      this.xgm.setAlpha(0.0F);
      setVisibility(0);
      this.xgm.animate().alpha(1.0F).setListener(null).setDuration(500L);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(91058);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          ScannerFlashSwitcher.a(ScannerFlashSwitcher.this).setAlpha(f);
          AppMethodBeat.o(91058);
        }
      });
      localValueAnimator.setRepeatCount(3);
      localValueAnimator.setRepeatMode(2);
      localValueAnimator.setDuration(500L);
      localValueAnimator.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(91059);
          ScannerFlashSwitcher.a(ScannerFlashSwitcher.this).setAlpha(1.0F);
          AppMethodBeat.o(91059);
        }
      });
      localValueAnimator.start();
      this.xgn = false;
    }
    for (;;)
    {
      setEnabled(true);
      AppMethodBeat.o(91064);
      return;
      setVisibility(0);
      this.xgm.animate().alpha(1.0F).setDuration(500L).setListener(null).start();
      this.xgl.animate().alpha(1.0F).setDuration(500L).setListener(null).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher
 * JD-Core Version:    0.7.0.1
 */