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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;

public class ScannerFlashSwitcher
  extends LinearLayout
{
  private ImageView COa;
  private TextView COb;
  private boolean COc;
  public boolean VC;
  boolean ddZ;
  
  public ScannerFlashSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91061);
    this.COc = false;
    init();
    AppMethodBeat.o(91061);
  }
  
  public ScannerFlashSwitcher(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91062);
    this.COc = false;
    init();
    AppMethodBeat.o(91062);
  }
  
  private void init()
  {
    AppMethodBeat.i(91063);
    aa.jQ(getContext()).inflate(2131496158, this, true);
    this.COa = ((ImageView)findViewById(2131301575));
    this.COb = ((TextView)findViewById(2131301571));
    this.COc = true;
    AppMethodBeat.o(91063);
  }
  
  public final void eRm()
  {
    AppMethodBeat.i(91066);
    Log.i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
    this.VC = true;
    this.COa.setImageResource(2131691436);
    this.COb.setText(2131764911);
    AppMethodBeat.o(91066);
  }
  
  public final void eRn()
  {
    AppMethodBeat.i(91067);
    Log.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
    this.VC = false;
    this.COa.setImageResource(2131691435);
    this.COb.setText(2131764912);
    AppMethodBeat.o(91067);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(91065);
    Log.i("MicroMsg.ScannerFlashSwitcher", "hide");
    setEnabled(false);
    this.ddZ = false;
    this.COa.animate().alpha(0.0F).setDuration(500L);
    this.COb.animate().alpha(0.0F).setDuration(500L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(91060);
        ScannerFlashSwitcher.this.setVisibility(8);
        AppMethodBeat.o(91060);
      }
    });
    this.VC = false;
    AppMethodBeat.o(91065);
  }
  
  public final void show()
  {
    AppMethodBeat.i(91064);
    Log.i("MicroMsg.ScannerFlashSwitcher", "show, isFirstShow: %s", new Object[] { Boolean.valueOf(this.COc) });
    this.ddZ = true;
    if (this.COc)
    {
      this.COa.setAlpha(0.0F);
      this.COb.setAlpha(0.0F);
      setVisibility(0);
      this.COb.animate().alpha(1.0F).setListener(null).setDuration(500L);
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
      this.COc = false;
    }
    for (;;)
    {
      setEnabled(true);
      AppMethodBeat.o(91064);
      return;
      setVisibility(0);
      this.COb.animate().alpha(1.0F).setDuration(500L).setListener(null).start();
      this.COa.animate().alpha(1.0F).setDuration(500L).setListener(null).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher
 * JD-Core Version:    0.7.0.1
 */