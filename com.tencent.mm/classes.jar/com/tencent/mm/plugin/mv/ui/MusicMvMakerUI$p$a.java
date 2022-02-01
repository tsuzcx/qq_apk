package com.tencent.mm.plugin.mv.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/MusicMvMakerUI$onCreate$5$onCancel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvMakerUI$p$a
  extends AnimatorListenerAdapter
{
  MusicMvMakerUI$p$a(MusicMvMakerUI paramMusicMvMakerUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(286474);
    MusicMvMakerUI.b(this.Mad).setAlpha(1.0F);
    MusicMvMakerUI.a(this.Mad).setVisibility(8);
    AppMethodBeat.o(286474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.MusicMvMakerUI.p.a
 * JD-Core Version:    0.7.0.1
 */