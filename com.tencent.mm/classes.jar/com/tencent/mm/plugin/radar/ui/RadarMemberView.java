package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
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
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.widget.a.d;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.l;
import d.n.n;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", "listener", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", "username", "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"})
public final class RadarMemberView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.RadarMemberView";
  private static final int uTp = 0;
  private static final int uTq = 1;
  public static final RadarMemberView.a uTr;
  private af contact;
  private boolean hSK;
  private View ija;
  private d ijc;
  private EditText lmq;
  private TextView ruT;
  private cgf uSF;
  private c.e uSG;
  private View uSZ;
  private final f uTa;
  private final f uTb;
  private final f uTc;
  private final f uTd;
  private final f uTe;
  private final f uTf;
  private final f uTg;
  private final f uTh;
  private int[] uTi;
  private final f uTj;
  private bw uTk;
  private b uTl;
  private final View.OnClickListener uTm;
  private final d uTn;
  private TextView uTo;
  
  static
  {
    AppMethodBeat.i(138609);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(RadarMemberView.class), "avatarHolder", "getAvatarHolder()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(RadarMemberView.class), "avatarCopy", "getAvatarCopy()Landroid/widget/ImageView;")), (d.l.k)w.a(new u(w.bk(RadarMemberView.class), "avatarCopyContainer", "getAvatarCopyContainer()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(RadarMemberView.class), "confirmBtn", "getConfirmBtn()Landroid/widget/Button;")), (d.l.k)w.a(new u(w.bk(RadarMemberView.class), "confirmBtnDisabled", "getConfirmBtnDisabled()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bk(RadarMemberView.class), "memberNameTv", "getMemberNameTv()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bk(RadarMemberView.class), "modifyNameBtn", "getModifyNameBtn()Landroid/widget/Button;")), (d.l.k)w.a(new u(w.bk(RadarMemberView.class), "sayHiTv", "getSayHiTv()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bk(RadarMemberView.class), "exposeTv", "getExposeTv()Landroid/widget/TextView;")) };
    uTr = new RadarMemberView.a((byte)0);
    TAG = "MicroMsg.RadarMemberView";
    uTq = 1;
    AppMethodBeat.o(138609);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138626);
    this.uTa = i.am(this, 2131303691);
    this.uTb = i.am(this, 2131303676);
    this.uTc = i.am(this, 2131303675);
    this.uTd = i.am(this, 2131303679);
    this.uTe = i.am(this, 2131303680);
    this.uTf = i.am(this, 2131303685);
    this.uTg = i.am(this, 2131303684);
    this.uTh = i.am(this, 2131303697);
    this.uTj = i.am(this, 2131299606);
    this.uTm = ((View.OnClickListener)new h(this));
    this.uTn = new d(this);
    AppMethodBeat.o(138626);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138627);
    this.uTa = i.am(this, 2131303691);
    this.uTb = i.am(this, 2131303676);
    this.uTc = i.am(this, 2131303675);
    this.uTd = i.am(this, 2131303679);
    this.uTe = i.am(this, 2131303680);
    this.uTf = i.am(this, 2131303685);
    this.uTg = i.am(this, 2131303684);
    this.uTh = i.am(this, 2131303697);
    this.uTj = i.am(this, 2131299606);
    this.uTm = ((View.OnClickListener)new h(this));
    this.uTn = new d(this);
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
    switch (c.ciE[parame.ordinal()])
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
    ImageView localImageView = (ImageView)this.uTb.getValue();
    AppMethodBeat.o(138611);
    return localImageView;
  }
  
  private final View getAvatarCopyContainer()
  {
    AppMethodBeat.i(138612);
    View localView = (View)this.uTc.getValue();
    AppMethodBeat.o(138612);
    return localView;
  }
  
  private final View getAvatarHolder()
  {
    AppMethodBeat.i(138610);
    View localView = (View)this.uTa.getValue();
    AppMethodBeat.o(138610);
    return localView;
  }
  
  private final Button getConfirmBtn()
  {
    AppMethodBeat.i(138613);
    Button localButton = (Button)this.uTd.getValue();
    AppMethodBeat.o(138613);
    return localButton;
  }
  
  private final TextView getConfirmBtnDisabled()
  {
    AppMethodBeat.i(138614);
    TextView localTextView = (TextView)this.uTe.getValue();
    AppMethodBeat.o(138614);
    return localTextView;
  }
  
  private final TextView getExposeTv()
  {
    AppMethodBeat.i(138618);
    TextView localTextView = (TextView)this.uTj.getValue();
    AppMethodBeat.o(138618);
    return localTextView;
  }
  
  private final TextView getMemberNameTv()
  {
    AppMethodBeat.i(138615);
    TextView localTextView = (TextView)this.uTf.getValue();
    AppMethodBeat.o(138615);
    return localTextView;
  }
  
  private final Button getModifyNameBtn()
  {
    AppMethodBeat.i(138616);
    Button localButton = (Button)this.uTg.getValue();
    AppMethodBeat.o(138616);
    return localButton;
  }
  
  private final TextView getSayHiTv()
  {
    AppMethodBeat.i(138617);
    TextView localTextView = (TextView)this.uTh.getValue();
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
  
  public final void a(View paramView, final cgf paramcgf, c.e parame)
  {
    AppMethodBeat.i(138623);
    d.g.b.k.h(paramView, "view");
    d.g.b.k.h(paramcgf, "member");
    ad.d(TAG, "popup");
    this.uSG = parame;
    this.uSF = paramcgf;
    parame = getConfirmBtn();
    if (parame != null) {
      parame.setOnClickListener((View.OnClickListener)new e(this, paramcgf));
    }
    getModifyNameBtn().setOnClickListener(this.uTm);
    setOnTouchListener((View.OnTouchListener)new f(this));
    getExposeTv().setOnClickListener((View.OnClickListener)new RadarMemberView.g(this));
    parame = g.uUC;
    parame = g.b(paramcgf);
    if (!n.aC((CharSequence)parame))
    {
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "service(IMessengerStorage::class.java)");
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().aHY(parame);
    }
    Object localObject = this.contact;
    if ((localObject != null) && (((af)localObject).ZJ() == true))
    {
      parame = this.contact;
      if (parame != null)
      {
        parame = parame.St();
        localObject = getMemberNameTv();
        if ((this.contact == null) || (bt.isNullOrNil(parame))) {
          break label611;
        }
      }
    }
    label611:
    for (paramcgf = (CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)parame, getMemberNameTv().getTextSize());; paramcgf = (CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)paramcgf.mBV, getMemberNameTv().getTextSize()))
    {
      ((TextView)localObject).setText(paramcgf);
      getMemberNameTv().setVisibility(4);
      getModifyNameBtn().setVisibility(4);
      reset();
      this.uSZ = paramView;
      paramView = this.uSZ;
      if (paramView == null) {
        d.g.b.k.fvU();
      }
      paramView = paramView.findViewById(2131303693);
      d.g.b.k.g(paramView, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
      paramcgf = (ImageView)paramView;
      paramView = this.uSZ;
      if (paramView == null) {
        d.g.b.k.fvU();
      }
      paramView = paramView.findViewById(2131303675);
      d.g.b.k.g(paramView, "avatarItem!!.findViewByI…d.radar_avatar_container)");
      parame = this.uSZ;
      if (parame == null) {
        d.g.b.k.fvU();
      }
      parame.setVisibility(4);
      getAvatarCopy().setImageDrawable(paramcgf.getDrawable());
      getAvatarCopyContainer().setVisibility(0);
      parame = new int[2];
      paramView.getLocationInWindow(parame);
      localObject = new int[2];
      getAvatarHolder().getLocationInWindow((int[])localObject);
      this.uTi = ((int[])localObject);
      setVisibility(0);
      paramcgf = new AnimationSet(true);
      paramcgf.setFillAfter(true);
      paramcgf.setRepeatCount(1);
      paramcgf.setDuration(500L);
      float f1 = getAvatarHolder().getHeight() / paramView.getHeight();
      float f2 = (paramView.getWidth() - paramView.getHeight()) / 2;
      paramView = new TranslateAnimation(parame[0], localObject[0] - f2 * f1, parame[1], localObject[1]);
      paramcgf.addAnimation((Animation)new ScaleAnimation(1.0F, f1, 1.0F, f1));
      paramcgf.addAnimation((Animation)paramView);
      paramcgf.setAnimationListener((Animation.AnimationListener)new i(this));
      getAvatarCopyContainer().startAnimation((Animation)paramcgf);
      AppMethodBeat.o(138623);
      return;
      parame = null;
      break;
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "service(IMessengerStorage::class.java)");
      this.uTk = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apN().agQ(parame);
      parame = this.uTk;
      if (parame != null)
      {
        parame = parame.St();
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
    d.g.b.k.h(paramString, "username");
    d.g.b.k.h(parame, "state");
    if ((!isShowing()) || (this.hSK))
    {
      AppMethodBeat.o(138620);
      return;
    }
    Object localObject1 = this.uSF;
    if (localObject1 != null) {}
    for (localObject1 = ((cgf)localObject1).DfI;; localObject1 = null)
    {
      if (!d.g.b.k.g(paramString, localObject1))
      {
        cgf localcgf = this.uSF;
        localObject1 = localObject2;
        if (localcgf != null) {
          localObject1 = localcgf.mAQ;
        }
        if (!d.g.b.k.g(paramString, localObject1)) {}
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
    ad.d(TAG, "dismiss");
    if (this.hSK)
    {
      AppMethodBeat.o(138624);
      return;
    }
    this.hSK = true;
    Object localObject1 = this.uSZ;
    if (localObject1 == null) {
      d.g.b.k.fvU();
    }
    Object localObject2 = ((View)localObject1).findViewById(2131303675);
    d.g.b.k.g(localObject2, "avatarItem!!.findViewByI…d.radar_avatar_container)");
    localObject1 = new AnimationSet(true);
    ((AnimationSet)localObject1).setFillAfter(true);
    ((AnimationSet)localObject1).setRepeatCount(1);
    ((AnimationSet)localObject1).setDuration(500L);
    int[] arrayOfInt1 = this.uTi;
    int[] arrayOfInt2 = new int[2];
    ((View)localObject2).getLocationInWindow(arrayOfInt2);
    float f1 = getAvatarHolder().getHeight() / ((View)localObject2).getHeight();
    float f2 = (((View)localObject2).getWidth() - ((View)localObject2).getHeight()) / 2;
    if (arrayOfInt1 == null) {
      d.g.b.k.fvU();
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
  
  public final cgf getMember()
  {
    return this.uSF;
  }
  
  public final c.e getState()
  {
    return this.uSG;
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
    d.g.b.k.h(paramb, "listener");
    this.uTl = paramb;
    AppMethodBeat.o(138622);
  }
  
  public final void setMember(cgf paramcgf)
  {
    this.uSF = paramcgf;
  }
  
  public final void setState(c.e parame)
  {
    this.uSG = parame;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
  public static abstract interface b
  {
    public abstract void a(cgf paramcgf, c.e parame);
    
    public abstract void b(cgf paramcgf, c.e parame);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class c
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138594);
      d.g.b.k.h(paramAnimation, "animation");
      ad.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
      RadarMemberView.e(this.uTs);
      RadarMemberView.d(this.uTs).sendEmptyMessage(RadarMemberView.dfg());
      AppMethodBeat.o(138594);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(138593);
      d.g.b.k.h(paramAnimation, "animation");
      AppMethodBeat.o(138593);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(138592);
      d.g.b.k.h(paramAnimation, "animation");
      AppMethodBeat.o(138592);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138595);
      d.g.b.k.h(paramMessage, "msg");
      if (paramMessage.what == RadarMemberView.dff())
      {
        paramMessage = this.uTs;
        this.uTs.getMember();
        RadarMemberView.a(paramMessage, this.uTs.getState());
        AppMethodBeat.o(138595);
        return;
      }
      if (paramMessage.what == RadarMemberView.dfg())
      {
        this.uTs.setVisibility(4);
        RadarMemberView.j(this.uTs);
        paramMessage = RadarMemberView.k(this.uTs);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
        paramMessage = RadarMemberView.a(this.uTs);
        if (paramMessage != null)
        {
          paramMessage.b(this.uTs.getMember(), this.uTs.getState());
          AppMethodBeat.o(138595);
          return;
        }
      }
      AppMethodBeat.o(138595);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(RadarMemberView paramRadarMemberView, cgf paramcgf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138596);
      if ((this.uTs.getState() == null) || (RadarMemberView.a(this.uTs) == null))
      {
        AppMethodBeat.o(138596);
        return;
      }
      paramView = RadarMemberView.a(this.uTs);
      if (paramView != null) {
        paramView.a(paramcgf, this.uTs.getState());
      }
      this.uTs.dismiss();
      AppMethodBeat.o(138596);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class f
    implements View.OnTouchListener
  {
    f(RadarMemberView paramRadarMemberView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(138597);
      if (paramView != RadarMemberView.b(this.uTs))
      {
        d.g.b.k.g(paramMotionEvent, "event");
        if ((paramMotionEvent.getAction() == 1) && (this.uTs.isShowing())) {
          this.uTs.dismiss();
        }
      }
      AppMethodBeat.o(138597);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(View paramView)
    {
      RadarMemberView localRadarMemberView = null;
      AppMethodBeat.i(138599);
      String str = "";
      paramView = str;
      if (RadarMemberView.c(this.uTs) != null)
      {
        paramView = RadarMemberView.c(this.uTs);
        if ((paramView == null) || (paramView.ZJ() != true)) {
          break label152;
        }
        paramView = RadarMemberView.c(this.uTs);
        if (paramView == null) {
          break label147;
        }
      }
      int i;
      label147:
      for (paramView = paramView.St();; paramView = null)
      {
        localObject = (CharSequence)paramView;
        if ((localObject != null) && (!n.aC((CharSequence)localObject))) {
          break;
        }
        i = 1;
        label80:
        localObject = paramView;
        if (i != 0)
        {
          localObject = paramView;
          if (this.uTs.getMember() != null)
          {
            localObject = this.uTs.getMember();
            paramView = localRadarMemberView;
            if (localObject != null) {
              paramView = ((cgf)localObject).mBV;
            }
            localObject = paramView;
          }
        }
        localRadarMemberView = this.uTs;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        RadarMemberView.a(localRadarMemberView, paramView);
        AppMethodBeat.o(138599);
        return;
      }
      label152:
      paramView = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(paramView, "service(IMessengerStorage::class.java)");
      Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramView).apN();
      paramView = RadarMemberView.c(this.uTs);
      if (paramView != null)
      {
        paramView = paramView.getUsername();
        label191:
        localObject = ((m)localObject).agQ(paramView);
        if (localObject != null)
        {
          paramView = (CharSequence)((bw)localObject).Sx();
          if ((paramView != null) && (!n.aC(paramView))) {
            break label334;
          }
          i = 1;
          label224:
          if (i == 0) {
            break label359;
          }
        }
        paramView = RadarMemberView.c(this.uTs);
        if (paramView == null) {
          break label339;
        }
        paramView = paramView.Sx();
        label245:
        paramView = (CharSequence)paramView;
        if ((paramView != null) && (!n.aC(paramView))) {
          break label344;
        }
        i = 1;
        label263:
        if (i != 0) {
          break label359;
        }
        paramView = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(paramView, "service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramView).apN();
        paramView = RadarMemberView.c(this.uTs);
        if (paramView == null) {
          break label349;
        }
        paramView = paramView.Sx();
        label306:
        localObject = ((m)localObject).agQ(paramView);
      }
      label334:
      label339:
      label344:
      label349:
      label359:
      for (;;)
      {
        paramView = str;
        if (localObject == null) {
          break;
        }
        paramView = ((bw)localObject).St();
        break;
        paramView = null;
        break label191;
        i = 0;
        break label224;
        paramView = null;
        break label245;
        i = 0;
        break label263;
        paramView = null;
        break label306;
        i = 0;
        break label80;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarMemberView$popup$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class i
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138602);
      d.g.b.k.h(paramAnimation, "animation");
      ad.d(RadarMemberView.access$getTAG$cp(), "popup animation end");
      RadarMemberView.d(this.uTs).sendEmptyMessage(RadarMemberView.dff());
      AppMethodBeat.o(138602);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(138601);
      d.g.b.k.h(paramAnimation, "animation");
      AppMethodBeat.o(138601);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(138600);
      d.g.b.k.h(paramAnimation, "animation");
      AppMethodBeat.o(138600);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(RadarMemberView paramRadarMemberView) {}
    
    public final void run()
    {
      AppMethodBeat.i(138606);
      if ((this.uTs.getContext() instanceof Activity))
      {
        Object localObject1 = RadarMemberView.uTr;
        localObject1 = this.uTs.getContext();
        if (localObject1 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(138606);
          throw ((Throwable)localObject1);
        }
        Activity localActivity = (Activity)localObject1;
        d.g.b.k.h(localActivity, "ac");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView
 * JD-Core Version:    0.7.0.1
 */