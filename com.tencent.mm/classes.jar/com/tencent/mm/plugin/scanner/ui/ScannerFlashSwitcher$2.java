package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;

final class ScannerFlashSwitcher$2
  extends AnimatorListenerAdapter
{
  ScannerFlashSwitcher$2(ScannerFlashSwitcher paramScannerFlashSwitcher) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    ScannerFlashSwitcher.a(this.nNt).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher.2
 * JD-Core Version:    0.7.0.1
 */