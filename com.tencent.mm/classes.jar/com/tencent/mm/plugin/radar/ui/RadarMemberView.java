package com.tencent.mm.plugin.radar.ui;

import a.f;
import a.f.b.t;
import a.f.b.v;
import a.f.b.y;
import a.j.k;
import a.l;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
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
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.b.c;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", "listener", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", "username", "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"})
public final class RadarMemberView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.RadarMemberView";
  private static final int pRt = 0;
  private static final int pRu = 1;
  public static final RadarMemberView.a pRv;
  private ad contact;
  private View gwd;
  private c gwf;
  private TextView mYs;
  private EditText pLt;
  private brg pQI;
  private c.e pQJ;
  private View pRc;
  private final f pRd;
  private final f pRe;
  private final f pRf;
  private final f pRg;
  private final f pRh;
  private final f pRi;
  private final f pRj;
  private final f pRk;
  private int[] pRl;
  private final f pRm;
  private boolean pRn;
  private bv pRo;
  private RadarMemberView.b pRp;
  private final View.OnClickListener pRq;
  private final RadarMemberView.d pRr;
  private TextView pRs;
  
  static
  {
    AppMethodBeat.i(102964);
    eOJ = new k[] { (k)v.a(new t(v.aG(RadarMemberView.class), "avatarHolder", "getAvatarHolder()Landroid/view/View;")), (k)v.a(new t(v.aG(RadarMemberView.class), "avatarCopy", "getAvatarCopy()Landroid/widget/ImageView;")), (k)v.a(new t(v.aG(RadarMemberView.class), "avatarCopyContainer", "getAvatarCopyContainer()Landroid/view/View;")), (k)v.a(new t(v.aG(RadarMemberView.class), "confirmBtn", "getConfirmBtn()Landroid/widget/Button;")), (k)v.a(new t(v.aG(RadarMemberView.class), "confirmBtnDisabled", "getConfirmBtnDisabled()Landroid/widget/TextView;")), (k)v.a(new t(v.aG(RadarMemberView.class), "memberNameTv", "getMemberNameTv()Landroid/widget/TextView;")), (k)v.a(new t(v.aG(RadarMemberView.class), "modifyNameBtn", "getModifyNameBtn()Landroid/widget/Button;")), (k)v.a(new t(v.aG(RadarMemberView.class), "sayHiTv", "getSayHiTv()Landroid/widget/TextView;")), (k)v.a(new t(v.aG(RadarMemberView.class), "exposeTv", "getExposeTv()Landroid/widget/TextView;")) };
    pRv = new RadarMemberView.a((byte)0);
    TAG = "MicroMsg.RadarMemberView";
    pRu = 1;
    AppMethodBeat.o(102964);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(102981);
    this.pRd = i.ae(this, 2131826981);
    this.pRe = i.ae(this, 2131826985);
    this.pRf = i.ae(this, 2131826984);
    this.pRg = i.ae(this, 2131826980);
    this.pRh = i.ae(this, 2131826979);
    this.pRi = i.ae(this, 2131826982);
    this.pRj = i.ae(this, 2131826983);
    this.pRk = i.ae(this, 2131826978);
    this.pRm = i.ae(this, 2131826986);
    this.pRq = ((View.OnClickListener)new RadarMemberView.h(this));
    this.pRr = new RadarMemberView.d(this);
    AppMethodBeat.o(102981);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(102982);
    this.pRd = i.ae(this, 2131826981);
    this.pRe = i.ae(this, 2131826985);
    this.pRf = i.ae(this, 2131826984);
    this.pRg = i.ae(this, 2131826980);
    this.pRh = i.ae(this, 2131826979);
    this.pRi = i.ae(this, 2131826982);
    this.pRj = i.ae(this, 2131826983);
    this.pRk = i.ae(this, 2131826978);
    this.pRm = i.ae(this, 2131826986);
    this.pRq = ((View.OnClickListener)new RadarMemberView.h(this));
    this.pRr = new RadarMemberView.d(this);
    AppMethodBeat.o(102982);
  }
  
  private final void a(c.e parame)
  {
    AppMethodBeat.i(102976);
    getExposeTv().setVisibility(0);
    if (parame == null)
    {
      AppMethodBeat.o(102976);
      return;
    }
    switch (c.bLo[parame.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(102976);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(2131302272);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(102976);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(2131302279);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(102976);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(2131302259);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      AppMethodBeat.o(102976);
      return;
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(2131302258);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setText((CharSequence)getContext().getString(2131302270));
      getSayHiTv().setVisibility(0);
    }
  }
  
  private final ImageView getAvatarCopy()
  {
    AppMethodBeat.i(102966);
    ImageView localImageView = (ImageView)this.pRe.getValue();
    AppMethodBeat.o(102966);
    return localImageView;
  }
  
  private final View getAvatarCopyContainer()
  {
    AppMethodBeat.i(102967);
    View localView = (View)this.pRf.getValue();
    AppMethodBeat.o(102967);
    return localView;
  }
  
  private final View getAvatarHolder()
  {
    AppMethodBeat.i(102965);
    View localView = (View)this.pRd.getValue();
    AppMethodBeat.o(102965);
    return localView;
  }
  
  private final Button getConfirmBtn()
  {
    AppMethodBeat.i(102968);
    Button localButton = (Button)this.pRg.getValue();
    AppMethodBeat.o(102968);
    return localButton;
  }
  
  private final TextView getConfirmBtnDisabled()
  {
    AppMethodBeat.i(102969);
    TextView localTextView = (TextView)this.pRh.getValue();
    AppMethodBeat.o(102969);
    return localTextView;
  }
  
  private final TextView getExposeTv()
  {
    AppMethodBeat.i(102973);
    TextView localTextView = (TextView)this.pRm.getValue();
    AppMethodBeat.o(102973);
    return localTextView;
  }
  
  private final TextView getMemberNameTv()
  {
    AppMethodBeat.i(102970);
    TextView localTextView = (TextView)this.pRi.getValue();
    AppMethodBeat.o(102970);
    return localTextView;
  }
  
  private final Button getModifyNameBtn()
  {
    AppMethodBeat.i(102971);
    Button localButton = (Button)this.pRj.getValue();
    AppMethodBeat.o(102971);
    return localButton;
  }
  
  private final TextView getSayHiTv()
  {
    AppMethodBeat.i(102972);
    TextView localTextView = (TextView)this.pRk.getValue();
    AppMethodBeat.o(102972);
    return localTextView;
  }
  
  private final void reset()
  {
    AppMethodBeat.i(102980);
    getAvatarCopyContainer().setVisibility(8);
    getMemberNameTv().setVisibility(4);
    getModifyNameBtn().setVisibility(4);
    getConfirmBtn().setVisibility(8);
    getConfirmBtnDisabled().setVisibility(8);
    getSayHiTv().setVisibility(8);
    getExposeTv().setVisibility(8);
    AppMethodBeat.o(102980);
  }
  
  public final void a(View paramView, brg parambrg, c.e parame)
  {
    AppMethodBeat.i(102978);
    a.f.b.j.q(paramView, "view");
    a.f.b.j.q(parambrg, "member");
    ab.d(TAG, "popup");
    this.pQJ = parame;
    this.pQI = parambrg;
    parame = getConfirmBtn();
    if (parame != null) {
      parame.setOnClickListener((View.OnClickListener)new RadarMemberView.e(this, parambrg));
    }
    getModifyNameBtn().setOnClickListener(this.pRq);
    setOnTouchListener((View.OnTouchListener)new RadarMemberView.f(this));
    getExposeTv().setOnClickListener((View.OnClickListener)new g(this));
    parame = g.pSH;
    parame = g.b(parambrg);
    if (!a.l.m.ap((CharSequence)parame))
    {
      localObject = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(localObject, "service(IMessengerStorage::class.java)");
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YA().arw(parame);
    }
    Object localObject = this.contact;
    if ((localObject != null) && (((ad)localObject).NT() == true))
    {
      parame = this.contact;
      if (parame != null)
      {
        parame = parame.Hr();
        localObject = getMemberNameTv();
        if ((this.contact == null) || (bo.isNullOrNil(parame))) {
          break label610;
        }
      }
    }
    label610:
    for (parambrg = (CharSequence)com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), (CharSequence)parame, getMemberNameTv().getTextSize());; parambrg = (CharSequence)com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), (CharSequence)parambrg.jKG, getMemberNameTv().getTextSize()))
    {
      ((TextView)localObject).setText(parambrg);
      getMemberNameTv().setVisibility(4);
      getModifyNameBtn().setVisibility(4);
      reset();
      this.pRc = paramView;
      paramView = this.pRc;
      if (paramView == null) {
        a.f.b.j.ebi();
      }
      paramView = paramView.findViewById(2131826989);
      a.f.b.j.p(paramView, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
      parambrg = (ImageView)paramView;
      paramView = this.pRc;
      if (paramView == null) {
        a.f.b.j.ebi();
      }
      paramView = paramView.findViewById(2131826984);
      a.f.b.j.p(paramView, "avatarItem!!.findViewByI…d.radar_avatar_container)");
      parame = this.pRc;
      if (parame == null) {
        a.f.b.j.ebi();
      }
      parame.setVisibility(4);
      getAvatarCopy().setImageDrawable(parambrg.getDrawable());
      getAvatarCopyContainer().setVisibility(0);
      parame = new int[2];
      paramView.getLocationInWindow(parame);
      localObject = new int[2];
      getAvatarHolder().getLocationInWindow((int[])localObject);
      this.pRl = ((int[])localObject);
      setVisibility(0);
      parambrg = new AnimationSet(true);
      parambrg.setFillAfter(true);
      parambrg.setRepeatCount(1);
      parambrg.setDuration(500L);
      float f1 = getAvatarHolder().getHeight() / paramView.getHeight();
      float f2 = (paramView.getWidth() - paramView.getHeight()) / 2;
      paramView = new TranslateAnimation(parame[0], localObject[0] - f2 * f1, parame[1], localObject[1]);
      parambrg.addAnimation((Animation)new ScaleAnimation(1.0F, f1, 1.0F, f1));
      parambrg.addAnimation((Animation)paramView);
      parambrg.setAnimationListener((Animation.AnimationListener)new RadarMemberView.i(this));
      getAvatarCopyContainer().startAnimation((Animation)parambrg);
      AppMethodBeat.o(102978);
      return;
      parame = null;
      break;
      localObject = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(localObject, "service(IMessengerStorage::class.java)");
      this.pRo = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YB().TM(parame);
      parame = this.pRo;
      if (parame != null)
      {
        parame = parame.Hr();
        break;
      }
      parame = null;
      break;
    }
  }
  
  public final void c(String paramString, c.e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(102975);
    a.f.b.j.q(paramString, "username");
    a.f.b.j.q(parame, "state");
    if ((!isShowing()) || (this.pRn))
    {
      AppMethodBeat.o(102975);
      return;
    }
    Object localObject1 = this.pQI;
    if (localObject1 != null) {}
    for (localObject1 = ((brg)localObject1).wSo;; localObject1 = null)
    {
      if (!a.f.b.j.e(paramString, localObject1))
      {
        brg localbrg = this.pQI;
        localObject1 = localObject2;
        if (localbrg != null) {
          localObject1 = localbrg.jJA;
        }
        if (!a.f.b.j.e(paramString, localObject1)) {}
      }
      else
      {
        a(parame);
      }
      AppMethodBeat.o(102975);
      return;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(102979);
    ab.d(TAG, "dismiss");
    if (this.pRn)
    {
      AppMethodBeat.o(102979);
      return;
    }
    this.pRn = true;
    Object localObject1 = this.pRc;
    if (localObject1 == null) {
      a.f.b.j.ebi();
    }
    Object localObject2 = ((View)localObject1).findViewById(2131826984);
    a.f.b.j.p(localObject2, "avatarItem!!.findViewByI…d.radar_avatar_container)");
    localObject1 = new AnimationSet(true);
    ((AnimationSet)localObject1).setFillAfter(true);
    ((AnimationSet)localObject1).setRepeatCount(1);
    ((AnimationSet)localObject1).setDuration(500L);
    int[] arrayOfInt1 = this.pRl;
    int[] arrayOfInt2 = new int[2];
    ((View)localObject2).getLocationInWindow(arrayOfInt2);
    float f1 = getAvatarHolder().getHeight() / ((View)localObject2).getHeight();
    float f2 = (((View)localObject2).getWidth() - ((View)localObject2).getHeight()) / 2;
    if (arrayOfInt1 == null) {
      a.f.b.j.ebi();
    }
    localObject2 = new TranslateAnimation(arrayOfInt1[0] - f2 * f1, arrayOfInt2[0], arrayOfInt1[1], arrayOfInt2[1]);
    ((AnimationSet)localObject1).addAnimation((Animation)new ScaleAnimation(f1, 1.0F, f1, 1.0F));
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).setAnimationListener((Animation.AnimationListener)new RadarMemberView.c(this));
    getMemberNameTv().setVisibility(4);
    getModifyNameBtn().setVisibility(4);
    getConfirmBtn().setVisibility(8);
    getConfirmBtnDisabled().setVisibility(8);
    getSayHiTv().setVisibility(8);
    getExposeTv().setVisibility(8);
    getAvatarCopyContainer().startAnimation((Animation)localObject1);
    AppMethodBeat.o(102979);
  }
  
  public final brg getMember()
  {
    return this.pQI;
  }
  
  public final c.e getState()
  {
    return this.pQJ;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(102974);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(102974);
      return true;
    }
    AppMethodBeat.o(102974);
    return false;
  }
  
  public final void setListener(RadarMemberView.b paramb)
  {
    AppMethodBeat.i(102977);
    a.f.b.j.q(paramb, "listener");
    this.pRp = paramb;
    AppMethodBeat.o(102977);
  }
  
  public final void setMember(brg parambrg)
  {
    this.pQI = parambrg;
  }
  
  public final void setState(c.e parame)
  {
    this.pQJ = parame;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102953);
      Intent localIntent = new Intent();
      paramView = RadarMemberView.c(this.pRw);
      if (paramView != null) {}
      for (paramView = paramView.getUsername();; paramView = null)
      {
        localIntent.putExtra("k_username", paramView);
        localIntent.putExtra("showShare", false);
        paramView = y.BNt;
        paramView = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(38) }, 1));
        a.f.b.j.p(paramView, "java.lang.String.format(format, *args)");
        localIntent.putExtra("rawUrl", paramView);
        d.b(this.pRw.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(102953);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView
 * JD-Core Version:    0.7.0.1
 */