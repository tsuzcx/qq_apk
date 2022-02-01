package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isShowing", "()Z", "isVisible", "ivState", "Landroid/widget/ImageView;", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "switchHandler", "com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1;", "trunOn", "init", "", "reset", "slideIn", "slideOut", "stateAlignment", "trunOff", "turnToState", "Companion", "plugin-radar_release"})
public final class RadarStateView
  extends RelativeLayout
{
  static final int HvN = 300;
  public static final RadarStateView.a HvO;
  static final String TAG = "MicroMsg.RadarStateView";
  b.e Huy;
  private final f HvD;
  private final f HvE;
  boolean HvK;
  final d HvL;
  private ImageView HvM;
  boolean dic;
  
  static
  {
    AppMethodBeat.i(138691);
    HvO = new RadarStateView.a((byte)0);
    TAG = "MicroMsg.RadarStateView";
    HvN = 300;
    AppMethodBeat.o(138691);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138699);
    this.Huy = b.e.HtM;
    this.HvK = true;
    this.HvL = new d(this);
    this.HvD = g.ar((kotlin.g.a.a)new c(this));
    this.HvE = g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(138699);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138700);
    this.Huy = b.e.HtM;
    this.HvK = true;
    this.HvL = new d(this);
    this.HvD = g.ar((kotlin.g.a.a)new c(this));
    this.HvE = g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(138700);
  }
  
  private final Animation getSlideInAnim()
  {
    AppMethodBeat.i(138694);
    Animation localAnimation = (Animation)this.HvE.getValue();
    AppMethodBeat.o(138694);
    return localAnimation;
  }
  
  private final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(138693);
    Animation localAnimation = (Animation)this.HvD.getValue();
    AppMethodBeat.o(138693);
    return localAnimation;
  }
  
  final void ftx()
  {
    AppMethodBeat.i(138695);
    Log.d(TAG, " state : " + this.Huy);
    if (!this.HvK)
    {
      setVisibility(8);
      AppMethodBeat.o(138695);
      return;
    }
    Object localObject = this.Huy;
    switch (f.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138695);
      return;
      setVisibility(8);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(a.f.radar_search_blue_bg);
      localObject = this.HvM;
      if (localObject == null) {
        p.iCn();
      }
      ((ImageView)localObject).setImageResource(a.f.radar_search_waiting);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(a.f.radar_search_green_bg);
      localObject = this.HvM;
      if (localObject == null) {
        p.iCn();
      }
      ((ImageView)localObject).setImageResource(a.f.radar_search_ok);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(a.f.radar_search_green_bg);
      localObject = this.HvM;
      if (localObject == null) {
        p.iCn();
      }
      ((ImageView)localObject).setImageResource(a.f.radar_search_hi);
      setVisibility(0);
    }
  }
  
  public final void fty()
  {
    AppMethodBeat.i(138697);
    if (!this.HvK)
    {
      AppMethodBeat.o(138697);
      return;
    }
    init();
    ftx();
    this.dic = true;
    startAnimation(getSlideOutAnim());
    AppMethodBeat.o(138697);
  }
  
  public final void ftz()
  {
    AppMethodBeat.i(138698);
    if (!this.HvK)
    {
      AppMethodBeat.o(138698);
      return;
    }
    init();
    ftx();
    startAnimation(getSlideInAnim());
    AppMethodBeat.o(138698);
  }
  
  public final b.e getState()
  {
    return this.Huy;
  }
  
  final void init()
  {
    AppMethodBeat.i(138696);
    if (this.HvM == null)
    {
      this.HvM = new ImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.ci.a.fromDPToPix(getContext(), 5), com.tencent.mm.ci.a.fromDPToPix(getContext(), 2));
      ImageView localImageView = this.HvM;
      if (localImageView != null) {
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      addView((View)this.HvM);
    }
    AppMethodBeat.o(138696);
  }
  
  public final void setState(b.e parame)
  {
    AppMethodBeat.i(138692);
    p.k(parame, "<set-?>");
    this.Huy = parame;
    AppMethodBeat.o(138692);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Animation>
  {
    b(RadarStateView paramRadarStateView)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarStateView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarStateView.b paramb) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138683);
        p.k(paramAnimation, "animation");
        RadarStateView.b(this.HvQ.HvP);
        this.HvQ.HvP.setVisibility(8);
        AppMethodBeat.o(138683);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138684);
        p.k(paramAnimation, "animation");
        AppMethodBeat.o(138684);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138682);
        p.k(paramAnimation, "animation");
        AppMethodBeat.o(138682);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Animation>
  {
    c(RadarStateView paramRadarStateView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138690);
      p.k(paramMessage, "msg");
      RadarStateView.a(this.HvP);
      this.HvP.fty();
      AppMethodBeat.o(138690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView
 * JD-Core Version:    0.7.0.1
 */