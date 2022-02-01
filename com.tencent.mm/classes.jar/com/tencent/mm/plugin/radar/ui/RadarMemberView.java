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
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bz;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.g.b.z;
import d.l;
import d.n.n;
import d.v;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", "listener", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", "username", "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"})
public final class RadarMemberView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.RadarMemberView";
  private static final int wce = 0;
  private static final int wcf = 1;
  public static final RadarMemberView.a wcg;
  private ai contact;
  private View iJh;
  private com.tencent.mm.ui.widget.a.d iJj;
  private boolean isP;
  private EditText lMg;
  private TextView sDL;
  private View wbO;
  private final f wbP;
  private final f wbQ;
  private final f wbR;
  private final f wbS;
  private final f wbT;
  private final f wbU;
  private final f wbV;
  private final f wbW;
  private int[] wbX;
  private final f wbY;
  private bz wbZ;
  private cli wbu;
  private c.e wbv;
  private b wca;
  private final View.OnClickListener wcb;
  private final d wcc;
  private TextView wcd;
  
  static
  {
    AppMethodBeat.i(138609);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(RadarMemberView.class), "avatarHolder", "getAvatarHolder()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(RadarMemberView.class), "avatarCopy", "getAvatarCopy()Landroid/widget/ImageView;")), (d.l.k)w.a(new u(w.bn(RadarMemberView.class), "avatarCopyContainer", "getAvatarCopyContainer()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(RadarMemberView.class), "confirmBtn", "getConfirmBtn()Landroid/widget/Button;")), (d.l.k)w.a(new u(w.bn(RadarMemberView.class), "confirmBtnDisabled", "getConfirmBtnDisabled()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bn(RadarMemberView.class), "memberNameTv", "getMemberNameTv()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bn(RadarMemberView.class), "modifyNameBtn", "getModifyNameBtn()Landroid/widget/Button;")), (d.l.k)w.a(new u(w.bn(RadarMemberView.class), "sayHiTv", "getSayHiTv()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bn(RadarMemberView.class), "exposeTv", "getExposeTv()Landroid/widget/TextView;")) };
    wcg = new RadarMemberView.a((byte)0);
    TAG = "MicroMsg.RadarMemberView";
    wcf = 1;
    AppMethodBeat.o(138609);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138626);
    this.wbP = i.an(this, 2131303691);
    this.wbQ = i.an(this, 2131303676);
    this.wbR = i.an(this, 2131303675);
    this.wbS = i.an(this, 2131303679);
    this.wbT = i.an(this, 2131303680);
    this.wbU = i.an(this, 2131303685);
    this.wbV = i.an(this, 2131303684);
    this.wbW = i.an(this, 2131303697);
    this.wbY = i.an(this, 2131299606);
    this.wcb = ((View.OnClickListener)new h(this));
    this.wcc = new d(this);
    AppMethodBeat.o(138626);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138627);
    this.wbP = i.an(this, 2131303691);
    this.wbQ = i.an(this, 2131303676);
    this.wbR = i.an(this, 2131303675);
    this.wbS = i.an(this, 2131303679);
    this.wbT = i.an(this, 2131303680);
    this.wbU = i.an(this, 2131303685);
    this.wbV = i.an(this, 2131303684);
    this.wbW = i.an(this, 2131303697);
    this.wbY = i.an(this, 2131299606);
    this.wcb = ((View.OnClickListener)new h(this));
    this.wcc = new d(this);
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
    switch (c.cfA[parame.ordinal()])
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
    ImageView localImageView = (ImageView)this.wbQ.getValue();
    AppMethodBeat.o(138611);
    return localImageView;
  }
  
  private final View getAvatarCopyContainer()
  {
    AppMethodBeat.i(138612);
    View localView = (View)this.wbR.getValue();
    AppMethodBeat.o(138612);
    return localView;
  }
  
  private final View getAvatarHolder()
  {
    AppMethodBeat.i(138610);
    View localView = (View)this.wbP.getValue();
    AppMethodBeat.o(138610);
    return localView;
  }
  
  private final Button getConfirmBtn()
  {
    AppMethodBeat.i(138613);
    Button localButton = (Button)this.wbS.getValue();
    AppMethodBeat.o(138613);
    return localButton;
  }
  
  private final TextView getConfirmBtnDisabled()
  {
    AppMethodBeat.i(138614);
    TextView localTextView = (TextView)this.wbT.getValue();
    AppMethodBeat.o(138614);
    return localTextView;
  }
  
  private final TextView getExposeTv()
  {
    AppMethodBeat.i(138618);
    TextView localTextView = (TextView)this.wbY.getValue();
    AppMethodBeat.o(138618);
    return localTextView;
  }
  
  private final TextView getMemberNameTv()
  {
    AppMethodBeat.i(138615);
    TextView localTextView = (TextView)this.wbU.getValue();
    AppMethodBeat.o(138615);
    return localTextView;
  }
  
  private final Button getModifyNameBtn()
  {
    AppMethodBeat.i(138616);
    Button localButton = (Button)this.wbV.getValue();
    AppMethodBeat.o(138616);
    return localButton;
  }
  
  private final TextView getSayHiTv()
  {
    AppMethodBeat.i(138617);
    TextView localTextView = (TextView)this.wbW.getValue();
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
  
  public final void a(View paramView, final cli paramcli, c.e parame)
  {
    AppMethodBeat.i(138623);
    d.g.b.k.h(paramView, "view");
    d.g.b.k.h(paramcli, "member");
    ac.d(TAG, "popup");
    this.wbv = parame;
    this.wbu = paramcli;
    parame = getConfirmBtn();
    if (parame != null) {
      parame.setOnClickListener((View.OnClickListener)new e(this, paramcli));
    }
    getModifyNameBtn().setOnClickListener(this.wcb);
    setOnTouchListener((View.OnTouchListener)new f(this));
    getExposeTv().setOnClickListener((View.OnClickListener)new g(this));
    parame = g.wdr;
    parame = g.b(paramcli);
    if (!n.aD((CharSequence)parame))
    {
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "service(IMessengerStorage::class.java)");
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(parame);
    }
    Object localObject = this.contact;
    if ((localObject != null) && (((ai)localObject).aaE() == true))
    {
      parame = this.contact;
      if (parame != null)
      {
        parame = parame.Tm();
        localObject = getMemberNameTv();
        if ((this.contact == null) || (bs.isNullOrNil(parame))) {
          break label611;
        }
      }
    }
    label611:
    for (paramcli = (CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)parame, getMemberNameTv().getTextSize());; paramcli = (CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)paramcli.ndW, getMemberNameTv().getTextSize()))
    {
      ((TextView)localObject).setText(paramcli);
      getMemberNameTv().setVisibility(4);
      getModifyNameBtn().setVisibility(4);
      reset();
      this.wbO = paramView;
      paramView = this.wbO;
      if (paramView == null) {
        d.g.b.k.fOy();
      }
      paramView = paramView.findViewById(2131303693);
      d.g.b.k.g(paramView, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
      paramcli = (ImageView)paramView;
      paramView = this.wbO;
      if (paramView == null) {
        d.g.b.k.fOy();
      }
      paramView = paramView.findViewById(2131303675);
      d.g.b.k.g(paramView, "avatarItem!!.findViewByI…d.radar_avatar_container)");
      parame = this.wbO;
      if (parame == null) {
        d.g.b.k.fOy();
      }
      parame.setVisibility(4);
      getAvatarCopy().setImageDrawable(paramcli.getDrawable());
      getAvatarCopyContainer().setVisibility(0);
      parame = new int[2];
      paramView.getLocationInWindow(parame);
      localObject = new int[2];
      getAvatarHolder().getLocationInWindow((int[])localObject);
      this.wbX = ((int[])localObject);
      setVisibility(0);
      paramcli = new AnimationSet(true);
      paramcli.setFillAfter(true);
      paramcli.setRepeatCount(1);
      paramcli.setDuration(500L);
      float f1 = getAvatarHolder().getHeight() / paramView.getHeight();
      float f2 = (paramView.getWidth() - paramView.getHeight()) / 2;
      paramView = new TranslateAnimation(parame[0], localObject[0] - f2 * f1, parame[1], localObject[1]);
      paramcli.addAnimation((Animation)new ScaleAnimation(1.0F, f1, 1.0F, f1));
      paramcli.addAnimation((Animation)paramView);
      paramcli.setAnimationListener((Animation.AnimationListener)new i(this));
      getAvatarCopyContainer().startAnimation((Animation)paramcli);
      AppMethodBeat.o(138623);
      return;
      parame = null;
      break;
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "service(IMessengerStorage::class.java)");
      this.wbZ = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awC().alK(parame);
      parame = this.wbZ;
      if (parame != null)
      {
        parame = parame.Tm();
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
    if ((!isShowing()) || (this.isP))
    {
      AppMethodBeat.o(138620);
      return;
    }
    Object localObject1 = this.wbu;
    if (localObject1 != null) {}
    for (localObject1 = ((cli)localObject1).EyO;; localObject1 = null)
    {
      if (!d.g.b.k.g(paramString, localObject1))
      {
        cli localcli = this.wbu;
        localObject1 = localObject2;
        if (localcli != null) {
          localObject1 = localcli.ncR;
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
    ac.d(TAG, "dismiss");
    if (this.isP)
    {
      AppMethodBeat.o(138624);
      return;
    }
    this.isP = true;
    Object localObject1 = this.wbO;
    if (localObject1 == null) {
      d.g.b.k.fOy();
    }
    Object localObject2 = ((View)localObject1).findViewById(2131303675);
    d.g.b.k.g(localObject2, "avatarItem!!.findViewByI…d.radar_avatar_container)");
    localObject1 = new AnimationSet(true);
    ((AnimationSet)localObject1).setFillAfter(true);
    ((AnimationSet)localObject1).setRepeatCount(1);
    ((AnimationSet)localObject1).setDuration(500L);
    int[] arrayOfInt1 = this.wbX;
    int[] arrayOfInt2 = new int[2];
    ((View)localObject2).getLocationInWindow(arrayOfInt2);
    float f1 = getAvatarHolder().getHeight() / ((View)localObject2).getHeight();
    float f2 = (((View)localObject2).getWidth() - ((View)localObject2).getHeight()) / 2;
    if (arrayOfInt1 == null) {
      d.g.b.k.fOy();
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
  
  public final cli getMember()
  {
    return this.wbu;
  }
  
  public final c.e getState()
  {
    return this.wbv;
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
    this.wca = paramb;
    AppMethodBeat.o(138622);
  }
  
  public final void setMember(cli paramcli)
  {
    this.wbu = paramcli;
  }
  
  public final void setState(c.e parame)
  {
    this.wbv = parame;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
  public static abstract interface b
  {
    public abstract void a(cli paramcli, c.e parame);
    
    public abstract void b(cli paramcli, c.e parame);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class c
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138594);
      d.g.b.k.h(paramAnimation, "animation");
      ac.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
      RadarMemberView.e(this.wch);
      RadarMemberView.d(this.wch).sendEmptyMessage(RadarMemberView.dsN());
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends ao
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138595);
      d.g.b.k.h(paramMessage, "msg");
      if (paramMessage.what == RadarMemberView.dsM())
      {
        paramMessage = this.wch;
        this.wch.getMember();
        RadarMemberView.a(paramMessage, this.wch.getState());
        AppMethodBeat.o(138595);
        return;
      }
      if (paramMessage.what == RadarMemberView.dsN())
      {
        this.wch.setVisibility(4);
        RadarMemberView.j(this.wch);
        paramMessage = RadarMemberView.k(this.wch);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
        paramMessage = RadarMemberView.a(this.wch);
        if (paramMessage != null)
        {
          paramMessage.b(this.wch.getMember(), this.wch.getState());
          AppMethodBeat.o(138595);
          return;
        }
      }
      AppMethodBeat.o(138595);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(RadarMemberView paramRadarMemberView, cli paramcli) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138596);
      if ((this.wch.getState() == null) || (RadarMemberView.a(this.wch) == null))
      {
        AppMethodBeat.o(138596);
        return;
      }
      paramView = RadarMemberView.a(this.wch);
      if (paramView != null) {
        paramView.a(paramcli, this.wch.getState());
      }
      this.wch.dismiss();
      AppMethodBeat.o(138596);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class f
    implements View.OnTouchListener
  {
    f(RadarMemberView paramRadarMemberView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(138597);
      if (paramView != RadarMemberView.b(this.wch))
      {
        d.g.b.k.g(paramMotionEvent, "event");
        if ((paramMotionEvent.getAction() == 1) && (this.wch.isShowing())) {
          this.wch.dismiss();
        }
      }
      AppMethodBeat.o(138597);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138598);
      Intent localIntent = new Intent();
      paramView = RadarMemberView.c(this.wch);
      if (paramView != null) {}
      for (paramView = paramView.getUsername();; paramView = null)
      {
        localIntent.putExtra("k_username", paramView);
        localIntent.putExtra("showShare", false);
        paramView = z.KUT;
        paramView = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(38) }, 1));
        d.g.b.k.g(paramView, "java.lang.String.format(format, *args)");
        localIntent.putExtra("rawUrl", paramView);
        com.tencent.mm.br.d.b(this.wch.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(138598);
        return;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
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
      if (RadarMemberView.c(this.wch) != null)
      {
        paramView = RadarMemberView.c(this.wch);
        if ((paramView == null) || (paramView.aaE() != true)) {
          break label152;
        }
        paramView = RadarMemberView.c(this.wch);
        if (paramView == null) {
          break label147;
        }
      }
      int i;
      label147:
      for (paramView = paramView.Tm();; paramView = null)
      {
        localObject = (CharSequence)paramView;
        if ((localObject != null) && (!n.aD((CharSequence)localObject))) {
          break;
        }
        i = 1;
        label80:
        localObject = paramView;
        if (i != 0)
        {
          localObject = paramView;
          if (this.wch.getMember() != null)
          {
            localObject = this.wch.getMember();
            paramView = localRadarMemberView;
            if (localObject != null) {
              paramView = ((cli)localObject).ndW;
            }
            localObject = paramView;
          }
        }
        localRadarMemberView = this.wch;
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
      Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramView).awC();
      paramView = RadarMemberView.c(this.wch);
      if (paramView != null)
      {
        paramView = paramView.getUsername();
        label191:
        localObject = ((m)localObject).alK(paramView);
        if (localObject != null)
        {
          paramView = (CharSequence)((bz)localObject).Tq();
          if ((paramView != null) && (!n.aD(paramView))) {
            break label334;
          }
          i = 1;
          label224:
          if (i == 0) {
            break label359;
          }
        }
        paramView = RadarMemberView.c(this.wch);
        if (paramView == null) {
          break label339;
        }
        paramView = paramView.Tq();
        label245:
        paramView = (CharSequence)paramView;
        if ((paramView != null) && (!n.aD(paramView))) {
          break label344;
        }
        i = 1;
        label263:
        if (i != 0) {
          break label359;
        }
        paramView = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(paramView, "service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramView).awC();
        paramView = RadarMemberView.c(this.wch);
        if (paramView == null) {
          break label349;
        }
        paramView = paramView.Tq();
        label306:
        localObject = ((m)localObject).alK(paramView);
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
        paramView = ((bz)localObject).Tm();
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarMemberView$popup$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class i
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138602);
      d.g.b.k.h(paramAnimation, "animation");
      ac.d(RadarMemberView.access$getTAG$cp(), "popup animation end");
      RadarMemberView.d(this.wch).sendEmptyMessage(RadarMemberView.dsM());
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarMemberView$showModifyDialog$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-radar_release"})
  public static final class j
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = false;
      AppMethodBeat.i(138605);
      d.g.b.k.h(paramEditable, "s");
      int j = 50 - paramEditable.length();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      Object localObject = RadarMemberView.f(this.wch);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)String.valueOf(i));
      }
      localObject = RadarMemberView.g(this.wch);
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
      d.g.b.k.h(paramCharSequence, "s");
      AppMethodBeat.o(138604);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(138603);
      d.g.b.k.h(paramCharSequence, "s");
      AppMethodBeat.o(138603);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(RadarMemberView paramRadarMemberView) {}
    
    public final void run()
    {
      AppMethodBeat.i(138606);
      if ((this.wch.getContext() instanceof Activity))
      {
        Object localObject1 = RadarMemberView.wcg;
        localObject1 = this.wch.getContext();
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class l
    implements DialogInterface.OnClickListener
  {
    l(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138607);
      paramDialogInterface = RadarMemberView.g(this.wch);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      RadarMemberView.h(this.wch);
      AppMethodBeat.o(138607);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class m
    implements DialogInterface.OnClickListener
  {
    m(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138608);
      if (RadarMemberView.g(this.wch) != null)
      {
        paramDialogInterface = RadarMemberView.g(this.wch);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        RadarMemberView.h(this.wch);
      }
      RadarMemberView.i(this.wch);
      AppMethodBeat.o(138608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView
 * JD-Core Version:    0.7.0.1
 */