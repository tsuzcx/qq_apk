package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;

public class ScannerFlashSwitcher
  extends LinearLayout
{
  ImageView nNq;
  TextView nNr;
  boolean nNs = false;
  
  public ScannerFlashSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ScannerFlashSwitcher(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    com.tencent.mm.ui.y.gt(getContext()).inflate(R.i.scanner_flash_switcher, this, true);
    this.nNq = ((ImageView)findViewById(R.h.flash_switcher));
    this.nNr = ((TextView)findViewById(R.h.flash_open_hint));
    this.nNs = true;
  }
  
  public final void byd()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
    this.nNq.setImageResource(R.k.scanner_flash_open_normal);
  }
  
  public final void hide()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ScannerFlashSwitcher", "hide");
    setEnabled(false);
    this.nNq.animate().alpha(0.0F).setDuration(500L);
    this.nNr.animate().alpha(0.0F).setDuration(500L).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ScannerFlashSwitcher.this.setVisibility(8);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher
 * JD-Core Version:    0.7.0.1
 */