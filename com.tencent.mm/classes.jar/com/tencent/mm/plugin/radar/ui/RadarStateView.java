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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isShowing", "()Z", "isVisible", "ivState", "Landroid/widget/ImageView;", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "switchHandler", "com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1;", "trunOn", "init", "", "reset", "slideIn", "slideOut", "stateAlignment", "trunOff", "turnToState", "Companion", "plugin-radar_release"})
public final class RadarStateView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarStateView";
  static final int uTW = 300;
  public static final RadarStateView.a uTX;
  boolean cEL;
  c.e uSG;
  private final f uTM;
  private final f uTN;
  boolean uTT;
  final d uTU;
  private ImageView uTV;
  
  static
  {
    AppMethodBeat.i(138691);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(RadarStateView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), (d.l.k)w.a(new u(w.bk(RadarStateView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;")) };
    uTX = new RadarStateView.a((byte)0);
    TAG = "MicroMsg.RadarStateView";
    uTW = 300;
    AppMethodBeat.o(138691);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138699);
    this.uSG = c.e.uRR;
    this.uTT = true;
    this.uTU = new d(this);
    this.uTM = g.E((d.g.a.a)new c(this));
    this.uTN = g.E((d.g.a.a)new b(this));
    AppMethodBeat.o(138699);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138700);
    this.uSG = c.e.uRR;
    this.uTT = true;
    this.uTU = new d(this);
    this.uTM = g.E((d.g.a.a)new c(this));
    this.uTN = g.E((d.g.a.a)new b(this));
    AppMethodBeat.o(138700);
  }
  
  private final Animation getSlideInAnim()
  {
    AppMethodBeat.i(138694);
    Animation localAnimation = (Animation)this.uTN.getValue();
    AppMethodBeat.o(138694);
    return localAnimation;
  }
  
  private final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(138693);
    Animation localAnimation = (Animation)this.uTM.getValue();
    AppMethodBeat.o(138693);
    return localAnimation;
  }
  
  final void dfk()
  {
    AppMethodBeat.i(138695);
    ad.d(TAG, " state : " + this.uSG);
    if (!this.uTT)
    {
      setVisibility(8);
      AppMethodBeat.o(138695);
      return;
    }
    Object localObject = this.uSG;
    switch (f.ciE[localObject.ordinal()])
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
      localObject = this.uTV;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      ((ImageView)localObject).setImageResource(2131691073);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(2131691070);
      localObject = this.uTV;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      ((ImageView)localObject).setImageResource(2131691072);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(2131691070);
      localObject = this.uTV;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      ((ImageView)localObject).setImageResource(2131691071);
      setVisibility(0);
    }
  }
  
  public final void dfl()
  {
    AppMethodBeat.i(138697);
    if (!this.uTT)
    {
      AppMethodBeat.o(138697);
      return;
    }
    init();
    dfk();
    this.cEL = true;
    startAnimation(getSlideOutAnim());
    AppMethodBeat.o(138697);
  }
  
  public final void dfm()
  {
    AppMethodBeat.i(138698);
    if (!this.uTT)
    {
      AppMethodBeat.o(138698);
      return;
    }
    init();
    dfk();
    startAnimation(getSlideInAnim());
    AppMethodBeat.o(138698);
  }
  
  public final c.e getState()
  {
    return this.uSG;
  }
  
  final void init()
  {
    AppMethodBeat.i(138696);
    if (this.uTV == null)
    {
      this.uTV = new ImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 5), com.tencent.mm.cd.a.fromDPToPix(getContext(), 2));
      ImageView localImageView = this.uTV;
      if (localImageView != null) {
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      addView((View)this.uTV);
    }
    AppMethodBeat.o(138696);
  }
  
  public final void setState(c.e parame)
  {
    AppMethodBeat.i(138692);
    d.g.b.k.h(parame, "<set-?>");
    this.uSG = parame;
    AppMethodBeat.o(138692);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<Animation>
  {
    b(RadarStateView paramRadarStateView)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarStateView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarStateView.b paramb) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138683);
        d.g.b.k.h(paramAnimation, "animation");
        RadarStateView.b(this.uTZ.uTY);
        this.uTZ.uTY.setVisibility(8);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Animation>
  {
    c(RadarStateView paramRadarStateView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138690);
      d.g.b.k.h(paramMessage, "msg");
      RadarStateView.a(this.uTY);
      this.uTY.dfl();
      AppMethodBeat.o(138690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView
 * JD-Core Version:    0.7.0.1
 */