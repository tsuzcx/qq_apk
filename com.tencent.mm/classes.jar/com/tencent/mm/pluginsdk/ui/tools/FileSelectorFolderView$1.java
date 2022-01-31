package com.tencent.mm.pluginsdk.ui.tools;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

final class FileSelectorFolderView$1
  implements Animation.AnimationListener
{
  FileSelectorFolderView$1(FileSelectorFolderView paramFileSelectorFolderView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    FileSelectorFolderView.a(this.slV).setVisibility(8);
    FileSelectorFolderView.a(this.slV, false);
    FileSelectorFolderView.b(this.slV);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.1
 * JD-Core Version:    0.7.0.1
 */