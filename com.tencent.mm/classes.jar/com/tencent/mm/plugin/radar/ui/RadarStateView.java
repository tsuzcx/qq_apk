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
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isShowing", "()Z", "isVisible", "ivState", "Landroid/widget/ImageView;", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "switchHandler", "com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1;", "trunOn", "init", "", "reset", "slideIn", "slideOut", "stateAlignment", "trunOff", "turnToState", "Companion", "plugin-radar_release"})
public final class RadarStateView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarStateView";
  static final int xAr = 300;
  public static final RadarStateView.a xAs;
  boolean cNB;
  private final f xAh;
  private final f xAi;
  boolean xAo;
  final d xAp;
  private ImageView xAq;
  c.e xzb;
  
  static
  {
    AppMethodBeat.i(138691);
    xAs = new RadarStateView.a((byte)0);
    TAG = "MicroMsg.RadarStateView";
    xAr = 300;
    AppMethodBeat.o(138691);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138699);
    this.xzb = c.e.xym;
    this.xAo = true;
    this.xAp = new d(this);
    this.xAh = g.O((d.g.a.a)new c(this));
    this.xAi = g.O((d.g.a.a)new b(this));
    AppMethodBeat.o(138699);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138700);
    this.xzb = c.e.xym;
    this.xAo = true;
    this.xAp = new d(this);
    this.xAh = g.O((d.g.a.a)new c(this));
    this.xAi = g.O((d.g.a.a)new b(this));
    AppMethodBeat.o(138700);
  }
  
  private final Animation getSlideInAnim()
  {
    AppMethodBeat.i(138694);
    Animation localAnimation = (Animation)this.xAi.getValue();
    AppMethodBeat.o(138694);
    return localAnimation;
  }
  
  private final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(138693);
    Animation localAnimation = (Animation)this.xAh.getValue();
    AppMethodBeat.o(138693);
    return localAnimation;
  }
  
  final void dGF()
  {
    AppMethodBeat.i(138695);
    ae.d(TAG, " state : " + this.xzb);
    if (!this.xAo)
    {
      setVisibility(8);
      AppMethodBeat.o(138695);
      return;
    }
    Object localObject = this.xzb;
    switch (f.cqt[localObject.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138695);
      return;
      setVisibility(8);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(2131691069);
      localObject = this.xAq;
      if (localObject == null) {
        p.gkB();
      }
      ((ImageView)localObject).setImageResource(2131691073);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(2131691070);
      localObject = this.xAq;
      if (localObject == null) {
        p.gkB();
      }
      ((ImageView)localObject).setImageResource(2131691072);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(2131691070);
      localObject = this.xAq;
      if (localObject == null) {
        p.gkB();
      }
      ((ImageView)localObject).setImageResource(2131691071);
      setVisibility(0);
    }
  }
  
  public final void dGG()
  {
    AppMethodBeat.i(138697);
    if (!this.xAo)
    {
      AppMethodBeat.o(138697);
      return;
    }
    init();
    dGF();
    this.cNB = true;
    startAnimation(getSlideOutAnim());
    AppMethodBeat.o(138697);
  }
  
  public final void dGH()
  {
    AppMethodBeat.i(138698);
    if (!this.xAo)
    {
      AppMethodBeat.o(138698);
      return;
    }
    init();
    dGF();
    startAnimation(getSlideInAnim());
    AppMethodBeat.o(138698);
  }
  
  public final c.e getState()
  {
    return this.xzb;
  }
  
  final void init()
  {
    AppMethodBeat.i(138696);
    if (this.xAq == null)
    {
      this.xAq = new ImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5), com.tencent.mm.cb.a.fromDPToPix(getContext(), 2));
      ImageView localImageView = this.xAq;
      if (localImageView != null) {
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      addView((View)this.xAq);
    }
    AppMethodBeat.o(138696);
  }
  
  public final void setState(c.e parame)
  {
    AppMethodBeat.i(138692);
    p.h(parame, "<set-?>");
    this.xzb = parame;
    AppMethodBeat.o(138692);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Animation>
  {
    b(RadarStateView paramRadarStateView)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarStateView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarStateView.b paramb) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138683);
        p.h(paramAnimation, "animation");
        RadarStateView.b(this.xAu.xAt);
        this.xAu.xAt.setVisibility(8);
        AppMethodBeat.o(138683);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138684);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(138684);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138682);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(138682);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<Animation>
  {
    c(RadarStateView paramRadarStateView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends aq
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138690);
      p.h(paramMessage, "msg");
      RadarStateView.a(this.xAt);
      this.xAt.dGG();
      AppMethodBeat.o(138690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView
 * JD-Core Version:    0.7.0.1
 */