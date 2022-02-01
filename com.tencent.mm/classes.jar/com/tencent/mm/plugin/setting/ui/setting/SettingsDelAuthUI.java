package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.q;
import com.tencent.mm.plugin.setting.model.r;
import com.tencent.mm.protocal.protobuf.fun;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsDelAuthUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mAdapter", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsDelAuthUI$SettingsUserAuthListItemAdapter;", "mUserAppAuthInfo", "Lcom/tencent/mm/protocal/protobuf/UserAuthApp;", "tipsDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "doDelUserAuth", "", "getLayoutId", "", "initAppInfoView", "initAppViewSize", "isMobileAppType", "", "type", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "showDelAuthBottomSheet", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "SettingsUserAuthListItemAdapter", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SettingsDelAuthUI
  extends MMActivity
{
  public static final SettingsDelAuthUI.a PsU;
  private SettingsDelAuthUI.b PsV;
  private fun PsW;
  private w Psj;
  
  static
  {
    AppMethodBeat.i(299238);
    PsU = new SettingsDelAuthUI.a((byte)0);
    AppMethodBeat.o(299238);
  }
  
  private static final void a(SettingsDelAuthUI paramSettingsDelAuthUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(299227);
    kotlin.g.b.s.u(paramSettingsDelAuthUI, "this$0");
    Object localObject;
    if (paramMenuItem.getItemId() == 1)
    {
      paramMenuItem = paramSettingsDelAuthUI.PsW;
      if (paramMenuItem != null)
      {
        localObject = c.Pos;
        c.a(206, paramMenuItem);
      }
      paramMenuItem = paramSettingsDelAuthUI.Psj;
      if (paramMenuItem != null) {
        paramMenuItem.dismiss();
      }
      paramSettingsDelAuthUI.Psj = com.tencent.mm.ui.base.k.a((Context)paramSettingsDelAuthUI.getContext(), paramSettingsDelAuthUI.getContext().getString(b.i.settings_auth_del_auth_loading), false, null);
      paramMenuItem = paramSettingsDelAuthUI.PsW;
      if (paramMenuItem != null) {
        break label166;
      }
      paramMenuItem = null;
      paramMenuItem = (CharSequence)paramMenuItem;
      if ((paramMenuItem != null) && (paramMenuItem.length() != 0)) {
        break label174;
      }
      paramInt = 1;
      label111:
      if (paramInt == 0)
      {
        paramMenuItem = com.tencent.mm.ui.component.k.aeZF;
        paramMenuItem = paramSettingsDelAuthUI.getContext();
        kotlin.g.b.s.s(paramMenuItem, "context");
        localObject = (e)com.tencent.mm.ui.component.k.d(paramMenuItem).q(e.class);
        paramSettingsDelAuthUI = paramSettingsDelAuthUI.PsW;
        if (paramSettingsDelAuthUI != null) {
          break label179;
        }
        paramSettingsDelAuthUI = "";
      }
    }
    for (;;)
    {
      ((e)localObject).aVD(paramSettingsDelAuthUI);
      AppMethodBeat.o(299227);
      return;
      label166:
      paramMenuItem = paramMenuItem.appid;
      break;
      label174:
      paramInt = 0;
      break label111;
      label179:
      paramMenuItem = paramSettingsDelAuthUI.appid;
      paramSettingsDelAuthUI = paramMenuItem;
      if (paramMenuItem == null) {
        paramSettingsDelAuthUI = "";
      }
    }
  }
  
  private static final void a(SettingsDelAuthUI paramSettingsDelAuthUI, View paramView)
  {
    AppMethodBeat.i(299211);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsDelAuthUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsDelAuthUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramSettingsDelAuthUI, "this$0");
    paramView = paramSettingsDelAuthUI.PsW;
    if (paramView != null)
    {
      localObject = c.Pos;
      c.a(205, paramView);
    }
    paramSettingsDelAuthUI.gVI();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsDelAuthUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299211);
  }
  
  private static final void a(SettingsDelAuthUI paramSettingsDelAuthUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(299217);
    kotlin.g.b.s.u(paramSettingsDelAuthUI, "this$0");
    params.a(1, paramSettingsDelAuthUI.getResources().getColor(b.c.red_text_color), (CharSequence)paramSettingsDelAuthUI.getResources().getString(b.i.settings_auth_del_auth));
    AppMethodBeat.o(299217);
  }
  
  private static final boolean a(SettingsDelAuthUI paramSettingsDelAuthUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(299204);
    kotlin.g.b.s.u(paramSettingsDelAuthUI, "this$0");
    paramSettingsDelAuthUI.finish();
    AppMethodBeat.o(299204);
    return true;
  }
  
  private final void gVI()
  {
    AppMethodBeat.i(299199);
    f localf = new f((Context)getContext(), 1, true);
    Object localObject = am.aixg;
    String str2 = getResources().getString(b.i.settings_auth_del_auth_confirm_title);
    kotlin.g.b.s.s(str2, "resources.getString(R.st…h_del_auth_confirm_title)");
    localObject = this.PsW;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localObject = String.format(str2, Arrays.copyOf(new Object[] { localObject }, 1));
      kotlin.g.b.s.s(localObject, "java.lang.String.format(format, *args)");
      localf.h((CharSequence)localObject, 17, com.tencent.mm.cd.a.fromDPToPix((Context)this, 14));
      localf.Vtg = new SettingsDelAuthUI..ExternalSyntheticLambda2(this);
      localf.GAC = new SettingsDelAuthUI..ExternalSyntheticLambda3(this);
      localf.dDn();
      AppMethodBeat.o(299199);
      return;
      String str1 = ((fun)localObject).nSt;
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.g.settings_del_auth;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(299276);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setBackBtn(new SettingsDelAuthUI..ExternalSyntheticLambda0(this));
    paramBundle = (Context)this;
    Object localObject1 = (RecyclerView)findViewById(b.f.settings_auth_item_auth_recyclerview);
    kotlin.g.b.s.s(localObject1, "settings_auth_item_auth_recyclerview");
    this.PsV = new SettingsDelAuthUI.b(paramBundle, (RecyclerView)localObject1);
    paramBundle = (RecyclerView)findViewById(b.f.settings_auth_item_auth_recyclerview);
    paramBundle.setAdapter((RecyclerView.a)this.PsV);
    paramBundle.getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.setItemAnimator(null);
    localObject1 = new androidx.recyclerview.widget.h(paramBundle.getContext(), 1);
    ((androidx.recyclerview.widget.h)localObject1).w(paramBundle.getResources().getDrawable(b.e.grey_divider));
    Object localObject2 = ah.aiuX;
    paramBundle.a((RecyclerView.h)localObject1);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = getContext();
    kotlin.g.b.s.s(paramBundle, "context");
    ((e)com.tencent.mm.ui.component.k.d(paramBundle).q(e.class)).PrX = ((e.b)new c(this));
    ((Button)findViewById(b.f.settings_auth_del_btn)).setOnClickListener(new SettingsDelAuthUI..ExternalSyntheticLambda1(this));
    aw.a((Paint)((TextView)findViewById(b.f.settings_auth_desc)).getPaint(), 0.8F);
    aw.a((Paint)((Button)findViewById(b.f.settings_auth_del_btn)).getPaint(), 0.8F);
    localObject1 = getIntent().getByteArrayExtra("key_user_auth_app");
    if (localObject1 != null)
    {
      paramBundle = new fun();
      paramBundle.parseFrom((byte[])localObject1);
      localObject1 = ah.aiuX;
      this.PsW = paramBundle;
    }
    localObject1 = new StringBuilder("initUserAuthAppInfo appId: ");
    paramBundle = this.PsW;
    if (paramBundle == null)
    {
      paramBundle = null;
      localObject1 = ((StringBuilder)localObject1).append(paramBundle).append(", appName: ");
      paramBundle = this.PsW;
      if (paramBundle != null) {
        break label963;
      }
      paramBundle = null;
      label359:
      localObject1 = ((StringBuilder)localObject1).append(paramBundle).append(", appType: ");
      paramBundle = this.PsW;
      if (paramBundle != null) {
        break label971;
      }
      paramBundle = null;
      label384:
      Log.i("MicroMsg.SettingsDelAuthUI", paramBundle);
      localObject2 = (MMNeat7extView)findViewById(b.f.settings_auth_app_name);
      paramBundle = this.PsW;
      if (paramBundle != null) {
        break label982;
      }
      paramBundle = "";
      label423:
      ((MMNeat7extView)localObject2).aZ((CharSequence)paramBundle);
      localObject1 = (TextView)findViewById(b.f.settings_auth_app_type);
      paramBundle = this.PsW;
      if (paramBundle != null) {
        break label1002;
      }
      paramBundle = (CharSequence)"";
      label459:
      ((TextView)localObject1).setText(paramBundle);
      i = com.tencent.mm.cd.a.ms((Context)getContext()) - getContext().getResources().getDimensionPixelSize(b.d.Edge_4A) * 2 - getContext().getResources().getDimensionPixelSize(b.d.Edge_3A) - getContext().getResources().getDimensionPixelSize(b.d.Edge_A) - getContext().getResources().getDimensionPixelSize(b.d.Edge_0_5_A);
      int k = i / 2;
      Log.i("MicroMsg.SettingsDelAuthUI", "computeViewWidth appName: %s, appType: %s, content: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(k), Integer.valueOf(i) });
      paramBundle = (MMNeat7extView)findViewById(b.f.settings_auth_app_name);
      kotlin.g.b.s.s(paramBundle, "settings_auth_app_name");
      localObject1 = (TextView)findViewById(b.f.settings_auth_app_type);
      kotlin.g.b.s.s(localObject1, "settings_auth_app_type");
      r.a(paramBundle, (TextView)localObject1, i, k, k, false);
      paramBundle = (MMRoundCornerImageView)findViewById(b.f.settings_auth_app_icon);
      localObject1 = this.PsW;
      if (localObject1 != null) {
        break label1028;
      }
      i = 0;
      label649:
      if ((i & 0x1) == 0) {
        break label1037;
      }
      i = 1;
      label657:
      if (i == 0) {
        break label1042;
      }
      paramBundle.setRadius(paramBundle.getResources().getDimensionPixelSize(b.d.SmallestPadding));
      label675:
      localObject1 = com.tencent.mm.modelappbrand.a.b.bEY();
      localObject2 = (ImageView)paramBundle;
      paramBundle = this.PsW;
      if (paramBundle != null) {
        break label1059;
      }
      paramBundle = null;
      label697:
      ((com.tencent.mm.modelappbrand.a.b)localObject1).a((ImageView)localObject2, paramBundle, b.c.UN_BG_0, null);
      paramBundle = this.PsW;
      if (paramBundle != null) {
        break label1067;
      }
      paramBundle = null;
      label721:
      paramBundle = (CharSequence)paramBundle;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label1075;
      }
      i = 1;
      label741:
      if (i != 0) {
        break label1088;
      }
      localObject1 = (TextView)findViewById(b.f.settings_auth_desc);
      paramBundle = this.PsW;
      if (paramBundle != null) {
        break label1080;
      }
      paramBundle = null;
      label768:
      ((TextView)localObject1).setText((CharSequence)paramBundle);
      label777:
      paramBundle = this.PsW;
      if (paramBundle != null) {
        break label1117;
      }
      paramBundle = null;
      label788:
      localObject1 = paramBundle;
      if (paramBundle == null) {
        localObject1 = new ArrayList();
      }
      paramBundle = this.PsV;
      if (paramBundle != null)
      {
        localObject1 = (List)localObject1;
        kotlin.g.b.s.u(localObject1, "authItems");
        localObject2 = q.ko((List)localObject1);
        paramBundle.Psm.clear();
        paramBundle.Psm.addAll((Collection)localObject2);
        Log.i("MicroMsg.SettingsDelAuthUI", "setAuthScopeList final size: " + paramBundle.Psm.size() + ", originSize: " + ((List)localObject1).size());
        localObject1 = paramBundle.mkw;
        if (((Collection)paramBundle.Psm).isEmpty()) {
          break label1125;
        }
        i = 1;
        label929:
        if (i == 0) {
          break label1130;
        }
      }
    }
    label963:
    label971:
    label982:
    label1002:
    label1130:
    for (int i = j;; i = 8)
    {
      ((RecyclerView)localObject1).setVisibility(i);
      paramBundle.bZE.notifyChanged();
      AppMethodBeat.o(299276);
      return;
      paramBundle = paramBundle.appid;
      break;
      paramBundle = paramBundle.nSt;
      break label359;
      paramBundle = Integer.valueOf(paramBundle.apptype);
      break label384;
      localObject1 = paramBundle.nSt;
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null) {
        break label423;
      }
      paramBundle = "";
      break label423;
      paramBundle = paramBundle.abSK;
      if (paramBundle == null)
      {
        paramBundle = (CharSequence)"";
        break label459;
      }
      paramBundle = (CharSequence)paramBundle;
      break label459;
      i = ((fun)localObject1).apptype;
      break label649;
      i = 0;
      break label657;
      paramBundle.setRadius(paramBundle.getResources().getDimensionPixelSize(b.d.Edge_1_5_A));
      break label675;
      paramBundle = paramBundle.abaT;
      break label697;
      paramBundle = paramBundle.abSM;
      break label721;
      i = 0;
      break label741;
      paramBundle = paramBundle.abSM;
      break label768;
      ((TextView)findViewById(b.f.settings_auth_desc)).setText((CharSequence)getResources().getString(b.i.settings_auth_del_auth_title));
      break label777;
      paramBundle = paramBundle.abSJ;
      break label788;
      i = 0;
      break label929;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(299287);
    super.onDestroy();
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    ((e)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject).q(e.class)).PrX = null;
    AppMethodBeat.o(299287);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(299281);
    super.onResume();
    setActionbarColor(getResources().getColor(b.c.BG_2));
    AppMethodBeat.o(299281);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(299268);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(e.class);
    AppMethodBeat.o(299268);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/SettingsDelAuthUI$onCreate$3", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDelAuthUIC$DelAuthCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements e.b
  {
    c(SettingsDelAuthUI paramSettingsDelAuthUI) {}
    
    private static final void b(SettingsDelAuthUI paramSettingsDelAuthUI)
    {
      AppMethodBeat.i(298930);
      kotlin.g.b.s.u(paramSettingsDelAuthUI, "this$0");
      paramSettingsDelAuthUI.setResult(-1);
      paramSettingsDelAuthUI.finish();
      AppMethodBeat.o(298930);
    }
    
    public final void gVE()
    {
      AppMethodBeat.i(298956);
      w localw = SettingsDelAuthUI.a(this.PsZ);
      if (localw != null) {
        localw.dismiss();
      }
      aa.dc((Context)this.PsZ.getContext(), this.PsZ.getResources().getString(b.i.settings_auth_del_auth_failed));
      AppMethodBeat.o(298956);
    }
    
    public final void onSuccess()
    {
      AppMethodBeat.i(298947);
      w localw = SettingsDelAuthUI.a(this.PsZ);
      if (localw != null) {
        localw.dismiss();
      }
      aa.db((Context)this.PsZ.getContext(), this.PsZ.getResources().getString(b.i.settings_auth_del_auth_success));
      com.tencent.threadpool.h.ahAA.o(new SettingsDelAuthUI.c..ExternalSyntheticLambda0(this.PsZ), 300L);
      AppMethodBeat.o(298947);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsDelAuthUI
 * JD-Core Version:    0.7.0.1
 */