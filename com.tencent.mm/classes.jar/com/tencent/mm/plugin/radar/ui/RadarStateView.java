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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isShowing", "()Z", "isVisible", "ivState", "Landroid/widget/ImageView;", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "switchHandler", "com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1;", "trunOn", "init", "", "reset", "slideIn", "slideOut", "stateAlignment", "trunOff", "turnToState", "Companion", "plugin-radar_release"})
public final class RadarStateView
  extends RelativeLayout
{
  static final int BAs = 300;
  public static final RadarStateView.a BAt;
  static final String TAG = "MicroMsg.RadarStateView";
  private final f BAi;
  private final f BAj;
  boolean BAp;
  final d BAq;
  private ImageView BAr;
  c.e Bzc;
  boolean ddZ;
  
  static
  {
    AppMethodBeat.i(138691);
    BAt = new RadarStateView.a((byte)0);
    TAG = "MicroMsg.RadarStateView";
    BAs = 300;
    AppMethodBeat.o(138691);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138699);
    this.Bzc = c.e.Byp;
    this.BAp = true;
    this.BAq = new d(this);
    this.BAi = g.ah((kotlin.g.a.a)new c(this));
    this.BAj = g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(138699);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138700);
    this.Bzc = c.e.Byp;
    this.BAp = true;
    this.BAq = new d(this);
    this.BAi = g.ah((kotlin.g.a.a)new c(this));
    this.BAj = g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(138700);
  }
  
  private final Animation getSlideInAnim()
  {
    AppMethodBeat.i(138694);
    Animation localAnimation = (Animation)this.BAj.getValue();
    AppMethodBeat.o(138694);
    return localAnimation;
  }
  
  private final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(138693);
    Animation localAnimation = (Animation)this.BAi.getValue();
    AppMethodBeat.o(138693);
    return localAnimation;
  }
  
  final void eHt()
  {
    AppMethodBeat.i(138695);
    Log.d(TAG, " state : " + this.Bzc);
    if (!this.BAp)
    {
      setVisibility(8);
      AppMethodBeat.o(138695);
      return;
    }
    Object localObject = this.Bzc;
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
      setBackgroundResource(2131691371);
      localObject = this.BAr;
      if (localObject == null) {
        p.hyc();
      }
      ((ImageView)localObject).setImageResource(2131691375);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(2131691372);
      localObject = this.BAr;
      if (localObject == null) {
        p.hyc();
      }
      ((ImageView)localObject).setImageResource(2131691374);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(2131691372);
      localObject = this.BAr;
      if (localObject == null) {
        p.hyc();
      }
      ((ImageView)localObject).setImageResource(2131691373);
      setVisibility(0);
    }
  }
  
  public final void eHu()
  {
    AppMethodBeat.i(138697);
    if (!this.BAp)
    {
      AppMethodBeat.o(138697);
      return;
    }
    init();
    eHt();
    this.ddZ = true;
    startAnimation(getSlideOutAnim());
    AppMethodBeat.o(138697);
  }
  
  public final void eHv()
  {
    AppMethodBeat.i(138698);
    if (!this.BAp)
    {
      AppMethodBeat.o(138698);
      return;
    }
    init();
    eHt();
    startAnimation(getSlideInAnim());
    AppMethodBeat.o(138698);
  }
  
  public final c.e getState()
  {
    return this.Bzc;
  }
  
  final void init()
  {
    AppMethodBeat.i(138696);
    if (this.BAr == null)
    {
      this.BAr = new ImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5), com.tencent.mm.cb.a.fromDPToPix(getContext(), 2));
      ImageView localImageView = this.BAr;
      if (localImageView != null) {
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      addView((View)this.BAr);
    }
    AppMethodBeat.o(138696);
  }
  
  public final void setState(c.e parame)
  {
    AppMethodBeat.i(138692);
    p.h(parame, "<set-?>");
    this.Bzc = parame;
    AppMethodBeat.o(138692);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Animation>
  {
    b(RadarStateView paramRadarStateView)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarStateView$slideInAnim$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarStateView.b paramb) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138683);
        p.h(paramAnimation, "animation");
        RadarStateView.b(this.BAv.BAu);
        this.BAv.BAu.setVisibility(8);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Animation>
  {
    c(RadarStateView paramRadarStateView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138690);
      p.h(paramMessage, "msg");
      RadarStateView.a(this.BAu);
      this.BAu.eHu();
      AppMethodBeat.o(138690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView
 * JD-Core Version:    0.7.0.1
 */