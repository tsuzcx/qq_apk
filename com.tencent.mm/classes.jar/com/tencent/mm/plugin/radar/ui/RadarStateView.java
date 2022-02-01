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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isShowing", "()Z", "isVisible", "ivState", "Landroid/widget/ImageView;", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "switchHandler", "com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1;", "trunOn", "init", "", "reset", "slideIn", "slideOut", "stateAlignment", "trunOff", "turnToState", "Companion", "plugin-radar_release"})
public final class RadarStateView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarStateView";
  static final int wcL = 300;
  public static final a wcM;
  boolean cBT;
  c.e wbv;
  private final f wcB;
  private final f wcC;
  boolean wcI;
  final d wcJ;
  private ImageView wcK;
  
  static
  {
    AppMethodBeat.i(138691);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(RadarStateView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), (d.l.k)w.a(new u(w.bn(RadarStateView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;")) };
    wcM = new a((byte)0);
    TAG = "MicroMsg.RadarStateView";
    wcL = 300;
    AppMethodBeat.o(138691);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138699);
    this.wbv = c.e.waG;
    this.wcI = true;
    this.wcJ = new d(this);
    this.wcB = g.K((d.g.a.a)new c(this));
    this.wcC = g.K((d.g.a.a)new b(this));
    AppMethodBeat.o(138699);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138700);
    this.wbv = c.e.waG;
    this.wcI = true;
    this.wcJ = new d(this);
    this.wcB = g.K((d.g.a.a)new c(this));
    this.wcC = g.K((d.g.a.a)new b(this));
    AppMethodBeat.o(138700);
  }
  
  private final Animation getSlideInAnim()
  {
    AppMethodBeat.i(138694);
    Animation localAnimation = (Animation)this.wcC.getValue();
    AppMethodBeat.o(138694);
    return localAnimation;
  }
  
  private final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(138693);
    Animation localAnimation = (Animation)this.wcB.getValue();
    AppMethodBeat.o(138693);
    return localAnimation;
  }
  
  final void dsR()
  {
    AppMethodBeat.i(138695);
    ac.d(TAG, " state : " + this.wbv);
    if (!this.wcI)
    {
      setVisibility(8);
      AppMethodBeat.o(138695);
      return;
    }
    Object localObject = this.wbv;
    switch (f.cfA[localObject.ordinal()])
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
      localObject = this.wcK;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      ((ImageView)localObject).setImageResource(2131691073);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(2131691070);
      localObject = this.wcK;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      ((ImageView)localObject).setImageResource(2131691072);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(2131691070);
      localObject = this.wcK;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      ((ImageView)localObject).setImageResource(2131691071);
      setVisibility(0);
    }
  }
  
  public final void dsS()
  {
    AppMethodBeat.i(138697);
    if (!this.wcI)
    {
      AppMethodBeat.o(138697);
      return;
    }
    init();
    dsR();
    this.cBT = true;
    startAnimation(getSlideOutAnim());
    AppMethodBeat.o(138697);
  }
  
  public final void dsT()
  {
    AppMethodBeat.i(138698);
    if (!this.wcI)
    {
      AppMethodBeat.o(138698);
      return;
    }
    init();
    dsR();
    startAnimation(getSlideInAnim());
    AppMethodBeat.o(138698);
  }
  
  public final c.e getState()
  {
    return this.wbv;
  }
  
  final void init()
  {
    AppMethodBeat.i(138696);
    if (this.wcK == null)
    {
      this.wcK = new ImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 5), com.tencent.mm.cc.a.fromDPToPix(getContext(), 2));
      ImageView localImageView = this.wcK;
      if (localImageView != null) {
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      addView((View)this.wcK);
    }
    AppMethodBeat.o(138696);
  }
  
  public final void setState(c.e parame)
  {
    AppMethodBeat.i(138692);
    d.g.b.k.h(parame, "<set-?>");
    this.wbv = parame;
    AppMethodBeat.o(138692);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarStateView$Companion;", "", "()V", "SlideAnimationDuring", "", "getSlideAnimationDuring", "()I", "TAG", "", "plugin-radar_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<Animation>
  {
    b(RadarStateView paramRadarStateView)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarStateView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarStateView.b paramb) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138683);
        d.g.b.k.h(paramAnimation, "animation");
        RadarStateView.b(this.wcO.wcN);
        this.wcO.wcN.setVisibility(8);
        AppMethodBeat.o(138683);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138684);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138684);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138682);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138682);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Animation>
  {
    c(RadarStateView paramRadarStateView)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarStateView$slideOutAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138687);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138687);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138688);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138688);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138686);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138686);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends ao
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138690);
      d.g.b.k.h(paramMessage, "msg");
      RadarStateView.a(this.wcN);
      this.wcN.dsS();
      AppMethodBeat.o(138690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView
 * JD-Core Version:    0.7.0.1
 */