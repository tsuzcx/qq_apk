package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.e.a;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isShowing", "", "mStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;)V", "mTrunOn", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "hide", "", "show", "stateAlignment", "trunOff", "trunOn", "trunToStatus", "status", "Companion", "plugin-radar_release"})
public final class RadarStateChooseView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.Radar.RadarStateChooseView";
  public static final a uTQ;
  boolean cEL;
  private final f uTM;
  private final f uTN;
  boolean uTO;
  e.a uTP;
  
  static
  {
    AppMethodBeat.i(138673);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(RadarStateChooseView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), (d.l.k)w.a(new u(w.bk(RadarStateChooseView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;")) };
    uTQ = new a((byte)0);
    TAG = "MicroMsg.Radar.RadarStateChooseView";
    AppMethodBeat.o(138673);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138678);
    this.uTM = g.E((a)new c(this));
    this.uTN = g.E((a)new b(this));
    this.uTO = true;
    this.uTP = e.a.uSD;
    AppMethodBeat.o(138678);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138679);
    this.uTM = g.E((a)new c(this));
    this.uTN = g.E((a)new b(this));
    this.uTO = true;
    this.uTP = e.a.uSD;
    AppMethodBeat.o(138679);
  }
  
  final void dfk()
  {
    AppMethodBeat.i(138677);
    e.a locala = this.uTP;
    switch (e.ciE[locala.ordinal()])
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
    setBackgroundResource(2131691074);
    setVisibility(0);
    AppMethodBeat.o(138677);
  }
  
  public final e.a getMStatus()
  {
    return this.uTP;
  }
  
  final Animation getSlideInAnim()
  {
    AppMethodBeat.i(138675);
    Animation localAnimation = (Animation)this.uTN.getValue();
    AppMethodBeat.o(138675);
    return localAnimation;
  }
  
  final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(138674);
    Animation localAnimation = (Animation)this.uTM.getValue();
    AppMethodBeat.o(138674);
    return localAnimation;
  }
  
  public final void setMStatus(e.a parama)
  {
    AppMethodBeat.i(138676);
    d.g.b.k.h(parama, "<set-?>");
    this.uTP = parama;
    AppMethodBeat.o(138676);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Animation>
  {
    b(RadarStateChooseView paramRadarStateChooseView)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarStateChooseView.b paramb) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138666);
        d.g.b.k.h(paramAnimation, "animation");
        RadarStateChooseView.a(this.uTS.uTR);
        this.uTS.uTR.setVisibility(8);
        AppMethodBeat.o(138666);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138667);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138667);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138665);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138665);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<Animation>
  {
    c(RadarStateChooseView paramRadarStateChooseView)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138670);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138670);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138671);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138671);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138669);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138669);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateChooseView
 * JD-Core Version:    0.7.0.1
 */