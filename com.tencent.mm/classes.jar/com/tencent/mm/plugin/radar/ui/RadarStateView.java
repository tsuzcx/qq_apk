package com.tencent.mm.plugin.radar.ui;

import a.b;
import a.c;
import a.d.b.g;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.radar.a.e;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.sdk.platformtools.y;

public final class RadarStateView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.RadarStateView";
  private static final int nmN = 300;
  public static final RadarStateView.a nmO = new RadarStateView.a((byte)0);
  c.e nlu = c.e.nkE;
  boolean nmB;
  private final b nmC = c.f((a.d.a.a)new RadarStateView.c(this));
  private final b nmD = c.f((a.d.a.a)new RadarStateView.b(this));
  boolean nmK = true;
  final RadarStateView.d nmL = new RadarStateView.d(this);
  private ImageView nmM;
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final Animation getSlideInAnim()
  {
    return (Animation)this.nmD.getValue();
  }
  
  private final Animation getSlideOutAnim()
  {
    return (Animation)this.nmC.getValue();
  }
  
  private final void setShowing(boolean paramBoolean)
  {
    this.nmB = paramBoolean;
  }
  
  final void buK()
  {
    y.d(TAG, " state : " + this.nlu);
    if (!this.nmK)
    {
      setVisibility(8);
      return;
    }
    Object localObject = this.nlu;
    switch (f.fHS[localObject.ordinal()])
    {
    default: 
      return;
    case 1: 
      setVisibility(8);
      return;
    case 2: 
      setBackgroundResource(a.e.radar_search_blue_bg);
      localObject = this.nmM;
      if (localObject == null) {
        g.cUk();
      }
      ((ImageView)localObject).setImageResource(a.e.radar_search_waiting);
      setVisibility(0);
      return;
    case 3: 
      setBackgroundResource(a.e.radar_search_green_bg);
      localObject = this.nmM;
      if (localObject == null) {
        g.cUk();
      }
      ((ImageView)localObject).setImageResource(a.e.radar_search_ok);
      setVisibility(0);
      return;
    }
    setBackgroundResource(a.e.radar_search_green_bg);
    localObject = this.nmM;
    if (localObject == null) {
      g.cUk();
    }
    ((ImageView)localObject).setImageResource(a.e.radar_search_hi);
    setVisibility(0);
  }
  
  public final void buL()
  {
    if (!this.nmK) {
      return;
    }
    init();
    buK();
    this.nmB = true;
    startAnimation(getSlideOutAnim());
  }
  
  public final void buM()
  {
    if (!this.nmK) {
      return;
    }
    init();
    buK();
    startAnimation(getSlideInAnim());
  }
  
  public final c.e getState()
  {
    return this.nlu;
  }
  
  final void init()
  {
    if (this.nmM == null)
    {
      this.nmM = new ImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5), com.tencent.mm.cb.a.fromDPToPix(getContext(), 2));
      ImageView localImageView = this.nmM;
      if (localImageView != null) {
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      addView((View)this.nmM);
    }
  }
  
  public final void setState(c.e parame)
  {
    g.k(parame, "<set-?>");
    this.nlu = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView
 * JD-Core Version:    0.7.0.1
 */