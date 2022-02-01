package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.sy;
import com.tencent.mm.autogen.a.sy.b;
import com.tencent.mm.autogen.mmdata.rpt.qi;
import com.tencent.mm.k.i;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.security.model.e;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "addrList", "", "Lcom/tencent/mm/plugin/address/protocal/AddressObj;", "exportUrl", "", "getExportUrl", "()Ljava/lang/String;", "exportUrl$delegate", "Lkotlin/Lazy;", "mActionBarContainer", "Landroid/view/View;", "mStatusBarHeightCallback", "Lcom/tencent/mm/ui/statusbar/StatusBarHeightWatcher$OnStatusBarHeightChangeCallback;", "fixActionBarStuff", "", "getLayoutId", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "HalfScreenAddressDlg", "ListItem", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SettingsPersonalInfoPreviewUI
  extends MMActivity
{
  public static final SettingsPersonalInfoPreviewUI.a Pvg;
  private View Inv;
  private c.a Inw;
  private List<? extends com.tencent.mm.plugin.address.d.b> Noa;
  private final kotlin.j Pvh;
  
  static
  {
    AppMethodBeat.i(299011);
    Pvg = new SettingsPersonalInfoPreviewUI.a((byte)0);
    AppMethodBeat.o(299011);
  }
  
  public SettingsPersonalInfoPreviewUI()
  {
    AppMethodBeat.i(298931);
    this.Pvh = k.cm((kotlin.g.a.a)SettingsPersonalInfoPreviewUI.d.Pvl);
    AppMethodBeat.o(298931);
  }
  
  private static final void a(sy paramsy, SettingsPersonalInfoPreviewUI paramSettingsPersonalInfoPreviewUI)
  {
    AppMethodBeat.i(298978);
    kotlin.g.b.s.u(paramsy, "$event");
    kotlin.g.b.s.u(paramSettingsPersonalInfoPreviewUI, "this$0");
    if (paramsy.hWs.errCode == 0)
    {
      paramSettingsPersonalInfoPreviewUI.Noa = paramsy.hWs.hWC;
      if (paramSettingsPersonalInfoPreviewUI.Noa == null) {
        paramSettingsPersonalInfoPreviewUI.Noa = ((List)new ArrayList());
      }
    }
    AppMethodBeat.o(298978);
  }
  
  private static final void a(SettingsPersonalInfoPreviewUI paramSettingsPersonalInfoPreviewUI, int paramInt)
  {
    AppMethodBeat.i(298989);
    kotlin.g.b.s.u(paramSettingsPersonalInfoPreviewUI, "this$0");
    paramSettingsPersonalInfoPreviewUI = paramSettingsPersonalInfoPreviewUI.Inv;
    kotlin.g.b.s.checkNotNull(paramSettingsPersonalInfoPreviewUI);
    paramSettingsPersonalInfoPreviewUI.setPadding(0, paramInt, 0, 0);
    AppMethodBeat.o(298989);
  }
  
  private static final void a(SettingsPersonalInfoPreviewUI paramSettingsPersonalInfoPreviewUI, View paramView)
  {
    AppMethodBeat.i(298999);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramSettingsPersonalInfoPreviewUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramSettingsPersonalInfoPreviewUI, "this$0");
    paramView = paramSettingsPersonalInfoPreviewUI.Noa;
    if (paramView != null)
    {
      localObject1 = (Iterable)paramView;
      paramView = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.address.d.b)((Iterator)localObject1).next();
        localObject2 = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.address.d.b)localObject3).qid)) {
          ((StringBuilder)localObject2).append(((com.tencent.mm.plugin.address.d.b)localObject3).qid);
        }
        if (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.address.d.b)localObject3).qie))
        {
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(((com.tencent.mm.plugin.address.d.b)localObject3).qie);
        }
        if (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.address.d.b)localObject3).qif))
        {
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(((com.tencent.mm.plugin.address.d.b)localObject3).qif);
        }
        if (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.address.d.b)localObject3).qil))
        {
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(((com.tencent.mm.plugin.address.d.b)localObject3).qil);
        }
        if (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.address.d.b)localObject3).qih))
        {
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(((com.tencent.mm.plugin.address.d.b)localObject3).qih);
        }
        localObject3 = ((com.tencent.mm.plugin.address.d.b)localObject3).qii + 65292 + ((com.tencent.mm.plugin.address.d.b)localObject3).qij;
        localObject2 = ((StringBuilder)localObject2).toString();
        kotlin.g.b.s.s(localObject2, "builder.toString()");
        paramView.add(new c((String)localObject3, (String)localObject2, ""));
      }
      paramView = (List)paramView;
      localObject1 = paramSettingsPersonalInfoPreviewUI.getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = (Context)localObject1;
      localObject2 = paramSettingsPersonalInfoPreviewUI.getString(b.i.settings_address);
      kotlin.g.b.s.s(localObject2, "getString(R.string.settings_address)");
      Object localObject3 = paramSettingsPersonalInfoPreviewUI.getString(b.i.settings_personal_info_no_address);
      kotlin.g.b.s.s(localObject3, "getString(R.string.setti…personal_info_no_address)");
      new b((Context)localObject1, (String)localObject2, (String)localObject3, new ArrayList((Collection)paramView)).show();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298999);
  }
  
  private static final void a(SettingsPersonalInfoPreviewUI paramSettingsPersonalInfoPreviewUI, TextView paramTextView, View paramView)
  {
    AppMethodBeat.i(298974);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsPersonalInfoPreviewUI);
    localb.cH(paramTextView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramSettingsPersonalInfoPreviewUI, "this$0");
    kotlin.g.b.s.u(paramTextView, "$this_apply");
    paramView = new Intent();
    paramView.putExtra("showShare", false);
    paramView.putExtra("rawUrl", paramSettingsPersonalInfoPreviewUI.gWa());
    paramView.putExtra("show_feedback", false);
    paramView.putExtra("show_bottom", false);
    paramView.putExtra("needRedirect", false);
    paramView.putExtra("neverGetA8Key", false);
    com.tencent.mm.br.c.b(paramTextView.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    paramSettingsPersonalInfoPreviewUI = new qi();
    paramSettingsPersonalInfoPreviewUI.ikE = 151L;
    paramSettingsPersonalInfoPreviewUI.bMH();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298974);
  }
  
  private static final void a(SettingsPersonalInfoPreviewUI paramSettingsPersonalInfoPreviewUI, ah.a parama, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(298967);
    kotlin.g.b.s.u(paramSettingsPersonalInfoPreviewUI, "this$0");
    kotlin.g.b.s.u(parama, "$actionBarHide");
    if (paramView.getScrollY() > com.tencent.mm.cd.a.fromDPToPix((Context)paramSettingsPersonalInfoPreviewUI.getContext(), 80))
    {
      if (parama.aiwY)
      {
        paramSettingsPersonalInfoPreviewUI.setMMTitle(b.i.settings_personal_info);
        paramSettingsPersonalInfoPreviewUI.setActionbarColor(paramSettingsPersonalInfoPreviewUI.getResources().getColor(b.c.white));
        paramSettingsPersonalInfoPreviewUI.supportLightStatusBar();
        parama.aiwY = false;
        AppMethodBeat.o(298967);
      }
    }
    else if (!parama.aiwY)
    {
      paramSettingsPersonalInfoPreviewUI.setMMTitle("");
      paramSettingsPersonalInfoPreviewUI.setActionbarColor(paramSettingsPersonalInfoPreviewUI.getResources().getColor(b.c.transparent));
      paramSettingsPersonalInfoPreviewUI.setActionbarElementColor(paramSettingsPersonalInfoPreviewUI.getContext().getResources().getColor(b.c.FG_0));
      paramSettingsPersonalInfoPreviewUI.supportLightStatusBar();
      parama.aiwY = true;
    }
    AppMethodBeat.o(298967);
  }
  
  private static final boolean a(SettingsPersonalInfoPreviewUI paramSettingsPersonalInfoPreviewUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(298949);
    kotlin.g.b.s.u(paramSettingsPersonalInfoPreviewUI, "this$0");
    paramSettingsPersonalInfoPreviewUI.finish();
    AppMethodBeat.o(298949);
    return true;
  }
  
  private static final void b(SettingsPersonalInfoPreviewUI paramSettingsPersonalInfoPreviewUI, View paramView)
  {
    AppMethodBeat.i(299005);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramSettingsPersonalInfoPreviewUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramSettingsPersonalInfoPreviewUI, "this$0");
    paramView = com.tencent.mm.plugin.account.security.model.g.bXS().bXP();
    if (paramView != null)
    {
      localObject1 = (Iterable)paramView;
      paramView = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.account.security.model.d)((Iterator)localObject1).next();
        str1 = ((com.tencent.mm.plugin.account.security.model.d)localObject2).field_name;
        kotlin.g.b.s.s(str1, "deviceInfo.field_name");
        String str2 = ((com.tencent.mm.plugin.account.security.model.d)localObject2).field_devicetype;
        kotlin.g.b.s.s(str2, "deviceInfo.field_devicetype");
        paramView.add(new c(str1, str2, com.tencent.mm.pluginsdk.platformtools.f.d((Context)paramSettingsPersonalInfoPreviewUI.getContext(), ((com.tencent.mm.plugin.account.security.model.d)localObject2).field_createtime * 1000L, true).toString()));
      }
      paramView = (List)paramView;
      localObject1 = paramSettingsPersonalInfoPreviewUI.getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = (Context)localObject1;
      localObject2 = paramSettingsPersonalInfoPreviewUI.getString(b.i.settings_manage_login_device);
      kotlin.g.b.s.s(localObject2, "getString(R.string.settings_manage_login_device)");
      String str1 = paramSettingsPersonalInfoPreviewUI.getString(b.i.settings_personal_info_no_devices);
      kotlin.g.b.s.s(str1, "getString(R.string.setti…personal_info_no_devices)");
      new b((Context)localObject1, (String)localObject2, str1, new ArrayList((Collection)paramView)).show();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299005);
  }
  
  private final String gWa()
  {
    AppMethodBeat.i(298939);
    Object localObject = this.Pvh.getValue();
    kotlin.g.b.s.s(localObject, "<get-exportUrl>(...)");
    localObject = (String)localObject;
    AppMethodBeat.o(298939);
    return localObject;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.g.settings_personal_info_preiview;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(299090);
    super.initView();
    a.b.g((ImageView)findViewById(com.tencent.mm.plugin.setting.b.f.avatar_iv), z.bAM());
    Object localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().d(4, null);
    if (localObject1 != null) {
      ((TextView)findViewById(com.tencent.mm.plugin.setting.b.f.nickname_tv)).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getContext(), (CharSequence)localObject1));
    }
    localObject1 = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.username_tv);
    Object localObject2 = z.bAN();
    Object localObject3 = z.bAM();
    Object localObject4 = (CharSequence)localObject2;
    if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label461;
      }
      if (!au.bxb((String)localObject3)) {
        break label449;
      }
      ((TextView)localObject1).setText((CharSequence)getString(b.i.settings_notset));
      label144:
      localObject1 = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.gender_tv);
      switch (Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(12290, null), 0))
      {
      default: 
        label200:
        localObject1 = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.district_tv);
        localObject3 = cb.bDe();
        localObject2 = Util.nullAsNil(((cb)localObject3).getProvince());
        localObject3 = Util.nullAsNil(((cb)localObject3).getCity());
        ((TextView)localObject1).setText((CharSequence)(aa.IF((String)localObject2) + ' ' + localObject3));
        localObject3 = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.sinature_tv);
        localObject2 = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(12291, null));
        localObject4 = ((TextView)localObject3).getContext();
        localObject1 = localObject2;
        if (((String)localObject2).length() <= 0) {
          localObject1 = getString(b.i.settings_signature_empty);
        }
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject4, (CharSequence)localObject1));
        localObject1 = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.phonenum_tv);
        localObject2 = (String)com.tencent.mm.kernel.h.baE().ban().d(6, null);
        if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
          ((TextView)localObject1).setText((CharSequence)getString(b.i.settings_bind_qq_unbind));
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.qqnum_tv);
      localObject2 = com.tencent.mm.kernel.h.baE().ban().d(9, Integer.valueOf(0));
      if (localObject2 != null) {
        break label520;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(299090);
      throw ((Throwable)localObject1);
      i = 0;
      break;
      label449:
      ((TextView)localObject1).setText((CharSequence)localObject3);
      break label144;
      label461:
      ((TextView)localObject1).setText((CharSequence)localObject2);
      break label144;
      ((TextView)localObject1).setText(b.i.sex_male);
      break label200;
      ((TextView)localObject1).setText(b.i.sex_female);
      break label200;
      ((TextView)localObject1).setText((CharSequence)getString(b.i.settings_signature_empty));
      break label200;
      ((TextView)localObject1).setText((CharSequence)localObject2);
    }
    label520:
    int i = ((Integer)localObject2).intValue();
    if (i == 0) {
      if (Util.getInt(i.aRC().getValue("BindQQSwitch"), 1) != 1)
      {
        ((TextView)localObject1).findViewById(com.tencent.mm.plugin.setting.b.f.qqnum_wrapper).setVisibility(8);
        if (WeChatBrands.Business.Entries.MeSetSecurityQQ.banned()) {
          ((TextView)localObject1).findViewById(com.tencent.mm.plugin.setting.b.f.qqnum_wrapper).setVisibility(8);
        }
        localObject1 = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.mail_addr_tv);
        localObject2 = (String)com.tencent.mm.kernel.h.baE().ban().d(5, null);
        localObject3 = (CharSequence)localObject2;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label748;
        }
        i = 1;
        label631:
        if (i != 0) {
          break label753;
        }
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.appversion_tv);
      ((TextView)localObject1).setText((CharSequence)ChannelUtil.formatVersion(((TextView)localObject1).getContext(), com.tencent.mm.protocal.d.Yxh));
      findViewById(com.tencent.mm.plugin.setting.b.f.my_addr).setOnClickListener(new SettingsPersonalInfoPreviewUI..ExternalSyntheticLambda1(this));
      findViewById(com.tencent.mm.plugin.setting.b.f.login_devices).setOnClickListener(new SettingsPersonalInfoPreviewUI..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(299090);
      return;
      ((TextView)localObject1).setText(b.i.settings_bind_qq_unbind);
      break;
      ((TextView)localObject1).setText((CharSequence)kotlin.g.b.s.X("", new com.tencent.mm.b.p(i)));
      break;
      label748:
      i = 0;
      break label631;
      label753:
      ((TextView)localObject1).setText(b.i.setting_unbind);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(299065);
    com.tencent.mm.pluginsdk.h.w((MMActivity)this);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.Inv = findViewById(com.tencent.mm.plugin.sns.b.f.action_bar_container);
    if ((this.Inv == null) || (!com.tencent.mm.ui.statusbar.c.afCQ)) {}
    Object localObject;
    for (;;)
    {
      paramBundle = getWindow().getDecorView();
      kotlin.g.b.s.s(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1280);
      setMMTitle("");
      hideActionbarLine();
      setActionbarColor(getResources().getColor(b.c.transparent));
      setActionbarElementColor(getContext().getResources().getColor(b.c.FG_0));
      setBackBtn(new SettingsPersonalInfoPreviewUI..ExternalSyntheticLambda0(this));
      supportLightStatusBar();
      paramBundle = new ah.a();
      paramBundle.aiwY = true;
      localObject = findViewById(com.tencent.mm.plugin.setting.b.f.container_sv);
      if (localObject != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.ScrollView");
      AppMethodBeat.o(299065);
      throw paramBundle;
      paramBundle = com.tencent.mm.ui.statusbar.c.ch((Activity)this);
      localObject = new SettingsPersonalInfoPreviewUI..ExternalSyntheticLambda5(this);
      this.Inw = ((c.a)localObject);
      ah localah = ah.aiuX;
      paramBundle.a((c.a)localObject);
      getWindow().getDecorView().requestApplyInsets();
      com.tencent.mm.ui.statusbar.d.g(getWindow());
    }
    ((ScrollView)localObject).setOnScrollChangeListener(new SettingsPersonalInfoPreviewUI..ExternalSyntheticLambda4(this, paramBundle));
    paramBundle = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.personal_info_export);
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener(new SettingsPersonalInfoPreviewUI..ExternalSyntheticLambda3(this, paramBundle));
      localObject = (CharSequence)gWa();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label381;
      }
    }
    label381:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (!n.U(gWa(), "http", false))) {
        paramBundle.setVisibility(8);
      }
      initView();
      paramBundle = new sy();
      paramBundle.hWs.errCode = -1;
      paramBundle.callback = new SettingsPersonalInfoPreviewUI..ExternalSyntheticLambda6(paramBundle, this);
      paramBundle.asyncPublish(Looper.getMainLooper());
      paramBundle = new com.tencent.mm.plugin.account.security.model.b();
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramBundle, 0);
      AppMethodBeat.o(299065);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$HalfScreenAddressDlg;", "Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "context", "Landroid/content/Context;", "title", "", "empty", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$ListItem;", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "getEmpty", "()Ljava/lang/String;", "getTitle", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "inflateContentView", "Landroid/view/View;", "initContentView", "", "AddressConvert", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.ui.f.a
  {
    private final String Pvi;
    private final ArrayList<SettingsPersonalInfoPreviewUI.c> data;
    private final String title;
    
    public b(String paramString1, String paramString2, ArrayList<SettingsPersonalInfoPreviewUI.c> paramArrayList)
    {
      super();
      AppMethodBeat.i(298676);
      this.title = paramString2;
      this.Pvi = paramArrayList;
      this.data = localObject;
      AppMethodBeat.o(298676);
    }
    
    private static final void a(b paramb, View paramView)
    {
      AppMethodBeat.i(298682);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$HalfScreenAddressDlg", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramb, "this$0");
      paramb.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$HalfScreenAddressDlg", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(298682);
    }
    
    public final View bZy()
    {
      AppMethodBeat.i(298688);
      View localView = af.mU(getContext()).inflate(b.g.half_screen_address_dialog, null);
      kotlin.g.b.s.s(localView, "getInflater(context).inf…een_address_dialog, null)");
      AppMethodBeat.o(298688);
      return localView;
    }
    
    public final void initContentView()
    {
      AppMethodBeat.i(298694);
      super.initContentView();
      Object localObject = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.title_tv);
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)this.title);
      }
      localObject = (Collection)this.data;
      int i;
      if ((localObject == null) || (((Collection)localObject).isEmpty()))
      {
        i = 1;
        if (i == 0) {
          break label146;
        }
        localObject = findViewById(com.tencent.mm.plugin.setting.b.f.recycler_view);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        localObject = (TextView)findViewById(com.tencent.mm.plugin.setting.b.f.empty_tv);
        if (localObject != null)
        {
          ((TextView)localObject).setText((CharSequence)this.Pvi);
          ((TextView)localObject).setVisibility(0);
        }
      }
      for (;;)
      {
        localObject = findViewById(com.tencent.mm.plugin.setting.b.f.close_btn);
        if (localObject != null) {
          ((View)localObject).setOnClickListener(new SettingsPersonalInfoPreviewUI.b..ExternalSyntheticLambda0(this));
        }
        AppMethodBeat.o(298694);
        return;
        i = 0;
        break;
        label146:
        localObject = (WxRecyclerView)findViewById(com.tencent.mm.plugin.setting.b.f.recycler_view);
        if (localObject != null)
        {
          ((WxRecyclerView)localObject).getContext();
          ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
          ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)new c((com.tencent.mm.view.recyclerview.g)new b(this), this.data));
        }
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$HalfScreenAddressDlg$AddressConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$ListItem;", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI;", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$HalfScreenAddressDlg;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "data", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
    public final class a
      extends com.tencent.mm.view.recyclerview.f<SettingsPersonalInfoPreviewUI.c>
    {
      public a()
      {
        AppMethodBeat.i(298987);
        AppMethodBeat.o(298987);
      }
      
      public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
      {
        AppMethodBeat.i(298996);
        kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
        kotlin.g.b.s.u(paramj, "holder");
        AppMethodBeat.o(298996);
      }
      
      public final int getLayoutId()
      {
        return b.g.half_screen_address_list_item;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$HalfScreenAddressDlg$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements com.tencent.mm.view.recyclerview.g
    {
      b(SettingsPersonalInfoPreviewUI.b paramb) {}
      
      public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
      {
        AppMethodBeat.i(298985);
        com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new SettingsPersonalInfoPreviewUI.b.a(this.Pvk);
        AppMethodBeat.o(298985);
        return localf;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$HalfScreenAddressDlg$initContentView$2$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$ListItem;", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI;", "needBindClickEvent", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      extends WxRecyclerAdapter<SettingsPersonalInfoPreviewUI.c>
    {
      c(com.tencent.mm.view.recyclerview.g paramg, ArrayList<SettingsPersonalInfoPreviewUI.c> paramArrayList)
      {
        super(paramArrayList, true);
      }
      
      public final boolean bZD()
      {
        return false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI$ListItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "title", "", "desc", "time", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoPreviewUI;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getTime", "getTitle", "getItemId", "", "getItemType", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    final String desc;
    final String time;
    final String title;
    
    public c(String paramString1, String paramString2)
    {
      AppMethodBeat.i(298674);
      this.title = paramString1;
      this.desc = paramString2;
      this.time = localObject;
      AppMethodBeat.o(298674);
    }
    
    public final long bZA()
    {
      AppMethodBeat.i(298681);
      long l = hashCode();
      AppMethodBeat.o(298681);
      return l;
    }
    
    public final int bZB()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoPreviewUI
 * JD-Core Version:    0.7.0.1
 */