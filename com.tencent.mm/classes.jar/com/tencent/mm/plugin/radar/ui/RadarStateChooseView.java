package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.d.a;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isShowing", "", "mStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;)V", "mTrunOn", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "hide", "", "show", "stateAlignment", "trunOff", "trunOn", "trunToStatus", "status", "Companion", "plugin-radar_release"})
public final class RadarStateChooseView
  extends RelativeLayout
{
  public static final RadarStateChooseView.a HvH;
  private static final String TAG = "MicroMsg.Radar.RadarStateChooseView";
  private final f HvD;
  private final f HvE;
  boolean HvF;
  d.a HvG;
  boolean dic;
  
  static
  {
    AppMethodBeat.i(138673);
    HvH = new RadarStateChooseView.a((byte)0);
    TAG = "MicroMsg.Radar.RadarStateChooseView";
    AppMethodBeat.o(138673);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138678);
    this.HvD = g.ar((a)new c(this));
    this.HvE = g.ar((a)new b(this));
    this.HvF = true;
    this.HvG = d.a.Huv;
    AppMethodBeat.o(138678);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138679);
    this.HvD = g.ar((a)new c(this));
    this.HvE = g.ar((a)new b(this));
    this.HvF = true;
    this.HvG = d.a.Huv;
    AppMethodBeat.o(138679);
  }
  
  final void ftx()
  {
    AppMethodBeat.i(138677);
    d.a locala = this.HvG;
    switch (e.$EnumSwitchMapping$0[locala.ordinal()])
    {
    default: 
      setVisibility(4);
      AppMethodBeat.o(138677);
      return;
    case 1: 
      setVisibility(4);
      AppMethodBeat.o(138677);
      return;
    }
    setBackgroundResource(a.f.radar_select);
    setVisibility(0);
    AppMethodBeat.o(138677);
  }
  
  public final d.a getMStatus()
  {
    return this.HvG;
  }
  
  final Animation getSlideInAnim()
  {
    AppMethodBeat.i(138675);
    Animation localAnimation = (Animation)this.HvE.getValue();
    AppMethodBeat.o(138675);
    return localAnimation;
  }
  
  final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(138674);
    Animation localAnimation = (Animation)this.HvD.getValue();
    AppMethodBeat.o(138674);
    return localAnimation;
  }
  
  public final void setMStatus(d.a parama)
  {
    AppMethodBeat.i(138676);
    p.k(parama, "<set-?>");
    this.HvG = parama;
    AppMethodBeat.o(138676);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<Animation>
  {
    b(RadarStateChooseView paramRadarStateChooseView)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarStateChooseView.b paramb) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138666);
        p.k(paramAnimation, "animation");
        RadarStateChooseView.a(this.HvJ.HvI);
        this.HvJ.HvI.setVisibility(8);
        AppMethodBeat.o(138666);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138667);
        p.k(paramAnimation, "animation");
        AppMethodBeat.o(138667);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138665);
        p.k(paramAnimation, "animation");
        AppMethodBeat.o(138665);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<Animation>
  {
    c(RadarStateChooseView paramRadarStateChooseView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateChooseView
 * JD-Core Version:    0.7.0.1
 */