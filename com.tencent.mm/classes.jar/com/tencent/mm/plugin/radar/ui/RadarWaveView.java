package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "audioPlayer", "Landroid/media/MediaPlayer;", "rotateAnim", "Landroid/view/animation/Animation;", "rotateWaveIV", "Landroid/view/View;", "init", "", "release", "startWaves", "stopWaves", "Companion", "plugin-radar_release"})
public final class RadarWaveView
  extends RelativeLayout
{
  public static final RadarWaveView.a Hxj;
  static final String TAG = "MicroMsg.RadarWaveView";
  MediaPlayer Hxg;
  View Hxh;
  Animation Hxi;
  
  static
  {
    AppMethodBeat.i(138789);
    Hxj = new RadarWaveView.a((byte)0);
    TAG = "MicroMsg.RadarWaveView";
    AppMethodBeat.o(138789);
  }
  
  public RadarWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138788);
    AppMethodBeat.o(138788);
  }
  
  public final void ftI()
  {
    AppMethodBeat.i(138786);
    Log.d(TAG, "start wave animation");
    setVisibility(0);
    View localView = this.Hxh;
    if (localView == null) {
      p.iCn();
    }
    localView.startAnimation(this.Hxi);
    AppMethodBeat.o(138786);
  }
  
  public final void ftJ()
  {
    AppMethodBeat.i(138787);
    Log.d(TAG, "stop wave animation. forces, %d, %d", new Object[] { Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()) });
    setVisibility(4);
    View localView = this.Hxh;
    if (localView == null) {
      p.iCn();
    }
    localView.clearAnimation();
    AppMethodBeat.o(138787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarWaveView
 * JD-Core Version:    0.7.0.1
 */