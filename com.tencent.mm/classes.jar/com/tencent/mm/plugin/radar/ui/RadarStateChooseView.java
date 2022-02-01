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
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isShowing", "", "mStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;)V", "mTrunOn", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "hide", "", "show", "stateAlignment", "trunOff", "trunOn", "trunToStatus", "status", "Companion", "plugin-radar_release"})
public final class RadarStateChooseView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.Radar.RadarStateChooseView";
  public static final a xko;
  boolean cMS;
  private final f xkk;
  private final f xkl;
  boolean xkm;
  e.a xkn;
  
  static
  {
    AppMethodBeat.i(138673);
    xko = new a((byte)0);
    TAG = "MicroMsg.Radar.RadarStateChooseView";
    AppMethodBeat.o(138673);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138678);
    this.xkk = g.O((a)new c(this));
    this.xkl = g.O((a)new b(this));
    this.xkm = true;
    this.xkn = e.a.xjb;
    AppMethodBeat.o(138678);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138679);
    this.xkk = g.O((a)new c(this));
    this.xkl = g.O((a)new b(this));
    this.xkm = true;
    this.xkn = e.a.xjb;
    AppMethodBeat.o(138679);
  }
  
  final void dDo()
  {
    AppMethodBeat.i(138677);
    e.a locala = this.xkn;
    switch (e.cpQ[locala.ordinal()])
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
    return this.xkn;
  }
  
  final Animation getSlideInAnim()
  {
    AppMethodBeat.i(138675);
    Animation localAnimation = (Animation)this.xkl.getValue();
    AppMethodBeat.o(138675);
    return localAnimation;
  }
  
  final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(138674);
    Animation localAnimation = (Animation)this.xkk.getValue();
    AppMethodBeat.o(138674);
    return localAnimation;
  }
  
  public final void setMStatus(e.a parama)
  {
    AppMethodBeat.i(138676);
    p.h(parama, "<set-?>");
    this.xkn = parama;
    AppMethodBeat.o(138676);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<Animation>
  {
    b(RadarStateChooseView paramRadarStateChooseView)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarStateChooseView.b paramb) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138666);
        p.h(paramAnimation, "animation");
        RadarStateChooseView.a(this.xkq.xkp);
        this.xkq.xkp.setVisibility(8);
        AppMethodBeat.o(138666);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138667);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(138667);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138665);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(138665);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements a<Animation>
  {
    c(RadarStateChooseView paramRadarStateChooseView)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarStateChooseView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138670);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(138670);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138671);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(138671);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138669);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(138669);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateChooseView
 * JD-Core Version:    0.7.0.1
 */