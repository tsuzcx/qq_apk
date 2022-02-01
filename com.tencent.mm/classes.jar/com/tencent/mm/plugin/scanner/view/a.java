package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator.AnimatorListener;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/view/IScanMaskView;", "", "animateShow", "", "show", "", "attachActivity", "activity", "Landroid/app/Activity;", "attachBackgroundView", "backgroundView", "Landroid/view/View;", "attachFlashSwitcherView", "flashSwitcher", "attachGalleryButton", "galleryButton", "attachScanCamera", "scanCamera", "Lcom/tencent/mm/plugin/scanner/camera/WxScanCamera;", "attachScanTipsView", "tipsView", "Landroid/widget/TextView;", "getTargetSuccessMarkView", "onBackPressed", "onNetworkChange", "state", "", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "scanResultAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "onShowNetworkLoading", "onShowNetworkUnconnectedView", "onShowNetworkWeakView", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "release", "setScanSource", "scanSource", "showLoadingView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "scan-sdk_release"})
public abstract interface a
{
  public abstract void a(Animator.AnimatorListener paramAnimatorListener);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.a
 * JD-Core Version:    0.7.0.1
 */