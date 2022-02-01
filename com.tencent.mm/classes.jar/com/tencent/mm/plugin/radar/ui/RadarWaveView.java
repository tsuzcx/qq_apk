package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "audioPlayer", "Landroid/media/MediaPlayer;", "rotateAnim", "Landroid/view/animation/Animation;", "rotateWaveIV", "Landroid/view/View;", "init", "", "release", "startWaves", "stopWaves", "Companion", "plugin-radar_release"})
public final class RadarWaveView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarWaveView";
  public static final RadarWaveView.a xlR;
  MediaPlayer xlO;
  View xlP;
  Animation xlQ;
  
  static
  {
    AppMethodBeat.i(138789);
    xlR = new RadarWaveView.a((byte)0);
    TAG = "MicroMsg.RadarWaveView";
    AppMethodBeat.o(138789);
  }
  
  public RadarWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138788);
    AppMethodBeat.o(138788);
  }
  
  public final void dDy()
  {
    AppMethodBeat.i(138786);
    ad.d(TAG, "start wave animation");
    setVisibility(0);
    View localView = this.xlP;
    if (localView == null) {
      p.gfZ();
    }
    localView.startAnimation(this.xlQ);
    AppMethodBeat.o(138786);
  }
  
  public final void dDz()
  {
    AppMethodBeat.i(138787);
    ad.d(TAG, "stop wave animation. forces, %d, %d", new Object[] { Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()) });
    setVisibility(4);
    View localView = this.xlP;
    if (localView == null) {
      p.gfZ();
    }
    localView.clearAnimation();
    AppMethodBeat.o(138787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarWaveView
 * JD-Core Version:    0.7.0.1
 */