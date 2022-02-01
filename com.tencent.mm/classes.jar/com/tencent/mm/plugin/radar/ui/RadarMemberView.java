package com.tencent.mm.plugin.radar.ui;

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
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.widget.a.d;
import d.f;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", "listener", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", "username", "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"})
public final class RadarMemberView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.RadarMemberView";
  private static final int xzK = 0;
  private static final int xzL = 1;
  public static final RadarMemberView.a xzM;
  private an contact;
  private boolean iOL;
  private View jfj;
  private d jfl;
  private EditText mqR;
  private TextView tLr;
  private final f xzA;
  private final f xzB;
  private final f xzC;
  private int[] xzD;
  private final f xzE;
  private cg xzF;
  private b xzG;
  private final View.OnClickListener xzH;
  private final d xzI;
  private TextView xzJ;
  private crc xza;
  private c.e xzb;
  private View xzu;
  private final f xzv;
  private final f xzw;
  private final f xzx;
  private final f xzy;
  private final f xzz;
  
  static
  {
    AppMethodBeat.i(138609);
    xzM = new RadarMemberView.a((byte)0);
    TAG = "MicroMsg.RadarMemberView";
    xzL = 1;
    AppMethodBeat.o(138609);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138626);
    this.xzv = i.ao(this, 2131303691);
    this.xzw = i.ao(this, 2131303676);
    this.xzx = i.ao(this, 2131303675);
    this.xzy = i.ao(this, 2131303679);
    this.xzz = i.ao(this, 2131303680);
    this.xzA = i.ao(this, 2131303685);
    this.xzB = i.ao(this, 2131303684);
    this.xzC = i.ao(this, 2131303697);
    this.xzE = i.ao(this, 2131299606);
    this.xzH = ((View.OnClickListener)new h(this));
    this.xzI = new d(this);
    AppMethodBeat.o(138626);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138627);
    this.xzv = i.ao(this, 2131303691);
    this.xzw = i.ao(this, 2131303676);
    this.xzx = i.ao(this, 2131303675);
    this.xzy = i.ao(this, 2131303679);
    this.xzz = i.ao(this, 2131303680);
    this.xzA = i.ao(this, 2131303685);
    this.xzB = i.ao(this, 2131303684);
    this.xzC = i.ao(this, 2131303697);
    this.xzE = i.ao(this, 2131299606);
    this.xzH = ((View.OnClickListener)new h(this));
    this.xzI = new d(this);
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
    switch (c.cqt[parame.ordinal()])
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
    ImageView localImageView = (ImageView)this.xzw.getValue();
    AppMethodBeat.o(138611);
    return localImageView;
  }
  
  private final View getAvatarCopyContainer()
  {
    AppMethodBeat.i(138612);
    View localView = (View)this.xzx.getValue();
    AppMethodBeat.o(138612);
    return localView;
  }
  
  private final View getAvatarHolder()
  {
    AppMethodBeat.i(138610);
    View localView = (View)this.xzv.getValue();
    AppMethodBeat.o(138610);
    return localView;
  }
  
  private final Button getConfirmBtn()
  {
    AppMethodBeat.i(138613);
    Button localButton = (Button)this.xzy.getValue();
    AppMethodBeat.o(138613);
    return localButton;
  }
  
  private final TextView getConfirmBtnDisabled()
  {
    AppMethodBeat.i(138614);
    TextView localTextView = (TextView)this.xzz.getValue();
    AppMethodBeat.o(138614);
    return localTextView;
  }
  
  private final TextView getExposeTv()
  {
    AppMethodBeat.i(138618);
    TextView localTextView = (TextView)this.xzE.getValue();
    AppMethodBeat.o(138618);
    return localTextView;
  }
  
  private final TextView getMemberNameTv()
  {
    AppMethodBeat.i(138615);
    TextView localTextView = (TextView)this.xzA.getValue();
    AppMethodBeat.o(138615);
    return localTextView;
  }
  
  private final Button getModifyNameBtn()
  {
    AppMethodBeat.i(138616);
    Button localButton = (Button)this.xzB.getValue();
    AppMethodBeat.o(138616);
    return localButton;
  }
  
  private final TextView getSayHiTv()
  {
    AppMethodBeat.i(138617);
    TextView localTextView = (TextView)this.xzC.getValue();
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
  
  public final void a(View paramView, final crc paramcrc, c.e parame)
  {
    AppMethodBeat.i(138623);
    p.h(paramView, "view");
    p.h(paramcrc, "member");
    ae.d(TAG, "popup");
    this.xzb = parame;
    this.xza = paramcrc;
    parame = getConfirmBtn();
    if (parame != null) {
      parame.setOnClickListener((View.OnClickListener)new e(this, paramcrc));
    }
    getModifyNameBtn().setOnClickListener(this.xzH);
    setOnTouchListener((View.OnTouchListener)new f(this));
    getExposeTv().setOnClickListener((View.OnClickListener)new RadarMemberView.g(this));
    parame = g.xAX;
    parame = g.b(paramcrc);
    if (!d.n.n.aD((CharSequence)parame))
    {
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "service(IMessengerStorage::class.java)");
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().BH(parame);
    }
    Object localObject = this.contact;
    if ((localObject != null) && (((an)localObject).ads() == true))
    {
      parame = this.contact;
      if (parame != null)
      {
        parame = parame.VJ();
        localObject = getMemberNameTv();
        if ((this.contact == null) || (bu.isNullOrNil(parame))) {
          break label610;
        }
      }
    }
    label610:
    for (paramcrc = (CharSequence)k.b(getContext(), (CharSequence)parame, getMemberNameTv().getTextSize());; paramcrc = (CharSequence)k.b(getContext(), (CharSequence)paramcrc.nJO, getMemberNameTv().getTextSize()))
    {
      ((TextView)localObject).setText(paramcrc);
      getMemberNameTv().setVisibility(4);
      getModifyNameBtn().setVisibility(4);
      reset();
      this.xzu = paramView;
      paramView = this.xzu;
      if (paramView == null) {
        p.gkB();
      }
      paramView = paramView.findViewById(2131303693);
      p.g(paramView, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
      paramcrc = (ImageView)paramView;
      paramView = this.xzu;
      if (paramView == null) {
        p.gkB();
      }
      paramView = paramView.findViewById(2131303675);
      p.g(paramView, "avatarItem!!.findViewByI…d.radar_avatar_container)");
      parame = this.xzu;
      if (parame == null) {
        p.gkB();
      }
      parame.setVisibility(4);
      getAvatarCopy().setImageDrawable(paramcrc.getDrawable());
      getAvatarCopyContainer().setVisibility(0);
      parame = new int[2];
      paramView.getLocationInWindow(parame);
      localObject = new int[2];
      getAvatarHolder().getLocationInWindow((int[])localObject);
      this.xzD = ((int[])localObject);
      setVisibility(0);
      paramcrc = new AnimationSet(true);
      paramcrc.setFillAfter(true);
      paramcrc.setRepeatCount(1);
      paramcrc.setDuration(500L);
      float f1 = getAvatarHolder().getHeight() / paramView.getHeight();
      float f2 = (paramView.getWidth() - paramView.getHeight()) / 2;
      paramView = new TranslateAnimation(parame[0], localObject[0] - f2 * f1, parame[1], localObject[1]);
      paramcrc.addAnimation((Animation)new ScaleAnimation(1.0F, f1, 1.0F, f1));
      paramcrc.addAnimation((Animation)paramView);
      paramcrc.setAnimationListener((Animation.AnimationListener)new i(this));
      getAvatarCopyContainer().startAnimation((Animation)paramcrc);
      AppMethodBeat.o(138623);
      return;
      parame = null;
      break;
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "service(IMessengerStorage::class.java)");
      this.xzF = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azG().arE(parame);
      parame = this.xzF;
      if (parame != null)
      {
        parame = parame.VJ();
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
    if ((!isShowing()) || (this.iOL))
    {
      AppMethodBeat.o(138620);
      return;
    }
    Object localObject1 = this.xza;
    if (localObject1 != null) {}
    for (localObject1 = ((crc)localObject1).Gzj;; localObject1 = null)
    {
      if (!p.i(paramString, localObject1))
      {
        crc localcrc = this.xza;
        localObject1 = localObject2;
        if (localcrc != null) {
          localObject1 = localcrc.nIJ;
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
    ae.d(TAG, "dismiss");
    if (this.iOL)
    {
      AppMethodBeat.o(138624);
      return;
    }
    this.iOL = true;
    Object localObject1 = this.xzu;
    if (localObject1 == null) {
      p.gkB();
    }
    Object localObject2 = ((View)localObject1).findViewById(2131303675);
    p.g(localObject2, "avatarItem!!.findViewByI…d.radar_avatar_container)");
    localObject1 = new AnimationSet(true);
    ((AnimationSet)localObject1).setFillAfter(true);
    ((AnimationSet)localObject1).setRepeatCount(1);
    ((AnimationSet)localObject1).setDuration(500L);
    int[] arrayOfInt1 = this.xzD;
    int[] arrayOfInt2 = new int[2];
    ((View)localObject2).getLocationInWindow(arrayOfInt2);
    float f1 = getAvatarHolder().getHeight() / ((View)localObject2).getHeight();
    float f2 = (((View)localObject2).getWidth() - ((View)localObject2).getHeight()) / 2;
    if (arrayOfInt1 == null) {
      p.gkB();
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
  
  public final crc getMember()
  {
    return this.xza;
  }
  
  public final c.e getState()
  {
    return this.xzb;
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
    this.xzG = paramb;
    AppMethodBeat.o(138622);
  }
  
  public final void setMember(crc paramcrc)
  {
    this.xza = paramcrc;
  }
  
  public final void setState(c.e parame)
  {
    this.xzb = parame;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
  public static abstract interface b
  {
    public abstract void a(crc paramcrc, c.e parame);
    
    public abstract void b(crc paramcrc, c.e parame);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class c
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138594);
      p.h(paramAnimation, "animation");
      ae.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
      RadarMemberView.e(this.xzN);
      RadarMemberView.d(this.xzN).sendEmptyMessage(RadarMemberView.dGB());
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends aq
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138595);
      p.h(paramMessage, "msg");
      if (paramMessage.what == RadarMemberView.dGA())
      {
        paramMessage = this.xzN;
        this.xzN.getMember();
        RadarMemberView.a(paramMessage, this.xzN.getState());
        AppMethodBeat.o(138595);
        return;
      }
      if (paramMessage.what == RadarMemberView.dGB())
      {
        this.xzN.setVisibility(4);
        RadarMemberView.j(this.xzN);
        paramMessage = RadarMemberView.k(this.xzN);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
        paramMessage = RadarMemberView.a(this.xzN);
        if (paramMessage != null)
        {
          paramMessage.b(this.xzN.getMember(), this.xzN.getState());
          AppMethodBeat.o(138595);
          return;
        }
      }
      AppMethodBeat.o(138595);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(RadarMemberView paramRadarMemberView, crc paramcrc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138596);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if ((this.xzN.getState() == null) || (RadarMemberView.a(this.xzN) == null))
      {
        a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(138596);
        return;
      }
      paramView = RadarMemberView.a(this.xzN);
      if (paramView != null) {
        paramView.a(paramcrc, this.xzN.getState());
      }
      this.xzN.dismiss();
      a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138596);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
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
      a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
      if (paramView != RadarMemberView.b(this.xzN))
      {
        p.g(paramMotionEvent, "event");
        if ((paramMotionEvent.getAction() == 1) && (this.xzN.isShowing())) {
          this.xzN.dismiss();
        }
      }
      a.a(true, this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(138597);
      return true;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
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
      a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$mOnModifyNameClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      String str = "";
      paramView = str;
      if (RadarMemberView.c(this.xzN) != null)
      {
        paramView = RadarMemberView.c(this.xzN);
        if ((paramView == null) || (paramView.ads() != true)) {
          break label193;
        }
        paramView = RadarMemberView.c(this.xzN);
        if (paramView == null) {
          break label188;
        }
      }
      int i;
      label188:
      for (paramView = paramView.VJ();; paramView = null)
      {
        localObject = (CharSequence)paramView;
        if ((localObject != null) && (!d.n.n.aD((CharSequence)localObject))) {
          break;
        }
        i = 1;
        label109:
        localObject = paramView;
        if (i != 0)
        {
          localObject = paramView;
          if (this.xzN.getMember() != null)
          {
            localObject = this.xzN.getMember();
            paramView = localRadarMemberView;
            if (localObject != null) {
              paramView = ((crc)localObject).nJO;
            }
            localObject = paramView;
          }
        }
        localRadarMemberView = this.xzN;
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
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView).azG();
      paramView = RadarMemberView.c(this.xzN);
      if (paramView != null)
      {
        paramView = paramView.getUsername();
        label232:
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject).arE(paramView);
        if (localObject != null)
        {
          paramView = (CharSequence)((cg)localObject).VN();
          if ((paramView != null) && (!d.n.n.aD(paramView))) {
            break label375;
          }
          i = 1;
          label265:
          if (i == 0) {
            break label400;
          }
        }
        paramView = RadarMemberView.c(this.xzN);
        if (paramView == null) {
          break label380;
        }
        paramView = paramView.VN();
        label286:
        paramView = (CharSequence)paramView;
        if ((paramView != null) && (!d.n.n.aD(paramView))) {
          break label385;
        }
        i = 1;
        label304:
        if (i != 0) {
          break label400;
        }
        paramView = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(paramView, "service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView).azG();
        paramView = RadarMemberView.c(this.xzN);
        if (paramView == null) {
          break label390;
        }
        paramView = paramView.VN();
        label347:
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject).arE(paramView);
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
        paramView = ((cg)localObject).VJ();
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarMemberView$popup$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class i
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138602);
      p.h(paramAnimation, "animation");
      ae.d(RadarMemberView.access$getTAG$cp(), "popup animation end");
      RadarMemberView.d(this.xzN).sendEmptyMessage(RadarMemberView.dGA());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView
 * JD-Core Version:    0.7.0.1
 */