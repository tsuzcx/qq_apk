package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.y;

public final class RadarWaveView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarWaveView";
  public static final RadarWaveView.a nol = new RadarWaveView.a((byte)0);
  MediaPlayer noi;
  View noj;
  Animation nok;
  
  public RadarWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void buU()
  {
    y.d(TAG, "start wave animation");
    setVisibility(0);
    View localView = this.noj;
    if (localView == null) {
      g.cUk();
    }
    localView.startAnimation(this.nok);
  }
  
  public final void buV()
  {
    y.d(TAG, "stop wave animation. forces, %d, %d", new Object[] { Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()) });
    setVisibility(4);
    View localView = this.noj;
    if (localView == null) {
      g.cUk();
    }
    localView.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarWaveView
 * JD-Core Version:    0.7.0.1
 */