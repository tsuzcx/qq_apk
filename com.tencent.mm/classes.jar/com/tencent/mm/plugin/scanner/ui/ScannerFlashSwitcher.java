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
import com.tencent.mm.plugin.al.a.e;
import com.tencent.mm.plugin.al.a.f;
import com.tencent.mm.plugin.al.a.g;
import com.tencent.mm.plugin.al.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;

public class ScannerFlashSwitcher
  extends LinearLayout
{
  private ImageView Pcv;
  private TextView Pcw;
  private boolean Pcx;
  boolean fhR;
  public boolean hU;
  
  public ScannerFlashSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91061);
    this.Pcx = false;
    init();
    AppMethodBeat.o(91061);
  }
  
  public ScannerFlashSwitcher(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91062);
    this.Pcx = false;
    init();
    AppMethodBeat.o(91062);
  }
  
  private void init()
  {
    AppMethodBeat.i(91063);
    af.mU(getContext()).inflate(a.f.scanner_flash_switcher, this, true);
    this.Pcv = ((ImageView)findViewById(a.e.flash_switcher));
    this.Pcw = ((TextView)findViewById(a.e.flash_open_hint));
    this.Pcx = true;
    AppMethodBeat.o(91063);
  }
  
  public final void gSZ()
  {
    AppMethodBeat.i(91066);
    Log.i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
    this.hU = true;
    this.Pcv.setImageResource(a.g.scanner_flash_open_on);
    this.Pcw.setText(a.h.scan_flash_close_hint);
    AppMethodBeat.o(91066);
  }
  
  public final void gTa()
  {
    AppMethodBeat.i(91067);
    Log.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
    this.hU = false;
    this.Pcv.setImageResource(a.g.scanner_flash_open_normal);
    this.Pcw.setText(a.h.scan_flash_open_hint);
    AppMethodBeat.o(91067);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(91065);
    Log.i("MicroMsg.ScannerFlashSwitcher", "hide");
    setEnabled(false);
    this.fhR = false;
    this.Pcv.animate().alpha(0.0F).setDuration(500L);
    this.Pcw.animate().alpha(0.0F).setDuration(500L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(91060);
        ScannerFlashSwitcher.this.setVisibility(8);
        AppMethodBeat.o(91060);
      }
    });
    this.hU = false;
    AppMethodBeat.o(91065);
  }
  
  public final void show()
  {
    AppMethodBeat.i(91064);
    Log.i("MicroMsg.ScannerFlashSwitcher", "show, isFirstShow: %s", new Object[] { Boolean.valueOf(this.Pcx) });
    this.fhR = true;
    if (this.Pcx)
    {
      this.Pcv.setAlpha(0.0F);
      this.Pcw.setAlpha(0.0F);
      setVisibility(0);
      this.Pcw.animate().alpha(1.0F).setListener(null).setDuration(500L);
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
      this.Pcx = false;
    }
    for (;;)
    {
      setEnabled(true);
      AppMethodBeat.o(91064);
      return;
      setVisibility(0);
      this.Pcw.animate().alpha(1.0F).setDuration(500L).setListener(null).start();
      this.Pcv.animate().alpha(1.0F).setDuration(500L).setListener(null).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher
 * JD-Core Version:    0.7.0.1
 */