package com.tencent.mm.plugin.radar.ui;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.g;
import a.j.k;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isShowing", "()Z", "setShowing", "(Z)V", "isVisible", "ivState", "Landroid/widget/ImageView;", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "switchHandler", "com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1;", "trunOn", "init", "", "reset", "slideIn", "slideOut", "stateAlignment", "trunOff", "turnToState", "Companion", "plugin-radar_release"})
public final class RadarStateView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarStateView";
  static final int pSb = 300;
  public static final RadarStateView.a pSc;
  boolean bTs;
  c.e pQJ;
  private final f pRQ;
  private final f pRR;
  boolean pRY;
  final RadarStateView.d pRZ;
  private ImageView pSa;
  
  static
  {
    AppMethodBeat.i(103042);
    eOJ = new k[] { (k)v.a(new t(v.aG(RadarStateView.class), "slideOutAnim", "getSlideOutAnim()Landroid/view/animation/Animation;")), (k)v.a(new t(v.aG(RadarStateView.class), "slideInAnim", "getSlideInAnim()Landroid/view/animation/Animation;")) };
    pSc = new RadarStateView.a((byte)0);
    TAG = "MicroMsg.RadarStateView";
    pSb = 300;
    AppMethodBeat.o(103042);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103050);
    this.pQJ = c.e.pPU;
    this.pRY = true;
    this.pRZ = new RadarStateView.d(this);
    this.pRQ = g.j((a.f.a.a)new RadarStateView.c(this));
    this.pRR = g.j((a.f.a.a)new RadarStateView.b(this));
    AppMethodBeat.o(103050);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103051);
    this.pQJ = c.e.pPU;
    this.pRY = true;
    this.pRZ = new RadarStateView.d(this);
    this.pRQ = g.j((a.f.a.a)new RadarStateView.c(this));
    this.pRR = g.j((a.f.a.a)new RadarStateView.b(this));
    AppMethodBeat.o(103051);
  }
  
  private final Animation getSlideInAnim()
  {
    AppMethodBeat.i(103045);
    Animation localAnimation = (Animation)this.pRR.getValue();
    AppMethodBeat.o(103045);
    return localAnimation;
  }
  
  private final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(103044);
    Animation localAnimation = (Animation)this.pRQ.getValue();
    AppMethodBeat.o(103044);
    return localAnimation;
  }
  
  private final void setShowing(boolean paramBoolean)
  {
    this.bTs = paramBoolean;
  }
  
  final void ceW()
  {
    AppMethodBeat.i(103046);
    ab.d(TAG, " state : " + this.pQJ);
    if (!this.pRY)
    {
      setVisibility(8);
      AppMethodBeat.o(103046);
      return;
    }
    Object localObject = this.pQJ;
    switch (f.bLo[localObject.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(103046);
      return;
      setVisibility(8);
      AppMethodBeat.o(103046);
      return;
      setBackgroundResource(2131231898);
      localObject = this.pSa;
      if (localObject == null) {
        j.ebi();
      }
      ((ImageView)localObject).setImageResource(2131231902);
      setVisibility(0);
      AppMethodBeat.o(103046);
      return;
      setBackgroundResource(2131231899);
      localObject = this.pSa;
      if (localObject == null) {
        j.ebi();
      }
      ((ImageView)localObject).setImageResource(2131231901);
      setVisibility(0);
      AppMethodBeat.o(103046);
      return;
      setBackgroundResource(2131231899);
      localObject = this.pSa;
      if (localObject == null) {
        j.ebi();
      }
      ((ImageView)localObject).setImageResource(2131231900);
      setVisibility(0);
    }
  }
  
  public final void ceX()
  {
    AppMethodBeat.i(103048);
    if (!this.pRY)
    {
      AppMethodBeat.o(103048);
      return;
    }
    init();
    ceW();
    this.bTs = true;
    startAnimation(getSlideOutAnim());
    AppMethodBeat.o(103048);
  }
  
  public final void ceY()
  {
    AppMethodBeat.i(103049);
    if (!this.pRY)
    {
      AppMethodBeat.o(103049);
      return;
    }
    init();
    ceW();
    startAnimation(getSlideInAnim());
    AppMethodBeat.o(103049);
  }
  
  public final c.e getState()
  {
    return this.pQJ;
  }
  
  final void init()
  {
    AppMethodBeat.i(103047);
    if (this.pSa == null)
    {
      this.pSa = new ImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 5), com.tencent.mm.cb.a.fromDPToPix(getContext(), 2));
      ImageView localImageView = this.pSa;
      if (localImageView != null) {
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      addView((View)this.pSa);
    }
    AppMethodBeat.o(103047);
  }
  
  public final void setState(c.e parame)
  {
    AppMethodBeat.i(103043);
    j.q(parame, "<set-?>");
    this.pQJ = parame;
    AppMethodBeat.o(103043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView
 * JD-Core Version:    0.7.0.1
 */