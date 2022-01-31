package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.plugin.radar.a.a;

final class RadarViewController$a
{
  private int nnM;
  final boolean nnN;
  final RadarViewController.a.a nnO;
  
  public RadarViewController$a()
  {
    g localg = g.nnt;
    Context localContext = localContext.getContext();
    a.d.b.g.j(localContext, "context");
    this.nnN = g.dY(localContext);
    this.nnO = new RadarViewController.a.a(this);
  }
  
  public final int buT()
  {
    this.nnM += 1;
    return this.nnM;
  }
  
  final int cH(View paramView)
  {
    Object localObject = paramView.getTag(RadarViewController.a(this.nnP));
    paramView = localObject;
    if (!(localObject instanceof Integer)) {
      paramView = null;
    }
    paramView = (Integer)paramView;
    if (paramView != null) {
      return paramView.intValue();
    }
    return -1;
  }
  
  public final void f(int paramInt, View paramView)
  {
    a.d.b.g.k(paramView, "view");
    Message localMessage = this.nnO.obtainMessage();
    localMessage.what = cH(paramView);
    localMessage.obj = paramView;
    paramView.setVisibility(4);
    this.nnO.sendMessageDelayed(localMessage, (paramInt + 1) * 500);
  }
  
  public final Animation getInAnimation()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this.nnP.getContext(), a.a.radar_user_turn_out);
    a.d.b.g.j(localAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
    return localAnimation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.a
 * JD-Core Version:    0.7.0.1
 */