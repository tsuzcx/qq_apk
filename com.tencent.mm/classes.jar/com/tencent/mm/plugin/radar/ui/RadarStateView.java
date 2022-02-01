package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.model.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isShowing", "()Z", "isVisible", "ivState", "Landroid/widget/ImageView;", "slideInAnim", "Landroid/view/animation/Animation;", "getSlideInAnim", "()Landroid/view/animation/Animation;", "slideInAnim$delegate", "Lkotlin/Lazy;", "slideOutAnim", "getSlideOutAnim", "slideOutAnim$delegate", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "switchHandler", "com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1;", "trunOn", "init", "", "reset", "slideIn", "slideOut", "stateAlignment", "trunOff", "turnToState", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RadarStateView
  extends RelativeLayout
{
  public static final RadarStateView.a Ntt;
  static final int Ntx;
  static final String TAG;
  b.e Nsm;
  private final j Nto;
  private final j Ntp;
  boolean Ntu;
  final e Ntv;
  private ImageView Ntw;
  boolean fhR;
  
  static
  {
    AppMethodBeat.i(138691);
    Ntt = new RadarStateView.a((byte)0);
    TAG = "MicroMsg.RadarStateView";
    Ntx = 300;
    AppMethodBeat.o(138691);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138699);
    this.Nsm = b.e.NrC;
    this.Ntu = true;
    this.Ntv = new e(this);
    this.Nto = k.cm((kotlin.g.a.a)new RadarStateView.d(this));
    this.Ntp = k.cm((kotlin.g.a.a)new RadarStateView.c(this));
    AppMethodBeat.o(138699);
  }
  
  public RadarStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138700);
    this.Nsm = b.e.NrC;
    this.Ntu = true;
    this.Ntv = new e(this);
    this.Nto = k.cm((kotlin.g.a.a)new RadarStateView.d(this));
    this.Ntp = k.cm((kotlin.g.a.a)new RadarStateView.c(this));
    AppMethodBeat.o(138700);
  }
  
  private final Animation getSlideInAnim()
  {
    AppMethodBeat.i(138694);
    Object localObject = this.Ntp.getValue();
    s.s(localObject, "<get-slideInAnim>(...)");
    localObject = (Animation)localObject;
    AppMethodBeat.o(138694);
    return localObject;
  }
  
  private final Animation getSlideOutAnim()
  {
    AppMethodBeat.i(138693);
    Object localObject = this.Nto.getValue();
    s.s(localObject, "<get-slideOutAnim>(...)");
    localObject = (Animation)localObject;
    AppMethodBeat.o(138693);
    return localObject;
  }
  
  final void gFk()
  {
    AppMethodBeat.i(138695);
    Log.d(TAG, s.X(" state : ", this.Nsm));
    if (!this.Ntu)
    {
      setVisibility(8);
      AppMethodBeat.o(138695);
      return;
    }
    Object localObject = this.Nsm;
    switch (b.$EnumSwitchMapping$0[localObject.ordinal()])
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
      localObject = this.Ntw;
      s.checkNotNull(localObject);
      ((ImageView)localObject).setImageResource(a.f.radar_search_waiting);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(a.f.radar_search_green_bg);
      localObject = this.Ntw;
      s.checkNotNull(localObject);
      ((ImageView)localObject).setImageResource(a.f.radar_search_ok);
      setVisibility(0);
      AppMethodBeat.o(138695);
      return;
      setBackgroundResource(a.f.radar_search_green_bg);
      localObject = this.Ntw;
      s.checkNotNull(localObject);
      ((ImageView)localObject).setImageResource(a.f.radar_search_hi);
      setVisibility(0);
    }
  }
  
  public final void gFl()
  {
    AppMethodBeat.i(138697);
    if (!this.Ntu)
    {
      AppMethodBeat.o(138697);
      return;
    }
    init();
    gFk();
    this.fhR = true;
    startAnimation(getSlideOutAnim());
    AppMethodBeat.o(138697);
  }
  
  public final void gFm()
  {
    AppMethodBeat.i(138698);
    if (!this.Ntu)
    {
      AppMethodBeat.o(138698);
      return;
    }
    init();
    gFk();
    startAnimation(getSlideInAnim());
    AppMethodBeat.o(138698);
  }
  
  public final b.e getState()
  {
    return this.Nsm;
  }
  
  final void init()
  {
    AppMethodBeat.i(138696);
    if (this.Ntw == null)
    {
      this.Ntw = new ImageView(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      localLayoutParams.setMargins(0, 0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 5), com.tencent.mm.cd.a.fromDPToPix(getContext(), 2));
      ImageView localImageView = this.Ntw;
      if (localImageView != null) {
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
      addView((View)this.Ntw);
    }
    AppMethodBeat.o(138696);
  }
  
  public final void setState(b.e parame)
  {
    AppMethodBeat.i(138692);
    s.u(parame, "<set-?>");
    this.Nsm = parame;
    AppMethodBeat.o(138692);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarStateView$switchHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends MMHandler
  {
    e(RadarStateView paramRadarStateView) {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138690);
      s.u(paramMessage, "msg");
      RadarStateView.a(this.Nty);
      this.Nty.gFl();
      AppMethodBeat.o(138690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarStateView
 * JD-Core Version:    0.7.0.1
 */