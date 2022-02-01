package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.a.g;
import com.tencent.mm.plugin.radar.b.b.e;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.widget.a.d;
import kotlin.f;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", "listener", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", "username", "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"})
public final class RadarMemberView
  extends RelativeLayout
{
  private static final int Hvg = 0;
  private static final int Hvh = 1;
  public static final RadarMemberView.a Hvi;
  private static final String TAG = "MicroMsg.RadarMemberView";
  private TextView HcF;
  private View HuR;
  private final f HuS;
  private final f HuT;
  private final f HuU;
  private final f HuV;
  private final f HuW;
  private final f HuX;
  private final f HuY;
  private final f HuZ;
  private dsq Hux;
  private b.e Huy;
  private int[] Hva;
  private final f Hvb;
  private co Hvc;
  private b Hvd;
  private final View.OnClickListener Hve;
  private final d Hvf;
  private as contact;
  private boolean mCE;
  private View mUM;
  private d mUO;
  private EditText qDO;
  private TextView yZg;
  
  static
  {
    AppMethodBeat.i(138609);
    Hvi = new RadarMemberView.a((byte)0);
    TAG = "MicroMsg.RadarMemberView";
    Hvh = 1;
    AppMethodBeat.o(138609);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138626);
    this.HuS = i.au(this, a.d.HsU);
    this.HuT = i.au(this, a.d.HsH);
    this.HuU = i.au(this, a.d.HsG);
    this.HuV = i.au(this, a.d.HsJ);
    this.HuW = i.au(this, a.d.HsK);
    this.HuX = i.au(this, a.d.HsO);
    this.HuY = i.au(this, a.d.HsN);
    this.HuZ = i.au(this, a.d.Hta);
    this.Hvb = i.au(this, a.d.HsF);
    this.Hve = ((View.OnClickListener)new h(this));
    this.Hvf = new d(this);
    AppMethodBeat.o(138626);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138627);
    this.HuS = i.au(this, a.d.HsU);
    this.HuT = i.au(this, a.d.HsH);
    this.HuU = i.au(this, a.d.HsG);
    this.HuV = i.au(this, a.d.HsJ);
    this.HuW = i.au(this, a.d.HsK);
    this.HuX = i.au(this, a.d.HsO);
    this.HuY = i.au(this, a.d.HsN);
    this.HuZ = i.au(this, a.d.Hta);
    this.Hvb = i.au(this, a.d.HsF);
    this.Hve = ((View.OnClickListener)new h(this));
    this.Hvf = new d(this);
    AppMethodBeat.o(138627);
  }
  
  private final void a(b.e parame)
  {
    AppMethodBeat.i(138621);
    getExposeTv().setVisibility(0);
    if (parame == null)
    {
      AppMethodBeat.o(138621);
      return;
    }
    switch (c.$EnumSwitchMapping$0[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(a.g.Hts);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(a.g.Htw);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(a.g.Htm);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(a.g.Htl);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setText((CharSequence)getContext().getString(a.g.Hta));
      getSayHiTv().setVisibility(0);
    }
  }
  
  private final ImageView getAvatarCopy()
  {
    AppMethodBeat.i(138611);
    ImageView localImageView = (ImageView)this.HuT.getValue();
    AppMethodBeat.o(138611);
    return localImageView;
  }
  
  private final View getAvatarCopyContainer()
  {
    AppMethodBeat.i(138612);
    View localView = (View)this.HuU.getValue();
    AppMethodBeat.o(138612);
    return localView;
  }
  
  private final View getAvatarHolder()
  {
    AppMethodBeat.i(138610);
    View localView = (View)this.HuS.getValue();
    AppMethodBeat.o(138610);
    return localView;
  }
  
  private final Button getConfirmBtn()
  {
    AppMethodBeat.i(138613);
    Button localButton = (Button)this.HuV.getValue();
    AppMethodBeat.o(138613);
    return localButton;
  }
  
  private final TextView getConfirmBtnDisabled()
  {
    AppMethodBeat.i(138614);
    TextView localTextView = (TextView)this.HuW.getValue();
    AppMethodBeat.o(138614);
    return localTextView;
  }
  
  private final TextView getExposeTv()
  {
    AppMethodBeat.i(138618);
    TextView localTextView = (TextView)this.Hvb.getValue();
    AppMethodBeat.o(138618);
    return localTextView;
  }
  
  private final TextView getMemberNameTv()
  {
    AppMethodBeat.i(138615);
    TextView localTextView = (TextView)this.HuX.getValue();
    AppMethodBeat.o(138615);
    return localTextView;
  }
  
  private final Button getModifyNameBtn()
  {
    AppMethodBeat.i(138616);
    Button localButton = (Button)this.HuY.getValue();
    AppMethodBeat.o(138616);
    return localButton;
  }
  
  private final TextView getSayHiTv()
  {
    AppMethodBeat.i(138617);
    TextView localTextView = (TextView)this.HuZ.getValue();
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
  
  public final void a(View paramView, final dsq paramdsq, b.e parame)
  {
    AppMethodBeat.i(138623);
    p.k(paramView, "view");
    p.k(paramdsq, "member");
    Log.d(TAG, "popup");
    this.Huy = parame;
    this.Hux = paramdsq;
    parame = getConfirmBtn();
    if (parame != null) {
      parame.setOnClickListener((View.OnClickListener)new e(this, paramdsq));
    }
    getModifyNameBtn().setOnClickListener(this.Hve);
    setOnTouchListener((View.OnTouchListener)new f(this));
    getExposeTv().setOnClickListener((View.OnClickListener)new RadarMemberView.g(this));
    parame = g.Hwt;
    parame = g.a(paramdsq);
    if (!kotlin.n.n.ba((CharSequence)parame))
    {
      localObject = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      p.j(localObject, "service(IMessengerStorage::class.java)");
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL().RG(parame);
    }
    Object localObject = this.contact;
    if ((localObject != null) && (((as)localObject).axZ() == true))
    {
      parame = this.contact;
      if (parame != null)
      {
        parame = parame.apg();
        localObject = getMemberNameTv();
        if ((this.contact == null) || (Util.isNullOrNil(parame))) {
          break label611;
        }
      }
    }
    label611:
    for (paramdsq = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (CharSequence)parame, getMemberNameTv().getTextSize());; paramdsq = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (CharSequence)paramdsq.rWI, getMemberNameTv().getTextSize()))
    {
      ((TextView)localObject).setText(paramdsq);
      getMemberNameTv().setVisibility(4);
      getModifyNameBtn().setVisibility(4);
      reset();
      this.HuR = paramView;
      paramView = this.HuR;
      if (paramView == null) {
        p.iCn();
      }
      paramView = paramView.findViewById(a.d.HsW);
      p.j(paramView, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
      paramdsq = (ImageView)paramView;
      paramView = this.HuR;
      if (paramView == null) {
        p.iCn();
      }
      paramView = paramView.findViewById(a.d.HsG);
      p.j(paramView, "avatarItem!!.findViewByI…d.radar_avatar_container)");
      parame = this.HuR;
      if (parame == null) {
        p.iCn();
      }
      parame.setVisibility(4);
      getAvatarCopy().setImageDrawable(paramdsq.getDrawable());
      getAvatarCopyContainer().setVisibility(0);
      parame = new int[2];
      paramView.getLocationInWindow(parame);
      localObject = new int[2];
      getAvatarHolder().getLocationInWindow((int[])localObject);
      this.Hva = ((int[])localObject);
      setVisibility(0);
      paramdsq = new AnimationSet(true);
      paramdsq.setFillAfter(true);
      paramdsq.setRepeatCount(1);
      paramdsq.setDuration(500L);
      float f1 = getAvatarHolder().getHeight() / paramView.getHeight();
      float f2 = (paramView.getWidth() - paramView.getHeight()) / 2;
      paramView = new TranslateAnimation(parame[0], localObject[0] - f2 * f1, parame[1], localObject[1]);
      paramdsq.addAnimation((Animation)new ScaleAnimation(1.0F, f1, 1.0F, f1));
      paramdsq.addAnimation((Animation)paramView);
      paramdsq.setAnimationListener((Animation.AnimationListener)new i(this));
      getAvatarCopyContainer().startAnimation((Animation)paramdsq);
      AppMethodBeat.o(138623);
      return;
      parame = null;
      break;
      localObject = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      p.j(localObject, "service(IMessengerStorage::class.java)");
      this.Hvc = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbM().aPj(parame);
      parame = this.Hvc;
      if (parame != null)
      {
        parame = parame.apg();
        break;
      }
      parame = null;
      break;
    }
  }
  
  public final void c(String paramString, b.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(138620);
    p.k(paramString, "username");
    p.k(parame, "state");
    if ((!isShowing()) || (this.mCE))
    {
      AppMethodBeat.o(138620);
      return;
    }
    Object localObject1 = this.Hux;
    if (localObject1 != null) {}
    for (localObject1 = ((dsq)localObject1).Sxx;; localObject1 = null)
    {
      if (!p.h(paramString, localObject1))
      {
        dsq localdsq = this.Hux;
        localObject1 = localObject2;
        if (localdsq != null) {
          localObject1 = localdsq.UserName;
        }
        if (!p.h(paramString, localObject1)) {}
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
    Log.d(TAG, "dismiss");
    if (this.mCE)
    {
      AppMethodBeat.o(138624);
      return;
    }
    this.mCE = true;
    Object localObject1 = this.HuR;
    if (localObject1 == null) {
      p.iCn();
    }
    Object localObject2 = ((View)localObject1).findViewById(a.d.HsG);
    p.j(localObject2, "avatarItem!!.findViewByI…d.radar_avatar_container)");
    localObject1 = new AnimationSet(true);
    ((AnimationSet)localObject1).setFillAfter(true);
    ((AnimationSet)localObject1).setRepeatCount(1);
    ((AnimationSet)localObject1).setDuration(500L);
    int[] arrayOfInt1 = this.Hva;
    int[] arrayOfInt2 = new int[2];
    ((View)localObject2).getLocationInWindow(arrayOfInt2);
    float f1 = getAvatarHolder().getHeight() / ((View)localObject2).getHeight();
    float f2 = (((View)localObject2).getWidth() - ((View)localObject2).getHeight()) / 2;
    if (arrayOfInt1 == null) {
      p.iCn();
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
  
  public final dsq getMember()
  {
    return this.Hux;
  }
  
  public final b.e getState()
  {
    return this.Huy;
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
    p.k(paramb, "listener");
    this.Hvd = paramb;
    AppMethodBeat.o(138622);
  }
  
  public final void setMember(dsq paramdsq)
  {
    this.Hux = paramdsq;
  }
  
  public final void setState(b.e parame)
  {
    this.Huy = parame;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
  public static abstract interface b
  {
    public abstract void a(dsq paramdsq, b.e parame);
    
    public abstract void b(dsq paramdsq, b.e parame);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class c
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138594);
      p.k(paramAnimation, "animation");
      Log.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
      RadarMemberView.e(this.Hvj);
      RadarMemberView.d(this.Hvj).sendEmptyMessage(RadarMemberView.ftt());
      AppMethodBeat.o(138594);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(138593);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(138593);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(138592);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(138592);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138595);
      p.k(paramMessage, "msg");
      if (paramMessage.what == RadarMemberView.fts())
      {
        paramMessage = this.Hvj;
        this.Hvj.getMember();
        RadarMemberView.a(paramMessage, this.Hvj.getState());
        AppMethodBeat.o(138595);
        return;
      }
      if (paramMessage.what == RadarMemberView.ftt())
      {
        this.Hvj.setVisibility(4);
        RadarMemberView.j(this.Hvj);
        paramMessage = RadarMemberView.k(this.Hvj);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
        paramMessage = RadarMemberView.a(this.Hvj);
        if (paramMessage != null)
        {
          paramMessage.b(this.Hvj.getMember(), this.Hvj.getState());
          AppMethodBeat.o(138595);
          return;
        }
      }
      AppMethodBeat.o(138595);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(RadarMemberView paramRadarMemberView, dsq paramdsq) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138596);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if ((this.Hvj.getState() == null) || (RadarMemberView.a(this.Hvj) == null))
      {
        a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(138596);
        return;
      }
      paramView = RadarMemberView.a(this.Hvj);
      if (paramView != null) {
        paramView.a(paramdsq, this.Hvj.getState());
      }
      this.Hvj.dismiss();
      a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138596);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class f
    implements View.OnTouchListener
  {
    f(RadarMemberView paramRadarMemberView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(138597);
      if (paramView != RadarMemberView.b(this.Hvj))
      {
        p.j(paramMotionEvent, "event");
        if ((paramMotionEvent.getAction() == 1) && (this.Hvj.isShowing())) {
          this.Hvj.dismiss();
        }
      }
      AppMethodBeat.o(138597);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(View paramView)
    {
      RadarMemberView localRadarMemberView = null;
      AppMethodBeat.i(138599);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/radar/ui/RadarMemberView$mOnModifyNameClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      String str = "";
      paramView = str;
      if (RadarMemberView.c(this.Hvj) != null)
      {
        paramView = RadarMemberView.c(this.Hvj);
        if ((paramView == null) || (paramView.axZ() != true)) {
          break label193;
        }
        paramView = RadarMemberView.c(this.Hvj);
        if (paramView == null) {
          break label188;
        }
      }
      int i;
      label188:
      for (paramView = paramView.apg();; paramView = null)
      {
        localObject = (CharSequence)paramView;
        if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
          break;
        }
        i = 1;
        label109:
        localObject = paramView;
        if (i != 0)
        {
          localObject = paramView;
          if (this.Hvj.getMember() != null)
          {
            localObject = this.Hvj.getMember();
            paramView = localRadarMemberView;
            if (localObject != null) {
              paramView = ((dsq)localObject).rWI;
            }
            localObject = paramView;
          }
        }
        localRadarMemberView = this.Hvj;
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
      paramView = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      p.j(paramView, "service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)paramView).bbM();
      paramView = RadarMemberView.c(this.Hvj);
      if (paramView != null)
      {
        paramView = paramView.getUsername();
        label232:
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject).aPj(paramView);
        if (localObject != null)
        {
          paramView = (CharSequence)((co)localObject).apn();
          if ((paramView != null) && (!kotlin.n.n.ba(paramView))) {
            break label375;
          }
          i = 1;
          label265:
          if (i == 0) {
            break label400;
          }
        }
        paramView = RadarMemberView.c(this.Hvj);
        if (paramView == null) {
          break label380;
        }
        paramView = paramView.apn();
        label286:
        paramView = (CharSequence)paramView;
        if ((paramView != null) && (!kotlin.n.n.ba(paramView))) {
          break label385;
        }
        i = 1;
        label304:
        if (i != 0) {
          break label400;
        }
        paramView = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
        p.j(paramView, "service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)paramView).bbM();
        paramView = RadarMemberView.c(this.Hvj);
        if (paramView == null) {
          break label390;
        }
        paramView = paramView.apn();
        label347:
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject).aPj(paramView);
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
        paramView = ((co)localObject).apg();
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarMemberView$popup$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class i
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138602);
      p.k(paramAnimation, "animation");
      Log.d(RadarMemberView.access$getTAG$cp(), "popup animation end");
      RadarMemberView.d(this.Hvj).sendEmptyMessage(RadarMemberView.fts());
      AppMethodBeat.o(138602);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(138601);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(138601);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(138600);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(138600);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarMemberView$showModifyDialog$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-radar_release"})
  public static final class j
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = false;
      AppMethodBeat.i(138605);
      p.k(paramEditable, "s");
      int j = 50 - paramEditable.length();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      Object localObject = RadarMemberView.f(this.Hvj);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)String.valueOf(i));
      }
      localObject = RadarMemberView.g(this.Hvj);
      if (localObject != null)
      {
        localObject = ((d)localObject).ayb(-1);
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
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(138604);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(138603);
      p.k(paramCharSequence, "s");
      AppMethodBeat.o(138603);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class l
    implements DialogInterface.OnClickListener
  {
    l(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138607);
      paramDialogInterface = RadarMemberView.g(this.Hvj);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      RadarMemberView.h(this.Hvj);
      AppMethodBeat.o(138607);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class m
    implements DialogInterface.OnClickListener
  {
    m(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138608);
      if (RadarMemberView.g(this.Hvj) != null)
      {
        paramDialogInterface = RadarMemberView.g(this.Hvj);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        RadarMemberView.h(this.Hvj);
      }
      RadarMemberView.i(this.Hvj);
      AppMethodBeat.o(138608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView
 * JD-Core Version:    0.7.0.1
 */