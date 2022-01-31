package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "audioPlayer", "Landroid/media/MediaPlayer;", "rotateAnim", "Landroid/view/animation/Animation;", "rotateWaveIV", "Landroid/view/View;", "init", "", "release", "startWaves", "stopWaves", "Companion", "plugin-radar_release"})
public final class RadarWaveView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarWaveView";
  public static final RadarWaveView.a pTz;
  MediaPlayer pTw;
  View pTx;
  Animation pTy;
  
  static
  {
    AppMethodBeat.i(103137);
    pTz = new RadarWaveView.a((byte)0);
    TAG = "MicroMsg.RadarWaveView";
    AppMethodBeat.o(103137);
  }
  
  public RadarWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103136);
    AppMethodBeat.o(103136);
  }
  
  public final void cfg()
  {
    AppMethodBeat.i(103134);
    ab.d(TAG, "start wave animation");
    setVisibility(0);
    View localView = this.pTx;
    if (localView == null) {
      j.ebi();
    }
    localView.startAnimation(this.pTy);
    AppMethodBeat.o(103134);
  }
  
  public final void cfh()
  {
    AppMethodBeat.i(103135);
    ab.d(TAG, "stop wave animation. forces, %d, %d", new Object[] { Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()) });
    setVisibility(4);
    View localView = this.pTx;
    if (localView == null) {
      j.ebi();
    }
    localView.clearAnimation();
    AppMethodBeat.o(103135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarWaveView
 * JD-Core Version:    0.7.0.1
 */