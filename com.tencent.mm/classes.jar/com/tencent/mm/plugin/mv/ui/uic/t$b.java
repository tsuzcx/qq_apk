package com.tencent.mm.plugin.mv.ui.uic;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvSongInfoUIC$doAlphaAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "p0", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t$b
  implements Animation.AnimationListener
{
  t$b(View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(287938);
    this.$view.setAlpha(this.DLO);
    AppMethodBeat.o(287938);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.t.b
 * JD-Core Version:    0.7.0.1
 */