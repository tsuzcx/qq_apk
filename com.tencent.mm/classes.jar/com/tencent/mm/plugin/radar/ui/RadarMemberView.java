package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.cf;
import d.f;
import d.g.b.p;
import d.v;
import java.util.Arrays;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", "listener", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", "username", "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"})
public final class RadarMemberView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.RadarMemberView";
  private static final int xjN = 0;
  private static final int xjO = 1;
  public static final RadarMemberView.a xjP;
  private am contact;
  private boolean iLS;
  private View jcq;
  private com.tencent.mm.ui.widget.a.d jcs;
  private EditText mlU;
  private TextView tAA;
  private final f xjA;
  private final f xjB;
  private final f xjC;
  private final f xjD;
  private final f xjE;
  private final f xjF;
  private int[] xjG;
  private final f xjH;
  private cf xjI;
  private b xjJ;
  private final View.OnClickListener xjK;
  private final d xjL;
  private TextView xjM;
  private cqi xjd;
  private c.e xje;
  private View xjx;
  private final f xjy;
  private final f xjz;
  
  static
  {
    AppMethodBeat.i(138609);
    xjP = new RadarMemberView.a((byte)0);
    TAG = "MicroMsg.RadarMemberView";
    xjO = 1;
    AppMethodBeat.o(138609);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138626);
    this.xjy = i.ao(this, 2131303691);
    this.xjz = i.ao(this, 2131303676);
    this.xjA = i.ao(this, 2131303675);
    this.xjB = i.ao(this, 2131303679);
    this.xjC = i.ao(this, 2131303680);
    this.xjD = i.ao(this, 2131303685);
    this.xjE = i.ao(this, 2131303684);
    this.xjF = i.ao(this, 2131303697);
    this.xjH = i.ao(this, 2131299606);
    this.xjK = ((View.OnClickListener)new h(this));
    this.xjL = new d(this);
    AppMethodBeat.o(138626);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138627);
    this.xjy = i.ao(this, 2131303691);
    this.xjz = i.ao(this, 2131303676);
    this.xjA = i.ao(this, 2131303675);
    this.xjB = i.ao(this, 2131303679);
    this.xjC = i.ao(this, 2131303680);
    this.xjD = i.ao(this, 2131303685);
    this.xjE = i.ao(this, 2131303684);
    this.xjF = i.ao(this, 2131303697);
    this.xjH = i.ao(this, 2131299606);
    this.xjK = ((View.OnClickListener)new h(this));
    this.xjL = new d(this);
    AppMethodBeat.o(138627);
  }
  
  private final void a(c.e parame)
  {
    AppMethodBeat.i(138621);
    getExposeTv().setVisibility(0);
    if (parame == null)
    {
      AppMethodBeat.o(138621);
      return;
    }
    switch (c.cpQ[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(2131762152);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(2131762159);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(2131762139);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(2131762138);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setText((CharSequence)getContext().getString(2131762150));
      getSayHiTv().setVisibility(0);
    }
  }
  
  private final ImageView getAvatarCopy()
  {
    AppMethodBeat.i(138611);
    ImageView localImageView = (ImageView)this.xjz.getValue();
    AppMethodBeat.o(138611);
    return localImageView;
  }
  
  private final View getAvatarCopyContainer()
  {
    AppMethodBeat.i(138612);
    View localView = (View)this.xjA.getValue();
    AppMethodBeat.o(138612);
    return localView;
  }
  
  private final View getAvatarHolder()
  {
    AppMethodBeat.i(138610);
    View localView = (View)this.xjy.getValue();
    AppMethodBeat.o(138610);
    return localView;
  }
  
  private final Button getConfirmBtn()
  {
    AppMethodBeat.i(138613);
    Button localButton = (Button)this.xjB.getValue();
    AppMethodBeat.o(138613);
    return localButton;
  }
  
  private final TextView getConfirmBtnDisabled()
  {
    AppMethodBeat.i(138614);
    TextView localTextView = (TextView)this.xjC.getValue();
    AppMethodBeat.o(138614);
    return localTextView;
  }
  
  private final TextView getExposeTv()
  {
    AppMethodBeat.i(138618);
    TextView localTextView = (TextView)this.xjH.getValue();
    AppMethodBeat.o(138618);
    return localTextView;
  }
  
  private final TextView getMemberNameTv()
  {
    AppMethodBeat.i(138615);
    TextView localTextView = (TextView)this.xjD.getValue();
    AppMethodBeat.o(138615);
    return localTextView;
  }
  
  private final Button getModifyNameBtn()
  {
    AppMethodBeat.i(138616);
    Button localButton = (Button)this.xjE.getValue();
    AppMethodBeat.o(138616);
    return localButton;
  }
  
  private final TextView getSayHiTv()
  {
    AppMethodBeat.i(138617);
    TextView localTextView = (TextView)this.xjF.getValue();
    AppMethodBeat.o(138617);
    return localTextView;
  }
  
  private final void reset()
  {
    AppMethodBeat.i(138625);
    getAvatarCopyContainer().setVisibility(8);
    getMemberNameTv().setVisibility(4);
    getModifyNameBtn().setVisibility(4);
    getConfirmBtn().setVisibility(8);
    getConfirmBtnDisabled().setVisibility(8);
    getSayHiTv().setVisibility(8);
    getExposeTv().setVisibility(8);
    AppMethodBeat.o(138625);
  }
  
  public final void a(View paramView, final cqi paramcqi, c.e parame)
  {
    AppMethodBeat.i(138623);
    p.h(paramView, "view");
    p.h(paramcqi, "member");
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "popup");
    this.xje = parame;
    this.xjd = paramcqi;
    parame = getConfirmBtn();
    if (parame != null) {
      parame.setOnClickListener((View.OnClickListener)new e(this, paramcqi));
    }
    getModifyNameBtn().setOnClickListener(this.xjK);
    setOnTouchListener((View.OnTouchListener)new f(this));
    getExposeTv().setOnClickListener((View.OnClickListener)new g(this));
    parame = g.xla;
    parame = g.b(paramcqi);
    if (!d.n.n.aE((CharSequence)parame))
    {
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "service(IMessengerStorage::class.java)");
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().Bf(parame);
    }
    Object localObject = this.contact;
    if ((localObject != null) && (((am)localObject).adh() == true))
    {
      parame = this.contact;
      if (parame != null)
      {
        parame = parame.VB();
        localObject = getMemberNameTv();
        if ((this.contact == null) || (bt.isNullOrNil(parame))) {
          break label610;
        }
      }
    }
    label610:
    for (paramcqi = (CharSequence)k.b(getContext(), (CharSequence)parame, getMemberNameTv().getTextSize());; paramcqi = (CharSequence)k.b(getContext(), (CharSequence)paramcqi.nEt, getMemberNameTv().getTextSize()))
    {
      ((TextView)localObject).setText(paramcqi);
      getMemberNameTv().setVisibility(4);
      getModifyNameBtn().setVisibility(4);
      reset();
      this.xjx = paramView;
      paramView = this.xjx;
      if (paramView == null) {
        p.gfZ();
      }
      paramView = paramView.findViewById(2131303693);
      p.g(paramView, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
      paramcqi = (ImageView)paramView;
      paramView = this.xjx;
      if (paramView == null) {
        p.gfZ();
      }
      paramView = paramView.findViewById(2131303675);
      p.g(paramView, "avatarItem!!.findViewByI…d.radar_avatar_container)");
      parame = this.xjx;
      if (parame == null) {
        p.gfZ();
      }
      parame.setVisibility(4);
      getAvatarCopy().setImageDrawable(paramcqi.getDrawable());
      getAvatarCopyContainer().setVisibility(0);
      parame = new int[2];
      paramView.getLocationInWindow(parame);
      localObject = new int[2];
      getAvatarHolder().getLocationInWindow((int[])localObject);
      this.xjG = ((int[])localObject);
      setVisibility(0);
      paramcqi = new AnimationSet(true);
      paramcqi.setFillAfter(true);
      paramcqi.setRepeatCount(1);
      paramcqi.setDuration(500L);
      float f1 = getAvatarHolder().getHeight() / paramView.getHeight();
      float f2 = (paramView.getWidth() - paramView.getHeight()) / 2;
      paramView = new TranslateAnimation(parame[0], localObject[0] - f2 * f1, parame[1], localObject[1]);
      paramcqi.addAnimation((Animation)new ScaleAnimation(1.0F, f1, 1.0F, f1));
      paramcqi.addAnimation((Animation)paramView);
      paramcqi.setAnimationListener((Animation.AnimationListener)new i(this));
      getAvatarCopyContainer().startAnimation((Animation)paramcqi);
      AppMethodBeat.o(138623);
      return;
      parame = null;
      break;
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "service(IMessengerStorage::class.java)");
      this.xjI = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azq().aqz(parame);
      parame = this.xjI;
      if (parame != null)
      {
        parame = parame.VB();
        break;
      }
      parame = null;
      break;
    }
  }
  
  public final void c(String paramString, c.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(138620);
    p.h(paramString, "username");
    p.h(parame, "state");
    if ((!isShowing()) || (this.iLS))
    {
      AppMethodBeat.o(138620);
      return;
    }
    Object localObject1 = this.xjd;
    if (localObject1 != null) {}
    for (localObject1 = ((cqi)localObject1).GgA;; localObject1 = null)
    {
      if (!p.i(paramString, localObject1))
      {
        cqi localcqi = this.xjd;
        localObject1 = localObject2;
        if (localcqi != null) {
          localObject1 = localcqi.nDo;
        }
        if (!p.i(paramString, localObject1)) {}
      }
      else
      {
        a(parame);
      }
      AppMethodBeat.o(138620);
      return;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(138624);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "dismiss");
    if (this.iLS)
    {
      AppMethodBeat.o(138624);
      return;
    }
    this.iLS = true;
    Object localObject1 = this.xjx;
    if (localObject1 == null) {
      p.gfZ();
    }
    Object localObject2 = ((View)localObject1).findViewById(2131303675);
    p.g(localObject2, "avatarItem!!.findViewByI…d.radar_avatar_container)");
    localObject1 = new AnimationSet(true);
    ((AnimationSet)localObject1).setFillAfter(true);
    ((AnimationSet)localObject1).setRepeatCount(1);
    ((AnimationSet)localObject1).setDuration(500L);
    int[] arrayOfInt1 = this.xjG;
    int[] arrayOfInt2 = new int[2];
    ((View)localObject2).getLocationInWindow(arrayOfInt2);
    float f1 = getAvatarHolder().getHeight() / ((View)localObject2).getHeight();
    float f2 = (((View)localObject2).getWidth() - ((View)localObject2).getHeight()) / 2;
    if (arrayOfInt1 == null) {
      p.gfZ();
    }
    localObject2 = new TranslateAnimation(arrayOfInt1[0] - f2 * f1, arrayOfInt2[0], arrayOfInt1[1], arrayOfInt2[1]);
    ((AnimationSet)localObject1).addAnimation((Animation)new ScaleAnimation(f1, 1.0F, f1, 1.0F));
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).setAnimationListener((Animation.AnimationListener)new c(this));
    getMemberNameTv().setVisibility(4);
    getModifyNameBtn().setVisibility(4);
    getConfirmBtn().setVisibility(8);
    getConfirmBtnDisabled().setVisibility(8);
    getSayHiTv().setVisibility(8);
    getExposeTv().setVisibility(8);
    getAvatarCopyContainer().startAnimation((Animation)localObject1);
    AppMethodBeat.o(138624);
  }
  
  public final cqi getMember()
  {
    return this.xjd;
  }
  
  public final c.e getState()
  {
    return this.xje;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(138619);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(138619);
      return true;
    }
    AppMethodBeat.o(138619);
    return false;
  }
  
  public final void setListener(b paramb)
  {
    AppMethodBeat.i(138622);
    p.h(paramb, "listener");
    this.xjJ = paramb;
    AppMethodBeat.o(138622);
  }
  
  public final void setMember(cqi paramcqi)
  {
    this.xjd = paramcqi;
  }
  
  public final void setState(c.e parame)
  {
    this.xje = parame;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
  public static abstract interface b
  {
    public abstract void a(cqi paramcqi, c.e parame);
    
    public abstract void b(cqi paramcqi, c.e parame);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class c
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138594);
      p.h(paramAnimation, "animation");
      com.tencent.mm.sdk.platformtools.ad.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
      RadarMemberView.e(this.xjQ);
      RadarMemberView.d(this.xjQ).sendEmptyMessage(RadarMemberView.dDk());
      AppMethodBeat.o(138594);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(138593);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(138593);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(138592);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(138592);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138595);
      p.h(paramMessage, "msg");
      if (paramMessage.what == RadarMemberView.dDj())
      {
        paramMessage = this.xjQ;
        this.xjQ.getMember();
        RadarMemberView.a(paramMessage, this.xjQ.getState());
        AppMethodBeat.o(138595);
        return;
      }
      if (paramMessage.what == RadarMemberView.dDk())
      {
        this.xjQ.setVisibility(4);
        RadarMemberView.j(this.xjQ);
        paramMessage = RadarMemberView.k(this.xjQ);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
        paramMessage = RadarMemberView.a(this.xjQ);
        if (paramMessage != null)
        {
          paramMessage.b(this.xjQ.getMember(), this.xjQ.getState());
          AppMethodBeat.o(138595);
          return;
        }
      }
      AppMethodBeat.o(138595);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(RadarMemberView paramRadarMemberView, cqi paramcqi) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138596);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if ((this.xjQ.getState() == null) || (RadarMemberView.a(this.xjQ) == null))
      {
        a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(138596);
        return;
      }
      paramView = RadarMemberView.a(this.xjQ);
      if (paramView != null) {
        paramView.a(paramcqi, this.xjQ.getState());
      }
      this.xjQ.dismiss();
      a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138596);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class f
    implements View.OnTouchListener
  {
    f(RadarMemberView paramRadarMemberView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(138597);
      b localb = new b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      if (paramView != RadarMemberView.b(this.xjQ))
      {
        p.g(paramMotionEvent, "event");
        if ((paramMotionEvent.getAction() == 1) && (this.xjQ.isShowing())) {
          this.xjQ.dismiss();
        }
      }
      a.a(true, this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(138597);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138598);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      localObject = new Intent();
      paramView = RadarMemberView.c(this.xjQ);
      if (paramView != null) {}
      for (paramView = paramView.getUsername();; paramView = null)
      {
        ((Intent)localObject).putExtra("k_username", paramView);
        ((Intent)localObject).putExtra("showShare", false);
        paramView = d.g.b.ad.MLZ;
        paramView = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(38) }, 1));
        p.g(paramView, "java.lang.String.format(format, *args)");
        ((Intent)localObject).putExtra("rawUrl", paramView);
        com.tencent.mm.bs.d.b(this.xjQ.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(138598);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(View paramView)
    {
      RadarMemberView localRadarMemberView = null;
      AppMethodBeat.i(138599);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$mOnModifyNameClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      String str = "";
      paramView = str;
      if (RadarMemberView.c(this.xjQ) != null)
      {
        paramView = RadarMemberView.c(this.xjQ);
        if ((paramView == null) || (paramView.adh() != true)) {
          break label193;
        }
        paramView = RadarMemberView.c(this.xjQ);
        if (paramView == null) {
          break label188;
        }
      }
      int i;
      label188:
      for (paramView = paramView.VB();; paramView = null)
      {
        localObject = (CharSequence)paramView;
        if ((localObject != null) && (!d.n.n.aE((CharSequence)localObject))) {
          break;
        }
        i = 1;
        label109:
        localObject = paramView;
        if (i != 0)
        {
          localObject = paramView;
          if (this.xjQ.getMember() != null)
          {
            localObject = this.xjQ.getMember();
            paramView = localRadarMemberView;
            if (localObject != null) {
              paramView = ((cqi)localObject).nEt;
            }
            localObject = paramView;
          }
        }
        localRadarMemberView = this.xjQ;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        RadarMemberView.a(localRadarMemberView, paramView);
        a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$mOnModifyNameClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(138599);
        return;
      }
      label193:
      paramView = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramView, "service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView).azq();
      paramView = RadarMemberView.c(this.xjQ);
      if (paramView != null)
      {
        paramView = paramView.getUsername();
        label232:
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject).aqz(paramView);
        if (localObject != null)
        {
          paramView = (CharSequence)((cf)localObject).VF();
          if ((paramView != null) && (!d.n.n.aE(paramView))) {
            break label375;
          }
          i = 1;
          label265:
          if (i == 0) {
            break label400;
          }
        }
        paramView = RadarMemberView.c(this.xjQ);
        if (paramView == null) {
          break label380;
        }
        paramView = paramView.VF();
        label286:
        paramView = (CharSequence)paramView;
        if ((paramView != null) && (!d.n.n.aE(paramView))) {
          break label385;
        }
        i = 1;
        label304:
        if (i != 0) {
          break label400;
        }
        paramView = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(paramView, "service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView).azq();
        paramView = RadarMemberView.c(this.xjQ);
        if (paramView == null) {
          break label390;
        }
        paramView = paramView.VF();
        label347:
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject).aqz(paramView);
      }
      label385:
      label390:
      label400:
      for (;;)
      {
        paramView = str;
        if (localObject == null) {
          break;
        }
        paramView = ((cf)localObject).VB();
        break;
        paramView = null;
        break label232;
        label375:
        i = 0;
        break label265;
        label380:
        paramView = null;
        break label286;
        i = 0;
        break label304;
        paramView = null;
        break label347;
        i = 0;
        break label109;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarMemberView$popup$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class i
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138602);
      p.h(paramAnimation, "animation");
      com.tencent.mm.sdk.platformtools.ad.d(RadarMemberView.access$getTAG$cp(), "popup animation end");
      RadarMemberView.d(this.xjQ).sendEmptyMessage(RadarMemberView.dDj());
      AppMethodBeat.o(138602);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(138601);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(138601);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(138600);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(138600);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarMemberView$showModifyDialog$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-radar_release"})
  public static final class j
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = false;
      AppMethodBeat.i(138605);
      p.h(paramEditable, "s");
      int j = 50 - paramEditable.length();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      Object localObject = RadarMemberView.f(this.xjQ);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)String.valueOf(i));
      }
      localObject = RadarMemberView.g(this.xjQ);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.widget.a.d)localObject).getButton(-1);
        if (localObject != null)
        {
          if (paramEditable.length() > 0) {
            bool = true;
          }
          ((Button)localObject).setEnabled(bool);
          AppMethodBeat.o(138605);
          return;
        }
      }
      AppMethodBeat.o(138605);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(138604);
      p.h(paramCharSequence, "s");
      AppMethodBeat.o(138604);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(138603);
      p.h(paramCharSequence, "s");
      AppMethodBeat.o(138603);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(RadarMemberView paramRadarMemberView) {}
    
    public final void run()
    {
      AppMethodBeat.i(138606);
      if ((this.xjQ.getContext() instanceof Activity))
      {
        Object localObject1 = RadarMemberView.xjP;
        localObject1 = this.xjQ.getContext();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(138606);
          throw ((Throwable)localObject1);
        }
        Activity localActivity = (Activity)localObject1;
        p.h(localActivity, "ac");
        Object localObject2 = localActivity.getSystemService("input_method");
        localObject1 = localObject2;
        if (!(localObject2 instanceof InputMethodManager)) {
          localObject1 = null;
        }
        localObject1 = (InputMethodManager)localObject1;
        if (localObject1 == null)
        {
          AppMethodBeat.o(138606);
          return;
        }
        localObject2 = localActivity.getCurrentFocus();
        if (localObject2 == null)
        {
          AppMethodBeat.o(138606);
          return;
        }
        if (((View)localObject2).getWindowToken() == null)
        {
          AppMethodBeat.o(138606);
          return;
        }
        ((InputMethodManager)localObject1).toggleSoftInput(0, 2);
      }
      AppMethodBeat.o(138606);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class l
    implements DialogInterface.OnClickListener
  {
    l(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138607);
      paramDialogInterface = RadarMemberView.g(this.xjQ);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      RadarMemberView.h(this.xjQ);
      AppMethodBeat.o(138607);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class m
    implements DialogInterface.OnClickListener
  {
    m(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138608);
      if (RadarMemberView.g(this.xjQ) != null)
      {
        paramDialogInterface = RadarMemberView.g(this.xjQ);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        RadarMemberView.h(this.xjQ);
      }
      RadarMemberView.i(this.xjQ);
      AppMethodBeat.o(138608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView
 * JD-Core Version:    0.7.0.1
 */