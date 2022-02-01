package com.tencent.mm.plugin.mv.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$makeMediaThumbTransition$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvMakerUI$f
  extends AnimatorListenerAdapter
{
  MusicMvMakerUI$f(MusicMvMakerUI paramMusicMvMakerUI, a<ah> parama) {}
  
  private static final void h(MusicMvMakerUI paramMusicMvMakerUI)
  {
    AppMethodBeat.i(286443);
    s.u(paramMusicMvMakerUI, "this$0");
    MusicMvMakerUI.a(paramMusicMvMakerUI).setVisibility(8);
    AppMethodBeat.o(286443);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(286460);
    MusicMvMakerUI.b(this.Mad).animate().alpha(0.0F).setDuration(200L).withEndAction(new MusicMvMakerUI.f..ExternalSyntheticLambda0(this.Mad)).start();
    paramAnimator = this.GUX;
    if (paramAnimator != null) {
      paramAnimator.invoke();
    }
    AppMethodBeat.o(286460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerUI.f
 * JD-Core Version:    0.7.0.1
 */