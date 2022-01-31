package com.tencent.mm.plugin.radar.ui;

import a.b;
import a.c;
import a.d.a.a;
import a.d.b.g;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.radar.a.e;
import com.tencent.mm.plugin.radar.b.e.a;

public final class RadarStateChooseView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.Radar.RadarStateChooseView";
  public static final a nmG = new a((byte)0);
  boolean nmB;
  private final b nmC = c.f((a)new RadarStateChooseView.c(this));
  private final b nmD = c.f((a)new RadarStateChooseView.b(this));
  boolean nmE = true;
  e.a nmF = e.a.nlr;
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  final void buK()
  {
    e.a locala = this.nmF;
    switch (e.fHS[locala.ordinal()])
    {
    default: 
      setVisibility(4);
      return;
    case 1: 
      setVisibility(4);
      return;
    }
    setBackgroundResource(a.e.radar_select);
    setVisibility(0);
  }
  
  public final e.a getMStatus()
  {
    return this.nmF;
  }
  
  final Animation getSlideInAnim()
  {
    return (Animation)this.nmD.getValue();
  }
  
  final Animation getSlideOutAnim()
  {
    return (Animation)this.nmC.getValue();
  }
  
  public final void setMStatus(e.a parama)
  {
    g.k(parama, "<set-?>");
    this.nmF = parama;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateChooseView
 * JD-Core Version:    0.7.0.1
 */