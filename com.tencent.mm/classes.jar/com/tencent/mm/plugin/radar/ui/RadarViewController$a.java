package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", "index", "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", "init", "show", "plugin-radar_release"})
final class RadarViewController$a
{
  private int pTa;
  final boolean pTb;
  private final RadarViewController.a.a pTc;
  
  public RadarViewController$a()
  {
    AppMethodBeat.i(103085);
    g localg = g.pSH;
    Context localContext = localContext.getContext();
    j.p(localContext, "context");
    this.pTb = g.eM(localContext);
    this.pTc = new RadarViewController.a.a(this);
    AppMethodBeat.o(103085);
  }
  
  private final int dv(View paramView)
  {
    AppMethodBeat.i(103084);
    Object localObject = paramView.getTag(RadarViewController.a(this.pTd));
    paramView = localObject;
    if (!(localObject instanceof Integer)) {
      paramView = null;
    }
    paramView = (Integer)paramView;
    if (paramView != null)
    {
      int i = paramView.intValue();
      AppMethodBeat.o(103084);
      return i;
    }
    AppMethodBeat.o(103084);
    return -1;
  }
  
  public final int cff()
  {
    this.pTa += 1;
    return this.pTa;
  }
  
  public final void ck(View paramView)
  {
    AppMethodBeat.i(103083);
    j.q(paramView, "view");
    int i = dv(paramView);
    if (i > 0) {
      this.pTc.removeMessages(i);
    }
    paramView.clearAnimation();
    AppMethodBeat.o(103083);
  }
  
  public final void g(int paramInt, View paramView)
  {
    AppMethodBeat.i(103082);
    j.q(paramView, "view");
    Message localMessage = this.pTc.obtainMessage();
    localMessage.what = dv(paramView);
    localMessage.obj = paramView;
    paramView.setVisibility(4);
    this.pTc.sendMessageDelayed(localMessage, (paramInt + 1) * 500);
    AppMethodBeat.o(103082);
  }
  
  public final Animation getInAnimation()
  {
    AppMethodBeat.i(103081);
    Animation localAnimation = AnimationUtils.loadAnimation(this.pTd.getContext(), 2131034239);
    j.p(localAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
    AppMethodBeat.o(103081);
    return localAnimation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.a
 * JD-Core Version:    0.7.0.1
 */