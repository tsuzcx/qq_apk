package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.teenmode.a.c;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.a.b;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/AuthorizationDetailUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "()V", "agreeBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getAgreeBtn", "()Landroid/widget/Button;", "agreeBtn$delegate", "Lkotlin/Lazy;", "appMsg", "Lcom/tencent/mm/message/AppMessage$Content;", "getAppMsg", "()Lcom/tencent/mm/message/AppMessage$Content;", "appMsg$delegate", "bottomHint", "Landroid/widget/TextView;", "getBottomHint", "()Landroid/widget/TextView;", "bottomHint$delegate", "bottomLine", "Landroid/view/View;", "getBottomLine", "()Landroid/view/View;", "bottomLine$delegate", "fillContent", "Landroid/widget/LinearLayout;", "getFillContent", "()Landroid/widget/LinearLayout;", "fillContent$delegate", "holder", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$Holder;", "iKnowBtn", "getIKnowBtn", "iKnowBtn$delegate", "msgArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getMsgArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "msgArrow$delegate", "msgSvrId", "", "getMsgSvrId", "()J", "msgSvrId$delegate", "pageFiller", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller;", "getPageFiller", "()Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller;", "pageFiller$delegate", "stateIcon", "getStateIcon", "stateIcon$delegate", "titleTv", "getTitleTv", "titleTv$delegate", "topLine", "getTopLine", "topLine$delegate", "getAuthorizationState", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller$State;", "getLayoutId", "", "hideErrorTip", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataChanged", "onDestroy", "showErrorTip", "errMsg", "", "updateView", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AuthorizationDetailUI
  extends MMActivity
  implements g
{
  public static final AuthorizationDetailUI.a SZx;
  private final j SZA;
  private final j SZB;
  private final j SZC;
  private final j SZD;
  private final j SZE;
  private final j SZF;
  private final j SZG;
  private final j SZH;
  private final com.tencent.mm.plugin.teenmode.a.a.a SZI;
  private final j SZy;
  private final j SZz;
  private final j vNI;
  private final j vOl;
  
  static
  {
    AppMethodBeat.i(279177);
    SZx = new AuthorizationDetailUI.a((byte)0);
    AppMethodBeat.o(279177);
  }
  
  public AuthorizationDetailUI()
  {
    AppMethodBeat.i(279037);
    this.SZy = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.SZz = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.SZA = kotlin.k.cm((kotlin.g.a.a)new m(this));
    this.vOl = kotlin.k.cm((kotlin.g.a.a)new n(this));
    this.SZB = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.SZC = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.SZD = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.SZE = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.vNI = kotlin.k.cm((kotlin.g.a.a)new o(this));
    this.SZF = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.SZG = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.SZH = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.SZI = new com.tencent.mm.plugin.teenmode.a.a.a();
    AppMethodBeat.o(279037);
  }
  
  private static final ah a(w paramw, AuthorizationDetailUI paramAuthorizationDetailUI, b.a parama)
  {
    AppMethodBeat.i(279138);
    s.u(paramAuthorizationDetailUI, "this$0");
    paramw.dismiss();
    if ((parama.errCode != 0) || (parama.errType != 0))
    {
      parama = parama.errMsg;
      TextView localTextView = (TextView)paramAuthorizationDetailUI.findViewById(a.d.error_tip);
      localTextView.setVisibility(0);
      paramw = parama;
      if (parama == null)
      {
        paramw = paramAuthorizationDetailUI.getString(a.g.app_err_server_busy_tip);
        s.s(paramw, "getString(R.string.app_err_server_busy_tip)");
      }
      localTextView.setText((CharSequence)paramw);
    }
    paramw = ah.aiuX;
    AppMethodBeat.o(279138);
    return paramw;
  }
  
  private static final void a(AuthorizationDetailUI paramAuthorizationDetailUI, View paramView)
  {
    AppMethodBeat.i(279156);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAuthorizationDetailUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/AuthorizationDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramAuthorizationDetailUI, "this$0");
    paramAuthorizationDetailUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/AuthorizationDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279156);
  }
  
  private static final void a(AuthorizationDetailUI paramAuthorizationDetailUI, String paramString, View paramView)
  {
    AppMethodBeat.i(279150);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramAuthorizationDetailUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/AuthorizationDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramAuthorizationDetailUI, "this$0");
    localObject2 = com.tencent.mm.ui.base.k.a((Context)paramAuthorizationDetailUI, paramAuthorizationDetailUI.getContext().getString(a.g.loading_tips_1), false, null);
    ((TextView)paramAuthorizationDetailUI.findViewById(a.d.error_tip)).setVisibility(8);
    if (paramString == null) {}
    int i;
    for (paramAuthorizationDetailUI = null;; paramAuthorizationDetailUI = new com.tencent.mm.plugin.teenmode.b.d(paramString, i, paramView, paramAuthorizationDetailUI.aJH()).bFJ().a((com.tencent.mm.vending.e.b)paramAuthorizationDetailUI).b(new AuthorizationDetailUI..ExternalSyntheticLambda3((w)localObject2, paramAuthorizationDetailUI)))
    {
      if (paramAuthorizationDetailUI == null) {
        ((w)localObject2).dismiss();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/AuthorizationDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279150);
      return;
      paramView = (com.tencent.mm.message.a.c)paramAuthorizationDetailUI.hEG().aK(com.tencent.mm.message.a.c.class);
      i = paramView.nVI;
      localObject1 = paramView.nVH;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
    }
  }
  
  private static final boolean a(AuthorizationDetailUI paramAuthorizationDetailUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(279134);
    s.u(paramAuthorizationDetailUI, "this$0");
    paramAuthorizationDetailUI.finish();
    AppMethodBeat.o(279134);
    return true;
  }
  
  private final long aJH()
  {
    AppMethodBeat.i(279052);
    long l = ((Number)this.SZz.getValue()).longValue();
    AppMethodBeat.o(279052);
    return l;
  }
  
  private final View ddW()
  {
    AppMethodBeat.i(279097);
    View localView = (View)this.vNI.getValue();
    AppMethodBeat.o(279097);
    return localView;
  }
  
  private final TextView getTitleTv()
  {
    AppMethodBeat.i(279063);
    TextView localTextView = (TextView)this.vOl.getValue();
    AppMethodBeat.o(279063);
    return localTextView;
  }
  
  private final k.b hEG()
  {
    AppMethodBeat.i(279046);
    k.b localb = (k.b)this.SZy.getValue();
    AppMethodBeat.o(279046);
    return localb;
  }
  
  private final WeImageView hEH()
  {
    AppMethodBeat.i(279058);
    WeImageView localWeImageView = (WeImageView)this.SZA.getValue();
    AppMethodBeat.o(279058);
    return localWeImageView;
  }
  
  private final Button hEI()
  {
    AppMethodBeat.i(279071);
    Button localButton = (Button)this.SZB.getValue();
    AppMethodBeat.o(279071);
    return localButton;
  }
  
  private final Button hEJ()
  {
    AppMethodBeat.i(279075);
    Button localButton = (Button)this.SZC.getValue();
    AppMethodBeat.o(279075);
    return localButton;
  }
  
  private final LinearLayout hEK()
  {
    AppMethodBeat.i(279088);
    LinearLayout localLinearLayout = (LinearLayout)this.SZD.getValue();
    AppMethodBeat.o(279088);
    return localLinearLayout;
  }
  
  private final WeImageView hEL()
  {
    AppMethodBeat.i(279093);
    WeImageView localWeImageView = (WeImageView)this.SZE.getValue();
    AppMethodBeat.o(279093);
    return localWeImageView;
  }
  
  private final View hEM()
  {
    AppMethodBeat.i(279102);
    View localView = (View)this.SZF.getValue();
    AppMethodBeat.o(279102);
    return localView;
  }
  
  private final TextView hEN()
  {
    AppMethodBeat.i(279107);
    TextView localTextView = (TextView)this.SZG.getValue();
    AppMethodBeat.o(279107);
    return localTextView;
  }
  
  private final com.tencent.mm.plugin.teenmode.a.a hEO()
  {
    AppMethodBeat.i(279112);
    com.tencent.mm.plugin.teenmode.a.a locala = (com.tencent.mm.plugin.teenmode.a.a)this.SZH.getValue();
    AppMethodBeat.o(279112);
    return locala;
  }
  
  private final a.b hEP()
  {
    AppMethodBeat.i(279128);
    Object localObject = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aoj(this.SZI.SYm.field_businessType);
    long l = cn.bDu();
    if (!((com.tencent.mm.plugin.teenmode.a.b)localObject).aD(this.SZI.PRp, l))
    {
      if ((this.SZI.SYm.hEw()) && (this.SZI.SYm.hEx()))
      {
        localObject = a.b.SYx;
        AppMethodBeat.o(279128);
        return localObject;
      }
      if (this.SZI.SYm.hEw())
      {
        localObject = a.b.SYw;
        AppMethodBeat.o(279128);
        return localObject;
      }
      localObject = a.b.SYu;
      AppMethodBeat.o(279128);
      return localObject;
    }
    if (this.SZI.SYm.hEw())
    {
      if (((com.tencent.mm.plugin.teenmode.a.b)localObject).aD(this.SZI.PRp, this.SZI.SYm.field_time))
      {
        localObject = a.b.SYv;
        AppMethodBeat.o(279128);
        return localObject;
      }
      if (this.SZI.SYm.hEx())
      {
        localObject = a.b.SYx;
        AppMethodBeat.o(279128);
        return localObject;
      }
      if (this.SZI.SYm.hEw())
      {
        localObject = a.b.SYw;
        AppMethodBeat.o(279128);
        return localObject;
      }
    }
    localObject = a.b.SYv;
    AppMethodBeat.o(279128);
    return localObject;
  }
  
  private final void updateView()
  {
    AppMethodBeat.i(279119);
    a.b localb = hEP();
    Object localObject;
    switch (b.$EnumSwitchMapping$0[localb.ordinal()])
    {
    default: 
      hEH().oR(a.f.icons_outlined_umbrella, com.tencent.mm.plugin.teenmode.a.a.wechat_green);
      TextView localTextView = getTitleTv();
      switch (b.$EnumSwitchMapping$0[localb.ordinal()])
      {
      case 3: 
      default: 
        localObject = (CharSequence)getString(a.g.SWQ);
        localTextView.setText((CharSequence)localObject);
        hEO().a((Context)this, localb, this.SZI);
        if ((localb == a.b.SYu) && (this.SZI.hEo()))
        {
          hEI().setVisibility(0);
          hEJ().setVisibility(8);
          label166:
          if ((localb == a.b.SYw) || (this.SZI.hEo())) {
            break label412;
          }
          hEL().setVisibility(8);
          ddW().setVisibility(0);
          hEM().setVisibility(0);
          hEK().setBackground(null);
          hEK().setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.teenmode.a.a.transparent));
        }
        break;
      }
      break;
    }
    for (;;)
    {
      if ((localb != a.b.SYx) || (!this.SZI.hEo())) {
        break label455;
      }
      hEN().setVisibility(0);
      AppMethodBeat.o(279119);
      return;
      hEH().oR(a.f.icons_filled_done2, com.tencent.mm.plugin.teenmode.a.a.wechat_green);
      break;
      hEH().oR(a.f.icons_filled_error, com.tencent.mm.plugin.teenmode.a.a.orange_100);
      break;
      if (this.SZI.hEo()) {}
      for (localObject = getString(a.g.SWO, new Object[] { hEO().gV((Context)getContext()) });; localObject = getString(a.g.SWP))
      {
        localObject = (CharSequence)localObject;
        break;
      }
      if (this.SZI.hEo()) {}
      for (localObject = getString(a.g.SWM);; localObject = getString(a.g.SWN))
      {
        localObject = (CharSequence)localObject;
        break;
      }
      hEI().setVisibility(8);
      hEJ().setVisibility(0);
      break label166;
      label412:
      hEL().setVisibility(0);
      ddW().setVisibility(8);
      hEM().setVisibility(8);
      hEK().setBackground(getDrawable(a.c.SVe));
    }
    label455:
    hEN().setVisibility(8);
    AppMethodBeat.o(279119);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.e.SWu;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279220);
    super.onCreate(paramBundle);
    if (!getIntent().getBooleanExtra("intent_extra_need_anim", false)) {
      overridePendingTransition(0, 0);
    }
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(com.tencent.mm.plugin.teenmode.a.a.white));
    setBackBtn(new AuthorizationDetailUI..ExternalSyntheticLambda0(this));
    z.bAM();
    paramBundle = getIntent().getStringExtra("intent_extra_guardian_username");
    String str = getIntent().getStringExtra("intent_extra_ward_username");
    this.SZI.SYl = getIntent().getStringExtra("intent_extra_cdn_img_path");
    Assert.assertNotNull(paramBundle);
    Assert.assertNotNull(str);
    hEI().setOnClickListener(new AuthorizationDetailUI..ExternalSyntheticLambda2(this, str));
    hEJ().setOnClickListener(new AuthorizationDetailUI..ExternalSyntheticLambda1(this));
    this.SZI.mll = ((TextView)findViewById(a.d.SVs));
    this.SZI.pmf = ((TextView)findViewById(a.d.SVi));
    this.SZI.SYp = ((LinearLayout)findViewById(a.d.SVm));
    this.SZI.SYq = ((ImageView)findViewById(a.d.SVo));
    this.SZI.SYr = ((ImageView)findViewById(a.d.SVn));
    this.SZI.SYs = ((TextView)findViewById(a.d.SVp));
    this.SZI.SYt = ((WeImageView)findViewById(a.d.SVk));
    Object localObject1 = (com.tencent.mm.message.a.c)hEG().aK(com.tencent.mm.message.a.c.class);
    this.SZI.SYk = hEG();
    this.SZI.PRp = getIntent().getLongExtra("intent_extra_request_time", 0L);
    com.tencent.mm.plugin.teenmode.a.a.a locala = this.SZI;
    Object localObject2 = com.tencent.mm.plugin.teenmode.b.a.e.SZq;
    localObject2 = com.tencent.mm.plugin.teenmode.b.a.e.hEB();
    int i = ((com.tencent.mm.message.a.c)localObject1).nVI;
    localObject1 = ((com.tencent.mm.message.a.c)localObject1).nVH;
    s.checkNotNull(localObject1);
    locala.SYm = ((com.tencent.mm.plugin.teenmode.b.a.c)localObject2).b(i, (String)localObject1, aJH());
    this.SZI.SYn = paramBundle;
    this.SZI.SYo = str;
    updateView();
    ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a((g)this);
    AppMethodBeat.o(279220);
  }
  
  public final void onDataChanged()
  {
    AppMethodBeat.i(279233);
    Object localObject1 = (com.tencent.mm.message.a.c)hEG().aK(com.tencent.mm.message.a.c.class);
    com.tencent.mm.plugin.teenmode.a.a.a locala = this.SZI;
    Object localObject2 = com.tencent.mm.plugin.teenmode.b.a.e.SZq;
    localObject2 = com.tencent.mm.plugin.teenmode.b.a.e.hEB();
    int i = ((com.tencent.mm.message.a.c)localObject1).nVI;
    localObject1 = ((com.tencent.mm.message.a.c)localObject1).nVH;
    s.checkNotNull(localObject1);
    locala.SYm = ((com.tencent.mm.plugin.teenmode.b.a.c)localObject2).b(i, (String)localObject1, aJH());
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new k(this));
    AppMethodBeat.o(279233);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(279226);
    hEO();
    ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).b((g)this);
    super.onDestroy();
    AppMethodBeat.o(279226);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Button>
  {
    c(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/message/AppMessage$Content;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<k.b>
  {
    d(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextView>
  {
    e(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<View>
  {
    f(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    g(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<Button>
  {
    h(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    i(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<Long>
  {
    j(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/teenmode/api/AuthorizationFiller;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.teenmode.a.a>
  {
    l(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    m(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<TextView>
  {
    n(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<View>
  {
    o(AuthorizationDetailUI paramAuthorizationDetailUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.AuthorizationDetailUI
 * JD-Core Version:    0.7.0.1
 */