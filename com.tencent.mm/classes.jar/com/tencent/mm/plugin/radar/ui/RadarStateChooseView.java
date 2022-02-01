package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.model.d.a;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isShowing", "", "mStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getMStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "setMStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;)V", "mTrunOn", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "hide", "", "show", "stateAlignment", "trunOff", "trunOn", "trunToStatus", "status", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RadarStateChooseView
  extends RelativeLayout
{
  public static final RadarStateChooseView.a Ntn;
  private static final String TAG;
  private final j Nto;
  private final j Ntp;
  boolean Ntq;
  d.a Ntr;
  boolean fhR;
  
  static
  {
    AppMethodBeat.i(138673);
    Ntn = new RadarStateChooseView.a((byte)0);
    TAG = "MicroMsg.Radar.RadarStateChooseView";
    AppMethodBeat.o(138673);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138678);
    this.Nto = k.cm((a)new RadarStateChooseView.d(this));
    this.Ntp = k.cm((a)new RadarStateChooseView.c(this));
    this.Ntq = true;
    this.Ntr = d.a.Nsj;
    AppMethodBeat.o(138678);
  }
  
  public RadarStateChooseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138679);
    this.Nto = k.cm((a)new RadarStateChooseView.d(this));
    this.Ntp = k.cm((a)new RadarStateChooseView.c(this));
    this.Ntq = true;
    this.Ntr = d.a.Nsj;
    AppMethodBeat.o(138679);
  }
  
  final void gFk()
  {
    AppMethodBeat.i(138677);
    d.a locala = this.Ntr;
    switch (b.$EnumSwitchMapping$0[locala.ordinal()])
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
    return this.Ntr;
  }
  
  final Animation getSlideInAnim()
  {
    AppMethodBeat.i(138675);
    Animation localAnimation = (Animation)this.Ntp.getValue();
    AppMethodBeat.o(138675);
    return localAnimation;
  }
  
  final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(138674);
    Animation localAnimation = (Animation)this.Nto.getValue();
    AppMethodBeat.o(138674);
    return localAnimation;
  }
  
  public final void setMStatus(d.a parama)
  {
    AppMethodBeat.i(138676);
    s.u(parama, "<set-?>");
    this.Ntr = parama;
    AppMethodBeat.o(138676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateChooseView
 * JD-Core Version:    0.7.0.1
 */