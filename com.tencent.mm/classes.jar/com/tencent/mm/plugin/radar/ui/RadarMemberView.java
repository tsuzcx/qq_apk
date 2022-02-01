package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
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
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.widget.a.d;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", "listener", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", "username", "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"})
public final class RadarMemberView
  extends RelativeLayout
{
  private static final int BzL = 0;
  private static final int BzM = 1;
  public static final RadarMemberView.a BzN;
  private static final String TAG = "MicroMsg.RadarMemberView";
  private final f BzA;
  private final f BzB;
  private final f BzC;
  private final f BzD;
  private int[] BzE;
  private final f BzF;
  private cn BzG;
  private b BzH;
  private final View.OnClickListener BzI;
  private final d BzJ;
  private TextView BzK;
  private djb Bzb;
  private c.e Bzc;
  private View Bzv;
  private final f Bzw;
  private final f Bzx;
  private final f Bzy;
  private final f Bzz;
  private as contact;
  private boolean jLA;
  private View kdm;
  private d kdo;
  private EditText nBD;
  private TextView xcs;
  
  static
  {
    AppMethodBeat.i(138609);
    BzN = new RadarMemberView.a((byte)0);
    TAG = "MicroMsg.RadarMemberView";
    BzM = 1;
    AppMethodBeat.o(138609);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138626);
    this.Bzw = i.aq(this, 2131306470);
    this.Bzx = i.aq(this, 2131306455);
    this.Bzy = i.aq(this, 2131306454);
    this.Bzz = i.aq(this, 2131306458);
    this.BzA = i.aq(this, 2131306459);
    this.BzB = i.aq(this, 2131306464);
    this.BzC = i.aq(this, 2131306463);
    this.BzD = i.aq(this, 2131306476);
    this.BzF = i.aq(this, 2131300240);
    this.BzI = ((View.OnClickListener)new h(this));
    this.BzJ = new d(this);
    AppMethodBeat.o(138626);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138627);
    this.Bzw = i.aq(this, 2131306470);
    this.Bzx = i.aq(this, 2131306455);
    this.Bzy = i.aq(this, 2131306454);
    this.Bzz = i.aq(this, 2131306458);
    this.BzA = i.aq(this, 2131306459);
    this.BzB = i.aq(this, 2131306464);
    this.BzC = i.aq(this, 2131306463);
    this.BzD = i.aq(this, 2131306476);
    this.BzF = i.aq(this, 2131300240);
    this.BzI = ((View.OnClickListener)new h(this));
    this.BzJ = new d(this);
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
    switch (c.$EnumSwitchMapping$0[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(2131764173);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(2131764180);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(2131764160);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(138621);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(2131764159);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setText((CharSequence)getContext().getString(2131764171));
      getSayHiTv().setVisibility(0);
    }
  }
  
  private final ImageView getAvatarCopy()
  {
    AppMethodBeat.i(138611);
    ImageView localImageView = (ImageView)this.Bzx.getValue();
    AppMethodBeat.o(138611);
    return localImageView;
  }
  
  private final View getAvatarCopyContainer()
  {
    AppMethodBeat.i(138612);
    View localView = (View)this.Bzy.getValue();
    AppMethodBeat.o(138612);
    return localView;
  }
  
  private final View getAvatarHolder()
  {
    AppMethodBeat.i(138610);
    View localView = (View)this.Bzw.getValue();
    AppMethodBeat.o(138610);
    return localView;
  }
  
  private final Button getConfirmBtn()
  {
    AppMethodBeat.i(138613);
    Button localButton = (Button)this.Bzz.getValue();
    AppMethodBeat.o(138613);
    return localButton;
  }
  
  private final TextView getConfirmBtnDisabled()
  {
    AppMethodBeat.i(138614);
    TextView localTextView = (TextView)this.BzA.getValue();
    AppMethodBeat.o(138614);
    return localTextView;
  }
  
  private final TextView getExposeTv()
  {
    AppMethodBeat.i(138618);
    TextView localTextView = (TextView)this.BzF.getValue();
    AppMethodBeat.o(138618);
    return localTextView;
  }
  
  private final TextView getMemberNameTv()
  {
    AppMethodBeat.i(138615);
    TextView localTextView = (TextView)this.BzB.getValue();
    AppMethodBeat.o(138615);
    return localTextView;
  }
  
  private final Button getModifyNameBtn()
  {
    AppMethodBeat.i(138616);
    Button localButton = (Button)this.BzC.getValue();
    AppMethodBeat.o(138616);
    return localButton;
  }
  
  private final TextView getSayHiTv()
  {
    AppMethodBeat.i(138617);
    TextView localTextView = (TextView)this.BzD.getValue();
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
  
  public final void a(View paramView, final djb paramdjb, c.e parame)
  {
    AppMethodBeat.i(138623);
    p.h(paramView, "view");
    p.h(paramdjb, "member");
    Log.d(TAG, "popup");
    this.Bzc = parame;
    this.Bzb = paramdjb;
    parame = getConfirmBtn();
    if (parame != null) {
      parame.setOnClickListener((View.OnClickListener)new e(this, paramdjb));
    }
    getModifyNameBtn().setOnClickListener(this.BzI);
    setOnTouchListener((View.OnTouchListener)new f(this));
    getExposeTv().setOnClickListener((View.OnClickListener)new RadarMemberView.g(this));
    parame = g.BAY;
    parame = g.b(paramdjb);
    if (!kotlin.n.n.aL((CharSequence)parame))
    {
      localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "service(IMessengerStorage::class.java)");
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(parame);
    }
    Object localObject = this.contact;
    if ((localObject != null) && (((as)localObject).arv() == true))
    {
      parame = this.contact;
      if (parame != null)
      {
        parame = parame.ajy();
        localObject = getMemberNameTv();
        if ((this.contact == null) || (Util.isNullOrNil(parame))) {
          break label610;
        }
      }
    }
    label610:
    for (paramdjb = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (CharSequence)parame, getMemberNameTv().getTextSize());; paramdjb = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (CharSequence)paramdjb.oUJ, getMemberNameTv().getTextSize()))
    {
      ((TextView)localObject).setText(paramdjb);
      getMemberNameTv().setVisibility(4);
      getModifyNameBtn().setVisibility(4);
      reset();
      this.Bzv = paramView;
      paramView = this.Bzv;
      if (paramView == null) {
        p.hyc();
      }
      paramView = paramView.findViewById(2131306472);
      p.g(paramView, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
      paramdjb = (ImageView)paramView;
      paramView = this.Bzv;
      if (paramView == null) {
        p.hyc();
      }
      paramView = paramView.findViewById(2131306454);
      p.g(paramView, "avatarItem!!.findViewByI…d.radar_avatar_container)");
      parame = this.Bzv;
      if (parame == null) {
        p.hyc();
      }
      parame.setVisibility(4);
      getAvatarCopy().setImageDrawable(paramdjb.getDrawable());
      getAvatarCopyContainer().setVisibility(0);
      parame = new int[2];
      paramView.getLocationInWindow(parame);
      localObject = new int[2];
      getAvatarHolder().getLocationInWindow((int[])localObject);
      this.BzE = ((int[])localObject);
      setVisibility(0);
      paramdjb = new AnimationSet(true);
      paramdjb.setFillAfter(true);
      paramdjb.setRepeatCount(1);
      paramdjb.setDuration(500L);
      float f1 = getAvatarHolder().getHeight() / paramView.getHeight();
      float f2 = (paramView.getWidth() - paramView.getHeight()) / 2;
      paramView = new TranslateAnimation(parame[0], localObject[0] - f2 * f1, parame[1], localObject[1]);
      paramdjb.addAnimation((Animation)new ScaleAnimation(1.0F, f1, 1.0F, f1));
      paramdjb.addAnimation((Animation)paramView);
      paramdjb.setAnimationListener((Animation.AnimationListener)new i(this));
      getAvatarCopyContainer().startAnimation((Animation)paramdjb);
      AppMethodBeat.o(138623);
      return;
      parame = null;
      break;
      localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "service(IMessengerStorage::class.java)");
      this.BzG = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSO().aEZ(parame);
      parame = this.BzG;
      if (parame != null)
      {
        parame = parame.ajy();
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
    if ((!isShowing()) || (this.jLA))
    {
      AppMethodBeat.o(138620);
      return;
    }
    Object localObject1 = this.Bzb;
    if (localObject1 != null) {}
    for (localObject1 = ((djb)localObject1).LuX;; localObject1 = null)
    {
      if (!p.j(paramString, localObject1))
      {
        djb localdjb = this.Bzb;
        localObject1 = localObject2;
        if (localdjb != null) {
          localObject1 = localdjb.UserName;
        }
        if (!p.j(paramString, localObject1)) {}
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
    if (this.jLA)
    {
      AppMethodBeat.o(138624);
      return;
    }
    this.jLA = true;
    Object localObject1 = this.Bzv;
    if (localObject1 == null) {
      p.hyc();
    }
    Object localObject2 = ((View)localObject1).findViewById(2131306454);
    p.g(localObject2, "avatarItem!!.findViewByI…d.radar_avatar_container)");
    localObject1 = new AnimationSet(true);
    ((AnimationSet)localObject1).setFillAfter(true);
    ((AnimationSet)localObject1).setRepeatCount(1);
    ((AnimationSet)localObject1).setDuration(500L);
    int[] arrayOfInt1 = this.BzE;
    int[] arrayOfInt2 = new int[2];
    ((View)localObject2).getLocationInWindow(arrayOfInt2);
    float f1 = getAvatarHolder().getHeight() / ((View)localObject2).getHeight();
    float f2 = (((View)localObject2).getWidth() - ((View)localObject2).getHeight()) / 2;
    if (arrayOfInt1 == null) {
      p.hyc();
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
  
  public final djb getMember()
  {
    return this.Bzb;
  }
  
  public final c.e getState()
  {
    return this.Bzc;
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
    this.BzH = paramb;
    AppMethodBeat.o(138622);
  }
  
  public final void setMember(djb paramdjb)
  {
    this.Bzb = paramdjb;
  }
  
  public final void setState(c.e parame)
  {
    this.Bzc = parame;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
  public static abstract interface b
  {
    public abstract void a(djb paramdjb, c.e parame);
    
    public abstract void b(djb paramdjb, c.e parame);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class c
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138594);
      p.h(paramAnimation, "animation");
      Log.d(RadarMemberView.access$getTAG$cp(), "dismiss animation end");
      RadarMemberView.e(this.BzO);
      RadarMemberView.d(this.BzO).sendEmptyMessage(RadarMemberView.eHp());
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class d
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138595);
      p.h(paramMessage, "msg");
      if (paramMessage.what == RadarMemberView.eHo())
      {
        paramMessage = this.BzO;
        this.BzO.getMember();
        RadarMemberView.a(paramMessage, this.BzO.getState());
        AppMethodBeat.o(138595);
        return;
      }
      if (paramMessage.what == RadarMemberView.eHp())
      {
        this.BzO.setVisibility(4);
        RadarMemberView.j(this.BzO);
        paramMessage = RadarMemberView.k(this.BzO);
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
        paramMessage = RadarMemberView.a(this.BzO);
        if (paramMessage != null)
        {
          paramMessage.b(this.BzO.getMember(), this.BzO.getState());
          AppMethodBeat.o(138595);
          return;
        }
      }
      AppMethodBeat.o(138595);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(RadarMemberView paramRadarMemberView, djb paramdjb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138596);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if ((this.BzO.getState() == null) || (RadarMemberView.a(this.BzO) == null))
      {
        a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(138596);
        return;
      }
      paramView = RadarMemberView.a(this.BzO);
      if (paramView != null) {
        paramView.a(paramdjb, this.BzO.getState());
      }
      this.BzO.dismiss();
      a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138596);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class f
    implements View.OnTouchListener
  {
    f(RadarMemberView paramRadarMemberView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(138597);
      if (paramView != RadarMemberView.b(this.BzO))
      {
        p.g(paramMotionEvent, "event");
        if ((paramMotionEvent.getAction() == 1) && (this.BzO.isShowing())) {
          this.BzO.dismiss();
        }
      }
      AppMethodBeat.o(138597);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(View paramView)
    {
      RadarMemberView localRadarMemberView = null;
      AppMethodBeat.i(138599);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$mOnModifyNameClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      String str = "";
      paramView = str;
      if (RadarMemberView.c(this.BzO) != null)
      {
        paramView = RadarMemberView.c(this.BzO);
        if ((paramView == null) || (paramView.arv() != true)) {
          break label193;
        }
        paramView = RadarMemberView.c(this.BzO);
        if (paramView == null) {
          break label188;
        }
      }
      int i;
      label188:
      for (paramView = paramView.ajy();; paramView = null)
      {
        localObject = (CharSequence)paramView;
        if ((localObject != null) && (!kotlin.n.n.aL((CharSequence)localObject))) {
          break;
        }
        i = 1;
        label109:
        localObject = paramView;
        if (i != 0)
        {
          localObject = paramView;
          if (this.BzO.getMember() != null)
          {
            localObject = this.BzO.getMember();
            paramView = localRadarMemberView;
            if (localObject != null) {
              paramView = ((djb)localObject).oUJ;
            }
            localObject = paramView;
          }
        }
        localRadarMemberView = this.BzO;
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
      paramView = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramView, "service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView).aSO();
      paramView = RadarMemberView.c(this.BzO);
      if (paramView != null)
      {
        paramView = paramView.getUsername();
        label232:
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject).aEZ(paramView);
        if (localObject != null)
        {
          paramView = (CharSequence)((cn)localObject).ajB();
          if ((paramView != null) && (!kotlin.n.n.aL(paramView))) {
            break label375;
          }
          i = 1;
          label265:
          if (i == 0) {
            break label400;
          }
        }
        paramView = RadarMemberView.c(this.BzO);
        if (paramView == null) {
          break label380;
        }
        paramView = paramView.ajB();
        label286:
        paramView = (CharSequence)paramView;
        if ((paramView != null) && (!kotlin.n.n.aL(paramView))) {
          break label385;
        }
        i = 1;
        label304:
        if (i != 0) {
          break label400;
        }
        paramView = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(paramView, "service(IMessengerStorage::class.java)");
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView).aSO();
        paramView = RadarMemberView.c(this.BzO);
        if (paramView == null) {
          break label390;
        }
        paramView = paramView.ajB();
        label347:
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.n)localObject).aEZ(paramView);
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
        paramView = ((cn)localObject).ajy();
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarMemberView$popup$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
  public static final class i
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(138602);
      p.h(paramAnimation, "animation");
      Log.d(RadarMemberView.access$getTAG$cp(), "popup animation end");
      RadarMemberView.d(this.BzO).sendEmptyMessage(RadarMemberView.eHo());
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarMemberView$showModifyDialog$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-radar_release"})
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
      Object localObject = RadarMemberView.f(this.BzO);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)String.valueOf(i));
      }
      localObject = RadarMemberView.g(this.BzO);
      if (localObject != null)
      {
        localObject = ((d)localObject).getButton(-1);
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(RadarMemberView paramRadarMemberView) {}
    
    public final void run()
    {
      AppMethodBeat.i(138606);
      if ((this.BzO.getContext() instanceof Activity))
      {
        Object localObject1 = RadarMemberView.BzN;
        localObject1 = this.BzO.getContext();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
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
        p.g(localObject2, "ac.currentFocus ?: return");
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class l
    implements DialogInterface.OnClickListener
  {
    l(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138607);
      paramDialogInterface = RadarMemberView.g(this.BzO);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      RadarMemberView.h(this.BzO);
      AppMethodBeat.o(138607);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class m
    implements DialogInterface.OnClickListener
  {
    m(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(138608);
      if (RadarMemberView.g(this.BzO) != null)
      {
        paramDialogInterface = RadarMemberView.g(this.BzO);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        RadarMemberView.h(this.BzO);
      }
      RadarMemberView.i(this.BzO);
      AppMethodBeat.o(138608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView
 * JD-Core Version:    0.7.0.1
 */