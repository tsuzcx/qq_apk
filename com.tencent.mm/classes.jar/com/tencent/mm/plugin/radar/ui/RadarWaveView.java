package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "audioPlayer", "Landroid/media/MediaPlayer;", "rotateAnim", "Landroid/view/animation/Animation;", "rotateWaveIV", "Landroid/view/View;", "init", "", "release", "startWaves", "stopWaves", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RadarWaveView
  extends RelativeLayout
{
  public static final RadarWaveView.a NuL;
  static final String TAG;
  MediaPlayer NuM;
  View NuN;
  Animation NuO;
  
  static
  {
    AppMethodBeat.i(138789);
    NuL = new RadarWaveView.a((byte)0);
    TAG = "MicroMsg.RadarWaveView";
    AppMethodBeat.o(138789);
  }
  
  public RadarWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138788);
    AppMethodBeat.o(138788);
  }
  
  public final void gFw()
  {
    AppMethodBeat.i(138786);
    Log.d(TAG, "start wave animation");
    setVisibility(0);
    View localView = this.NuN;
    s.checkNotNull(localView);
    localView.startAnimation(this.NuO);
    AppMethodBeat.o(138786);
  }
  
  public final void gFx()
  {
    AppMethodBeat.i(138787);
    Log.d(TAG, "stop wave animation. forces, %d, %d", new Object[] { Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()) });
    setVisibility(4);
    View localView = this.NuN;
    s.checkNotNull(localView);
    localView.clearAnimation();
    AppMethodBeat.o(138787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarWaveView
 * JD-Core Version:    0.7.0.1
 */