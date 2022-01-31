package com.tencent.mm.pluginsdk.ui.tools;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FileSelectorFolderView$1
  implements Animation.AnimationListener
{
  FileSelectorFolderView$1(FileSelectorFolderView paramFileSelectorFolderView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(28158);
    FileSelectorFolderView.a(this.wex).setVisibility(8);
    FileSelectorFolderView.a(this.wex, false);
    FileSelectorFolderView.b(this.wex);
    AppMethodBeat.o(28158);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.1
 * JD-Core Version:    0.7.0.1
 */