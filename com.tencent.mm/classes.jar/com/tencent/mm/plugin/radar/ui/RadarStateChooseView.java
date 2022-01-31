package com.tencent.mm.plugin.radar.ui;

import a.f;
import a.f.a.a;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.g;
import a.j.k;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.e.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isShowing", "", "mStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;)V", "mTrunOn", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "hide", "", "show", "stateAlignment", "trunOff", "trunOn", "trunToStatus", "status", "Companion", "plugin-radar_release"})
public final class RadarStateChooseView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.Radar.RadarStateChooseView";
  public static final RadarStateChooseView.a pRU;
  boolean bTs;
  private final f pRQ;
  private final f pRR;
  boolean pRS;
  e.a pRT;
  
  static
  {
    AppMethodBeat.i(103025);
    eOJ = new k[] { (k)v.a(new t(v.aG(RadarStateChooseView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), (k)v.a(new t(v.aG(RadarStateChooseView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;")) };
    pRU = new RadarStateChooseView.a((byte)0);
    TAG = "MicroMsg.Radar.RadarStateChooseView";
    AppMethodBeat.o(103025);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103030);
    this.pRQ = g.j((a)new RadarStateChooseView.c(this));
    this.pRR = g.j((a)new RadarStateChooseView.b(this));
    this.pRS = true;
    this.pRT = e.a.pQG;
    AppMethodBeat.o(103030);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103031);
    this.pRQ = g.j((a)new RadarStateChooseView.c(this));
    this.pRR = g.j((a)new RadarStateChooseView.b(this));
    this.pRS = true;
    this.pRT = e.a.pQG;
    AppMethodBeat.o(103031);
  }
  
  final void ceW()
  {
    AppMethodBeat.i(103029);
    e.a locala = this.pRT;
    switch (e.bLo[locala.ordinal()])
    {
    default: 
      setVisibility(4);
      AppMethodBeat.o(103029);
      return;
    case 1: 
      setVisibility(4);
      AppMethodBeat.o(103029);
      return;
    }
    setBackgroundResource(2131231903);
    setVisibility(0);
    AppMethodBeat.o(103029);
  }
  
  public final e.a getMStatus()
  {
    return this.pRT;
  }
  
  final Animation getSlideInAnim()
  {
    AppMethodBeat.i(103027);
    Animation localAnimation = (Animation)this.pRR.getValue();
    AppMethodBeat.o(103027);
    return localAnimation;
  }
  
  final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(103026);
    Animation localAnimation = (Animation)this.pRQ.getValue();
    AppMethodBeat.o(103026);
    return localAnimation;
  }
  
  public final void setMStatus(e.a parama)
  {
    AppMethodBeat.i(103028);
    j.q(parama, "<set-?>");
    this.pRT = parama;
    AppMethodBeat.o(103028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateChooseView
 * JD-Core Version:    0.7.0.1
 */