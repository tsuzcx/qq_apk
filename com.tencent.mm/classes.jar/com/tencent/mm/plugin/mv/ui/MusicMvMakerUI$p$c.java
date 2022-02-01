package com.tencent.mm.plugin.mv.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$5$onConfirm$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvMakerUI$p$c
  extends AnimatorListenerAdapter
{
  MusicMvMakerUI$p$c(MusicMvMakerUI paramMusicMvMakerUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(286507);
    MusicMvMakerUI.a(this.Mad).setVisibility(8);
    AppMethodBeat.o(286507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerUI.p.c
 * JD-Core Version:    0.7.0.1
 */